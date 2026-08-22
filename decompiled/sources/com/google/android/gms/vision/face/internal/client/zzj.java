package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzj extends com.google.android.gms.internal.vision.zzb implements zzh {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, zzsVar);
        Parcel parcelZza = zza(1, parcelA_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelZza.createTypedArray(FaceParcel.CREATOR);
        parcelZza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzs zzsVar) throws RemoteException {
        Parcel parcelA_ = a_();
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper2);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, iObjectWrapper3);
        parcelA_.writeInt(i);
        parcelA_.writeInt(i2);
        parcelA_.writeInt(i3);
        parcelA_.writeInt(i4);
        parcelA_.writeInt(i5);
        parcelA_.writeInt(i6);
        com.google.android.gms.internal.vision.zzd.zza(parcelA_, zzsVar);
        Parcel parcelZza = zza(4, parcelA_);
        FaceParcel[] faceParcelArr = (FaceParcel[]) parcelZza.createTypedArray(FaceParcel.CREATOR);
        parcelZza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zza(int i) throws RemoteException {
        Parcel parcelA_ = a_();
        parcelA_.writeInt(i);
        Parcel parcelZza = zza(2, parcelA_);
        boolean zZza = com.google.android.gms.internal.vision.zzd.zza(parcelZza);
        parcelZza.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zza() throws RemoteException {
        zzb(3, a_());
    }
}
