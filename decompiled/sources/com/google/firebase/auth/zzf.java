package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzbk;
import com.google.android.gms.internal.firebase_auth.zzbl;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Set;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzf {
    private static final zzbl<String, Integer> zzg = new zzbk().zza("recoverEmail", 2).zza("resetPassword", 0).zza("signIn", 4).zza("verifyEmail", 1).zza("verifyBeforeChangeEmail", 5).zza("revertSecondFactorAddition", 6).zza();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;

    private zzf(String str) {
        String strZza = zza(str, DynamicLink.Builder.KEY_API_KEY);
        this.zza = strZza;
        String strZza2 = zza(str, "oobCode");
        this.zzb = strZza2;
        String strZza3 = zza(str, "mode");
        this.zzc = strZza3;
        if (strZza == null || strZza2 == null || strZza3 == null) {
            throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", DynamicLink.Builder.KEY_API_KEY, "oobCode", "mode"));
        }
        this.zzd = zza(str, "continueUrl");
        this.zze = zza(str, "languageCode");
        this.zzf = zza(str, "tenantId");
    }

    public static zzf zza(String str) {
        Preconditions.checkNotEmpty(str);
        try {
            return new zzf(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final int zza() {
        return zzg.getOrDefault(this.zzc, 3).intValue();
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzf;
    }

    private static String zza(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(uri.getQueryParameter("link")).getQueryParameter(str2);
            }
            return null;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }
}
