package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes9.dex */
public class IdManager implements InstallIdProvider {
    public static final String DEFAULT_VERSION_NAME = "0.0";
    static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
    static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
    static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
    static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
    private final Context appContext;
    private final String appIdentifier;
    private String crashlyticsInstallId;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final InstallerPackageNameProvider installerPackageNameProvider;
    private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
    private static final String FORWARD_SLASH_REGEX = Pattern.quote(MqttTopic.TOPIC_LEVEL_SEPARATOR);

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.appContext = context;
        this.appIdentifier = str;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.installerPackageNameProvider = new InstallerPackageNameProvider();
    }

    private static String formatId(String str) {
        if (str == null) {
            return null;
        }
        return ID_PATTERN.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    @Override // com.google.firebase.crashlytics.internal.common.InstallIdProvider
    public synchronized String getCrashlyticsInstallId() {
        String str;
        String str2 = this.crashlyticsInstallId;
        if (str2 != null) {
            return str2;
        }
        Logger.getLogger().v("Determining Crashlytics installation ID...");
        SharedPreferences sharedPrefs = CommonUtils.getSharedPrefs(this.appContext);
        Task<String> id = this.firebaseInstallationsApi.getId();
        String string = sharedPrefs.getString(PREFKEY_FIREBASE_IID, null);
        try {
            str = (String) Utils.awaitEvenIfOnMainThread(id);
        } catch (Exception e2) {
            Logger.getLogger().w("Failed to retrieve Firebase Installations ID.", e2);
            str = string != null ? string : null;
        }
        if (string == null) {
            Logger.getLogger().v("No cached Firebase Installations ID found.");
            SharedPreferences legacySharedPrefs = CommonUtils.getLegacySharedPrefs(this.appContext);
            String string2 = legacySharedPrefs.getString("crashlytics.installation.id", null);
            if (string2 == null) {
                Logger.getLogger().v("No legacy Crashlytics installation ID found, creating new ID.");
                this.crashlyticsInstallId = createAndStoreIid(str, sharedPrefs);
            } else {
                Logger.getLogger().v("A legacy Crashlytics installation ID was found. Upgrading.");
                this.crashlyticsInstallId = string2;
                migrateLegacyId(string2, str, sharedPrefs, legacySharedPrefs);
            }
        } else if (string.equals(str)) {
            this.crashlyticsInstallId = sharedPrefs.getString("crashlytics.installation.id", null);
            Logger.getLogger().v("Firebase Installations ID is unchanged from previous startup.");
            if (this.crashlyticsInstallId == null) {
                Logger.getLogger().v("Crashlytics installation ID was null, creating new ID.");
                this.crashlyticsInstallId = createAndStoreIid(str, sharedPrefs);
            }
        } else {
            this.crashlyticsInstallId = createAndStoreIid(str, sharedPrefs);
        }
        Logger.getLogger().v("Crashlytics installation ID is " + this.crashlyticsInstallId);
        return this.crashlyticsInstallId;
    }

    private synchronized void migrateLegacyId(String str, String str2, SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        Logger.getLogger().v("Migrating legacy Crashlytics installation ID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", str).putString(PREFKEY_FIREBASE_IID, str2).apply();
        sharedPreferences2.edit().remove("crashlytics.installation.id").remove(PREFKEY_ADVERTISING_ID).apply();
    }

    private synchronized String createAndStoreIid(String str, SharedPreferences sharedPreferences) {
        String id;
        id = formatId(UUID.randomUUID().toString());
        Logger.getLogger().v("Created new Crashlytics installation ID: " + id);
        sharedPreferences.edit().putString("crashlytics.installation.id", id).putString(PREFKEY_FIREBASE_IID, str).apply();
        return id;
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public String getOsDisplayVersionString() {
        return removeForwardSlashesIn(Build.VERSION.RELEASE);
    }

    public String getOsBuildVersionString() {
        return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
    }

    public String getModelName() {
        return String.format(Locale.US, "%s/%s", removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL));
    }

    private String removeForwardSlashesIn(String str) {
        return str.replaceAll(FORWARD_SLASH_REGEX, "");
    }

    public String getInstallerPackageName() {
        return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
    }
}
