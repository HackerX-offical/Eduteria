package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zziw extends zzix {
    zziw(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.play_billing.zziy.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.play_billing.zziy.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.play_billing.zziy.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.play_billing.zziy.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzc(Object obj, long j, boolean z) {
        if (zziy.zzb) {
            zziy.zzi(obj, j, z);
        } else {
            zziy.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzd(Object obj, long j, byte b2) {
        if (zziy.zzb) {
            zziy.zzD(obj, j, b2);
        } else {
            zziy.zzE(obj, j, b2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zze(Object obj, long j, double d2) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final void zzf(Object obj, long j, float f2) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.play_billing.zzix
    public final boolean zzg(Object obj, long j) {
        return zziy.zzb ? zziy.zzt(obj, j) : zziy.zzu(obj, j);
    }
}
