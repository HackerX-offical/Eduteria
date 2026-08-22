package org.pgpainless.decryption_verification;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SignatureException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.PGPSignatureList;
import org.pgpainless.decryption_verification.OpenPgpMetadata;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class SignatureVerifyingInputStream extends FilterInputStream {
    private final PGPObjectFactory objectFactory;
    private final Map<OpenPgpV4Fingerprint, OnePassSignature> onePassSignatures;
    private final OpenPgpMetadata.Builder resultBuilder;
    private boolean validated;
    private static final Logger LOGGER = Logger.getLogger(SignatureVerifyingInputStream.class.getName());
    private static final Level LEVEL = Level.FINE;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    protected SignatureVerifyingInputStream(@Nonnull InputStream inputStream, @Nonnull PGPObjectFactory pGPObjectFactory, @Nonnull Map<OpenPgpV4Fingerprint, OnePassSignature> map, @Nonnull OpenPgpMetadata.Builder builder) {
        super(inputStream);
        this.validated = false;
        this.objectFactory = pGPObjectFactory;
        this.resultBuilder = builder;
        this.onePassSignatures = map;
        LOGGER.log(LEVEL, "Begin verifying OnePassSignatures");
    }

    private void updateOnePassSignatures(byte b2) {
        Iterator<OnePassSignature> it = this.onePassSignatures.values().iterator();
        while (it.hasNext()) {
            it.next().getOnePassSignature().update(b2);
        }
    }

    private void updateOnePassSignatures(byte[] bArr, int i, int i2) {
        Iterator<OnePassSignature> it = this.onePassSignatures.values().iterator();
        while (it.hasNext()) {
            it.next().getOnePassSignature().update(bArr, i, i2);
        }
    }

    private void validateOnePassSignaturesIfNeeded() throws IOException {
        if (this.validated) {
            return;
        }
        this.validated = true;
        validateOnePassSignaturesIfAny();
    }

    private void validateOnePassSignaturesIfAny() throws IOException {
        if (this.onePassSignatures.isEmpty()) {
            LOGGER.log(LEVEL, "No One-Pass-Signatures found -> No validation");
        } else {
            validateOnePassSignatures();
        }
    }

    private void validateOnePassSignatures() throws IOException {
        try {
            for (PGPSignature pGPSignature : findPgpSignatureList()) {
                OpenPgpV4Fingerprint openPgpV4FingerprintFindFingerprintForSignature = findFingerprintForSignature(pGPSignature);
                OnePassSignature onePassSignatureFindOnePassSignature = findOnePassSignature(openPgpV4FingerprintFindFingerprintForSignature);
                if (onePassSignatureFindOnePassSignature == null) {
                    LOGGER.log(LEVEL, "Found Signature without respective OnePassSignature packet -> skip");
                } else {
                    verifySignatureOrThrowSignatureException(pGPSignature, openPgpV4FingerprintFindFingerprintForSignature, onePassSignatureFindOnePassSignature);
                }
            }
        } catch (SignatureException | PGPException e2) {
            throw new IOException(e2.getMessage(), e2);
        }
    }

    private void verifySignatureOrThrowSignatureException(PGPSignature pGPSignature, OpenPgpV4Fingerprint openPgpV4Fingerprint, OnePassSignature onePassSignature) throws SignatureException, PGPException {
        if (onePassSignature.verify(pGPSignature)) {
            LOGGER.log(LEVEL, "Verified signature of key " + Long.toHexString(pGPSignature.getKeyID()));
            return;
        }
        throw new SignatureException("Bad Signature of key " + pGPSignature.getKeyID());
    }

    private OnePassSignature findOnePassSignature(OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        if (openPgpV4Fingerprint != null) {
            return this.onePassSignatures.get(openPgpV4Fingerprint);
        }
        return null;
    }

    private PGPSignatureList findPgpSignatureList() throws IOException {
        Object objNextObject = this.objectFactory.nextObject();
        PGPSignatureList pGPSignatureList = null;
        while (objNextObject != null && pGPSignatureList == null) {
            if (objNextObject instanceof PGPSignatureList) {
                pGPSignatureList = (PGPSignatureList) objNextObject;
            } else {
                objNextObject = this.objectFactory.nextObject();
            }
        }
        if (pGPSignatureList == null || pGPSignatureList.isEmpty()) {
            throw new IOException("Verification failed - No Signatures found");
        }
        return pGPSignatureList;
    }

    private OpenPgpV4Fingerprint findFingerprintForSignature(PGPSignature pGPSignature) {
        for (OpenPgpV4Fingerprint openPgpV4Fingerprint : this.onePassSignatures.keySet()) {
            if (openPgpV4Fingerprint.getKeyId() == pGPSignature.getKeyID()) {
                return openPgpV4Fingerprint;
            }
        }
        return null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = super.read();
        if (i == -1) {
            validateOnePassSignaturesIfNeeded();
            return i;
        }
        updateOnePassSignatures((byte) i);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 == -1) {
            validateOnePassSignaturesIfNeeded();
            return i3;
        }
        updateOnePassSignatures(bArr, i, i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        throw new UnsupportedOperationException("skip() is not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        throw new UnsupportedOperationException("mark() not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        throw new UnsupportedOperationException("reset() is not supported");
    }
}
