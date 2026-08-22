package com.clevertap.android.sdk.db.dao;

import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.db.QueueData;
import com.clevertap.android.sdk.db.Table;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH'J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\u0015"}, d2 = {"Lcom/clevertap/android/sdk/db/dao/EventDAO;", "", "storeEvent", "", "event", "Lorg/json/JSONObject;", "table", "Lcom/clevertap/android/sdk/db/Table;", "fetchEvents", "Lcom/clevertap/android/sdk/db/QueueData;", Constants.KEY_LIMIT, "", "fetchCombinedEvents", "batchSize", "cleanupEventsFromLastId", "", "lastId", "", "cleanupStaleEvents", "removeAllEvents", "updateAllEvents", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EventDAO {
    void cleanupEventsFromLastId(String lastId, Table table);

    void cleanupStaleEvents(Table table);

    QueueData fetchCombinedEvents(int batchSize);

    QueueData fetchEvents(Table table, int limit);

    void removeAllEvents(Table table);

    long storeEvent(JSONObject event, Table table);

    int updateAllEvents(Table table);
}
