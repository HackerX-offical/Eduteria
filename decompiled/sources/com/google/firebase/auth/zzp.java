package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzp implements Runnable {
    private final /* synthetic */ FirebaseAuth zza;

    zzp(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it = this.zza.zzd.iterator();
        while (it.hasNext()) {
            ((FirebaseAuth.AuthStateListener) it.next()).onAuthStateChanged(this.zza);
        }
    }
}
