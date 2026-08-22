package org.bouncycastle.openpgp.operator.jcajce;

import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.jcajce.io.CipherOutputStream;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.PGPDataEncryptor;
import org.bouncycastle.openpgp.operator.PGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class JcePGPDataEncryptorBuilder implements PGPDataEncryptorBuilder {
    private int encAlgorithm;

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private OperatorHelper f1474helper = new OperatorHelper(new DefaultJcaJceHelper());
    private SecureRandom random;
    private boolean withIntegrityPacket;

    private class MyPGPDataEncryptor implements PGPDataEncryptor {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Cipher f1475c;

        MyPGPDataEncryptor(byte[] bArr) throws PGPException {
            Cipher cipherCreateStreamCipher = JcePGPDataEncryptorBuilder.this.f1474helper.createStreamCipher(JcePGPDataEncryptorBuilder.this.encAlgorithm, JcePGPDataEncryptorBuilder.this.withIntegrityPacket);
            this.f1475c = cipherCreateStreamCipher;
            try {
                if (!JcePGPDataEncryptorBuilder.this.withIntegrityPacket) {
                    cipherCreateStreamCipher.init(1, JcaJcePGPUtil.makeSymmetricKey(JcePGPDataEncryptorBuilder.this.encAlgorithm, bArr));
                } else {
                    cipherCreateStreamCipher.init(1, JcaJcePGPUtil.makeSymmetricKey(JcePGPDataEncryptorBuilder.this.encAlgorithm, bArr), new IvParameterSpec(new byte[cipherCreateStreamCipher.getBlockSize()]));
                }
            } catch (InvalidAlgorithmParameterException e2) {
                throw new PGPException("imvalid algorithm parameter: " + e2.getMessage(), e2);
            } catch (InvalidKeyException e3) {
                throw new PGPException("invalid key: " + e3.getMessage(), e3);
            }
        }

        @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptor
        public int getBlockSize() {
            return this.f1475c.getBlockSize();
        }

        @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptor
        public PGPDigestCalculator getIntegrityCalculator() {
            if (JcePGPDataEncryptorBuilder.this.withIntegrityPacket) {
                return new SHA1PGPDigestCalculator();
            }
            return null;
        }

        @Override // org.bouncycastle.openpgp.operator.PGPDataEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            return new CipherOutputStream(outputStream, this.f1475c);
        }
    }

    public JcePGPDataEncryptorBuilder(int i) {
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

    public JcePGPDataEncryptorBuilder setProvider(String str) {
        this.f1474helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcePGPDataEncryptorBuilder setProvider(Provider provider) {
        this.f1474helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcePGPDataEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.random = secureRandom;
        return this;
    }

    public JcePGPDataEncryptorBuilder setWithIntegrityPacket(boolean z) {
        this.withIntegrityPacket = z;
        return this;
    }
}
