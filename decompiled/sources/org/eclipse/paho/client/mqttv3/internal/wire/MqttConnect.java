package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/* JADX INFO: loaded from: classes10.dex */
public class MqttConnect extends MqttWireMessage {
    public static final String KEY = "Con";
    private boolean cleanSession;
    private String clientId;
    private int keepAliveInterval;
    private int mqttVersion;
    private char[] password;
    private String userName;
    private String willDestination;
    private MqttMessage willMessage;

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    protected byte getMessageInfo() {
        return (byte) 0;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    public MqttConnect(byte b2, byte[] bArr) throws MqttException, IOException {
        super((byte) 1);
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        decodeUTF8(dataInputStream);
        dataInputStream.readByte();
        dataInputStream.readByte();
        this.keepAliveInterval = dataInputStream.readUnsignedShort();
        this.clientId = decodeUTF8(dataInputStream);
        dataInputStream.close();
    }

    public MqttConnect(String str, int i, boolean z, int i2, String str2, char[] cArr, MqttMessage mqttMessage, String str3) {
        super((byte) 1);
        this.clientId = str;
        this.cleanSession = z;
        this.keepAliveInterval = i2;
        this.userName = str2;
        if (cArr != null) {
            this.password = (char[]) cArr.clone();
        }
        this.willMessage = mqttMessage;
        this.willDestination = str3;
        this.mqttVersion = i;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String toString() {
        return String.valueOf(super.toString()) + " clientId " + this.clientId + " keepAliveInterval " + this.keepAliveInterval;
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    protected byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            int i = this.mqttVersion;
            if (i == 3) {
                encodeUTF8(dataOutputStream, "MQIsdp");
            } else if (i == 4) {
                encodeUTF8(dataOutputStream, "MQTT");
            }
            dataOutputStream.write(this.mqttVersion);
            byte qos = this.cleanSession ? (byte) 2 : (byte) 0;
            MqttMessage mqttMessage = this.willMessage;
            if (mqttMessage != null) {
                qos = (byte) (((byte) (qos | 4)) | (mqttMessage.getQos() << 3));
                if (this.willMessage.isRetained()) {
                    qos = (byte) (qos | 32);
                }
            }
            if (this.userName != null) {
                qos = (byte) (qos | 128);
                if (this.password != null) {
                    qos = (byte) (qos | 64);
                }
            }
            dataOutputStream.write(qos);
            dataOutputStream.writeShort(this.keepAliveInterval);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            encodeUTF8(dataOutputStream, this.clientId);
            if (this.willMessage != null) {
                encodeUTF8(dataOutputStream, this.willDestination);
                dataOutputStream.writeShort(this.willMessage.getPayload().length);
                dataOutputStream.write(this.willMessage.getPayload());
            }
            String str = this.userName;
            if (str != null) {
                encodeUTF8(dataOutputStream, str);
                if (this.password != null) {
                    encodeUTF8(dataOutputStream, new String(this.password));
                }
            }
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException(e2);
        }
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String getKey() {
        return "Con";
    }
}
