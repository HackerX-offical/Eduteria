package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentDataRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzs extends zza implements IInterface {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.wallet.internal.IOwService");
    }

    public final void zzc(CreateWalletObjectsRequest createWalletObjectsRequest, Bundle bundle, zzu zzuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, createWalletObjectsRequest);
        zzc.zzb(parcelZza, bundle);
        zzc.zzc(parcelZza, zzuVar);
        zzb(6, parcelZza);
    }

    public final void zzd(IsReadyToPayRequest isReadyToPayRequest, Bundle bundle, zzu zzuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, isReadyToPayRequest);
        zzc.zzb(parcelZza, bundle);
        zzc.zzc(parcelZza, zzuVar);
        zzb(14, parcelZza);
    }

    public final void zze(PaymentDataRequest paymentDataRequest, Bundle bundle, zzu zzuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, paymentDataRequest);
        zzc.zzb(parcelZza, bundle);
        zzc.zzc(parcelZza, zzuVar);
        zzb(19, parcelZza);
    }
}
