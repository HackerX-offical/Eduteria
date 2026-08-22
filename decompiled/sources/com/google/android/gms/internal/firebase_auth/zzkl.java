package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzkl extends zzkr {
    private final /* synthetic */ zzkg zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzkl(zzkg zzkgVar) {
        super(zzkgVar, null);
        this.zza = zzkgVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzkr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzki(this.zza, null);
    }

    /* synthetic */ zzkl(zzkg zzkgVar, zzkj zzkjVar) {
        this(zzkgVar);
    }
}
