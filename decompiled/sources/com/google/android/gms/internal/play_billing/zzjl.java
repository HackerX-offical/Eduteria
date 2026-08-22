package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzjl extends zzgs implements zzhv {
    private static final zzjl zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        zzjl zzjlVar = new zzjl();
        zzb = zzjlVar;
        zzgs.zzx(zzjl.class, zzjlVar);
    }

    private zzjl() {
    }

    static /* synthetic */ void zzC(zzjl zzjlVar, zzkj zzkjVar) {
        zzkjVar.getClass();
        zzjlVar.zzf = zzkjVar;
        zzjlVar.zze = 2;
    }

    static /* synthetic */ void zzD(zzjl zzjlVar, zzkz zzkzVar) {
        zzkzVar.getClass();
        zzjlVar.zzf = zzkzVar;
        zzjlVar.zze = 3;
    }

    static /* synthetic */ void zzE(zzjl zzjlVar, int i) {
        zzjlVar.zzg = i - 1;
        zzjlVar.zzd |= 1;
    }

    public static zzjj zzc() {
        return (zzjj) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzji.zza, zzkj.class, zzkz.class});
        }
        if (i2 == 3) {
            return new zzjl();
        }
        zzjk zzjkVar = null;
        if (i2 == 4) {
            return new zzjj(zzjkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
