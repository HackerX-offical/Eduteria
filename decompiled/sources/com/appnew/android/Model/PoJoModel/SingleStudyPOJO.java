package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class SingleStudyPOJO implements Serializable {
    private String id;
    private String parent_id;

    public SingleStudyPOJO(String id, String parent_id) {
        this.id = id;
        this.parent_id = parent_id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return this.parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }
}
