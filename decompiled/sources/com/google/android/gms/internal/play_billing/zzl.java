package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzl extends zzz implements zzm {
    public zzl() {
        super("com.android.vending.billing.IInAppBillingGetBillingConfigCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzz
    protected final boolean zzb(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzaa.zza(parcel, Bundle.CREATOR);
        zzaa.zzb(parcel);
        zza(bundle);
        parcel2.writeNoException();
        return true;
    }
}
