package com.clevertap.android.sdk.events;

import android.content.Context;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseEventQueueManager {
    public abstract void addToQueue(Context context, JSONObject jSONObject, int i);

    public abstract void flush();

    public abstract void flushQueueAsync(Context context, EventGroup eventGroup);

    public abstract void flushQueueSync(Context context, EventGroup eventGroup);

    public abstract void flushQueueSync(Context context, EventGroup eventGroup, String str);

    public abstract void flushQueueSync(Context context, EventGroup eventGroup, String str, boolean z);

    public abstract void pushBasicProfile(JSONObject jSONObject, boolean z);

    public abstract void pushInitialEventsAsync();

    public abstract Future<?> queueEvent(Context context, JSONObject jSONObject, int i);

    public abstract void scheduleQueueFlush(Context context);

    public abstract void sendImmediately(Context context, EventGroup eventGroup, JSONObject jSONObject);
}
