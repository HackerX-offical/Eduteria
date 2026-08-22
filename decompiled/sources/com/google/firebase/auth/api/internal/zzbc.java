package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbc extends zzes<AuthResult, com.google.firebase.auth.internal.zza> {
    final com.google.android.gms.internal.firebase_auth.zzcf zza;

    public zzbc(String str, String str2, String str3) {
        super(2);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        Preconditions.checkNotEmpty(str2, "password cannot be null or empty");
        this.zza = new com.google.android.gms.internal.firebase_auth.zzcf(str, str2, str3);
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "createUserWithEmailAndPassword";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, AuthResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzbb
            private final zzbc zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbc zzbcVar = this.zza;
                zzdt zzdtVar = (zzdt) obj;
                zzbcVar.zzh = new zzfc(zzbcVar, (TaskCompletionSource) obj2);
                if (zzbcVar.zzu) {
                    zzdtVar.zza().zzc(zzbcVar.zza.zza(), zzbcVar.zza.zzb(), zzbcVar.zzc);
                } else {
                    zzdtVar.zza().zza(zzbcVar.zza, zzbcVar.zzc);
                }
            }
        }).build();
    }

    @Override // com.google.firebase.auth.api.internal.zzes
    public final void zze() {
        com.google.firebase.auth.internal.zzn zznVarZza = zzau.zza(this.zzd, this.zzl);
        ((com.google.firebase.auth.internal.zza) this.zzf).zza(this.zzk, zznVarZza);
        zzb(new com.google.firebase.auth.internal.zzh(zznVarZza));
    }
}
