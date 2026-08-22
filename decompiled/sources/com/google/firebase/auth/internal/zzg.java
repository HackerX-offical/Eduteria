package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.ActionCodeResult;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzg implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final com.google.firebase.auth.zza zzd;

    public zzg(zzfm zzfmVar) {
        int i;
        this.zzb = zzfmVar.zzg() ? zzfmVar.zzc() : zzfmVar.zzb();
        this.zzc = zzfmVar.zzb();
        com.google.firebase.auth.zza zzeVar = null;
        if (!zzfmVar.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String strZzd = zzfmVar.zzd();
        strZzd.hashCode();
        i = 5;
        switch (strZzd) {
            case "REVERT_SECOND_FACTOR_ADDITION":
                i = 6;
                break;
            case "PASSWORD_RESET":
                i = 0;
                break;
            case "VERIFY_EMAIL":
                i = 1;
                break;
            case "VERIFY_BEFORE_UPDATE_EMAIL":
                break;
            case "EMAIL_SIGNIN":
                i = 4;
                break;
            case "RECOVER_EMAIL":
                i = 2;
                break;
            default:
                i = 3;
                break;
        }
        this.zza = i;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        if (zzfmVar.zzi()) {
            zzeVar = new zzd(zzfmVar.zzb(), zzar.zza(zzfmVar.zze()));
        } else if (zzfmVar.zzg()) {
            zzeVar = new zzb(zzfmVar.zzc(), zzfmVar.zzb());
        } else if (zzfmVar.zzf()) {
            zzeVar = new zze(zzfmVar.zzb());
        }
        this.zzd = zzeVar;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final int getOperation() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.ActionCodeResult
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i == 0) {
            return this.zzb;
        }
        if (i != 1) {
            return null;
        }
        return this.zzc;
    }
}
