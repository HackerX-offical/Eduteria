package com.google.android.gms.internal.appinvite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes8.dex */
public final class zzs extends zzb implements zzq {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appinvite.internal.IAppInviteService");
    }

    @Override // com.google.android.gms.internal.appinvite.zzq
    public final void zza(zzo zzoVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzd.zza(parcelZza, zzoVar);
        parcelZza.writeString(str);
        zza(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.appinvite.zzq
    public final void zzb(zzo zzoVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzd.zza(parcelZza, zzoVar);
        parcelZza.writeString(str);
        zza(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.appinvite.zzq
    public final void zza(zzo zzoVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzd.zza(parcelZza, zzoVar);
        zza(3, parcelZza);
    }
}
