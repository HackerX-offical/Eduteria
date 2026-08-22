package com.appnew.android.Model.ZoomModel;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class PdfData implements Serializable {

    @SerializedName("content_id")
    @Expose
    private String content_id;

    @SerializedName("content_type")
    @Expose
    private String content_type;

    @SerializedName(Const.COMBO_COURSE_ID)
    @Expose
    private String course_ids;

    @SerializedName("file_type")
    @Expose
    private String file_type;

    @SerializedName("file_url")
    @Expose
    private String file_url;

    @SerializedName(Const.IS_DOWNLOAD)
    @Expose
    private String is_download;

    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnail_url;

    @SerializedName("tile_id")
    @Expose
    private String tile_id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("vdc_id")
    @Expose
    private String vdc_id;

    @SerializedName(Const.VIDEO_TYPE)
    @Expose
    private String video_type;

    public String getContent_id() {
        return this.content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getContent_type() {
        return this.content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getVideo_type() {
        return this.video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getVdc_id() {
        return this.vdc_id;
    }

    public void setVdc_id(String vdc_id) {
        this.vdc_id = vdc_id;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getIs_download() {
        return this.is_download;
    }

    public void setIs_download(String is_download) {
        this.is_download = is_download;
    }

    public String getCourse_ids() {
        return this.course_ids;
    }

    public void setCourse_ids(String course_ids) {
        this.course_ids = course_ids;
    }

    public String getFile_type() {
        return this.file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getTile_id() {
        return this.tile_id;
    }

    public void setTile_id(String tile_id) {
        this.tile_id = tile_id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
