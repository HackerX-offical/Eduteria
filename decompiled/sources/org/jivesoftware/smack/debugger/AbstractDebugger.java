package org.jivesoftware.smack.debugger;

import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.ReconnectionListener;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.TopLevelStreamElement;
import org.jivesoftware.smack.util.ObservableReader;
import org.jivesoftware.smack.util.ObservableWriter;
import org.jivesoftware.smack.util.ReaderListener;
import org.jivesoftware.smack.util.WriterListener;
import org.jxmpp.jid.EntityFullJid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractDebugger extends SmackDebugger {
    private static final Logger LOGGER = Logger.getLogger(AbstractDebugger.class.getName());
    public static boolean printInterpreted = false;
    private final ConnectionListener connListener;
    private ObservableReader reader;
    private final ReaderListener readerListener;
    private final ReconnectionListener reconnectionListener;
    private ObservableWriter writer;
    private final WriterListener writerListener;

    protected abstract void log(String str);

    protected abstract void log(String str, Throwable th);

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public void onOutgoingStreamElement(TopLevelStreamElement topLevelStreamElement) {
    }

    public AbstractDebugger(final XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.reader = new ObservableReader(this.reader);
        ReaderListener readerListener = new ReaderListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.1
            @Override // org.jivesoftware.smack.util.ReaderListener
            public void read(String str) {
                AbstractDebugger.this.log("RECV (" + xMPPConnection.getConnectionCounter() + "): " + str);
            }
        };
        this.readerListener = readerListener;
        this.reader.addReaderListener(readerListener);
        this.writer = new ObservableWriter(this.writer);
        WriterListener writerListener = new WriterListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.2
            @Override // org.jivesoftware.smack.util.WriterListener
            public void write(String str) {
                AbstractDebugger.this.log("SENT (" + xMPPConnection.getConnectionCounter() + "): " + str);
            }
        };
        this.writerListener = writerListener;
        this.writer.addWriterListener(writerListener);
        this.connListener = new ConnectionListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.3
            @Override // org.jivesoftware.smack.ConnectionListener
            public void connected(XMPPConnection xMPPConnection2) {
                AbstractDebugger.this.log("XMPPConnection connected (" + xMPPConnection2 + ")");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void authenticated(XMPPConnection xMPPConnection2, boolean z) {
                String str = "XMPPConnection authenticated (" + xMPPConnection2 + ")";
                if (z) {
                    str = str + " and resumed";
                }
                AbstractDebugger.this.log(str);
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosed() {
                AbstractDebugger.this.log("XMPPConnection closed (" + xMPPConnection + ")");
            }

            @Override // org.jivesoftware.smack.ConnectionListener
            public void connectionClosedOnError(Exception exc) {
                AbstractDebugger.this.log("XMPPConnection closed due to an exception (" + xMPPConnection + ")", exc);
            }
        };
        ReconnectionListener reconnectionListener = new ReconnectionListener() { // from class: org.jivesoftware.smack.debugger.AbstractDebugger.4
            @Override // org.jivesoftware.smack.ReconnectionListener
            public void reconnectionFailed(Exception exc) {
                AbstractDebugger.this.log("Reconnection failed due to an exception (" + xMPPConnection + ")", exc);
            }

            @Override // org.jivesoftware.smack.ReconnectionListener
            public void reconnectingIn(int i) {
                AbstractDebugger.this.log("XMPPConnection (" + xMPPConnection + ") will reconnect in " + i);
            }
        };
        this.reconnectionListener = reconnectionListener;
        if (xMPPConnection instanceof AbstractXMPPConnection) {
            ReconnectionManager.getInstanceFor((AbstractXMPPConnection) xMPPConnection).addReconnectionListener(reconnectionListener);
        } else {
            LOGGER.info("The connection instance " + xMPPConnection + " is not an instance of AbstractXMPPConnection, thus we can not install the ReconnectionListener");
        }
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    /* JADX INFO: renamed from: outgoingStreamSink */
    public final void m14197x8b8e340f(CharSequence charSequence) {
        log("SENT (" + this.connection.getConnectionCounter() + "): " + ((Object) charSequence));
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    /* JADX INFO: renamed from: incomingStreamSink */
    public final void m14195x4a9ebbdd(CharSequence charSequence) {
        log("RECV (" + this.connection.getConnectionCounter() + "): " + ((Object) charSequence));
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public void userHasLogged(EntityFullJid entityFullJid) {
        String string = entityFullJid.getLocalpart().toString();
        boolean zEquals = "".equals(string);
        StringBuilder sbAppend = new StringBuilder("User logged (").append(this.connection.getConnectionCounter()).append("): ");
        if (zEquals) {
            string = "";
        }
        log(sbAppend.append(string).append("@").append((Object) this.connection.getXMPPServiceDomain()).append(":").append(this.connection.getPort()).toString() + MqttTopic.TOPIC_LEVEL_SEPARATOR + ((Object) entityFullJid.getResourcepart()));
        this.connection.addConnectionListener(this.connListener);
    }

    @Override // org.jivesoftware.smack.debugger.SmackDebugger
    public void onIncomingStreamElement(TopLevelStreamElement topLevelStreamElement) {
        if (printInterpreted) {
            log("RCV PKT (" + this.connection.getConnectionCounter() + "): " + ((Object) topLevelStreamElement.toXML()));
        }
    }
}
