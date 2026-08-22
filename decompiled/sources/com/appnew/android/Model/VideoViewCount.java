package com.appnew.android.Model;

/* JADX INFO: loaded from: classes6.dex */
public class VideoViewCount {
    String user_id;
    String video_id;
    int viewCount;

    public VideoViewCount(String user_id, String video_id, int viewCount) {
        this.user_id = user_id;
        this.video_id = video_id;
        this.viewCount = viewCount;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVideo_id() {
        return this.video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public int getViewCount() {
        return this.viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
