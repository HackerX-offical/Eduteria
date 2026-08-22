package org.eclipse.paho.client.mqttv3.internal;

import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes10.dex */
public interface DestinationProvider {
    MqttTopic getTopic(String str);
}
