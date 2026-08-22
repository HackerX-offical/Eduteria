package com.appnew.android.Model.TileMeta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class TileMeta {

    @SerializedName("description")
    @Expose
    private List<Description> description = null;

    @SerializedName("description_2")
    @Expose
    private List<Description2> description2 = null;

    @SerializedName("visibility")
    @Expose
    private String visibility;

    public String getVisibility() {
        return this.visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public List<Description> getDescription() {
        return this.description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public List<Description2> getDescription2() {
        return this.description2;
    }

    public void setDescription2(List<Description2> description2) {
        this.description2 = description2;
    }
}
