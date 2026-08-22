package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzt extends zzy implements zzv {
    zzt(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(5, parcelZzu);
        int i2 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final int zzc(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaa.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(10, parcelZzu);
        int i2 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzd(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaa.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(TypedValues.Custom.TYPE_COLOR, parcelZzu);
        Bundle bundle2 = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zze(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaa.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(12, parcelZzu);
        Bundle bundle2 = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzf(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        Parcel parcelZzv = zzv(3, parcelZzu);
        Bundle bundle = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        zzaa.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(8, parcelZzu);
        Bundle bundle2 = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzh(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(6);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        zzaa.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(9, parcelZzu);
        Bundle bundle2 = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzi(int i, String str, String str2, String str3) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        Parcel parcelZzv = zzv(4, parcelZzu);
        Bundle bundle = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzj(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        zzaa.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(11, parcelZzu);
        Bundle bundle2 = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzk(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaa.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(2, parcelZzu);
        Bundle bundle2 = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final Bundle zzl(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzaa.zzc(parcelZzu, bundle);
        zzaa.zzc(parcelZzu, bundle2);
        Parcel parcelZzv = zzv(TypedValues.Custom.TYPE_FLOAT, parcelZzu);
        Bundle bundle3 = (Bundle) zzaa.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzm(int i, String str, Bundle bundle, zzg zzgVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzgVar);
        zzx(1501, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzn(int i, String str, Bundle bundle, zzi zziVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zziVar);
        zzx(1801, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzo(int i, String str, Bundle bundle, zzk zzkVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzkVar);
        zzx(1601, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzp(int i, String str, Bundle bundle, zzm zzmVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(18);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzmVar);
        zzw(1301, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzq(int i, String str, Bundle bundle, zzo zzoVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzoVar);
        zzx(1901, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzr(int i, String str, Bundle bundle, zzq zzqVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzqVar);
        zzx(1401, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzs(int i, String str, Bundle bundle, zzs zzsVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzsVar);
        zzx(1701, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzv
    public final void zzt(int i, String str, Bundle bundle, zzx zzxVar) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(12);
        parcelZzu.writeString(str);
        zzaa.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzxVar);
        zzw(1201, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzv
    public final int zzy(int i, String str, String str2) throws RemoteException {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(1, parcelZzu);
        int i2 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i2;
    }
}
