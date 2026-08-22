package com.appnew.android.Model.videoTimeUpdate;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class Data {

    @SerializedName("course_id")
    @Expose
    private String courseId;

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    @Expose
    private String created;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName(StoreProvider.StoreData.MODIFIED_DATE)
    @Expose
    private String modified;

    @SerializedName("time_left")
    @Expose
    private String timeLeft;

    @SerializedName(Const.TOTAL_TIME)
    @Expose
    private String totalTime;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName(Const.VIDEO_ID)
    @Expose
    private String videoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getTimeLeft() {
        return this.timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return this.modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
