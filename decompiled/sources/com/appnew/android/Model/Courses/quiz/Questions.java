package com.appnew.android.Model.Courses.quiz;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Questions implements Serializable {
    private String answer;
    private String description;
    private String difficulty_level;
    private String duration;
    private String id;
    private String marks;
    private String negative_marks;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private String option_5;
    private String question;
    private String question_type;
    private String status;
    private String subject_id;
    private String subject_name;
    private String topic_id;
    private String user_answer;
    private boolean answered = false;
    private ArrayList<String> userAnswered = new ArrayList<>();

    public ArrayList<String> getUserAnswered() {
        return this.userAnswered;
    }

    public void setUserAnswered(ArrayList<String> userAnswered) {
        this.userAnswered = userAnswered;
    }

    public String getUser_answer() {
        return this.user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

    public boolean isAnswered() {
        return this.answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public String getSubject_name() {
        return this.subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getQuestion_type() {
        return this.question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public String getOption_2() {
        return this.option_2;
    }

    public void setOption_2(String option_2) {
        this.option_2 = option_2;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOption_3() {
        return this.option_3;
    }

    public void setOption_3(String option_3) {
        this.option_3 = option_3;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getOption_4() {
        return this.option_4;
    }

    public void setOption_4(String option_4) {
        this.option_4 = option_4;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getOption_5() {
        return this.option_5;
    }

    public void setOption_5(String option_5) {
        this.option_5 = option_5;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOption_1() {
        return this.option_1;
    }

    public void setOption_1(String option_1) {
        this.option_1 = option_1;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDifficulty_level() {
        return this.difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getNegative_marks() {
        return this.negative_marks;
    }

    public void setNegative_marks(String negative_marks) {
        this.negative_marks = negative_marks;
    }
}
