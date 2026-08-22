package com.appnew.android.Courses.Modal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class VODTimeDB implements Serializable {
    String courseId;
    String leftTime;
    String tileId;
    String totalTime;
    String type;
    String userId;
    String videoid;

    public VODTimeDB(String userId, String type, String courseId, String videoid, String totalTime, String leftTime, String tileId) {
        this.userId = userId;
        this.type = type;
        this.courseId = courseId;
        this.videoid = videoid;
        this.totalTime = totalTime;
        this.leftTime = leftTime;
        this.tileId = tileId;
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

    public String getVideoid() {
        return this.videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public String getLeftTime() {
        return this.leftTime;
    }

    public void setLeftTime(String leftTime) {
        this.leftTime = leftTime;
    }

    public String getTileId() {
        return this.tileId;
    }

    public void setTileId(String tileId) {
        this.tileId = tileId;
    }
}
