package com.appnew.android.Model.TestseriesBase;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionDump implements Serializable {

    @SerializedName(Const.ANSWER)
    @Expose
    private String answer;

    @SerializedName(Const.GUESS)
    @Expose
    private String guess;

    @SerializedName(Const.ONSCREEN)
    @Expose
    private String onscreen;

    @SerializedName(Const.PART)
    @Expose
    private String part;

    @SerializedName(Const.QUESTIONID)
    @Expose
    private String questionId;

    @SerializedName(Const.ISMARKFORREVIEW)
    @Expose
    private String review;

    @SerializedName("section_id")
    @Expose
    private String sectionId;

    public String getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getGuess() {
        return this.guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getOnscreen() {
        return this.onscreen;
    }

    public void setOnscreen(String onscreen) {
        this.onscreen = onscreen;
    }

    public String getPart() {
        return this.part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
