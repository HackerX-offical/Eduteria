package info.mqtt.android.service.ping;

import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import info.mqtt.android.service.MqttService;
import info.mqtt.android.service.room.MqMessageDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import timber.log.Timber;

/* JADX INFO: compiled from: AlarmPingSender.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Linfo/mqtt/android/service/ping/AlarmPingSender;", "Lorg/eclipse/paho/client/mqttv3/MqttPingSender;", NotificationCompat.CATEGORY_SERVICE, "Linfo/mqtt/android/service/MqttService;", "id", "", "pingLogging", "", "keepPingRecords", "", "<init>", "(Linfo/mqtt/android/service/MqttService;Ljava/lang/String;ZI)V", "getService", "()Linfo/mqtt/android/service/MqttService;", "getId", "()Ljava/lang/String;", "workManager", "Landroidx/work/WorkManager;", "init", "", "comms", "Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;", "start", "stop", "schedule", "delayInMilliseconds", "", "Companion", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlarmPingSender implements MqttPingSender {
    private static final String PING_JOB = "PING_JOB";
    private static MqMessageDatabase messageDatabase;
    private final String id;
    private final int keepPingRecords;
    private final boolean pingLogging;
    private final MqttService service;
    private final WorkManager workManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ConcurrentHashMap<String, ClientComms> clientCommsMap = new ConcurrentHashMap<>();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss'Z'", Locale.getDefault());

    public AlarmPingSender(MqttService service, String id, boolean z, int i) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(id, "id");
        this.service = service;
        this.id = id;
        this.pingLogging = z;
        this.keepPingRecords = i;
        this.workManager = WorkManager.INSTANCE.getInstance(service);
    }

    public /* synthetic */ AlarmPingSender(MqttService mqttService, String str, boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mqttService, str, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 1000 : i);
    }

    public final MqttService getService() {
        return this.service;
    }

    public final String getId() {
        return this.id;
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void init(ClientComms comms) {
        Intrinsics.checkNotNullParameter(comms, "comms");
        clientCommsMap.put(this.id, comms);
        messageDatabase = this.service.getMessageDatabase();
        Timber.INSTANCE.w("Init ping job " + this.id, new Object[0]);
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void start() {
        Timber.INSTANCE.d("Start ping job " + this.id, new Object[0]);
        ClientComms clientComms = clientCommsMap.get(this.id);
        if (clientComms != null && clientComms.getClientState() != null) {
            ClientComms clientComms2 = clientCommsMap.get(this.id);
            Intrinsics.checkNotNull(clientComms2);
            schedule(clientComms2.getKeepAlive());
            return;
        }
        Timber.INSTANCE.e("FIXME: try to start ping schedule, but clientState null, not able to get keepAlive", new Object[0]);
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void stop() {
        Timber.INSTANCE.d("Stop ping job " + this.id, new Object[0]);
        this.workManager.cancelAllWorkByTag("PING_JOB_" + this.id);
    }

    @Override // org.eclipse.paho.client.mqttv3.MqttPingSender
    public void schedule(long delayInMilliseconds) {
        Timber.INSTANCE.d(this.id + ": Schedule next alarm at " + sdf.format(new Date(System.currentTimeMillis() + delayInMilliseconds)), new Object[0]);
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) PingWorker.class);
        Data.Builder builder2 = new Data.Builder();
        builder2.putBoolean(PingWorker.LOGGING, this.pingLogging);
        builder2.putInt("keepRecordCount", this.keepPingRecords);
        builder2.putString("id", this.id);
        builder.setInitialDelay(delayInMilliseconds, TimeUnit.MILLISECONDS).setInputData(builder2.build()).addTag("PING_JOB_" + this.id);
        this.workManager.enqueueUniqueWork("PING_JOB_" + this.id + "_" + System.currentTimeMillis(), ExistingWorkPolicy.REPLACE, builder.build());
        Timber.INSTANCE.d(this.id + ": Successfully scheduled new ping job", new Object[0]);
    }

    /* JADX INFO: compiled from: AlarmPingSender.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00148\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Linfo/mqtt/android/service/ping/AlarmPingSender$Companion;", "", "<init>", "()V", "clientCommsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;", "getClientCommsMap$serviceLibrary_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "setClientCommsMap$serviceLibrary_release", "(Ljava/util/concurrent/ConcurrentHashMap;)V", AlarmPingSender.PING_JOB, "messageDatabase", "Linfo/mqtt/android/service/room/MqMessageDatabase;", "getMessageDatabase$serviceLibrary_release", "()Linfo/mqtt/android/service/room/MqMessageDatabase;", "setMessageDatabase$serviceLibrary_release", "(Linfo/mqtt/android/service/room/MqMessageDatabase;)V", "sdf", "Ljava/text/SimpleDateFormat;", "getSdf$serviceLibrary_release", "()Ljava/text/SimpleDateFormat;", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConcurrentHashMap<String, ClientComms> getClientCommsMap$serviceLibrary_release() {
            return AlarmPingSender.clientCommsMap;
        }

        public final void setClientCommsMap$serviceLibrary_release(ConcurrentHashMap<String, ClientComms> concurrentHashMap) {
            Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
            AlarmPingSender.clientCommsMap = concurrentHashMap;
        }

        public final MqMessageDatabase getMessageDatabase$serviceLibrary_release() {
            return AlarmPingSender.messageDatabase;
        }

        public final void setMessageDatabase$serviceLibrary_release(MqMessageDatabase mqMessageDatabase) {
            AlarmPingSender.messageDatabase = mqMessageDatabase;
        }

        public final SimpleDateFormat getSdf$serviceLibrary_release() {
            return AlarmPingSender.sdf;
        }
    }
}
