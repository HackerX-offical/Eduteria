package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzbl;
import com.google.firebase.auth.GetTokenResult;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzap {
    private static final Logger zza = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zza(String str) {
        Map mapZza;
        try {
            mapZza = zzao.zza(str);
        } catch (com.google.firebase.auth.api.zza e2) {
            zza.e("Error parsing token claims", e2, new Object[0]);
            mapZza = zzbl.zza();
        }
        return new GetTokenResult(str, mapZza);
    }
}
