package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzev extends zzgs implements zzhv {
    private static final zzev zzb;
    private zzgw zzd = zzs();

    static {
        zzev zzevVar = new zzev();
        zzb = zzevVar;
        zzgs.zzx(zzev.class, zzevVar);
    }

    private zzev() {
    }

    public static zzeu zza() {
        return (zzeu) zzb.zzm();
    }

    static /* synthetic */ void zzc(zzev zzevVar, Iterable iterable) {
        zzgw zzgwVar = zzevVar.zzd;
        if (!zzgwVar.zzc()) {
            int size = zzgwVar.size();
            zzevVar.zzd = zzgwVar.zzd(size + size);
        }
        zzfd.zzg(iterable, zzevVar.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgs
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzet.class});
        }
        if (i2 == 3) {
            return new zzev();
        }
        zzew zzewVar = null;
        if (i2 == 4) {
            return new zzeu(zzewVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
