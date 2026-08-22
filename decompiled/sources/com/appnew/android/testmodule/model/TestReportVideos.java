package com.appnew.android.testmodule.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TestReportVideos implements Serializable {
    private String creation_time;
    private String file_type;
    private String id;
    private String status;
    private String test_series_id;
    private String video_title;
    private String video_url;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTest_series_id() {
        return this.test_series_id;
    }

    public void setTest_series_id(String test_series_id) {
        this.test_series_id = test_series_id;
    }

    public String getVideo_title() {
        return this.video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_url() {
        return this.video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getFile_type() {
        return this.file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
