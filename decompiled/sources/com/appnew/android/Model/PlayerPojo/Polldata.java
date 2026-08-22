package com.appnew.android.Model.PlayerPojo;

import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.StoreProvider;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class Polldata {

    @SerializedName(Const.ANSWER)
    @Expose
    private String answer;

    @SerializedName("attempt_1")
    @Expose
    private Long attempt1;

    @SerializedName("attempt_2")
    @Expose
    private Long attempt2;

    @SerializedName("attempt_3")
    @Expose
    private Long attempt3;

    @SerializedName("attempt_4")
    @Expose
    private Long attempt4;

    @SerializedName(StoreProvider.StoreData.CREATED_DATE)
    @Expose
    private String created;

    @SerializedName("created_by")
    @Expose
    private String createdBy;

    @SerializedName("disable_result")
    @Expose
    private String disable_result;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("isvisible")
    @Expose
    private String isvisible;

    @SerializedName("my_answer")
    @Expose
    private String myAnswer;

    @SerializedName("option_1")
    @Expose
    private String option1;

    @SerializedName("option_2")
    @Expose
    private String option2;

    @SerializedName("option_3")
    @Expose
    private String option3;

    @SerializedName("option_4")
    @Expose
    private String option4;

    @SerializedName(Const.QUESTION)
    @Expose
    private String question;

    @SerializedName("firebase_key")
    @Expose
    private String rendomkey;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("valid_till")
    @Expose
    private String validTill;

    @SerializedName("validity")
    @Expose
    private String validity;

    @SerializedName(Const.VIDEO_ID)
    @Expose
    private String videoId;
    boolean isTImerRunning = false;

    @SerializedName("delay")
    @Expose
    private String delay = "0";

    public String getDelay() {
        return this.delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getRendomkey() {
        return this.rendomkey;
    }

    public void setRendomkey(String rendomkey) {
        this.rendomkey = rendomkey;
    }

    public String getIsvisible() {
        return this.isvisible;
    }

    public void setIsvisible(String isvisible) {
        this.isvisible = isvisible;
    }

    public String getDisable_result() {
        return this.disable_result;
    }

    public void setDisable_result(String disable_result) {
        this.disable_result = disable_result;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return this.option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return this.option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return this.option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return this.option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getValidTill() {
        return this.validTill;
    }

    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Long getAttempt1() {
        return this.attempt1;
    }

    public void setAttempt1(Long attempt1) {
        this.attempt1 = attempt1;
    }

    public Long getAttempt2() {
        return this.attempt2;
    }

    public void setAttempt2(Long attempt2) {
        this.attempt2 = attempt2;
    }

    public Long getAttempt3() {
        return this.attempt3;
    }

    public void setAttempt3(Long attempt3) {
        this.attempt3 = attempt3;
    }

    public Long getAttempt4() {
        return this.attempt4;
    }

    public void setAttempt4(Long attempt4) {
        this.attempt4 = attempt4;
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMyAnswer() {
        return this.myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer;
    }

    public String getValidity() {
        return this.validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
