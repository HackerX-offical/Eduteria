package com.clevertap.android.sdk.pushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.clevertap.android.sdk.AnalyticsManager;
import com.clevertap.android.sdk.CTXtensions;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.ControllerManager;
import com.clevertap.android.sdk.CoreMetaData;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.StorageHelper;
import com.clevertap.android.sdk.db.BaseDatabaseManager;
import com.clevertap.android.sdk.db.DBAdapter;
import com.clevertap.android.sdk.interfaces.AudibleNotification;
import com.clevertap.android.sdk.pushnotification.amp.CTPushAmpWorker;
import com.clevertap.android.sdk.pushnotification.work.CTWorkManager;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.utils.Clock;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultFactory;
import com.clevertap.android.sdk.validation.ValidationResultStack;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.jivesoftware.smackx.iot.discovery.element.IoTUnregister;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class PushProviders implements CTPushProviderListener {
    private static final int DEFAULT_FLEX_INTERVAL = 5;
    private static final String PF_JOB_ID = "pfjobid";
    private static final String PF_WORK_ID = "pfworkid";
    private static final String PING_FREQUENCY = "pf";
    private static final int PING_FREQUENCY_VALUE = 240;
    private static final String TAG = "PushProviders";
    private static final String inputFormat = "HH:mm";
    private final AnalyticsManager analyticsManager;
    private final BaseDatabaseManager baseDatabaseManager;
    private final Clock clock;
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final CTWorkManager ctWorkManager;
    private CleverTapAPI.DevicePushTokenRefreshListener tokenRefreshListener;
    private final ValidationResultStack validationResultStack;
    private final ArrayList<PushType> allEnabledPushTypes = new ArrayList<>();
    private final ArrayList<CTPushProvider> availableCTPushProviders = new ArrayList<>();
    private final ArrayList<PushType> nonEnabledPushTypes = new ArrayList<>();
    private INotificationRenderer iNotificationRenderer = new CoreNotificationRenderer();
    private final Object tokenLock = new Object();
    private final Object pushRenderingLock = new Object();

    public static PushProviders load(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, BaseDatabaseManager baseDatabaseManager, ValidationResultStack validationResultStack, AnalyticsManager analyticsManager, ControllerManager controllerManager, CTWorkManager cTWorkManager, Clock clock) {
        PushProviders pushProviders = new PushProviders(context, cleverTapInstanceConfig, baseDatabaseManager, validationResultStack, analyticsManager, cTWorkManager, clock);
        pushProviders.init();
        controllerManager.setPushProviders(pushProviders);
        return pushProviders;
    }

    private PushProviders(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, BaseDatabaseManager baseDatabaseManager, ValidationResultStack validationResultStack, AnalyticsManager analyticsManager, CTWorkManager cTWorkManager, Clock clock) {
        this.context = context;
        this.config = cleverTapInstanceConfig;
        this.clock = clock;
        this.baseDatabaseManager = baseDatabaseManager;
        this.validationResultStack = validationResultStack;
        this.analyticsManager = analyticsManager;
        this.ctWorkManager = cTWorkManager;
        initPushAmp();
    }

    public void _createNotification(Context context, Bundle bundle, int i) {
        if (bundle == null || bundle.get("wzrk_pn") == null) {
            return;
        }
        if (this.config.isAnalyticsOnly()) {
            this.config.getLogger().debug(this.config.getAccountId(), "Instance is set for Analytics only, cannot create notification");
            return;
        }
        try {
            if (bundle.getString(Constants.WZRK_PUSH_SILENT, "").equalsIgnoreCase("true")) {
                this.analyticsManager.pushNotificationViewedEvent(bundle);
                return;
            }
            String string = bundle.getString(Constants.EXTRAS_FROM);
            if (string == null || !string.equals("PTReceiver")) {
                this.config.getLogger().debug(this.config.getAccountId(), "Handling notification: " + bundle);
                if (bundle.getString(Constants.WZRK_PUSH_ID) != null && this.baseDatabaseManager.loadDBAdapter(context).doesPushNotificationIdExist(bundle.getString(Constants.WZRK_PUSH_ID))) {
                    this.config.getLogger().debug(this.config.getAccountId(), "Push Notification already rendered, not showing again");
                    return;
                }
                String message = this.iNotificationRenderer.getMessage(bundle);
                if (message == null) {
                    message = "";
                }
                if (message.isEmpty()) {
                    this.config.getLogger().verbose(this.config.getAccountId(), "Push notification message is empty, not rendering");
                    this.baseDatabaseManager.loadDBAdapter(context).storeUninstallTimestamp();
                    String string2 = bundle.getString(PING_FREQUENCY, "");
                    if (TextUtils.isEmpty(string2)) {
                        return;
                    }
                    updatePingFrequencyIfNeeded(context, Integer.parseInt(string2));
                    return;
                }
            }
            if (this.iNotificationRenderer.getTitle(bundle, context).isEmpty()) {
                String str = context.getApplicationInfo().name;
            }
            triggerNotification(context, bundle, i);
        } catch (Throwable th) {
            this.config.getLogger().debug(this.config.getAccountId(), "Couldn't render notification: ", th);
        }
    }

    public void cacheToken(final String str, final PushType pushType) {
        if (TextUtils.isEmpty(str) || pushType == null) {
            return;
        }
        try {
            CTExecutorFactory.executors(this.config).ioTask().execute("PushProviders#cacheToken", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.1
                @Override // java.util.concurrent.Callable
                public Void call() {
                    if (PushProviders.this.alreadyHaveToken(str, pushType)) {
                        return null;
                    }
                    String tokenPrefKey = pushType.getTokenPrefKey();
                    if (TextUtils.isEmpty(tokenPrefKey)) {
                        return null;
                    }
                    StorageHelper.putStringImmediate(PushProviders.this.context, PushProviders.this.config.getAccountId(), tokenPrefKey, str);
                    PushProviders.this.config.log(PushConstants.LOG_TAG, pushType + "Cached New Token successfully " + str);
                    return null;
                }
            });
        } catch (Throwable th) {
            this.config.log(PushConstants.LOG_TAG, pushType + "Unable to cache token " + str, th);
        }
    }

    public void doTokenRefresh(String str, PushType pushType) {
        if (TextUtils.isEmpty(str) || pushType == null) {
            return;
        }
        handleToken(str, pushType, true);
    }

    public void forcePushDeviceToken(boolean z) {
        Iterator<PushType> it = this.allEnabledPushTypes.iterator();
        while (it.hasNext()) {
            pushDeviceTokenEvent(null, z, it.next());
        }
    }

    public ArrayList<PushType> getAvailablePushTypes() {
        ArrayList<PushType> arrayList = new ArrayList<>();
        Iterator<CTPushProvider> it = this.availableCTPushProviders.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPushType());
        }
        return arrayList;
    }

    public String getCachedToken(PushType pushType) {
        if (pushType != null) {
            String tokenPrefKey = pushType.getTokenPrefKey();
            if (!TextUtils.isEmpty(tokenPrefKey)) {
                String stringFromPrefs = StorageHelper.getStringFromPrefs(this.context, this.config.getAccountId(), tokenPrefKey, null);
                this.config.log(PushConstants.LOG_TAG, pushType + "getting Cached Token - " + stringFromPrefs);
                return stringFromPrefs;
            }
        }
        if (pushType != null) {
            this.config.log(PushConstants.LOG_TAG, pushType + " Unable to find cached Token for type ");
        }
        return null;
    }

    public CleverTapAPI.DevicePushTokenRefreshListener getDevicePushTokenRefreshListener() {
        return this.tokenRefreshListener;
    }

    public void setDevicePushTokenRefreshListener(CleverTapAPI.DevicePushTokenRefreshListener devicePushTokenRefreshListener) {
        this.tokenRefreshListener = devicePushTokenRefreshListener;
    }

    public void handleToken(String str, PushType pushType, boolean z) {
        if (z) {
            registerToken(str, pushType);
        } else {
            unregisterToken(str, pushType);
        }
    }

    public boolean isNotificationSupported() {
        Iterator<PushType> it = getAvailablePushTypes().iterator();
        while (it.hasNext()) {
            if (getCachedToken(it.next()) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.clevertap.android.sdk.pushnotification.CTPushProviderListener
    public void onNewToken(String str, PushType pushType) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        doTokenRefresh(str, pushType);
        deviceTokenDidRefresh(str, pushType);
    }

    public void onTokenRefresh() {
        refreshAllTokens();
    }

    public void processCustomPushNotification(final Bundle bundle) {
        CTExecutorFactory.executors(this.config).postAsyncSafelyTask().execute("customHandlePushAmplification", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.2
            @Override // java.util.concurrent.Callable
            public Void call() {
                String string = bundle.getString(Constants.NOTIF_MSG);
                if (string == null) {
                    string = "";
                }
                if (string.isEmpty()) {
                    PushProviders.this.config.getLogger().verbose(PushProviders.this.config.getAccountId(), "Push notification message is empty, not rendering");
                    PushProviders.this.baseDatabaseManager.loadDBAdapter(PushProviders.this.context).storeUninstallTimestamp();
                    String string2 = bundle.getString(PushProviders.PING_FREQUENCY, "");
                    if (TextUtils.isEmpty(string2)) {
                        return null;
                    }
                    PushProviders pushProviders = PushProviders.this;
                    pushProviders.updatePingFrequencyIfNeeded(pushProviders.context, Integer.parseInt(string2));
                    return null;
                }
                String string3 = bundle.getString(Constants.WZRK_PUSH_ID);
                String string4 = bundle.getString("wzrk_ttl");
                long jCurrentTimeSeconds = PushProviders.this.clock.currentTimeSeconds() + Constants.DEFAULT_PUSH_TTL_SECONDS;
                if (string4 != null) {
                    jCurrentTimeSeconds = Long.parseLong(string4);
                }
                if (string3 != null) {
                    PushProviders.this.config.getLogger().verbose("Storing Push Notification..." + string3 + " - with ttl - " + string4);
                    PushProviders.this.baseDatabaseManager.loadDBAdapter(PushProviders.this.context).storePushNotificationId(string3, jCurrentTimeSeconds);
                    return null;
                }
                PushProviders.this.config.getLogger().verbose("Will not save Push Notification in DB due to invalid id, processCustomPushNotification");
                return null;
            }
        });
    }

    public void unregisterToken(String str, PushType pushType) {
        pushDeviceTokenEvent(str, false, pushType);
    }

    public void updatePingFrequencyIfNeeded(Context context, int i) {
        this.config.getLogger().verbose("Ping frequency received - " + i);
        this.config.getLogger().verbose("Stored Ping Frequency - " + getPingFrequency(context));
        if (i != getPingFrequency(context)) {
            setPingFrequency(context, i);
            if (!this.config.isBackgroundSync() || this.config.isAnalyticsOnly()) {
                return;
            }
            CTExecutorFactory.executors(this.config).postAsyncSafelyTask(TAG).execute("createOrResetWorker", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.3
                @Override // java.util.concurrent.Callable
                public Void call() {
                    PushProviders.this.createOrResetWorker(true);
                    return null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alreadyHaveToken(String str, PushType pushType) {
        boolean z = (TextUtils.isEmpty(str) || pushType == null || !str.equalsIgnoreCase(getCachedToken(pushType))) ? false : true;
        if (pushType != null) {
            this.config.log(PushConstants.LOG_TAG, pushType + "Token Already available value: " + z);
        }
        return z;
    }

    public void runPushAmpWork(Context context) {
        Logger.v(this.config.getAccountId(), "Pushamp - Running work request");
        if (!isNotificationSupported()) {
            Logger.v(this.config.getAccountId(), "Pushamp - Token is not present, not running the work request");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(11);
        int i2 = calendar.get(12);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputFormat, Locale.US);
        if (isTimeBetweenDNDTime(parseTimeToDate(Constants.DND_START, simpleDateFormat), parseTimeToDate(Constants.DND_STOP, simpleDateFormat), parseTimeToDate(i + ":" + i2, simpleDateFormat))) {
            Logger.v(this.config.getAccountId(), "Pushamp won't run in default DND hours");
            return;
        }
        long lastUninstallTimestamp = this.baseDatabaseManager.loadDBAdapter(context).getLastUninstallTimestamp();
        if (lastUninstallTimestamp == 0 || lastUninstallTimestamp > this.clock.currentTimeMillis() - 86400000) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bk", 1);
                this.analyticsManager.sendPingEvent(jSONObject);
                Logger.v(this.config.getAccountId(), "Pushamp - Successfully completed work request");
            } catch (JSONException unused) {
                Logger.v("Pushamp - Unable to complete work request");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopJobScheduler(Context context) {
        int i = StorageHelper.getInt(context, PF_JOB_ID, -1);
        if (i != -1) {
            ((JobScheduler) context.getSystemService("jobscheduler")).cancel(i);
            StorageHelper.remove(context, PF_JOB_ID);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createOrResetWorker(boolean z) {
        String string = StorageHelper.getString(this.context, PF_WORK_ID, "");
        int pingFrequency = getPingFrequency(this.context);
        if (string.equals("") && pingFrequency <= 0) {
            this.config.getLogger().debug(this.config.getAccountId(), "Pushamp - There is no running work and nothing to create");
            return;
        }
        if (pingFrequency <= 0) {
            this.config.getLogger().debug(this.config.getAccountId(), "Pushamp - Cancelling worker as pingFrequency <=0 ");
            stopWorker();
            return;
        }
        try {
            WorkManager workManager = WorkManager.getInstance(this.context);
            if (!string.equals("") && !z) {
                return;
            }
            PeriodicWorkRequest periodicWorkRequestBuild = new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) CTPushAmpWorker.class, pingFrequency, TimeUnit.MINUTES, 5L, TimeUnit.MINUTES).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setRequiresCharging(false).setRequiresBatteryNotLow(true).build()).build();
            if (string.equals("")) {
                string = this.config.getAccountId();
            }
            workManager.enqueueUniquePeriodicWork(string, ExistingPeriodicWorkPolicy.UPDATE, periodicWorkRequestBuild);
            StorageHelper.putString(this.context, PF_WORK_ID, string);
            this.config.getLogger().debug(this.config.getAccountId(), "Pushamp - Finished scheduling periodic work request - " + string + " with repeatInterval- " + pingFrequency + " minutes");
        } catch (Exception e2) {
            this.config.getLogger().debug(this.config.getAccountId(), "Pushamp - Failed scheduling/cancelling periodic work request" + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopWorker() {
        String string = StorageHelper.getString(this.context, PF_WORK_ID, "");
        if (string.equals("")) {
            return;
        }
        try {
            WorkManager.getInstance(this.context).cancelUniqueWork(string);
            StorageHelper.putString(this.context, PF_WORK_ID, "");
            this.config.getLogger().debug(this.config.getAccountId(), "Pushamp - Successfully cancelled work");
        } catch (Exception unused) {
            this.config.getLogger().debug(this.config.getAccountId(), "Pushamp - Failure while cancelling work");
        }
    }

    private List<CTPushProvider> createProviders() {
        ArrayList arrayList = new ArrayList();
        Iterator<PushType> it = this.allEnabledPushTypes.iterator();
        while (it.hasNext()) {
            CTPushProvider cTPushProviderFromPushType = getCTPushProviderFromPushType(it.next());
            if (cTPushProviderFromPushType != null) {
                arrayList.add(cTPushProviderFromPushType);
            }
        }
        return arrayList;
    }

    private CTPushProvider getCTPushProviderFromPushType(PushType pushType) {
        String ctProviderClassName = pushType.getCtProviderClassName();
        CTPushProvider cTPushProvider = null;
        try {
            CTPushProvider cTPushProvider2 = (CTPushProvider) Class.forName(ctProviderClassName).getConstructor(CTPushProviderListener.class, Context.class, CleverTapInstanceConfig.class).newInstance(this, this.context, this.config);
            try {
                this.config.log(PushConstants.LOG_TAG, "Found provider:" + ctProviderClassName);
                return cTPushProvider2;
            } catch (ClassNotFoundException unused) {
                cTPushProvider = cTPushProvider2;
                this.config.log(PushConstants.LOG_TAG, "Unable to create provider ClassNotFoundException" + ctProviderClassName);
                return cTPushProvider;
            } catch (IllegalAccessException unused2) {
                cTPushProvider = cTPushProvider2;
                this.config.log(PushConstants.LOG_TAG, "Unable to create provider IllegalAccessException" + ctProviderClassName);
                return cTPushProvider;
            } catch (InstantiationException unused3) {
                cTPushProvider = cTPushProvider2;
                this.config.log(PushConstants.LOG_TAG, "Unable to create provider InstantiationException" + ctProviderClassName);
                return cTPushProvider;
            } catch (Exception e2) {
                e = e2;
                cTPushProvider = cTPushProvider2;
                this.config.log(PushConstants.LOG_TAG, "Unable to create provider " + ctProviderClassName + " Exception:" + e.getClass().getName());
                return cTPushProvider;
            }
        } catch (ClassNotFoundException unused4) {
        } catch (IllegalAccessException unused5) {
        } catch (InstantiationException unused6) {
        } catch (Exception e3) {
            e = e3;
        }
    }

    private void deviceTokenDidRefresh(String str, PushType pushType) {
        if (this.tokenRefreshListener != null) {
            this.config.getLogger().debug(this.config.getAccountId(), "Notifying devicePushTokenDidRefresh: " + str);
            this.tokenRefreshListener.devicePushTokenDidRefresh(str, pushType);
        }
    }

    private void findAvailableCTPushProviders() {
        List<CTPushProvider> listCreateProviders = createProviders();
        if (listCreateProviders.isEmpty()) {
            this.config.log(PushConstants.LOG_TAG, "No push providers found!. Make sure to install at least one push provider");
            return;
        }
        for (CTPushProvider cTPushProvider : listCreateProviders) {
            if (!isValid(cTPushProvider)) {
                this.config.log(PushConstants.LOG_TAG, "Invalid Provider: " + cTPushProvider.getClass());
            } else if (!cTPushProvider.isSupported()) {
                this.config.log(PushConstants.LOG_TAG, "Unsupported Provider: " + cTPushProvider.getClass());
            } else if (cTPushProvider.isAvailable()) {
                this.config.log(PushConstants.LOG_TAG, "Available Provider: " + cTPushProvider.getClass());
                this.availableCTPushProviders.add(cTPushProvider);
            } else {
                this.config.log(PushConstants.LOG_TAG, "Unavailable Provider: " + cTPushProvider.getClass());
            }
        }
    }

    private void findNonEnabledPushTypes() {
        this.nonEnabledPushTypes.addAll(this.allEnabledPushTypes);
        Iterator<CTPushProvider> it = this.availableCTPushProviders.iterator();
        while (it.hasNext()) {
            this.nonEnabledPushTypes.remove(it.next().getPushType());
        }
    }

    private void configurePushTypes() {
        for (PushType pushType : this.config.getPushTypes()) {
            String messagingSDKClassName = pushType.getMessagingSDKClassName();
            try {
                Class.forName(messagingSDKClassName);
                this.allEnabledPushTypes.add(pushType);
                this.config.log(PushConstants.LOG_TAG, "SDK Class Available :" + messagingSDKClassName);
            } catch (Exception e2) {
                this.config.log(PushConstants.LOG_TAG, "SDK class Not available " + messagingSDKClassName + " Exception:" + e2.getClass().getName());
            }
        }
    }

    public void addPushService(PushType pushType) {
        this.allEnabledPushTypes.add(pushType);
    }

    private int getPingFrequency(Context context) {
        return StorageHelper.getInt(context, PING_FREQUENCY, 240);
    }

    private void init() {
        configurePushTypes();
        CTExecutorFactory.executors(this.config).postAsyncSafelyTask(TAG).execute("asyncFindAvailableCTPushProviders", new Callable() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m11934xe61576f9();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$init$0$com-clevertap-android-sdk-pushnotification-PushProviders, reason: not valid java name */
    /* synthetic */ Void m11934xe61576f9() throws Exception {
        findAvailableCTPushProviders();
        findNonEnabledPushTypes();
        return null;
    }

    private void initPushAmp() {
        CTExecutorFactory.executors(this.config).postAsyncSafelyTask(TAG).execute("createOrResetWorker", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.4
            @Override // java.util.concurrent.Callable
            public Void call() {
                PushProviders pushProviders = PushProviders.this;
                pushProviders.stopJobScheduler(pushProviders.context);
                if (!PushProviders.this.config.isBackgroundSync() || PushProviders.this.config.isAnalyticsOnly()) {
                    PushProviders.this.config.getLogger().debug(PushProviders.this.config.getAccountId(), "Pushamp - Cancelling worker as background sync is disabled or config is analytics only");
                    PushProviders.this.stopWorker();
                    return null;
                }
                PushProviders.this.createOrResetWorker(false);
                return null;
            }
        });
    }

    private boolean isTimeBetweenDNDTime(Date date, Date date2, Date date3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date3);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date2);
        if (date2.compareTo(date) < 0) {
            if (calendar2.compareTo(calendar3) < 0) {
                calendar2.add(5, 1);
            }
            calendar3.add(5, 1);
        }
        return calendar2.compareTo(calendar) >= 0 && calendar2.compareTo(calendar3) < 0;
    }

    private boolean isValid(CTPushProvider cTPushProvider) {
        if (70700 >= cTPushProvider.minSDKSupportVersionCode()) {
            return true;
        }
        this.config.log(PushConstants.LOG_TAG, "Provider: %s version %s does not match the SDK version %s. Make sure all CleverTap dependencies are the same version.");
        return false;
    }

    private Date parseTimeToDate(String str, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            return new Date(0L);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void pushDeviceTokenEvent(String str, boolean z, PushType pushType) {
        if (pushType == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = getCachedToken(pushType);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.tokenLock) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str2 = z ? "register" : IoTUnregister.ELEMENT;
            try {
                jSONObject2.put("action", str2);
                jSONObject2.put("id", str);
                jSONObject2.put("type", pushType.getType());
                jSONObject.put("data", jSONObject2);
                this.config.getLogger().verbose(this.config.getAccountId(), pushType + str2 + " device token " + str);
                this.analyticsManager.sendDataEvent(jSONObject);
            } catch (Throwable th) {
                this.config.getLogger().verbose(this.config.getAccountId(), pushType + str2 + " device token failed", th);
            }
        }
    }

    private void refreshAllTokens() {
        CTExecutorFactory.executors(this.config).postAsyncSafelyTask(TAG).execute("PushProviders#refreshAllTokens", new Callable<Void>() { // from class: com.clevertap.android.sdk.pushnotification.PushProviders.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                PushProviders.this.refreshAvailableCTProviderTokens();
                PushProviders.this.refreshNonEnabledProviderTokens();
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshAvailableCTProviderTokens() {
        for (CTPushProvider cTPushProvider : this.availableCTPushProviders) {
            try {
                cTPushProvider.requestToken();
            } catch (Throwable th) {
                this.config.log(PushConstants.LOG_TAG, "Token Refresh error " + cTPushProvider, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshNonEnabledProviderTokens() {
        for (PushType pushType : this.nonEnabledPushTypes) {
            try {
                pushDeviceTokenEvent(getCachedToken(pushType), true, pushType);
            } catch (Throwable th) {
                this.config.log(PushConstants.LOG_TAG, "Token Refresh error " + pushType, th);
            }
        }
    }

    private void registerToken(String str, PushType pushType) {
        pushDeviceTokenEvent(str, true, pushType);
        cacheToken(str, pushType);
    }

    private void setPingFrequency(Context context, int i) {
        StorageHelper.putInt(context, PING_FREQUENCY, i);
    }

    public INotificationRenderer getPushNotificationRenderer() {
        return this.iNotificationRenderer;
    }

    public Object getPushRenderingLock() {
        return this.pushRenderingLock;
    }

    public void setPushNotificationRenderer(INotificationRenderer iNotificationRenderer) {
        this.iNotificationRenderer = iNotificationRenderer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v41 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.core.app.NotificationCompat$Builder] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.clevertap.android.sdk.pushnotification.INotificationRenderer] */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r4v16, types: [androidx.core.app.NotificationCompat$Builder] */
    /* JADX WARN: Type inference failed for: r4v27, types: [com.clevertap.android.sdk.interfaces.AudibleNotification] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void triggerNotification(Context context, Bundle bundle, int i) {
        String string;
        int i2;
        char c2;
        int appIconAsIntId;
        ?? Equals;
        String notificationIcon;
        int iHashCode = i;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            this.config.getLogger().debug(this.config.getAccountId(), "Unable to render notification, Notification Manager is null.");
            return;
        }
        String string2 = bundle.getString(Constants.WZRK_CHANNEL_ID, "");
        if (string2.isEmpty()) {
            string = bundle.toString();
            i2 = 8;
        } else if (notificationManager.getNotificationChannel(string2) == null) {
            i2 = 9;
            string = string2;
        } else {
            string = "";
            i2 = -1;
        }
        if (i2 != -1) {
            ValidationResult validationResultCreate = ValidationResultFactory.create(512, i2, string);
            c2 = 0;
            this.config.getLogger().debug(this.config.getAccountId(), validationResultCreate.getErrorDesc());
            this.validationResultStack.pushValidationResult(validationResultCreate);
        } else {
            c2 = 0;
        }
        String orCreateChannel = CTXtensions.getOrCreateChannel(notificationManager, string2, context, (CoreMetaData.isAppForeground() && "true".equalsIgnoreCase(bundle.getString(Constants.WZRK_SILENCE_IN_FOREGROUND))) ? 1 : c2);
        if (orCreateChannel == null || orCreateChannel.trim().isEmpty()) {
            this.config.getLogger().debug(this.config.getAccountId(), "Not rendering Push since channel id is null or blank.");
            return;
        }
        if (!CTXtensions.isNotificationChannelEnabled(context, orCreateChannel)) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Not rendering push notification as channel = " + orCreateChannel + " is blocked by user");
            return;
        }
        this.config.getLogger().debug(this.config.getAccountId(), "Rendering Push on channel = " + orCreateChannel);
        try {
            notificationIcon = ManifestInfo.getInstance(context).getNotificationIcon();
        } catch (Throwable unused) {
            appIconAsIntId = DeviceInfo.getAppIconAsIntId(context);
        }
        if (notificationIcon == null) {
            throw new IllegalArgumentException();
        }
        appIconAsIntId = context.getResources().getIdentifier(notificationIcon, "drawable", context.getPackageName());
        if (appIconAsIntId == 0) {
            throw new IllegalArgumentException();
        }
        this.iNotificationRenderer.setSmallIcon(appIconAsIntId, context);
        String string3 = bundle.getString("pr");
        if (string3 != null) {
            Equals = string3.equals(Constants.PRIORITY_HIGH);
            if (string3.equals(Constants.PRIORITY_MAX)) {
                Equals = 2;
            }
        } else {
            Equals = c2;
        }
        if (iHashCode == -1000) {
            try {
                Object collapseKey = this.iNotificationRenderer.getCollapseKey(bundle);
                if (collapseKey != null) {
                    if (collapseKey instanceof Number) {
                        iHashCode = ((Number) collapseKey).intValue();
                    } else if (collapseKey instanceof String) {
                        try {
                            iHashCode = Integer.parseInt(collapseKey.toString());
                            this.config.getLogger().verbose(this.config.getAccountId(), "Converting collapse_key: " + collapseKey + " to notificationId int: " + iHashCode);
                        } catch (NumberFormatException unused2) {
                            iHashCode = collapseKey.toString().hashCode();
                            this.config.getLogger().verbose(this.config.getAccountId(), "Converting collapse_key: " + collapseKey + " to notificationId int: " + iHashCode);
                        }
                    }
                    iHashCode = Math.abs(iHashCode);
                    this.config.getLogger().debug(this.config.getAccountId(), "Creating the notification id: " + iHashCode + " from collapse_key: " + collapseKey);
                }
            } catch (NumberFormatException unused3) {
            }
        } else {
            this.config.getLogger().debug(this.config.getAccountId(), "Have user provided notificationId: " + iHashCode + " won't use collapse_key (if any) as basis for notificationId");
        }
        if (iHashCode == -1000) {
            iHashCode = (int) (Math.random() * 100.0d);
            this.config.getLogger().debug(this.config.getAccountId(), "Setting random notificationId: " + iHashCode);
        }
        int i3 = iHashCode;
        ?? builder = new NotificationCompat.Builder(context, orCreateChannel);
        String string4 = bundle.getString(Constants.WZRK_BADGE_ICON, null);
        if (string4 != null) {
            try {
                int i4 = Integer.parseInt(string4);
                if (i4 >= 0) {
                    builder.setBadgeIconType(i4);
                }
            } catch (Throwable unused4) {
            }
        }
        String string5 = bundle.getString(Constants.WZRK_BADGE_COUNT, null);
        if (string5 != null) {
            try {
                int i5 = Integer.parseInt(string5);
                if (i5 >= 0) {
                    builder.setNumber(i5);
                }
            } catch (Throwable unused5) {
            }
        }
        builder.setPriority(Equals);
        INotificationRenderer iNotificationRenderer = this.iNotificationRenderer;
        ?? sound = builder;
        if (iNotificationRenderer instanceof AudibleNotification) {
            sound = ((AudibleNotification) iNotificationRenderer).setSound(context, bundle, builder, this.config);
        }
        NotificationCompat.Builder builderRenderNotification = this.iNotificationRenderer.renderNotification(bundle, context, sound, this.config, i3);
        if (builderRenderNotification == null) {
            return;
        }
        Notification notificationBuild = builderRenderNotification.build();
        notificationManager.notify(i3, notificationBuild);
        this.config.getLogger().debug(this.config.getAccountId(), "Rendered notification: " + notificationBuild);
        String string6 = bundle.getString(Constants.EXTRAS_FROM);
        if (string6 == null || !string6.equals("PTReceiver")) {
            String string7 = bundle.getString("wzrk_ttl");
            long jCurrentTimeSeconds = this.clock.currentTimeSeconds() + Constants.DEFAULT_PUSH_TTL_SECONDS;
            if (string7 != null) {
                jCurrentTimeSeconds = Long.parseLong(string7);
            }
            String string8 = bundle.getString(Constants.WZRK_PUSH_ID);
            DBAdapter dBAdapterLoadDBAdapter = this.baseDatabaseManager.loadDBAdapter(context);
            if (string8 != null) {
                this.config.getLogger().verbose("Storing Push Notification..." + string8 + " - with ttl - " + string7);
                dBAdapterLoadDBAdapter.storePushNotificationId(string8, jCurrentTimeSeconds);
            } else {
                this.config.getLogger().verbose("Will not save Push Notification in DB due to invalid id");
            }
            if ("true".equals(bundle.getString(Constants.WZRK_RNV, ""))) {
                long j = bundle.getLong(Constants.OMR_INVOKE_TIME_IN_MILLIS, -1L);
                if (j >= 0) {
                    this.config.getLogger().verbose("Rendered Push Notification in " + (this.clock.currentTimeMillis() - j) + " millis");
                }
                this.ctWorkManager.init();
                this.analyticsManager.pushNotificationViewedEvent(bundle);
                return;
            }
            String[] strArr = new String[1];
            strArr[c2] = bundle.toString();
            ValidationResult validationResultCreate2 = ValidationResultFactory.create(512, 10, strArr);
            this.config.getLogger().debug(validationResultCreate2.getErrorDesc());
            this.validationResultStack.pushValidationResult(validationResultCreate2);
        }
    }
}
