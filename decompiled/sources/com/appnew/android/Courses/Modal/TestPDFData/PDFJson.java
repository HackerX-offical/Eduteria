package com.appnew.android.Courses.Modal.TestPDFData;

import com.appnew.android.Model.CoursePDF;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class PDFJson implements Serializable {

    @SerializedName("bg_color")
    @Expose
    private String bg_color;

    @SerializedName("font_color")
    @Expose
    private String font_color;

    @SerializedName("list")
    @Expose
    private ArrayList<CoursePDF> pdf_list = null;

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

    public ArrayList<CoursePDF> getPdf_list() {
        return this.pdf_list;
    }

    public void setPdf_list(ArrayList<CoursePDF> pdf_list) {
        this.pdf_list = pdf_list;
    }
}
