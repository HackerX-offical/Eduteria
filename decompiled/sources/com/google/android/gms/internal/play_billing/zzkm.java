package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkm extends zzgs implements zzhv {
    private static final zzkm zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private zzkc zzg;
    private zzkf zzh;

    static {
        zzkm zzkmVar = new zzkm();
        zzb = zzkmVar;
        zzgs.zzx(zzkm.class, zzkmVar);
    }

    private zzkm() {
    }

    static /* synthetic */ void zzC(zzkm zzkmVar, zzjh zzjhVar) {
        zzkmVar.zzf = zzjhVar;
        zzkmVar.zze = 2;
    }

    static /* synthetic */ void zzD(zzkm zzkmVar, zzjl zzjlVar) {
        zzkmVar.zzf = zzjlVar;
        zzkmVar.zze = 3;
    }

    static /* synthetic */ void zzE(zzkm zzkmVar, zzjt zzjtVar) {
        zzjtVar.getClass();
        zzkmVar.zzf = zzjtVar;
        zzkmVar.zze = 7;
    }

    static /* synthetic */ void zzF(zzkm zzkmVar, zzkc zzkcVar) {
        zzkcVar.getClass();
        zzkmVar.zzg = zzkcVar;
        zzkmVar.zzd |= 1;
    }

    static /* synthetic */ void zzG(zzkm zzkmVar, zzks zzksVar) {
        zzksVar.getClass();
        zzkmVar.zzf = zzksVar;
        zzkmVar.zze = 8;
    }

    static /* synthetic */ void zzH(zzkm zzkmVar, zzkw zzkwVar) {
        zzkmVar.zzf = zzkwVar;
        zzkmVar.zze = 4;
    }

    public static zzkk zzc() {
        return (zzkk) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\b\u0001\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001\u0007<\u0000\b<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzjh.class, zzjl.class, zzkw.class, zzjz.class, "zzh", zzjt.class, zzks.class});
        }
        if (i2 == 3) {
            return new zzkm();
        }
        zzkl zzklVar = null;
        if (i2 == 4) {
            return new zzkk(zzklVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
