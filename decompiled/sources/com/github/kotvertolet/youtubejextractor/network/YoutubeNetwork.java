package com.github.kotvertolet.youtubejextractor.network;

import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes7.dex */
public class YoutubeNetwork {
    private static final String YOUTUBE_SITE_URL = "https://www.youtube.com/";
    private IYoutubeApi youtubeApi;

    public YoutubeNetwork(Gson gson) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);
        builder.addInterceptor(new UserAgentInterceptor());
        this.youtubeApi = (IYoutubeApi) new Retrofit.Builder().baseUrl(YOUTUBE_SITE_URL).client(builder.build()).addConverterFactory(GsonConverterFactory.create(gson)).build().create(IYoutubeApi.class);
    }

    public YoutubeNetwork(Gson gson, OkHttpClient okHttpClient) {
        this.youtubeApi = (IYoutubeApi) new Retrofit.Builder().baseUrl(YOUTUBE_SITE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build().create(IYoutubeApi.class);
    }

    public Response<ResponseBody> getYoutubeVideoInfo(String str, String str2) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(this.youtubeApi.getVideoInfo(str, str2));
    }

    public Response<ResponseBody> getYoutubeEmbeddedVideoPage(String str) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(this.youtubeApi.getEmbeddedVideoPage(str));
    }

    public Response<ResponseBody> getYoutubeVideoPage(String str) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(this.youtubeApi.getVideoPage(str, "US", 1, "9999999999"));
    }

    public Response<ResponseBody> downloadWebpage(String str) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(this.youtubeApi.getWebPage(str));
    }

    public Response<ResponseBody> getStream(String str) throws YoutubeRequestException {
        return new RequestExecutor().executeWithRetry(this.youtubeApi.getStream(str));
    }
}
