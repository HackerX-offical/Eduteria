package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzaz implements zzba {
    private final /* synthetic */ zzal zza;

    zzaz(zzal zzalVar) {
        this.zza = zzalVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzba
    public final /* synthetic */ Iterator zza(zzau zzauVar, CharSequence charSequence) {
        return new zzay(this, zzauVar, charSequence, this.zza.zza(charSequence));
    }
}
