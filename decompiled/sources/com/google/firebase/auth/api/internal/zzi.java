package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.android.gms.internal.firebase_auth.zzfs;
import com.google.android.gms.internal.firebase_auth.zzfv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzi implements zzfd<zzfv> {
    private final /* synthetic */ zzfs zza;
    private final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzew zzb;
    private final /* synthetic */ zzdu zzc;
    private final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzff zzd;
    private final /* synthetic */ zzfe zze;
    private final /* synthetic */ zza zzf;

    zzi(zza zzaVar, zzfs zzfsVar, com.google.android.gms.internal.firebase_auth.zzew zzewVar, zzdu zzduVar, com.google.android.gms.internal.firebase_auth.zzff zzffVar, zzfe zzfeVar) {
        this.zzf = zzaVar;
        this.zza = zzfsVar;
        this.zzb = zzewVar;
        this.zzc = zzduVar;
        this.zzd = zzffVar;
        this.zze = zzfeVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zze.zza(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(zzfv zzfvVar) {
        zzfv zzfvVar2 = zzfvVar;
        if (this.zza.zza("EMAIL")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zza("DISPLAY_NAME")) {
            this.zzb.zzb(null);
        } else if (this.zza.zzd() != null) {
            this.zzb.zzb(this.zza.zzd());
        }
        if (this.zza.zza("PHOTO_URL")) {
            this.zzb.zzc(null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzc(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzc())) {
            this.zzb.zzd(Base64Utils.encode("redacted".getBytes()));
        }
        List<zzfj> listZzf = zzfvVar2.zzf();
        if (listZzf == null) {
            listZzf = new ArrayList<>();
        }
        this.zzb.zza(listZzf);
        zzdu zzduVar = this.zzc;
        zza zzaVar = this.zzf;
        zzduVar.zza(zza.zza(this.zzd, zzfvVar2), this.zzb);
    }
}
