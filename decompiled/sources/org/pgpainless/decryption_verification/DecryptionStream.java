package org.pgpainless.decryption_verification;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.pgpainless.decryption_verification.OpenPgpMetadata;

/* JADX INFO: loaded from: classes10.dex */
public class DecryptionStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger(DecryptionStream.class.getName());
    private final InputStream inputStream;
    private boolean isClosed = false;
    private final OpenPgpMetadata.Builder resultBuilder;

    DecryptionStream(@Nonnull InputStream inputStream, @Nonnull OpenPgpMetadata.Builder builder) {
        this.inputStream = inputStream;
        this.resultBuilder = builder;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.inputStream.read();
        maybeUpdateDetachedSignatures(i);
        return i;
    }

    private void maybeUpdateDetachedSignatures(int i) {
        for (DetachedSignature detachedSignature : this.resultBuilder.getDetachedSignatures()) {
            if (i != -1) {
                detachedSignature.getSignature().update((byte) i);
            }
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inputStream.close();
        maybeVerifyDetachedSignatures();
        this.isClosed = true;
    }

    void maybeVerifyDetachedSignatures() {
        for (DetachedSignature detachedSignature : this.resultBuilder.getDetachedSignatures()) {
            try {
                detachedSignature.setVerified(detachedSignature.getSignature().verify());
            } catch (PGPException e2) {
                LOGGER.log(Level.WARNING, "Could not verify signature of key " + ((Object) detachedSignature.getFingerprint()), (Throwable) e2);
            }
        }
    }

    public OpenPgpMetadata getResult() {
        if (!this.isClosed) {
            throw new IllegalStateException("DecryptionStream MUST be closed before the result can be accessed.");
        }
        return this.resultBuilder.build();
    }
}
