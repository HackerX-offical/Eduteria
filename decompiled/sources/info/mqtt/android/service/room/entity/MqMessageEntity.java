package info.mqtt.android.service.room.entity;

import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import info.mqtt.android.service.QoS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: compiled from: MqMessageEntity.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003JY\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010,\u001a\u00020\u000b2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0012\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00061"}, d2 = {"Linfo/mqtt/android/service/room/entity/MqMessageEntity;", "", "messageId", "", "clientHandle", "topic", "mqttMessage", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "qos", "Linfo/mqtt/android/service/QoS;", "retained", "", "duplicate", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/eclipse/paho/client/mqttv3/MqttMessage;Linfo/mqtt/android/service/QoS;ZZJ)V", "getMessageId", "()Ljava/lang/String;", "getClientHandle", "setClientHandle", "(Ljava/lang/String;)V", "getTopic", "setTopic", "getMqttMessage", "()Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "setMqttMessage", "(Lorg/eclipse/paho/client/mqttv3/MqttMessage;)V", "getQos", "()Linfo/mqtt/android/service/QoS;", "getRetained", "()Z", "getDuplicate", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", Constants.COPY_TYPE, "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MqMessageEntity {
    private String clientHandle;
    private final boolean duplicate;
    private final String messageId;
    private MqttMessage mqttMessage;
    private final QoS qos;
    private final boolean retained;
    private final long timestamp;
    private String topic;

    public static /* synthetic */ MqMessageEntity copy$default(MqMessageEntity mqMessageEntity, String str, String str2, String str3, MqttMessage mqttMessage, QoS qoS, boolean z, boolean z2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mqMessageEntity.messageId;
        }
        if ((i & 2) != 0) {
            str2 = mqMessageEntity.clientHandle;
        }
        if ((i & 4) != 0) {
            str3 = mqMessageEntity.topic;
        }
        if ((i & 8) != 0) {
            mqttMessage = mqMessageEntity.mqttMessage;
        }
        if ((i & 16) != 0) {
            qoS = mqMessageEntity.qos;
        }
        if ((i & 32) != 0) {
            z = mqMessageEntity.retained;
        }
        if ((i & 64) != 0) {
            z2 = mqMessageEntity.duplicate;
        }
        if ((i & 128) != 0) {
            j = mqMessageEntity.timestamp;
        }
        long j2 = j;
        boolean z3 = z;
        boolean z4 = z2;
        QoS qoS2 = qoS;
        String str4 = str3;
        return mqMessageEntity.copy(str, str2, str4, mqttMessage, qoS2, z3, z4, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClientHandle() {
        return this.clientHandle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTopic() {
        return this.topic;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MqttMessage getMqttMessage() {
        return this.mqttMessage;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final QoS getQos() {
        return this.qos;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getRetained() {
        return this.retained;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getDuplicate() {
        return this.duplicate;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final MqMessageEntity copy(String messageId, String clientHandle, String topic, MqttMessage mqttMessage, QoS qos, boolean retained, boolean duplicate, long timestamp) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(mqttMessage, "mqttMessage");
        Intrinsics.checkNotNullParameter(qos, "qos");
        return new MqMessageEntity(messageId, clientHandle, topic, mqttMessage, qos, retained, duplicate, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MqMessageEntity)) {
            return false;
        }
        MqMessageEntity mqMessageEntity = (MqMessageEntity) other;
        return Intrinsics.areEqual(this.messageId, mqMessageEntity.messageId) && Intrinsics.areEqual(this.clientHandle, mqMessageEntity.clientHandle) && Intrinsics.areEqual(this.topic, mqMessageEntity.topic) && Intrinsics.areEqual(this.mqttMessage, mqMessageEntity.mqttMessage) && this.qos == mqMessageEntity.qos && this.retained == mqMessageEntity.retained && this.duplicate == mqMessageEntity.duplicate && this.timestamp == mqMessageEntity.timestamp;
    }

    public int hashCode() {
        return (((((((((((((this.messageId.hashCode() * 31) + this.clientHandle.hashCode()) * 31) + this.topic.hashCode()) * 31) + this.mqttMessage.hashCode()) * 31) + this.qos.hashCode()) * 31) + Boolean.hashCode(this.retained)) * 31) + Boolean.hashCode(this.duplicate)) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "MqMessageEntity(messageId=" + this.messageId + ", clientHandle=" + this.clientHandle + ", topic=" + this.topic + ", mqttMessage=" + this.mqttMessage + ", qos=" + this.qos + ", retained=" + this.retained + ", duplicate=" + this.duplicate + ", timestamp=" + this.timestamp + ")";
    }

    public MqMessageEntity(String messageId, String clientHandle, String topic, MqttMessage mqttMessage, QoS qos, boolean z, boolean z2, long j) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(clientHandle, "clientHandle");
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(mqttMessage, "mqttMessage");
        Intrinsics.checkNotNullParameter(qos, "qos");
        this.messageId = messageId;
        this.clientHandle = clientHandle;
        this.topic = topic;
        this.mqttMessage = mqttMessage;
        this.qos = qos;
        this.retained = z;
        this.duplicate = z2;
        this.timestamp = j;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getClientHandle() {
        return this.clientHandle;
    }

    public final void setClientHandle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientHandle = str;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final void setTopic(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.topic = str;
    }

    public final MqttMessage getMqttMessage() {
        return this.mqttMessage;
    }

    public final void setMqttMessage(MqttMessage mqttMessage) {
        Intrinsics.checkNotNullParameter(mqttMessage, "<set-?>");
        this.mqttMessage = mqttMessage;
    }

    public final QoS getQos() {
        return this.qos;
    }

    public final boolean getRetained() {
        return this.retained;
    }

    public final boolean getDuplicate() {
        return this.duplicate;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
