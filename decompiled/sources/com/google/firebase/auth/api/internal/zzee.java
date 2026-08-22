package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzee extends com.google.android.gms.internal.firebase_auth.zzb implements zzec {
    zzee(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, zzffVar);
        zzb(1, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzff zzffVar, com.google.android.gms.internal.firebase_auth.zzew zzewVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, zzffVar);
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, zzewVar);
        zzb(2, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(zzem zzemVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, zzemVar);
        zzb(3, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(zzfm zzfmVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, zzfmVar);
        zzb(4, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(Status status) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, status);
        zzb(5, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void a_() throws RemoteException {
        zzb(6, zza());
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzb() throws RemoteException {
        zzb(7, zza());
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzb(8, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzb(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzb(9, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, phoneAuthCredential);
        zzb(10, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzc(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzb(11, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, status);
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, phoneAuthCredential);
        zzb(12, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zzc() throws RemoteException {
        zzb(13, zza());
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzeh zzehVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, zzehVar);
        zzb(14, parcelZza);
    }

    @Override // com.google.firebase.auth.api.internal.zzec
    public final void zza(com.google.android.gms.internal.firebase_auth.zzej zzejVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.firebase_auth.zzd.zza(parcelZza, zzejVar);
        zzb(15, parcelZza);
    }
}
