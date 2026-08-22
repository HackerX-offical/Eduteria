package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Parts implements Serializable {
    private Detail detail;
    private String id;
    private String part_name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPart_name() {
        return this.part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public Detail getDetail() {
        return this.detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
