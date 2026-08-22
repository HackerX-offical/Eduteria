package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class SendUserData implements Serializable {
    String answer;
    String id;
    String name;
    String timeleft;

    public SendUserData(String name, String id, String timetaken, String answer) {
        this.name = name;
        this.id = id;
        this.timeleft = timetaken;
        this.answer = answer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeleft() {
        return this.timeleft;
    }

    public void setTimeleft(String timeleft) {
        this.timeleft = timeleft;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
