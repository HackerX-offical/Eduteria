package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class zzg extends OAuthCredential {
    public static final Parcelable.Creator<zzg> CREATOR = new zzi();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final zzfy zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    zzg(String str, String str2, String str3, zzfy zzfyVar, String str4, String str5, String str6) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzfyVar;
        this.zze = str4;
        this.zzf = str5;
        this.zzg = str6;
    }

    public static zzg zza(String str, String str2, String str3) {
        return zza(str, str2, str3, null, null);
    }

    public static zzg zza(String str, String str2, String str3, String str4, String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zzg(str, str2, str3, null, str4, str5, null);
    }

    public static zzg zza(zzfy zzfyVar) {
        Preconditions.checkNotNull(zzfyVar, "Must specify a non-null webSignInCredential");
        return new zzg(null, null, null, zzfyVar, null, null, null);
    }

    static zzg zza(String str, String str2, String str3, String str4) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zzg(str, str2, str3, null, null, null, str4);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getIdToken() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getAccessToken() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.OAuthCredential
    public String getSecret() {
        return this.zzf;
    }

    public static zzfy zza(zzg zzgVar, String str) {
        Preconditions.checkNotNull(zzgVar);
        zzfy zzfyVar = zzgVar.zzd;
        return zzfyVar != null ? zzfyVar : new zzfy(zzgVar.getIdToken(), zzgVar.getAccessToken(), zzgVar.getProvider(), null, zzgVar.getSecret(), null, str, zzgVar.zze, zzgVar.zzg);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new zzg(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProvider(), false);
        SafeParcelWriter.writeString(parcel, 2, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 3, getAccessToken(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, getSecret(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
