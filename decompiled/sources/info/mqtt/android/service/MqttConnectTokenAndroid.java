package info.mqtt.android.service;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: compiled from: MqttConnectTokenAndroid.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0015\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0016¢\u0006\u0002\u0010\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Linfo/mqtt/android/service/MqttConnectTokenAndroid;", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "sessionPresent", "", "<init>", "(Z)V", "waitForCompletion", "", "timeout", "", "isComplete", "getException", "Lorg/eclipse/paho/client/mqttv3/MqttException;", "getActionCallback", "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "setActionCallback", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getClient", "Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;", "getTopics", "", "", "()[Ljava/lang/String;", "getUserContext", "", "setUserContext", "userContext", "getMessageId", "", "getGrantedQos", "", "getSessionPresent", "getResponse", "Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MqttConnectTokenAndroid implements IMqttToken {
    private final boolean sessionPresent;

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public IMqttActionListener getActionCallback() {
        return null;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public IMqttAsyncClient getClient() {
        return null;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public MqttException getException() {
        return null;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public int getMessageId() {
        return 0;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public MqttWireMessage getResponse() {
        return null;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public Object getUserContext() {
        return null;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public boolean isComplete() {
        return false;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void setActionCallback(IMqttActionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void setUserContext(Object userContext) {
        Intrinsics.checkNotNullParameter(userContext, "userContext");
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void waitForCompletion() throws MqttException {
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void waitForCompletion(long timeout) throws MqttException {
    }

    public MqttConnectTokenAndroid(boolean z) {
        this.sessionPresent = z;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public String[] getTopics() {
        return new String[0];
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public int[] getGrantedQos() {
        return new int[0];
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public boolean getSessionPresent() {
        return this.sessionPresent;
    }
}
