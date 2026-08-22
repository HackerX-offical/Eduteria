package com.clevertap.android.sdk.db;

import android.content.Context;
import com.clevertap.android.sdk.events.EventGroup;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseDatabaseManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J,\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J\u001e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&¨\u0006\u001d"}, d2 = {"Lcom/clevertap/android/sdk/db/BaseDatabaseManager;", "", "loadDBAdapter", "Lcom/clevertap/android/sdk/db/DBAdapter;", "context", "Landroid/content/Context;", "clearQueues", "", "getQueuedEvents", "Lcom/clevertap/android/sdk/db/QueueData;", "batchSize", "", "eventGroup", "Lcom/clevertap/android/sdk/events/EventGroup;", "getCombinedQueuedEvents", "queueEventToDB", "event", "Lorg/json/JSONObject;", "type", "queuePushNotificationViewedEventToDB", "getPushNotificationViewedQueuedEvents", "cleanupSentEvents", "", "eventIds", "", "", "profileEventIds", "cleanupPushNotificationEvents", "ids", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BaseDatabaseManager {
    boolean cleanupPushNotificationEvents(Context context, List<String> ids);

    boolean cleanupSentEvents(Context context, List<String> eventIds, List<String> profileEventIds);

    void clearQueues(Context context);

    QueueData getCombinedQueuedEvents(Context context, int batchSize);

    QueueData getPushNotificationViewedQueuedEvents(Context context, int batchSize);

    QueueData getQueuedEvents(Context context, int batchSize, EventGroup eventGroup);

    DBAdapter loadDBAdapter(Context context);

    void queueEventToDB(Context context, JSONObject event, int type);

    void queuePushNotificationViewedEventToDB(Context context, JSONObject event);
}
