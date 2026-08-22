package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzex implements zzez {
    private final /* synthetic */ Status zza;

    zzex(zzeu zzeuVar, Status status) {
        this.zza = status;
    }

    @Override // com.google.firebase.auth.api.internal.zzez
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzdv.zza(this.zza));
    }
}
