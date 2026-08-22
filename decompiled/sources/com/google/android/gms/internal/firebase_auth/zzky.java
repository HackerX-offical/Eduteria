package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzky extends RuntimeException {
    private final List<String> zza;

    public zzky(zzjp zzjpVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zza = null;
    }
}
