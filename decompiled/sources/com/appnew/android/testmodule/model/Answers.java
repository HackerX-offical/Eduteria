package com.appnew.android.testmodule.model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Answers implements Serializable {
    String answerBookmark;
    private int answerPosition;
    ArrayList<String> answers;
    String config_id;
    String index;
    private String is_topic_enabled;
    String on_screen;
    String section_id;
    String section_question_behaviour;
    ArrayList<String> selectedString;
    ArrayList<Integer> selectedValue;
    String state;
    String subject_id;
    private String topic_id;
    private String topic_name;
    String user_answer;
    String is_bookmarked = "0";
    private boolean isanswer = false;
    private String answer = "1";

    public String getAnswerBookmark() {
        return this.answerBookmark;
    }

    public void setAnswerBookmark(String answerBookmark) {
        this.answerBookmark = answerBookmark;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getConfig_id() {
        return this.config_id;
    }

    public void setConfig_id(String config_id) {
        this.config_id = config_id;
    }

    public String getSection_id() {
        return this.section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
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

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public ArrayList<String> getSelectedString() {
        return this.selectedString;
    }

    public void setSelectedString(ArrayList<String> selectedString) {
        this.selectedString = selectedString;
    }

    public ArrayList<Integer> getSelectedValue() {
        return this.selectedValue;
    }

    public void setSelectedValue(ArrayList<Integer> selectedValue) {
        this.selectedValue = selectedValue;
    }

    public String getOn_screen() {
        return this.on_screen;
    }

    public void setOn_screen(String on_screen) {
        this.on_screen = on_screen;
    }

    public boolean isIsanswer() {
        return this.isanswer;
    }

    public void setIsanswer(boolean isanswer) {
        this.isanswer = isanswer;
    }

    public int getAnswerPosition() {
        return this.answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public String getUser_answer() {
        return this.user_answer;
    }

    public void setUser_answer(String user_answer) {
        this.user_answer = user_answer;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSection_question_behaviour() {
        return this.section_question_behaviour;
    }

    public void setSection_question_behaviour(String section_question_behaviour) {
        this.section_question_behaviour = section_question_behaviour;
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
}
