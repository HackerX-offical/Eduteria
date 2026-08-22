package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzey extends zzgs implements zzhv {
    private static final zzey zzb;
    private int zzd;
    private String zze = "";

    static {
        zzey zzeyVar = new zzey();
        zzb = zzeyVar;
        zzgs.zzx(zzey.class, zzeyVar);
    }

    private zzey() {
    }

    public static zzex zza() {
        return (zzex) zzb.zzm();
    }

    static /* synthetic */ void zzc(zzey zzeyVar, String str) {
        zzeyVar.zzd |= 1;
        zzeyVar.zze = str;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzey();
        }
        zzez zzezVar = null;
        if (i2 == 4) {
            return new zzex(zzezVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
