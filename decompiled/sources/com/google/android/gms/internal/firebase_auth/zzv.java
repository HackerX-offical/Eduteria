package com.google.android.gms.internal.firebase_auth;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public enum zzv implements zzij {
    USER_ATTRIBUTE_NAME_UNSPECIFIED(0),
    EMAIL(1),
    DISPLAY_NAME(2),
    PROVIDER(3),
    PHOTO_URL(4),
    PASSWORD(5),
    RAW_USER_INFO(6);

    private static final zzii<zzv> zzh = new zzii<zzv>() { // from class: com.google.android.gms.internal.firebase_auth.zzx
    };
    private final int zzi;

    @Override // com.google.android.gms.internal.firebase_auth.zzij
    public final int zza() {
        return this.zzi;
    }

    public static zzv zza(int i) {
        switch (i) {
            case 0:
                return USER_ATTRIBUTE_NAME_UNSPECIFIED;
            case 1:
                return EMAIL;
            case 2:
                return DISPLAY_NAME;
            case 3:
                return PROVIDER;
            case 4:
                return PHOTO_URL;
            case 5:
                return PASSWORD;
            case 6:
                return RAW_USER_INFO;
            default:
                return null;
        }
    }

    public static zzil zzb() {
        return zzw.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzi);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzv(int i) {
        this.zzi = i;
    }
}
