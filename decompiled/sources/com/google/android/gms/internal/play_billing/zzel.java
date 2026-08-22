package com.google.android.gms.internal.play_billing;

import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzel extends TimeoutException {
    /* synthetic */ zzel(String str, zzem zzemVar) {
        super(str);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
