package com.appnew.android.Model.customPayment;

import com.clevertap.android.sdk.Constants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ModelCourseCustomPayment implements Serializable {

    @SerializedName("cd_time")
    private long cdTime;

    @SerializedName("data")
    private List<CourseItemsCustomPayment> data;

    @SerializedName("interval")
    private int interval;

    @SerializedName(Constants.KEY_LIMIT)
    private int limit;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    @SerializedName("time")
    private long time;

    public void setCourses(List<CourseItemsCustomPayment> data) {
        this.data = data;
    }

    public List<CourseItemsCustomPayment> getCourses() {
        return this.data;
    }

    public void setCdTime(int cdTime) {
        this.cdTime = cdTime;
    }

    public long getCdTime() {
        return this.cdTime;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return this.interval;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getTime() {
        return this.time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return this.status;
    }
}
