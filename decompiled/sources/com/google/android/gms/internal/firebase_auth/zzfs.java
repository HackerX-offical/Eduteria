package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfs implements com.google.firebase.auth.api.internal.zzfk<zzp.zzn> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzi;
    private String zzj;
    private boolean zzh = true;
    private zzfw zzg = new zzfw();
    private zzfw zzf = new zzfw();

    public final boolean zza(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzg.zza().contains(str);
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zze;
    }

    public final zzfs zzb(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzfs zzc(String str) {
        if (str == null) {
            this.zzg.zza().add("EMAIL");
            return this;
        }
        this.zzb = str;
        return this;
    }

    public final zzfs zzd(String str) {
        if (str == null) {
            this.zzg.zza().add("PASSWORD");
            return this;
        }
        this.zzc = str;
        return this;
    }

    public final zzfs zze(String str) {
        if (str == null) {
            this.zzg.zza().add("DISPLAY_NAME");
            return this;
        }
        this.zzd = str;
        return this;
    }

    public final zzfs zzf(String str) {
        if (str == null) {
            this.zzg.zza().add("PHOTO_URL");
            return this;
        }
        this.zze = str;
        return this;
    }

    public final zzfs zzg(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzf.zza().add(str);
        return this;
    }

    public final zzfs zzh(String str) {
        this.zzi = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzfs zzi(String str) {
        this.zzj = str;
        return this;
    }

    @Override // com.google.firebase.auth.api.internal.zzfk
    public final /* synthetic */ zzjp zza() {
        zzv zzvVar;
        zzp.zzn.zzb zzbVarZzb = zzp.zzn.zza().zza(this.zzh).zzb(this.zzf.zza());
        List<String> listZza = this.zzg.zza();
        zzv[] zzvVarArr = new zzv[listZza.size()];
        for (int i = 0; i < listZza.size(); i++) {
            String str = listZza.get(i);
            str.hashCode();
            switch (str) {
                case "DISPLAY_NAME":
                    zzvVar = zzv.DISPLAY_NAME;
                    break;
                case "EMAIL":
                    zzvVar = zzv.EMAIL;
                    break;
                case "PHOTO_URL":
                    zzvVar = zzv.PHOTO_URL;
                    break;
                case "PASSWORD":
                    zzvVar = zzv.PASSWORD;
                    break;
                default:
                    zzvVar = zzv.USER_ATTRIBUTE_NAME_UNSPECIFIED;
                    break;
            }
            zzvVarArr[i] = zzvVar;
        }
        zzp.zzn.zzb zzbVarZza = zzbVarZzb.zza(Arrays.asList(zzvVarArr));
        String str2 = this.zza;
        if (str2 != null) {
            zzbVarZza.zza(str2);
        }
        String str3 = this.zzb;
        if (str3 != null) {
            zzbVarZza.zzc(str3);
        }
        String str4 = this.zzc;
        if (str4 != null) {
            zzbVarZza.zzd(str4);
        }
        String str5 = this.zzd;
        if (str5 != null) {
            zzbVarZza.zzb(str5);
        }
        String str6 = this.zze;
        if (str6 != null) {
            zzbVarZza.zzf(str6);
        }
        String str7 = this.zzi;
        if (str7 != null) {
            zzbVarZza.zze(str7);
        }
        String str8 = this.zzj;
        if (str8 != null) {
            zzbVarZza.zzg(str8);
        }
        return (zzp.zzn) ((zzie) zzbVarZza.zzf());
    }
}
