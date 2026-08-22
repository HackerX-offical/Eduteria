package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzjt extends zzgs implements zzhv {
    private static final zzjt zzb;

    static {
        zzjt zzjtVar = new zzjt();
        zzb = zzjtVar;
        zzgs.zzx(zzjt.class, zzjtVar);
    }

    private zzjt() {
    }

    public static zzjt zzB() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzjs zzjsVar = null;
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new zzjt();
        }
        if (i2 == 4) {
            return new zzjr(zzjsVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
