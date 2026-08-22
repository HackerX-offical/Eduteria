package org.eclipse.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttInputStream;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubComp;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubRec;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* JADX INFO: loaded from: classes10.dex */
public class CommsReceiver implements Runnable {
    private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.CommsReceiver";
    private ClientComms clientComms;
    private ClientState clientState;
    private MqttInputStream in;
    private Future<?> receiverFuture;
    private String threadName;
    private CommsTokenStore tokenStore;
    private Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private State current_state = State.STOPPED;
    private State target_state = State.STOPPED;
    private final Object lifecycle = new Object();
    private Thread recThread = null;

    private enum State {
        STOPPED,
        RUNNING,
        STARTING,
        RECEIVING;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    public CommsReceiver(ClientComms clientComms, ClientState clientState, CommsTokenStore commsTokenStore, InputStream inputStream) {
        this.clientState = null;
        this.clientComms = null;
        this.tokenStore = null;
        this.in = new MqttInputStream(clientState, inputStream);
        this.clientComms = clientComms;
        this.clientState = clientState;
        this.tokenStore = commsTokenStore;
        this.log.setResourceName(clientComms.getClient().getClientId());
    }

    public void start(String str, ExecutorService executorService) {
        this.threadName = str;
        this.log.fine(CLASS_NAME, "start", "855");
        synchronized (this.lifecycle) {
            if (this.current_state == State.STOPPED && this.target_state == State.STOPPED) {
                this.target_state = State.RUNNING;
                if (executorService == null) {
                    new Thread(this).start();
                } else {
                    this.receiverFuture = executorService.submit(this);
                }
            }
        }
        while (!isRunning()) {
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
    }

    public void stop() {
        synchronized (this.lifecycle) {
            Future<?> future = this.receiverFuture;
            if (future != null) {
                future.cancel(true);
            }
            this.log.fine(CLASS_NAME, "stop", "850");
            if (isRunning()) {
                this.target_state = State.STOPPED;
            }
        }
        while (isRunning()) {
            try {
                Thread.sleep(100L);
            } catch (Exception unused) {
            }
        }
        this.log.fine(CLASS_NAME, "stop", "851");
    }

    @Override // java.lang.Runnable
    public void run() {
        State state;
        Thread threadCurrentThread = Thread.currentThread();
        this.recThread = threadCurrentThread;
        threadCurrentThread.setName(this.threadName);
        synchronized (this.lifecycle) {
            this.current_state = State.RUNNING;
        }
        try {
            synchronized (this.lifecycle) {
                state = this.target_state;
            }
            MqttToken token = null;
            while (state == State.RUNNING && this.in != null) {
                try {
                    try {
                        try {
                            Logger logger = this.log;
                            String str = CLASS_NAME;
                            logger.fine(str, "run", "852");
                            if (this.in.available() > 0) {
                                synchronized (this.lifecycle) {
                                    this.current_state = State.RECEIVING;
                                }
                            }
                            MqttWireMessage mqttWireMessage = this.in.readMqttWireMessage();
                            synchronized (this.lifecycle) {
                                this.current_state = State.RUNNING;
                            }
                            if (mqttWireMessage instanceof MqttAck) {
                                token = this.tokenStore.getToken(mqttWireMessage);
                                if (token != null) {
                                    synchronized (token) {
                                        this.clientState.notifyReceivedAck((MqttAck) mqttWireMessage);
                                    }
                                } else {
                                    if (!(mqttWireMessage instanceof MqttPubRec) && !(mqttWireMessage instanceof MqttPubComp) && !(mqttWireMessage instanceof MqttPubAck)) {
                                        throw new MqttException(6);
                                    }
                                    this.log.fine(str, "run", "857");
                                }
                            } else if (mqttWireMessage != null) {
                                this.clientState.notifyReceivedMsg(mqttWireMessage);
                            } else if (!this.clientComms.isConnected() && !this.clientComms.isConnecting()) {
                                throw new IOException("Connection is lost.");
                            }
                            synchronized (this.lifecycle) {
                                this.current_state = State.RUNNING;
                            }
                        } catch (Throwable th) {
                            synchronized (this.lifecycle) {
                                this.current_state = State.RUNNING;
                                throw th;
                            }
                        }
                    } catch (MqttException e2) {
                        this.log.fine(CLASS_NAME, "run", "856", null, e2);
                        synchronized (this.lifecycle) {
                            this.target_state = State.STOPPED;
                            this.clientComms.shutdownConnection(token, e2);
                            synchronized (this.lifecycle) {
                                this.current_state = State.RUNNING;
                            }
                        }
                    }
                } catch (IOException e3) {
                    this.log.fine(CLASS_NAME, "run", "853");
                    if (this.target_state != State.STOPPED) {
                        synchronized (this.lifecycle) {
                            this.target_state = State.STOPPED;
                            if (!this.clientComms.isDisconnecting()) {
                                this.clientComms.shutdownConnection(token, new MqttException(32109, e3));
                            }
                        }
                    }
                    synchronized (this.lifecycle) {
                        this.current_state = State.RUNNING;
                    }
                }
                synchronized (this.lifecycle) {
                    state = this.target_state;
                }
            }
            synchronized (this.lifecycle) {
                this.current_state = State.STOPPED;
            }
            this.recThread = null;
            this.log.fine(CLASS_NAME, "run", "854");
        } catch (Throwable th2) {
            synchronized (this.lifecycle) {
                this.current_state = State.STOPPED;
                throw th2;
            }
        }
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.lifecycle) {
            z = (this.current_state == State.RUNNING || this.current_state == State.RECEIVING) && this.target_state == State.RUNNING;
        }
        return z;
    }

    public boolean isReceiving() {
        boolean z;
        synchronized (this.lifecycle) {
            z = this.current_state == State.RECEIVING;
        }
        return z;
    }
}
