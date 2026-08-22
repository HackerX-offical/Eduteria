package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TestBasic implements Serializable {
    private String allow_user_move;

    @SerializedName("answer_shuffle")
    @Expose
    private String answerShuffle;

    @SerializedName("consider_time")
    @Expose
    private String considerTime;
    private String display_bubble;
    private String display_qid;

    @SerializedName("fail_message")
    @Expose
    private String failMessage;

    @SerializedName("general_message")
    @Expose
    private String generalMessage;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("is_calc_allowed")
    @Expose
    private String isCalcAllowed;

    @SerializedName("pass_message")
    @Expose
    private String passMessage;

    @SerializedName("pass_percentage")
    @Expose
    private String passPercentage;

    @SerializedName("reward_points")
    @Expose
    private String rewardPoints;

    @SerializedName("set_type")
    @Expose
    private String setType;

    @SerializedName("shuffle")
    @Expose
    private String shuffle;

    @SerializedName("test_series_name")
    @Expose
    private String testSeriesName;

    @SerializedName(Const.TEST_TYPE)
    @Expose
    private String testType;

    @SerializedName("test_assets")
    @Expose
    private Test_assets test_assets;

    @SerializedName("time_boundation")
    @Expose
    private String timeBoundation;

    @SerializedName("time_in_mins")
    @Expose
    private String timeInMins;

    @SerializedName("total_marks")
    @Expose
    private String totalMarks;

    @SerializedName("total_questions")
    @Expose
    private String totalQuestions;

    @SerializedName("watermark")
    @Expose
    private String watermark;

    @SerializedName("lang_id")
    @Expose
    private List<String> langId = null;
    private long timeRemaining = 0;

    public String getDisplay_qid() {
        return this.display_qid;
    }

    public void setDisplay_qid(String display_qid) {
        this.display_qid = display_qid;
    }

    public Test_assets getTest_assets() {
        return this.test_assets;
    }

    public void setTest_assets(Test_assets test_assets) {
        this.test_assets = test_assets;
    }

    public long getTimeRemaining() {
        return this.timeRemaining;
    }

    public String getDisplay_bubble() {
        return this.display_bubble;
    }

    public void setDisplay_bubble(String display_bubble) {
        this.display_bubble = display_bubble;
    }

    public void setTimeRemaining(long timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestSeriesName() {
        return this.testSeriesName;
    }

    public void setTestSeriesName(String testSeriesName) {
        this.testSeriesName = testSeriesName;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTestType() {
        return this.testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTotalQuestions() {
        return this.totalQuestions;
    }

    public void setTotalQuestions(String totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public String getConsiderTime() {
        return this.considerTime;
    }

    public void setConsiderTime(String considerTime) {
        this.considerTime = considerTime;
    }

    public String getTimeInMins() {
        return this.timeInMins;
    }

    public void setTimeInMins(String timeInMins) {
        this.timeInMins = timeInMins;
    }

    public String getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getShuffle() {
        return this.shuffle;
    }

    public void setShuffle(String shuffle) {
        this.shuffle = shuffle;
    }

    public String getAnswerShuffle() {
        return this.answerShuffle;
    }

    public void setAnswerShuffle(String answerShuffle) {
        this.answerShuffle = answerShuffle;
    }

    public String getTimeBoundation() {
        return this.timeBoundation;
    }

    public void setTimeBoundation(String timeBoundation) {
        this.timeBoundation = timeBoundation;
    }

    public String getPassMessage() {
        return this.passMessage;
    }

    public void setPassMessage(String passMessage) {
        this.passMessage = passMessage;
    }

    public String getGeneralMessage() {
        return this.generalMessage;
    }

    public void setGeneralMessage(String generalMessage) {
        this.generalMessage = generalMessage;
    }

    public String getFailMessage() {
        return this.failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    public String getPassPercentage() {
        return this.passPercentage;
    }

    public void setPassPercentage(String passPercentage) {
        this.passPercentage = passPercentage;
    }

    public String getRewardPoints() {
        return this.rewardPoints;
    }

    public void setRewardPoints(String rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getSetType() {
        return this.setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public List<String> getLangId() {
        return this.langId;
    }

    public void setLangId(List<String> langId) {
        this.langId = langId;
    }

    public String getIsCalcAllowed() {
        return this.isCalcAllowed;
    }

    public void setIsCalcAllowed(String isCalcAllowed) {
        this.isCalcAllowed = isCalcAllowed;
    }

    public String getWatermark() {
        return this.watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getAllow_user_move() {
        return this.allow_user_move;
    }

    public void setAllow_user_move(String allow_user_move) {
        this.allow_user_move = allow_user_move;
    }

    public static class Test_assets implements Serializable {

        @SerializedName("disable_sec_click")
        @Expose
        private String disable_sec_click;

        @SerializedName("hide_inst_time")
        @Expose
        private String hide_inst_time;

        public String getHide_inst_time() {
            return this.hide_inst_time;
        }

        public void setHide_inst_time(String hide_inst_time) {
            this.hide_inst_time = hide_inst_time;
        }

        public String getDisable_sec_click() {
            return this.disable_sec_click;
        }

        public void setDisable_sec_click(String disable_sec_click) {
            this.disable_sec_click = disable_sec_click;
        }
    }
}
