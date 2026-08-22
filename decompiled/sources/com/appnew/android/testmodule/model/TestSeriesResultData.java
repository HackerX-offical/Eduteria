package com.appnew.android.testmodule.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class TestSeriesResultData implements Serializable {
    private String creation_time;
    private String id;
    private String state;
    private String test_result_date;
    private String test_series_id;
    private String test_series_name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreation_time() {
        return this.creation_time;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public String getTest_result_date() {
        return this.test_result_date;
    }

    public void setTest_result_date(String test_result_date) {
        this.test_result_date = test_result_date;
    }

    public String getTest_series_name() {
        return this.test_series_name;
    }

    public void setTest_series_name(String test_series_name) {
        this.test_series_name = test_series_name;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTest_series_id() {
        return this.test_series_id;
    }

    public void setTest_series_id(String test_series_id) {
        this.test_series_id = test_series_id;
    }
}
