package com.appnew.android.CreateTest.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class QuestionCount implements Serializable {
    private String easy;
    private String hard;
    private String medium;

    public String getEasy() {
        return this.easy;
    }

    public void setEasy(String easy) {
        this.easy = easy;
    }

    public String getMedium() {
        return this.medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getHard() {
        return this.hard;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }
}
