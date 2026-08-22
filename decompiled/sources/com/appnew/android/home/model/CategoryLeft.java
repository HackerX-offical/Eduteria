package com.appnew.android.home.model;

import android.os.Parcel;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CategoryLeft implements Serializable {
    private String id;
    private String name;

    public CategoryLeft(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected CategoryLeft(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
    }
}
