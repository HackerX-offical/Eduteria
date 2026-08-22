package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes8.dex */
public final class zzm implements Parcelable.Creator<StreetViewPanoramaCamera> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 2) {
                f2 = SafeParcelReader.readFloat(parcel, header);
            } else if (fieldId == 3) {
                f3 = SafeParcelReader.readFloat(parcel, header);
            } else if (fieldId == 4) {
                f4 = SafeParcelReader.readFloat(parcel, header);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new StreetViewPanoramaCamera(f2, f3, f4);
    }
}
