package com.appnew.android.Model;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DiscussionVideo implements Serializable {

    @SerializedName("file_url")
    @Expose
    private String file_url;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_drm_protected")
    @Expose
    private String is_drm_protected;

    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnail_url;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("vdc_id")
    @Expose
    private String vdc_id;

    @SerializedName(Const.VIDEO_TYPE)
    @Expose
    private String video_type;

    public String getIs_drm_protected() {
        return this.is_drm_protected;
    }

    public void setIs_drm_protected(String is_drm_protected) {
        this.is_drm_protected = is_drm_protected;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public String getVdc_id() {
        return this.vdc_id;
    }

    public void setVdc_id(String vdc_id) {
        this.vdc_id = vdc_id;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getVideo_type() {
        return this.video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
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
}
