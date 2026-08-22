package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdm implements Parcelable.Creator<zzdj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdj[] newArray(int i) {
        return new zzdj[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdj createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzfy zzfyVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) == 1) {
                zzfyVar = (zzfy) SafeParcelReader.createParcelable(parcel, header, zzfy.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzdj(zzfyVar);
    }
}
