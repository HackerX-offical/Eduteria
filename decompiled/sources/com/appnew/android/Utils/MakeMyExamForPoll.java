package com.appnew.android.Utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.appnew.android.Utils.Network.API;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
public class MakeMyExamForPoll extends MultiDexApplication {
    private static Context appContext = null;
    private static Retrofit retrofit = null;
    private static MakeMyExamForPoll singleton = null;
    public static String userId = "0";

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId2) {
        userId = userId2;
    }

    public static MakeMyExamForPoll getInstance() {
        if (singleton == null) {
            singleton = new MakeMyExamForPoll();
        }
        return singleton;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        appContext = this;
        singleton = this;
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
    }

    public static Retrofit getRetrofitInstance(String url) {
        if (SharedPreference.getInstance().getLoggedInUser() != null && !TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getId())) {
            setUserId(SharedPreference.getInstance().getLoggedInUser().getId());
        } else {
            userId = "0";
        }
        Retrofit retrofit3 = retrofit;
        if (retrofit3 != null) {
            return retrofit3;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() { // from class: com.appnew.android.Utils.MakeMyExamForPoll$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return chain.proceed(chain.request().newBuilder().header(Const.GET_DIVISION, Helper.getDivisionID() != null ? Helper.getDivisionID() : "0").header(Const.GET_SUB_DIVISION, Helper.getSubDivisionID() != null ? Helper.getSubDivisionID() : "0").header(Const.MOBILE, Helper.getUserMobile() != null ? Helper.getUserMobile() : "").header(Const.USERID, MakeMyExamForPoll.getUserId() != null ? MakeMyExamForPoll.getUserId() : "0").header(Const.DEVICE_TYPE, "1").header("Theme", "1").header(Const.Jwt, !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.JWT)) ? SharedPreference.getInstance().getString(Const.JWT) : "").removeHeader("User-Agent").addHeader("User-Agent", "okhttp/4.9.1").header(Const.LANG, String.valueOf(SharedPreference.getInstance().getInt(Const.LANGUAGE))).header("Version", TextUtils.isEmpty(SharedPreference.getInstance().getString("Version")) ? "" : SharedPreference.getInstance().getString("Version")).addHeader("Authorization", API.Bearer).addHeader(Const.APP_ID, SharedPreference.getInstance().getString(Const.APP_ID)).build());
            }
        }).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).build();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(httpLoggingInterceptor);
        Retrofit retrofitBuild = new Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl(url).client(builder.build()).build();
        retrofit = retrofitBuild;
        return retrofitBuild;
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        MultiDex.install(this);
        super.attachBaseContext(base);
    }
}
