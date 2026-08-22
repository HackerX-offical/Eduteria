package com.razorpay;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
class CacheEntry implements Serializable {
    String data;
    long expiryTime;

    CacheEntry(String str, long j) {
        this.data = str;
        this.expiryTime = j;
    }
}
