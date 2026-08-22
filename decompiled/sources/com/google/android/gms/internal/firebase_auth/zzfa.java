package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.ActionCodeSettings;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfa implements com.google.firebase.auth.api.internal.zzfk<zzp.zzh> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    private String zzf;

    public zzfa(zzgk zzgkVar) {
        this.zza = zza(zzgkVar);
    }

    private zzfa(zzgk zzgkVar, ActionCodeSettings actionCodeSettings, String str, String str2, String str3, String str4) {
        this.zza = zza((zzgk) Preconditions.checkNotNull(zzgkVar));
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
    }

    public static zzfa zza(ActionCodeSettings actionCodeSettings, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        return new zzfa(zzgk.VERIFY_AND_CHANGE_EMAIL, actionCodeSettings, null, str2, str, null);
    }

    public final zzfa zza(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzfa zzb(String str) {
        this.zzd = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzfa zza(ActionCodeSettings actionCodeSettings) {
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzfa zzc(String str) {
        this.zzf = str;
        return this;
    }

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    private static String zza(zzgk zzgkVar) {
        int i = zzfd.zza[zzgkVar.ordinal()];
        if (i == 1) {
            return "PASSWORD_RESET";
        }
        if (i == 2) {
            return "VERIFY_EMAIL";
        }
        if (i == 3) {
            return "EMAIL_SIGNIN";
        }
        if (i == 4) {
            return "VERIFY_BEFORE_UPDATE_EMAIL";
        }
        return "REQUEST_TYPE_UNSET_ENUM_VALUE";
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzgk zzgkVar;
        zzp.zzh.zza zzaVarZza = zzp.zzh.zza();
        String str = this.zza;
        str.hashCode();
        switch (str) {
            case "PASSWORD_RESET":
                zzgkVar = zzgk.PASSWORD_RESET;
                break;
            case "VERIFY_EMAIL":
                zzgkVar = zzgk.VERIFY_EMAIL;
                break;
            case "VERIFY_BEFORE_UPDATE_EMAIL":
                zzgkVar = zzgk.VERIFY_AND_CHANGE_EMAIL;
                break;
            case "EMAIL_SIGNIN":
                zzgkVar = zzgk.EMAIL_SIGNIN;
                break;
            default:
                zzgkVar = zzgk.OOB_REQ_TYPE_UNSPECIFIED;
                break;
        }
        zzp.zzh.zza zzaVarZza2 = zzaVarZza.zza(zzgkVar);
        String str2 = this.zzb;
        if (str2 != null) {
            zzaVarZza2.zza(str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            zzaVarZza2.zzb(str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            zzaVarZza2.zzc(str4);
        }
        ActionCodeSettings actionCodeSettings = this.zze;
        if (actionCodeSettings != null) {
            zzaVarZza2.zza(actionCodeSettings.getAndroidInstallApp()).zzb(this.zze.canHandleCodeInApp());
            if (this.zze.getUrl() != null) {
                zzaVarZza2.zzd(this.zze.getUrl());
            }
            if (this.zze.getIOSBundle() != null) {
                zzaVarZza2.zze(this.zze.getIOSBundle());
            }
            if (this.zze.zzb() != null) {
                zzaVarZza2.zzf(this.zze.zzb());
            }
            if (this.zze.getAndroidPackageName() != null) {
                zzaVarZza2.zzg(this.zze.getAndroidPackageName());
            }
            if (this.zze.getAndroidMinimumVersion() != null) {
                zzaVarZza2.zzh(this.zze.getAndroidMinimumVersion());
            }
            if (this.zze.zze() != null) {
                zzaVarZza2.zzj(this.zze.zze());
            }
        }
        String str5 = this.zzf;
        if (str5 != null) {
            zzaVarZza2.zzi(str5);
        }
        return (zzp.zzh) ((zzie) zzaVarZza2.zzf());
    }
}
