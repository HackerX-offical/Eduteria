package com.appnew.android.Utils.Network.retrofit;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.Network.API;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: loaded from: classes6.dex */
public interface VideoDetailApiInterface {
    @FormUrlEncoded
    @POST("data_model/video/video_comment/add_comment")
    Call<JsonObject> addVideoComment(@Field("user_id") String USER_ID, @Field(Const.VIDEO_ID) String VIDEO_ID, @Field("comment") String COMMENT);

    @FormUrlEncoded
    @POST("data_model/video/video_comment/add_comment")
    Call<JsonObject> addVideoCommentList(@Field("user_id") String USER_ID, @Field(Const.VIDEO_ID) String VIDEO_ID, @Field(Const.PARENT_ID) String PARENT_ID, @Field("comment") String COMMENT);

    @FormUrlEncoded
    @POST("data_model/video/Video_channel/add_video_counter")
    Call<JsonObject> addViewVideo(@Field("user_id") String userid, @Field(Const.VIDEO_ID) String VIDEO_ID);

    @FormUrlEncoded
    @POST("data_model/video/video_comment/dislike_video_comment")
    Call<JsonObject> dislikeVideoComment(@Field("user_id") String userid, @Field(Const.COMMENT_ID) String comment_id);

    @FormUrlEncoded
    @POST("data_model/video/Video_like/dislike_video")
    Call<JsonObject> dislikeVideoData(@Field("user_id") String userid, @Field(Const.VIDEO_ID) String VIDEO_ID);

    @FormUrlEncoded
    @POST("data_model/video/video_comment/get_video_comment")
    Call<JsonObject> getSingleVideoComment(@Field("user_id") String user_id, @Field(Const.VIDEO_ID) String VIDEO_ID, @Field("last_comment_id") String LAST_VIDEO_COMMENT_ID);

    @FormUrlEncoded
    @POST("data_model/video/video_comment/get_video_comment")
    Call<JsonObject> getSingleVideoCommmentList(@Field("user_id") String user_id, @Field(Const.VIDEO_ID) String VIDEO_ID, @Field(Const.PARENT_ID) String PARENT_ID, @Field("last_comment_id") String LAST_VIDEO_COMMENT_ID);

    @FormUrlEncoded
    @POST(API.API_GET_SINGLE_VIDEO_DATA2)
    Call<JsonObject> getSingleVideoData(@Field("user_id") String userid, @Field(Const.VIDEO_ID) String VIDEO_ID);

    @FormUrlEncoded
    @POST("data_model/video/Video_channel/add_solution_video_counter")
    Call<JsonObject> getVideoSolutionCounter(@Field("user_id") String userid, @Field(Const.VIDEO_ID) String video_id);

    @FormUrlEncoded
    @POST("data_model/video/video_comment/like_video_comment")
    Call<JsonObject> likeVideoComment(@Field("user_id") String userid, @Field(Const.COMMENT_ID) String comment_id);

    @FormUrlEncoded
    @POST("data_model/video/Video_like/like_video")
    Call<JsonObject> likeVideoData(@Field("user_id") String userid, @Field(Const.VIDEO_ID) String VIDEO_ID);

    @FormUrlEncoded
    @POST("data_model/fanwall/fan_wall/on_request_create_video_link")
    Call<JsonObject> requestVideoLink(@Field("name") String name);
}
