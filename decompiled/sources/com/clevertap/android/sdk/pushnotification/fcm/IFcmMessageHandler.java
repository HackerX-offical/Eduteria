package com.clevertap.android.sdk.pushnotification.fcm;

import android.content.Context;
import com.google.firebase.messaging.RemoteMessage;

/* JADX INFO: loaded from: classes7.dex */
public interface IFcmMessageHandler {
    boolean createNotification(Context context, RemoteMessage remoteMessage);

    boolean onNewToken(Context context, String str);
}
