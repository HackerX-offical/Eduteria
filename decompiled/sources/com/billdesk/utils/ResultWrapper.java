package com.billdesk.utils;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class ResultWrapper implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RESULT f529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Exception f532d;

    public enum RESULT {
        SUCCESS,
        ERROR,
        CANCEL
    }
}
