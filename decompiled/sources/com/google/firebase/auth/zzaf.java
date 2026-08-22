package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzaf extends zzy {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzae();
    private final String zza;

    @Nullable
    private final String zzb;
    private final long zzc;
    private final String zzd;

    public zzaf(String str, @Nullable String str2, long j, String str3) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = str2;
        this.zzc = j;
        this.zzd = Preconditions.checkNotEmpty(str3);
    }

    public static zzaf zza(JSONObject jSONObject) {
        if (!jSONObject.has("enrollmentTimestamp")) {
            throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
        }
        return new zzaf(jSONObject.optString("uid"), jSONObject.optString("displayName"), jSONObject.optLong("enrollmentTimestamp"), jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER));
    }

    @Override // com.google.firebase.auth.zzy
    @Nullable
    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("factorIdKey", "phone");
            jSONObject.putOpt("uid", this.zza);
            jSONObject.putOpt("displayName", this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zzd);
            return jSONObject;
        } catch (JSONException e2) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new com.google.firebase.auth.api.zza(e2);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
