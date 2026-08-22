package com.appnew.android.home.model.myNotesData;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class NoteTags implements Serializable {
    private String tag_name;

    public NoteTags(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_name() {
        return this.tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
