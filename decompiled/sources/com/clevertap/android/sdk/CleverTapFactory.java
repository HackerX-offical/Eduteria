package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.cryption.CTKeyGenerator;
import com.clevertap.android.sdk.cryption.CryptFactory;
import com.clevertap.android.sdk.cryption.CryptHandler;
import com.clevertap.android.sdk.cryption.CryptMigrator;
import com.clevertap.android.sdk.cryption.CryptRepository;
import com.clevertap.android.sdk.cryption.DataMigrationRepository;
import com.clevertap.android.sdk.cryption.EncryptionLevel;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.db.DBEncryptionHandler;
import com.clevertap.android.sdk.db.DBManager;
import com.clevertap.android.sdk.db.DelayedLegacyInAppDAO;
import com.clevertap.android.sdk.events.EventMediator;
import com.clevertap.android.sdk.events.EventQueueManager;
import com.clevertap.android.sdk.featureFlags.CTFeatureFlagsFactory;
import com.clevertap.android.sdk.inapp.ImpressionManager;
import com.clevertap.android.sdk.inapp.InAppActionHandler;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.inapp.InAppNotificationInflater;
import com.clevertap.android.sdk.inapp.InAppPreviewHandler;
import com.clevertap.android.sdk.inapp.StoreRegistryInAppQueue;
import com.clevertap.android.sdk.inapp.TriggerManager;
import com.clevertap.android.sdk.inapp.customtemplates.TemplatesManager;
import com.clevertap.android.sdk.inapp.customtemplates.system.SystemTemplates;
import com.clevertap.android.sdk.inapp.delay.InAppDelayManager;
import com.clevertap.android.sdk.inapp.evaluation.EvaluationManager;
import com.clevertap.android.sdk.inapp.evaluation.LimitsMatcher;
import com.clevertap.android.sdk.inapp.evaluation.TriggersMatcher;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoFactory;
import com.clevertap.android.sdk.inapp.store.db.DelayedLegacyInAppStore;
import com.clevertap.android.sdk.inapp.store.preference.ImpressionStore;
import com.clevertap.android.sdk.inapp.store.preference.InAppStore;
import com.clevertap.android.sdk.inapp.store.preference.StoreRegistry;
import com.clevertap.android.sdk.login.LoginController;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.network.AppLaunchListener;
import com.clevertap.android.sdk.network.ArpRepo;
import com.clevertap.android.sdk.network.CompositeBatchListener;
import com.clevertap.android.sdk.network.ContentFetchManager;
import com.clevertap.android.sdk.network.FetchInAppListener;
import com.clevertap.android.sdk.network.IJRepo;
import com.clevertap.android.sdk.network.NetworkEncryptionManager;
import com.clevertap.android.sdk.network.NetworkManager;
import com.clevertap.android.sdk.network.NetworkRepo;
import com.clevertap.android.sdk.network.QueueHeaderBuilder;
import com.clevertap.android.sdk.network.api.CtApiWrapper;
import com.clevertap.android.sdk.pushnotification.PushProviders;
import com.clevertap.android.sdk.pushnotification.work.CTWorkManager;
import com.clevertap.android.sdk.response.ARPResponse;
import com.clevertap.android.sdk.response.CleverTapResponse;
import com.clevertap.android.sdk.response.ClevertapResponseHandler;
import com.clevertap.android.sdk.response.ConsoleResponse;
import com.clevertap.android.sdk.response.ContentFetchResponse;
import com.clevertap.android.sdk.response.DisplayUnitResponse;
import com.clevertap.android.sdk.response.FeatureFlagResponse;
import com.clevertap.android.sdk.response.FetchVariablesResponse;
import com.clevertap.android.sdk.response.GeofenceResponse;
import com.clevertap.android.sdk.response.InAppResponse;
import com.clevertap.android.sdk.response.InboxResponse;
import com.clevertap.android.sdk.response.MetadataResponse;
import com.clevertap.android.sdk.response.ProductConfigResponse;
import com.clevertap.android.sdk.response.PushAmpResponse;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.CTExecutors;
import com.clevertap.android.sdk.task.MainLooperHandler;
import com.clevertap.android.sdk.utils.Clock;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import com.clevertap.android.sdk.validation.Validator;
import com.clevertap.android.sdk.variables.CTVariables;
import com.clevertap.android.sdk.variables.Parser;
import com.clevertap.android.sdk.variables.VarCache;
import com.clevertap.android.sdk.variables.repo.VariablesRepo;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CleverTapFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J>\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¨\u0006\u0017"}, d2 = {"Lcom/clevertap/android/sdk/CleverTapFactory;", "", "<init>", "()V", "getCoreState", "Lcom/clevertap/android/sdk/CoreState;", "context", "Landroid/content/Context;", "cleverTapInstanceConfig", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "cleverTapID", "", "initFeatureFlags", "", "controllerManager", "Lcom/clevertap/android/sdk/ControllerManager;", "config", "deviceInfo", "Lcom/clevertap/android/sdk/DeviceInfo;", "callbackManager", "Lcom/clevertap/android/sdk/BaseCallbackManager;", "analyticsManager", "Lcom/clevertap/android/sdk/AnalyticsManager;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CleverTapFactory {
    public static final CleverTapFactory INSTANCE = new CleverTapFactory();

    private CleverTapFactory() {
    }

    @JvmStatic
    public static final CoreState getCoreState(final Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String cleverTapID) {
        if (context == null || cleverTapInstanceConfig == null) {
            throw new RuntimeException("This is invalid case and will not happen. Context/Config is null");
        }
        final StoreProvider companion = StoreProvider.INSTANCE.getInstance();
        final String accountId = cleverTapInstanceConfig.getAccountId();
        Intrinsics.checkNotNull(accountId);
        final StoreRegistry storeRegistry = new StoreRegistry(null, null, companion.provideLegacyInAppStore(context, accountId), companion.provideInAppAssetsStore(context, accountId), companion.provideFileStore(context, accountId));
        CoreMetaData coreMetaData = new CoreMetaData();
        Validator validator = new Validator();
        ValidationResultStack validationResultStack = new ValidationResultStack();
        CTLockManager cTLockManager = new CTLockManager();
        MainLooperHandler mainLooperHandler = new MainLooperHandler();
        final CleverTapInstanceConfig cleverTapInstanceConfig2 = new CleverTapInstanceConfig(cleverTapInstanceConfig);
        NetworkRepo networkRepo = new NetworkRepo(context, cleverTapInstanceConfig2, null, null, 12, null);
        IJRepo iJRepo = new IJRepo(cleverTapInstanceConfig2);
        final CTExecutors cTExecutorsExecutors = CTExecutorFactory.executors(cleverTapInstanceConfig2);
        Logger logger = cleverTapInstanceConfig2.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        final InAppDelayManager inAppDelayManager = new InAppDelayManager(accountId, logger, null, null, null, null, 60, null);
        cTExecutorsExecutors.ioTask().execute("initFileResourceProvider", new Callable() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CleverTapFactory.getCoreState$lambda$0(context, cleverTapInstanceConfig2);
            }
        });
        String accountId2 = cleverTapInstanceConfig2.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId2, "getAccountId(...)");
        final CryptRepository cryptRepository = new CryptRepository(context, accountId2);
        CTKeyGenerator cTKeyGenerator = new CTKeyGenerator(cryptRepository);
        String accountId3 = cleverTapInstanceConfig2.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId3, "getAccountId(...)");
        CryptFactory cryptFactory = new CryptFactory(accountId3, cTKeyGenerator);
        final CryptHandler cryptHandler = new CryptHandler(cryptRepository, cryptFactory);
        CryptHandler cryptHandler2 = cryptHandler;
        Logger logger2 = cleverTapInstanceConfig2.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger2, "getLogger(...)");
        DBEncryptionHandler dBEncryptionHandler = new DBEncryptionHandler(cryptHandler2, logger2, EncryptionLevel.INSTANCE.fromInt(cleverTapInstanceConfig2.getEncryptionLevel()));
        String accountId4 = cleverTapInstanceConfig2.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId4, "getAccountId(...)");
        final VariablesRepo variablesRepo = new VariablesRepo(context, accountId4, dBEncryptionHandler);
        String databaseName = DBAdapter.INSTANCE.getDatabaseName(cleverTapInstanceConfig2);
        String accountId5 = cleverTapInstanceConfig2.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId5, "getAccountId(...)");
        Logger logger3 = cleverTapInstanceConfig2.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger3, "getLogger(...)");
        final DBManager dBManager = new DBManager(accountId5, logger3, databaseName, cTLockManager, iJRepo, dBEncryptionHandler, new CleverTapFactory$getCoreState$databaseManager$1(networkRepo), new CleverTapFactory$getCoreState$databaseManager$2(networkRepo));
        cTExecutorsExecutors.postAsyncSafelyTask().execute("migratingEncryption", new Callable() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CleverTapFactory.getCoreState$lambda$1(dBManager, context, cleverTapInstanceConfig2, cryptHandler, cryptRepository, variablesRepo);
            }
        });
        cTExecutorsExecutors.postAsyncSafelyTask().execute("loadInAppsDao", new Callable() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CleverTapFactory.getCoreState$lambda$2(inAppDelayManager, dBManager, context, cryptHandler, cleverTapInstanceConfig2, accountId);
            }
        });
        final DeviceInfo deviceInfo = new DeviceInfo(context, cleverTapInstanceConfig2, cleverTapID, coreMetaData);
        deviceInfo.onInitDeviceInfo(cleverTapID);
        DBManager dBManager2 = dBManager;
        LocalDataStore localDataStore = new LocalDataStore(context, cleverTapInstanceConfig2, cryptHandler2, deviceInfo, dBManager2);
        ProfileValueHandler profileValueHandler = new ProfileValueHandler(validator, validationResultStack);
        EventMediator eventMediator = new EventMediator(cleverTapInstanceConfig2, coreMetaData, localDataStore, profileValueHandler, networkRepo);
        CTPreferenceCache.INSTANCE.getInstance(context, cleverTapInstanceConfig2);
        final CallbackManager callbackManager = new CallbackManager(cleverTapInstanceConfig2, deviceInfo);
        SessionManager sessionManager = new SessionManager(cleverTapInstanceConfig2, coreMetaData, validator, localDataStore);
        final ControllerManager controllerManager = new ControllerManager(context, cleverTapInstanceConfig2, cTLockManager, callbackManager, deviceInfo, dBManager2);
        TriggersMatcher triggersMatcher = new TriggersMatcher(localDataStore);
        String accountId6 = cleverTapInstanceConfig2.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId6, "getAccountId(...)");
        TriggerManager triggerManager = new TriggerManager(context, accountId6, deviceInfo);
        final ImpressionManager impressionManager = new ImpressionManager(storeRegistry, null, null, 6, null);
        LimitsMatcher limitsMatcher = new LimitsMatcher(impressionManager, triggerManager);
        InAppActionHandler inAppActionHandler = new InAppActionHandler(context, cleverTapInstanceConfig2, new PushPermissionHandler(cleverTapInstanceConfig2, callbackManager.getPushPermissionResponseListenerList(), null, null, null, 28, null), null, 8, null);
        TemplatesManager templatesManagerCreateInstance = TemplatesManager.INSTANCE.createInstance(cleverTapInstanceConfig2, SystemTemplates.INSTANCE.getSystemTemplates(inAppActionHandler));
        final EvaluationManager evaluationManager = new EvaluationManager(triggersMatcher, triggerManager, limitsMatcher, storeRegistry, templatesManagerCreateInstance);
        cTExecutorsExecutors.ioTask().execute("initStores", new Callable() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CleverTapFactory.getCoreState$lambda$3(deviceInfo, storeRegistry, companion, context, cryptHandler, cleverTapInstanceConfig2, evaluationManager, callbackManager);
            }
        });
        cTExecutorsExecutors.ioTask().execute("initFCManager", new Callable() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CleverTapFactory.getCoreState$lambda$4(deviceInfo, controllerManager, cleverTapInstanceConfig2, context, storeRegistry, impressionManager, cTExecutorsExecutors);
            }
        });
        FileResourcesRepoFactory.Companion companion2 = FileResourcesRepoFactory.INSTANCE;
        Logger logger4 = cleverTapInstanceConfig2.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger4, "getLogger(...)");
        VarCache varCache = new VarCache(cleverTapInstanceConfig2, context, companion2.createFileResourcesRepo(context, logger4, storeRegistry), variablesRepo);
        final CTVariables cTVariables = new CTVariables(varCache);
        controllerManager.setCtVariables(cTVariables);
        Parser parser = new Parser(cTVariables);
        cTExecutorsExecutors.ioTask().execute("initCTVariables", new Callable() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CleverTapFactory.getCoreState$lambda$5(cTVariables);
            }
        });
        InAppResponse inAppResponse = new InAppResponse(cleverTapInstanceConfig2, controllerManager, false, storeRegistry, triggerManager, templatesManagerCreateInstance, coreMetaData);
        CtApiWrapper ctApiWrapper = new CtApiWrapper(networkRepo, cleverTapInstanceConfig2, deviceInfo);
        NetworkEncryptionManager networkEncryptionManager = new NetworkEncryptionManager(cTKeyGenerator, cryptFactory.getAesGcmCrypt());
        String accountId7 = cleverTapInstanceConfig2.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId7, "getAccountId(...)");
        Logger logger5 = cleverTapInstanceConfig2.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger5, "getLogger(...)");
        ArpRepo arpRepo = new ArpRepo(accountId7, logger5, deviceInfo);
        CleverTapFactory$getCoreState$queueHeaderBuilder$1 cleverTapFactory$getCoreState$queueHeaderBuilder$1 = new CleverTapFactory$getCoreState$queueHeaderBuilder$1(networkRepo);
        CleverTapFactory$getCoreState$queueHeaderBuilder$2 cleverTapFactory$getCoreState$queueHeaderBuilder$2 = new CleverTapFactory$getCoreState$queueHeaderBuilder$2(networkRepo);
        Logger logger6 = cleverTapInstanceConfig2.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger6, "getLogger(...)");
        QueueHeaderBuilder queueHeaderBuilder = new QueueHeaderBuilder(context, cleverTapInstanceConfig2, coreMetaData, controllerManager, deviceInfo, arpRepo, iJRepo, dBManager2, validationResultStack, cleverTapFactory$getCoreState$queueHeaderBuilder$1, cleverTapFactory$getCoreState$queueHeaderBuilder$2, logger6);
        ARPResponse aRPResponse = new ARPResponse(cleverTapInstanceConfig2, validator, controllerManager, arpRepo);
        ContentFetchManager contentFetchManager = new ContentFetchManager(cleverTapInstanceConfig2, coreMetaData, queueHeaderBuilder, ctApiWrapper, 0, null, null, 112, null);
        ClevertapResponseHandler clevertapResponseHandler = new ClevertapResponseHandler(context, CollectionsKt.listOf((Object[]) new CleverTapResponse[]{inAppResponse, new MetadataResponse(cleverTapInstanceConfig2, deviceInfo, iJRepo), aRPResponse, new ConsoleResponse(cleverTapInstanceConfig2), new InboxResponse(cleverTapInstanceConfig2, cTLockManager, callbackManager, controllerManager), new PushAmpResponse(context, cleverTapInstanceConfig2, dBManager2, callbackManager, controllerManager), new FetchVariablesResponse(cleverTapInstanceConfig2, controllerManager, callbackManager), new DisplayUnitResponse(cleverTapInstanceConfig2, callbackManager, controllerManager), new FeatureFlagResponse(cleverTapInstanceConfig2, controllerManager), new ProductConfigResponse(cleverTapInstanceConfig2, coreMetaData, controllerManager), new GeofenceResponse(cleverTapInstanceConfig2, callbackManager), new ContentFetchResponse(cleverTapInstanceConfig2, contentFetchManager)}));
        contentFetchManager.setClevertapResponseHandler(clevertapResponseHandler);
        NetworkManager networkManager = new NetworkManager(context, cleverTapInstanceConfig2, deviceInfo, coreMetaData, controllerManager, dBManager2, callbackManager, ctApiWrapper, networkEncryptionManager, aRPResponse, networkRepo, queueHeaderBuilder, clevertapResponseHandler, null, 8192, null);
        LoginInfoProvider loginInfoProvider = new LoginInfoProvider(context, cleverTapInstanceConfig2, cryptHandler2);
        EventQueueManager eventQueueManager = new EventQueueManager(dBManager2, context, cleverTapInstanceConfig2, eventMediator, sessionManager, callbackManager, mainLooperHandler, deviceInfo, validationResultStack, networkManager, coreMetaData, cTLockManager, localDataStore, controllerManager, loginInfoProvider);
        InAppResponse inAppResponse2 = new InAppResponse(cleverTapInstanceConfig2, controllerManager, true, storeRegistry, triggerManager, templatesManagerCreateInstance, coreMetaData);
        Logger logger7 = cleverTapInstanceConfig2.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger7, "getLogger(...)");
        EventQueueManager eventQueueManager2 = eventQueueManager;
        final AnalyticsManager analyticsManager = new AnalyticsManager(context, cleverTapInstanceConfig2, eventQueueManager2, validator, validationResultStack, coreMetaData, deviceInfo, callbackManager, controllerManager, cTLockManager, Clock.SYSTEM, cTExecutorsExecutors, new InAppPreviewHandler(cTExecutorsExecutors, networkManager, inAppResponse2, context, logger7));
        InAppNotificationInflater inAppNotificationInflater = new InAppNotificationInflater(storeRegistry, templatesManagerCreateInstance, cTExecutorsExecutors, new Function0() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CleverTapFactory.getCoreState$lambda$6(context, cleverTapInstanceConfig2);
            }
        }, false, 16, null);
        networkManager.addNetworkHeadersListener(evaluationManager);
        ManifestInfo manifestInfo = ManifestInfo.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(manifestInfo, "getInstance(...)");
        String accountId8 = cleverTapInstanceConfig2.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId8, "getAccountId(...)");
        InAppController inAppController = new InAppController(context, cleverTapInstanceConfig2, cTExecutorsExecutors, controllerManager, callbackManager, analyticsManager, coreMetaData, manifestInfo, deviceInfo, new StoreRegistryInAppQueue(storeRegistry, accountId8), evaluationManager, templatesManagerCreateInstance, inAppActionHandler, inAppNotificationInflater, inAppDelayManager, Clock.SYSTEM);
        controllerManager.setInAppController(inAppController);
        CompositeBatchListener compositeBatchListener = new CompositeBatchListener();
        AppLaunchListener appLaunchListener = new AppLaunchListener();
        appLaunchListener.addListener(inAppController.getOnAppLaunchEventSent());
        compositeBatchListener.addListener(appLaunchListener);
        compositeBatchListener.addListener(new FetchInAppListener(callbackManager));
        callbackManager.setBatchListener(compositeBatchListener);
        cTExecutorsExecutors.ioTask().execute("initFeatureFlags", new Callable() { // from class: com.clevertap.android.sdk.CleverTapFactory$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return CleverTapFactory.getCoreState$lambda$7(context, controllerManager, cleverTapInstanceConfig2, deviceInfo, callbackManager, analyticsManager);
            }
        });
        LocationManager locationManager = new LocationManager(context, cleverTapInstanceConfig2, coreMetaData, eventQueueManager2);
        PushProviders pushProvidersLoad = PushProviders.load(context, cleverTapInstanceConfig2, dBManager2, validationResultStack, analyticsManager, controllerManager, new CTWorkManager(context, cleverTapInstanceConfig2), Clock.SYSTEM);
        Intrinsics.checkNotNullExpressionValue(pushProvidersLoad, "load(...)");
        return new CoreState(locationManager, cleverTapInstanceConfig2, coreMetaData, dBManager2, deviceInfo, eventMediator, localDataStore, new ActivityLifeCycleManager(context, cleverTapInstanceConfig2, analyticsManager, coreMetaData, sessionManager, pushProvidersLoad, callbackManager, inAppController, eventQueueManager2, cTExecutorsExecutors, Clock.SYSTEM), analyticsManager, eventQueueManager2, cTLockManager, callbackManager, controllerManager, inAppController, evaluationManager, impressionManager, new LoginController(context, cleverTapInstanceConfig2, deviceInfo, validationResultStack, eventQueueManager2, analyticsManager, coreMetaData, controllerManager, sessionManager, localDataStore, callbackManager, dBManager, cTLockManager, loginInfoProvider, contentFetchManager), sessionManager, validationResultStack, mainLooperHandler, networkManager, pushProvidersLoad, varCache, parser, cryptHandler2, storeRegistry, templatesManagerCreateInstance, profileValueHandler, cTVariables, cTExecutorsExecutors);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCoreState$lambda$0(Context context, CleverTapInstanceConfig config) {
        Intrinsics.checkNotNullParameter(config, "$config");
        FileResourceProvider.INSTANCE.getInstance(context, config.getLogger());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCoreState$lambda$1(DBManager databaseManager, Context context, CleverTapInstanceConfig config, CryptHandler cryptHandler, CryptRepository repository, VariablesRepo variablesRepo) {
        Intrinsics.checkNotNullParameter(databaseManager, "$databaseManager");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(cryptHandler, "$cryptHandler");
        Intrinsics.checkNotNullParameter(repository, "$repository");
        Intrinsics.checkNotNullParameter(variablesRepo, "$variablesRepo");
        DBAdapter dBAdapterLoadDBAdapter = databaseManager.loadDBAdapter(context);
        DataMigrationRepository dataMigrationRepository = new DataMigrationRepository(context, config, dBAdapterLoadDBAdapter);
        String accountId = config.getAccountId();
        Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
        int encryptionLevel = config.getEncryptionLevel();
        Logger logger = config.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        new CryptMigrator(accountId, encryptionLevel, logger, cryptHandler, repository, dataMigrationRepository, variablesRepo, dBAdapterLoadDBAdapter).migrateEncryption();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCoreState$lambda$2(InAppDelayManager inAppDelayManager, DBManager databaseManager, Context context, CryptHandler cryptHandler, CleverTapInstanceConfig config, String str) {
        Intrinsics.checkNotNullParameter(inAppDelayManager, "$inAppDelayManager");
        Intrinsics.checkNotNullParameter(databaseManager, "$databaseManager");
        Intrinsics.checkNotNullParameter(cryptHandler, "$cryptHandler");
        Intrinsics.checkNotNullParameter(config, "$config");
        DelayedLegacyInAppDAO delayedLegacyInAppDAO = databaseManager.loadDBAdapter(context).delayedLegacyInAppDAO();
        Logger logger = config.getLogger();
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        Intrinsics.checkNotNull(str);
        inAppDelayManager.setDelayedLegacyInAppStore$clevertap_core_release(new DelayedLegacyInAppStore(delayedLegacyInAppDAO, cryptHandler, logger, str));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCoreState$lambda$3(DeviceInfo deviceInfo, StoreRegistry storeRegistry, StoreProvider storeProvider, Context context, CryptHandler cryptHandler, CleverTapInstanceConfig config, EvaluationManager evaluationManager, BaseCallbackManager callbackManager) {
        Intrinsics.checkNotNullParameter(deviceInfo, "$deviceInfo");
        Intrinsics.checkNotNullParameter(storeRegistry, "$storeRegistry");
        Intrinsics.checkNotNullParameter(storeProvider, "$storeProvider");
        Intrinsics.checkNotNullParameter(cryptHandler, "$cryptHandler");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(evaluationManager, "$evaluationManager");
        Intrinsics.checkNotNullParameter(callbackManager, "$callbackManager");
        if (deviceInfo.getDeviceID() != null) {
            if (storeRegistry.getInAppStore() == null) {
                String deviceID = deviceInfo.getDeviceID();
                Intrinsics.checkNotNullExpressionValue(deviceID, "getDeviceID(...)");
                String accountId = config.getAccountId();
                Intrinsics.checkNotNullExpressionValue(accountId, "getAccountId(...)");
                InAppStore inAppStoreProvideInAppStore = storeProvider.provideInAppStore(context, cryptHandler, deviceID, accountId);
                storeRegistry.setInAppStore(inAppStoreProvideInAppStore);
                evaluationManager.loadSuppressedCSAndEvaluatedSSInAppsIds();
                callbackManager.addChangeUserCallback(inAppStoreProvideInAppStore);
            }
            if (storeRegistry.getImpressionStore() == null) {
                String deviceID2 = deviceInfo.getDeviceID();
                Intrinsics.checkNotNullExpressionValue(deviceID2, "getDeviceID(...)");
                String accountId2 = config.getAccountId();
                Intrinsics.checkNotNullExpressionValue(accountId2, "getAccountId(...)");
                ImpressionStore impressionStoreProvideImpressionStore = storeProvider.provideImpressionStore(context, deviceID2, accountId2);
                storeRegistry.setImpressionStore(impressionStoreProvideImpressionStore);
                callbackManager.addChangeUserCallback(impressionStoreProvideImpressionStore);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCoreState$lambda$4(DeviceInfo deviceInfo, ControllerManager controllerManager, CleverTapInstanceConfig config, Context context, StoreRegistry storeRegistry, ImpressionManager impressionManager, CTExecutors executors) {
        Intrinsics.checkNotNullParameter(deviceInfo, "$deviceInfo");
        Intrinsics.checkNotNullParameter(controllerManager, "$controllerManager");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(storeRegistry, "$storeRegistry");
        Intrinsics.checkNotNullParameter(impressionManager, "$impressionManager");
        Intrinsics.checkNotNullParameter(executors, "$executors");
        String deviceID = deviceInfo.getDeviceID();
        if (deviceID != null && controllerManager.getInAppFCManager() == null) {
            config.getLogger().verbose(config.getAccountId() + ":async_deviceID", "Initializing InAppFC with device Id = " + deviceID);
            controllerManager.setInAppFCManager(new InAppFCManager(context, config, deviceID, storeRegistry, impressionManager, executors, Clock.SYSTEM));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCoreState$lambda$5(CTVariables ctVariables) {
        Intrinsics.checkNotNullParameter(ctVariables, "$ctVariables");
        ctVariables.init();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileResourceProvider getCoreState$lambda$6(Context context, CleverTapInstanceConfig config) {
        Intrinsics.checkNotNullParameter(config, "$config");
        return FileResourceProvider.INSTANCE.getInstance(context, config.getLogger());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCoreState$lambda$7(Context context, ControllerManager controllerManager, CleverTapInstanceConfig config, DeviceInfo deviceInfo, BaseCallbackManager callbackManager, AnalyticsManager analyticsManager) {
        Intrinsics.checkNotNullParameter(controllerManager, "$controllerManager");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(deviceInfo, "$deviceInfo");
        Intrinsics.checkNotNullParameter(callbackManager, "$callbackManager");
        Intrinsics.checkNotNullParameter(analyticsManager, "$analyticsManager");
        INSTANCE.initFeatureFlags(context, controllerManager, config, deviceInfo, callbackManager, analyticsManager);
        return Unit.INSTANCE;
    }

    private final void initFeatureFlags(Context context, ControllerManager controllerManager, CleverTapInstanceConfig config, DeviceInfo deviceInfo, BaseCallbackManager callbackManager, AnalyticsManager analyticsManager) {
        config.getLogger().verbose(config.getAccountId() + ":async_deviceID", "Initializing Feature Flags with device Id = " + deviceInfo.getDeviceID());
        if (config.isAnalyticsOnly()) {
            config.getLogger().debug(config.getAccountId(), "Feature Flag is not enabled for this instance");
        } else {
            controllerManager.setCTFeatureFlagsController(CTFeatureFlagsFactory.getInstance(context, deviceInfo.getDeviceID(), config, callbackManager, analyticsManager));
            config.getLogger().verbose(config.getAccountId() + ":async_deviceID", "Feature Flags initialized");
        }
    }
}
