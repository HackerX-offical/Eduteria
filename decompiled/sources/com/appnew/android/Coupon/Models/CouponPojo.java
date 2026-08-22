package com.appnew.android.Coupon.Models;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class CouponPojo implements Serializable {
    List<Available> available;
    List<Available> expired;
    List<Available> redeemed;

    public List<Available> getAvailable() {
        return this.available;
    }

    public void setAvailable(List<Available> available) {
        this.available = available;
    }

    public List<Available> getRedeemed() {
        return this.redeemed;
    }

    public void setRedeemed(List<Available> redeemed) {
        this.redeemed = redeemed;
    }

    public List<Available> getExpired() {
        return this.expired;
    }

    public void setExpired(List<Available> expired) {
        this.expired = expired;
    }
}
