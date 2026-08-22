package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzhm implements zzig {
    private static final zzhs zza = new zzhk();
    private final zzhs zzb;

    public zzhm() {
        zzhs zzhsVar = zza;
        int i = zzic.zza;
        zzhl zzhlVar = new zzhl(zzgn.zza(), zzhsVar);
        byte[] bArr = zzgx.zzb;
        this.zzb = zzhlVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzig
    public final zzif zza(Class cls) {
        int i = zzih.zza;
        if (!zzgs.class.isAssignableFrom(cls)) {
            int i2 = zzic.zza;
        }
        zzhr zzhrVarZzb = this.zzb.zzb(cls);
        if (zzhrVarZzb.zzb()) {
            int i3 = zzic.zza;
            return zzhy.zzc(zzih.zzm(), zzgh.zza(), zzhrVarZzb.zza());
        }
        int i4 = zzic.zza;
        return zzhx.zzl(cls, zzhrVarZzb, zzia.zza(), zzhi.zza(), zzih.zzm(), zzhrVarZzb.zzc() + (-1) != 1 ? zzgh.zza() : null, zzhq.zza());
    }
}
