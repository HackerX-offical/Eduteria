package com.appnew.android.Model.Courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class StudyAnalytics {

    @SerializedName("study_doc")
    @Expose
    private ArrayList<StudyDoc> studyDoc = null;

    @SerializedName("graph_data")
    @Expose
    private ArrayList<GraphDatum> graphData = null;

    public ArrayList<StudyDoc> getStudyDoc() {
        return this.studyDoc;
    }

    public void setStudyDoc(ArrayList<StudyDoc> studyDoc) {
        this.studyDoc = studyDoc;
    }

    public ArrayList<GraphDatum> getGraphData() {
        return this.graphData;
    }

    public void setGraphData(ArrayList<GraphDatum> graphData) {
        this.graphData = graphData;
    }
}
