package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzie;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhv extends zzht<zzie.zzc> {
    zzhv() {
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final boolean zza(zzjp zzjpVar) {
        return zzjpVar instanceof zzie.zzd;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final zzhx<zzie.zzc> zza(Object obj) {
        return ((zzie.zzd) obj).zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final zzhx<zzie.zzc> zzb(Object obj) {
        zzie.zzd zzdVar = (zzie.zzd) obj;
        if (zzdVar.zzc.zzc()) {
            zzdVar.zzc = (zzhx) zzdVar.zzc.clone();
        }
        return zzdVar.zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final void zzc(Object obj) {
        zza(obj).zzb();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final <UT, UB> UB zza(zzkc zzkcVar, Object obj, zzhr zzhrVar, zzhx<zzie.zzc> zzhxVar, UB ub, zzkx<UT, UB> zzkxVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final int zza(Map.Entry<?, ?> entry) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final void zza(zzlu zzluVar, Map.Entry<?, ?> entry) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final Object zza(zzhr zzhrVar, zzjp zzjpVar, int i) {
        return zzhrVar.zza(zzjpVar, i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final void zza(zzkc zzkcVar, Object obj, zzhr zzhrVar, zzhx<zzie.zzc> zzhxVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzht
    final void zza(zzgt zzgtVar, Object obj, zzhr zzhrVar, zzhx<zzie.zzc> zzhxVar) throws IOException {
        throw new NoSuchMethodError();
    }
}
