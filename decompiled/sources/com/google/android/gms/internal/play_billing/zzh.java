package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzh extends zzz implements zzi {
    public zzh() {
        super("com.android.vending.billing.IInAppBillingCreateExternalPaymentReportingDetailsCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzz
    protected final boolean zzb(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzaa.zza(parcel, Bundle.CREATOR);
        zzaa.zzb(parcel);
        zza(bundle);
        return true;
    }
}
