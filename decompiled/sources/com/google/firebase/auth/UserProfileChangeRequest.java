package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzai();
    private String zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private Uri zze;

    UserProfileChangeRequest(String str, String str2, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = z2;
        this.zze = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    /* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
    public static class Builder {
        private String zza;
        private Uri zzb;
        private boolean zzc;
        private boolean zzd;

        public Builder setDisplayName(String str) {
            if (str == null) {
                this.zzc = true;
                return this;
            }
            this.zza = str;
            return this;
        }

        public Builder setPhotoUri(Uri uri) {
            if (uri == null) {
                this.zzd = true;
                return this;
            }
            this.zzb = uri;
            return this;
        }

        public UserProfileChangeRequest build() {
            String str = this.zza;
            Uri uri = this.zzb;
            return new UserProfileChangeRequest(str, uri == null ? null : uri.toString(), this.zzc, this.zzd);
        }
    }

    public String getDisplayName() {
        return this.zza;
    }

    public final String zza() {
        return this.zzb;
    }

    public Uri getPhotoUri() {
        return this.zze;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
