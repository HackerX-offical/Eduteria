package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzew implements zzez {
    private final /* synthetic */ String zza;

    zzew(zzeu zzeuVar, String str) {
        this.zza = str;
    }

    @Override // com.google.firebase.auth.api.internal.zzez
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zza, PhoneAuthProvider.ForceResendingToken.zza());
    }
}
