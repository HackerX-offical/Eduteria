package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class CatDataTwoPOJO implements Serializable {
    private String study_type;
    private String sub_cat;

    public CatDataTwoPOJO(String sub_cat, String study_type) {
        this.sub_cat = sub_cat;
        this.study_type = study_type;
    }

    public String getSub_cat() {
        return this.sub_cat;
    }

    public void setSub_cat(String sub_cat) {
        this.sub_cat = sub_cat;
    }

    public String getStudy_type() {
        return this.study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }
}
