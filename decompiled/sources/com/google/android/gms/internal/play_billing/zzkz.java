package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzkz extends zzgs implements zzhv {
    private static final zzkz zzb;
    private int zzd;
    private int zze;
    private boolean zzf;

    static {
        zzkz zzkzVar = new zzkz();
        zzb = zzkzVar;
        zzgs.zzx(zzkz.class, zzkzVar);
    }

    private zzkz() {
    }

    static /* synthetic */ void zzC(zzkz zzkzVar, boolean z) {
        zzkzVar.zzd |= 2;
        zzkzVar.zzf = true;
    }

    public static zzkx zzc() {
        return (zzkx) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzkz();
        }
        zzky zzkyVar = null;
        if (i2 == 4) {
            return new zzkx(zzkyVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
