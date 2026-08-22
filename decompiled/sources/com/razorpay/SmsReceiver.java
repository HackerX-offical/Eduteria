package com.razorpay;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.appnew.android.Utils.Service.SmsBroadcastReceiver;

/* JADX INFO: loaded from: classes9.dex */
public class SmsReceiver extends BroadcastReceiver {
    private SmsAgent smsAgent;

    SmsReceiver() {
        this.smsAgent = null;
    }

    SmsReceiver(SmsAgent smsAgent) {
        this.smsAgent = smsAgent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                Object[] objArr = (Object[]) extras.get(SmsBroadcastReceiver.SMS_BUNDLE);
                if (objArr.length > 0) {
                    SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) objArr[0]);
                    String displayOriginatingAddress = smsMessageCreateFromPdu.getDisplayOriginatingAddress();
                    String displayMessageBody = smsMessageCreateFromPdu.getDisplayMessageBody();
                    SmsAgent smsAgent = this.smsAgent;
                    if (smsAgent != null) {
                        smsAgent.postSms(displayOriginatingAddress, displayMessageBody);
                        return;
                    }
                    Intent intent2 = new Intent("com.razorpay.events.SMS_PROCESSED");
                    intent2.putExtra("extra_sender", displayOriginatingAddress);
                    intent2.putExtra("extra_message", displayMessageBody);
                    context.sendBroadcast(intent2);
                }
            } catch (Exception e2) {
                AnalyticsUtil.reportError("SmsReceiver", "S0", e2.getMessage());
                new StringBuilder("SmsReceiver Exception smsReceiver").append(e2);
            }
        }
    }
}
