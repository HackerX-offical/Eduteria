package com.google.android.gms.internal.appinvite;

import android.content.Intent;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes8.dex */
public abstract class zzr extends zza implements zzo {
    public zzr() {
        super("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
    }

    @Override // com.google.android.gms.internal.appinvite.zza
    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((Status) zzd.zza(parcel, Status.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zza((Status) zzd.zza(parcel, Status.CREATOR), (Intent) zzd.zza(parcel, Intent.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
