package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zbw extends zba implements IInterface {
    zbw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zbm zbmVar, BeginSignInRequest beginSignInRequest) throws RemoteException {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbmVar);
        zbc.zbc(parcelZba, beginSignInRequest);
        zbb(1, parcelZba);
    }

    public final void zbd(zbp zbpVar, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, String str) throws RemoteException {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbpVar);
        zbc.zbc(parcelZba, getPhoneNumberHintIntentRequest);
        parcelZba.writeString(str);
        zbb(4, parcelZba);
    }

    public final void zbe(zbr zbrVar, GetSignInIntentRequest getSignInIntentRequest) throws RemoteException {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, zbrVar);
        zbc.zbc(parcelZba, getSignInIntentRequest);
        zbb(3, parcelZba);
    }

    public final void zbf(IStatusCallback iStatusCallback, String str) throws RemoteException {
        Parcel parcelZba = zba();
        zbc.zbd(parcelZba, iStatusCallback);
        parcelZba.writeString(str);
        zbb(2, parcelZba);
    }
}
