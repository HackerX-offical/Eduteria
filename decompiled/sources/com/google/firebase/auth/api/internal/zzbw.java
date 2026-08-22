package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbw extends zzes<Void, com.google.firebase.auth.internal.zza> {
    private final com.google.android.gms.internal.firebase_auth.zzdp zza;

    public zzbw(EmailAuthCredential emailAuthCredential) {
        super(2);
        Preconditions.checkNotNull(emailAuthCredential, "Credential cannot be null");
        this.zza = new com.google.android.gms.internal.firebase_auth.zzdp(emailAuthCredential);
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "reauthenticateWithEmailLink";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzbv
            private final zzbw zza;

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
        if (this.zze.getUid().equalsIgnoreCase(zznVarZza.getUid())) {
            ((com.google.firebase.auth.internal.zza) this.zzf).zza(this.zzk, zznVarZza);
            zzb((Object) null);
        } else {
            zza(new Status(FirebaseError.ERROR_USER_MISMATCH));
        }
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
