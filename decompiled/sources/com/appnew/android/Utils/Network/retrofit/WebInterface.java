package com.appnew.android.Utils.Network.retrofit;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Network.API;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes6.dex */
public interface WebInterface {
    @POST(API.API_GET_BASIC_COURSE)
    Call<String> API_GET_BASIC_COURSE(@Body String data);

    @POST(API.API_GET_BASIC_COURSE)
    Call<String> API_GET_BASIC_COURSE1(@Body String data);

    @POST(API.API_GET_BASIC_COURSE)
    Call<String> API_GET_BASIC_COURSE2(@Body String data);

    @FormUrlEncoded
    @POST(API.API_GET_COMPLETE_INFO_TEST_SERIES)
    Call<JsonObject> API_GET_COMPLETE_INFO_TEST_SERIES(@Field("user_id") String USER_ID, @Field(Const.TESTSERIES_ID) String TESTSERIES_ID);

    @POST(API.API_GET_MASTER_DATA)
    Call<String> API_GET_CONCEPT_DATA_FIRST(@Body String data);

    @POST(API.API_GET_MASTER_DATA)
    Call<String> API_GET_CONCEPT_DATA_FIRST1(@Body String data);

    @FormUrlEncoded
    @POST
    Call<JsonObject> API_GET_FEEDS_FOR_USER(@Url String url, @Field("user_id") String USER_ID);

    @FormUrlEncoded
    @POST
    Call<JsonObject> API_GET_FEEDS_FOR_USER(@Url String url, @Field("user_id") String USER_ID, @Field(Const.LAST_POST_ID) String LAST_POST_ID, @Field(Const.SEARCH_TEXT) String SEARCH_TEXT);

    @FormUrlEncoded
    @POST
    Call<JsonObject> API_GET_FEEDS_FOR_USER(@Url String url, @Field("user_id") String USER_ID, @Field(Const.LAST_POST_ID) String LAST_POST_ID, @Field(Const.TAG_ID) String TAG_ID, @Field(Const.SUBJECT_ID) String SUBJECT_ID, @Field(Const.SEARCH_TEXT) String SEARCH_TEXT);

    @POST(API.API_GET_MASTER_DATA)
    Call<String> API_GET_PRACTICE_DATA_FIRST(@Body String data);

    @FormUrlEncoded
    @POST(API.API_GET_SINGLE_CAT_VIDEO_DATA)
    Call<JsonObject> API_GET_SINGLE_CAT_VIDEO_DATA(@Field("user_id") String USER_ID, @Field(Const.SUB_CAT) String SUB_CAT, @Field(Const.LAST_VIDEO_ID) String LAST_VIDEO_ID, @Field(Const.SORT_BY) String SORT_BY, @Field(Const.PAGE_SEGMENT) String PAGE_SEGMENT, @Field(Const.SEARCH_CONTENT) String SEARCH_CONTENT);

    @FormUrlEncoded
    @POST(API.API_SUBJECTIVE_QUESTIONS)
    Call<JsonObject> API_GET_SUBJECTIVE_QUESTIONS(@Field("test_id") String TEST_ID, @Field("user_id") String userid);

    @POST(API.API_GET_MASTER_DATA)
    Call<String> API_GET_TEST_DATA_FIRST(@Body String data);

    @FormUrlEncoded
    @POST(API.API_GET_TOPIC_DATA_FIRST)
    Call<JsonObject> API_GET_TOPIC_DATA_FIRST(@Field(Const.SUBJECT_ID) String CHAPTER_ID, @Field("course_id") String COURSE_ID);

    @FormUrlEncoded
    @POST(API.API_GET_UNIT_DATA_FIRST)
    Call<JsonObject> API_GET_UNIT_DATA_FIRST(@Field(Const.SUBJECT_ID) String SUBJECT_ID, @Field("course_id") String COURSE_ID);

    @POST(API.API_GET_MASTER_DATA)
    Call<String> API_GET_VIDEO_DATA_FIRST(@Body String data);

    @POST(API.API_GET_MASTER_DATA)
    Call<String> API_GET_VIDEO_DATA_FIRST2(@Body String data);

    @POST("https://appapi.videocrypt.in/index.php/data_model/payment/free_transaction")
    Call<String> API_MAKE_FREE_COURSE_TRANSACTION(@Body String data);

    @FormUrlEncoded
    @POST(API.API_REQUEST_TEST_DATA)
    Call<JsonObject> API_REQUEST_TEST_DATA(@Field("user_id") String USER_ID, @Field(Const.VIDEO_ID) String VIDEO_ID);

    @POST(API.API_REQUEST_VIDEO_LINK)
    Call<String> API_REQUEST_VIDEO_LINK(@Body String data);

    @POST(API.API_REQUEST_VIDEO_LINK_V2)
    Call<String> API_REQUEST_VIDEO_LINK_V2(@Body String data);

    @FormUrlEncoded
    @POST(API.API_SEND_ROLL_NO_POST)
    Call<JsonObject> API_SEND_ROLL_NO_POST(@Field("user_id") String USER_ID, @Field(Const.ROLL_NO) String ROLL_NO, @Field("campaign_id") String COMPAIGN_ID);

    @FormUrlEncoded
    @POST(API.API_UPDATE_DEVICE_TOKEN)
    Call<JsonObject> API_UPDATE_DEVICE_TOKEN(@Field(Const.DEVICE_TYPE) String DEVICE_TYPE, @Field(Const.DEVICE_TOKEN) String DEVICE_TOKEN);

    @POST(API.API_UPDATE_VIDEO_VIEW)
    Call<String> API_UPDATE_VIDEO_VIEW(@Body String data);

    @FormUrlEncoded
    @POST(API.API_BOOKMARK)
    Call<JsonObject> API_USER_BOOKMARK(@Field("id") String ID, @Field(Const.VIDEO_ID) String VIDEO_ID, @Field("time") String TIME, @Field("info") String INFO, @Field("for") String STATE);

    @FormUrlEncoded
    @POST(API.API_subjective_result)
    Call<JsonObject> Submitanswer(@Field("user_id") String userid);

    @FormUrlEncoded
    @POST(API.API_SUBJECTIVE_SUBMIT)
    Call<JsonObject> Submitanswer(@Field("test_id") String TEST_ID, @Field("user_id") String userid, @Field(Const.ANSWERS) String answers);

    @FormUrlEncoded
    @POST(API.API_GET_SINGLE_VIDEO_DATA)
    Call<JsonObject> getSingleVideoData(@Field("user_id") String USER_ID, @Field(Const.VIDEO_ID) String VIDEO_ID);
}
