package org.jivesoftware.smack;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StreamError;
import org.jivesoftware.smack.util.Async;

/* JADX INFO: loaded from: classes10.dex */
public final class ReconnectionManager {
    private static int defaultFixedDelay;
    private static ReconnectionPolicy defaultReconnectionPolicy;
    private static boolean enabledPerDefault;
    private Thread reconnectionThread;
    private final WeakReference<AbstractXMPPConnection> weakRefConnection;
    private static final Logger LOGGER = Logger.getLogger(ReconnectionManager.class.getName());
    private static final Map<AbstractXMPPConnection, ReconnectionManager> INSTANCES = new WeakHashMap();
    private final Set<ReconnectionListener> reconnectionListeners = new CopyOnWriteArraySet();
    private final int randomBase = new Random().nextInt(13) + 2;
    private volatile int fixedDelay = defaultFixedDelay;
    private volatile ReconnectionPolicy reconnectionPolicy = defaultReconnectionPolicy;
    private boolean automaticReconnectEnabled = false;
    boolean done = false;
    private final ConnectionListener connectionListener = new ConnectionListener() { // from class: org.jivesoftware.smack.ReconnectionManager.3
        @Override // org.jivesoftware.smack.ConnectionListener
        public void connectionClosed() {
            ReconnectionManager.this.done = true;
        }

        @Override // org.jivesoftware.smack.ConnectionListener
        public void authenticated(XMPPConnection xMPPConnection, boolean z) {
            ReconnectionManager.this.done = false;
        }

        @Override // org.jivesoftware.smack.ConnectionListener
        public void connectionClosedOnError(Exception exc) {
            ReconnectionManager.this.done = false;
            if (ReconnectionManager.this.isAutomaticReconnectEnabled()) {
                if (exc instanceof XMPPException.StreamErrorException) {
                    if (StreamError.Condition.conflict == ((XMPPException.StreamErrorException) exc).getStreamError().getCondition()) {
                        return;
                    }
                }
                ReconnectionManager.this.reconnect();
            }
        }
    };
    private final Runnable reconnectionRunnable = new Runnable() { // from class: org.jivesoftware.smack.ReconnectionManager.2
        private int attempts = 0;

        private int timeDelay() {
            this.attempts++;
            int i = AnonymousClass4.$SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy[ReconnectionManager.this.reconnectionPolicy.ordinal()];
            if (i == 1) {
                return ReconnectionManager.this.fixedDelay;
            }
            if (i == 2) {
                int i2 = this.attempts;
                if (i2 > 13) {
                    return ReconnectionManager.this.randomBase * 30;
                }
                return i2 > 7 ? ReconnectionManager.this.randomBase * 6 : ReconnectionManager.this.randomBase;
            }
            throw new AssertionError("Unknown reconnection policy " + ReconnectionManager.this.reconnectionPolicy);
        }

        /* JADX WARN: Removed duplicated region for block: B:51:0x00b4 A[LOOP:4: B:49:0x00ae->B:51:0x00b4, LOOP_END] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 202
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jivesoftware.smack.ReconnectionManager.AnonymousClass2.run():void");
        }
    };

    public enum ReconnectionPolicy {
        RANDOM_INCREASING_DELAY,
        FIXED_DELAY
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smack.ReconnectionManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                if (xMPPConnection instanceof AbstractXMPPConnection) {
                    ReconnectionManager.getInstanceFor((AbstractXMPPConnection) xMPPConnection);
                }
            }
        });
        enabledPerDefault = false;
        defaultFixedDelay = 15;
        defaultReconnectionPolicy = ReconnectionPolicy.RANDOM_INCREASING_DELAY;
    }

    public static synchronized ReconnectionManager getInstanceFor(AbstractXMPPConnection abstractXMPPConnection) {
        ReconnectionManager reconnectionManager;
        Map<AbstractXMPPConnection, ReconnectionManager> map = INSTANCES;
        reconnectionManager = map.get(abstractXMPPConnection);
        if (reconnectionManager == null) {
            reconnectionManager = new ReconnectionManager(abstractXMPPConnection);
            map.put(abstractXMPPConnection, reconnectionManager);
        }
        return reconnectionManager;
    }

    public static void setEnabledPerDefault(boolean z) {
        enabledPerDefault = z;
    }

    public static boolean getEnabledPerDefault() {
        return enabledPerDefault;
    }

    public static void setDefaultFixedDelay(int i) {
        defaultFixedDelay = i;
        setDefaultReconnectionPolicy(ReconnectionPolicy.FIXED_DELAY);
    }

    public static void setDefaultReconnectionPolicy(ReconnectionPolicy reconnectionPolicy) {
        defaultReconnectionPolicy = reconnectionPolicy;
    }

    public boolean addReconnectionListener(ReconnectionListener reconnectionListener) {
        return this.reconnectionListeners.add(reconnectionListener);
    }

    public boolean removeReconnectionListener(ReconnectionListener reconnectionListener) {
        return this.reconnectionListeners.remove(reconnectionListener);
    }

    public void setFixedDelay(int i) {
        this.fixedDelay = i;
        setReconnectionPolicy(ReconnectionPolicy.FIXED_DELAY);
    }

    public void setReconnectionPolicy(ReconnectionPolicy reconnectionPolicy) {
        this.reconnectionPolicy = reconnectionPolicy;
    }

    private ReconnectionManager(AbstractXMPPConnection abstractXMPPConnection) {
        this.weakRefConnection = new WeakReference<>(abstractXMPPConnection);
        if (getEnabledPerDefault()) {
            enableAutomaticReconnection();
        }
    }

    /* JADX INFO: renamed from: org.jivesoftware.smack.ReconnectionManager$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy;

        static {
            int[] iArr = new int[ReconnectionPolicy.values().length];
            $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy = iArr;
            try {
                iArr[ReconnectionPolicy.FIXED_DELAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$ReconnectionManager$ReconnectionPolicy[ReconnectionPolicy.RANDOM_INCREASING_DELAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public synchronized void enableAutomaticReconnection() {
        if (this.automaticReconnectEnabled) {
            return;
        }
        AbstractXMPPConnection abstractXMPPConnection = this.weakRefConnection.get();
        if (abstractXMPPConnection == null) {
            throw new IllegalStateException("Connection instance no longer available");
        }
        abstractXMPPConnection.addConnectionListener(this.connectionListener);
        this.automaticReconnectEnabled = true;
    }

    public synchronized void disableAutomaticReconnection() {
        if (this.automaticReconnectEnabled) {
            AbstractXMPPConnection abstractXMPPConnection = this.weakRefConnection.get();
            if (abstractXMPPConnection == null) {
                throw new IllegalStateException("Connection instance no longer available");
            }
            abstractXMPPConnection.removeConnectionListener(this.connectionListener);
            this.automaticReconnectEnabled = false;
        }
    }

    public synchronized boolean isAutomaticReconnectEnabled() {
        return this.automaticReconnectEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReconnectionPossible(XMPPConnection xMPPConnection) {
        return (this.done || xMPPConnection.isConnected() || !isAutomaticReconnectEnabled()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reconnect() {
        AbstractXMPPConnection abstractXMPPConnection = this.weakRefConnection.get();
        if (abstractXMPPConnection == null) {
            LOGGER.fine("Connection is null, will not reconnect");
            return;
        }
        Thread thread = this.reconnectionThread;
        if (thread == null || !thread.isAlive()) {
            this.reconnectionThread = Async.go(this.reconnectionRunnable, "Smack Reconnection Manager (" + abstractXMPPConnection.getConnectionCounter() + ')');
        }
    }

    public synchronized void abortPossiblyRunningReconnection() {
        Thread thread = this.reconnectionThread;
        if (thread == null) {
            return;
        }
        thread.interrupt();
        this.reconnectionThread = null;
    }
}
