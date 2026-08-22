package com.clevertap.android.sdk.usereventlogs;

import com.clevertap.android.sdk.db.Column;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: UserEventLogDAO.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H'J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H'J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\r0\fH'J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H'J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H'J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H'J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0011H'J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0004\u001a\u00020\u0005H'J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0016H'J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H'¨\u0006\u001b"}, d2 = {"Lcom/clevertap/android/sdk/usereventlogs/UserEventLogDAO;", "", "insertEvent", "", Column.DEVICE_ID, "", "eventName", Column.NORMALIZED_EVENT_NAME, "updateEventByDeviceIdAndNormalizedEventName", "", "upsertEventsByDeviceIdAndNormalizedEventName", "setOfActualAndNormalizedEventNamePair", "", "Lkotlin/Pair;", "readEventByDeviceIdAndNormalizedEventName", "Lcom/clevertap/android/sdk/usereventlogs/UserEventLog;", "readEventCountByDeviceIdAndNormalizedEventName", "", "eventExistsByDeviceIdAndNormalizedEventName", "eventExistsByDeviceIdAndNormalizedEventNameAndCount", "count", "allEventsByDeviceID", "", "allEvents", "cleanUpExtraEvents", "rowsThreshold", "numberOfRowsToCleanup", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UserEventLogDAO {
    List<UserEventLog> allEvents();

    List<UserEventLog> allEventsByDeviceID(String deviceID);

    boolean cleanUpExtraEvents(int rowsThreshold, int numberOfRowsToCleanup);

    boolean eventExistsByDeviceIdAndNormalizedEventName(String deviceID, String normalizedEventName);

    boolean eventExistsByDeviceIdAndNormalizedEventNameAndCount(String deviceID, String normalizedEventName, int count);

    long insertEvent(String deviceID, String eventName, String normalizedEventName);

    UserEventLog readEventByDeviceIdAndNormalizedEventName(String deviceID, String normalizedEventName);

    int readEventCountByDeviceIdAndNormalizedEventName(String deviceID, String normalizedEventName);

    boolean updateEventByDeviceIdAndNormalizedEventName(String deviceID, String normalizedEventName);

    boolean upsertEventsByDeviceIdAndNormalizedEventName(String deviceID, Set<Pair<String, String>> setOfActualAndNormalizedEventNamePair);
}
