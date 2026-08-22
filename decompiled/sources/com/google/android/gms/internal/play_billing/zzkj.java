package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkj extends zzgs implements zzhv {
    private static final zzkj zzb;
    private int zzd;
    private int zze;

    static {
        zzkj zzkjVar = new zzkj();
        zzb = zzkjVar;
        zzgs.zzx(zzkj.class, zzkjVar);
    }

    private zzkj() {
    }

    static /* synthetic */ void zzC(zzkj zzkjVar, int i) {
        zzkjVar.zze = i - 1;
        zzkjVar.zzd |= 1;
    }

    public static zzkg zzc() {
        return (zzkg) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzkh.zza});
        }
        if (i2 == 3) {
            return new zzkj();
        }
        zzki zzkiVar = null;
        if (i2 == 4) {
            return new zzkg(zzkiVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
