package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzff;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzo implements com.google.firebase.auth.internal.zza, com.google.firebase.auth.internal.zzae {
    private final /* synthetic */ FirebaseAuth zza;

    zzo(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zza
    public final void zza(zzff zzffVar, FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzffVar, true, true);
    }

    @Override // com.google.firebase.auth.internal.zzae
    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
