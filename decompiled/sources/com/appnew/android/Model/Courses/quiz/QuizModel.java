package com.appnew.android.Model.Courses.quiz;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class QuizModel implements Serializable {
    private Quiz_Basic_Info basic_info;
    private boolean isResume = false;
    private int quesCount;
    private ArrayList<Questions> question_bank;

    public int getQuesCount() {
        return this.quesCount;
    }

    public void setQuesCount(int quesCount) {
        this.quesCount = quesCount;
    }

    public boolean isResume() {
        return this.isResume;
    }

    public void setResume(boolean resume) {
        this.isResume = resume;
    }

    public ArrayList<Questions> getQuestion_bank() {
        return this.question_bank;
    }

    public void setQuestion_bank(ArrayList<Questions> question_bank) {
        this.question_bank = question_bank;
    }

    public Quiz_Basic_Info getBasic_info() {
        return this.basic_info;
    }

    public void setBasic_info(Quiz_Basic_Info basic_info) {
        this.basic_info = basic_info;
    }
}
