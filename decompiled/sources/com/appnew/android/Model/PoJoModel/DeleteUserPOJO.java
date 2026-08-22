package com.appnew.android.Model.PoJoModel;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class DeleteUserPOJO implements Serializable {
    private String reason;
    private String user_id;

    public DeleteUserPOJO(String user_id, String reason) {
        this.user_id = user_id;
        this.reason = reason;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
