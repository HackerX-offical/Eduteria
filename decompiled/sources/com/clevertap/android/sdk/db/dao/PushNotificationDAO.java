package com.clevertap.android.sdk.db.dao;

import kotlin.Metadata;

/* JADX INFO: compiled from: PushNotificationDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH'¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u001b\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\tH'¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0003H'¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/PushNotificationDAO;", "", "storePushNotificationId", "", "id", "", "ttlInSeconds", "", "fetchPushNotificationIds", "", "()[Ljava/lang/String;", "doesPushNotificationIdExist", "", "updatePushNotificationIds", "ids", "([Ljava/lang/String;)V", "cleanUpPushNotifications", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PushNotificationDAO {
    void cleanUpPushNotifications();

    boolean doesPushNotificationIdExist(String id);

    String[] fetchPushNotificationIds();

    void storePushNotificationId(String id, long ttlInSeconds);

    void updatePushNotificationIds(String[] ids);
}
