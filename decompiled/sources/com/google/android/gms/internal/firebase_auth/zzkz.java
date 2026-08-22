package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkz extends zzkx<zzla, zzla> {
    zzkz() {
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final boolean zza(zzkc zzkcVar) {
        return false;
    }

    /* JADX INFO: renamed from: zza, reason: avoid collision after fix types in other method */
    private static void zza2(Object obj, zzla zzlaVar) {
        ((zzie) obj).zzb = zzlaVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final void zzd(Object obj) {
        ((zzie) obj).zzb.zzc();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ int zzf(zzla zzlaVar) {
        return zzlaVar.zze();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ int zze(zzla zzlaVar) {
        return zzlaVar.zzd();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ zzla zzc(zzla zzlaVar, zzla zzlaVar2) {
        zzla zzlaVar3 = zzlaVar;
        zzla zzlaVar4 = zzlaVar2;
        return zzlaVar4.equals(zzla.zza()) ? zzlaVar3 : zzla.zza(zzlaVar3, zzlaVar4);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zzb(zzla zzlaVar, zzlu zzluVar) throws IOException {
        zzlaVar.zza(zzluVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zza(zzla zzlaVar, zzlu zzluVar) throws IOException {
        zzlaVar.zzb(zzluVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zzb(Object obj, zzla zzlaVar) {
        zza2(obj, zzlaVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ zzla zzc(Object obj) {
        zzla zzlaVar = ((zzie) obj).zzb;
        if (zzlaVar != zzla.zza()) {
            return zzlaVar;
        }
        zzla zzlaVarZzb = zzla.zzb();
        zza2(obj, zzlaVarZzb);
        return zzlaVarZzb;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ zzla zzb(Object obj) {
        return ((zzie) obj).zzb;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* bridge */ /* synthetic */ void zza(Object obj, zzla zzlaVar) {
        zza2(obj, zzlaVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ zzla zza(zzla zzlaVar) {
        zzla zzlaVar2 = zzlaVar;
        zzlaVar2.zzc();
        return zzlaVar2;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ zzla zza() {
        return zzla.zzb();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zza(zzla zzlaVar, int i, zzla zzlaVar2) {
        zzlaVar.zza((i << 3) | 3, zzlaVar2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zza(zzla zzlaVar, int i, zzgt zzgtVar) {
        zzlaVar.zza((i << 3) | 2, zzgtVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zzb(zzla zzlaVar, int i, long j) {
        zzlaVar.zza((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zza(zzla zzlaVar, int i, int i2) {
        zzlaVar.zza((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkx
    final /* synthetic */ void zza(zzla zzlaVar, int i, long j) {
        zzlaVar.zza(i << 3, Long.valueOf(j));
    }
}
