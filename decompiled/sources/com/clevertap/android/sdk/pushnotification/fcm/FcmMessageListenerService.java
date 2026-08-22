package com.clevertap.android.sdk.pushnotification.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/* JADX INFO: loaded from: classes7.dex */
public class FcmMessageListenerService extends FirebaseMessagingService {
    private IFcmMessageHandler mHandler = new CTFcmMessageHandler();

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        this.mHandler.createNotification(getApplicationContext(), remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        this.mHandler.onNewToken(getApplicationContext(), str);
    }
}
