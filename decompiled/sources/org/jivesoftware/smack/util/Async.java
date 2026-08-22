package org.jivesoftware.smack.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class Async {
    public static Thread go(Runnable runnable) {
        Thread threadDaemonThreadFrom = daemonThreadFrom(runnable);
        threadDaemonThreadFrom.start();
        return threadDaemonThreadFrom;
    }

    public static Thread go(Runnable runnable, String str) {
        Thread threadDaemonThreadFrom = daemonThreadFrom(runnable);
        threadDaemonThreadFrom.setName(str);
        threadDaemonThreadFrom.start();
        return threadDaemonThreadFrom;
    }

    public static Thread daemonThreadFrom(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    public static abstract class ThrowingRunnable implements Runnable {
        public static final Logger LOGGER = Logger.getLogger(ThrowingRunnable.class.getName());

        public abstract void runOrThrow() throws Exception;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                runOrThrow();
            } catch (Exception e2) {
                if (e2 instanceof RuntimeException) {
                    throw ((RuntimeException) e2);
                }
                LOGGER.log(Level.WARNING, "Caught Exception", (Throwable) e2);
            }
        }
    }
}
