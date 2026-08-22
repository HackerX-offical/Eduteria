package com.appnew.android.Sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsBroadcastReceiver.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/appnew/android/Sms/SmsBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "smsBroadcastReceiverListener", "Lcom/appnew/android/Sms/SmsBroadcastReceiver$SmsBroadcastReceiverListener;", "getSmsBroadcastReceiverListener", "()Lcom/appnew/android/Sms/SmsBroadcastReceiver$SmsBroadcastReceiverListener;", "setSmsBroadcastReceiverListener", "(Lcom/appnew/android/Sms/SmsBroadcastReceiver$SmsBroadcastReceiverListener;)V", "onReceive", "", "context", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "SmsBroadcastReceiverListener", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmsBroadcastReceiver extends BroadcastReceiver {
    public static final int $stable = 8;
    private SmsBroadcastReceiverListener smsBroadcastReceiverListener;

    /* JADX INFO: compiled from: SmsBroadcastReceiver.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/appnew/android/Sms/SmsBroadcastReceiver$SmsBroadcastReceiverListener;", "", "onSuccess", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onFailure", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SmsBroadcastReceiverListener {
        void onFailure();

        void onSuccess(Intent intent);
    }

    public final SmsBroadcastReceiverListener getSmsBroadcastReceiverListener() {
        return this.smsBroadcastReceiverListener;
    }

    public final void setSmsBroadcastReceiverListener(SmsBroadcastReceiverListener smsBroadcastReceiverListener) {
        this.smsBroadcastReceiverListener = smsBroadcastReceiverListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SmsBroadcastReceiverListener smsBroadcastReceiverListener;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            if (Intrinsics.areEqual(intent.getAction(), SmsRetriever.SMS_RETRIEVED_ACTION)) {
                Bundle extras = intent.getExtras();
                Intrinsics.checkNotNull(extras);
                Status status = (Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                Integer numValueOf = status != null ? Integer.valueOf(status.getStatusCode()) : null;
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    Intent intent2 = (Intent) extras.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT);
                    SmsBroadcastReceiverListener smsBroadcastReceiverListener2 = this.smsBroadcastReceiverListener;
                    if (smsBroadcastReceiverListener2 != null) {
                        smsBroadcastReceiverListener2.onSuccess(intent2);
                        return;
                    }
                    return;
                }
                if (numValueOf == null || numValueOf.intValue() != 15 || (smsBroadcastReceiverListener = this.smsBroadcastReceiverListener) == null) {
                    return;
                }
                smsBroadcastReceiverListener.onFailure();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
