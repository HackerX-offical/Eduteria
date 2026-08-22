package org.jivesoftware.smack;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes10.dex */
public interface XmppInputOutputFilter {
    default void closeInputOutput() {
    }

    String getFilterName();

    Object getStats();

    ByteBuffer input(ByteBuffer byteBuffer) throws IOException;

    OutputResult output(ByteBuffer byteBuffer, boolean z, boolean z2, boolean z3) throws IOException;

    default void waitUntilInputOutputClosed() throws SmackException, InterruptedException, IOException, CertificateException, XMPPException {
    }

    public static class OutputResult {
        public static final OutputResult NO_OUTPUT = new OutputResult(false, null);
        public final ByteBuffer filteredOutputData;
        public final boolean pendingFilterData;

        public OutputResult(ByteBuffer byteBuffer) {
            this(false, byteBuffer);
        }

        public OutputResult(boolean z, ByteBuffer byteBuffer) {
            this.pendingFilterData = z;
            this.filteredOutputData = byteBuffer;
        }
    }
}
