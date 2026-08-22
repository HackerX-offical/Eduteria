package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkf extends zzgs implements zzhv {
    private static final zzkf zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzkf zzkfVar = new zzkf();
        zzb = zzkfVar;
        zzgs.zzx(zzkf.class, zzkfVar);
    }

    private zzkf() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzkf();
        }
        zzke zzkeVar = null;
        if (i2 == 4) {
            return new zzkd(zzkeVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
