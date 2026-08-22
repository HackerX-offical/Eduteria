package com.pallycon.exoplayersample.simple.network;

import com.appnew.android.Utils.Const;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes9.dex */
public interface APIinterface {
    public static final String BaseUrl = "https://api.videocrypt.com/getVideoDetailsDrm";
    public static final String prefix = "https://videocrypt.in/index.php/rest_api/courses/course/";

    @FormUrlEncoded
    @Headers({"device-type:1"})
    @POST(BaseUrl)
    Call<ResponseBody> createVideoLink(@Header("device-id") String str, @Header("account-id") String str2, @Header("version") String str3, @Header("device-name") String str4, @Header("user-id") String str5, @Header("secretKey") String str6, @Header("accessKey") String str7, @Field("name") String str8, @Field(Const.FLAG) String str9);

    @FormUrlEncoded
    @Headers({"device_type: 1", "device_id: 123456789", "version:2"})
    @POST("https://videocrypt.in/index.php/rest_api/courses/course/get_video_list")
    Call<ResponseBody> getVideoList(@Field("pagination_offset") String str);
}
