package com.appnew.android.folder.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ExamCenter implements Serializable {
    boolean isChecked;
    String name;

    public ExamCenter(String name, boolean isChecked) {
        this.name = name;
        this.isChecked = isChecked;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean checked) {
        this.isChecked = checked;
    }
}
