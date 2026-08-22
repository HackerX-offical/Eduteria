package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes4.dex */
public interface ILicenseResultListener extends IInterface {
    public static final String DESCRIPTOR = "com.android.vending.licensing.ILicenseResultListener";

    public static class Default implements ILicenseResultListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.vending.licensing.ILicenseResultListener
        public void verifyLicense(int i, String str, String str2) throws RemoteException {
        }
    }

    void verifyLicense(int i, String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements ILicenseResultListener {
        static final int TRANSACTION_verifyLicense = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, ILicenseResultListener.DESCRIPTOR);
        }

        public static ILicenseResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(ILicenseResultListener.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof ILicenseResultListener)) {
                return (ILicenseResultListener) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(ILicenseResultListener.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(ILicenseResultListener.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                verifyLicense(parcel.readInt(), parcel.readString(), parcel.readString());
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ILicenseResultListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return ILicenseResultListener.DESCRIPTOR;
            }

            @Override // com.android.vending.licensing.ILicenseResultListener
            public void verifyLicense(int i, String str, String str2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(ILicenseResultListener.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    this.mRemote.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }
}
