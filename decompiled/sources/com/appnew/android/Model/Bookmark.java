package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Bookmark implements Serializable {
    private String id;

    /* JADX INFO: renamed from: info, reason: collision with root package name */
    private String f309info;
    private String time;

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
        return this.f309info;
    }

    public void setInfo(String info2) {
        this.f309info = info2;
    }
}
