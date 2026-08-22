package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkc extends zzgs implements zzhv {
    private static final zzkc zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;
    private long zzh;

    static {
        zzkc zzkcVar = new zzkc();
        zzb = zzkcVar;
        zzgs.zzx(zzkc.class, zzkcVar);
    }

    private zzkc() {
    }

    static /* synthetic */ void zzC(zzkc zzkcVar, int i) {
        zzkcVar.zzd |= 4;
        zzkcVar.zzg = i;
    }

    static /* synthetic */ void zzD(zzkc zzkcVar, long j) {
        zzkcVar.zzd |= 8;
        zzkcVar.zzh = j;
    }

    static /* synthetic */ void zzE(zzkc zzkcVar, String str) {
        str.getClass();
        zzkcVar.zzd |= 2;
        zzkcVar.zzf = str;
    }

    static /* synthetic */ void zzF(zzkc zzkcVar, String str) {
        str.getClass();
        zzkcVar.zzd |= 1;
        zzkcVar.zze = str;
    }

    public static zzka zzc() {
        return (zzka) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004ဂ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzkc();
        }
        zzkb zzkbVar = null;
        if (i2 == 4) {
            return new zzka(zzkbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
