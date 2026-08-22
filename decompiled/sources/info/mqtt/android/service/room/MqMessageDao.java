package info.mqtt.android.service.room;

import info.mqtt.android.service.room.entity.MqMessageEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: MqMessageDao.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H'J!\u0010\r\u001a\u00020\u000e2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004H'¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0004H'J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH'J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH'R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Linfo/mqtt/android/service/room/MqMessageDao;", "", "all", "", "Linfo/mqtt/android/service/room/entity/MqMessageEntity;", "getAll", "()Ljava/util/List;", "allArrived", "clientHandle", "", "insert", "", "mqMessageEntity", "updateAll", "", "", "([Linfo/mqtt/android/service/room/entity/MqMessageEntity;)V", "delete", "deleteId", "", "id", "deleteClientHandle", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MqMessageDao {
    List<MqMessageEntity> allArrived(String clientHandle);

    void delete(MqMessageEntity mqMessageEntity);

    int deleteClientHandle(String clientHandle);

    int deleteId(String clientHandle, String id);

    List<MqMessageEntity> getAll();

    long insert(MqMessageEntity mqMessageEntity);

    void updateAll(MqMessageEntity... mqMessageEntity);
}
