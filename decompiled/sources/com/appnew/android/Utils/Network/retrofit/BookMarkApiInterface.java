package com.appnew.android.Utils.Network.retrofit;

import com.appnew.android.Utils.Const;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes6.dex */
public interface BookMarkApiInterface {
    @FormUrlEncoded
    @POST("data_model/fanwall/Fan_wall/get_question_bookmark_by_subject")
    Call<JsonObject> allSubjectBookmark(@Field("user_id") String userid, @Field(Const.SUBJECT_ID) String subject_id, @Field("last_id") String last_post_id);

    @FormUrlEncoded
    @POST("data_model/fanwall/Fan_wall/bookmark_category_list")
    Call<JsonObject> getbookmarkcategories(@Field("user_id") String userid, @Field("type") String type, @Field("stream") String stream);

    @FormUrlEncoded
    @POST("data_model/fanwall/Fan_wall/bookmark_list")
    Call<JsonObject> getbookmarklist(@Field("user_id") String userid, @Field("type") String type, @Field("stream") String stream, @Field(Const.LAST_POST_ID) String last_post_id, @Field(Const.TAG_ID) String tag_id, @Field(Const.SEARCH_TEXT) String search_text);

    @FormUrlEncoded
    @POST("data_model/fanwall/fan_wall/remove_bookmark")
    Call<JsonObject> removeBookmark(@Field("user_id") String userid, @Field(Const.QUESTIONID) String questionId);

    @FormUrlEncoded
    @POST("data_model/fanwall/Fan_wall/single_question_bookmark")
    Call<JsonObject> singleQuestionData(@Field("user_id") String userid, @Field(Const.QUESTIONID) String question_id);
}
