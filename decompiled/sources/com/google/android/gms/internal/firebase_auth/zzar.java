package com.google.android.gms.internal.firebase_auth;

import java.util.logging.Logger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzar {
    private static final Logger zza = Logger.getLogger(zzar.class.getName());
    private static final zzas zzb = new zza();

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    static final class zza implements zzas {
        private zza() {
        }

        @Override // com.google.android.gms.internal.firebase_auth.zzas
        public final zzal zza(String str) {
            return new zzan(Pattern.compile(str));
        }
    }

    private zzar() {
    }

    static zzal zza(String str) {
        zzav.zza(str);
        return zzb.zza(str);
    }
}
