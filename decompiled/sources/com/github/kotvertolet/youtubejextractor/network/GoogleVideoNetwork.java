package com.github.kotvertolet.youtubejextractor.network;

import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes7.dex */
public class GoogleVideoNetwork {
    private static final String BASE_URL = "https://video.google.com/";
    private IGoogleVideoApi googleVideoApi;

    public GoogleVideoNetwork(Gson gson) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(new UserAgentInterceptor());
        this.googleVideoApi = (IGoogleVideoApi) new Retrofit.Builder().baseUrl(BASE_URL).client(builder.build()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(IGoogleVideoApi.class);
    }

    public Response<ResponseBody> getSubtitlesList(String str) throws IOException {
        return this.googleVideoApi.getSubtitles("list", str, null).execute();
    }

    public Response<ResponseBody> getSubtitles(String str, String str2) throws IOException {
        return this.googleVideoApi.getSubtitles("track", str, str2).execute();
    }
}
