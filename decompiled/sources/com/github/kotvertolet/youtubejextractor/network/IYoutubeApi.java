package com.github.kotvertolet.youtubejextractor.network;

import com.appnew.android.Utils.Const;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes7.dex */
public interface IYoutubeApi {
    @GET("embed/{videoId}")
    Call<ResponseBody> getEmbeddedVideoPage(@Path("videoId") String str);

    @Streaming
    @GET
    Call<ResponseBody> getStream(@Url String str);

    @GET("get_video_info")
    Call<ResponseBody> getVideoInfo(@Query(Const.VIDEO_ID) String str, @Query("eurl") String str2);

    @Headers({"accept-language: en-US"})
    @GET("watch")
    Call<ResponseBody> getVideoPage(@Query("v") String str, @Query("gl") String str2, @Query("has_verified") int i, @Query("bpctr") String str3);

    @GET
    Call<ResponseBody> getWebPage(@Url String str);
}
