package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzen implements com.google.firebase.auth.api.internal.zzfk<zzp.zza> {
    private String zza;
    private String zzb = "http://localhost";
    private final String zzc;

    public zzen(String str, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzp.zza.C0144zza c0144zzaZzb = zzp.zza.zza().zza(this.zza).zzb(this.zzb);
        String str = this.zzc;
        if (str != null) {
            c0144zzaZzb.zzc(str);
        }
        return (zzp.zza) ((zzie) c0144zzaZzb.zzf());
    }
}
