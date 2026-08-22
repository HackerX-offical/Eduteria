package com.appnew.android.Model.TestseriesBase;

import com.appnew.android.Utils.Const;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class Part implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    private int indexOf;

    @SerializedName("part_name")
    @Expose
    private String partName;

    @SerializedName(Const.TESTSERIES_ID)
    @Expose
    private String testSeriesId;

    public int getIndexOf() {
        return this.indexOf;
    }

    public void setIndexOf(int indexOf) {
        this.indexOf = indexOf;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestSeriesId() {
        return this.testSeriesId;
    }

    public void setTestSeriesId(String testSeriesId) {
        this.testSeriesId = testSeriesId;
    }

    public String getPartName() {
        return this.partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setIndex(int indexOf) {
        this.indexOf = indexOf;
    }
}
