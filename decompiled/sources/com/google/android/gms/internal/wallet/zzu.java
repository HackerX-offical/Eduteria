package com.google.android.gms.internal.wallet;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.PaymentData;

/* JADX INFO: compiled from: com.google.android.gms:play-services-wallet@@18.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public interface zzu extends IInterface {
    void zzb(int i, FullWallet fullWallet, Bundle bundle) throws RemoteException;

    void zzc(Status status, boolean z, Bundle bundle) throws RemoteException;

    void zzd(int i, MaskedWallet maskedWallet, Bundle bundle) throws RemoteException;

    void zze(Status status, PaymentData paymentData, Bundle bundle) throws RemoteException;

    void zzf(int i, boolean z, Bundle bundle) throws RemoteException;

    void zzg(int i, Bundle bundle) throws RemoteException;
}
