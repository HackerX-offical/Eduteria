package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: loaded from: classes8.dex */
public final class zza implements Parcelable.Creator<CameraPosition> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition[] newArray(int i) {
        return new CameraPosition[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CameraPosition createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(header);
            if (fieldId == 2) {
                latLng = (LatLng) SafeParcelReader.createParcelable(parcel, header, LatLng.CREATOR);
            } else if (fieldId == 3) {
                f2 = SafeParcelReader.readFloat(parcel, header);
            } else if (fieldId == 4) {
                f3 = SafeParcelReader.readFloat(parcel, header);
            } else if (fieldId == 5) {
                f4 = SafeParcelReader.readFloat(parcel, header);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new CameraPosition(latLng, f2, f3, f4);
    }
}
