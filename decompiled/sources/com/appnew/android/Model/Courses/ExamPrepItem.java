package com.appnew.android.Model.Courses;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class ExamPrepItem implements Serializable {

    @SerializedName(Const.LAYER)
    @Expose
    private String layer;

    @SerializedName("list")
    @Expose
    private ArrayList<Lists> list;

    @SerializedName(Const.Study_Analytics)
    @Expose
    private StudyAnalytics studyAnalytics;

    public String getLayer() {
        return this.layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public ArrayList<Lists> getList() {
        return this.list;
    }

    public void setList(ArrayList<Lists> list) {
        this.list = list;
    }

    public StudyAnalytics getStudyAnalytics() {
        return this.studyAnalytics;
    }

    public void setStudyAnalytics(StudyAnalytics studyAnalytics) {
        this.studyAnalytics = studyAnalytics;
    }
}
