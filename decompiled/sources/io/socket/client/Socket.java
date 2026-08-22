package io.socket.client;

import io.socket.client.Manager;
import io.socket.client.On;
import io.socket.emitter.Emitter;
import io.socket.parser.Packet;
import io.socket.thread.EventThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class Socket extends Emitter {
    public static final String EVENT_CONNECT = "connect";
    public static final String EVENT_CONNECT_ERROR = "connect_error";
    public static final String EVENT_DISCONNECT = "disconnect";
    static final String EVENT_MESSAGE = "message";
    private Map<String, String> auth;
    private volatile boolean connected;
    String id;
    private int ids;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private Manager f1344io;
    private String nsp;
    private Queue<On.Handle> subs;
    private static final Logger logger = Logger.getLogger(Socket.class.getName());
    protected static Map<String, Integer> RESERVED_EVENTS = new HashMap<String, Integer>() { // from class: io.socket.client.Socket.1
        {
            put("connect", 1);
            put(Socket.EVENT_CONNECT_ERROR, 1);
            put("disconnect", 1);
            put("disconnecting", 1);
            put("newListener", 1);
            put("removeListener", 1);
        }
    };
    private Map<Integer, Ack> acks = new HashMap();
    private final Queue<List<Object>> receiveBuffer = new LinkedList();
    private final Queue<Packet<JSONArray>> sendBuffer = new LinkedList();

    static /* synthetic */ int access$708(Socket socket) {
        int i = socket.ids;
        socket.ids = i + 1;
        return i;
    }

    public Socket(Manager manager, String str, Manager.Options options) {
        this.f1344io = manager;
        this.nsp = str;
        if (options != null) {
            this.auth = options.auth;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subEvents() {
        if (this.subs != null) {
            return;
        }
        this.subs = new LinkedList<On.Handle>(this.f1344io) { // from class: io.socket.client.Socket.2
            final /* synthetic */ Manager val$io;

            {
                this.val$io = manager;
                add(On.on(manager, "open", new Emitter.Listener() { // from class: io.socket.client.Socket.2.1
                    @Override // io.socket.emitter.Emitter.Listener
                    public void call(Object... objArr) {
                        Socket.this.onopen();
                    }
                }));
                add(On.on(manager, "packet", new Emitter.Listener() { // from class: io.socket.client.Socket.2.2
                    @Override // io.socket.emitter.Emitter.Listener
                    public void call(Object... objArr) {
                        Socket.this.onpacket((Packet) objArr[0]);
                    }
                }));
                add(On.on(manager, "error", new Emitter.Listener() { // from class: io.socket.client.Socket.2.3
                    @Override // io.socket.emitter.Emitter.Listener
                    public void call(Object... objArr) {
                        if (Socket.this.connected) {
                            return;
                        }
                        Socket.super.emit(Socket.EVENT_CONNECT_ERROR, objArr[0]);
                    }
                }));
                add(On.on(manager, "close", new Emitter.Listener() { // from class: io.socket.client.Socket.2.4
                    @Override // io.socket.emitter.Emitter.Listener
                    public void call(Object... objArr) {
                        Socket.this.onclose(objArr.length > 0 ? (String) objArr[0] : null);
                    }
                }));
            }
        };
    }

    public boolean isActive() {
        return this.subs != null;
    }

    public Socket open() {
        EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.3
            @Override // java.lang.Runnable
            public void run() {
                if (Socket.this.connected || Socket.this.f1344io.isReconnecting()) {
                    return;
                }
                Socket.this.subEvents();
                Socket.this.f1344io.open();
                if (Manager.ReadyState.OPEN == Socket.this.f1344io.readyState) {
                    Socket.this.onopen();
                }
            }
        });
        return this;
    }

    public Socket connect() {
        return open();
    }

    public Socket send(final Object... objArr) {
        EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.4
            @Override // java.lang.Runnable
            public void run() {
                Socket.this.emit("message", objArr);
            }
        });
        return this;
    }

    @Override // io.socket.emitter.Emitter
    public Emitter emit(final String str, final Object... objArr) {
        if (RESERVED_EVENTS.containsKey(str)) {
            throw new RuntimeException("'" + str + "' is a reserved event name");
        }
        EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.5
            @Override // java.lang.Runnable
            public void run() {
                Ack ack;
                Object[] objArr2 = objArr;
                int length = objArr2.length - 1;
                if (objArr2.length <= 0 || !(objArr2[length] instanceof Ack)) {
                    ack = null;
                } else {
                    objArr2 = new Object[length];
                    for (int i = 0; i < length; i++) {
                        objArr2[i] = objArr[i];
                    }
                    ack = (Ack) objArr[length];
                }
                Socket.this.emit(str, objArr2, ack);
            }
        });
        return this;
    }

    public Emitter emit(final String str, final Object[] objArr, final Ack ack) {
        EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.6
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                Object[] objArr2 = objArr;
                if (objArr2 != null) {
                    for (Object obj : objArr2) {
                        jSONArray.put(obj);
                    }
                }
                Packet packet = new Packet(2, jSONArray);
                if (ack != null) {
                    Socket.logger.fine(String.format("emitting packet with ack id %d", Integer.valueOf(Socket.this.ids)));
                    Socket.this.acks.put(Integer.valueOf(Socket.this.ids), ack);
                    packet.id = Socket.access$708(Socket.this);
                }
                if (Socket.this.connected) {
                    Socket.this.packet(packet);
                } else {
                    Socket.this.sendBuffer.add(packet);
                }
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void packet(Packet packet) {
        packet.nsp = this.nsp;
        this.f1344io.packet(packet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onopen() {
        logger.fine("transport is open - connecting");
        if (this.auth != null) {
            packet(new Packet(0, new JSONObject(this.auth)));
        } else {
            packet(new Packet(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onclose(String str) {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("close (%s)", str));
        }
        this.connected = false;
        this.id = null;
        super.emit("disconnect", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void onpacket(Packet<?> packet) {
        if (this.nsp.equals(packet.nsp)) {
            switch (packet.type) {
                case 0:
                    if ((packet.data instanceof JSONObject) && ((JSONObject) packet.data).has("sid")) {
                        try {
                            onconnect(((JSONObject) packet.data).getString("sid"));
                        } catch (JSONException unused) {
                            return;
                        }
                    } else {
                        super.emit(EVENT_CONNECT_ERROR, new SocketIOException("It seems you are trying to reach a Socket.IO server in v2.x with a v3.x client, which is not possible"));
                    }
                    break;
                case 1:
                    ondisconnect();
                    break;
                case 2:
                    onevent(packet);
                    break;
                case 3:
                    onack(packet);
                    break;
                case 4:
                    super.emit(EVENT_CONNECT_ERROR, packet.data);
                    break;
                case 5:
                    onevent(packet);
                    break;
                case 6:
                    onack(packet);
                    break;
            }
        }
    }

    private void onevent(Packet<JSONArray> packet) {
        ArrayList arrayList = new ArrayList(Arrays.asList(toArray(packet.data)));
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("emitting event %s", arrayList));
        }
        if (packet.id >= 0) {
            logger2.fine("attaching ack callback to event");
            arrayList.add(ack(packet.id));
        }
        if (this.connected) {
            if (arrayList.isEmpty()) {
                return;
            }
            super.emit(arrayList.remove(0).toString(), arrayList.toArray());
            return;
        }
        this.receiveBuffer.add(arrayList);
    }

    private Ack ack(final int i) {
        final boolean[] zArr = {false};
        return new Ack() { // from class: io.socket.client.Socket.7
            @Override // io.socket.client.Ack
            public void call(final Object... objArr) {
                EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (zArr[0]) {
                            return;
                        }
                        zArr[0] = true;
                        if (Socket.logger.isLoggable(Level.FINE)) {
                            Logger logger2 = Socket.logger;
                            Object[] objArr2 = objArr;
                            if (objArr2.length == 0) {
                                objArr2 = null;
                            }
                            logger2.fine(String.format("sending ack %s", objArr2));
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (Object obj : objArr) {
                            jSONArray.put(obj);
                        }
                        Packet packet = new Packet(3, jSONArray);
                        packet.id = i;
                        this.packet(packet);
                    }
                });
            }
        };
    }

    private void onack(Packet<JSONArray> packet) {
        Ack ackRemove = this.acks.remove(Integer.valueOf(packet.id));
        if (ackRemove != null) {
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(String.format("calling ack %s with %s", Integer.valueOf(packet.id), packet.data));
            }
            ackRemove.call(toArray(packet.data));
            return;
        }
        Logger logger3 = logger;
        if (logger3.isLoggable(Level.FINE)) {
            logger3.fine(String.format("bad ack %s", Integer.valueOf(packet.id)));
        }
    }

    private void onconnect(String str) {
        this.connected = true;
        this.id = str;
        emitBuffered();
        super.emit("connect", new Object[0]);
    }

    private void emitBuffered() {
        while (true) {
            List<Object> listPoll = this.receiveBuffer.poll();
            if (listPoll == null) {
                break;
            } else {
                super.emit((String) listPoll.get(0), listPoll.toArray());
            }
        }
        this.receiveBuffer.clear();
        while (true) {
            Packet<JSONArray> packetPoll = this.sendBuffer.poll();
            if (packetPoll != null) {
                packet(packetPoll);
            } else {
                this.sendBuffer.clear();
                return;
            }
        }
    }

    private void ondisconnect() {
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("server disconnect (%s)", this.nsp));
        }
        destroy();
        onclose("io server disconnect");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        Queue<On.Handle> queue = this.subs;
        if (queue != null) {
            Iterator<On.Handle> it = queue.iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.subs = null;
        }
        this.f1344io.destroy();
    }

    public Socket close() {
        EventThread.exec(new Runnable() { // from class: io.socket.client.Socket.8
            @Override // java.lang.Runnable
            public void run() {
                if (Socket.this.connected) {
                    if (Socket.logger.isLoggable(Level.FINE)) {
                        Socket.logger.fine(String.format("performing disconnect (%s)", Socket.this.nsp));
                    }
                    Socket.this.packet(new Packet(1));
                }
                Socket.this.destroy();
                if (Socket.this.connected) {
                    Socket.this.onclose("io client disconnect");
                }
            }
        });
        return this;
    }

    public Socket disconnect() {
        return close();
    }

    public Manager io() {
        return this.f1344io;
    }

    public boolean connected() {
        return this.connected;
    }

    public String id() {
        return this.id;
    }

    private static Object[] toArray(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i);
            } catch (JSONException e2) {
                logger.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e2);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i] = obj2;
        }
        return objArr;
    }
}
