package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfk implements Parcelable.Creator<zzfl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfl[] newArray(int i) {
        return new zzfl[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzfl createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList arrayListCreateTypedList = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) == 2) {
                arrayListCreateTypedList = SafeParcelReader.createTypedList(parcel, header, zzfj.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzfl(arrayListCreateTypedList);
    }
}
