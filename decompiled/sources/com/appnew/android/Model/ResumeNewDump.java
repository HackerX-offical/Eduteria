package com.appnew.android.Model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ResumeNewDump implements Serializable {
    private List<com.appnew.android.testmodule.model.QuestionDump> question_dump = null;

    public List<com.appnew.android.testmodule.model.QuestionDump> getQuestion_dump() {
        return this.question_dump;
    }

    public void setQuestion_dump(List<com.appnew.android.testmodule.model.QuestionDump> question_dump) {
        this.question_dump = question_dump;
    }
}
