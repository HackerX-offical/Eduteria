package org.bouncycastle.openpgp.operator;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.PublicKeyEncSessionPacket;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PublicKeyKeyEncryptionMethodGenerator extends PGPKeyEncryptionMethodGenerator {
    private PGPPublicKey pubKey;

    protected PublicKeyKeyEncryptionMethodGenerator(PGPPublicKey pGPPublicKey) {
        this.pubKey = pGPPublicKey;
        int algorithm = pGPPublicKey.getAlgorithm();
        if (algorithm == 1 || algorithm == 2) {
            return;
        }
        if (algorithm == 3) {
            throw new IllegalArgumentException("Can't use an RSA_SIGN key for encryption.");
        }
        switch (algorithm) {
            case 16:
            case 18:
            case 20:
                return;
            case 17:
                throw new IllegalArgumentException("Can't use DSA for encryption.");
            case 19:
                throw new IllegalArgumentException("Can't use ECDSA for encryption.");
            default:
                throw new IllegalArgumentException("unknown asymmetric algorithm: " + pGPPublicKey.getAlgorithm());
        }
    }

    private byte[] convertToEncodedMPI(byte[] bArr) throws PGPException {
        try {
            return new MPInteger(new BigInteger(1, bArr)).getEncoded();
        } catch (IOException e2) {
            throw new PGPException("Invalid MPI encoding: " + e2.getMessage(), e2);
        }
    }

    protected abstract byte[] encryptSessionInfo(PGPPublicKey pGPPublicKey, byte[] bArr) throws PGPException;

    @Override // org.bouncycastle.openpgp.operator.PGPKeyEncryptionMethodGenerator
    public ContainedPacket generate(int i, byte[] bArr) throws PGPException {
        return new PublicKeyEncSessionPacket(this.pubKey.getKeyID(), this.pubKey.getAlgorithm(), processSessionInfo(encryptSessionInfo(this.pubKey, bArr)));
    }

    public byte[][] processSessionInfo(byte[] bArr) throws PGPException {
        int algorithm = this.pubKey.getAlgorithm();
        if (algorithm == 1 || algorithm == 2) {
            return new byte[][]{convertToEncodedMPI(bArr)};
        }
        if (algorithm != 16) {
            if (algorithm == 18) {
                return new byte[][]{bArr};
            }
            if (algorithm != 20) {
                throw new PGPException("unknown asymmetric algorithm: " + this.pubKey.getAlgorithm());
            }
        }
        int length = bArr.length / 2;
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length / 2;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        System.arraycopy(bArr, length, bArr3, 0, length2);
        return new byte[][]{convertToEncodedMPI(bArr2), convertToEncodedMPI(bArr3)};
    }
}
