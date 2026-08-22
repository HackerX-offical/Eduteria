package com.appnew.android.testmodule.model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Question implements Serializable {

    @SerializedName(Const.CONFIG_ID)
    @Expose
    private String configId;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("font_type")
    @Expose
    private String font_type;

    @SerializedName("id")
    @Expose
    private String id;
    private boolean isMarkForReview;

    @SerializedName("is_topic_enabled")
    @Expose
    private String is_topic_enabled;
    private boolean isanswerRight;
    private boolean issaveMarkForReview;

    @SerializedName("neg_marks")
    @Expose
    private String negMarks;

    @SerializedName("option_1")
    @Expose
    private String option1;

    @SerializedName("option_10")
    @Expose
    private String option10;

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

    @SerializedName("paragraph_text")
    @Expose
    private String paragraphText;

    @SerializedName("po_marks")
    @Expose
    private String posMarks;

    @SerializedName(Const.QUESTION)
    @Expose
    private String question;

    @SerializedName("question_type")
    @Expose
    private String questionType;
    private String right_answer;
    private String right_answer_pos;

    @SerializedName("section_id")
    @Expose
    private String sectionId;
    private String sectionName;

    @SerializedName("section_question_behaviour")
    @Expose
    private String section_question_behaviour;

    @SerializedName("solution_url")
    @Expose
    private String solution_url;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName(Const.SUBJECT_ID)
    @Expose
    private String subjectId;

    @SerializedName(Const.TOPIC_ID)
    @Expose
    private String topic_id;

    @SerializedName("topic_name")
    @Expose
    private String topic_name;
    private String user_answer;
    private String answer = "1";
    private String is_bookmarked = "0";
    private boolean answered = false;
    private int answerPosition = -1;
    private String isCorrect = "";
    private String isguess = "0";
    private String anspositions = "-1";
    private ArrayList<String> answers = new ArrayList<>();
    private int selectedanswerPosition = -1;
    private boolean iswronganswer = false;
    private int wronganswerPosition = -1;
    private int totalTimeSpent = 0;
    private boolean isanswer = false;
    public ArrayList<mcSelection> selcted = new ArrayList<>();
    public ArrayList<mcSelection> selcted2 = new ArrayList<>();
    ArrayList<Integer> selectedValue = new ArrayList<>();
    private Boolean isInstantAnswer = false;
    private boolean isPause = false;
    ArrayList<String> selectedString = new ArrayList<>();
    private int wrongAnswer = -1;

    public String getSectionName() {
        return this.sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getFont_type() {
        return this.font_type;
    }

    public void setFont_type(String font_type) {
        this.font_type = font_type;
    }

    public String getSection_question_behaviour() {
        return this.section_question_behaviour;
    }

    public void setSection_question_behaviour(String section_question_behaviour) {
        this.section_question_behaviour = section_question_behaviour;
    }

    public boolean isIsanswer() {
        return this.isanswer;
    }

    public Boolean getInstantAnswer() {
        return this.isInstantAnswer;
    }

    public void setInstantAnswer(Boolean instantAnswer) {
        this.isInstantAnswer = instantAnswer;
    }

    public String getRight_answer() {
        return this.right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    public String getRight_answer_pos() {
        return this.right_answer_pos;
    }

    public void setRight_answer_pos(String right_answer_pos) {
        this.right_answer_pos = right_answer_pos;
    }

    public String getUser_answer() {
        return this.user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

    public String getSolution_url() {
        return this.solution_url;
    }

    public void setSolution_url(String solution_url) {
        this.solution_url = solution_url;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public boolean isAnswered() {
        return this.answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public int getAnswerPosition() {
        return this.answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public String getAnspositions() {
        return this.anspositions;
    }

    public void setAnspositions(String anspositions) {
        this.anspositions = anspositions;
    }

    public String getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean isPause() {
        return this.isPause;
    }

    public void setPause(boolean pause) {
        this.isPause = pause;
    }

    public int getTotalTimeSpent() {
        return this.totalTimeSpent;
    }

    public void setTotalTimeSpent(int totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    public void setSelcted(ArrayList<mcSelection> selcted) {
        this.selcted = selcted;
    }

    public ArrayList<mcSelection> getSelcted() {
        return this.selcted;
    }

    public void setSelcted2(ArrayList<mcSelection> selcted2) {
        this.selcted2 = selcted2;
    }

    public ArrayList<mcSelection> getSelcted2() {
        return this.selcted2;
    }

    public boolean isanswer() {
        return this.isanswer;
    }

    public void setIsanswer(boolean isanswer, int position, String anspositions, ArrayList answers) {
        this.isanswer = isanswer;
        this.answerPosition = position;
        this.anspositions = anspositions;
        this.answers = answers;
    }

    public void setIsanswer(boolean isanswer, int position, String anspositions) {
        this.isanswer = isanswer;
        this.answerPosition = position;
        this.anspositions = anspositions;
    }

    public void setIsanswer(boolean isanswer, int position, ArrayList answers) {
        this.isanswer = isanswer;
        this.answerPosition = position;
        this.answers = answers;
    }

    public void setIsanswer(boolean isanswer, int position) {
        this.isanswer = isanswer;
        this.answerPosition = position;
    }

    public void setIsanswer(boolean isanswer) {
        this.isanswer = isanswer;
    }

    public void setIswronganswer(boolean iswronganswer, int position) {
        this.iswronganswer = iswronganswer;
        this.wronganswerPosition = position;
    }

    public int getAnswerPosttion() {
        return this.answerPosition;
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

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getAnswerPosttions() {
        return this.anspositions;
    }

    public String getIsguess() {
        return this.isguess;
    }

    public void setIsguess(String isguess) {
        this.isguess = isguess;
    }

    public boolean isIsanswerRight() {
        return this.isanswerRight;
    }

    public void setIsanswerRight(boolean isanswerRight) {
        this.isanswerRight = isanswerRight;
    }

    public boolean isMarkForReview() {
        return this.isMarkForReview;
    }

    public void setMarkForReview(boolean markForReview) {
        this.isMarkForReview = markForReview;
    }

    public boolean isIssaveMarkForReview() {
        return this.issaveMarkForReview;
    }

    public void setIssaveMarkForReview(boolean issaveMarkForReview) {
        this.issaveMarkForReview = issaveMarkForReview;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getConfigId() {
        return this.configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
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

    public String getParagraphText() {
        return this.paragraphText;
    }

    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnswer() {
        return this.answer;
    }

    public int getWrongAnswer() {
        return this.wrongAnswer;
    }

    public void setWrongAnswer(int wrongAnswer) {
        this.wrongAnswer = wrongAnswer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPosMarks() {
        return this.posMarks;
    }

    public void setPosMarks(String posMarks) {
        this.posMarks = posMarks;
    }

    public String getNegMarks() {
        return this.negMarks;
    }

    public void setNegMarks(String negMarks) {
        this.negMarks = negMarks;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getIs_topic_enabled() {
        return this.is_topic_enabled;
    }

    public void setIs_topic_enabled(String is_topic_enabled) {
        this.is_topic_enabled = is_topic_enabled;
    }

    public String getTopic_name() {
        return this.topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public String getColor() {
        if (this.isMarkForReview) {
            return "4";
        }
        int i = this.answerPosition;
        if (i == -1 || !this.isanswer || i == -1) {
            return "3";
        }
        if (this.isanswerRight) {
            return "1";
        }
        return "2";
    }
}
