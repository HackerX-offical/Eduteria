package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionDump implements Serializable {

    @SerializedName(Const.ANSWER)
    @Expose
    private String answer;

    @SerializedName("answerBookmark")
    @Expose
    private String answerBookmark;

    @SerializedName("answerPosition")
    @Expose
    private String answerPosition;

    @SerializedName(Const.CONFIG_ID)
    @Expose
    private String configId;

    @SerializedName(Const.GUESS)
    @Expose
    private String guess;

    @SerializedName(FirebaseAnalytics.Param.INDEX)
    @Expose
    private String index;

    @SerializedName(Const.ISCORRECT)
    @Expose
    private Integer isCorrect;

    @SerializedName("is_bookmarked")
    @Expose
    private String is_bookmarked;

    @SerializedName("on_screen")
    @Expose
    private int on_screen;

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

    @SerializedName("section_question_behaviour")
    @Expose
    private String section_question_behaviour;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName(Const.SUBJECT_ID)
    @Expose
    private String subjectId;
    private boolean isanswer = false;

    @SerializedName(Const.ANSWERS)
    @Expose
    private ArrayList<String> answers = null;

    @SerializedName("selectedValue")
    @Expose
    private ArrayList<Integer> selectedValue = null;

    @SerializedName("selectedString")
    @Expose
    private ArrayList<String> selectedString = null;

    public boolean isIsanswer() {
        return this.isanswer;
    }

    public void setIsanswer(boolean isanswer) {
        this.isanswer = isanswer;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public int getOn_screen() {
        return this.on_screen;
    }

    public void setOn_screen(int on_screen) {
        this.on_screen = on_screen;
    }

    public String getAnswerPosition() {
        return this.answerPosition;
    }

    public void setAnswerPosition(String answerPosition) {
        this.answerPosition = answerPosition;
    }

    public String getAnswerBookmark() {
        return this.answerBookmark;
    }

    public void setAnswerBookmark(String answerBookmark) {
        this.answerBookmark = answerBookmark;
    }

    public String getSection_question_behaviour() {
        return this.section_question_behaviour;
    }

    public void setSection_question_behaviour(String section_question_behaviour) {
        this.section_question_behaviour = section_question_behaviour;
    }

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

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(ArrayList<String> answers) {
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(Integer isCorrect) {
        this.isCorrect = isCorrect;
    }

    public ArrayList<Integer> getSelectedValue() {
        return this.selectedValue;
    }

    public void setSelectedValue(ArrayList<Integer> selectedValue) {
        this.selectedValue = selectedValue;
    }

    public ArrayList<String> getSelectedString() {
        return this.selectedString;
    }

    public void setSelectedString(ArrayList<String> selectedString) {
        this.selectedString = selectedString;
    }
}
