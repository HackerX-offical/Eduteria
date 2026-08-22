package com.google.android.gms.internal.firebase_auth;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzan extends zzal implements Serializable {
    private final Pattern zza;

    zzan(Pattern pattern) {
        this.zza = (Pattern) zzav.zza(pattern);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzal
    public final zzam zza(CharSequence charSequence) {
        return new zzaq(this.zza.matcher(charSequence));
    }

    public final String toString() {
        return this.zza.toString();
    }
}
