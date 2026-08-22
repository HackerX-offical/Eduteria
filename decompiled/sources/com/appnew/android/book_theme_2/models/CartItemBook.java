package com.appnew.android.book_theme_2.models;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CartItemBook.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b(\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003JO\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001b¨\u00064"}, d2 = {"Lcom/appnew/android/book_theme_2/models/CartItemBook;", "", "cdTime", "", "data", "Lcom/appnew/android/book_theme_2/models/CartItemBookData;", "interval", "", Constants.KEY_LIMIT, "message", "", "status", "", "time", "<init>", "(JLcom/appnew/android/book_theme_2/models/CartItemBookData;IILjava/lang/String;ZI)V", "getCdTime", "()J", "setCdTime", "(J)V", "getData", "()Lcom/appnew/android/book_theme_2/models/CartItemBookData;", "setData", "(Lcom/appnew/android/book_theme_2/models/CartItemBookData;)V", "getInterval", "()I", "setInterval", "(I)V", "getLimit", "setLimit", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getStatus", "()Z", "setStatus", "(Z)V", "getTime", "setTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", Constants.COPY_TYPE, "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class CartItemBook {
    public static final int $stable = 8;

    @SerializedName("cd_time")
    private long cdTime;

    @SerializedName("data")
    private CartItemBookData data;

    @SerializedName("interval")
    private int interval;

    @SerializedName(Constants.KEY_LIMIT)
    private int limit;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private boolean status;

    @SerializedName("time")
    private int time;

    public static /* synthetic */ CartItemBook copy$default(CartItemBook cartItemBook, long j, CartItemBookData cartItemBookData, int i, int i2, String str, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = cartItemBook.cdTime;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            cartItemBookData = cartItemBook.data;
        }
        CartItemBookData cartItemBookData2 = cartItemBookData;
        if ((i4 & 4) != 0) {
            i = cartItemBook.interval;
        }
        int i5 = i;
        if ((i4 & 8) != 0) {
            i2 = cartItemBook.limit;
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            str = cartItemBook.message;
        }
        return cartItemBook.copy(j2, cartItemBookData2, i5, i6, str, (i4 & 32) != 0 ? cartItemBook.status : z, (i4 & 64) != 0 ? cartItemBook.time : i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getCdTime() {
        return this.cdTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CartItemBookData getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getInterval() {
        return this.interval;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getLimit() {
        return this.limit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getTime() {
        return this.time;
    }

    public final CartItemBook copy(long cdTime, CartItemBookData data, int interval, int limit, String message, boolean status, int time) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        return new CartItemBook(cdTime, data, interval, limit, message, status, time);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CartItemBook)) {
            return false;
        }
        CartItemBook cartItemBook = (CartItemBook) other;
        return this.cdTime == cartItemBook.cdTime && Intrinsics.areEqual(this.data, cartItemBook.data) && this.interval == cartItemBook.interval && this.limit == cartItemBook.limit && Intrinsics.areEqual(this.message, cartItemBook.message) && this.status == cartItemBook.status && this.time == cartItemBook.time;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.cdTime) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.interval)) * 31) + Integer.hashCode(this.limit)) * 31) + this.message.hashCode()) * 31) + Boolean.hashCode(this.status)) * 31) + Integer.hashCode(this.time);
    }

    public String toString() {
        return "CartItemBook(cdTime=" + this.cdTime + ", data=" + this.data + ", interval=" + this.interval + ", limit=" + this.limit + ", message=" + this.message + ", status=" + this.status + ", time=" + this.time + ")";
    }

    public CartItemBook(long j, CartItemBookData data, int i, int i2, String message, boolean z, int i3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(message, "message");
        this.cdTime = j;
        this.data = data;
        this.interval = i;
        this.limit = i2;
        this.message = message;
        this.status = z;
        this.time = i3;
    }

    public final long getCdTime() {
        return this.cdTime;
    }

    public final void setCdTime(long j) {
        this.cdTime = j;
    }

    public final CartItemBookData getData() {
        return this.data;
    }

    public final void setData(CartItemBookData cartItemBookData) {
        Intrinsics.checkNotNullParameter(cartItemBookData, "<set-?>");
        this.data = cartItemBookData;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final void setInterval(int i) {
        this.interval = i;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final void setLimit(int i) {
        this.limit = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final int getTime() {
        return this.time;
    }

    public final void setTime(int i) {
        this.time = i;
    }
}
