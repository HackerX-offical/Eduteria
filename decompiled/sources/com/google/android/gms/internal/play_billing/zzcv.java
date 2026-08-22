package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzcv extends zzcd {
    private final transient zzbz zza;
    private final transient zzbw zzb;

    zzcv(zzbz zzbzVar, zzbw zzbwVar) {
        this.zza = zzbzVar;
        this.zzb = zzbwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr
    public final zzbw zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr
    /* JADX INFO: renamed from: zze */
    public final zzde iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final boolean zzf() {
        throw null;
    }
}
