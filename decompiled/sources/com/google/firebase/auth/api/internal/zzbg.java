package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbg extends zzes<SignInMethodQueryResult, com.google.firebase.auth.internal.zza> {
    private final com.google.android.gms.internal.firebase_auth.zzcp zza;

    public zzbg(String str, String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new com.google.android.gms.internal.firebase_auth.zzcp(str, str2);
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    @Override // com.google.firebase.auth.api.internal.zzap
    public final TaskApiCall<zzdt, SignInMethodQueryResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{com.google.android.gms.internal.firebase_auth.zze.zza}).run(new RemoteCall(this) { // from class: com.google.firebase.auth.api.internal.zzbf
            private final zzbg zza;

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
        zzb(new com.google.firebase.auth.internal.zzx(this.zzm.zzb()));
    }

    final /* synthetic */ void zza(zzdt zzdtVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzfc(this, taskCompletionSource);
        if (this.zzu) {
            zzdtVar.zza().zzc(this.zza.zza(), this.zzc);
        } else {
            zzdtVar.zza().zza(this.zza, this.zzc);
        }
    }
}
