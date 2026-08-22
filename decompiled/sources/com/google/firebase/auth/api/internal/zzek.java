package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzek {
    private final String zza;
    private final int zzb;
    private final int zzc = -1;

    private zzek(String str, int i) {
        this.zza = str;
        this.zzb = zzd(str);
    }

    public final String zza() {
        int i = this.zzb;
        if (i != -1) {
            return String.format("X%s", Integer.toString(i));
        }
        return Integer.toString(this.zzc);
    }

    final boolean zza(String str) {
        return this.zzb >= zzd(str);
    }

    final boolean zzb(String str) {
        return this.zzb >= zzd(str);
    }

    static String zzb() {
        return zzc("firebase-auth");
    }

    private static String zzc(String str) throws Throwable {
        String version = LibraryVersion.getInstance().getVersion(str);
        return (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) ? "-1" : version;
    }

    static zzek zzc() {
        return new zzek(zzc("firebase-auth-compat"), -1);
    }

    private static int zzd(String str) {
        try {
            List<String> listZza = com.google.android.gms.internal.firebase_auth.zzau.zza("[.-]").zza((CharSequence) str);
            if (listZza.size() == 1) {
                return Integer.parseInt(str);
            }
            if (listZza.size() >= 3) {
                return (Integer.parseInt(listZza.get(0)) * 1000000) + (Integer.parseInt(listZza.get(1)) * 1000) + Integer.parseInt(listZza.get(2));
            }
            return -1;
        } catch (IllegalArgumentException e2) {
            if (!Log.isLoggable("LibraryVersionContainer", 3)) {
                return -1;
            }
            Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", str, e2));
            return -1;
        }
    }
}
