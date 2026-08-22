package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Detail implements Serializable {
    private String accuracy;
    private String attempt;
    private String correct;
    private String guess;
    private String incorrect;
    private String percentage;
    private String score;
    private String time;
    private String total_marks;
    private String total_question_in_part;

    public String getTotal_question_in_part() {
        return this.total_question_in_part;
    }

    public void setTotal_question_in_part(String total_question_in_part) {
        this.total_question_in_part = total_question_in_part;
    }

    public String getCorrect() {
        return this.correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getIncorrect() {
        return this.incorrect;
    }

    public void setIncorrect(String incorrect) {
        this.incorrect = incorrect;
    }

    public String getGuess() {
        return this.guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getAttempt() {
        return this.attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public String getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getTotal_marks() {
        return this.total_marks;
    }

    public void setTotal_marks(String total_marks) {
        this.total_marks = total_marks;
    }

    public String getPercentage() {
        return this.percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
