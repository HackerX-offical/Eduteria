package com.appnew.android.Model.PlayerPojo;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DoubtItemData implements Serializable {
    String app_id;
    String image;
    String is_upVoted;
    String position;
    String upvotes;
    String video_id;

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getUpvotes() {
        return this.upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIs_upVoted() {
        return this.is_upVoted;
    }

    public void setIs_upVoted(String is_upVoted) {
        this.is_upVoted = is_upVoted;
    }
}
