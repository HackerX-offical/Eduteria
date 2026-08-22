package org.bouncycastle.openpgp.operator.jcajce;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.jivesoftware.smack.util.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
public class JcaKeyFingerprintCalculator implements KeyFingerPrintCalculator {

    /* JADX INFO: renamed from: helper, reason: collision with root package name */
    private final JcaJceHelper f1463helper;

    public JcaKeyFingerprintCalculator() {
        this(new DefaultJcaJceHelper());
    }

    private JcaKeyFingerprintCalculator(JcaJceHelper jcaJceHelper) {
        this.f1463helper = jcaJceHelper;
    }

    @Override // org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator
    public byte[] calculateFingerprint(PublicKeyPacket publicKeyPacket) throws PGPException {
        BCPGKey key = publicKeyPacket.getKey();
        if (publicKeyPacket.getVersion() <= 3) {
            RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
            try {
                MessageDigest messageDigestCreateMessageDigest = this.f1463helper.createMessageDigest(StringUtils.MD5);
                byte[] encoded = new MPInteger(rSAPublicBCPGKey.getModulus()).getEncoded();
                messageDigestCreateMessageDigest.update(encoded, 2, encoded.length - 2);
                byte[] encoded2 = new MPInteger(rSAPublicBCPGKey.getPublicExponent()).getEncoded();
                messageDigestCreateMessageDigest.update(encoded2, 2, encoded2.length - 2);
                return messageDigestCreateMessageDigest.digest();
            } catch (IOException e2) {
                throw new PGPException("can't encode key components: " + e2.getMessage(), e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new PGPException("can't find MD5", e3);
            } catch (NoSuchProviderException e4) {
                throw new PGPException("can't find MD5", e4);
            }
        }
        try {
            byte[] encodedContents = publicKeyPacket.getEncodedContents();
            MessageDigest messageDigestCreateMessageDigest2 = this.f1463helper.createMessageDigest("SHA1");
            messageDigestCreateMessageDigest2.update((byte) -103);
            messageDigestCreateMessageDigest2.update((byte) (encodedContents.length >> 8));
            messageDigestCreateMessageDigest2.update((byte) encodedContents.length);
            messageDigestCreateMessageDigest2.update(encodedContents);
            return messageDigestCreateMessageDigest2.digest();
        } catch (IOException e5) {
            throw new PGPException("can't encode key components: " + e5.getMessage(), e5);
        } catch (NoSuchAlgorithmException e6) {
            throw new PGPException("can't find SHA1", e6);
        } catch (NoSuchProviderException e7) {
            throw new PGPException("can't find SHA1", e7);
        }
    }

    public JcaKeyFingerprintCalculator setProvider(String str) {
        return new JcaKeyFingerprintCalculator(new NamedJcaJceHelper(str));
    }

    public JcaKeyFingerprintCalculator setProvider(Provider provider) {
        return new JcaKeyFingerprintCalculator(new ProviderJcaJceHelper(provider));
    }
}
