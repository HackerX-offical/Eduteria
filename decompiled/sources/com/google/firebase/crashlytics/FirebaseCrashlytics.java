package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.MissingNativeComponent;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.crashlytics.internal.unity.ResourceUnityVersionProvider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class FirebaseCrashlytics {
    private static final int APP_EXCEPTION_CALLBACK_TIMEOUT_MS = 500;
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    private static final String FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN = "clx";
    private static final String LEGACY_CRASH_ANALYTICS_ORIGIN = "crash";
    private final CrashlyticsCore core;

    static FirebaseCrashlytics init(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsConnector analyticsConnector) {
        BreadcrumbSource disabledBreadcrumbSource;
        AnalyticsEventLogger unavailableAnalyticsEventLogger;
        Logger.getLogger().i("Initializing Firebase Crashlytics " + CrashlyticsCore.getVersion());
        Context applicationContext = firebaseApp.getApplicationContext();
        IdManager idManager = new IdManager(applicationContext, applicationContext.getPackageName(), firebaseInstallationsApi);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        if (crashlyticsNativeComponent == null) {
            crashlyticsNativeComponent = new MissingNativeComponent();
        }
        CrashlyticsNativeComponent crashlyticsNativeComponent2 = crashlyticsNativeComponent;
        if (analyticsConnector != null) {
            CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(analyticsConnector);
            CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
            if (subscribeToAnalyticsEvents(analyticsConnector, crashlyticsAnalyticsListener) != null) {
                Logger.getLogger().d("Registered Firebase Analytics listener.");
                BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
                crashlyticsAnalyticsListener.setBreadcrumbEventReceiver(breadcrumbAnalyticsEventReceiver);
                crashlyticsAnalyticsListener.setCrashlyticsOriginEventReceiver(blockingAnalyticsEventLogger);
                unavailableAnalyticsEventLogger = blockingAnalyticsEventLogger;
                disabledBreadcrumbSource = breadcrumbAnalyticsEventReceiver;
            } else {
                Logger.getLogger().w("Could not register Firebase Analytics listener; a listener is already registered.");
                unavailableAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
                disabledBreadcrumbSource = new DisabledBreadcrumbSource();
            }
        } else {
            Logger.getLogger().d("Firebase Analytics is not available.");
            DisabledBreadcrumbSource disabledBreadcrumbSource2 = new DisabledBreadcrumbSource();
            unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
            disabledBreadcrumbSource = disabledBreadcrumbSource2;
        }
        final CrashlyticsCore crashlyticsCore = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponent2, dataCollectionArbiter, disabledBreadcrumbSource, unavailableAnalyticsEventLogger, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
        String applicationId = firebaseApp.getOptions().getApplicationId();
        String mappingFileId = CommonUtils.getMappingFileId(applicationContext);
        Logger.getLogger().d("Mapping file ID is: " + mappingFileId);
        try {
            AppData appDataCreate = AppData.create(applicationContext, idManager, applicationId, mappingFileId, new ResourceUnityVersionProvider(applicationContext));
            Logger.getLogger().v("Installer package name is: " + appDataCreate.installerPackageName);
            ExecutorService executorServiceBuildSingleThreadExecutorService = ExecutorUtils.buildSingleThreadExecutorService("com.google.firebase.crashlytics.startup");
            final SettingsController settingsControllerCreate = SettingsController.create(applicationContext, applicationId, idManager, new HttpRequestFactory(), appDataCreate.versionCode, appDataCreate.versionName, dataCollectionArbiter);
            settingsControllerCreate.loadSettingsData(executorServiceBuildSingleThreadExecutorService).continueWith(executorServiceBuildSingleThreadExecutorService, new Continuation<Void, Object>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.1
                @Override // com.google.android.gms.tasks.Continuation
                public Object then(Task<Void> task) throws Exception {
                    if (task.isSuccessful()) {
                        return null;
                    }
                    Logger.getLogger().e("Error fetching settings.", task.getException());
                    return null;
                }
            });
            final boolean zOnPreExecute = crashlyticsCore.onPreExecute(appDataCreate, settingsControllerCreate);
            Tasks.call(executorServiceBuildSingleThreadExecutorService, new Callable<Void>() { // from class: com.google.firebase.crashlytics.FirebaseCrashlytics.2
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    if (!zOnPreExecute) {
                        return null;
                    }
                    crashlyticsCore.doBackgroundInitializationAsync(settingsControllerCreate);
                    return null;
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore);
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.getLogger().e("Error retrieving app package info.", e2);
            return null;
        }
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(AnalyticsConnector analyticsConnector, CrashlyticsAnalyticsListener crashlyticsAnalyticsListener) {
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = analyticsConnector.registerAnalyticsConnectorListener(FIREBASE_CRASHLYTICS_ANALYTICS_ORIGIN, crashlyticsAnalyticsListener);
        if (analyticsConnectorHandleRegisterAnalyticsConnectorListener != null) {
            return analyticsConnectorHandleRegisterAnalyticsConnectorListener;
        }
        Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener2 = analyticsConnector.registerAnalyticsConnectorListener("crash", crashlyticsAnalyticsListener);
        if (analyticsConnectorHandleRegisterAnalyticsConnectorListener2 != null) {
            Logger.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
        }
        return analyticsConnectorHandleRegisterAnalyticsConnectorListener2;
    }

    private FirebaseCrashlytics(CrashlyticsCore crashlyticsCore) {
        this.core = crashlyticsCore;
    }

    public static FirebaseCrashlytics getInstance() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.getInstance().get(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    public void recordException(Throwable th) {
        if (th == null) {
            Logger.getLogger().w("A null value was passed to recordException. Ignoring.");
        } else {
            this.core.logException(th);
        }
    }

    public void log(String str) {
        this.core.log(str);
    }

    public void setUserId(String str) {
        this.core.setUserId(str);
    }

    public void setCustomKey(String str, boolean z) {
        this.core.setCustomKey(str, Boolean.toString(z));
    }

    public void setCustomKey(String str, double d2) {
        this.core.setCustomKey(str, Double.toString(d2));
    }

    public void setCustomKey(String str, float f2) {
        this.core.setCustomKey(str, Float.toString(f2));
    }

    public void setCustomKey(String str, int i) {
        this.core.setCustomKey(str, Integer.toString(i));
    }

    public void setCustomKey(String str, long j) {
        this.core.setCustomKey(str, Long.toString(j));
    }

    public void setCustomKey(String str, String str2) {
        this.core.setCustomKey(str, str2);
    }

    public void setCustomKeys(CustomKeysAndValues customKeysAndValues) {
        this.core.setCustomKeys(customKeysAndValues.keysAndValues);
    }

    public Task<Boolean> checkForUnsentReports() {
        return this.core.checkForUnsentReports();
    }

    public void sendUnsentReports() {
        this.core.sendUnsentReports();
    }

    public void deleteUnsentReports() {
        this.core.deleteUnsentReports();
    }

    public boolean didCrashOnPreviousExecution() {
        return this.core.didCrashOnPreviousExecution();
    }

    public void setCrashlyticsCollectionEnabled(boolean z) {
        this.core.setCrashlyticsCollectionEnabled(Boolean.valueOf(z));
    }

    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.core.setCrashlyticsCollectionEnabled(bool);
    }
}
