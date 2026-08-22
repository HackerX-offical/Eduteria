package com.razorpay;

import android.app.Activity;
import android.content.IntentFilter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
class SmsAgent {
    static final int READ_SMS_PERMISSION_CODE = 1;
    static SmsAgent sSmsAgent;
    ArrayList<SmsAgentInterface> interfaceArrayList = new ArrayList<>();
    private SmsReceiver smsBroadcastReceiver;

    void deregisterForCallbacks(SmsAgentInterface smsAgentInterface) {
    }

    void postSms(String str, String str2) {
    }

    void registerForCallbacks(SmsAgentInterface smsAgentInterface) {
    }

    void sendSmsPermissionCallBack(boolean z) {
    }

    boolean takeActionsIfPermissionsAreGranted(Activity activity) {
        return false;
    }

    static SmsAgent getSmsAgentInstance() {
        if (sSmsAgent == null) {
            sSmsAgent = new SmsAgent();
        }
        return sSmsAgent;
    }

    SmsAgent() {
    }

    void addSMSBroadcastReceiver(Activity activity) {
        if (this.smsBroadcastReceiver != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(1000);
        this.smsBroadcastReceiver = new SmsReceiver(this);
        intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
    }

    void removeSMSBroadcastReceiver(Activity activity) {
        sendSmsPermissionCallBack(false);
        SmsReceiver smsReceiver = this.smsBroadcastReceiver;
        if (smsReceiver == null) {
            return;
        }
        try {
            activity.unregisterReceiver(smsReceiver);
        } catch (Exception e2) {
            AnalyticsUtil.reportError("SmsAgent", "S0", e2.getMessage());
        }
        this.smsBroadcastReceiver = null;
    }

    void handleRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        if (i != 1) {
            return;
        }
        if (iArr.length > 0 && iArr[0] == 0) {
            sendSmsPermissionCallBack(true);
            addSMSBroadcastReceiver(activity);
            AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_NOW_GRANTED);
        } else {
            sendSmsPermissionCallBack(false);
            AnalyticsUtil.trackEvent(AnalyticsEvent.SMS_PERMISSION_NOW_DENIED);
        }
    }
}
