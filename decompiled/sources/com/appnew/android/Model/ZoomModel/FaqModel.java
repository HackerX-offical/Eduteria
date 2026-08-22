package com.appnew.android.Model.ZoomModel;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class FaqModel implements Serializable {

    @SerializedName("creation_date")
    @Expose
    private String creation_date;

    @SerializedName("description")
    @Expose
    private String description;
    private Boolean expand = false;

    @SerializedName(Const.QUESTION)
    @Expose
    private String question;

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreation_date() {
        return this.creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public Boolean getExpand() {
        return this.expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }
}
