package org.bouncycastle.openpgp;

import androidx.core.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.BCPGObject;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.bcpg.DSASecretBCPGKey;
import org.bouncycastle.bcpg.ECSecretBCPGKey;
import org.bouncycastle.bcpg.EdSecretBCPGKey;
import org.bouncycastle.bcpg.ElGamalSecretBCPGKey;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSASecretBCPGKey;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.bcpg.SecretKeyPacket;
import org.bouncycastle.bcpg.SecretSubkeyPacket;
import org.bouncycastle.bcpg.UserAttributePacket;
import org.bouncycastle.bcpg.UserIDPacket;
import org.bouncycastle.gpg.SExprParser;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.PBEProtectionRemoverFactory;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class PGPSecretKey {
    PGPPublicKey pub;
    SecretKeyPacket secret;

    public PGPSecretKey(int i, PGPKeyPair pGPKeyPair, String str, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this(i, pGPKeyPair, str, null, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, pGPContentSignerBuilder, pBESecretKeyEncryptor);
    }

    public PGPSecretKey(int i, PGPKeyPair pGPKeyPair, String str, PGPDigestCalculator pGPDigestCalculator, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this(pGPKeyPair.getPrivateKey(), certifiedPublicKey(i, pGPKeyPair, str, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, pGPContentSignerBuilder), pGPDigestCalculator, true, pBESecretKeyEncryptor);
    }

    public PGPSecretKey(SecretKeyPacket secretKeyPacket, PGPPublicKey pGPPublicKey) {
        this.secret = secretKeyPacket;
        this.pub = pGPPublicKey;
    }

    PGPSecretKey(PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, PGPDigestCalculator pGPDigestCalculator, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this(pGPPrivateKey, pGPPublicKey, pGPDigestCalculator, false, pBESecretKeyEncryptor);
    }

    public PGPSecretKey(PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, PGPDigestCalculator pGPDigestCalculator, boolean z, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        this.pub = pGPPublicKey;
        this.secret = buildSecretKeyPacket(z, pGPPrivateKey, pGPPublicKey, pBESecretKeyEncryptor, pGPDigestCalculator);
    }

    private static SecretKeyPacket buildSecretKeyPacket(boolean z, PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, PBESecretKeyEncryptor pBESecretKeyEncryptor, PGPDigestCalculator pGPDigestCalculator) throws PGPException {
        int i;
        BCPGObject bCPGObject = (BCPGObject) pGPPrivateKey.getPrivateKeyDataPacket();
        if (bCPGObject == null) {
            return z ? new SecretKeyPacket(pGPPublicKey.publicPk, 0, null, null, new byte[0]) : new SecretSubkeyPacket(pGPPublicKey.publicPk, 0, null, null, new byte[0]);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
            bCPGOutputStream.writeObject(bCPGObject);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int algorithm = pBESecretKeyEncryptor != null ? pBESecretKeyEncryptor.getAlgorithm() : 0;
            if (algorithm == 0) {
                int i2 = algorithm;
                bCPGOutputStream.write(checksum(null, byteArray, byteArray.length));
                return z ? new SecretKeyPacket(pGPPublicKey.publicPk, i2, null, null, byteArrayOutputStream.toByteArray()) : new SecretSubkeyPacket(pGPPublicKey.publicPk, i2, null, null, byteArrayOutputStream.toByteArray());
            }
            bCPGOutputStream.write(checksum(pGPDigestCalculator, byteArray, byteArray.length));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            byte[] bArrEncryptKeyData = pBESecretKeyEncryptor.encryptKeyData(byteArray2, 0, byteArray2.length);
            byte[] cipherIV = pBESecretKeyEncryptor.getCipherIV();
            S2K s2k = pBESecretKeyEncryptor.getS2K();
            if (pGPDigestCalculator == null) {
                i = 255;
            } else {
                if (pGPDigestCalculator.getAlgorithm() != 2) {
                    throw new PGPException("only SHA1 supported for key checksum calculations.");
                }
                i = 254;
            }
            if (z) {
                return new SecretKeyPacket(pGPPublicKey.publicPk, algorithm, i, s2k, cipherIV, bArrEncryptKeyData);
            }
            return new SecretSubkeyPacket(pGPPublicKey.publicPk, algorithm, i, s2k, cipherIV, bArrEncryptKeyData);
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("Exception encrypting key", e3);
        }
    }

    private static PGPPublicKey certifiedPublicKey(int i, PGPKeyPair pGPKeyPair, String str, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, PGPContentSignerBuilder pGPContentSignerBuilder) throws PGPException {
        try {
            PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(pGPContentSignerBuilder);
            pGPSignatureGenerator.init(i, pGPKeyPair.getPrivateKey());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketVector);
            pGPSignatureGenerator.setUnhashedSubpackets(pGPSignatureSubpacketVector2);
            try {
                return PGPPublicKey.addCertification(pGPKeyPair.getPublicKey(), str, pGPSignatureGenerator.generateCertification(str, pGPKeyPair.getPublicKey()));
            } catch (Exception e2) {
                throw new PGPException("exception doing certification: " + e2, e2);
            }
        } catch (Exception e3) {
            throw new PGPException("creating signature generator: " + e3, e3);
        }
    }

    private static byte[] checksum(PGPDigestCalculator pGPDigestCalculator, byte[] bArr, int i) throws PGPException {
        if (pGPDigestCalculator != null) {
            OutputStream outputStream = pGPDigestCalculator.getOutputStream();
            try {
                outputStream.write(bArr, 0, i);
                outputStream.close();
                return pGPDigestCalculator.getDigest();
            } catch (Exception e2) {
                throw new PGPException("checksum digest calculation failed: " + e2.getMessage(), e2);
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 != i; i3++) {
            i2 += bArr[i3] & 255;
        }
        return new byte[]{(byte) (i2 >> 8), (byte) i2};
    }

    public static PGPSecretKey copyWithNewPassword(PGPSecretKey pGPSecretKey, PBESecretKeyDecryptor pBESecretKeyDecryptor, PBESecretKeyEncryptor pBESecretKeyEncryptor) throws PGPException {
        S2K s2k;
        byte[] bArr;
        byte[] bArr2;
        int algorithm;
        int i;
        int i2;
        int i3;
        byte[] bArrEncryptKeyData;
        if (pGPSecretKey.isPrivateKeyEmpty()) {
            throw new PGPException("no private key in this SecretKey - public key present only.");
        }
        byte[] bArrExtractKeyData = pGPSecretKey.extractKeyData(pBESecretKeyDecryptor);
        int s2KUsage = pGPSecretKey.secret.getS2KUsage();
        boolean z = true;
        if (pBESecretKeyEncryptor == null || pBESecretKeyEncryptor.getAlgorithm() == 0) {
            if (pGPSecretKey.secret.getS2KUsage() == 254) {
                int length = bArrExtractKeyData.length;
                byte[] bArr3 = new byte[length - 18];
                int i4 = length - 20;
                System.arraycopy(bArrExtractKeyData, 0, bArr3, 0, i4);
                byte[] bArrChecksum = checksum(null, bArr3, i4);
                bArr3[i4] = bArrChecksum[0];
                bArr3[length - 19] = bArrChecksum[1];
                bArr2 = bArr3;
                s2k = null;
                bArr = null;
            } else {
                s2k = null;
                bArr = null;
                bArr2 = bArrExtractKeyData;
            }
            algorithm = 0;
            i = 0;
        } else {
            byte b2 = 255;
            int i5 = s2KUsage == 0 ? 255 : s2KUsage;
            if (pGPSecretKey.secret.getPublicKeyPacket().getVersion() < 4) {
                byte[] key = pBESecretKeyEncryptor.getKey();
                byte[] bArr4 = new byte[bArrExtractKeyData.length];
                if (pBESecretKeyEncryptor.getHashAlgorithm() != 1) {
                    throw new PGPException("MD5 Digest Calculator required for version 3 key encryptor.");
                }
                byte[] cipherIV = null;
                int i6 = 0;
                int i7 = 0;
                while (i6 != 4) {
                    byte b3 = bArrExtractKeyData[i7];
                    int i8 = i7 + 1;
                    boolean z2 = z;
                    int i9 = ((((b3 & 255) << 8) | (bArrExtractKeyData[i8] & b2)) + 7) / 8;
                    bArr4[i7] = b3;
                    bArr4[i8] = bArrExtractKeyData[i8];
                    int i10 = i7 + 2;
                    if (i9 > bArrExtractKeyData.length - i10) {
                        throw new PGPException("out of range encLen found in rawKeyData");
                    }
                    if (i6 == 0) {
                        bArrEncryptKeyData = pBESecretKeyEncryptor.encryptKeyData(key, bArrExtractKeyData, i10, i9);
                        cipherIV = pBESecretKeyEncryptor.getCipherIV();
                        i2 = i9;
                        i3 = i10;
                    } else {
                        int length2 = cipherIV.length;
                        byte[] bArr5 = new byte[length2];
                        System.arraycopy(bArr4, i7 - cipherIV.length, bArr5, 0, length2);
                        i2 = i9;
                        i3 = i10;
                        bArrEncryptKeyData = pBESecretKeyEncryptor.encryptKeyData(key, bArr5, bArrExtractKeyData, i3, i2);
                    }
                    System.arraycopy(bArrEncryptKeyData, 0, bArr4, i3, bArrEncryptKeyData.length);
                    i7 += i2 + 2;
                    i6++;
                    z = z2;
                    b2 = 255;
                }
                bArr4[i7] = bArrExtractKeyData[i7];
                int i11 = i7 + 1;
                bArr4[i11] = bArrExtractKeyData[i11];
                S2K s2k2 = pBESecretKeyEncryptor.getS2K();
                algorithm = pBESecretKeyEncryptor.getAlgorithm();
                bArr2 = bArr4;
                bArr = cipherIV;
                s2k = s2k2;
            } else {
                byte[] bArrEncryptKeyData2 = pBESecretKeyEncryptor.encryptKeyData(bArrExtractKeyData, 0, bArrExtractKeyData.length);
                byte[] cipherIV2 = pBESecretKeyEncryptor.getCipherIV();
                s2k = pBESecretKeyEncryptor.getS2K();
                bArr = cipherIV2;
                bArr2 = bArrEncryptKeyData2;
                algorithm = pBESecretKeyEncryptor.getAlgorithm();
            }
            i = i5;
        }
        return new PGPSecretKey(pGPSecretKey.secret instanceof SecretSubkeyPacket ? new SecretSubkeyPacket(pGPSecretKey.secret.getPublicKeyPacket(), algorithm, i, s2k, bArr, bArr2) : new SecretKeyPacket(pGPSecretKey.secret.getPublicKeyPacket(), algorithm, i, s2k, bArr, bArr2), pGPSecretKey.pub);
    }

    private byte[] extractKeyData(PBESecretKeyDecryptor pBESecretKeyDecryptor) throws PGPException {
        PBESecretKeyDecryptor pBESecretKeyDecryptor2 = pBESecretKeyDecryptor;
        byte[] secretKeyData = this.secret.getSecretKeyData();
        if (this.secret.getEncAlgorithm() == 0) {
            return secretKeyData;
        }
        try {
            int i = 0;
            if (this.secret.getPublicKeyPacket().getVersion() == 4) {
                byte[] bArrRecoverKeyData = pBESecretKeyDecryptor2.recoverKeyData(this.secret.getEncAlgorithm(), pBESecretKeyDecryptor2.makeKeyFromPassPhrase(this.secret.getEncAlgorithm(), this.secret.getS2K()), this.secret.getIV(), secretKeyData, 0, secretKeyData.length);
                boolean z = this.secret.getS2KUsage() == 254;
                byte[] bArrChecksum = checksum(z ? pBESecretKeyDecryptor2.getChecksumCalculator(2) : null, bArrRecoverKeyData, z ? bArrRecoverKeyData.length - 20 : bArrRecoverKeyData.length - 2);
                while (i != bArrChecksum.length) {
                    if (bArrChecksum[i] != bArrRecoverKeyData[(bArrRecoverKeyData.length - bArrChecksum.length) + i]) {
                        throw new PGPException("checksum mismatch at " + i + " of " + bArrChecksum.length);
                    }
                    i++;
                }
                return bArrRecoverKeyData;
            }
            byte[] bArrMakeKeyFromPassPhrase = pBESecretKeyDecryptor2.makeKeyFromPassPhrase(this.secret.getEncAlgorithm(), this.secret.getS2K());
            int length = secretKeyData.length;
            byte[] bArr = new byte[length];
            int length2 = this.secret.getIV().length;
            byte[] bArr2 = new byte[length2];
            System.arraycopy(this.secret.getIV(), 0, bArr2, 0, length2);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 4; i2 != i4; i4 = 4) {
                byte b2 = secretKeyData[i3];
                int i5 = i3 + 1;
                int i6 = ((((b2 & 255) << 8) | (secretKeyData[i5] & 255)) + 7) / 8;
                bArr[i3] = b2;
                bArr[i5] = secretKeyData[i5];
                int i7 = i3 + 2;
                if (i6 > secretKeyData.length - i7) {
                    throw new PGPException("out of range encLen found in encData");
                }
                byte[] bArrRecoverKeyData2 = pBESecretKeyDecryptor2.recoverKeyData(this.secret.getEncAlgorithm(), bArrMakeKeyFromPassPhrase, bArr2, secretKeyData, i7, i6);
                System.arraycopy(bArrRecoverKeyData2, 0, bArr, i7, bArrRecoverKeyData2.length);
                i3 += i6 + 2;
                if (i2 != 3) {
                    System.arraycopy(secretKeyData, i3 - length2, bArr2, 0, length2);
                }
                i2++;
                pBESecretKeyDecryptor2 = pBESecretKeyDecryptor;
            }
            bArr[i3] = secretKeyData[i3];
            int i8 = i3 + 1;
            bArr[i8] = secretKeyData[i8];
            int i9 = (secretKeyData[i8] & 255) | ((secretKeyData[i3] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
            int i10 = 0;
            while (i < length - 2) {
                i10 += bArr[i] & 255;
                i++;
            }
            int i11 = 65535 & i10;
            if (i11 == i9) {
                return bArr;
            }
            throw new PGPException("checksum mismatch: passphrase wrong, expected " + Integer.toHexString(i9) + " found " + Integer.toHexString(i11));
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("Exception decrypting key", e3);
        }
    }

    public static PGPSecretKey parseSecretKeyFromSExpr(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory, PGPPublicKey pGPPublicKey) throws IOException, PGPException {
        return new SExprParser(null).parseSecretKey(inputStream, pBEProtectionRemoverFactory, pGPPublicKey);
    }

    public static PGPSecretKey parseSecretKeyFromSExpr(InputStream inputStream, PBEProtectionRemoverFactory pBEProtectionRemoverFactory, KeyFingerPrintCalculator keyFingerPrintCalculator) throws IOException, PGPException {
        return new SExprParser(null).parseSecretKey(inputStream, pBEProtectionRemoverFactory, keyFingerPrintCalculator);
    }

    public static PGPSecretKey replacePublicKey(PGPSecretKey pGPSecretKey, PGPPublicKey pGPPublicKey) {
        if (pGPPublicKey.getKeyID() == pGPSecretKey.getKeyID()) {
            return new PGPSecretKey(pGPSecretKey.secret, pGPPublicKey);
        }
        throw new IllegalArgumentException("keyIDs do not match");
    }

    public void encode(OutputStream outputStream) throws IOException {
        BCPGOutputStream bCPGOutputStream = outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream);
        bCPGOutputStream.writePacket(this.secret);
        if (this.pub.trustPk != null) {
            bCPGOutputStream.writePacket(this.pub.trustPk);
        }
        if (this.pub.subSigs != null) {
            for (int i = 0; i != this.pub.subSigs.size(); i++) {
                ((PGPSignature) this.pub.subSigs.get(i)).encode(bCPGOutputStream);
            }
            return;
        }
        for (int i2 = 0; i2 != this.pub.keySigs.size(); i2++) {
            ((PGPSignature) this.pub.keySigs.get(i2)).encode(bCPGOutputStream);
        }
        for (int i3 = 0; i3 != this.pub.ids.size(); i3++) {
            if (this.pub.ids.get(i3) instanceof UserIDPacket) {
                bCPGOutputStream.writePacket((UserIDPacket) this.pub.ids.get(i3));
            } else {
                bCPGOutputStream.writePacket(new UserAttributePacket(((PGPUserAttributeSubpacketVector) this.pub.ids.get(i3)).toSubpacketArray()));
            }
            if (this.pub.idTrusts.get(i3) != null) {
                bCPGOutputStream.writePacket((ContainedPacket) this.pub.idTrusts.get(i3));
            }
            ArrayList arrayList = (ArrayList) this.pub.idSigs.get(i3);
            for (int i4 = 0; i4 != arrayList.size(); i4++) {
                ((PGPSignature) arrayList.get(i4)).encode(bCPGOutputStream);
            }
        }
    }

    public PGPPrivateKey extractPrivateKey(PBESecretKeyDecryptor pBESecretKeyDecryptor) throws PGPException {
        if (isPrivateKeyEmpty()) {
            return null;
        }
        PublicKeyPacket publicKeyPacket = this.secret.getPublicKeyPacket();
        try {
            BCPGInputStream bCPGInputStream = new BCPGInputStream(new ByteArrayInputStream(extractKeyData(pBESecretKeyDecryptor)));
            int algorithm = publicKeyPacket.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                return new PGPPrivateKey(getKeyID(), publicKeyPacket, new RSASecretBCPGKey(bCPGInputStream));
            }
            if (algorithm == 22) {
                return new PGPPrivateKey(getKeyID(), publicKeyPacket, new EdSecretBCPGKey(bCPGInputStream));
            }
            switch (algorithm) {
                case 16:
                case 20:
                    return new PGPPrivateKey(getKeyID(), publicKeyPacket, new ElGamalSecretBCPGKey(bCPGInputStream));
                case 17:
                    return new PGPPrivateKey(getKeyID(), publicKeyPacket, new DSASecretBCPGKey(bCPGInputStream));
                case 18:
                case 19:
                    return new PGPPrivateKey(getKeyID(), publicKeyPacket, new ECSecretBCPGKey(bCPGInputStream));
                default:
                    throw new PGPException("unknown public key algorithm encountered");
            }
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("Exception constructing key", e3);
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int getKeyEncryptionAlgorithm() {
        return this.secret.getEncAlgorithm();
    }

    public long getKeyID() {
        return this.pub.getKeyID();
    }

    public PGPPublicKey getPublicKey() {
        return this.pub;
    }

    public S2K getS2K() {
        return this.secret.getS2K();
    }

    public int getS2KUsage() {
        return this.secret.getS2KUsage();
    }

    public Iterator<PGPUserAttributeSubpacketVector> getUserAttributes() {
        return this.pub.getUserAttributes();
    }

    public Iterator<String> getUserIDs() {
        return this.pub.getUserIDs();
    }

    public boolean isMasterKey() {
        return this.pub.isMasterKey();
    }

    public boolean isPrivateKeyEmpty() {
        byte[] secretKeyData = this.secret.getSecretKeyData();
        return secretKeyData == null || secretKeyData.length < 1;
    }

    public boolean isSigningKey() {
        int algorithm = this.pub.getAlgorithm();
        return algorithm == 1 || algorithm == 3 || algorithm == 17 || algorithm == 19 || algorithm == 20;
    }
}
