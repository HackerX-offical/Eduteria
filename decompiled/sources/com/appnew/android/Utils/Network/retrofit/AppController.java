package com.appnew.android.Utils.Network.retrofit;

import android.text.TextUtils;
import androidx.multidex.MultiDexApplication;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.SharedPreference;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
public class AppController extends MultiDexApplication {
    static String id;

    public static <S> S getRetrofitInstance(Class<S> cls) {
        OkHttpClient.Builder timeout = new OkHttpClient.Builder().connectTimeout(60L, TimeUnit.MINUTES).readTimeout(60L, TimeUnit.MINUTES);
        if (SharedPreference.getInstance().getLoggedInUser() != null && SharedPreference.getInstance().getLoggedInUser().getId() != null) {
            id = SharedPreference.getInstance().getLoggedInUser().getId();
        } else {
            id = "0";
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl("https://appapi.videocrypt.in/").addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create())).client(timeout.addInterceptor(httpLoggingInterceptor).connectTimeout(60L, TimeUnit.MINUTES).readTimeout(60L, TimeUnit.MINUTES).writeTimeout(1L, TimeUnit.MINUTES).build()).build();
        timeout.addInterceptor(new Interceptor() { // from class: com.appnew.android.Utils.Network.retrofit.AppController.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request().newBuilder().addHeader(Const.USERID, AppController.id).addHeader(Const.DEVICETOKEN, !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.FIREBASE_TOKEN_ID)) ? SharedPreference.getInstance().getString(Const.FIREBASE_TOKEN_ID) : "utkarsh_device").addHeader(Const.Jwt, !TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.JWT)) ? SharedPreference.getInstance().getString(Const.JWT) : "").addHeader(Const.LANG, String.valueOf(SharedPreference.getInstance().getInt(Const.LANGUAGE))).build());
            }
        });
        return (S) retrofitBuild.create(cls);
    }
}
