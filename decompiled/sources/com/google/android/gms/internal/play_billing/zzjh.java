package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzjh extends zzgs implements zzhv {
    private static final zzjh zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private zzjq zzh;

    static {
        zzjh zzjhVar = new zzjh();
        zzb = zzjhVar;
        zzgs.zzx(zzjh.class, zzjhVar);
    }

    private zzjh() {
    }

    public static zzjh zzC(byte[] bArr, zzge zzgeVar) throws zzgz {
        return (zzjh) zzgs.zzq(zzb, bArr, zzgeVar);
    }

    static /* synthetic */ void zzD(zzjh zzjhVar, zzjq zzjqVar) {
        zzjqVar.getClass();
        zzjhVar.zzh = zzjqVar;
        zzjhVar.zzd |= 2;
    }

    static /* synthetic */ void zzE(zzjh zzjhVar, zzkj zzkjVar) {
        zzkjVar.getClass();
        zzjhVar.zzf = zzkjVar;
        zzjhVar.zze = 4;
    }

    static /* synthetic */ void zzF(zzjh zzjhVar, int i) {
        zzjhVar.zzg = i - 1;
        zzjhVar.zzd |= 1;
    }

    public static zzjf zzc() {
        return (zzjf) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzji.zza, "zzh", zzkj.class});
        }
        if (i2 == 3) {
            return new zzjh();
        }
        zzjg zzjgVar = null;
        if (i2 == 4) {
            return new zzjf(zzjgVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
