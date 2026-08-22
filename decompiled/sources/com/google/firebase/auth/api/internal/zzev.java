package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzev implements zzez {
    private final /* synthetic */ PhoneAuthCredential zza;

    zzev(zzeu zzeuVar, PhoneAuthCredential phoneAuthCredential) {
        this.zza = phoneAuthCredential;
    }

    @Override // com.google.firebase.auth.api.internal.zzez
    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zza);
    }
}
