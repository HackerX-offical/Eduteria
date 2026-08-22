package com.appnew.android.testmodule.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FIBSelectedTag implements Serializable {
    private String answers;
    private int pos;

    public FIBSelectedTag(int pos, String answers) {
        this.pos = pos;
        this.answers = answers;
    }

    public int getPos() {
        return this.pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getAnswers() {
        return this.answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
