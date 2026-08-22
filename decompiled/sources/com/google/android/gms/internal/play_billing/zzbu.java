package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbu extends zzbw {
    private final transient zzbw zza;

    zzbu(zzbw zzbwVar) {
        this.zza = zzbwVar;
    }

    private final int zzp(int i) {
        return (this.zza.size() - 1) - i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzam.zza(i, this.zza.size(), FirebaseAnalytics.Param.INDEX);
        return this.zza.get(zzp(i));
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzp(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzp(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final boolean zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    public final zzbw zzh() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbw
    /* JADX INFO: renamed from: zzi */
    public final zzbw subList(int i, int i2) {
        zzam.zze(i, i2, this.zza.size());
        zzbw zzbwVar = this.zza;
        return zzbwVar.subList(zzbwVar.size() - i2, this.zza.size() - i).zzh();
    }
}
