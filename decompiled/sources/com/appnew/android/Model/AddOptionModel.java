package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class AddOptionModel implements Serializable {
    String answer;
    boolean isThisAnswerRight;
    String option;

    public AddOptionModel(String option, String answer, boolean isThisAnswerRight) {
        this.option = option;
        this.answer = answer;
        this.isThisAnswerRight = isThisAnswerRight;
    }

    public String getOption() {
        return this.option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isThisAnswerRight() {
        return this.isThisAnswerRight;
    }

    public void setThisAnswerRight(boolean thisAnswerRight) {
        this.isThisAnswerRight = thisAnswerRight;
    }
}
