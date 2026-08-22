package com.appnew.android.Utils.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmsBroadcastReceiverNew.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/appnew/android/Utils/Service/SmsBroadcastReceiverNew;", "Landroid/content/BroadcastReceiver;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onReceive", "context", "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmsBroadcastReceiverNew extends BroadcastReceiver {
    public static final int $stable = 0;
    private final Function1<String, Unit> listener;

    /* JADX WARN: Multi-variable type inference failed */
    public SmsBroadcastReceiverNew(Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent != null ? intent.getAction() : null)) {
            Bundle extras = intent.getExtras();
            Object obj = extras != null ? extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS") : null;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
            int statusCode = ((Status) obj).getStatusCode();
            if (statusCode != 0) {
                if (statusCode != 15) {
                    return;
                }
                Log.e("SmsBroadcastReceiverNew", "SMS retrieval timed out");
            } else {
                Object obj2 = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj2;
                Log.d("SmsBroadcastReceiverNew", "SMS received: " + str);
                this.listener.invoke(str);
            }
        }
    }
}
