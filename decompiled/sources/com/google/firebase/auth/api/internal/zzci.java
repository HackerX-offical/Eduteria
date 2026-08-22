package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzci extends zzes<Void, com.google.firebase.auth.internal.zza> {
    public zzci() {
        super(2);
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "reload";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzch
            private final zzci zza;

            {
                this.zza = this;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzci zzciVar = this.zza;
                zzdt zzdtVar = (zzdt) obj;
                zzciVar.zzh = new zzfc(zzciVar, (TaskCompletionSource) obj2);
                if (zzciVar.zzu) {
                    zzdtVar.zza().zzf(zzciVar.zze.zzf(), zzciVar.zzc);
                } else {
                    zzdtVar.zza().zza(new com.google.android.gms.internal.firebase_auth.zzcx(zzciVar.zze.zzf()), zzciVar.zzc);
                }
            }
        }).build();
    }

    @Override // com.google.firebase.auth.api.internal.zzes
    public final void zze() {
        ((com.google.firebase.auth.internal.zza) this.zzf).zza(this.zzk, zzau.zza(this.zzd, this.zzl));
        zzb((Object) null);
    }
}
