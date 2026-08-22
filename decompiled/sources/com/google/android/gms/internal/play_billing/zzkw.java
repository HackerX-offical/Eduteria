package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkw extends zzgs implements zzhv {
    private static final zzkw zzb;
    private int zzd;
    private int zze;

    static {
        zzkw zzkwVar = new zzkw();
        zzb = zzkwVar;
        zzgs.zzx(zzkw.class, zzkwVar);
    }

    private zzkw() {
    }

    public static zzkw zzB() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzku.zza});
        }
        if (i2 == 3) {
            return new zzkw();
        }
        zzkv zzkvVar = null;
        if (i2 == 4) {
            return new zzkt(zzkvVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
