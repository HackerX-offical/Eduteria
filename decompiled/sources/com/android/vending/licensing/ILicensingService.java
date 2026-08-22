package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.vending.licensing.ILicenseResultListener;

/* JADX INFO: loaded from: classes4.dex */
public interface ILicensingService extends IInterface {
    public static final String DESCRIPTOR = "com.android.vending.licensing.ILicensingService";

    public static class Default implements ILicensingService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.vending.licensing.ILicensingService
        public void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException {
        }
    }

    void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ILicensingService {
        static final int TRANSACTION_checkLicense = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ILicensingService.DESCRIPTOR);
        }

        public static ILicensingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILicensingService.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ILicensingService)) {
                return (ILicensingService) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ILicensingService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ILicensingService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                checkLicense(parcel.readLong(), parcel.readString(), ILicenseResultListener.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ILicensingService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILicensingService.DESCRIPTOR;
            }

            @Override // com.android.vending.licensing.ILicensingService
            public void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILicensingService.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(iLicenseResultListener);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
