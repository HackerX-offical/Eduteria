package info.mqtt.android.service;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: compiled from: MqttTokenAndroid.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0010\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0015\u0010#\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¢\u0006\u0002\u0010$J\n\u0010%\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u000fH\u0016J\b\u0010-\u001a\u00020.H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Linfo/mqtt/android/service/MqttTokenAndroid;", "Lorg/eclipse/paho/client/mqttv3/IMqttToken;", "client", "Linfo/mqtt/android/service/MqttAndroidClient;", "userContext", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;", "topics", "", "", "<init>", "(Linfo/mqtt/android/service/MqttAndroidClient;Ljava/lang/Object;Lorg/eclipse/paho/client/mqttv3/IMqttActionListener;[Ljava/lang/String;)V", "[Ljava/lang/String;", "isComplete", "", "lastException", "Lorg/eclipse/paho/client/mqttv3/MqttException;", "lock", "Ljava/lang/Object;", "delegate", "pendingException", "", "waitForCompletion", "", "timeout", "", "notifyComplete", "notifyFailure", "throwable", "getException", "getClient", "Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;", "getActionCallback", "setActionCallback", "getTopics", "()[Ljava/lang/String;", "getUserContext", "setUserContext", "setDelegate", "getMessageId", "", "getResponse", "Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;", "getSessionPresent", "getGrantedQos", "", "serviceLibrary_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MqttTokenAndroid implements IMqttToken {
    private final MqttAndroidClient client;
    private IMqttToken delegate;
    private volatile boolean isComplete;
    private volatile MqttException lastException;
    private IMqttActionListener listener;
    private final Object lock;
    private Throwable pendingException;
    private final String[] topics;
    private Object userContext;

    public MqttTokenAndroid(MqttAndroidClient client, Object obj, IMqttActionListener iMqttActionListener, String[] strArr) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.userContext = obj;
        this.listener = iMqttActionListener;
        this.topics = strArr;
        this.lock = new Object();
    }

    public /* synthetic */ MqttTokenAndroid(MqttAndroidClient mqttAndroidClient, Object obj, IMqttActionListener iMqttActionListener, String[] strArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mqttAndroidClient, obj, iMqttActionListener, (i & 8) != 0 ? null : strArr);
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void waitForCompletion() throws Throwable {
        synchronized (this.lock) {
            try {
                this.lock.wait();
            } catch (InterruptedException unused) {
            }
            Unit unit = Unit.INSTANCE;
        }
        Throwable th = this.pendingException;
        if (th != null) {
            throw th;
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void waitForCompletion(long timeout) throws Throwable {
        synchronized (this.lock) {
            try {
                this.lock.wait(timeout);
            } catch (InterruptedException unused) {
            }
            Unit unit = Unit.INSTANCE;
        }
        if (!this.isComplete) {
            throw new MqttException(32000, new Throwable("After " + timeout + " ms"));
        }
        Throwable th = this.pendingException;
        if (th != null) {
            throw th;
        }
    }

    public final void notifyComplete() {
        synchronized (this.lock) {
            this.isComplete = true;
            this.lock.notifyAll();
            IMqttActionListener iMqttActionListener = this.listener;
            if (iMqttActionListener != null) {
                iMqttActionListener.onSuccess(this);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void notifyFailure(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        synchronized (this.lock) {
            this.isComplete = true;
            this.pendingException = throwable;
            this.lock.notifyAll();
            if (throwable instanceof MqttException) {
                this.lastException = (MqttException) throwable;
            }
            IMqttActionListener iMqttActionListener = this.listener;
            if (iMqttActionListener != null) {
                iMqttActionListener.onFailure(this, throwable);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    /* JADX INFO: renamed from: isComplete, reason: from getter */
    public boolean getIsComplete() {
        return this.isComplete;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    /* JADX INFO: renamed from: getException, reason: from getter */
    public MqttException getLastException() {
        return this.lastException;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public IMqttAsyncClient getClient() {
        return this.client;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    /* JADX INFO: renamed from: getActionCallback, reason: from getter */
    public IMqttActionListener getListener() {
        return this.listener;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void setActionCallback(IMqttActionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public String[] getTopics() {
        return this.topics;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public Object getUserContext() {
        return this.userContext;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public void setUserContext(Object userContext) {
        Intrinsics.checkNotNullParameter(userContext, "userContext");
        this.userContext = userContext;
    }

    public final void setDelegate(IMqttToken delegate) {
        this.delegate = delegate;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public int getMessageId() {
        IMqttToken iMqttToken = this.delegate;
        if (iMqttToken == null) {
            return 0;
        }
        Intrinsics.checkNotNull(iMqttToken);
        return iMqttToken.getMessageId();
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public MqttWireMessage getResponse() {
        IMqttToken iMqttToken = this.delegate;
        Intrinsics.checkNotNull(iMqttToken);
        MqttWireMessage response = iMqttToken.getResponse();
        Intrinsics.checkNotNullExpressionValue(response, "getResponse(...)");
        return response;
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public boolean getSessionPresent() {
        IMqttToken iMqttToken = this.delegate;
        Intrinsics.checkNotNull(iMqttToken);
        return iMqttToken.getSessionPresent();
    }

    @Override // org.eclipse.paho.client.mqttv3.IMqttToken
    public int[] getGrantedQos() {
        IMqttToken iMqttToken = this.delegate;
        Intrinsics.checkNotNull(iMqttToken);
        int[] grantedQos = iMqttToken.getGrantedQos();
        Intrinsics.checkNotNullExpressionValue(grantedQos, "getGrantedQos(...)");
        return grantedQos;
    }
}
