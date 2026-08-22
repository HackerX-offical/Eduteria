package org.jivesoftware.smack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.packet.Stanza;

/* JADX INFO: loaded from: classes10.dex */
public final class StanzaCollector implements AutoCloseable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private volatile boolean cancelled;
    private List<Stanza> collectedCache;
    private final StanzaCollector collectorToReset;
    private final XMPPConnection connection;
    private Exception connectionException;
    private final int maxQueueSize;
    private final StanzaFilter packetFilter;
    private final Stanza request;
    private final ArrayDeque<Stanza> resultQueue;
    private String stringCache;
    private volatile long waitStart;

    StanzaCollector(XMPPConnection xMPPConnection, Configuration configuration) {
        this.connection = xMPPConnection;
        this.packetFilter = configuration.packetFilter;
        this.resultQueue = new ArrayDeque<>(configuration.size);
        this.maxQueueSize = configuration.size;
        this.collectorToReset = configuration.collectorToReset;
        this.request = configuration.request;
    }

    public synchronized void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.connection.removeStanzaCollector(this);
        notifyAll();
        StanzaCollector stanzaCollector = this.collectorToReset;
        if (stanzaCollector != null) {
            stanzaCollector.cancel();
        }
    }

    public StanzaFilter getStanzaFilter() {
        return this.packetFilter;
    }

    public synchronized <P extends Stanza> P pollResult() {
        return (P) this.resultQueue.poll();
    }

    public <P extends Stanza> P pollResultOrThrow() throws XMPPException.XMPPErrorException {
        P p = (P) pollResult();
        if (p != null) {
            XMPPException.XMPPErrorException.ifHasErrorThenThrow(p);
        }
        return p;
    }

    public synchronized <P extends Stanza> P nextResultBlockForever() throws InterruptedException {
        throwIfCancelled();
        while (true) {
            P p = (P) this.resultQueue.poll();
            if (p != null) {
                return p;
            }
            if (this.cancelled) {
                return null;
            }
            wait();
        }
    }

    public <P extends Stanza> P nextResult() throws InterruptedException {
        return (P) nextResult(this.connection.getReplyTimeout());
    }

    public <P extends Stanza> P nextResult(long j) throws InterruptedException {
        throwIfCancelled();
        this.waitStart = System.currentTimeMillis();
        P p = null;
        long jCurrentTimeMillis = j;
        while (jCurrentTimeMillis > 0 && this.connectionException == null && !this.cancelled) {
            synchronized (this) {
                p = (P) this.resultQueue.poll();
                if (p != null) {
                    return p;
                }
                wait(jCurrentTimeMillis);
            }
            jCurrentTimeMillis = j - (System.currentTimeMillis() - this.waitStart);
        }
        return p;
    }

    public <P extends Stanza> P nextResultOrThrow() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return (P) nextResultOrThrow(this.connection.getReplyTimeout());
    }

    public <P extends Stanza> P nextResultOrThrow(long j) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        try {
            P p = (P) nextResult(j);
            if (p == null) {
                if (this.connectionException != null) {
                    throw new SmackException.NotConnectedException(this.connection, this.packetFilter, this.connectionException);
                }
                if (!this.connection.isConnected()) {
                    throw new SmackException.NotConnectedException(this.connection, this.packetFilter);
                }
                throw SmackException.NoResponseException.newWith(j, this, this.cancelled);
            }
            XMPPException.XMPPErrorException.ifHasErrorThenThrow(p);
            return p;
        } finally {
            cancel();
        }
    }

    public List<Stanza> getCollectedStanzasAfterCancelled() {
        if (!this.cancelled) {
            throw new IllegalStateException("Stanza collector was not yet cancelled");
        }
        if (this.collectedCache == null) {
            ArrayList arrayList = new ArrayList(getCollectedCount());
            this.collectedCache = arrayList;
            arrayList.addAll(this.resultQueue);
        }
        return this.collectedCache;
    }

    public synchronized int getCollectedCount() {
        return this.resultQueue.size();
    }

    public String toString() {
        if (this.stringCache == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Stanza Collector filter='").append(this.packetFilter).append('\'');
            if (this.request != null) {
                sb.append(" request='").append(this.request).append('\'');
            }
            this.stringCache = sb.toString();
        }
        return this.stringCache;
    }

    synchronized void notifyConnectionError(Exception exc) {
        this.connectionException = exc;
        notifyAll();
    }

    protected void processStanza(Stanza stanza) {
        StanzaFilter stanzaFilter = this.packetFilter;
        if (stanzaFilter == null || stanzaFilter.accept(stanza)) {
            synchronized (this) {
                if (this.resultQueue.size() == this.maxQueueSize) {
                    this.resultQueue.poll();
                }
                this.resultQueue.add(stanza);
                notifyAll();
            }
            StanzaCollector stanzaCollector = this.collectorToReset;
            if (stanzaCollector != null) {
                stanzaCollector.waitStart = System.currentTimeMillis();
            }
        }
    }

    private void throwIfCancelled() {
        if (this.cancelled) {
            throw new IllegalStateException("Stanza collector already cancelled");
        }
    }

    public static Configuration newConfiguration() {
        return new Configuration();
    }

    public static final class Configuration {
        private StanzaCollector collectorToReset;
        private StanzaFilter packetFilter;
        private Stanza request;
        private int size;

        private Configuration() {
            this.size = SmackConfiguration.getStanzaCollectorSize();
        }

        public Configuration setStanzaFilter(StanzaFilter stanzaFilter) {
            this.packetFilter = stanzaFilter;
            return this;
        }

        public Configuration setSize(int i) {
            this.size = i;
            return this;
        }

        public Configuration setCollectorToReset(StanzaCollector stanzaCollector) {
            this.collectorToReset = stanzaCollector;
            return this;
        }

        public Configuration setRequest(Stanza stanza) {
            this.request = stanza;
            return this;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        cancel();
    }
}
