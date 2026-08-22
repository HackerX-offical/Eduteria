package com.google.android.gms.internal.firebase_auth;

import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public enum zzgk implements zzij {
    OOB_REQ_TYPE_UNSPECIFIED(0),
    PASSWORD_RESET(1),
    OLD_EMAIL_AGREE(2),
    NEW_EMAIL_ACCEPT(3),
    VERIFY_EMAIL(4),
    RECOVER_EMAIL(5),
    EMAIL_SIGNIN(6),
    VERIFY_AND_CHANGE_EMAIL(7),
    REVERT_SECOND_FACTOR_ADDITION(8);

    private static final zzii<zzgk> zzj = new zzii<zzgk>() { // from class: com.google.android.gms.internal.firebase_auth.zzgj
    };
    private final int zzk;

    @Override // com.google.android.gms.internal.firebase_auth.zzij
    public final int zza() {
        return this.zzk;
    }

    public static zzgk zza(int i) {
        switch (i) {
            case 0:
                return OOB_REQ_TYPE_UNSPECIFIED;
            case 1:
                return PASSWORD_RESET;
            case 2:
                return OLD_EMAIL_AGREE;
            case 3:
                return NEW_EMAIL_ACCEPT;
            case 4:
                return VERIFY_EMAIL;
            case 5:
                return RECOVER_EMAIL;
            case 6:
                return EMAIL_SIGNIN;
            case 7:
                return VERIFY_AND_CHANGE_EMAIL;
            case 8:
                return REVERT_SECOND_FACTOR_ADDITION;
            default:
                return null;
        }
    }

    public static zzil zzb() {
        return zzgm.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" number=").append(this.zzk);
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    zzgk(int i) {
        this.zzk = i;
    }
}
