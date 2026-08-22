package org.bouncycastle.openpgp.operator.bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.io.CipherOutputStream;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PGPDataEncryptor;
import org.bouncycastle.openpgp.operator.PGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class BcPGPDataEncryptorBuilder implements PGPDataEncryptorBuilder {
    private int encAlgorithm;
    private SecureRandom random;
    private boolean withIntegrityPacket;

    private class MyPGPDataEncryptor implements PGPDataEncryptor {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final BufferedBlockCipher f1462c;

        MyPGPDataEncryptor(byte[] bArr) throws PGPException {
            try {
                this.f1462c = BcUtil.createStreamCipher(true, BcImplProvider.createBlockCipher(BcPGPDataEncryptorBuilder.this.encAlgorithm), BcPGPDataEncryptorBuilder.this.withIntegrityPacket, bArr);
            } catch (IllegalArgumentException e2) {
                throw new PGPException("invalid parameters: " + e2.getMessage(), e2);
            }
        }

        @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptor
        public int getBlockSize() {
            return this.f1462c.getBlockSize();
        }

        @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptor
        public PGPDigestCalculator getIntegrityCalculator() {
            if (BcPGPDataEncryptorBuilder.this.withIntegrityPacket) {
                return new SHA1PGPDigestCalculator();
            }
            return null;
        }

        @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.f1462c);
        }
    }

    public BcPGPDataEncryptorBuilder(int i) {
        this.encAlgorithm = i;
        if (i == 0) {
            throw new IllegalArgumentException("null cipher specified");
        }
    }

    @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptorBuilder
    public PGPDataEncryptor build(byte[] bArr) throws PGPException {
        return new MyPGPDataEncryptor(bArr);
    }

    @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptorBuilder
    public int getAlgorithm() {
        return this.encAlgorithm;
    }

    @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptorBuilder
    public SecureRandom getSecureRandom() {
        if (this.random == null) {
            this.random = new SecureRandom();
        }
        return this.random;
    }

    public BcPGPDataEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public BcPGPDataEncryptorBuilder setWithIntegrityPacket(boolean z) {
        this.withIntegrityPacket = z;
        return this;
    }
}
