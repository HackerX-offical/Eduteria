package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzl implements Runnable {
    private final /* synthetic */ FirebaseAuth.IdTokenListener zza;
    private final /* synthetic */ FirebaseAuth zzb;

    zzl(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zzb = firebaseAuth;
        this.zza = idTokenListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.onIdTokenChanged(this.zzb);
    }
}
