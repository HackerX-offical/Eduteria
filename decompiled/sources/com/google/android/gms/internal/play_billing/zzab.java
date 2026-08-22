package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzab extends zzy implements zzad {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzad
    public final void zza(String str, String str2, zzaf zzafVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        int i = zzaa.zza;
        parcelZzu.writeStrongBinder(zzafVar);
        zzx(1, parcelZzu);
    }
}
