package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbm extends zzes<AuthResult, com.google.firebase.auth.internal.zza> {
    private final zzfy zza;

    public zzbm(AuthCredential authCredential) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zza = com.google.firebase.auth.internal.zzc.zza(authCredential, null);
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "linkFederatedCredential";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, AuthResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzbl
            private final zzbm zza;

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
        if (this.zzu) {
            zzdtVar.zza().zza(this.zze.zzf(), this.zza, this.zzc);
        } else {
            zzdtVar.zza().zza(new com.google.android.gms.internal.firebase_auth.zzct(this.zze.zzf(), this.zza), this.zzc);
        }
    }
}
