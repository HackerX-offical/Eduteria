package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzeh {
    public static final Api<zzei> zza;
    private static final Api.ClientKey<zzdt> zzb;
    private static final Api.AbstractClientBuilder<zzdt, zzei> zzc;

    public static zzau zza(Context context, zzei zzeiVar) {
        return new zzau(context, zzeiVar);
    }

    static {
        Api.ClientKey<zzdt> clientKey = new Api.ClientKey<>();
        zzb = clientKey;
        zzej zzejVar = new zzej();
        zzc = zzejVar;
        zza = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzejVar, clientKey);
    }
}
