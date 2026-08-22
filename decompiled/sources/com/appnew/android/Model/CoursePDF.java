package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CoursePDF implements Serializable {

    @SerializedName(Const.CREATION_TIME)
    @Expose
    private String creationTime;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_downloadable")
    @Expose
    private String is_downloadable;

    @SerializedName("page_count")
    @Expose
    private String pageCount;

    @SerializedName("pdf_thumbnail")
    @Expose
    private String pdfThumbnail;

    @SerializedName("pdf_title")
    @Expose
    private String pdfTitle;

    @SerializedName("pdf_url")
    @Expose
    private String pdfUrl;

    @SerializedName(Const.VIDEO_ID)
    @Expose
    private String videoId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getPdfTitle() {
        return this.pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return this.pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPdfThumbnail() {
        return this.pdfThumbnail;
    }

    public void setPdfThumbnail(String pdfThumbnail) {
        this.pdfThumbnail = pdfThumbnail;
    }

    public String getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getIs_downloadable() {
        return this.is_downloadable;
    }

    public void setIs_downloadable(String is_downloadable) {
        this.is_downloadable = is_downloadable;
    }
}
