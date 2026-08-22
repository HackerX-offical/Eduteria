package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzgg;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzff {
    public static zzgg zza(PhoneAuthCredential phoneAuthCredential) {
        return !TextUtils.isEmpty(phoneAuthCredential.zze()) ? zzgg.zzb(phoneAuthCredential.zzc(), phoneAuthCredential.zze(), phoneAuthCredential.zzd()) : zzgg.zza(phoneAuthCredential.zzb(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zzd());
    }
}
