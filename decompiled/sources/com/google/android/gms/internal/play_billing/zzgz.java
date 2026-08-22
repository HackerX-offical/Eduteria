package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzgz extends IOException {
    public zzgz(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzgz(String str) {
        super(str);
    }
}
