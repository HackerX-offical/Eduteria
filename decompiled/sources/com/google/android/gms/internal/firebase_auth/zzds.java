package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.EmailAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzds implements Parcelable.Creator<zzdp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdp[] newArray(int i) {
        return new zzdp[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdp createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        EmailAuthCredential emailAuthCredential = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            if (SafeParcelReader.getFieldId(header) == 1) {
                emailAuthCredential = (EmailAuthCredential) SafeParcelReader.createParcelable(parcel, header, EmailAuthCredential.CREATOR);
            } else {
                SafeParcelReader.skipUnknownField(parcel, header);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzdp(emailAuthCredential);
    }
}
