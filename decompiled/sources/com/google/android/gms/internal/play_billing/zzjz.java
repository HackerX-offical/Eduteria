package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzjz extends zzgs implements zzhv {
    private static final zzjz zzb;
    private int zzd;
    private int zzf;
    private zzjq zzi;
    private boolean zzj;
    private boolean zzk;
    private String zze = "";
    private zzgv zzg = zzr();
    private zzgw zzh = zzs();

    static {
        zzjz zzjzVar = new zzjz();
        zzb = zzjzVar;
        zzgs.zzx(zzjz.class, zzjzVar);
    }

    private zzjz() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ࠬ\u0004\u001b\u0005ဉ\u0002\u0006ဇ\u0003\u0007ဇ\u0004", new Object[]{"zzd", "zze", "zzf", zzjx.zza, "zzg", zzju.zza, "zzh", zzkp.class, "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzjz();
        }
        zzjy zzjyVar = null;
        if (i2 == 4) {
            return new zzjw(zzjyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
