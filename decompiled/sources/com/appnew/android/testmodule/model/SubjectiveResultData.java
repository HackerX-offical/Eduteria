package com.appnew.android.testmodule.model;

import com.appnew.android.Model.DiscussionVideo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class SubjectiveResultData implements Serializable {

    @SerializedName("marks")
    @Expose
    private String marks;

    @SerializedName("rank")
    @Expose
    private String rank;

    @SerializedName("remarks")
    @Expose
    private String remarks;

    @SerializedName("result_id")
    @Expose
    private String resultId;

    @SerializedName("solutions")
    @Expose
    private String solutions;

    @SerializedName("test_series_name")
    @Expose
    private String testSeriesName;

    @SerializedName("top_rankers")
    @Expose
    private List<TopRanker> topRankers = null;

    @SerializedName("total_marks")
    @Expose
    private String totalMarks;

    @SerializedName("discussion_video")
    @Expose
    private DiscussionVideo video;

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public DiscussionVideo getVideo() {
        return this.video;
    }

    public void setVideo(DiscussionVideo video) {
        this.video = video;
    }

    public String getSolutions() {
        return this.solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }

    public String getTestSeriesName() {
        return this.testSeriesName;
    }

    public void setTestSeriesName(String testSeriesName) {
        this.testSeriesName = testSeriesName;
    }

    public String getTotalMarks() {
        return this.totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getResultId() {
        return this.resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getRank() {
        return this.rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<TopRanker> getTopRankers() {
        return this.topRankers;
    }

    public void setTopRankers(List<TopRanker> topRankers) {
        this.topRankers = topRankers;
    }
}
