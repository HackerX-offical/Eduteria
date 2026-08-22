package com.appnew.android.Webview.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionArray implements Serializable {
    private String id;
    private String option;
    private String question;
    private String questionType;

    public QuestionArray(String id, String question, String questionType, String option) {
        this.id = id;
        this.question = question;
        this.questionType = questionType;
        this.option = option;
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

    public String getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
