package com.appnew.android.testmodule.model;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class AnswersResumeResponse implements Serializable {
    ArrayList<String> answers;
    String config_id;
    String index;
    String is_bookmarked;
    int is_correct;
    String on_screen;
    String section_id;
    String state;

    public String getConfig_id() {
        return this.config_id;
    }

    public void setConfig_id(String config_id) {
        this.config_id = config_id;
    }

    public String getIndex() {
        return this.index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getOn_screen() {
        return this.on_screen;
    }

    public void setOn_screen(String on_screen) {
        this.on_screen = on_screen;
    }

    public String getSection_id() {
        return this.section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIs_correct() {
        return this.is_correct;
    }

    public void setIs_correct(int is_correct) {
        this.is_correct = is_correct;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }
}
