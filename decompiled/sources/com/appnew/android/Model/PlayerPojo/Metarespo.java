package com.appnew.android.Model.PlayerPojo;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.socket.engineio.client.transports.Polling;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Metarespo {

    @SerializedName("feedback_auto_trigger_time")
    @Expose
    String feedback_auto_trigger_time;

    @SerializedName("feedback_min_watch_time")
    @Expose
    String feedback_min_watch_time;

    @SerializedName("review_sumbitted")
    @Expose
    String review_sumbitted;

    @SerializedName(Const.PDF)
    @Expose
    private List<Pdf> pdf = null;

    @SerializedName(Polling.EVENT_POLL)
    @Expose
    private List<Polldata> poll = null;

    @SerializedName(FirebaseAnalytics.Param.INDEX)
    @Expose
    private List<VideoTimeFramePojo> index = null;

    @SerializedName("bookmark")
    @Expose
    private List<VideoTimeFramePojo> bookmark = null;

    @SerializedName("video")
    @Expose
    private Video video = null;
    private LiveChat live_chat = null;

    public LiveChat getLive_chat() {
        return this.live_chat;
    }

    public void setLive_chat(LiveChat live_chat) {
        this.live_chat = live_chat;
    }

    public Video getVideo() {
        return this.video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public List<Pdf> getPdf() {
        return this.pdf;
    }

    public void setPdf(List<Pdf> pdf) {
        this.pdf = pdf;
    }

    public List<Polldata> getPoll() {
        return this.poll;
    }

    public void setPoll(List<Polldata> poll) {
        this.poll = poll;
    }

    public List<VideoTimeFramePojo> getIndex() {
        return this.index;
    }

    public void setIndex(List<VideoTimeFramePojo> index) {
        this.index = index;
    }

    public List<VideoTimeFramePojo> getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(List<VideoTimeFramePojo> bookmark) {
        this.bookmark = bookmark;
    }

    public String getReview_sumbitted() {
        return this.review_sumbitted;
    }

    public void setReview_sumbitted(String review_sumbitted) {
        this.review_sumbitted = review_sumbitted;
    }

    public String getFeedback_min_watch_time() {
        return this.feedback_min_watch_time;
    }

    public void setFeedback_min_watch_time(String feedback_min_watch_time) {
        this.feedback_min_watch_time = feedback_min_watch_time;
    }

    public String getFeedback_auto_trigger_time() {
        return this.feedback_auto_trigger_time;
    }

    public void setFeedback_auto_trigger_time(String feedback_auto_trigger_time) {
        this.feedback_auto_trigger_time = feedback_auto_trigger_time;
    }
}
