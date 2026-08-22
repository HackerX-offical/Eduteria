package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Tags implements Serializable {
    private String id;
    private String master_id;
    private String position;
    private String status;
    private String text;

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMaster_id() {
        return this.master_id;
    }

    public void setMaster_id(String master_id) {
        this.master_id = master_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
