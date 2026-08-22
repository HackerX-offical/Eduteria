package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.UserProfileChangeRequest;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzeg implements Parcelable.Creator<zzed> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzed[] newArray(int i) {
        return new zzed[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzed createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        UserProfileChangeRequest userProfileChangeRequest = null;
        String strCreateString = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                userProfileChangeRequest = (UserProfileChangeRequest) SafeParcelReader.createParcelable(parcel, header, UserProfileChangeRequest.CREATOR);
            } else if (fieldId == 2) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzed(userProfileChangeRequest, strCreateString);
    }
}
