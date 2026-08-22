package com.appnew.android.Model.CartModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CartData {

    @SerializedName("cartdata")
    @Expose
    private List<CartCourseList> cartdata = null;

    @SerializedName("total")
    @Expose
    private String total;

    public List<CartCourseList> getCartdata() {
        return this.cartdata;
    }

    public void setCartdata(List<CartCourseList> cartdata) {
        this.cartdata = cartdata;
    }

    public String getTotal() {
        return this.total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
