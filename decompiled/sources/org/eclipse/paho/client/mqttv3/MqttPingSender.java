package org.eclipse.paho.client.mqttv3;

import org.eclipse.paho.client.mqttv3.internal.ClientComms;

/* JADX INFO: loaded from: classes10.dex */
public interface MqttPingSender {
    void init(ClientComms clientComms);

    void schedule(long j);

    void start();

    void stop();
}
