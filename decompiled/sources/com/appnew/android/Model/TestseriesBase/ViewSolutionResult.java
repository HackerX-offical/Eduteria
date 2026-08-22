package com.appnew.android.Model.TestseriesBase;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ViewSolutionResult implements Serializable {

    @SerializedName(Const.ANSWER)
    @Expose
    private String answer;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_bookmarked")
    @Expose
    private String is_bookmarked;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("option_1")
    @Expose
    private String option1;

    @SerializedName("option_10")
    @Expose
    private String option10;

    @SerializedName("option_11")
    @Expose
    private String option11;

    @SerializedName("option_12")
    @Expose
    private String option12;

    @SerializedName("option_13")
    @Expose
    private String option13;

    @SerializedName("option_14")
    @Expose
    private String option14;

    @SerializedName("option_15")
    @Expose
    private String option15;

    @SerializedName("option_2")
    @Expose
    private String option2;

    @SerializedName("option_3")
    @Expose
    private String option3;

    @SerializedName("option_4")
    @Expose
    private String option4;

    @SerializedName("option_5")
    @Expose
    private String option5;

    @SerializedName("option_6")
    @Expose
    private String option6;

    @SerializedName("option_7")
    @Expose
    private String option7;

    @SerializedName("option_8")
    @Expose
    private String option8;

    @SerializedName("option_9")
    @Expose
    private String option9;

    @SerializedName(Const.QUESTION)
    @Expose
    private String question;

    @SerializedName("question_type")
    @Expose
    private String questionType;

    @SerializedName("section_title")
    @Expose
    private String sectionTitle;

    @SerializedName(Const.SUBJECT_ID)
    @Expose
    private String subjectId;

    @SerializedName("total_attempt")
    @Expose
    private String totalAttempt;

    @SerializedName("total_right")
    @Expose
    private String totalRight;

    @SerializedName("total_wrong")
    @Expose
    private String totalWrong;

    @SerializedName("user_answer")
    @Expose
    private String userAnswer;

    public String getSectionTitle() {
        return this.sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOption5() {
        return this.option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getTotalAttempt() {
        return this.totalAttempt;
    }

    public void setTotalAttempt(String totalAttempt) {
        this.totalAttempt = totalAttempt;
    }

    public String getTotalRight() {
        return this.totalRight;
    }

    public void setTotalRight(String totalRight) {
        this.totalRight = totalRight;
    }

    public String getTotalWrong() {
        return this.totalWrong;
    }

    public void setTotalWrong(String totalWrong) {
        this.totalWrong = totalWrong;
    }

    public String getUserAnswer() {
        return this.userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getOption6() {
        return this.option6;
    }

    public void setOption6(String option6) {
        this.option6 = option6;
    }

    public String getOption7() {
        return this.option7;
    }

    public void setOption7(String option7) {
        this.option7 = option7;
    }

    public String getOption8() {
        return this.option8;
    }

    public void setOption8(String option8) {
        this.option8 = option8;
    }

    public String getOption9() {
        return this.option9;
    }

    public void setOption9(String option9) {
        this.option9 = option9;
    }

    public String getOption10() {
        return this.option10;
    }

    public void setOption10(String option10) {
        this.option10 = option10;
    }

    public String getOption11() {
        return this.option11;
    }

    public void setOption11(String option11) {
        this.option11 = option11;
    }

    public String getOption12() {
        return this.option12;
    }

    public void setOption12(String option12) {
        this.option12 = option12;
    }

    public String getOption13() {
        return this.option13;
    }

    public void setOption13(String option13) {
        this.option13 = option13;
    }

    public String getOption14() {
        return this.option14;
    }

    public void setOption14(String option14) {
        this.option14 = option14;
    }

    public String getOption15() {
        return this.option15;
    }

    public void setOption15(String option15) {
        this.option15 = option15;
    }

    public String getIs_bookmark() {
        return this.is_bookmarked;
    }

    public void setIs_bookmark(String is_bookmark) {
        this.is_bookmarked = is_bookmark;
    }
}
