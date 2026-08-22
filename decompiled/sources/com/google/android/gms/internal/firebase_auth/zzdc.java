package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.ActionCodeSettings;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzdc implements Parcelable.Creator<zzcz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcz[] newArray(int i) {
        return new zzcz[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcz createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        ActionCodeSettings actionCodeSettings = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                actionCodeSettings = (ActionCodeSettings) SafeParcelReader.createParcelable(parcel, header, ActionCodeSettings.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzcz(strCreateString, actionCodeSettings);
    }
}
