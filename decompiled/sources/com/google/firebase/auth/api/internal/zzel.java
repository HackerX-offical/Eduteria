package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzel {
    private String zza;

    public zzel(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final zzei zza() {
        return new zzei(this.zza, null);
    }
}
