package com.razorpay;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes9.dex */
public class AdvertisingIdUtil {

    interface AdvertisingIdCallback {
        void onResult(String str);
    }

    static void getId(Context context, AdvertisingIdCallback advertisingIdCallback) {
        new AdvertisingIdAsyncTask(context, advertisingIdCallback).execute(new Void[0]);
    }

    private static class AdvertisingIdAsyncTask extends AsyncTask<Void, Void, String> {
        private AdvertisingIdCallback callback;
        private Context context;

        AdvertisingIdAsyncTask(Context context, AdvertisingIdCallback advertisingIdCallback) {
            this.context = context;
            this.callback = advertisingIdCallback;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            AdvertisingConnection advertisingConnection = new AdvertisingConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (this.context.bindService(intent, advertisingConnection, 1)) {
                    try {
                        String id = new AdvertisingInterface(advertisingConnection.getBinder()).getId();
                        try {
                            return id;
                        } catch (IllegalArgumentException e2) {
                            return id;
                        }
                    } catch (Exception e3) {
                        String message = e3.getMessage();
                        try {
                            this.context.unbindService(advertisingConnection);
                        } catch (IllegalArgumentException e4) {
                            AnalyticsUtil.reportError(getClass().getName(), "S1", e4.getLocalizedMessage());
                        }
                        return message;
                    }
                }
                return "permission disabled";
            } finally {
                try {
                    this.context.unbindService(advertisingConnection);
                } catch (IllegalArgumentException e22) {
                    AnalyticsUtil.reportError(getClass().getName(), "S1", e22.getLocalizedMessage());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            this.callback.onResult(str);
        }
    }

    private static final class AdvertisingConnection implements ServiceConnection {
        private final LinkedBlockingQueue<IBinder> queue;
        boolean retrieved;

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private AdvertisingConnection() {
            this.retrieved = false;
            this.queue = new LinkedBlockingQueue<>(1);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.queue.put(iBinder);
            } catch (Exception e2) {
                AnalyticsUtil.reportError(getClass().getName(), "S1", e2.getMessage());
            }
        }

        final IBinder getBinder() throws InterruptedException {
            if (!this.retrieved) {
                this.retrieved = true;
            }
            return this.queue.take();
        }
    }

    private static final class AdvertisingInterface implements IInterface {
        private IBinder binder;

        AdvertisingInterface(IBinder iBinder) {
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.binder;
        }

        public final String getId() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }
}
