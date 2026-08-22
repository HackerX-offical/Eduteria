package com.appnew.android.Model.PlayerPojo;

import com.clevertap.android.sdk.Constants;

/* JADX INFO: loaded from: classes6.dex */
public class VideoTimeFramePojo {
    private String id;

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private String f310info;
    private String time;
    private String v_fk;

    public String getV_fk() {
        return this.v_fk;
    }

    public void setV_fk(String v_fk) {
        this.v_fk = v_fk;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return this.f310info;
    }

    public void setInfo(String info2) {
        this.f310info = info2;
    }

    public String toString() {
        return "ClassPojo [v_fk = " + this.v_fk + ", id = " + this.id + ", time = " + this.time + ", info = " + this.f310info + Constants.AES_SUFFIX;
    }
}
