package com.appnew.android.Model.Educator;

import com.appnew.android.home.liveclasses.Datum;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class PaidLiveClasses {

    @SerializedName("data")
    private ArrayList<Datum> data;

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public ArrayList<Datum> getData() {
        return this.data;
    }
}
