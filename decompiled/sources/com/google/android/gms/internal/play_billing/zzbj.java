package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbj extends zzbm {
    private static final zzbj zzb = new zzbj();

    private zzbj() {
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
        return "+∞";
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm
    public final int zza(zzbm zzbmVar) {
        return zzbmVar == this ? 0 : 1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm
    final void zzc(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.gms.internal.play_billing.zzbm
    final void zzd(StringBuilder sb) {
        sb.append("+∞)");
    }
}
