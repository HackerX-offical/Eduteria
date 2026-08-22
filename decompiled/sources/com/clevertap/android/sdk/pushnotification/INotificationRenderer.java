package com.clevertap.android.sdk.pushnotification;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.clevertap.android.sdk.CleverTapInstanceConfig;

/* JADX INFO: loaded from: classes7.dex */
public interface INotificationRenderer {
    String getActionButtonIconKey();

    Object getCollapseKey(Bundle bundle);

    String getMessage(Bundle bundle);

    String getTitle(Bundle bundle, Context context);

    NotificationCompat.Builder renderNotification(Bundle bundle, Context context, NotificationCompat.Builder builder, CleverTapInstanceConfig cleverTapInstanceConfig, int i);

    void setSmallIcon(int i, Context context);

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f1 A[Catch: all -> 0x0184, TryCatch #2 {all -> 0x0184, blocks: (B:20:0x0042, B:22:0x006b, B:25:0x0073, B:32:0x00a5, B:38:0x00b2, B:41:0x00bd, B:43:0x00c3, B:46:0x00cd, B:52:0x00da, B:55:0x00e2, B:62:0x00f1, B:64:0x010c, B:70:0x0133, B:65:0x0110, B:67:0x0116, B:68:0x0125, B:30:0x0089, B:27:0x0079), top: B:95:0x0042, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0110 A[Catch: all -> 0x0184, TryCatch #2 {all -> 0x0184, blocks: (B:20:0x0042, B:22:0x006b, B:25:0x0073, B:32:0x00a5, B:38:0x00b2, B:41:0x00bd, B:43:0x00c3, B:46:0x00cd, B:52:0x00da, B:55:0x00e2, B:62:0x00f1, B:64:0x010c, B:70:0x0133, B:65:0x0110, B:67:0x0116, B:68:0x0125, B:30:0x0089, B:27:0x0079), top: B:95:0x0042, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133 A[Catch: all -> 0x0184, TRY_LEAVE, TryCatch #2 {all -> 0x0184, blocks: (B:20:0x0042, B:22:0x006b, B:25:0x0073, B:32:0x00a5, B:38:0x00b2, B:41:0x00bd, B:43:0x00c3, B:46:0x00cd, B:52:0x00da, B:55:0x00e2, B:62:0x00f1, B:64:0x010c, B:70:0x0133, B:65:0x0110, B:67:0x0116, B:68:0x0125, B:30:0x0089, B:27:0x0079), top: B:95:0x0042, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0168 A[Catch: all -> 0x0177, TRY_LEAVE, TryCatch #3 {all -> 0x0177, blocks: (B:72:0x0150, B:74:0x015b, B:76:0x0168), top: B:97:0x0150 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    default androidx.core.app.NotificationCompat.Builder setActionButtons(android.content.Context r18, android.os.Bundle r19, int r20, androidx.core.app.NotificationCompat.Builder r21, org.json.JSONArray r22) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.INotificationRenderer.setActionButtons(android.content.Context, android.os.Bundle, int, androidx.core.app.NotificationCompat$Builder, org.json.JSONArray):androidx.core.app.NotificationCompat$Builder");
    }
}
