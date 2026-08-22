package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfo implements Parcelable.Creator<zzfm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfm[] newArray(int i) {
        return new zzfm[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfm createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        zzfh zzfhVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 2) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 3) {
                strCreateString2 = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 4) {
                strCreateString3 = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 5) {
                zzfhVar = (zzfh) SafeParcelReader.createParcelable(parcel, header, zzfh.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfm(strCreateString, strCreateString2, strCreateString3, zzfhVar);
    }
}
