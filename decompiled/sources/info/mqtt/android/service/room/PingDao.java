package info.mqtt.android.service.room;

import androidx.lifecycle.LiveData;
import info.mqtt.android.service.ping.PingWorker;
import info.mqtt.android.service.room.entity.PingEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PingDao.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H'J!\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0011\"\u00020\u0005H'¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0005H'J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0015H'R \u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Linfo/mqtt/android/service/room/PingDao;", "", "all", "Landroidx/lifecycle/LiveData;", "", "Linfo/mqtt/android/service/room/entity/PingEntity;", "getAll", "()Landroidx/lifecycle/LiveData;", "allByState", "statePing", "", "insert", "", "pingEntity", "updateAll", "", "pingEntities", "", "([Linfo/mqtt/android/service/room/entity/PingEntity;)V", "delete", "deleteState", "", "removeOldData", PingWorker.KEEP_RECORDS_COUNT, "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface PingDao {
    LiveData<List<PingEntity>> allByState(boolean statePing);

    void delete(PingEntity pingEntity);

    int deleteState(boolean statePing);

    LiveData<List<PingEntity>> getAll();

    long insert(PingEntity pingEntity);

    void removeOldData(int keepCount);

    void updateAll(PingEntity... pingEntities);
}
