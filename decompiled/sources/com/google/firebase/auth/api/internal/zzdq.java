package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdq extends zzes<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final com.google.android.gms.internal.firebase_auth.zzdd zza;

    public zzdq(zzfr zzfrVar) {
        super(8);
        Preconditions.checkNotNull(zzfrVar);
        this.zza = new com.google.android.gms.internal.firebase_auth.zzdd(zzfrVar);
    }

    @Override // com.google.firebase.auth.api.internal.zzes
    public final void zze() {
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "verifyPhoneNumber";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzdp
            private final zzdq zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.zza.zza((zzdt) obj, (TaskCompletionSource) obj2);
            }
        }).build();
    }

    final /* synthetic */ void zza(zzdt zzdtVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfc(this, taskCompletionSource);
        if (this.zzu) {
            zzdtVar.zza().zza(this.zza.zza(), this.zzc);
        } else {
            zzdtVar.zza().zza(this.zza, this.zzc);
        }
    }
}
