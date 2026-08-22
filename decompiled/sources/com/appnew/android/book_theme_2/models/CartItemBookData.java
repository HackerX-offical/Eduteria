package com.appnew.android.book_theme_2.models;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CartItemBook.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/appnew/android/book_theme_2/models/CartItemBookData;", "", "cartdata", "", "Lcom/appnew/android/book_theme_2/models/Cartdata;", "total", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getCartdata", "()Ljava/util/List;", "setCartdata", "(Ljava/util/List;)V", "getTotal", "()Ljava/lang/String;", "setTotal", "(Ljava/lang/String;)V", "component1", "component2", Constants.COPY_TYPE, "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CartItemBookData {
    public static final int $stable = 8;

    @SerializedName("cartdata")
    private List<Cartdata> cartdata;

    @SerializedName("total")
    private String total;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CartItemBookData copy$default(CartItemBookData cartItemBookData, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = cartItemBookData.cartdata;
        }
        if ((i & 2) != 0) {
            str = cartItemBookData.total;
        }
        return cartItemBookData.copy(list, str);
    }

    public final List<Cartdata> component1() {
        return this.cartdata;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTotal() {
        return this.total;
    }

    public final CartItemBookData copy(List<Cartdata> cartdata, String total) {
        Intrinsics.checkNotNullParameter(cartdata, "cartdata");
        Intrinsics.checkNotNullParameter(total, "total");
        return new CartItemBookData(cartdata, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CartItemBookData)) {
            return false;
        }
        CartItemBookData cartItemBookData = (CartItemBookData) other;
        return Intrinsics.areEqual(this.cartdata, cartItemBookData.cartdata) && Intrinsics.areEqual(this.total, cartItemBookData.total);
    }

    public int hashCode() {
        return (this.cartdata.hashCode() * 31) + this.total.hashCode();
    }

    public String toString() {
        return "CartItemBookData(cartdata=" + this.cartdata + ", total=" + this.total + ")";
    }

    public CartItemBookData(List<Cartdata> cartdata, String total) {
        Intrinsics.checkNotNullParameter(cartdata, "cartdata");
        Intrinsics.checkNotNullParameter(total, "total");
        this.cartdata = cartdata;
        this.total = total;
    }

    public final List<Cartdata> getCartdata() {
        return this.cartdata;
    }

    public final void setCartdata(List<Cartdata> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cartdata = list;
    }

    public final String getTotal() {
        return this.total;
    }

    public final void setTotal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.total = str;
    }
}
