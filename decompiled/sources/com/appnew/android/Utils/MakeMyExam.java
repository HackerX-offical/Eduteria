package com.appnew.android.Utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.media3.common.util.Util;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.appnew.android.BuildConfig;
import com.appnew.android.Coupon.Models.CouponPojo;
import com.appnew.android.FacebookEventLogger;
import com.appnew.android.Login.Activity.SplashScreen;
import com.appnew.android.Microsoft.MicrosoftClarity;
import com.appnew.android.Model.Video;
import com.appnew.android.Utils.Network.API;
import com.appnew.android.Utils.SecurityUtils;
import com.appnew.android.Utils.shortcuts.Shortsuts;
import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;
import com.eduteria.app.app.R;
import com.facebook.FacebookSdk;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.firebase.FirebaseApp;
import fr.maxcom.libmedia.Licensing;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
public class MakeMyExam extends MultiDexApplication implements Application.ActivityLifecycleCallbacks {
    public static final String NIGHT_MODE = "NIGHT_MODE";
    private static String TILE_DATA = null;
    private static String TILE_DATA2 = null;
    private static Context appContext = null;
    public static Bitmap bitmap = null;
    public static CouponPojo couponData = null;
    static String id = null;
    public static boolean isDeliveryAddressNeeded = false;
    public static String object = "";
    public static String questionbanklist = "";
    private static Retrofit retrofit = null;
    public static String startTimeOfDrm = "";
    public static long time_server = 0;
    public static String userId = "0";
    public static String username = "";
    private Activity currentActivity;
    private boolean isNightModeEnabled = false;
    protected String userAgent;
    public static ArrayList<Video> videoArrayList = new ArrayList<>();
    public static ArrayList<Video> seleced_tile_list = new ArrayList<>();
    private static MakeMyExam singleton = null;
    public static boolean lvlresponse = true;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.MINUTES).readTimeout(60, TimeUnit.MINUTES);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId2) {
        userId = userId2;
    }

    public static long getTime_server() {
        return time_server;
    }

    public static void setTime_server(long time_server2) {
        time_server = time_server2;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static MakeMyExam getInstance() {
        if (singleton == null) {
            singleton = new MakeMyExam();
        }
        return singleton;
    }

    @Override // android.app.Application
    public void onCreate() {
        ActivityLifecycleCallback.register(this);
        super.onCreate();
        registerActivityLifecycleCallbacks(this);
        Thread.setDefaultUncaughtExceptionHandler(new LocalFileUncaughtExceptionHandler(this, Thread.getDefaultUncaughtExceptionHandler()));
        appContext = this;
        SecurityUtils.INSTANCE.startDisplayWatcher(this, new SecurityUtils.SecurityCallback() { // from class: com.appnew.android.Utils.MakeMyExam.1
            @Override // com.appnew.android.Utils.SecurityUtils.SecurityCallback
            public void onSafe() {
            }

            @Override // com.appnew.android.Utils.SecurityUtils.SecurityCallback
            public void onSecurityRiskDetected(String reason) {
                if (MakeMyExam.this.currentActivity == null) {
                    return;
                }
                Intent intent = new Intent(MakeMyExam.this.getApplicationContext(), (Class<?>) SplashScreen.class);
                intent.addFlags(268468224);
                intent.putExtra("streaming_detected", true);
                intent.putExtra("streaming_reason", reason);
                MakeMyExam.this.startActivity(intent);
            }
        });
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.INFO);
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.VERBOSE);
        if (BuildConfig.FLAVOR.equalsIgnoreCase("DishaPublication")) {
            new MicrosoftClarity().Clarity(this);
        }
        initFacebookEvents();
        FirebaseApp.initializeApp(this);
        SharedPreference.getInstance().putString(Const.APP_ID, "166");
        this.userAgent = Util.getUserAgent(this, appContext.getResources().getString(R.string.app_name));
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
        singleton = this;
        this.isNightModeEnabled = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(NIGHT_MODE, false);
        Licensing.allow(getApplicationContext());
        Licensing.setDeveloperMode(true);
        Shortsuts.INSTANCE.createShortcuts(appContext);
        if (SharedPreference.getInstance().getLoggedInUser() == null) {
            Shortsuts.INSTANCE.updateShortcuts(appContext);
        }
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public static Retrofit getRetrofitInstance() {
        if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null) {
            setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
        } else {
            userId = "0";
        }
        Retrofit retrofit3 = retrofit;
        if (retrofit3 != null) {
            return retrofit3;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() { // from class: com.appnew.android.Utils.MakeMyExam$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return chain.proceed(chain.request().newBuilder().header(Const.GET_DIVISION, Helper.getDivisionID() != null ? Helper.getDivisionID() : "0").header(Const.GET_SUB_DIVISION, Helper.getSubDivisionID() != null ? Helper.getSubDivisionID() : "0").header(Const.MOBILE, Helper.getUserMobile() != null ? Helper.getUserMobile() : "").header(Const.USERID, MakeMyExam.getUserId() != null ? MakeMyExam.getUserId() : "0").header(Const.DEVICE_TYPE, "1").header(Const.Jwt, !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.JWT)) ? SharedPreference.getInstance().getString(Const.JWT) : "").removeHeader("User-Agent").addHeader("User-Agent", "okhttp/4.9.1").header(Const.LANG, String.valueOf(SharedPreference.getInstance().getInt(Const.LANGUAGE))).header("Version", TextUtils.isEmpty(SharedPreference.getInstance().getString("Version")) ? "" : SharedPreference.getInstance().getString("Version")).addHeader("Authorization", API.Bearer).addHeader(Const.APP_ID, SharedPreference.getInstance().getString(Const.APP_ID)).build());
            }
        }).connectTimeout(1L, TimeUnit.MINUTES).readTimeout(1L, TimeUnit.MINUTES).writeTimeout(1L, TimeUnit.MINUTES).build();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(httpLoggingInterceptor);
        Retrofit retrofitBuild = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl("https://appapi.videocrypt.in/").client(builder.build()).build();
        retrofit = retrofitBuild;
        return retrofitBuild;
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.appnew.android.Utils.MakeMyExam.2
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(socketFactory, (X509TrustManager) trustManagerArr[0]);
            builder.hostnameVerifier(new HostnameVerifier() { // from class: com.appnew.android.Utils.MakeMyExam.3
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
        SplitCompat.install(this);
    }

    public static String getTileData() {
        return TILE_DATA;
    }

    public static void setTileData(String tileData) {
        TILE_DATA = tileData;
    }

    public static String getTileData2() {
        return TILE_DATA2;
    }

    public static void setTileData2(String tileData2) {
        TILE_DATA2 = tileData2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Helper.DeveloperOpt(activity);
        this.currentActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.currentActivity = activity;
    }

    private void initFacebookEvents() {
        try {
            FacebookSdk.sdkInitialize(this);
            FacebookSdk.setAutoInitEnabled(true);
            FacebookSdk.setApplicationId(getString(R.string.facebook_app_id));
            FacebookSdk.setClientToken(getString(R.string.facebook_client_token));
            FacebookEventLogger.logFbSdkInitialize(this);
            Bundle bundle = new Bundle();
            bundle.putString("AppStartedEvent_Android", "Init Custom Facebook Events.");
            FacebookEventLogger.logEvent(this, getString(R.string.app_name), bundle);
        } catch (Exception unused) {
        }
    }
}
