package com.google.android.gms.internal.play_billing;

import com.clevertap.android.sdk.Constants;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdb extends zzcd {
    final transient Object zza;

    zzdb(Object obj) {
        obj.getClass();
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzch(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return Constants.AES_PREFIX + this.zza.toString() + Constants.AES_SUFFIX;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final int zza(Object[] objArr, int i) {
        objArr[0] = this.zza;
        return 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr
    public final zzbw zzd() {
        return zzbw.zzm(this.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzcd, com.google.android.gms.internal.play_billing.zzbr
    /* JADX INFO: renamed from: zze */
    public final zzde iterator() {
        return new zzch(this.zza);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbr
    final boolean zzf() {
        throw null;
    }
}
