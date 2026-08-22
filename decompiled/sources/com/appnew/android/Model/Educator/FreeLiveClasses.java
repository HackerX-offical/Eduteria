package com.appnew.android.Model.Educator;

import com.appnew.android.home.liveclasses.Datum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class FreeLiveClasses {

    @SerializedName("data")
    @Expose
    private ArrayList<Datum> data = null;

    public ArrayList<Datum> getData() {
        return this.data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }
}
