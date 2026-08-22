package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CatDataOnePOJO implements Serializable {
    private String cat_id;

    public CatDataOnePOJO(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_id() {
        return this.cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }
}
