package com.pallycon.exoplayersample.simple.network;

import androidx.multidex.MultiDexApplication;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes9.dex */
public class RetrofitClientInstance extends MultiDexApplication {
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().proxy(Proxy.NO_PROXY).connectTimeout(60, TimeUnit.MINUTES).readTimeout(60, TimeUnit.MINUTES);
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            Gson gsonCreate = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClientBuild = httpClient.addInterceptor(httpLoggingInterceptor).connectTimeout(60L, TimeUnit.MINUTES).readTimeout(60L, TimeUnit.MINUTES).writeTimeout(1L, TimeUnit.MINUTES).build();
            new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder().client(okHttpClientBuild).baseUrl("http://videocrypt.in/index.php/").addConverterFactory(GsonConverterFactory.create(gsonCreate)).build();
        }
        retrofit.create(APIinterface.class);
        return retrofit;
    }
}
