package com.appnew.android.Model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FileMeta implements Serializable {
    private String backend_user_id;
    private String description;
    private String file_type;
    private String file_url;
    private String id;
    private String is_bookmarked;
    private String is_locked;
    private String main_id;
    private String page_count;
    private String sub_id;
    private String sub_title;
    private String subject_id;
    private String thumbnail_url;
    private String title;
    private String topic_id;
    private String video_type;

    public String getSub_id() {
        return this.sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getVideo_type() {
        return this.video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getIs_bookmarked() {
        return this.is_bookmarked;
    }

    public void setIs_bookmarked(String is_bookmarked) {
        this.is_bookmarked = is_bookmarked;
    }

    public String getIs_locked() {
        return this.is_locked;
    }

    public void setIs_locked(String is_locked) {
        this.is_locked = is_locked;
    }

    public String getMain_id() {
        return this.main_id;
    }

    public void setMain_id(String main_id) {
        this.main_id = main_id;
    }

    public String getFile_url() {
        return this.file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getSub_title() {
        return this.sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getBackend_user_id() {
        return this.backend_user_id;
    }

    public void setBackend_user_id(String backend_user_id) {
        this.backend_user_id = backend_user_id;
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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String toString() {
        return "ClassPojo [sub_id = " + this.sub_id + ", video_type = " + this.video_type + ", subject_id = " + this.subject_id + ", is_bookmarked = " + this.is_bookmarked + ", is_locked = " + this.is_locked + ", main_id = " + this.main_id + ", file_url = " + this.file_url + ", sub_title = " + this.sub_title + ", backend_user_id = " + this.backend_user_id + ", file_type = " + this.file_type + ", page_count = " + this.page_count + ", id = " + this.id + ", thumbnail_url = " + this.thumbnail_url + ", title = " + this.title + ", description = " + this.description + ", topic_id = " + this.topic_id + Constants.AES_SUFFIX;
    }
}
