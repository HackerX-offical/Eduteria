package com.clevertap.android.sdk;

import android.app.UiModeManager;
import android.app.usage.UsageStatsManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Insets;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.clevertap.android.sdk.inapp.InAppController;
import com.clevertap.android.sdk.login.LoginInfoProvider;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.Task;
import com.clevertap.android.sdk.utils.CTJsonConverter;
import com.clevertap.android.sdk.validation.ValidationResult;
import com.clevertap.android.sdk.validation.ValidationResultFactory;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceInfo {
    private static final String GUID_PREFIX = "__";
    static final int NULL = -1;
    private static final String OS_NAME = "Android";
    public static final int SMART_PHONE = 1;
    public static final int TABLET = 2;
    static final int TV = 3;
    static final int UNKNOWN = 0;
    static int sDeviceType = -1;
    private DeviceCachedInfo cachedInfo;
    private final CleverTapInstanceConfig config;
    private final Context context;
    private final CoreMetaData mCoreMetaData;
    private final Object adIDLock = new Object();
    private boolean adIdRun = false;
    private final Object deviceIDLock = new Object();
    private boolean enableNetworkInfoReporting = false;
    private String googleAdID = null;
    private boolean limitAdTracking = false;
    private final ArrayList<ValidationResult> validationResults = new ArrayList<>();
    private String library = null;
    private String customLocale = null;

    private class DeviceCachedInfo {
        private static final String STANDBY_BUCKET_ACTIVE = "active";
        private static final String STANDBY_BUCKET_FREQUENT = "frequent";
        private static final String STANDBY_BUCKET_RARE = "rare";
        private static final String STANDBY_BUCKET_RESTRICTED = "restricted";
        private static final String STANDBY_BUCKET_WORKING_SET = "working_set";
        private final String appBucket;
        private final int dpi;
        private final double height;
        private int localInAppCount;
        private final String locale;
        private final double width;
        private final String versionName = getVersionName();
        private final String osName = getOsName();
        private final String osVersion = getOsVersion();
        private final String manufacturer = getManufacturer();
        private final String model = getModel();
        private final String carrier = getCarrier();
        private final int build = getBuild();
        private final String networkType = getNetworkType();
        private final String bluetoothVersion = getBluetoothVersion();
        private final String countryCode = getCountryCode();
        private final int sdkVersion = getSdkVersion();

        private int getSdkVersion() {
            return BuildConfig.VERSION_CODE;
        }

        static /* synthetic */ int access$1608(DeviceCachedInfo deviceCachedInfo) {
            int i = deviceCachedInfo.localInAppCount;
            deviceCachedInfo.localInAppCount = i + 1;
            return i;
        }

        DeviceCachedInfo() {
            WindowSize windowSizeData = getWindowSizeData();
            this.width = windowSizeData.width;
            this.height = windowSizeData.height;
            this.dpi = windowSizeData.localDpi;
            this.localInAppCount = DeviceInfo.this.getLocalInAppCountFromPreference();
            this.locale = getDeviceLocale();
            this.appBucket = getAppBucket();
        }

        private WindowSize getWindowSizeData() {
            int iWidth;
            int iHeight;
            float f2;
            float f3;
            int i;
            WindowManager windowManager = DeviceInfo.this.getWindowManager();
            if (windowManager == null) {
                Logger.v("WindowManager is null, returning zero dimension for width/height");
                return new WindowSize(0, 0.0d, 0.0d);
            }
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Configuration configuration = DeviceInfo.this.context.getResources().getConfiguration();
                Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemGestures());
                iWidth = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.right) - insetsIgnoringVisibility.left;
                iHeight = (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.top) - insetsIgnoringVisibility.bottom;
                f2 = configuration.densityDpi;
                f3 = configuration.densityDpi;
                i = configuration.densityDpi;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                iWidth = displayMetrics.widthPixels;
                iHeight = displayMetrics.heightPixels;
                f2 = displayMetrics.xdpi;
                f3 = displayMetrics.ydpi;
                i = displayMetrics.densityDpi;
            }
            return new WindowSize(i, toTwoPlaces(iWidth / f2), toTwoPlaces(iHeight / f3));
        }

        private String getBluetoothVersion() {
            if (!DeviceInfo.this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                if (DeviceInfo.this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
                    return "classic";
                }
                return "none";
            }
            return "ble";
        }

        private int getBuild() {
            try {
                return DeviceInfo.this.context.getPackageManager().getPackageInfo(DeviceInfo.this.context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.d("Unable to get app build");
                return 0;
            }
        }

        private String getCarrier() {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) DeviceInfo.this.context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getNetworkOperatorName();
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        private String getCountryCode() {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) DeviceInfo.this.context.getSystemService("phone");
                if (telephonyManager == null) {
                    return "";
                }
                return telephonyManager.getSimCountryIso();
            } catch (Throwable unused) {
                return "";
            }
        }

        private String getManufacturer() {
            return Build.MANUFACTURER;
        }

        private String getAppBucket() {
            int appStandbyBucket = ((UsageStatsManager) DeviceInfo.this.context.getSystemService("usagestats")).getAppStandbyBucket();
            if (appStandbyBucket == 10) {
                return "active";
            }
            if (appStandbyBucket == 20) {
                return STANDBY_BUCKET_WORKING_SET;
            }
            if (appStandbyBucket == 30) {
                return STANDBY_BUCKET_FREQUENT;
            }
            if (appStandbyBucket == 40) {
                return STANDBY_BUCKET_RARE;
            }
            if (appStandbyBucket == 45) {
                return STANDBY_BUCKET_RESTRICTED;
            }
            return "";
        }

        private String getModel() {
            return Build.MODEL.replace(getManufacturer(), "");
        }

        private String getNetworkType() {
            return Utils.getDeviceNetworkType(DeviceInfo.this.context);
        }

        private String getOsName() {
            return "Android";
        }

        private String getOsVersion() {
            return Build.VERSION.RELEASE;
        }

        private String getVersionName() {
            try {
                return DeviceInfo.this.context.getPackageManager().getPackageInfo(DeviceInfo.this.context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                Logger.d("Unable to get app version");
                return null;
            }
        }

        private String getDeviceLocale() {
            String language = Locale.getDefault().getLanguage();
            if ("".equals(language)) {
                language = "xx";
            }
            String country = Locale.getDefault().getCountry();
            if ("".equals(country)) {
                country = "XX";
            }
            return language + "_" + country;
        }

        private double toTwoPlaces(double d2) {
            return Math.round(d2 * 100.0d) / 100.0d;
        }
    }

    private static class WindowSize {
        public final double height;
        public final int localDpi;
        public final double width;

        public WindowSize(int i, double d2, double d3) {
            this.localDpi = i;
            this.width = d2;
            this.height = d3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowManager getWindowManager() {
        Display display;
        if (this.context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                DisplayManager displayManager = (DisplayManager) this.context.getSystemService(DisplayManager.class);
                if (displayManager != null && (display = displayManager.getDisplay(0)) != null) {
                    return (WindowManager) this.context.createDisplayContext(display).createWindowContext(2, null).getSystemService(WindowManager.class);
                }
            } catch (Exception e2) {
                Logger.v("Window context creation failed: " + e2.getMessage());
            }
        }
        return (WindowManager) this.context.getSystemService("window");
    }

    public static int getAppIconAsIntId(Context context) {
        return context.getApplicationInfo().icon;
    }

    public static int getDeviceType(Context context) {
        if (sDeviceType == -1) {
            try {
                if (((UiModeManager) context.getSystemService("uimode")).getCurrentModeType() == 4) {
                    sDeviceType = 3;
                    return 3;
                }
            } catch (Exception e2) {
                Logger.d("Failed to decide whether device is a TV!");
                e2.printStackTrace();
            }
            try {
                sDeviceType = context.getResources().getBoolean(R.bool.ctIsTablet) ? 2 : 1;
            } catch (Exception e3) {
                Logger.d("Failed to decide whether device is a smart phone or tablet!");
                e3.printStackTrace();
                sDeviceType = 0;
            }
        }
        return sDeviceType;
    }

    DeviceInfo(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, String str, CoreMetaData coreMetaData) {
        this.context = context;
        this.config = cleverTapInstanceConfig;
        this.mCoreMetaData = coreMetaData;
    }

    public void forceNewDeviceID() {
        forceUpdateDeviceId(generateGUID());
    }

    public String forceUpdateCustomCleverTapID(String str) {
        if (Utils.validateCTID(str)) {
            getConfigLogger().info(this.config.getAccountId(), "Setting CleverTap ID to custom CleverTap ID : " + str);
            String str2 = Constants.CUSTOM_CLEVERTAP_ID_PREFIX + str;
            forceUpdateDeviceId(str2);
            return str2;
        }
        String strGenerateFallbackDeviceID = generateFallbackDeviceID();
        removeDeviceID();
        getConfigLogger().info(this.config.getAccountId(), recordDeviceError(21, str, getFallBackDeviceID()));
        return strGenerateFallbackDeviceID;
    }

    public void forceUpdateDeviceId(String str) {
        getConfigLogger().verbose(this.config.getAccountId(), "Force updating the device ID to " + str);
        synchronized (this.deviceIDLock) {
            StorageHelper.putString(this.context, getDeviceIdStorageKey(), str);
        }
    }

    public JSONObject getAppLaunchedFields() {
        try {
            return CTJsonConverter.from(this, this.mCoreMetaData, this.enableNetworkInfoReporting, getGoogleAdID() != null ? new LoginInfoProvider(this.context, this.config).deviceIsMultiUser() : false);
        } catch (Throwable th) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Failed to construct App Launched event", th);
            return new JSONObject();
        }
    }

    public String getBluetoothVersion() {
        return getDeviceCachedInfo().bluetoothVersion;
    }

    public int getBuild() {
        return getDeviceCachedInfo().build;
    }

    public String getCarrier() {
        return getDeviceCachedInfo().carrier;
    }

    public Context getContext() {
        return this.context;
    }

    public String getCountryCode() {
        return getDeviceCachedInfo().countryCode;
    }

    public int getDPI() {
        return getDeviceCachedInfo().dpi;
    }

    public String getDeviceID() {
        String str_getDeviceID = _getDeviceID();
        return str_getDeviceID != null ? str_getDeviceID : getFallBackDeviceID();
    }

    public String getGoogleAdID() {
        String str;
        synchronized (this.adIDLock) {
            str = this.googleAdID;
        }
        return str;
    }

    public double getHeight() {
        return getDeviceCachedInfo().height;
    }

    public String getLibrary() {
        return this.library;
    }

    void setLibrary(String str) {
        this.library = str;
    }

    public String getManufacturer() {
        return getDeviceCachedInfo().manufacturer;
    }

    public String getAppBucket() {
        return getDeviceCachedInfo().appBucket;
    }

    public String getModel() {
        return getDeviceCachedInfo().model;
    }

    public String getNetworkType() {
        return getDeviceCachedInfo().networkType;
    }

    public String getOsName() {
        return getDeviceCachedInfo().osName;
    }

    public String getOsVersion() {
        return getDeviceCachedInfo().osVersion;
    }

    public int getSdkVersion() {
        return getDeviceCachedInfo().sdkVersion;
    }

    public int getLocalInAppCount() {
        return getDeviceCachedInfo().localInAppCount;
    }

    public void incrementLocalInAppCount() {
        DeviceCachedInfo.access$1608(getDeviceCachedInfo());
    }

    public String getDeviceLocale() {
        return getDeviceCachedInfo().locale;
    }

    public void setCustomLocale(String str) {
        this.customLocale = str;
    }

    public String getCustomLocale() {
        return this.customLocale;
    }

    public String getLocale() {
        return TextUtils.isEmpty(getCustomLocale()) ? getDeviceLocale() : getCustomLocale();
    }

    public ArrayList<ValidationResult> getValidationResults() {
        ArrayList<ValidationResult> arrayList = (ArrayList) this.validationResults.clone();
        this.validationResults.clear();
        return arrayList;
    }

    public String getVersionName() {
        return getDeviceCachedInfo().versionName;
    }

    public double getWidth() {
        return getDeviceCachedInfo().width;
    }

    public Boolean isBluetoothEnabled() {
        BluetoothAdapter defaultAdapter;
        try {
            if (this.context.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.context.getPackageName()) != 0 || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
                return null;
            }
            return Boolean.valueOf(defaultAdapter.isEnabled());
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean isErrorDeviceId() {
        String deviceID = getDeviceID();
        return deviceID != null && deviceID.startsWith(Constants.ERROR_PROFILE_PREFIX);
    }

    public boolean isLimitAdTrackingEnabled() {
        boolean z;
        synchronized (this.adIDLock) {
            z = this.limitAdTracking;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean isWifiConnected() {
        /*
            r3 = this;
            android.content.Context r0 = r3.context
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            int r0 = r0.checkCallingOrSelfPermission(r1)
            if (r0 != 0) goto L30
            android.content.Context r0 = r3.context
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 == 0) goto L30
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L2a
            int r1 = r0.getType()
            r2 = 1
            if (r1 != r2) goto L2a
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L2a
            goto L2b
        L2a:
            r2 = 0
        L2b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            return r0
        L30:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.DeviceInfo.isWifiConnected():java.lang.Boolean");
    }

    void enableDeviceNetworkInfoReporting(boolean z) {
        this.enableNetworkInfoReporting = z;
        StorageHelper.putBoolean(this.context, this.config.getAccountId(), Constants.NETWORK_INFO, this.enableNetworkInfoReporting);
        this.config.getLogger().verbose(this.config.getAccountId(), "Device Network Information reporting set to " + this.enableNetworkInfoReporting);
    }

    String getAttributionID() {
        return getDeviceID();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLocalInAppCountFromPreference() {
        return StorageHelper.getInt(this.context, InAppController.LOCAL_INAPP_COUNT, 0);
    }

    void onInitDeviceInfo(final String str) {
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "DeviceInfo() called");
        CTExecutorFactory.executors(this.config).ioTask().execute("getDeviceCachedInfo", new Callable<Void>() { // from class: com.clevertap.android.sdk.DeviceInfo.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                DeviceInfo.this.getDeviceCachedInfo();
                return null;
            }
        });
        Task taskIoTask = CTExecutorFactory.executors(this.config).ioTask();
        taskIoTask.addOnSuccessListener(new OnSuccessListener() { // from class: com.clevertap.android.sdk.DeviceInfo$$ExternalSyntheticLambda0
            @Override // com.clevertap.android.sdk.task.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f$0.m11871lambda$onInitDeviceInfo$0$comclevertapandroidsdkDeviceInfo((String) obj);
            }
        });
        taskIoTask.execute("initDeviceID", new Callable<String>() { // from class: com.clevertap.android.sdk.DeviceInfo.2
            @Override // java.util.concurrent.Callable
            public String call() throws Exception {
                return DeviceInfo.this.initDeviceID(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onInitDeviceInfo$0$com-clevertap-android-sdk-DeviceInfo, reason: not valid java name */
    /* synthetic */ void m11871lambda$onInitDeviceInfo$0$comclevertapandroidsdkDeviceInfo(String str) {
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "DeviceID initialized successfully!" + Thread.currentThread());
        CleverTapAPI.instanceWithConfig(this.context, this.config).deviceIDCreated(str);
    }

    public void setCurrentUserOptOutStateFromStorage() {
        String strOptOutKey = optOutKey();
        if (strOptOutKey == null) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Unable to set current user OptOut state from storage: storage key is null");
            return;
        }
        boolean booleanFromPrefs = StorageHelper.getBooleanFromPrefs(this.context, this.config.getAccountId(), strOptOutKey);
        this.mCoreMetaData.setCurrentUserOptedOut(booleanFromPrefs);
        this.config.getLogger().verbose(this.config.getAccountId(), "Set current user OptOut state from storage to: " + booleanFromPrefs + " for key: " + strOptOutKey);
    }

    void saveOptOutState(boolean z) {
        String strOptOutKey = optOutKey();
        if (strOptOutKey == null) {
            getConfigLogger().verbose(this.config.getAccountId(), "Unable to persist user OptOut state, storage key is null");
        } else {
            StorageHelper.putBoolean(this.context, this.config.getAccountId(), strOptOutKey, z);
            getConfigLogger().verbose(this.config.getAccountId(), "Set current user OptOut state to: " + z);
        }
    }

    public void setSystemEventsAllowedStateFromStorage() {
        String strAllowedSystemEventsKey = allowedSystemEventsKey();
        if (strAllowedSystemEventsKey == null) {
            this.config.getLogger().verbose(this.config.getAccountId(), "Unable to set current user allowed system events and communications flag from storage: storage key is null");
            return;
        }
        boolean booleanFromPrefs = StorageHelper.getBooleanFromPrefs(this.context, this.config.getAccountId(), strAllowedSystemEventsKey);
        this.mCoreMetaData.setEnabledSystemEvents(booleanFromPrefs);
        this.config.getLogger().verbose(this.config.getAccountId(), "Set current user allowed system events and communications flag state from storage to: " + booleanFromPrefs + " for key: " + strAllowedSystemEventsKey);
    }

    void saveAllowedSystemEventsState(boolean z) {
        String strAllowedSystemEventsKey = allowedSystemEventsKey();
        if (strAllowedSystemEventsKey == null) {
            getConfigLogger().verbose(this.config.getAccountId(), "Unable to persist user allowed system events and communications flag state, storage key is null");
        } else {
            StorageHelper.putBoolean(this.context, this.config.getAccountId(), strAllowedSystemEventsKey, z);
            getConfigLogger().verbose(this.config.getAccountId(), "Set current user allowed system events and communications flag state to: " + z);
        }
    }

    private String optOutKey() {
        String deviceID = getDeviceID();
        if (deviceID == null) {
            return null;
        }
        return "OptOut:" + deviceID;
    }

    private String allowedSystemEventsKey() {
        String deviceID = getDeviceID();
        if (deviceID == null) {
            return null;
        }
        return "allowSystemEvents:" + deviceID;
    }

    void setDeviceNetworkInfoReportingFromStorage() {
        boolean booleanFromPrefs = StorageHelper.getBooleanFromPrefs(this.context, this.config.getAccountId(), Constants.NETWORK_INFO);
        this.config.getLogger().verbose(this.config.getAccountId(), "Setting device network info reporting state from storage to " + booleanFromPrefs);
        this.enableNetworkInfoReporting = booleanFromPrefs;
    }

    private String _getDeviceID() {
        String string = StorageHelper.getString(this.context, getDeviceIdStorageKey(), null);
        return (this.config.isDefaultInstance() && string == null) ? StorageHelper.getString(this.context, Constants.DEVICE_ID_TAG, null) : string;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:12:0x0069, B:18:0x0073, B:20:0x00a8, B:21:0x00b7, B:24:0x00ba), top: B:57:0x0069, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba A[Catch: all -> 0x0070, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:12:0x0069, B:18:0x0073, B:20:0x00a8, B:21:0x00b7, B:24:0x00ba), top: B:57:0x0069, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized void fetchGoogleAdID() {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.DeviceInfo.fetchGoogleAdID():void");
    }

    private synchronized String generateDeviceID() {
        String strGenerateGUID;
        String str;
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "generateDeviceID() called!");
        String googleAdID = getGoogleAdID();
        if (googleAdID != null) {
            str = Constants.GUID_PREFIX_GOOGLE_AD_ID + googleAdID;
        } else {
            synchronized (this.deviceIDLock) {
                strGenerateGUID = generateGUID();
            }
            str = strGenerateGUID;
        }
        forceUpdateDeviceId(str);
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "generateDeviceID() done executing!");
        return str;
    }

    private String generateGUID() {
        return GUID_PREFIX + UUID.randomUUID().toString().replace("-", "");
    }

    private Logger getConfigLogger() {
        return this.config.getLogger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DeviceCachedInfo getDeviceCachedInfo() {
        if (this.cachedInfo == null) {
            this.cachedInfo = new DeviceCachedInfo();
        }
        return this.cachedInfo;
    }

    private String getDeviceIdStorageKey() {
        return "deviceId:" + this.config.getAccountId();
    }

    private String getFallBackDeviceID() {
        return StorageHelper.getString(this.context, getFallbackIdStorageKey(), null);
    }

    private String getFallbackIdStorageKey() {
        return "fallbackId:" + this.config.getAccountId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String initDeviceID(String str) {
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "Called initDeviceID()");
        if (this.config.getEnableCustomCleverTapId()) {
            if (str == null) {
                this.config.getLogger().info(recordDeviceError(18, new String[0]));
            }
        } else if (str != null) {
            this.config.getLogger().info(recordDeviceError(19, new String[0]));
        }
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "Calling _getDeviceID");
        String str_getDeviceID = _getDeviceID();
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "Called _getDeviceID");
        if (str_getDeviceID != null && str_getDeviceID.trim().length() > 2) {
            getConfigLogger().verbose(this.config.getAccountId(), "CleverTap ID already present for profile");
            if (str != null) {
                getConfigLogger().info(this.config.getAccountId(), recordDeviceError(20, str_getDeviceID, str));
            }
            return str_getDeviceID;
        }
        if (this.config.getEnableCustomCleverTapId()) {
            return forceUpdateCustomCleverTapID(str);
        }
        if (!this.config.isUseGoogleAdId()) {
            getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "Calling generateDeviceID()");
            String strGenerateDeviceID = generateDeviceID();
            getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "Called generateDeviceID()");
            return strGenerateDeviceID;
        }
        fetchGoogleAdID();
        String strGenerateDeviceID2 = generateDeviceID();
        getConfigLogger().verbose(this.config.getAccountId() + ":async_deviceID", "initDeviceID() done executing!");
        return strGenerateDeviceID2;
    }

    private String recordDeviceError(int i, String... strArr) {
        ValidationResult validationResultCreate = ValidationResultFactory.create(514, i, strArr);
        this.validationResults.add(validationResultCreate);
        return validationResultCreate.getErrorDesc();
    }

    private void removeDeviceID() {
        StorageHelper.remove(this.context, getDeviceIdStorageKey());
    }

    private synchronized String generateFallbackDeviceID() {
        String str;
        String fallBackDeviceID = getFallBackDeviceID();
        if (fallBackDeviceID != null) {
            return fallBackDeviceID;
        }
        synchronized (this.deviceIDLock) {
            str = Constants.ERROR_PROFILE_PREFIX + UUID.randomUUID().toString().replace("-", "");
            updateFallbackID(str);
        }
        return str;
    }

    private void updateFallbackID(String str) {
        getConfigLogger().verbose(this.config.getAccountId(), "Updating the fallback id - " + str);
        StorageHelper.putString(this.context, getFallbackIdStorageKey(), str);
    }
}
