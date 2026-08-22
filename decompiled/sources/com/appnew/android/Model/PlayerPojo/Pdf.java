package com.appnew.android.Model.PlayerPojo;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class Pdf {

    @SerializedName(Const.CREATION_TIME)
    @Expose
    private String creationTime;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_downloadable")
    @Expose
    private String isDownloadable;

    @SerializedName("is_share")
    @Expose
    private String is_share;

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

    @SerializedName("pdf_view_url")
    @Expose
    private String pdf_view_url;

    @SerializedName(Const.VIDEO_ID)
    @Expose
    private String videoId;

    public String getPdf_view_url() {
        return this.pdf_view_url;
    }

    public void setPdf_view_url(String pdf_view_url) {
        this.pdf_view_url = pdf_view_url;
    }

    public String getIs_share() {
        return this.is_share;
    }

    public void setIs_share(String is_share) {
        this.is_share = is_share;
    }

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

    public String getIsDownloadable() {
        return this.isDownloadable;
    }

    public void setIsDownloadable(String isDownloadable) {
        this.isDownloadable = isDownloadable;
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
}
