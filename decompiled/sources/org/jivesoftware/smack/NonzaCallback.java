package org.jivesoftware.smack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.util.XmppElementUtil;

/* JADX INFO: loaded from: classes10.dex */
public class NonzaCallback {
    protected final AbstractXMPPConnection connection;
    protected final Map<QName, ClassAndConsumer<? extends Nonza>> filterAndListeners;

    public interface NonzaListener<N extends Nonza> {
        void accept(N n) throws IOException;
    }

    private NonzaCallback(Builder builder) {
        this.connection = builder.connection;
        this.filterAndListeners = builder.filterAndListeners;
        install();
    }

    void onNonzaReceived(Nonza nonza) throws IOException {
        this.filterAndListeners.get(nonza.getQName()).accept(nonza);
    }

    public void cancel() {
        Iterator<Map.Entry<QName, ClassAndConsumer<? extends Nonza>>> it = this.filterAndListeners.entrySet().iterator();
        while (it.hasNext()) {
            QName key = it.next().getKey();
            synchronized (this.connection.nonzaCallbacksMap) {
                this.connection.nonzaCallbacksMap.removeOne(key, this);
            }
        }
    }

    protected void install() {
        if (this.filterAndListeners.isEmpty()) {
            return;
        }
        for (QName qName : this.filterAndListeners.keySet()) {
            synchronized (this.connection.nonzaCallbacksMap) {
                this.connection.nonzaCallbacksMap.put(qName, this);
            }
        }
    }

    private static final class NonzaResponseCallback<SN extends Nonza, FN extends Nonza> extends NonzaCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private FN failedNonza;
        private SN successNonza;

        /* JADX WARN: Illegal instructions before constructor call */
        private NonzaResponseCallback(Class<SN> cls, Class<FN> cls2, Builder builder) {
            super(builder);
            QName qNameFor = XmppElementUtil.getQNameFor(cls);
            QName qNameFor2 = XmppElementUtil.getQNameFor(cls2);
            ClassAndConsumer<? extends Nonza> classAndConsumer = new ClassAndConsumer<>(cls, new NonzaListener<SN>() { // from class: org.jivesoftware.smack.NonzaCallback.NonzaResponseCallback.1
                @Override // org.jivesoftware.smack.NonzaCallback.NonzaListener
                public void accept(SN sn) {
                    NonzaResponseCallback.this.successNonza = sn;
                    NonzaResponseCallback.this.notifyResponse();
                }
            });
            ClassAndConsumer<? extends Nonza> classAndConsumer2 = new ClassAndConsumer<>(cls2, new NonzaListener<FN>() { // from class: org.jivesoftware.smack.NonzaCallback.NonzaResponseCallback.2
                @Override // org.jivesoftware.smack.NonzaCallback.NonzaListener
                public void accept(FN fn) {
                    NonzaResponseCallback.this.failedNonza = fn;
                    NonzaResponseCallback.this.notifyResponse();
                }
            });
            this.filterAndListeners.put(qNameFor, classAndConsumer);
            this.filterAndListeners.put(qNameFor2, classAndConsumer2);
            install();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void notifyResponse() {
            synchronized (this) {
                notifyAll();
            }
        }

        private boolean hasReceivedSuccessOrFailedNonza() {
            return (this.successNonza == null && this.failedNonza == null) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SN waitForResponse() throws SmackException.NoResponseException, InterruptedException, XMPPException.FailedNonzaException {
            long jCurrentTimeMillis = System.currentTimeMillis() + this.connection.getReplyTimeout();
            synchronized (this) {
                while (!hasReceivedSuccessOrFailedNonza()) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    if (jCurrentTimeMillis2 >= jCurrentTimeMillis) {
                        break;
                    }
                    wait(jCurrentTimeMillis - jCurrentTimeMillis2);
                }
            }
            if (!hasReceivedSuccessOrFailedNonza()) {
                throw SmackException.NoResponseException.newWith(this.connection, "Nonza Listener");
            }
            if (this.failedNonza != null) {
                throw new XMPPException.FailedNonzaException(this.failedNonza);
            }
            return this.successNonza;
        }
    }

    public static final class Builder {
        private final AbstractXMPPConnection connection;
        private Map<QName, ClassAndConsumer<? extends Nonza>> filterAndListeners = new HashMap();

        Builder(AbstractXMPPConnection abstractXMPPConnection) {
            this.connection = abstractXMPPConnection;
        }

        public <N extends Nonza> Builder listenFor(Class<N> cls, NonzaListener<N> nonzaListener) {
            this.filterAndListeners.put(XmppElementUtil.getQNameFor(cls), new ClassAndConsumer<>(cls, nonzaListener));
            return this;
        }

        public NonzaCallback install() {
            return new NonzaCallback(this);
        }
    }

    private static final class ClassAndConsumer<N extends Nonza> {
        private final Class<N> clazz;
        private final NonzaListener<N> consumer;

        private ClassAndConsumer(Class<N> cls, NonzaListener<N> nonzaListener) {
            this.clazz = cls;
            this.consumer = nonzaListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void accept(Object obj) throws IOException {
            this.consumer.accept(this.clazz.cast(obj));
        }
    }

    static <SN extends Nonza, FN extends Nonza> SN sendAndWaitForResponse(Builder builder, Nonza nonza, Class<SN> cls, Class<FN> cls2) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.FailedNonzaException {
        NonzaResponseCallback nonzaResponseCallback = new NonzaResponseCallback(cls, cls2, builder);
        try {
            nonzaResponseCallback.connection.sendNonza(nonza);
            return (SN) nonzaResponseCallback.waitForResponse();
        } finally {
            nonzaResponseCallback.cancel();
        }
    }
}
