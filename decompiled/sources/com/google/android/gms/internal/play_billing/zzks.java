package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzks extends zzgs implements zzhv {
    private static final zzks zzb;
    private int zzd;
    private zzjq zze;

    static {
        zzks zzksVar = new zzks();
        zzb = zzksVar;
        zzgs.zzx(zzks.class, zzksVar);
    }

    private zzks() {
    }

    static /* synthetic */ void zzC(zzks zzksVar, zzjq zzjqVar) {
        zzjqVar.getClass();
        zzksVar.zze = zzjqVar;
        zzksVar.zzd |= 1;
    }

    public static zzkq zzc() {
        return (zzkq) zzb.zzm();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzks();
        }
        zzkr zzkrVar = null;
        if (i2 == 4) {
            return new zzkq(zzkrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
