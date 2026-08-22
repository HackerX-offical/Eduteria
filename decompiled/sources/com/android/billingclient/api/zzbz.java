package com.android.billingclient.api;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbz extends com.google.android.gms.internal.play_billing.zzae {
    private final CallbackToFutureAdapter.Completer zza;

    zzbz(CallbackToFutureAdapter.Completer completer) {
        this.zza = completer;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaf
    public final void zza(int i) {
        this.zza.set(Integer.valueOf(i));
    }
}
