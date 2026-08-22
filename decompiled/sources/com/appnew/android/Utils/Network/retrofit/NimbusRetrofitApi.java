package com.appnew.android.Utils.Network.retrofit;

import com.appnew.android.Login.Pojo.NimbusLogin;
import com.appnew.android.Model.VideoRes;
import com.appnew.android.Utils.Network.API;
import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes6.dex */
public interface NimbusRetrofitApi {
    @FormUrlEncoded
    @POST(API.API_GET_SINGLE_VIDEO_DATA2)
    Call<List<VideoRes>> getVideoResponse(@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("nimbus_user_verification")
    Call<NimbusLogin> signinWithNimbus(@FieldMap HashMap<String, String> map);
}
