package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.EmailAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzer implements com.google.firebase.auth.api.internal.zzfk<zzp.zzd> {
    private static final Logger zza = new Logger("EmailLinkSignInRequest", new String[0]);
    private final String zzb;
    private final String zzc;
    private final String zzd;

    public zzer(EmailAuthCredential emailAuthCredential, String str) {
        this.zzb = Preconditions.checkNotEmpty(emailAuthCredential.zzb());
        this.zzc = Preconditions.checkNotEmpty(emailAuthCredential.zzd());
        this.zzd = str;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzp.zzd.zza zzaVarZzb = zzp.zzd.zza().zzb(this.zzb);
        com.google.firebase.auth.zzf zzfVarZza = com.google.firebase.auth.zzf.zza(this.zzc);
        String strZzb = zzfVarZza != null ? zzfVarZza.zzb() : null;
        String strZzc = zzfVarZza != null ? zzfVarZza.zzc() : null;
        if (strZzb != null) {
            zzaVarZzb.zza(strZzb);
        }
        if (strZzc != null) {
            zzaVarZzb.zzd(strZzc);
        }
        String str = this.zzd;
        if (str != null) {
            zzaVarZzb.zzc(str);
        }
        return (zzp.zzd) ((zzie) zzaVarZzb.zzf());
    }
}
