package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzn extends zzz implements zzo {
    public zzn() {
        super("com.android.vending.billing.IInAppBillingGetExternalPaymentDialogIntentCallback");
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
