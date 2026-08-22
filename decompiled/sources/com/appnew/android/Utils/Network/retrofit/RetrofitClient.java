package com.appnew.android.Utils.Network.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes6.dex */
public class RetrofitClient {
    private static Retrofit retrofit;

    public static Retrofit getClient(String baseUrl) {
        Retrofit retrofit3 = retrofit;
        if (retrofit3 != null) {
            return retrofit3;
        }
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        retrofit = retrofitBuild;
        return retrofitBuild;
    }

    public static Retrofit getClientV2() {
        Retrofit retrofit3 = retrofit;
        if (retrofit3 != null) {
            return retrofit3;
        }
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl("http://www.online.utkarsh.com").addConverterFactory(GsonConverterFactory.create()).build();
        retrofit = retrofitBuild;
        return retrofitBuild;
    }
}
