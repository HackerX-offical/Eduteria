package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzj();
    private String zza;
    private String zzb;
    private final String zzc;
    private String zzd;
    private boolean zze;

    EmailAuthCredential(String str, String str2, String str3, String str4, boolean z) {
        this.zza = Preconditions.checkNotEmpty(str);
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z;
    }

    EmailAuthCredential(String str, String str2) {
        this(str, str2, null, null, false);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zze;
    }

    public final EmailAuthCredential zza(FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zzf();
        this.zze = true;
        return this;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "password";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        if (!TextUtils.isEmpty(this.zzb)) {
            return "password";
        }
        return EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzc);
    }

    public static boolean zza(String str) {
        zzf zzfVarZza;
        return (TextUtils.isEmpty(str) || (zzfVarZza = zzf.zza(str)) == null || zzfVarZza.zza() != 4) ? false : true;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
