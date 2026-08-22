package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
public final class zzf extends zza<Long> {
    public static Long zza(SharedPreferences sharedPreferences, String str, Long l) {
        try {
            return (Long) com.google.android.gms.internal.flags.zze.zza(new zzg(sharedPreferences, str, l));
        } catch (Exception e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return l;
        }
    }
}
