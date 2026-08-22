package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class zzg extends com.google.android.gms.internal.vision.zza implements zzh {
    public zzg() {
        super("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.internal.vision.zza
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            FaceParcel[] faceParcelArrZza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzs) com.google.android.gms.internal.vision.zzd.zza(parcel, zzs.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedArray(faceParcelArrZza, 1);
        } else if (i == 2) {
            boolean zZza = zza(parcel.readInt());
            parcel2.writeNoException();
            com.google.android.gms.internal.vision.zzd.zza(parcel2, zZza);
        } else if (i == 3) {
            zza();
            parcel2.writeNoException();
        } else {
            if (i != 4) {
                return false;
            }
            FaceParcel[] faceParcelArrZza2 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (zzs) com.google.android.gms.internal.vision.zzd.zza(parcel, zzs.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedArray(faceParcelArrZza2, 1);
        }
        return true;
    }
}
