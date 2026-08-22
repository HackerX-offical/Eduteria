package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class BasicThreePOJO implements Serializable {
    private String data_required;
    private String id;

    public BasicThreePOJO(String id, String data_required) {
        this.id = id;
        this.data_required = data_required;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData_required() {
        return this.data_required;
    }

    public void setData_required(String data_required) {
        this.data_required = data_required;
    }
}
