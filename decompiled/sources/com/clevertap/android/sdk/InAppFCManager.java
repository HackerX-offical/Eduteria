package com.clevertap.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.inapp.CTInAppNotification;
import com.clevertap.android.sdk.inapp.ImpressionManager;
import com.clevertap.android.sdk.inapp.SharedPreferencesMigration;
import com.clevertap.android.sdk.inapp.store.preference.InAppStore;
import com.clevertap.android.sdk.inapp.store.preference.LegacyInAppStore;
import com.clevertap.android.sdk.inapp.store.preference.StoreRegistry;
import com.clevertap.android.sdk.task.CTExecutors;
import com.clevertap.android.sdk.utils.Clock;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class InAppFCManager {
    private final Clock clock;
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final SimpleDateFormat ddMMyyyy = new SimpleDateFormat("ddMMyyyy", Locale.US);
    private String deviceId;
    private final CTExecutors executors;
    private final ImpressionManager impressionManager;
    private final StoreRegistry storeRegistry;

    InAppFCManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, final String str, StoreRegistry storeRegistry, ImpressionManager impressionManager, CTExecutors cTExecutors, Clock clock) {
        this.config = cleverTapInstanceConfig;
        this.context = context;
        this.deviceId = str;
        this.storeRegistry = storeRegistry;
        this.impressionManager = impressionManager;
        this.executors = cTExecutors;
        this.clock = clock;
        cTExecutors.postAsyncSafelyTask().execute("initInAppFCManager", new Callable() { // from class: com.clevertap.android.sdk.InAppFCManager$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m11873lambda$new$0$comclevertapandroidsdkInAppFCManager(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$new$0$com-clevertap-android-sdk-InAppFCManager, reason: not valid java name */
    /* synthetic */ Void m11873lambda$new$0$comclevertapandroidsdkInAppFCManager(String str) throws Exception {
        init(str);
        return null;
    }

    public boolean canShow(CTInAppNotification cTInAppNotification, Function2<JSONObject, String, Boolean> function2) {
        if (cTInAppNotification == null) {
            return false;
        }
        try {
            String inAppID = getInAppID(cTInAppNotification);
            if (inAppID == null) {
                return true;
            }
            if (function2.invoke(cTInAppNotification.getJsonDescription(), inAppID).booleanValue()) {
                return false;
            }
            if (cTInAppNotification.getIsExcludeFromCaps()) {
                return true;
            }
            if (!hasSessionCapacityMaxedOut(cTInAppNotification) && !hasLifetimeCapacityMaxedOut(cTInAppNotification)) {
                if (!hasDailyCapacityMaxedOut(cTInAppNotification)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void changeUser(String str) {
        this.impressionManager.clearSessionData();
        this.deviceId = str;
        init(str);
    }

    public void didShow(final Context context, CTInAppNotification cTInAppNotification) {
        final String inAppID = getInAppID(cTInAppNotification);
        if (inAppID == null) {
            return;
        }
        this.executors.ioTask().execute("recordInAppImpressionsAndCounts", new Callable() { // from class: com.clevertap.android.sdk.InAppFCManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m11872lambda$didShow$1$comclevertapandroidsdkInAppFCManager(inAppID, context);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$didShow$1$com-clevertap-android-sdk-InAppFCManager, reason: not valid java name */
    /* synthetic */ Void m11872lambda$didShow$1$comclevertapandroidsdkInAppFCManager(String str, Context context) throws Exception {
        this.impressionManager.recordImpression(str);
        incrementInAppCountsInPersistentStore(str);
        StorageHelper.putInt(context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_SHOWN_TODAY, this.deviceId)), getIntFromPrefs(getKeyWithDeviceId(Constants.KEY_COUNTS_SHOWN_TODAY, this.deviceId), 0) + 1);
        return null;
    }

    public int getShownTodayCount() {
        return getIntFromPrefs(getKeyWithDeviceId(Constants.KEY_COUNTS_SHOWN_TODAY, this.deviceId), 0);
    }

    public JSONArray getInAppsCount(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, ?> entry : StorageHelper.getPreferences(context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_PER_INAPP, this.deviceId))).getAll().entrySet()) {
                if (entry.getValue() instanceof String) {
                    String[] strArrSplit = ((String) entry.getValue()).split(Constants.SEPARATOR_COMMA);
                    if (strArrSplit.length == 2) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(0, entry.getKey());
                        jSONArray2.put(1, Integer.parseInt(strArrSplit[0]));
                        jSONArray2.put(2, Integer.parseInt(strArrSplit[1]));
                        jSONArray.put(jSONArray2);
                    }
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            Logger.v("Failed to get in apps count", th);
            return null;
        }
    }

    public void processResponse(Context context, JSONObject jSONObject) {
        try {
            if (jSONObject.has(Constants.INAPP_NOTIFS_STALE_KEY)) {
                JSONArray jSONArray = jSONObject.getJSONArray(Constants.INAPP_NOTIFS_STALE_KEY);
                SharedPreferences.Editor editorEdit = StorageHelper.getPreferences(context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_PER_INAPP, this.deviceId))).edit();
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj = jSONArray.get(i);
                    if (obj instanceof Integer) {
                        editorEdit.remove("" + obj);
                        Logger.d("Purged stale in-app - " + obj);
                    } else if (obj instanceof String) {
                        editorEdit.remove((String) obj);
                        Logger.d("Purged stale in-app - " + obj);
                    }
                }
                StorageHelper.persist(editorEdit);
            }
        } catch (Throwable th) {
            Logger.v("Failed to purge out stale targets", th);
        }
    }

    public synchronized void updateLimits(Context context, int i, int i2) {
        StorageHelper.putInt(context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_MAX_PER_DAY, this.deviceId)), i);
        StorageHelper.putInt(context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.INAPP_MAX_PER_SESSION_KEY, this.deviceId)), i2);
    }

    private String getConfigAccountId() {
        return this.config.getAccountId();
    }

    private Logger getConfigLogger() {
        return this.config.getLogger();
    }

    private int[] getInAppCountsFromPersistentStore(String str) {
        String string = StorageHelper.getPreferences(this.context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_PER_INAPP, this.deviceId))).getString(str, null);
        if (string == null) {
            return new int[]{0, 0};
        }
        try {
            String[] strArrSplit = string.split(Constants.SEPARATOR_COMMA);
            if (strArrSplit.length != 2) {
                return new int[]{0, 0};
            }
            return new int[]{Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1])};
        } catch (Throwable unused) {
            return new int[]{0, 0};
        }
    }

    public String getInAppID(CTInAppNotification cTInAppNotification) {
        if (cTInAppNotification.getId() != null && !cTInAppNotification.getId().isEmpty()) {
            try {
                return cTInAppNotification.getId();
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private int getIntFromPrefs(String str, int i) {
        if (this.config.isDefaultInstance()) {
            int i2 = StorageHelper.getInt(this.context, storageKeyWithSuffix(str), -1000);
            return i2 != -1000 ? i2 : StorageHelper.getInt(this.context, str, i);
        }
        return StorageHelper.getInt(this.context, storageKeyWithSuffix(str), i);
    }

    private String getKeyWithDeviceId(String str, String str2) {
        return str + ":" + str2;
    }

    private String getStringFromPrefs(String str, String str2) {
        if (this.config.isDefaultInstance()) {
            String string = StorageHelper.getString(this.context, storageKeyWithSuffix(str), str2);
            return string != null ? string : StorageHelper.getString(this.context, str, str2);
        }
        return StorageHelper.getString(this.context, storageKeyWithSuffix(str), str2);
    }

    private boolean hasDailyCapacityMaxedOut(CTInAppNotification cTInAppNotification) {
        String inAppID = getInAppID(cTInAppNotification);
        if (inAppID == null) {
            return false;
        }
        if (getIntFromPrefs(getKeyWithDeviceId(Constants.KEY_COUNTS_SHOWN_TODAY, this.deviceId), 0) >= getIntFromPrefs(getKeyWithDeviceId(Constants.KEY_MAX_PER_DAY, this.deviceId), 1)) {
            return true;
        }
        try {
            int totalDailyCount = cTInAppNotification.getTotalDailyCount();
            if (totalDailyCount == -1) {
                return false;
            }
            return getInAppCountsFromPersistentStore(inAppID)[0] >= totalDailyCount;
        } catch (Throwable unused) {
            return true;
        }
    }

    private boolean hasLifetimeCapacityMaxedOut(CTInAppNotification cTInAppNotification) {
        String inAppID = getInAppID(cTInAppNotification);
        if (inAppID == null || cTInAppNotification.getTotalLifetimeCount() == -1) {
            return false;
        }
        try {
            return getInAppCountsFromPersistentStore(inAppID)[1] >= cTInAppNotification.getTotalLifetimeCount();
        } catch (Exception unused) {
            return true;
        }
    }

    private boolean hasSessionCapacityMaxedOut(CTInAppNotification cTInAppNotification) {
        String inAppID = getInAppID(cTInAppNotification);
        if (inAppID == null) {
            return false;
        }
        try {
            if (this.impressionManager.perSession(inAppID) >= (cTInAppNotification.getMaxPerSession() >= 0 ? cTInAppNotification.getMaxPerSession() : 1000)) {
                return true;
            }
            return this.impressionManager.getSessionImpressionsTotal() >= getIntFromPrefs(getKeyWithDeviceId(Constants.INAPP_MAX_PER_SESSION_KEY, this.deviceId), 1);
        } catch (Throwable unused) {
            return true;
        }
    }

    private void incrementInAppCountsInPersistentStore(String str) {
        int[] inAppCountsFromPersistentStore = getInAppCountsFromPersistentStore(str);
        inAppCountsFromPersistentStore[0] = inAppCountsFromPersistentStore[0] + 1;
        inAppCountsFromPersistentStore[1] = inAppCountsFromPersistentStore[1] + 1;
        SharedPreferences.Editor editorEdit = StorageHelper.getPreferences(this.context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_PER_INAPP, this.deviceId))).edit();
        editorEdit.putString(str, inAppCountsFromPersistentStore[0] + Constants.SEPARATOR_COMMA + inAppCountsFromPersistentStore[1]);
        StorageHelper.persist(editorEdit);
    }

    private void init(String str) {
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "InAppFCManager init() called");
        try {
            migrateToNewPrefsKey(str);
            String str2 = this.ddMMyyyy.format(this.clock.newDate());
            if (str2.equals(getStringFromPrefs(getKeyWithDeviceId("ict_date", str), "20140428"))) {
                return;
            }
            StorageHelper.putString(this.context, storageKeyWithSuffix(getKeyWithDeviceId("ict_date", str)), str2);
            StorageHelper.putInt(this.context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_SHOWN_TODAY, str)), 0);
            SharedPreferences preferences = StorageHelper.getPreferences(this.context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_PER_INAPP, str)));
            SharedPreferences.Editor editorEdit = preferences.edit();
            Map<String, ?> all = preferences.getAll();
            for (String str3 : all.keySet()) {
                Object obj = all.get(str3);
                if (!(obj instanceof String)) {
                    editorEdit.remove(str3);
                } else {
                    String[] strArrSplit = ((String) obj).split(Constants.SEPARATOR_COMMA);
                    if (strArrSplit.length != 2) {
                        editorEdit.remove(str3);
                    } else {
                        try {
                            editorEdit.putString(str3, "0," + strArrSplit[1]);
                        } catch (Throwable th) {
                            getConfigLogger().verbose(getConfigAccountId(), "Failed to reset todayCount for inapp " + str3, th);
                        }
                    }
                }
            }
            StorageHelper.persist(editorEdit);
        } catch (Exception e2) {
            getConfigLogger().verbose(getConfigAccountId(), "Failed to init inapp manager " + e2.getLocalizedMessage());
        }
    }

    private void migrateToNewPrefsKey(String str) {
        SharedPreferences preferences = StorageHelper.getPreferences(this.context, Constants.KEY_COUNTS_PER_INAPP);
        SharedPreferences preferences2 = StorageHelper.getPreferences(this.context, getKeyWithDeviceId(Constants.KEY_COUNTS_PER_INAPP, str));
        SharedPreferences preferences3 = StorageHelper.getPreferences(this.context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_PER_INAPP, str)));
        Function1 function1 = new Function1() { // from class: com.clevertap.android.sdk.InAppFCManager$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(((String) obj).split(Constants.SEPARATOR_COMMA).length == 2);
            }
        };
        if (CTXtensions.hasData(preferences2)) {
            Logger.d("migrating shared preference countsPerInApp from V2 to V3...");
            new SharedPreferencesMigration(preferences2, preferences3, String.class, function1).migrate();
            Logger.d("Finished migrating shared preference countsPerInApp from V2 to V3.");
        } else if (CTXtensions.hasData(preferences)) {
            Logger.d("migrating shared preference countsPerInApp from V1 to V3...");
            new SharedPreferencesMigration(preferences, preferences3, String.class, function1).migrate();
            Logger.d("Finished migrating shared preference countsPerInApp from V1 to V3.");
        }
        InAppStore inAppStore = this.storeRegistry.getInAppStore();
        LegacyInAppStore legacyInAppStore = this.storeRegistry.getLegacyInAppStore();
        if (inAppStore != null && legacyInAppStore != null) {
            JSONArray inApps = legacyInAppStore.readInApps();
            if (inApps.length() > 0) {
                Logger.d("migrating in-apps from account id to device id based preference.");
                inAppStore.storeServerSideInApps(inApps);
                legacyInAppStore.removeInApps();
                Logger.d("Finished migrating in-apps from account id to device id based preference.");
            }
        }
        if (getStringFromPrefs(getKeyWithDeviceId("ict_date", str), null) != null || getStringFromPrefs("ict_date", null) == null) {
            return;
        }
        Logger.v("Migrating InAppFC Prefs");
        StorageHelper.putString(this.context, storageKeyWithSuffix(getKeyWithDeviceId("ict_date", str)), getStringFromPrefs("ict_date", "20140428"));
        StorageHelper.putInt(this.context, storageKeyWithSuffix(getKeyWithDeviceId(Constants.KEY_COUNTS_SHOWN_TODAY, str)), getIntFromPrefs(storageKeyWithSuffix(Constants.KEY_COUNTS_SHOWN_TODAY), 0));
    }

    private String storageKeyWithSuffix(String str) {
        return str + ":" + getConfigAccountId();
    }
}
