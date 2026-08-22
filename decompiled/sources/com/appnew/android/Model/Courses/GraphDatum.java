package com.appnew.android.Model.Courses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tv9news.utils.helpers.AnalyticsConstants;

/* JADX INFO: loaded from: classes6.dex */
public class GraphDatum {

    @SerializedName("marks")
    @Expose
    private Float marks;

    @SerializedName(AnalyticsConstants.test_name)
    @Expose
    private String testName;

    public String getTestName() {
        return this.testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Float getMarks() {
        return this.marks;
    }

    public void setMarks(Float marks) {
        this.marks = marks;
    }
}
