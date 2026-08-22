package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzag implements Parcelable.Creator<ShippingAddressRequirements> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ShippingAddressRequirements createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<String> arrayListCreateStringList = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) != 1) {
                SafeParcelReader.skipUnknownField(parcel, header);
            } else {
                arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new ShippingAddressRequirements(arrayListCreateStringList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ShippingAddressRequirements[] newArray(int i) {
        return new ShippingAddressRequirements[i];
    }
}
