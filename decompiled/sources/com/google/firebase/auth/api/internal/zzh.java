package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzfj;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzh implements zzfd<com.google.android.gms.internal.firebase_auth.zzeu> {
    private final /* synthetic */ zzfe zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ com.google.firebase.auth.zzg zze;
    private final /* synthetic */ zzdu zzf;
    private final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzff zzg;

    zzh(zza zzaVar, zzfe zzfeVar, String str, String str2, Boolean bool, com.google.firebase.auth.zzg zzgVar, zzdu zzduVar, com.google.android.gms.internal.firebase_auth.zzff zzffVar) {
        this.zza = zzfeVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzgVar;
        this.zzf = zzduVar;
        this.zzg = zzffVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzfe
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.firebase.auth.api.internal.zzfd
    public final /* synthetic */ void zza(com.google.android.gms.internal.firebase_auth.zzeu zzeuVar) {
        List<com.google.android.gms.internal.firebase_auth.zzew> listZzb = zzeuVar.zzb();
        if (listZzb == null || listZzb.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        com.google.android.gms.internal.firebase_auth.zzew zzewVar = listZzb.get(0);
        com.google.android.gms.internal.firebase_auth.zzfl zzflVarZzk = zzewVar.zzk();
        List<zzfj> listZza = zzflVarZzk != null ? zzflVarZzk.zza() : null;
        if (listZza != null && !listZza.isEmpty()) {
            if (TextUtils.isEmpty(this.zzb)) {
                listZza.get(0).zza(this.zzc);
            } else {
                int i = 0;
                while (true) {
                    if (i >= listZza.size()) {
                        break;
                    }
                    if (listZza.get(i).zzd().equals(this.zzb)) {
                        listZza.get(i).zza(this.zzc);
                        break;
                    }
                    i++;
                }
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzewVar.zza(bool.booleanValue());
        } else {
            zzewVar.zza(zzewVar.zzh() - zzewVar.zzg() < 1000);
        }
        zzewVar.zza(this.zze);
        this.zzf.zza(this.zzg, zzewVar);
    }
}
