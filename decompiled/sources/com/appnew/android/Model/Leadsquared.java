package com.appnew.android.Model;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Leadsquared implements Serializable {

    @SerializedName(JsonDocumentFields.POLICY_ID)
    @Expose
    private String id;

    @SerializedName("RelatedId")
    @Expose
    private String relatedId;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelatedId() {
        return this.relatedId;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }
}
