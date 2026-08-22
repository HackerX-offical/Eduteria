package com.appnew.android.Payment.billdesk_payment_gateway;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.appnew.android.Utils.SharedPreference;
import com.billdesk.sdk.LibraryPaymentStatusProtocol;

/* JADX INFO: loaded from: classes6.dex */
public class SampleCallBack implements LibraryPaymentStatusProtocol {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.appnew.android.Payment.billdesk_payment_gateway.SampleCallBack.1
        String TAG = "Callback --- Parcelable.Creator ::: > ";

        @Override // android.os.Parcelable.Creator
        public SampleCallBack createFromParcel(Parcel in) {
            Log.v(this.TAG, "CallBackActivity createFromParcel(Parcel in)....");
            return new SampleCallBack(in);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int size) {
            Log.v(this.TAG, "Object[] newArray(int size)....");
            return new SampleCallBack[size];
        }
    };
    String TAG = "SampleCallBack ::: > ";
    SendData sendData;

    interface SendData {
        void sendPayment(String result);
    }

    @Override // com.billdesk.sdk.LibraryPaymentStatusProtocol
    public void cancelTransaction() {
    }

    @Override // com.billdesk.sdk.LibraryPaymentStatusProtocol
    public void onError(Exception e2) {
    }

    @Override // com.billdesk.sdk.LibraryPaymentStatusProtocol
    public void tryAgain() {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
    }

    public SampleCallBack() {
    }

    public SampleCallBack(Parcel in) {
        Log.v("SampleCallBack ::: > ", "CallBack(Parcel in)....");
    }

    @Override // com.billdesk.sdk.LibraryPaymentStatusProtocol
    public void paymentStatus(String result, Activity context) {
        SharedPreference.getInstance().putString("paymentResult", result);
        context.finish();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        Log.v(this.TAG, "describeContents()....");
        return 0;
    }
}
