package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzcm implements Parcelable.Creator<zzcj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcj[] newArray(int i) {
        return new zzcj[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzcj createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        PhoneAuthCredential phoneAuthCredential = null;
        String strCreateString = null;
        String strCreateString2 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                phoneAuthCredential = (PhoneAuthCredential) SafeParcelReader.createParcelable(parcel, header, PhoneAuthCredential.CREATOR);
            } else if (fieldId == 2) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 3) {
                strCreateString2 = SafeParcelReader.createString(parcel, header);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzcj(phoneAuthCredential, strCreateString, strCreateString2);
    }
}
