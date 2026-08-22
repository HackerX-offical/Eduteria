package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzen;
import com.google.android.gms.internal.firebase_auth.zzer;
import com.google.android.gms.internal.firebase_auth.zzfn;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.android.gms.internal.firebase_auth.zzfu;
import com.google.android.gms.internal.firebase_auth.zzfv;
import com.google.android.gms.internal.firebase_auth.zzfy;
import com.google.android.gms.internal.firebase_auth.zzga;
import com.google.android.gms.internal.firebase_auth.zzgd;
import com.google.android.gms.internal.firebase_auth.zzge;
import com.google.android.gms.internal.firebase_auth.zzgg;
import com.google.android.gms.internal.firebase_auth.zzgk;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zza {
    private static final Logger zza = new Logger("FBAuthApiDispatcher", new String[0]);
    private final zzfb zzb;
    private final zzar zzc;

    public zza(zzfb zzfbVar, zzar zzarVar) {
        this.zzb = (zzfb) Preconditions.checkNotNull(zzfbVar);
        this.zzc = (zzar) Preconditions.checkNotNull(zzarVar);
    }

    public final void zza(String str, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzes(str), new zzc(this, zzduVar));
    }

    public final void zza(zzgd zzgdVar, zzdu zzduVar) {
        Preconditions.checkNotNull(zzgdVar);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(zzgdVar, new zzl(this, zzduVar));
    }

    public final void zza(Context context, zzfy zzfyVar, zzdu zzduVar) {
        Preconditions.checkNotNull(zzfyVar);
        Preconditions.checkNotNull(zzduVar);
        if (this.zzc.zza()) {
            zzfyVar.zzc(true);
        }
        this.zzb.zza((Context) null, zzfyVar, new zzx(this, zzduVar));
    }

    public final void zzb(String str, zzdu zzduVar) {
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(new zzfu(str), new zzag(this, zzduVar));
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzaf(this, userProfileChangeRequest, zzduVar));
    }

    public final void zza(String str, String str2, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzai(this, str2, zzduVar));
    }

    public final void zzb(String str, String str2, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzah(this, str2, zzduVar));
    }

    public final void zzc(String str, String str2, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        zzfs zzfsVar = new zzfs();
        zzfsVar.zzh(str);
        zzfsVar.zzi(str2);
        this.zzb.zza(zzfsVar, new zzak(this, zzduVar));
    }

    private final void zza(String str, zzfd<com.google.android.gms.internal.firebase_auth.zzff> zzfdVar) {
        Preconditions.checkNotNull(zzfdVar);
        Preconditions.checkNotEmpty(str);
        com.google.android.gms.internal.firebase_auth.zzff zzffVarZzb = com.google.android.gms.internal.firebase_auth.zzff.zzb(str);
        if (zzffVarZzb.zzb()) {
            zzfdVar.zza(zzffVarZzb);
        } else {
            this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzes(zzffVarZzb.zzc()), new zzaj(this, zzfdVar));
        }
    }

    public final void zza(String str, String str2, String str3, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(new zzfu(str, str2, null, str3), new zzb(this, zzduVar));
    }

    public final void zza(Context context, String str, String str2, String str3, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza((Context) null, new zzge(str, str2, str3), new zze(this, zzduVar));
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzdu zzduVar) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzduVar);
        if (emailAuthCredential.zzf()) {
            zza(emailAuthCredential.zze(), new zzd(this, emailAuthCredential, zzduVar));
        } else {
            zza(new zzer(emailAuthCredential, null), zzduVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzer zzerVar, zzdu zzduVar) {
        Preconditions.checkNotNull(zzerVar);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(zzerVar, new zzg(this, zzduVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdu zzduVar, com.google.android.gms.internal.firebase_auth.zzff zzffVar, zzfs zzfsVar, zzfe zzfeVar) {
        Preconditions.checkNotNull(zzduVar);
        Preconditions.checkNotNull(zzffVar);
        Preconditions.checkNotNull(zzfsVar);
        Preconditions.checkNotNull(zzfeVar);
        this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzev(zzffVar.zzd()), new zzf(this, zzfeVar, zzduVar, zzffVar, zzfsVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdu zzduVar, com.google.android.gms.internal.firebase_auth.zzff zzffVar, com.google.android.gms.internal.firebase_auth.zzew zzewVar, zzfs zzfsVar, zzfe zzfeVar) {
        Preconditions.checkNotNull(zzduVar);
        Preconditions.checkNotNull(zzffVar);
        Preconditions.checkNotNull(zzewVar);
        Preconditions.checkNotNull(zzfsVar);
        Preconditions.checkNotNull(zzfeVar);
        this.zzb.zza(zzfsVar, new zzi(this, zzfsVar, zzewVar, zzduVar, zzffVar, zzfeVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.android.gms.internal.firebase_auth.zzff zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar, zzfv zzfvVar) {
        Preconditions.checkNotNull(zzffVar);
        Preconditions.checkNotNull(zzfvVar);
        String strZzb = zzfvVar.zzb();
        String strZzc = zzfvVar.zzc();
        return (TextUtils.isEmpty(strZzb) || TextUtils.isEmpty(strZzc)) ? zzffVar : new com.google.android.gms.internal.firebase_auth.zzff(strZzc, strZzb, Long.valueOf(zzfvVar.zzd()), zzffVar.zzf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar, String str, String str2, Boolean bool, com.google.firebase.auth.zzg zzgVar, zzdu zzduVar, zzfe zzfeVar) {
        Preconditions.checkNotNull(zzffVar);
        Preconditions.checkNotNull(zzfeVar);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(new com.google.android.gms.internal.firebase_auth.zzev(zzffVar.zzd()), new zzh(this, zzfeVar, str2, str, bool, zzgVar, zzduVar, zzffVar));
    }

    public final void zzd(String str, String str2, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(new zzen(str, str2), new zzk(this, zzduVar));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, String str2, zzdu zzduVar) {
        com.google.android.gms.internal.firebase_auth.zzfa zzfaVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        zzgk zzgkVarZza = zzgk.zza(actionCodeSettings.zzd());
        if (zzgkVarZza != null) {
            zzfaVar = new com.google.android.gms.internal.firebase_auth.zzfa(zzgkVarZza);
        } else {
            zzfaVar = new com.google.android.gms.internal.firebase_auth.zzfa(zzgk.OOB_REQ_TYPE_UNSPECIFIED);
        }
        zzfaVar.zza(str);
        zzfaVar.zza(actionCodeSettings);
        zzfaVar.zzc(str2);
        this.zzb.zza(zzfaVar, new zzj(this, zzduVar));
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        com.google.android.gms.internal.firebase_auth.zzfa zzfaVar = new com.google.android.gms.internal.firebase_auth.zzfa(zzgk.VERIFY_EMAIL);
        zzfaVar.zzb(str);
        if (actionCodeSettings != null) {
            zzfaVar.zza(actionCodeSettings);
        }
        zzb(zzfaVar, zzduVar);
    }

    public final void zze(String str, String str2, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(new zzfn(str, null, str2), new zzm(this, zzduVar));
    }

    public final void zzb(String str, String str2, String str3, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(new zzfn(str, str2, str3), new zzo(this, zzduVar));
    }

    public final void zza(zzfr zzfrVar, zzdu zzduVar) {
        Preconditions.checkNotEmpty(zzfrVar.zzb());
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(zzfrVar, new zzn(this, zzduVar));
    }

    public final void zza(Context context, zzgg zzggVar, zzdu zzduVar) {
        Preconditions.checkNotNull(zzggVar);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza((Context) null, zzggVar, new zzq(this, zzduVar));
    }

    public final void zzc(String str, String str2, String str3, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzduVar);
        zza(str3, new zzp(this, str, str2, zzduVar));
    }

    public final void zza(Context context, String str, zzgg zzggVar, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzggVar);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzs(this, zzggVar, null, zzduVar));
    }

    public final void zza(String str, zzfy zzfyVar, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzfyVar);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzu(this, zzfyVar, zzduVar));
    }

    public final void zzc(String str, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzw(this, zzduVar));
    }

    public final void zzf(String str, String str2, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzduVar);
        zza(str2, new zzv(this, str, zzduVar));
    }

    public final void zza(com.google.android.gms.internal.firebase_auth.zzfa zzfaVar, zzdu zzduVar) {
        zzb(zzfaVar, zzduVar);
    }

    public final void zzd(String str, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzaa(this, zzduVar));
    }

    public final void zze(String str, zzdu zzduVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzduVar);
        zza(str, new zzac(this, zzduVar));
    }

    public final void zzf(String str, zzdu zzduVar) {
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(str, new zzae(this, zzduVar));
    }

    private final void zzb(com.google.android.gms.internal.firebase_auth.zzfa zzfaVar, zzdu zzduVar) {
        Preconditions.checkNotNull(zzfaVar);
        Preconditions.checkNotNull(zzduVar);
        this.zzb.zza(zzfaVar, new zzad(this, zzduVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzga zzgaVar, zzdu zzduVar, zzfe zzfeVar) {
        Status statusZza;
        if (zzgaVar.zzk()) {
            com.google.firebase.auth.zzg zzgVarZzp = zzgaVar.zzp();
            String strZzd = zzgaVar.zzd();
            String strZzl = zzgaVar.zzl();
            if (zzgaVar.zzb()) {
                statusZza = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                statusZza = com.google.firebase.auth.internal.zzy.zza(zzgaVar.zzj());
            }
            if (this.zzc.zza()) {
                zzduVar.zza(new com.google.android.gms.internal.firebase_auth.zzeh(statusZza, zzgVarZzp, strZzd, strZzl));
                return;
            } else {
                zzduVar.zza(statusZza);
                return;
            }
        }
        zza(new com.google.android.gms.internal.firebase_auth.zzff(zzgaVar.zzg(), zzgaVar.zzc(), Long.valueOf(zzgaVar.zzh()), "Bearer"), zzgaVar.zzf(), zzgaVar.zze(), Boolean.valueOf(zzgaVar.zzi()), zzgaVar.zzp(), zzduVar, zzfeVar);
    }
}
