package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.UserProfileChangeRequest;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdm extends zzes<Void, com.google.firebase.auth.internal.zza> {
    private final UserProfileChangeRequest zza;

    public zzdm(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        this.zza = (UserProfileChangeRequest) Preconditions.checkNotNull(userProfileChangeRequest, "request cannot be null");
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "updateProfile";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzdl
            private final zzdm zza;

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
        ((com.google.firebase.auth.internal.zza) this.zzf).zza(this.zzk, zzau.zza(this.zzd, this.zzl));
        zzb((Object) null);
    }

    final /* synthetic */ void zza(zzdt zzdtVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfc(this, taskCompletionSource);
        if (this.zzu) {
            zzdtVar.zza().zza(this.zze.zzf(), this.zza, this.zzc);
        } else {
            zzdtVar.zza().zza(new com.google.android.gms.internal.firebase_auth.zzed(this.zza, this.zze.zzf()), this.zzc);
        }
    }
}
