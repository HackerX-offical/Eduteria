package com.billdesk.utils;

/* JADX INFO: loaded from: classes6.dex */
public class BillDeskSDKException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f476a;

    public BillDeskSDKException(String str) {
        super(str);
        this.f476a = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f476a;
    }
}
