package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzga;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzt implements zzfd<zzga> {
    private final /* synthetic */ zzfd zza;
    private final /* synthetic */ zzu zzb;

    zzt(zzu zzuVar, zzfd zzfdVar) {
        this.zzb = zzuVar;
        this.zza = zzfdVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzga zzgaVar) {
        this.zzb.zzb.zza(zzgaVar, this.zzb.zza, this);
    }
}
