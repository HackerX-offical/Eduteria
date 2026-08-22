package com.appnew.android.Model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FlashData implements Serializable {
    private String Q_id;
    private String description;
    private boolean is_selectecd = false;
    private String terms;

    public String getTerms() {
        return this.terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQ_id() {
        return this.Q_id;
    }

    public void setQ_id(String q_id) {
        this.Q_id = q_id;
    }

    public boolean isIs_selectecd() {
        return this.is_selectecd;
    }

    public void setIs_selectecd(boolean is_selectecd) {
        this.is_selectecd = is_selectecd;
    }
}
