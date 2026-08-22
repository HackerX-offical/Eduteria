package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzgi;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzr implements zzfd<zzgi> {
    private final /* synthetic */ zzfd zza;
    private final /* synthetic */ zzs zzb;

    zzr(zzs zzsVar, zzfd zzfdVar) {
        this.zzb = zzsVar;
        this.zza = zzfdVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzgi zzgiVar) {
        zzgi zzgiVar2 = zzgiVar;
        if (!TextUtils.isEmpty(zzgiVar2.zzf())) {
            this.zzb.zza.zza(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zza(zzgiVar2.zzg(), zzgiVar2.zzf()));
        } else {
            this.zzb.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzff(zzgiVar2.zzc(), zzgiVar2.zzb(), Long.valueOf(zzgiVar2.zzd()), "Bearer"), null, "phone", Boolean.valueOf(zzgiVar2.zze()), null, this.zzb.zza, this.zza);
        }
    }
}
