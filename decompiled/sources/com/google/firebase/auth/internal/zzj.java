package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.firebase_auth.zzew;
import com.google.android.gms.internal.firebase_auth.zzfj;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzj extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzj> CREATOR = new zzm();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private Uri zze;
    private String zzf;
    private String zzg;
    private boolean zzh;
    private String zzi;

    public zzj(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z;
        this.zzi = str7;
    }

    public zzj(zzew zzewVar, String str) {
        Preconditions.checkNotNull(zzewVar);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzewVar.zzc());
        this.zzb = str;
        this.zzf = zzewVar.zza();
        this.zzc = zzewVar.zzd();
        Uri uriZze = zzewVar.zze();
        if (uriZze != null) {
            this.zzd = uriZze.toString();
            this.zze = uriZze;
        }
        this.zzh = zzewVar.zzb();
        this.zzi = null;
        this.zzg = zzewVar.zzf();
    }

    public zzj(zzfj zzfjVar) {
        Preconditions.checkNotNull(zzfjVar);
        this.zza = zzfjVar.zza();
        this.zzb = Preconditions.checkNotEmpty(zzfjVar.zzd());
        this.zzc = zzfjVar.zzb();
        Uri uriZzc = zzfjVar.zzc();
        if (uriZzc != null) {
            this.zzd = uriZzc.toString();
            this.zze = uriZzc;
        }
        this.zzf = zzfjVar.zzg();
        this.zzg = zzfjVar.zze();
        this.zzh = false;
        this.zzi = zzfjVar.zzf();
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzh;
    }

    public final String zza() {
        return this.zzi;
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e2) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new com.google.firebase.auth.api.zza(e2);
        }
    }

    public static zzj zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzj(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e2) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new com.google.firebase.auth.api.zza(e2);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
