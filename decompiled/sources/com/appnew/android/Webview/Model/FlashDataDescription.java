package com.appnew.android.Webview.Model;

/* JADX INFO: loaded from: classes6.dex */
public class FlashDataDescription {
    private String Q_id;
    private String description;

    public FlashDataDescription(String description, String q_id) {
        this.description = description;
        this.Q_id = q_id;
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
}
