package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzgn implements zzhs {
    private static final zzgn zza = new zzgn();

    private zzgn() {
    }

    public static zzgn zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final zzhr zzb(Class cls) {
        if (!zzgs.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzhr) zzgs.zzo(cls.asSubclass(zzgs.class)).zzd(3, null, null);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhs
    public final boolean zzc(Class cls) {
        return zzgs.class.isAssignableFrom(cls);
    }
}
