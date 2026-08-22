package com.clevertap.android.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes7.dex */
public class ManifestInfo {
    private static final String LABEL_ACCOUNT_ID = "CLEVERTAP_ACCOUNT_ID";
    private static final String LABEL_BACKGROUND_SYNC = "CLEVERTAP_BACKGROUND_SYNC";
    private static final String LABEL_BETA = "CLEVERTAP_BETA";
    private static final String LABEL_CLEVERTAP_HANDSHAKE_DOMAIN = "CLEVERTAP_HANDSHAKE_DOMAIN";
    private static final String LABEL_CUSTOM_ID = "CLEVERTAP_USE_CUSTOM_ID";
    private static final String LABEL_DEFAULT_CHANNEL_ID = "CLEVERTAP_DEFAULT_CHANNEL_ID";
    private static final String LABEL_DISABLE_APP_LAUNCH = "CLEVERTAP_DISABLE_APP_LAUNCHED";
    private static final String LABEL_ENCRYPTION_IN_TRANSIT = "CLEVERTAP_ENCRYPTION_IN_TRANSIT";
    private static final String LABEL_ENCRYPTION_LEVEL = "CLEVERTAP_ENCRYPTION_LEVEL";
    private static final String LABEL_FCM_SENDER_ID = "FCM_SENDER_ID";
    private static final String LABEL_INAPP_EXCLUDE = "CLEVERTAP_INAPP_EXCLUDE";
    private static final String LABEL_INTENT_SERVICE = "CLEVERTAP_INTENT_SERVICE";
    public static final String LABEL_NOTIFICATION_ICON = "CLEVERTAP_NOTIFICATION_ICON";
    private static final String LABEL_PACKAGE_NAME = "CLEVERTAP_APP_PACKAGE";
    private static final String LABEL_PROXY_DOMAIN = "CLEVERTAP_PROXY_DOMAIN";
    private static final String LABEL_PUSH_PROVIDER_1 = "CLEVERTAP_PROVIDER_1";
    private static final String LABEL_PUSH_PROVIDER_2 = "CLEVERTAP_PROVIDER_2";
    private static final String LABEL_REGION = "CLEVERTAP_REGION";
    private static final String LABEL_SPIKY_PROXY_DOMAIN = "CLEVERTAP_SPIKY_PROXY_DOMAIN";
    private static final String LABEL_SSL_PINNING = "CLEVERTAP_SSL_PINNING";
    private static final String LABEL_TOKEN = "CLEVERTAP_TOKEN";
    private static final String LABEL_USE_GOOGLE_AD_ID = "CLEVERTAP_USE_GOOGLE_AD_ID";
    private static String ccAccountId;
    private static String ccAccountRegion;
    private static String ccAccountToken;
    private static String ccHandshakeDomain;
    private static String ccProxyDomain;
    private static String ccSpikyProxyDomain;
    private static ManifestInfo instance;
    private final String accountId;
    private final String accountRegion;
    private final String accountToken;
    private final boolean appLaunchedDisabled;
    private final boolean backgroundSync;
    private final boolean beta;
    private final String devDefaultPushChannelId;
    private final String encryptionInTransit;
    private final int encryptionLevel;
    private final String excludedActivitiesForInApps;
    private final String fcmSenderId;
    private final String handshakeDomain;
    private final String intentServiceName;
    private final String notificationIcon;
    private final String packageName;
    private final String[] profileKeys;
    private final String provider1;
    private final String provider2;
    private final String proxyDomain;
    private final String spikyProxyDomain;
    private final boolean sslPinning;
    private final boolean useADID;
    private final boolean useCustomID;

    public static synchronized ManifestInfo getInstance(Context context) {
        if (instance == null) {
            instance = new ManifestInfo(context);
        }
        return instance;
    }

    static void clearPreloadedManifestInfo() {
        instance = null;
    }

    static void changeCredentials(String str, String str2, String str3) {
        ccAccountId = str;
        ccAccountToken = str2;
        ccAccountRegion = str3;
    }

    static void changeCredentials(String str, String str2, String str3, String str4) {
        ccAccountId = str;
        ccAccountToken = str2;
        ccProxyDomain = str3;
        ccSpikyProxyDomain = str4;
    }

    static void changeCredentials(String str, String str2, String str3, String str4, String str5) {
        ccAccountId = str;
        ccAccountToken = str2;
        ccProxyDomain = str3;
        ccSpikyProxyDomain = str4;
        ccHandshakeDomain = str5;
    }

    private ManifestInfo(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (Throwable unused) {
            bundle = null;
        }
        bundle = bundle == null ? new Bundle() : bundle;
        String str = ccAccountId;
        this.accountId = str == null ? _getManifestStringValueForKey(bundle, LABEL_ACCOUNT_ID) : str;
        String str2 = ccAccountToken;
        this.accountToken = str2 == null ? _getManifestStringValueForKey(bundle, LABEL_TOKEN) : str2;
        String str3 = ccAccountRegion;
        this.accountRegion = str3 == null ? _getManifestStringValueForKey(bundle, LABEL_REGION) : str3;
        String str4 = ccProxyDomain;
        this.proxyDomain = str4 == null ? _getManifestStringValueForKey(bundle, LABEL_PROXY_DOMAIN) : str4;
        String str5 = ccSpikyProxyDomain;
        this.spikyProxyDomain = str5 == null ? _getManifestStringValueForKey(bundle, LABEL_SPIKY_PROXY_DOMAIN) : str5;
        String str6 = ccHandshakeDomain;
        this.handshakeDomain = str6 == null ? _getManifestStringValueForKey(bundle, LABEL_CLEVERTAP_HANDSHAKE_DOMAIN) : str6;
        this.notificationIcon = _getManifestStringValueForKey(bundle, LABEL_NOTIFICATION_ICON);
        this.useADID = "1".equals(_getManifestStringValueForKey(bundle, LABEL_USE_GOOGLE_AD_ID));
        this.appLaunchedDisabled = "1".equals(_getManifestStringValueForKey(bundle, LABEL_DISABLE_APP_LAUNCH));
        this.excludedActivitiesForInApps = _getManifestStringValueForKey(bundle, LABEL_INAPP_EXCLUDE);
        this.sslPinning = "1".equals(_getManifestStringValueForKey(bundle, LABEL_SSL_PINNING));
        this.backgroundSync = "1".equals(_getManifestStringValueForKey(bundle, LABEL_BACKGROUND_SYNC));
        this.useCustomID = "1".equals(_getManifestStringValueForKey(bundle, LABEL_CUSTOM_ID));
        String str_getManifestStringValueForKey = _getManifestStringValueForKey(bundle, LABEL_FCM_SENDER_ID);
        this.fcmSenderId = str_getManifestStringValueForKey != null ? str_getManifestStringValueForKey.replace("id:", "") : str_getManifestStringValueForKey;
        int i = 0;
        try {
            String str_getManifestStringValueForKey2 = _getManifestStringValueForKey(bundle, LABEL_ENCRYPTION_LEVEL);
            int i2 = str_getManifestStringValueForKey2 != null ? Integer.parseInt(str_getManifestStringValueForKey2) : 0;
            if (i2 < 0 || i2 > 2) {
                Logger.v("Invalid encryption level is used, defaulting to no encryption");
            } else {
                i = i2;
            }
        } catch (Throwable th) {
            Logger.v("Unable to parse encryption level from the Manifest, Setting it to 0 by default", th.getCause());
        }
        this.encryptionLevel = i;
        this.packageName = _getManifestStringValueForKey(bundle, LABEL_PACKAGE_NAME);
        this.beta = "1".equals(_getManifestStringValueForKey(bundle, LABEL_BETA));
        this.intentServiceName = _getManifestStringValueForKey(bundle, LABEL_INTENT_SERVICE);
        this.devDefaultPushChannelId = _getManifestStringValueForKey(bundle, LABEL_DEFAULT_CHANNEL_ID);
        this.profileKeys = parseProfileKeys(bundle);
        this.provider1 = _getManifestStringValueForKey(bundle, LABEL_PUSH_PROVIDER_1);
        this.provider2 = _getManifestStringValueForKey(bundle, LABEL_PUSH_PROVIDER_2);
        this.encryptionInTransit = _getManifestStringValueForKey(bundle, LABEL_ENCRYPTION_IN_TRANSIT);
    }

    ManifestInfo(String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, String str7, String str8, boolean z3, boolean z4, boolean z5, String str9, String str10, boolean z6, String str11, String str12, String[] strArr, int i, String str13, String str14, String str15) {
        this.accountId = str;
        this.accountToken = str2;
        this.accountRegion = str3;
        this.proxyDomain = str4;
        this.spikyProxyDomain = str5;
        this.handshakeDomain = str6;
        this.useADID = z;
        this.appLaunchedDisabled = z2;
        this.notificationIcon = str7;
        this.excludedActivitiesForInApps = str8;
        this.sslPinning = z3;
        this.backgroundSync = z4;
        this.useCustomID = z5;
        this.fcmSenderId = str9;
        this.packageName = str10;
        this.beta = z6;
        this.intentServiceName = str11;
        this.devDefaultPushChannelId = str12;
        this.profileKeys = strArr;
        this.encryptionLevel = i;
        this.provider1 = str13;
        this.provider2 = str14;
        this.encryptionInTransit = str15;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getExcludedActivities() {
        return this.excludedActivitiesForInApps;
    }

    public String getFCMSenderId() {
        return this.fcmSenderId;
    }

    public String getDevDefaultPushChannelId() {
        return this.devDefaultPushChannelId;
    }

    public String getIntentServiceName() {
        return this.intentServiceName;
    }

    public String getNotificationIcon() {
        return this.notificationIcon;
    }

    public String[] getProfileKeys() {
        return this.profileKeys;
    }

    boolean enableBeta() {
        return this.beta;
    }

    public int getEncryptionLevel() {
        return this.encryptionLevel;
    }

    public String getAccountRegion() {
        Logger.v("ManifestInfo: getAccountRegion called, returning region:" + this.accountRegion);
        return this.accountRegion;
    }

    String getAccountToken() {
        return this.accountToken;
    }

    public String getProxyDomain() {
        Logger.v("ManifestInfo: getProxyDomain called, returning proxyDomain:" + this.proxyDomain);
        return this.proxyDomain;
    }

    public String getSpikeyProxyDomain() {
        Logger.v("ManifestInfo: getSpikeyProxyDomain called, returning spikeyProxyDomain:" + this.spikyProxyDomain);
        return this.spikyProxyDomain;
    }

    public String getHandshakeDomain() {
        Logger.v("ManifestInfo: getHandshakeDomain called, returning handshakeDomain:" + this.handshakeDomain);
        return this.handshakeDomain;
    }

    String getPackageName() {
        return this.packageName;
    }

    boolean isAppLaunchedDisabled() {
        return this.appLaunchedDisabled;
    }

    boolean isBackgroundSync() {
        return this.backgroundSync;
    }

    public boolean isSSLPinningEnabled() {
        return this.sslPinning;
    }

    boolean useCustomId() {
        return this.useCustomID;
    }

    boolean useGoogleAdId() {
        return this.useADID;
    }

    private String[] parseProfileKeys(Bundle bundle) {
        String str_getManifestStringValueForKey = _getManifestStringValueForKey(bundle, Constants.CLEVERTAP_IDENTIFIER);
        return !TextUtils.isEmpty(str_getManifestStringValueForKey) ? str_getManifestStringValueForKey.split(Constants.SEPARATOR_COMMA) : Constants.NULL_STRING_ARRAY;
    }

    private String _getManifestStringValueForKey(Bundle bundle, String str) {
        try {
            Object obj = bundle.get(str);
            if (obj != null) {
                return obj.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public String getVendorOneProvider() {
        return this.provider1;
    }

    public String getVendorTwoProvider() {
        return this.provider2;
    }

    public String getEncryptionInTransit() {
        return this.encryptionInTransit;
    }
}
