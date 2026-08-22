package com.appnew.android.Model.TestseriesBase;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Data implements Serializable {

    @SerializedName("active_ques")
    @Expose
    private String activeQues;

    @SerializedName("basic_info")
    @Expose
    private BasicInfo basicInfo;

    @SerializedName("question_bank")
    @Expose
    private List<QuestionBank> questionBank = null;

    @SerializedName("question_dump")
    @Expose
    private List<QuestionDump> questionDump = null;

    @SerializedName(Const.TIME_SPENT)
    @Expose
    private String timeSpent;

    @SerializedName("user_info")
    @Expose
    private UserInfo userInfo;

    public BasicInfo getBasicInfo() {
        return this.basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public List<QuestionBank> getQuestionBank() {
        return this.questionBank;
    }

    public void setQuestionBank(List<QuestionBank> questionBank) {
        this.questionBank = questionBank;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<QuestionDump> getQuestionDump() {
        return this.questionDump;
    }

    public void setQuestionDump(List<QuestionDump> questionDump) {
        this.questionDump = questionDump;
    }

    public String getTimeSpent() {
        return this.timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getActiveQues() {
        return this.activeQues;
    }

    public void setActiveQues(String activeQues) {
        this.activeQues = activeQues;
    }
}
