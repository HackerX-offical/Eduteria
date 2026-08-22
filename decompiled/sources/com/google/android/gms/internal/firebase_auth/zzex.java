package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzex implements Parcelable.Creator<zzeu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeu[] newArray(int i) {
        return new zzeu[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzeu createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzey zzeyVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) == 2) {
                zzeyVar = (zzey) SafeParcelReader.createParcelable(parcel, header, zzey.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzeu(zzeyVar);
    }
}
