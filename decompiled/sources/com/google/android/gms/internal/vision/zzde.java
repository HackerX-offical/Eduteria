package com.google.android.gms.internal.vision;

import com.google.firebase.analytics.FirebaseAnalytics;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzde {
    public static void zza(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void zzb(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @NonNullDecl
    public static <T> T zza(@NonNullDecl T t) {
        t.getClass();
        return t;
    }

    @NonNullDecl
    public static <T> T zza(@NonNullDecl T t, @NullableDecl Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int zza(int i, int i2) {
        String strZza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZza = zzdg.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else if (i2 >= 0) {
            strZza = zzdg.zza("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i2).toString());
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zza(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    private static String zza(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return zzdg.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(new StringBuilder(26).append("negative size: ").append(i2).toString());
        }
        return zzdg.zza("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void zza(int i, int i2, int i3) {
        String strZza;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZza = zza(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                strZza = zza(i2, i3, "end index");
            } else {
                strZza = zzdg.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZza);
        }
    }
}
