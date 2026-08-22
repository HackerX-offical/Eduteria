package com.amazonaws.http;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.conn.ClientConnectionManager;

/* JADX INFO: loaded from: classes4.dex */
public final class IdleConnectionReaper extends Thread {
    private static final int MINUTE_IN_SECONDS = 60;
    private static final int PERIOD_MILLISECONDS = 60000;
    private static IdleConnectionReaper instance;
    private volatile boolean shuttingDown;
    private static final ArrayList<ClientConnectionManager> CONNECTION_MANAGERS = new ArrayList<>();
    static final Log log = LogFactory.getLog(IdleConnectionReaper.class);

    private IdleConnectionReaper() {
        super("java-sdk-http-connection-reaper");
        setDaemon(true);
    }

    public static synchronized boolean registerConnectionManager(ClientConnectionManager clientConnectionManager) {
        if (instance == null) {
            IdleConnectionReaper idleConnectionReaper = new IdleConnectionReaper();
            instance = idleConnectionReaper;
            idleConnectionReaper.start();
        }
        return CONNECTION_MANAGERS.add(clientConnectionManager);
    }

    public static synchronized boolean removeConnectionManager(ClientConnectionManager clientConnectionManager) {
        boolean zRemove;
        ArrayList<ClientConnectionManager> arrayList = CONNECTION_MANAGERS;
        zRemove = arrayList.remove(clientConnectionManager);
        if (arrayList.isEmpty()) {
            shutdown();
        }
        return zRemove;
    }

    private void markShuttingDown() {
        this.shuttingDown = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        List list;
        while (!this.shuttingDown) {
            try {
                Thread.sleep(60000L);
                synchronized (IdleConnectionReaper.class) {
                    list = (List) CONNECTION_MANAGERS.clone();
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((ClientConnectionManager) it.next()).closeIdleConnections(60L, TimeUnit.SECONDS);
                    } catch (Exception e2) {
                        log.warn("Unable to close idle connections", e2);
                    }
                }
            } catch (Throwable th) {
                log.debug("Reaper thread: ", th);
            }
        }
        log.debug("Shutting down reaper thread.");
    }

    public static synchronized boolean shutdown() {
        IdleConnectionReaper idleConnectionReaper = instance;
        if (idleConnectionReaper == null) {
            return false;
        }
        idleConnectionReaper.markShuttingDown();
        instance.interrupt();
        CONNECTION_MANAGERS.clear();
        instance = null;
        return true;
    }

    static synchronized int size() {
        return CONNECTION_MANAGERS.size();
    }
}
