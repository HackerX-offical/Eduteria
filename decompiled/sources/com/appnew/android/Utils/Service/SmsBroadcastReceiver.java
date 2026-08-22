package com.appnew.android.Utils.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

/* JADX INFO: loaded from: classes6.dex */
public class SmsBroadcastReceiver extends BroadcastReceiver {
    public static final String SMS_BUNDLE = "pdus";
    String[] message;
    String address = "";
    String smsBody = "";
    String OTP = "";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (Object obj : (Object[]) extras.get(SMS_BUNDLE)) {
                SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
                this.smsBody = smsMessageCreateFromPdu.getMessageBody();
                this.address = smsMessageCreateFromPdu.getOriginatingAddress();
                smsMessageCreateFromPdu.getDisplayOriginatingAddress();
                String displayMessageBody = smsMessageCreateFromPdu.getDisplayMessageBody();
                try {
                    Intent intent2 = new Intent("broadCastOtp");
                    intent2.putExtra("message", displayMessageBody);
                    context.sendBroadcast(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
