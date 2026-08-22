package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzbb extends zzae<String> {
    final CharSequence zza;
    private final zzaf zzb;
    private int zze;
    private int zzd = 0;
    private final boolean zzc = false;

    protected zzbb(zzau zzauVar, CharSequence charSequence) {
        this.zzb = zzauVar.zza;
        this.zze = zzauVar.zzd;
        this.zza = charSequence;
    }

    abstract int zza(int i);

    abstract int zzb(int i);

    @Override // com.google.android.gms.internal.firebase_auth.zzae
    protected final /* synthetic */ String zza() {
        int iZza;
        int i = this.zzd;
        while (true) {
            int i2 = this.zzd;
            if (i2 != -1) {
                iZza = zza(i2);
                if (iZza == -1) {
                    iZza = this.zza.length();
                    this.zzd = -1;
                } else {
                    this.zzd = zzb(iZza);
                }
                int i3 = this.zzd;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.zzd = i4;
                    if (i4 > this.zza.length()) {
                        this.zzd = -1;
                    }
                } else {
                    while (i < iZza && this.zzb.zza(this.zza.charAt(i))) {
                        i++;
                    }
                    while (iZza > i && this.zzb.zza(this.zza.charAt(iZza - 1))) {
                        iZza--;
                    }
                    if (!this.zzc || i != iZza) {
                        break;
                    }
                    i = this.zzd;
                }
            } else {
                zzb();
                return null;
            }
        }
        int i5 = this.zze;
        if (i5 == 1) {
            iZza = this.zza.length();
            this.zzd = -1;
            while (iZza > i && this.zzb.zza(this.zza.charAt(iZza - 1))) {
                iZza--;
            }
        } else {
            this.zze = i5 - 1;
        }
        return this.zza.subSequence(i, iZza).toString();
    }
}
