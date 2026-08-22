package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbq extends zzes<AuthResult, com.google.firebase.auth.internal.zza> {
    private final EmailAuthCredential zza;

    public zzbq(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zza = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "linkEmailAuthCredential";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, AuthResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzbp
            private final zzbq zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                this.zza.zza((zzdt) obj, (TaskCompletionSource) obj2);
            }
        }).build();
    }

    @Override // com.google.firebase.auth.api.internal.zzes
    public final void zze() {
        com.google.firebase.auth.internal.zzn zznVarZza = zzau.zza(this.zzd, this.zzl);
        ((com.google.firebase.auth.internal.zza) this.zzf).zza(this.zzk, zznVarZza);
        zzb(new com.google.firebase.auth.internal.zzh(zznVarZza));
    }

    final /* synthetic */ void zza(zzdt zzdtVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfc(this, taskCompletionSource);
        com.google.android.gms.internal.firebase_auth.zzdp zzdpVar = new com.google.android.gms.internal.firebase_auth.zzdp(this.zza.zza(this.zze));
        if (this.zzu) {
            zzdtVar.zza().zza(zzdpVar.zza(), this.zzc);
        } else {
            zzdtVar.zza().zza(zzdpVar, this.zzc);
        }
    }
}
