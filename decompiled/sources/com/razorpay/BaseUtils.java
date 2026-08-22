package com.razorpay;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.media3.common.MimeTypes;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.imagecropper.CropImage;
import com.clevertap.android.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AdvertisingIdUtil;
import com.razorpay.AnalyticsProperty;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.util.TLSUtils;
import org.jivesoftware.smackx.hashes.element.HashElement;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class BaseUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String PERMISSION_DISABLED = "permission disabled";
    static String apiKey;
    private static BaseUtils baseUtils;
    static String ipAddress;
    private String orderId;
    private String paymentId;
    private static final boolean sWebViewDebuggingEnabled = ConfigDroid.ENABLE_WEBVIEW_DEBUGGING.booleanValue();
    private static boolean isCompatibleWithGooglePay = true;
    private static boolean isGpayCardsUpiRegistered = false;
    private static final ExecutorService ICON_EXECUTOR = Executors.newCachedThreadPool();

    BaseUtils() {
    }

    public static BaseUtils getInstance() {
        BaseUtils baseUtils2 = baseUtils;
        if (baseUtils2 != null) {
            return baseUtils2;
        }
        BaseUtils baseUtils3 = new BaseUtils();
        baseUtils = baseUtils3;
        return baseUtils3;
    }

    public void setDeeplinkEnabled(Context context, boolean z) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, (Class<?>) DeeplinkActivity.class), z ? 1 : 2, 1);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
        }
    }

    public static ArrayList<String> getAppsWithPackageNames(Context context, ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            for (String str : arrayList) {
                if (str != null && !str.isEmpty() && isAppInstalled(context, str)) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    public void setPaymentId(String str) {
        this.paymentId = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getMetadata() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("payment_id", this.paymentId);
            jSONObject.put("order_id", this.orderId);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void clearMetadata() {
        this.paymentId = null;
        this.orderId = null;
    }

    static String constructBasicAuth(String str) throws UnsupportedEncodingException {
        return Base64.encodeToString((str + ":").getBytes("UTF-8"), 2);
    }

    static boolean hasPermission(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
            return false;
        }
    }

    static String getKeyId(Context context) {
        try {
            String str = apiKey;
            if (str != null) {
                return str;
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            return applicationInfo.metaData.getString("com.razorpay.ApiKey");
        } catch (PackageManager.NameNotFoundException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
            return null;
        }
    }

    static HashMap<String, String> getAllPluginsFromManifest(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                return null;
            }
            HashMap<String, String> map = new HashMap<>();
            for (String str : applicationInfo.metaData.keySet()) {
                if (str.contains("com.razorpay.plugin.") && applicationInfo.metaData.getString(str).equalsIgnoreCase("com.razorpay.RzpGpayMerged")) {
                    try {
                        if (Class.forName("com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient").newInstance() != null) {
                            map.put(str, applicationInfo.metaData.getString(str));
                        }
                    } catch (ClassNotFoundException e2) {
                        AnalyticsUtil.reportError(e2.getMessage(), "S2", "GooglePay SDK is not included");
                    } catch (IllegalAccessException e3) {
                        e = e3;
                        e.printStackTrace();
                    } catch (InstantiationException e4) {
                        e = e4;
                        e.printStackTrace();
                    }
                } else if (str.contains("com.razorpay.plugin.") && applicationInfo.metaData.getString(str).equalsIgnoreCase("com.razorpay.RzpGooglePay")) {
                    try {
                        if (Class.forName("com.google.android.apps.nbu.paisa.inapp.client.api.PaymentsClient").newInstance() != null) {
                            map.put(str, applicationInfo.metaData.getString(str));
                        }
                    } catch (ClassNotFoundException e5) {
                        AnalyticsUtil.reportError(e5.getMessage(), "S2", "GooglePay SDK is not included");
                    } catch (IllegalAccessException e6) {
                        e = e6;
                        e.printStackTrace();
                    } catch (InstantiationException e7) {
                        e = e7;
                        e.printStackTrace();
                    }
                } else if (str.contains("com.razorpay.plugin.") && applicationInfo.metaData.getString(str) != null) {
                    map.put(str, applicationInfo.metaData.getString(str));
                }
            }
            return map;
        } catch (PackageManager.NameNotFoundException e8) {
            AnalyticsUtil.reportError(e8.getMessage(), "S0", e8.getMessage());
            return null;
        }
    }

    private static void setBaseWebViewSettings() {
        WebView.setWebContentsDebuggingEnabled(sWebViewDebuggingEnabled);
    }

    private static void enableJavaScriptInWebView(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
    }

    static void setWebViewSettings(final Context context, final WebView webView, boolean z) {
        setBaseWebViewSettings();
        enableJavaScriptInWebView(webView);
        CookieManager.getInstance().setAcceptCookie(true);
        webView.setTag("razorpay");
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setTextZoom(100);
        context.getApplicationContext().getDir("database", 0).getPath();
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        settings.setCacheMode(-1);
        if (z) {
            settings.setCacheMode(2);
        }
        settings.setSaveFormData(false);
        webView.addJavascriptInterface(new StorageBridge(context), "StorageBridge");
        settings.setAllowFileAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowContentAccess(false);
        webView.post(new Runnable() { // from class: com.razorpay.BaseUtils.1
            @Override // java.lang.Runnable
            public void run() {
                GpuInfoUtil.extractGpuInfo(webView, context);
            }
        });
    }

    static boolean hasFeature(Context context, String str) {
        return context.getPackageManager().hasSystemFeature(str);
    }

    static <T> T getSystemService(Context context, String str) {
        return (T) context.getApplicationContext().getSystemService(str);
    }

    static int getNetworkType(Context context) {
        NetworkType dataNetworkType = getDataNetworkType(context);
        if (dataNetworkType == NetworkType.WIFI) {
            return 0;
        }
        if (dataNetworkType == NetworkType.BLUETOOTH) {
            return 1;
        }
        if (dataNetworkType != NetworkType.CELLULAR) {
            return -1;
        }
        String cellularNetworkType = getCellularNetworkType(context);
        if (cellularNetworkType.equalsIgnoreCase("2G")) {
            return 2;
        }
        if (cellularNetworkType.equalsIgnoreCase("3G")) {
            return 3;
        }
        return cellularNetworkType.equalsIgnoreCase("4G") ? 4 : -1;
    }

    static String getCellularNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return "NA";
            }
            return mapNetworkTypeToGeneration(telephonyManager.getDataNetworkType());
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getLocalizedMessage());
            return "NA";
        }
    }

    private static String mapNetworkTypeToGeneration(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "LTE";
            default:
                return "NA";
        }
    }

    private static String getCellularNetworkTypeFromConnectivityManager(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 0) {
                return "NA";
            }
            return mapNetworkTypeToGeneration(activeNetworkInfo.getSubtype());
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getLocalizedMessage());
            return "NA";
        }
    }

    static String getCellularNetworkProviderName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(context, "phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return "unknown";
    }

    static NetworkType getDataNetworkType(Context context) {
        ConnectivityManager connectivityManager;
        if (hasPermission(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) getSystemService(context, "connectivity")) != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                return NetworkType.WIFI;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(7);
            if (networkInfo2 != null && networkInfo2.isConnected()) {
                return NetworkType.BLUETOOTH;
            }
            NetworkInfo networkInfo3 = connectivityManager.getNetworkInfo(0);
            if (networkInfo3 != null && networkInfo3.isConnected()) {
                return NetworkType.CELLULAR;
            }
        }
        return NetworkType.UNKNOWN;
    }

    static String getLocale() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    static ArrayList<String> jsonStringArrayToArrayList(JSONArray jSONArray) throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    static String getAppBuildType(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return "development";
        }
        return "production";
    }

    static CharSequence getWebViewUserAgent(Context context) {
        try {
            return AnalyticsUtil.returnUndefinedIfNull(new WebView(context).getSettings().getUserAgentString());
        } catch (Exception unused) {
            return "undefined";
        }
    }

    static boolean isDeviceHaveCorrectTlsVersion() {
        try {
            String[] protocols = SSLContext.getDefault().getDefaultSSLParameters().getProtocols();
            if (protocols == null) {
                return false;
            }
            for (String str : protocols) {
                if (str.startsWith("TLS") && !str.equalsIgnoreCase(TLSUtils.PROTO_TLSV1)) {
                    return true;
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getMessage());
        }
        return false;
    }

    static void setup() {
        AnalyticsUtil.reset();
    }

    public static double round(double d2, int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(d2).setScale(i, RoundingMode.HALF_UP).doubleValue();
    }

    public static String nanoTimeToSecondsString(long j, int i) {
        return new StringBuilder().append(round(j / 1.0E9d, i)).toString();
    }

    static boolean isMerchantAppDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    static Certificate getX509Certificate(SslCertificate sslCertificate) {
        byte[] byteArray = SslCertificate.saveState(sslCertificate).getByteArray("x509-certificate");
        if (byteArray == null) {
            return null;
        }
        try {
            return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray));
        } catch (CertificateException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            return null;
        }
    }

    static String makeErrorPayload(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", str);
            jSONObject2.put("description", str2);
            jSONObject.put("error", jSONObject2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", e2.getMessage());
            e2.printStackTrace();
            return "{\"error\":{\"code\": \"BAD_REQUEST_ERROR\", \"description\": \"An unknown error occurred.\"}}";
        }
    }

    static PublicKey constructPublicKey(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes(), 0)));
        } catch (Exception unused) {
            return null;
        }
    }

    private static Boolean isUserRegisteredOnTruePay(Context context) {
        try {
            boolean z = true;
            if (context.getPackageManager().getComponentEnabledSetting(new ComponentName("com.truecaller", "com.truecaller.truepay.UserRegistered")) != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e2) {
            e2.printStackTrace();
            AnalyticsUtil.reportError(e2.getMessage(), "S1", e2.getMessage());
            return Boolean.FALSE;
        }
    }

    static boolean checkUpiRegisteredApp(Context context, String str) {
        str.hashCode();
        if (str.equals("com.google.android.apps.nbu.paisa.user")) {
            return isCompatibleWithGooglePay;
        }
        return true;
    }

    static HashSet<String> getSetOfPackageNamesSupportingUpi(Context context) {
        List<ResolveInfo> listOfAppsWhichHandleDeepLink = getListOfAppsWhichHandleDeepLink(context, "upi://pay");
        HashSet<String> hashSet = new HashSet<>();
        if (listOfAppsWhichHandleDeepLink != null && listOfAppsWhichHandleDeepLink.size() > 0) {
            Iterator<ResolveInfo> it = listOfAppsWhichHandleDeepLink.iterator();
            while (it.hasNext()) {
                try {
                    hashSet.add(it.next().activityInfo.packageName);
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
                }
            }
        }
        if (hashSet.size() > 0 && !checkUpiRegisteredApp(context, "com.google.android.apps.nbu.paisa.user")) {
            hashSet.remove("com.google.android.apps.nbu.paisa.user");
        }
        if (hashSet.size() > 0 && !checkUpiRegisteredApp(context, "com.truecaller")) {
            hashSet.remove("com.truecaller");
        }
        return hashSet;
    }

    static HashSet<String> getSetOfPackageNamesSupportingUpiAutopay(Context context) {
        List<ResolveInfo> listOfAppsWhichHandleDeepLink = getListOfAppsWhichHandleDeepLink(context, "upi://mandate");
        HashSet<String> hashSet = new HashSet<>();
        if (listOfAppsWhichHandleDeepLink != null && listOfAppsWhichHandleDeepLink.size() > 0) {
            Iterator<ResolveInfo> it = listOfAppsWhichHandleDeepLink.iterator();
            while (it.hasNext()) {
                try {
                    hashSet.add(it.next().activityInfo.packageName);
                } catch (Exception e2) {
                    AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
                }
            }
        }
        return hashSet;
    }

    static List<ResolveInfo> getListOfAppsWhichHandleDeepLink(Context context, String str) {
        HashMap map = new HashMap();
        map.put("url", str);
        AnalyticsUtil.trackEvent(AnalyticsEvent.DEVICE_UPI_APPS_DISCOVERY_START, AnalyticsUtil.getJSONResponse(map));
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 131072);
        map.put("deviceApps", getAppPackageNames(listQueryIntentActivities));
        AnalyticsUtil.trackEvent(AnalyticsEvent.DEVICE_UPI_APPS_DISCOVERY_SUCCESS, AnalyticsUtil.getJSONResponse(map));
        return listQueryIntentActivities;
    }

    static List<String> getAppPackageNames(List<ResolveInfo> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().activityInfo.packageName);
            } catch (Exception e2) {
                AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            }
        }
        return arrayList;
    }

    static String getAppNameOfResolveInfo(ResolveInfo resolveInfo, Context context) throws Exception {
        return getAppNameOfPackageName(resolveInfo.activityInfo.packageName, context);
    }

    static void startActivityForResult(String str, String str2, Activity activity) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (str2 != null && !str2.isEmpty()) {
                intent.setPackage(str2);
            }
            if (str.startsWith("credpay")) {
                activity.startActivityForResult(intent, 20);
                return;
            }
            if (str.startsWith("truecallersdk://truesdk")) {
                activity.startActivityForResult(intent, 101);
                return;
            }
            if (str.contains("tngdigital") && "my.com.tngdigital.ewallet".equalsIgnoreCase(str2)) {
                AnalyticsUtil.trackEvent(AnalyticsEvent.SDK_INTENT_WALLET_APP_REDIRECT);
                AnalyticsUtil.addProperty("url", new AnalyticsProperty(str, AnalyticsProperty.Scope.PAYMENT));
                AnalyticsUtil.addProperty("wallet_app_package_name", new AnalyticsProperty(str2, AnalyticsProperty.Scope.PAYMENT));
                AnalyticsUtil.trackEvent(AnalyticsEvent.SDK_TNG_WALLET_APP_FLOW_START);
                activity.startActivity(intent);
                return;
            }
            activity.startActivityForResult(intent, 99);
        } catch (ActivityNotFoundException e2) {
            AnalyticsUtil.reportError("BaseUtils", "S2", e2.getMessage());
        }
    }

    static JSONObject getJSONFromIntentData(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (intent != null && (extras = intent.getExtras()) != null) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, extras.get(str));
                } catch (JSONException e2) {
                    AnalyticsUtil.reportError(e2.getMessage(), "error:exception", e2.getLocalizedMessage());
                }
            }
        }
        return jSONObject;
    }

    static String getBase64FromOtherAppsResource(final Context context, final String str) {
        Future futureSubmit = ICON_EXECUTOR.submit(new Callable() { // from class: com.razorpay.BaseUtils$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BaseUtils.lambda$getBase64FromOtherAppsResource$0(context, str);
            }
        });
        try {
            return (String) futureSubmit.get(2L, TimeUnit.SECONDS);
        } catch (Exception e2) {
            futureSubmit.cancel(true);
            Thread.currentThread().interrupt();
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Execution error while loading icon for " + str + ": " + e2.getLocalizedMessage());
            return null;
        }
    }

    static /* synthetic */ String lambda$getBase64FromOtherAppsResource$0(Context context, String str) throws Exception {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                applicationInfo = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
            } else {
                applicationInfo = packageManager.getApplicationInfo(str, 128);
            }
            return getBase64FromDrawable(packageManager.getResourcesForApplication(applicationInfo), packageManager.getApplicationIcon(str));
        } catch (PackageManager.NameNotFoundException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error loading app icon for " + str + ": " + e2.getLocalizedMessage());
            return null;
        }
    }

    static String getAppNameOfPackageName(String str, Context context) throws Exception {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            int i = applicationInfo.labelRes;
            return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : packageManager.getResourcesForApplication(applicationInfo).getString(i);
        } catch (PackageManager.NameNotFoundException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", "Error loading app name for " + str + ": " + e2.getLocalizedMessage());
            return null;
        }
    }

    static String getBase64FromDrawable(Resources resources, Drawable drawable) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, R.drawable.rzp_logo);
        Boolean bool = Boolean.FALSE;
        if (drawable != null) {
            if (drawable instanceof BitmapDrawable) {
                bitmapDecodeResource = ((BitmapDrawable) drawable).getBitmap();
            } else {
                bitmapDecodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapDecodeResource);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                bool = Boolean.TRUE;
            }
        }
        if (bitmapDecodeResource == null) {
            if (bitmapDecodeResource != null && !bitmapDecodeResource.isRecycled() && bool.booleanValue()) {
                bitmapDecodeResource.recycle();
            }
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapDecodeResource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            String str = "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            if (bitmapDecodeResource != null && !bitmapDecodeResource.isRecycled() && bool.booleanValue()) {
                bitmapDecodeResource.recycle();
            }
            return str;
        } catch (Exception unused) {
            if (bitmapDecodeResource != null && !bitmapDecodeResource.isRecycled() && bool.booleanValue()) {
                bitmapDecodeResource.recycle();
            }
            return null;
        } catch (Throwable th) {
            if (bitmapDecodeResource != null && !bitmapDecodeResource.isRecycled() && bool.booleanValue()) {
                bitmapDecodeResource.recycle();
            }
            throw th;
        }
    }

    static String getBase64FromResource(Resources resources, int i) {
        Drawable drawable;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(resources, i);
        if (bitmapDecodeResource == null && (drawable = resources.getDrawable(i)) != null) {
            if (drawable instanceof BitmapDrawable) {
                bitmapDecodeResource = ((BitmapDrawable) drawable).getBitmap();
            } else {
                bitmapDecodeResource = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapDecodeResource);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
        }
        if (bitmapDecodeResource == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapDecodeResource.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    static Object getJsonValue(String str, JSONObject jSONObject, Object obj) {
        Object jsonValue;
        try {
            jsonValue = getJsonValue(str.split("\\."), jSONObject, 0);
        } catch (Exception unused) {
        }
        return jsonValue != null ? jsonValue : obj;
    }

    static String getType(String str) {
        str.hashCode();
        switch (str) {
            case "gif":
                return "image/gif";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            case "png":
                return MimeTypes.IMAGE_PNG;
            default:
                return "application/octet-stream";
        }
    }

    static void openPdfFile(Activity activity, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uri, "application/pdf");
            intent.setFlags(1);
            if (activity.getPackageManager().queryIntentActivities(intent, 0).size() > 0) {
                activity.startActivity(intent);
            } else {
                Toast.makeText(activity, "No app found to open PDF", 1).show();
            }
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
        }
    }

    static void openFile(Activity activity, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(1);
            if (!activity.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
                activity.startActivity(intent);
            } else {
                Toast.makeText(activity, "No app found to open PDF", 1).show();
            }
        } catch (ActivityNotFoundException e2) {
            e2.getMessage();
        }
    }

    static void pdfDownloadHelper(Activity activity, String str, String str2) {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = activity.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(Base64.decode(str2, 0));
            fileOutputStreamOpenFileOutput.close();
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
        try {
            Uri uriForFile = FileProvider.getUriForFile(activity, activity.getApplicationContext().getPackageName(), new File(activity.getFilesDir().toString() + MqttTopic.TOPIC_LEVEL_SEPARATOR + str + ".pdf"));
            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.TITLE", str);
            intent.setDataAndType(uriForFile, "application/pdf");
            intent.putExtra("android.provider.extra.INITIAL_URI", Uri.parse("/Documents"));
            activity.startActivityForResult(intent, 77);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private static Object getJsonValue(String[] strArr, Object obj, int i) {
        while (i != strArr.length) {
            String str = strArr[i];
            if (obj instanceof JSONObject) {
                obj = ((JSONObject) obj).opt(str);
            } else {
                if (!(obj instanceof JSONArray)) {
                    return null;
                }
                JSONArray jSONArray = (JSONArray) obj;
                if (!TextUtils.isDigitsOnly(str)) {
                    return null;
                }
                obj = jSONArray.opt(Integer.parseInt(str));
            }
            i++;
        }
        return obj;
    }

    static String getRandomString() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    static String getFileFromInternal(Activity activity, String str, String str2) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(activity.openFileInput(getVersionedAssetName(getLocalVersion(activity, str2).toString(), str)), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            } else {
                bufferedReader.close();
                return decryptFile(sb.toString());
            }
        }
    }

    static String decryptFile(String str) {
        try {
            return new CryptLib().decrypt(str, CryptLib.SHA256("rzpisunitedred", 32), "glorygloryunited");
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getLocalizedMessage());
            e2.getMessage();
            return null;
        }
    }

    static String getVersionedAssetName(String str, String str2) {
        return str.replaceAll("\\.", "-") + "-" + str2;
    }

    static String getLocalVersion(Activity activity, String str) {
        String value = SharedPreferenceUtil.getValue(activity, str);
        return value == null ? getVersionFromJsonString("{\n  \"hash\" : \"c4171614448e750850bd4daca2c7e8d1\",\n  \"magic_hash\": \"e1ff492228196aa72f4892db1e05624e\"\n}\n", str) : value;
    }

    static String getVersionFromJsonString(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str2.equalsIgnoreCase("otpelf_version")) {
                return jSONObject.getString(HashElement.ELEMENT);
            }
            if (str2.equalsIgnoreCase("magic_version")) {
                return jSONObject.getString("magic_hash");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    static void updateLocalVersion(Activity activity, String str, String str2) {
        SharedPreferenceUtil.setValue(activity, str, str2);
    }

    static boolean storeFileInInternal(Activity activity, String str, String str2) {
        try {
            FileOutputStream fileOutputStreamOpenFileOutput = activity.openFileOutput(str, 0);
            fileOutputStreamOpenFileOutput.write(str2.getBytes());
            fileOutputStreamOpenFileOutput.close();
            return true;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S1", "Error in saving file: " + str);
            return false;
        }
    }

    static void checkForLatestVersion(Context context, int i) {
        if (CoreConfig.getInstance().isSDKUpdateAlertEnabled() && isMerchantAppDebuggable(context) && i < CoreConfig.getInstance().getLatestSDKVersionCode()) {
            Toast.makeText(context, CoreConfig.getInstance().getUpdateSDKMsg(), 1).show();
        }
    }

    static int dpToPixels(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    static int getDisplayWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    static int getDisplayHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    static HashMap<String, String> getMapFromJSONObject(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", e2.getMessage());
            return map;
        }
    }

    static void setCompatibleWithGooglePay(boolean z) {
        isCompatibleWithGooglePay = z;
    }

    static String makeUrlEncodedPayload(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            sb.append(String.format("%s=%s&", next, Uri.encode(jSONObject.getString(next))));
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    static String installedApps(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(0)) {
                if ((applicationInfo.flags & 1) == 0) {
                    if (sb.length() != 0) {
                        sb.append(Constants.SEPARATOR_COMMA);
                    }
                    sb.append(applicationInfo.packageName);
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "Apps not available";
        }
    }

    static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    static String getDisplayResolution(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return String.format(Locale.ENGLISH, "%dx%dx%d", Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.densityDpi));
    }

    static long getTotalRamMB(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem / 1048576;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", "Error getting total RAM");
            return -1L;
        }
    }

    static long getFreeRamMB(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1048576;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", "Error getting free RAM");
            return -1L;
        }
    }

    static int getCpuCores() {
        try {
            return Runtime.getRuntime().availableProcessors();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", "Error getting CPU cores");
            return -1;
        }
    }

    static boolean isPowerSaveMode(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", "Error checking power save mode");
            return false;
        }
    }

    static int getBatteryLevel(Context context) {
        try {
            if (context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) == null) {
                return -1;
            }
            return (int) ((r3.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) / r3.getIntExtra(CropImage.SCALE, -1)) * 100.0f);
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", "Error getting battery level");
            return -1;
        }
    }

    static boolean isCharging(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null) {
                return false;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "error:exception", "Error checking charging status");
            return false;
        }
    }

    String getSystemFontSize(Context context) {
        return String.valueOf(context.getResources().getConfiguration().fontScale);
    }

    private boolean isMocked(Context context, Location location) {
        return location.isFromMockProvider();
    }

    static boolean isNetworkRoaming(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.isNetworkRoaming();
        }
        return false;
    }

    static String getCarrierOperatorName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return PERMISSION_DISABLED;
    }

    static Map<String, String> getDeviceAttributes(Context context) {
        HashMap map = new HashMap();
        if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            context.getSystemService("phone");
            map.put("device_id", BaseConfig.getAdvertisingId(context));
            map.put("sim_serial_number", PERMISSION_DISABLED);
            map.put("build_unique_id", UUID.randomUUID().toString());
        } else {
            map.put("device_id", PERMISSION_DISABLED);
            map.put("sim_serial_number", PERMISSION_DISABLED);
        }
        map.put("device_manufacturer", Build.MANUFACTURER);
        map.put("device_model", Build.MODEL);
        return map;
    }

    static String getWifiSSID(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            return ((WifiManager) context.getApplicationContext().getSystemService(Constants.CLTAP_CONNECTED_TO_WIFI)).getConnectionInfo().getSSID();
        }
        return PERMISSION_DISABLED;
    }

    static String buildSerial() {
        return Build.SERIAL;
    }

    static void fetchIP(final RzpJSONCallback rzpJSONCallback) {
        new Thread(new Runnable() { // from class: com.razorpay.BaseUtils.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[Catch: Exception -> 0x007c, PHI: r2
              0x005f: PHI (r2v5 ??) = (r2v22 ??), (r2v23 ??) binds: [B:20:0x005d, B:24:0x0073] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x007c, blocks: (B:9:0x0043, B:27:0x0078, B:28:0x007b, B:21:0x005f), top: B:33:0x0005 }] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v16 */
            /* JADX WARN: Type inference failed for: r2v18 */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v2, types: [javax.net.ssl.HttpsURLConnection] */
            /* JADX WARN: Type inference failed for: r2v20 */
            /* JADX WARN: Type inference failed for: r2v21 */
            /* JADX WARN: Type inference failed for: r2v22 */
            /* JADX WARN: Type inference failed for: r2v23 */
            /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r2v4 */
            /* JADX WARN: Type inference failed for: r2v5, types: [javax.net.ssl.HttpsURLConnection] */
            /* JADX WARN: Type inference failed for: r2v6 */
            /* JADX WARN: Type inference failed for: r2v7 */
            /* JADX WARN: Type inference failed for: r2v8 */
            /* JADX WARN: Type inference failed for: r2v9 */
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
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.lang.Throwable {
                /*
                    r6 = this;
                    java.lang.String r0 = "S2"
                    java.lang.String r1 = "error"
                    r2 = 0
                    java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51 java.net.SocketTimeoutException -> L63
                    java.lang.String r4 = "https://approvals-api.getsimpl.com/my-ip"
                    r3.<init>(r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51 java.net.SocketTimeoutException -> L63
                    java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51 java.net.SocketTimeoutException -> L63
                    javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51 java.net.SocketTimeoutException -> L63
                    java.lang.String r2 = "GET"
                    r3.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    r2 = 150(0x96, float:2.1E-43)
                    r3.setReadTimeout(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    r2 = 250(0xfa, float:3.5E-43)
                    r3.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    int r2 = r3.getResponseCode()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    r4 = 200(0xc8, float:2.8E-43)
                    if (r2 != r4) goto L33
                    org.json.JSONObject r2 = com.razorpay.BaseUtils.access$000(r3)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    com.razorpay.RzpJSONCallback r4 = r1     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    r4.onResponse(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    goto L41
                L33:
                    com.razorpay.RzpJSONCallback r2 = r1     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    r4.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    org.json.JSONObject r4 = r4.put(r1, r1)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                    r2.onResponse(r4)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a java.net.SocketTimeoutException -> L4d
                L41:
                    if (r3 == 0) goto L88
                    r3.disconnect()     // Catch: java.lang.Exception -> L7c
                    return
                L47:
                    r1 = move-exception
                    r2 = r3
                    goto L76
                L4a:
                    r1 = move-exception
                    r2 = r3
                    goto L52
                L4d:
                    r2 = r3
                    goto L63
                L4f:
                    r1 = move-exception
                    goto L76
                L51:
                    r1 = move-exception
                L52:
                    java.lang.String r3 = r1.getMessage()     // Catch: java.lang.Throwable -> L4f
                    java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L4f
                    com.razorpay.AnalyticsUtil.reportError(r3, r0, r1)     // Catch: java.lang.Throwable -> L4f
                    if (r2 == 0) goto L88
                L5f:
                    r2.disconnect()     // Catch: java.lang.Exception -> L7c
                    goto L88
                L63:
                    com.razorpay.RzpJSONCallback r3 = r1     // Catch: java.lang.Throwable -> L4f
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4f
                    r4.<init>()     // Catch: java.lang.Throwable -> L4f
                    java.lang.String r5 = "timeout"
                    org.json.JSONObject r1 = r4.put(r1, r5)     // Catch: java.lang.Throwable -> L4f
                    r3.onResponse(r1)     // Catch: java.lang.Throwable -> L4f
                    if (r2 == 0) goto L88
                    goto L5f
                L76:
                    if (r2 == 0) goto L7b
                    r2.disconnect()     // Catch: java.lang.Exception -> L7c
                L7b:
                    throw r1     // Catch: java.lang.Exception -> L7c
                L7c:
                    r1 = move-exception
                    java.lang.String r2 = r1.getMessage()
                    java.lang.String r1 = r1.getMessage()
                    com.razorpay.AnalyticsUtil.reportError(r2, r0, r1)
                L88:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.razorpay.BaseUtils.AnonymousClass2.run():void");
            }
        }).start();
    }

    static void getDeviceParamValues(final Context context, final RzpJSONCallback rzpJSONCallback) {
        final JSONObject jSONObject = new JSONObject();
        try {
            fetchIP(new RzpJSONCallback() { // from class: com.razorpay.BaseUtils.3
                @Override // com.razorpay.RzpJSONCallback
                public void onResponse(JSONObject jSONObject2) {
                    try {
                        if (jSONObject2.getString("ip") != null) {
                            BaseUtils.ipAddress = jSONObject2.getString("ip");
                        }
                    } catch (JSONException unused) {
                    }
                }
            });
            AdvertisingIdUtil.getId(context, new AdvertisingIdUtil.AdvertisingIdCallback() { // from class: com.razorpay.BaseUtils.4
                @Override // com.razorpay.AdvertisingIdUtil.AdvertisingIdCallback
                public void onResult(String str) {
                    try {
                        jSONObject.put("advertising_id", str);
                        jSONObject.put("is_roming", BaseUtils.isNetworkRoaming(context));
                        jSONObject.put("carrier_network", BaseUtils.getCarrierOperatorName(context));
                        jSONObject.put("carrier_id", com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID);
                        Map<String, String> deviceAttributes = BaseUtils.getDeviceAttributes(context);
                        jSONObject.put("device_Id", deviceAttributes.get("device_Id"));
                        jSONObject.put("device_manufacturer", deviceAttributes.get("device_manufacturer"));
                        jSONObject.put("device_model", deviceAttributes.get("device_model"));
                        jSONObject.put("serial_number", BaseUtils.buildSerial());
                        jSONObject.put(Const.LAST_IP_ADDRESS, BaseUtils.ipAddress);
                        jSONObject.put("wifi_ssid", BaseUtils.getWifiSSID(context));
                        jSONObject.put("android_id", BaseUtils.getAndroidId(context));
                        jSONObject.put("safety_net basic_integrity", "true");
                        jSONObject.put("safety_net_cts_profile_match", com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID);
                        rzpJSONCallback.onResponse(jSONObject);
                    } catch (JSONException e2) {
                        AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
                    }
                }
            });
        } catch (Exception e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S2", e2.getMessage());
        }
    }

    static void getSignalStrength(Context context) {
        ((TelephonyManager) context.getSystemService("phone")).listen(new MyPhoneStateListener(), 256);
    }

    public static class MyPhoneStateListener extends PhoneStateListener {
        public int signalStrengthValue;

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (signalStrength.isGsm()) {
                if (signalStrength.getGsmSignalStrength() != 99) {
                    this.signalStrengthValue = (signalStrength.getGsmSignalStrength() << 1) - 113;
                    return;
                } else {
                    this.signalStrengthValue = signalStrength.getGsmSignalStrength();
                    return;
                }
            }
            this.signalStrengthValue = signalStrength.getCdmaDbm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject getResponseJson(HttpsURLConnection httpsURLConnection) throws JSONException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line);
            } else {
                bufferedReader.close();
                return new JSONObject(sb.toString());
            }
        }
    }

    static String getGenericPaymentErrorResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", "BAD_REQUEST_ERROR");
            jSONObject.put("description", str);
            jSONObject.put("source", "customer");
            jSONObject.put("step", "payment_authentication");
            jSONObject.put("reason", "payload_error");
            return new JSONObject().put("error", jSONObject).toString();
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            return null;
        }
    }

    static String getGenericPaymentErrorResponse(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", "BAD_REQUEST_ERROR");
            jSONObject.put("description", str2);
            jSONObject.put("source", "customer");
            jSONObject.put("step", "payment_authentication");
            jSONObject.put("reason", new JSONObject().put("code", str).put("description", str2));
            if (str3 != null) {
                jSONObject.put("metadata", new JSONObject(str3));
            }
            return new JSONObject().put("error", jSONObject).toString();
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            return null;
        }
    }

    static String getGenericPaymentErrorResponse(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", "BAD_REQUEST_ERROR");
            jSONObject.put("description", str);
            jSONObject.put("source", "customer");
            jSONObject.put("step", "payment_authentication");
            jSONObject.put("reason", "payment_error");
            if (str2 != null) {
                jSONObject.put("metadata", new JSONObject(str2));
            }
            return new JSONObject().put("error", jSONObject).toString();
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            return null;
        }
    }

    static String getPaymentCancelledResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", "BAD_REQUEST_ERROR");
            jSONObject.put("description", "You may have cancelled the payment or there was a delay in response from the UPI app");
            jSONObject.put("source", "customer");
            jSONObject.put("step", "payment_authentication");
            jSONObject.put("reason", "payment_cancelled");
            if (str != null) {
                if (str.startsWith("pay")) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("payment_id", str);
                    jSONObject.put("metadata", jSONObject2);
                } else {
                    jSONObject.put("metadata", new JSONObject(str));
                }
            }
            return new JSONObject().put("error", jSONObject).toString();
        } catch (JSONException e2) {
            AnalyticsUtil.reportError(e2.getMessage(), "S0", e2.getLocalizedMessage());
            return null;
        }
    }

    public static boolean checkGpayCardsUpiRegistered(Activity activity, String str) {
        if (str == null) {
            return isGpayCardsUpiRegistered;
        }
        try {
            String string = new JSONObject(str).getString("code");
            if (string.hashCode() == -1534821982 && string.equals("google_pay")) {
                return isGpayCardsUpiRegistered;
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    static void setIsGpayCardsUpiRegistered(boolean z) {
        isGpayCardsUpiRegistered = z;
    }

    static boolean isAppInstalled(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
                return true;
            }
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
