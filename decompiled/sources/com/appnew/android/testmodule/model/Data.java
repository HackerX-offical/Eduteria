package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Data implements Serializable {
    private String activeQues;

    @SerializedName("lastSection")
    @Expose
    private String lastSection;
    List<Questions2> question_response;

    @SerializedName("test_basic")
    @Expose
    private TestBasic testBasic;

    @SerializedName("user_details")
    @Expose
    private UserInfo userDetails;

    @SerializedName("test_sections")
    @Expose
    private List<TestSection> testSections = null;

    @SerializedName(Const.QUESTION_REPORT_OPTION)
    @Expose
    private List<QuesReportOption> questionReportOptions = null;

    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;

    @SerializedName("questions_hindi")
    @Expose
    private List<Question> questionsHindi = null;

    @SerializedName("questions_gujrati")
    @Expose
    private List<Question> questions_gujrati = null;

    @SerializedName("questions_marathi")
    @Expose
    private List<Question> questions_marathi = null;

    @SerializedName("questions_kannada")
    @Expose
    private List<Question> questions_kannada = null;

    @SerializedName("questions_urdu")
    @Expose
    private List<Question> questions_urdu = null;

    @SerializedName("questions_uriya")
    @Expose
    private List<Question> questions_uriya = null;

    @SerializedName("questions_bangauli")
    @Expose
    private List<Question> questions_bangauli = null;

    @SerializedName("questions_assami")
    @Expose
    private List<Question> questions_assami = null;

    @SerializedName("resume_dump")
    @Expose
    private ResumeDump resume_dump = null;
    private List<QuestionDump> questionDump = null;

    public String getLastSection() {
        return this.lastSection;
    }

    public void setLastSection(String lastSection) {
        this.lastSection = lastSection;
    }

    public List<Question> getQuestions_kannada() {
        return this.questions_kannada;
    }

    public void setQuestions_kannada(List<Question> questions_kannada) {
        this.questions_kannada = questions_kannada;
    }

    public List<Question> getQuestions_urdu() {
        return this.questions_urdu;
    }

    public void setQuestions_urdu(List<Question> questions_urdu) {
        this.questions_urdu = questions_urdu;
    }

    public List<Question> getQuestions_uriya() {
        return this.questions_uriya;
    }

    public void setQuestions_uriya(List<Question> questions_uriya) {
        this.questions_uriya = questions_uriya;
    }

    public List<Question> getQuestions_bangauli() {
        return this.questions_bangauli;
    }

    public void setQuestions_bangauli(List<Question> questions_bangauli) {
        this.questions_bangauli = questions_bangauli;
    }

    public List<Question> getQuestions_assami() {
        return this.questions_assami;
    }

    public void setQuestions_assami(List<Question> questions_assami) {
        this.questions_assami = questions_assami;
    }

    public List<Question> getQuestions_gujrati() {
        return this.questions_gujrati;
    }

    public void setQuestions_gujrati(List<Question> questions_gujrati) {
        this.questions_gujrati = questions_gujrati;
    }

    public List<Question> getQuestions_marathi() {
        return this.questions_marathi;
    }

    public void setQuestions_marathi(List<Question> questions_marathi) {
        this.questions_marathi = questions_marathi;
    }

    public void setQuestionDump(List<QuestionDump> questionDump) {
        this.questionDump = questionDump;
    }

    public List<Questions2> getQuestion_response() {
        return this.question_response;
    }

    public void setQuestion_response(List<Questions2> question_response) {
        this.question_response = question_response;
    }

    public ResumeDump getResume_dump() {
        return this.resume_dump;
    }

    public void setResume_dump(ResumeDump resume_dump) {
        this.resume_dump = resume_dump;
    }

    public String getActiveQues() {
        return this.activeQues;
    }

    public void setActiveQues(String activeQues) {
        this.activeQues = activeQues;
    }

    public UserInfo getUserDetails() {
        return this.userDetails;
    }

    public void setUserDetails(UserInfo userDetails) {
        this.userDetails = userDetails;
    }

    public TestBasic getTestBasic() {
        return this.testBasic;
    }

    public void setTestBasic(TestBasic testBasic) {
        this.testBasic = testBasic;
    }

    public List<TestSection> getTestSections() {
        return this.testSections;
    }

    public void setTestSections(List<TestSection> testSections) {
        this.testSections = testSections;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestionsHindi() {
        return this.questionsHindi;
    }

    public void setQuestionsHindi(List<Question> questionsHindi) {
        this.questionsHindi = questionsHindi;
    }

    public List<QuestionDump> getQuestionDump() {
        return this.questionDump;
    }

    public List<QuesReportOption> getQuestionReportOptions() {
        return this.questionReportOptions;
    }

    public void setQuestionReportOptions(List<QuesReportOption> questionReportOptions) {
        this.questionReportOptions = questionReportOptions;
    }
}
