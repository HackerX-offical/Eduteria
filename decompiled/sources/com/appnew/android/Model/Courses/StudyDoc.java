package com.appnew.android.Model.Courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class StudyDoc {

    @SerializedName("course_topic_master_id")
    @Expose
    private String courseTopicMasterId;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("pdf_data")
    @Expose
    private ArrayList<PdfDatum> pdfData = null;

    @SerializedName("sub_stream_id")
    @Expose
    private String subStreamId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseTopicMasterId() {
        return this.courseTopicMasterId;
    }

    public void setCourseTopicMasterId(String courseTopicMasterId) {
        this.courseTopicMasterId = courseTopicMasterId;
    }

    public String getSubStreamId() {
        return this.subStreamId;
    }

    public void setSubStreamId(String subStreamId) {
        this.subStreamId = subStreamId;
    }

    public ArrayList<PdfDatum> getPdfData() {
        return this.pdfData;
    }

    public void setPdfData(ArrayList<PdfDatum> pdfData) {
        this.pdfData = pdfData;
    }
}
