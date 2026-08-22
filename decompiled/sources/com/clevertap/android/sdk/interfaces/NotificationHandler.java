package com.clevertap.android.sdk.interfaces;

import android.content.Context;
import android.os.Bundle;
import com.clevertap.android.sdk.pushnotification.PushType;

/* JADX INFO: loaded from: classes7.dex */
public interface NotificationHandler {
    boolean onMessageReceived(Context context, Bundle bundle, String str);

    boolean onNewToken(Context context, String str, PushType pushType);
}
