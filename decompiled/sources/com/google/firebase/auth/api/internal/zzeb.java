package com.google.firebase.auth.api.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzem;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.PhoneAuthCredential;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@19.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzeb extends com.google.android.gms.internal.firebase_auth.zza implements zzec {
    public zzeb() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.firebase_auth.zza
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((com.google.android.gms.internal.firebase_auth.zzff) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzff.CREATOR));
                return true;
            case 2:
                zza((com.google.android.gms.internal.firebase_auth.zzff) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzff.CREATOR), (com.google.android.gms.internal.firebase_auth.zzew) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzew.CREATOR));
                return true;
            case 3:
                zza((zzem) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, zzem.CREATOR));
                return true;
            case 4:
                zza((zzfm) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, zzfm.CREATOR));
                return true;
            case 5:
                zza((Status) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, Status.CREATOR));
                return true;
            case 6:
                a_();
                return true;
            case 7:
                zzb();
                return true;
            case 8:
                zza(parcel.readString());
                return true;
            case 9:
                zzb(parcel.readString());
                return true;
            case 10:
                zza((PhoneAuthCredential) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 11:
                zzc(parcel.readString());
                return true;
            case 12:
                zza((Status) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, Status.CREATOR), (PhoneAuthCredential) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 13:
                zzc();
                return true;
            case 14:
                zza((com.google.android.gms.internal.firebase_auth.zzeh) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzeh.CREATOR));
                return true;
            case 15:
                zza((com.google.android.gms.internal.firebase_auth.zzej) com.google.android.gms.internal.firebase_auth.zzd.zza(parcel, com.google.android.gms.internal.firebase_auth.zzej.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
