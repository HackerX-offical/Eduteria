package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class HelpSupportPOJO implements Serializable {
    private String comment_msg;
    private String comment_type;

    public HelpSupportPOJO(String comment_type, String comment_msg) {
        this.comment_type = comment_type;
        this.comment_msg = comment_msg;
    }

    public String getComment_type() {
        return this.comment_type;
    }

    public void setComment_type(String comment_type) {
        this.comment_type = comment_type;
    }

    public String getComment_msg() {
        return this.comment_msg;
    }

    public void setComment_msg(String comment_msg) {
        this.comment_msg = comment_msg;
    }
}
