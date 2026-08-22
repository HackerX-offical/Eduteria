package com.appnew.android.Model.TileMeta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: compiled from: TileMeta.java */
/* JADX INFO: loaded from: classes6.dex */
class Description {

    @SerializedName("description")
    @Expose
    private List<Description> description = null;

    @SerializedName("visibility")
    @Expose
    private String visibility;

    Description() {
    }
}
