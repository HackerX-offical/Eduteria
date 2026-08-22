package info.mqtt.android.service;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: compiled from: MqttDeliveryTokenAndroid.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Linfo/mqtt/android/service/MqttDeliveryTokenAndroid;", "Linfo/mqtt/android/service/MqttTokenAndroid;", "Lorg/eclipse/paho/client/mqttv3/IMqttDeliveryToken;", "client", "Linfo/mqtt/android/service/MqttAndroidClient;", "userContext", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "message", "Lorg/eclipse/paho/client/mqttv3/MqttMessage;", "<init>", "(Linfo/mqtt/android/service/MqttAndroidClient;Ljava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;Lorg/eclipse/paho/client/mqttv3/MqttMessage;)V", "getMessage", "setMessage", "", "notifyDelivery", "delivered", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqttDeliveryTokenAndroid extends MqttTokenAndroid implements IMqttDeliveryToken {
    private MqttMessage message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MqttDeliveryTokenAndroid(MqttAndroidClient client, Object obj, IMqttActionListener iMqttActionListener, MqttMessage message) {
        super(client, obj, iMqttActionListener, null, 8, null);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
    public MqttMessage getMessage() {
        return this.message;
    }

    public final void setMessage(MqttMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    public final void notifyDelivery(MqttMessage delivered) {
        Intrinsics.checkNotNullParameter(delivered, "delivered");
        this.message = delivered;
        super.notifyComplete();
    }
}
