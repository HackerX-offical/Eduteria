package com.amazonaws.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SdkInputStream extends InputStream implements MetricAware {
    protected void abort() throws IOException {
    }

    protected abstract InputStream getWrappedInputStream();

    @Override // com.amazonaws.internal.MetricAware
    @Deprecated
    public final boolean isMetricActivated() {
        Closeable wrappedInputStream = getWrappedInputStream();
        if (wrappedInputStream instanceof MetricAware) {
            return ((MetricAware) wrappedInputStream).isMetricActivated();
        }
        return false;
    }

    protected final void abortIfNeeded() {
        if (Thread.interrupted()) {
            try {
                abort();
            } catch (IOException e2) {
                LogFactory.getLog(getClass()).debug("FYI", e2);
            }
            throw new AbortedException();
        }
    }
}
