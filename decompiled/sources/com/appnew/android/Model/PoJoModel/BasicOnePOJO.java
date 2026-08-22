package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class BasicOnePOJO implements Serializable {
    private String data_required;
    private String id;
    private String subject_id;

    public BasicOnePOJO(String id, String subject_id, String data_required) {
        this.id = id;
        this.subject_id = subject_id;
        this.data_required = data_required;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject_id() {
        return this.subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getData_required() {
        return this.data_required;
    }

    public void setData_required(String data_required) {
        this.data_required = data_required;
    }
}
