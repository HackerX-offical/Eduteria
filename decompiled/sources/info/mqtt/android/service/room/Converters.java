package info.mqtt.android.service.room;

import info.mqtt.android.service.QoS;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: compiled from: Converters.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\nH\u0007¨\u0006\r"}, d2 = {"Linfo/mqtt/android/service/room/Converters;", "", "<init>", "()V", "toQoS", "Linfo/mqtt/android/service/QoS;", "value", "", "fromQoS", "toMqttMessage", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "", "fromMqttMessage", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Converters {
    public final QoS toQoS(int value) {
        return QoS.values()[value];
    }

    public final int fromQoS(QoS value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.getValue();
    }

    public final MqttMessage toMqttMessage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] bytes = value.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return new MqttMessage(bytes);
    }

    public final String fromMqttMessage(MqttMessage value) {
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] payload = value.getPayload();
        Intrinsics.checkNotNullExpressionValue(payload, "getPayload(...)");
        return new String(payload, Charsets.UTF_8);
    }
}
