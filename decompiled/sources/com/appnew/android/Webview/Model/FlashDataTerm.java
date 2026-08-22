package com.appnew.android.Webview.Model;

/* JADX INFO: loaded from: classes6.dex */
public class FlashDataTerm {
    private String Q_id;
    private String terms;

    public FlashDataTerm(String terms, String q_id) {
        this.terms = terms;
        this.Q_id = q_id;
    }

    public String getTerms() {
        return this.terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getQ_id() {
        return this.Q_id;
    }

    public void setQ_id(String q_id) {
        this.Q_id = q_id;
    }
}
