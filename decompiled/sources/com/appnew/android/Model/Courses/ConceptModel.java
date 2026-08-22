package com.appnew.android.Model.Courses;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ConceptModel implements Serializable {

    @SerializedName("backend_user_id")
    @Expose
    private String backend_user_id;

    @SerializedName("c_code")
    @Expose
    private String c_code;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("description_2")
    @Expose
    private String description_2;

    @SerializedName("file_type")
    @Expose
    private String file_type;

    @SerializedName("file_url")
    @Expose
    private String file_url;

    @SerializedName("file_url_enc")
    @Expose
    private String file_url_enc;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("is_bookmarked")
    @Expose
    private String is_bookmarked;

    @SerializedName("is_locked")
    @Expose
    private String is_locked;

    @SerializedName("live_status")
    @Expose
    private String live_status;

    @SerializedName(Const.MAIN_ID)
    @Expose
    private String main_id;

    @SerializedName("page_count")
    @Expose
    private String page_count;

    @SerializedName("sub_id")
    @Expose
    private String sub_id;

    @SerializedName("sub_title")
    @Expose
    private String sub_title;

    @SerializedName("sub_title_2")
    @Expose
    private String sub_title_2;

    @SerializedName(Const.SUBTOPIC_ID)
    @Expose
    private String sub_topic_id;

    @SerializedName(Const.SUBJECT_ID)
    @Expose
    private String subject_id;

    @SerializedName("thumbnail_url")
    @Expose
    private String thumbnail_url;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("title_2")
    @Expose
    private String title_2;

    @SerializedName(Const.TOPIC_ID)
    @Expose
    private String topic_id;

    @SerializedName(Const.VIDEO_TYPE)
    @Expose
    private String video_type;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMain_id() {
        return this.main_id;
    }

    public void setMain_id(String main_id) {
        this.main_id = main_id;
    }

    public String getSub_id() {
        return this.sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getFile_url_enc() {
        return this.file_url_enc;
    }

    public void setFile_url_enc(String file_url_enc) {
        this.file_url_enc = file_url_enc;
    }

    public String getThumbnail_url() {
        return this.thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_2() {
        return this.title_2;
    }

    public void setTitle_2(String title_2) {
        this.title_2 = title_2;
    }

    public String getSub_title() {
        return this.sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getSub_title_2() {
        return this.sub_title_2;
    }

    public void setSub_title_2(String sub_title_2) {
        this.sub_title_2 = sub_title_2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription_2() {
        return this.description_2;
    }

    public void setDescription_2(String description_2) {
        this.description_2 = description_2;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getSub_topic_id() {
        return this.sub_topic_id;
    }

    public void setSub_topic_id(String sub_topic_id) {
        this.sub_topic_id = sub_topic_id;
    }

    public String getFile_type() {
        return this.file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getPage_count() {
        return this.page_count;
    }

    public void setPage_count(String page_count) {
        this.page_count = page_count;
    }

    public String getBackend_user_id() {
        return this.backend_user_id;
    }

    public void setBackend_user_id(String backend_user_id) {
        this.backend_user_id = backend_user_id;
    }

    public String getLive_status() {
        return this.live_status;
    }

    public void setLive_status(String live_status) {
        this.live_status = live_status;
    }

    public String getVideo_type() {
        return this.video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getIs_locked() {
        return this.is_locked;
    }

    public void setIs_locked(String is_locked) {
        this.is_locked = is_locked;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getC_code() {
        return this.c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }
}
