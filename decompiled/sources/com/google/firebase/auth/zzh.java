package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzh implements Parcelable.Creator<PhoneAuthProvider.ForceResendingToken> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken[] newArray(int i) {
        return new PhoneAuthProvider.ForceResendingToken[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthProvider.ForceResendingToken createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            SafeParcelReader.getFieldId(header);
            SafeParcelReader.skipUnknownField(parcel, header);
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new PhoneAuthProvider.ForceResendingToken();
    }
}
