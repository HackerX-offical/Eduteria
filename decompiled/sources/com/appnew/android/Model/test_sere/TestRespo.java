package com.appnew.android.Model.test_sere;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class TestRespo {

    @SerializedName("data")
    private Data mData;

    @SerializedName("is_ios_price")
    private Long mIsIosPrice;

    public Data getData() {
        return this.mData;
    }

    public void setData(Data data) {
        this.mData = data;
    }

    public Long getIsIosPrice() {
        return this.mIsIosPrice;
    }

    public void setIsIosPrice(Long isIosPrice) {
        this.mIsIosPrice = isIosPrice;
    }
}
