package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzn implements Runnable {
    private final /* synthetic */ FirebaseAuth.AuthStateListener zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzn(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzb = firebaseAuth;
        this.zza = authStateListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onAuthStateChanged(this.zzb);
    }
}
