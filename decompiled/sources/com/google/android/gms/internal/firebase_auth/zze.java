package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zze {
    public static final Feature zza;
    public static final Feature[] zzb;
    private static final Feature zzc;
    private static final Feature zzd;

    static {
        Feature feature = new Feature("firebase_auth", 11L);
        zzc = feature;
        Feature feature2 = new Feature("firebase_auth_aidl_migration", 1L);
        zza = feature2;
        Feature feature3 = new Feature("firebase_auth_multi_factor_auth", 1L);
        zzd = feature3;
        zzb = new Feature[]{feature, feature2, feature3};
    }
}
