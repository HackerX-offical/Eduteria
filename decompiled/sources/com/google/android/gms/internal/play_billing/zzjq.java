package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzjq extends zzgs implements zzhv {
    private static final zzjq zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        zzjq zzjqVar = new zzjq();
        zzb = zzjqVar;
        zzgs.zzx(zzjq.class, zzjqVar);
    }

    private zzjq() {
    }

    static /* synthetic */ void zzC(zzjq zzjqVar, String str) {
        zzjqVar.zzd |= 8;
        zzjqVar.zzh = str;
    }

    static /* synthetic */ void zzD(zzjq zzjqVar, String str) {
        str.getClass();
        zzjqVar.zzd |= 2;
        zzjqVar.zzf = str;
    }

    static /* synthetic */ void zzE(zzjq zzjqVar, int i) {
        zzjqVar.zzd |= 1;
        zzjqVar.zze = i;
    }

    static /* synthetic */ void zzF(zzjq zzjqVar, int i) {
        zzjqVar.zzg = i - 1;
        zzjqVar.zzd |= 4;
    }

    public static zzjm zzc() {
        return (zzjm) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzjn.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzjq();
        }
        zzjp zzjpVar = null;
        if (i2 == 4) {
            return new zzjm(zzjpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
