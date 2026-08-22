package com.appnew.android.Model.ZoomModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Topics implements Serializable {
    String id;
    String name;
    String position;
    String subject_id;

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

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }
}
