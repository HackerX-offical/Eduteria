package com.appnew.android.Model.CartModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Data {

    @SerializedName("cartdata")
    @Expose
    private List<CartItemModel> cartdata = null;

    @SerializedName("policyType")
    private String policyType = "0";

    @SerializedName("total")
    @Expose
    private String total;

    public List<CartItemModel> getCartdata() {
        return this.cartdata;
    }

    public void setCartdata(List<CartItemModel> cartdata) {
        this.cartdata = cartdata;
    }

    public String getTotal() {
        return this.total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPolicyType() {
        return this.policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }
}
