package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzfy;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class FacebookAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzk();
    private final String zza;

    FacebookAuthCredential(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "facebook.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "facebook.com";
    }

    public static zzfy zza(FacebookAuthCredential facebookAuthCredential, String str) {
        Preconditions.checkNotNull(facebookAuthCredential);
        return new zzfy(null, facebookAuthCredential.zza, facebookAuthCredential.getProvider(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new FacebookAuthCredential(this.zza);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
