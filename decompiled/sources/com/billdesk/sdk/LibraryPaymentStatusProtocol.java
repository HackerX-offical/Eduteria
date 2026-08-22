package com.billdesk.sdk;

import android.app.Activity;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes6.dex */
public interface LibraryPaymentStatusProtocol extends Parcelable {
    void cancelTransaction();

    void onError(Exception exc);

    void paymentStatus(String str, Activity activity);

    void tryAgain();
}
