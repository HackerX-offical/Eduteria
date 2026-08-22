package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzjl implements zzji {
    zzjl() {
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final Map<?, ?> zza(Object obj) {
        return (zzjj) obj;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final zzjg<?, ?> zzf(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final Map<?, ?> zzb(Object obj) {
        return (zzjj) obj;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final boolean zzc(Object obj) {
        return !((zzjj) obj).zzd();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final Object zzd(Object obj) {
        ((zzjj) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final Object zze(Object obj) {
        return zzjj.zza().zzb();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final Object zza(Object obj, Object obj2) {
        zzjj zzjjVarZzb = (zzjj) obj;
        zzjj zzjjVar = (zzjj) obj2;
        if (!zzjjVar.isEmpty()) {
            if (!zzjjVarZzb.zzd()) {
                zzjjVarZzb = zzjjVarZzb.zzb();
            }
            zzjjVarZzb.zza(zzjjVar);
        }
        return zzjjVarZzb;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzji
    public final int zza(int i, Object obj, Object obj2) {
        zzjj zzjjVar = (zzjj) obj;
        if (zzjjVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzjjVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
