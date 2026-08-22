package org.jivesoftware.smack.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes10.dex */
public class CloseableUtil {
    public static void maybeClose(Closeable closeable) {
        maybeClose(closeable, null);
    }

    public static void maybeClose(Closeable closeable, Logger logger) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            if (logger != null) {
                logger.log(Level.WARNING, "Could not close " + closeable, (Throwable) e2);
            }
        }
    }
}
