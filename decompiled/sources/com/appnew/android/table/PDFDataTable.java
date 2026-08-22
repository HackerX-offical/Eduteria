package com.appnew.android.table;

/* JADX INFO: loaded from: classes6.dex */
public class PDFDataTable {
    private int id;
    private String isShare;
    private String is_selected;
    private String pdfFile;
    private String pdfId;
    private String pdfImage;
    private String pdfName;
    private String pdfPath;
    private String pdfUrl;
    private String userId;

    public String getIsShare() {
        return this.isShare;
    }

    public void setIsShare(String isShare) {
        this.isShare = isShare;
    }

    public String getPdfName() {
        return this.pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getPdfId() {
        return this.pdfId;
    }

    public void setPdfId(String pdfId) {
        this.pdfId = pdfId;
    }

    public String getPdfFile() {
        return this.pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public String getPdfImage() {
        return this.pdfImage;
    }

    public void setPdfImage(String pdfImage) {
        this.pdfImage = pdfImage;
    }

    public String getPdfPath() {
        return this.pdfPath;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIs_selected() {
        return this.is_selected;
    }

    public void setIs_selected(String is_selected) {
        this.is_selected = is_selected;
    }

    public PDFDataTable(String userId, String pdfFile, String pdfId, String pdfPath, String pdfName, String pdfImage, String is_selected, String pdfUrl, String isShare) {
        this.userId = userId;
        this.pdfName = pdfName;
        this.pdfFile = pdfFile;
        this.pdfId = pdfId;
        this.pdfPath = pdfPath;
        this.pdfImage = pdfImage;
        this.is_selected = is_selected;
        this.pdfUrl = pdfUrl;
        this.isShare = isShare;
    }

    public String getPdfUrl() {
        return this.pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
