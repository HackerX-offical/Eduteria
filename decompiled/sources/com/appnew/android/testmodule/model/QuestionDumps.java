package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionDumps implements Serializable {

    @SerializedName(Const.ANSWERS)
    @Expose
    private List<Object> answers = null;

    @SerializedName(Const.CONFIG_ID)
    @Expose
    private String configId;

    @SerializedName(FirebaseAnalytics.Param.INDEX)
    @Expose
    private String index;

    @SerializedName("is_bookmarked")
    @Expose
    private String is_bookmarked;

    @SerializedName("is_challenge")
    @Expose
    private int is_challenge;

    @SerializedName("on_screen")
    @Expose
    private String onScreen;

    @SerializedName("section_id")
    @Expose
    private String sectionId;

    @SerializedName("state")
    @Expose
    private String state;

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public int getIs_challenge() {
        return this.is_challenge;
    }

    public void setIs_challenge(int is_challenge) {
        this.is_challenge = is_challenge;
    }

    public List<Object> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<Object> answers) {
        this.answers = answers;
    }

    public String getConfigId() {
        return this.configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getIndex() {
        return this.index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getOnScreen() {
        return this.onScreen;
    }

    public void setOnScreen(String onScreen) {
        this.onScreen = onScreen;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
