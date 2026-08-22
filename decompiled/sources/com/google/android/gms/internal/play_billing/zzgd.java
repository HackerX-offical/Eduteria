package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzgd {
    private final Object zza;
    private final int zzb;

    zzgd(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgd)) {
            return false;
        }
        zzgd zzgdVar = (zzgd) obj;
        return this.zza == zzgdVar.zza && this.zzb == zzgdVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
