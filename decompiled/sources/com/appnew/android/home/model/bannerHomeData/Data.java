package com.appnew.android.home.model.bannerHomeData;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public class Data implements Serializable {

    @SerializedName("list")
    @Expose
    private ArrayList<BannerData> data = null;

    @SerializedName(TypedValues.TransitionType.S_DURATION)
    @Expose
    private String duration;

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<BannerData> getData() {
        return this.data;
    }

    public void setData(ArrayList<BannerData> data) {
        this.data = data;
    }
}
