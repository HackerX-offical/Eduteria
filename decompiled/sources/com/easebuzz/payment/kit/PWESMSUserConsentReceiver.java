package com.easebuzz.payment.kit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import listeners.PWEOtpListener;

/* JADX INFO: loaded from: classes7.dex */
public class PWESMSUserConsentReceiver extends BroadcastReceiver {
    private PWEOtpListener pweOtpListener;

    public void setPweOtpListener(PWEOtpListener pWEOtpListener) {
        this.pweOtpListener = pWEOtpListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            this.pweOtpListener.otpSMSReceived(intent);
        } catch (Exception unused) {
        }
    }
}
