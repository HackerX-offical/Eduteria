package com.google.firebase.auth.api.internal;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfl {
    public static String zza(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
            if (objInvoke != null && String.class.isAssignableFrom(objInvoke.getClass())) {
                return (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
