package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzu implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zza;

    zzu(FirebaseUser firebaseUser) {
        this.zza = firebaseUser;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<GetTokenResult> task) throws Exception {
        return FirebaseAuth.getInstance(this.zza.zzc()).zza((ActionCodeSettings) null, task.getResult().getToken());
    }
}
