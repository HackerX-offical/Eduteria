package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes10.dex */
public interface IDiscardedBufferMessageCallback {
    void messageDiscarded(MqttWireMessage mqttWireMessage);
}
