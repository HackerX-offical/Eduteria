package org.jivesoftware.smack.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jivesoftware.smack.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public abstract class XMPPInputOutputStream {
    protected static FlushMethod flushMethod = FlushMethod.SYNC_FLUSH;
    protected final String compressionMethod;

    public enum FlushMethod {
        FULL_FLUSH,
        SYNC_FLUSH
    }

    public abstract InputStream getInputStream(InputStream inputStream) throws IOException;

    public abstract OutputStream getOutputStream(OutputStream outputStream) throws IOException;

    public abstract boolean isSupported();

    public static void setFlushMethod(FlushMethod flushMethod2) {
        flushMethod = (FlushMethod) Objects.requireNonNull(flushMethod2);
    }

    public static FlushMethod getFlushMethod() {
        return flushMethod;
    }

    protected XMPPInputOutputStream(String str) {
        this.compressionMethod = str;
    }

    public String getCompressionMethod() {
        return this.compressionMethod;
    }
}
