package com.google.android.gms.internal.firebase_auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzay extends zzbb {
    private final /* synthetic */ zzam zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzay(zzaz zzazVar, zzau zzauVar, CharSequence charSequence, zzam zzamVar) {
        super(zzauVar, charSequence);
        this.zzb = zzamVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbb
    public final int zza(int i) {
        if (this.zzb.zza(i)) {
            return this.zzb.zzc();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzbb
    public final int zzb(int i) {
        return this.zzb.zzb();
    }
}
