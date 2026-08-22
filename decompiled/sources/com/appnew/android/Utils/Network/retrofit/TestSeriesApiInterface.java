package com.appnew.android.Utils.Network.retrofit;

import com.appnew.android.Utils.Const;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes6.dex */
public interface TestSeriesApiInterface {
    @FormUrlEncoded
    @POST("data_model/courses/custom_qbank/get_test_series_result")
    Call<JsonObject> getCustomViewSolutionData(@Field("user_id") String userid);

    @FormUrlEncoded
    @POST("data_model/courses/test_series/get_test_series_result")
    Call<JsonObject> getViewSolutionData(@Field("user_id") String userid, @Field(Const.TESTSEGMENT_ID) String test_segment_id);
}
