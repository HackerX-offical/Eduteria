package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbl extends zzbm {
    private static final zzbl zzb = new zzbl();

    private zzbl() {
        super("");
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return zza((zzbm) obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm
    public final int zza(zzbm zzbmVar) {
        return zzbmVar == this ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm
    final void zzc(StringBuilder sb) {
        sb.append("(-∞");
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm
    final void zzd(StringBuilder sb) {
        throw new AssertionError();
    }
}
