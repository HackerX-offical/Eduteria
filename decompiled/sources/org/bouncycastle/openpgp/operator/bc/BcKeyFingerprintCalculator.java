package org.bouncycastle.openpgp.operator.bc;

import java.io.IOException;
import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class BcKeyFingerprintCalculator implements KeyFingerPrintCalculator {
    @Override // org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator
    public byte[] calculateFingerprint(PublicKeyPacket publicKeyPacket) throws PGPException {
        Digest mD5Digest;
        BCPGKey key = publicKeyPacket.getKey();
        if (publicKeyPacket.getVersion() <= 3) {
            RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
            try {
                mD5Digest = new MD5Digest();
                byte[] encoded = new MPInteger(rSAPublicBCPGKey.getModulus()).getEncoded();
                mD5Digest.update(encoded, 2, encoded.length - 2);
                byte[] encoded2 = new MPInteger(rSAPublicBCPGKey.getPublicExponent()).getEncoded();
                mD5Digest.update(encoded2, 2, encoded2.length - 2);
            } catch (IOException e2) {
                throw new PGPException("can't encode key components: " + e2.getMessage(), e2);
            }
        } else {
            try {
                byte[] encodedContents = publicKeyPacket.getEncodedContents();
                SHA1Digest sHA1Digest = new SHA1Digest();
                sHA1Digest.update((byte) -103);
                sHA1Digest.update((byte) (encodedContents.length >> 8));
                sHA1Digest.update((byte) encodedContents.length);
                sHA1Digest.update(encodedContents, 0, encodedContents.length);
                mD5Digest = sHA1Digest;
            } catch (IOException e3) {
                throw new PGPException("can't encode key components: " + e3.getMessage(), e3);
            }
        }
        byte[] bArr = new byte[mD5Digest.getDigestSize()];
        mD5Digest.doFinal(bArr, 0);
        return bArr;
    }
}
