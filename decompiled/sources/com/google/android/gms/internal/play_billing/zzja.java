package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzja extends IllegalArgumentException {
    zzja(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
