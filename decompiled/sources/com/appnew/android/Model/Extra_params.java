package com.appnew.android.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Extra_params implements Serializable {

    @SerializedName("demo_percent")
    @Expose
    private String demo_percent;

    @SerializedName("feedback_video")
    @Expose
    private String feedback;

    @SerializedName("is_limited")
    @Expose
    private String is_limited;

    @SerializedName("videotoken")
    @Expose
    private String videotoken;

    public String getIs_limited() {
        return this.is_limited;
    }

    public void setIs_limited(String is_limited) {
        this.is_limited = is_limited;
    }

    public String getFeedback() {
        return this.feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDemo_percent() {
        return this.demo_percent;
    }

    public void setDemo_percent(String demo_percent) {
        this.demo_percent = demo_percent;
    }

    public String getVideotoken() {
        return this.videotoken;
    }

    public void setVideotoken(String videotoken) {
        this.videotoken = videotoken;
    }
}
