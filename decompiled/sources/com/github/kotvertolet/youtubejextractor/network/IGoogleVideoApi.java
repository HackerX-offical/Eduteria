package com.github.kotvertolet.youtubejextractor.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes7.dex */
public interface IGoogleVideoApi {
    @GET("timedtext")
    Call<ResponseBody> getSubtitles(@Query("type") String str, @Query("v") String str2, @Query("lang") String str3);
}
