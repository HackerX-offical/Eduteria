package com.appnew.android.Model.TestPDFData;

import com.appnew.android.Model.Courses.quiz.Quiz_Basic_Info;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Subjective implements Serializable {

    @SerializedName("bg_color")
    @Expose
    private String bg_color;

    @SerializedName("font_color")
    @Expose
    private String font_color;

    @SerializedName("test_list")
    @Expose
    private ArrayList<Quiz_Basic_Info> testList = null;

    @SerializedName("title")
    @Expose
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFont_color() {
        return this.font_color;
    }

    public void setFont_color(String font_color) {
        this.font_color = font_color;
    }

    public String getBg_color() {
        return this.bg_color;
    }

    public void setBg_color(String bg_color) {
        this.bg_color = bg_color;
    }

    public ArrayList<Quiz_Basic_Info> getTestList() {
        return this.testList;
    }

    public void setTestList(ArrayList<Quiz_Basic_Info> testList) {
        this.testList = testList;
    }
}
