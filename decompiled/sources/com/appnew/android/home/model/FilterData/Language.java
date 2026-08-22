package com.appnew.android.home.model.FilterData;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class Language {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName(Const.LANGUAGE)
    @Expose
    private String language;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
