package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzel implements Parcelable.Creator<zzej> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzej[] newArray(int i) {
        return new zzej[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzej createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        ArrayList arrayListCreateTypedList = null;
        com.google.firebase.auth.zzg zzgVar = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 1) {
                strCreateString = SafeParcelReader.createString(parcel, header);
            } else if (fieldId == 2) {
                arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzfh.CREATOR);
            } else if (fieldId == 3) {
                zzgVar = (com.google.firebase.auth.zzg) SafeParcelReader.createParcelable(parcel, header, com.google.firebase.auth.zzg.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzej(strCreateString, arrayListCreateTypedList, zzgVar);
    }
}
