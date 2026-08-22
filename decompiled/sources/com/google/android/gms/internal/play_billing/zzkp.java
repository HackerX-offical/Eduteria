package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkp extends zzgs implements zzhv {
    private static final zzkp zzb;
    private int zzd;
    private int zzf;
    private zzgw zze = zzgs.zzs();
    private String zzg = "";

    static {
        zzkp zzkpVar = new zzkp();
        zzb = zzkpVar;
        zzgs.zzx(zzkp.class, zzkpVar);
    }

    private zzkp() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzkp();
        }
        zzko zzkoVar = null;
        if (i2 == 4) {
            return new zzkn(zzkoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
