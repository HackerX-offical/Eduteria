package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes8.dex */
@Immutable
public final class RsaSsaPssSignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    private static final String RAW_RSA_ALGORITHM = "RSA/ECB/NOPADDING";
    private final Enums.HashType mgf1Hash;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final int saltLength;
    private final Enums.HashType sigHash;

    public RsaSsaPssSignJce(final RSAPrivateCrtKey priv, Enums.HashType sigHash, Enums.HashType mgf1Hash, int saltLength) throws GeneralSecurityException {
        if (!FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        Validators.validateSignatureHash(sigHash);
        Validators.validateRsaModulusSize(priv.getModulus().bitLength());
        Validators.validateRsaPublicExponent(priv.getPublicExponent());
        this.privateKey = priv;
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(priv.getModulus(), priv.getPublicExponent()));
        this.sigHash = sigHash;
        this.mgf1Hash = mgf1Hash;
        this.saltLength = saltLength;
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        return rsasp1(emsaPssEncode(data, this.publicKey.getModulus().bitLength() - 1));
    }

    private byte[] rsasp1(byte[] m) throws GeneralSecurityException {
        Cipher engineFactory = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        engineFactory.init(2, this.privateKey);
        byte[] bArrDoFinal = engineFactory.doFinal(m);
        Cipher engineFactory2 = EngineFactory.CIPHER.getInstance(RAW_RSA_ALGORITHM);
        engineFactory2.init(1, this.publicKey);
        if (new BigInteger(1, m).equals(new BigInteger(1, engineFactory2.doFinal(bArrDoFinal)))) {
            return bArrDoFinal;
        }
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    private byte[] emsaPssEncode(byte[] m, int emBits) throws GeneralSecurityException {
        Validators.validateSignatureHash(this.sigHash);
        MessageDigest engineFactory = EngineFactory.MESSAGE_DIGEST.getInstance(SubtleUtil.toDigestAlgo(this.sigHash));
        byte[] bArrDigest = engineFactory.digest(m);
        int digestLength = engineFactory.getDigestLength();
        int i = 1;
        int i2 = ((emBits - 1) / 8) + 1;
        int i3 = this.saltLength;
        if (i2 < digestLength + i3 + 2) {
            throw new GeneralSecurityException("encoding error");
        }
        byte[] bArrRandBytes = Random.randBytes(i3);
        int i4 = digestLength + 8;
        byte[] bArr = new byte[this.saltLength + i4];
        System.arraycopy(bArrDigest, 0, bArr, 8, digestLength);
        System.arraycopy(bArrRandBytes, 0, bArr, i4, bArrRandBytes.length);
        byte[] bArrDigest2 = engineFactory.digest(bArr);
        int i5 = (i2 - digestLength) - 1;
        byte[] bArr2 = new byte[i5];
        int i6 = this.saltLength;
        bArr2[((i2 - i6) - digestLength) - 2] = 1;
        System.arraycopy(bArrRandBytes, 0, bArr2, ((i2 - i6) - digestLength) - 1, bArrRandBytes.length);
        byte[] bArrMgf1 = SubtleUtil.mgf1(bArrDigest2, i5, this.mgf1Hash);
        byte[] bArr3 = new byte[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            bArr3[i7] = (byte) (bArr2[i7] ^ bArrMgf1[i7]);
        }
        int i8 = 0;
        while (true) {
            int i9 = i;
            if (i8 < (((long) i2) * 8) - ((long) emBits)) {
                int i10 = i8 / 8;
                bArr3[i10] = (byte) ((~(i9 << (7 - (i8 % 8)))) & bArr3[i10]);
                i8++;
                i = i9;
            } else {
                int i11 = digestLength + i5;
                byte[] bArr4 = new byte[i11 + 1];
                System.arraycopy(bArr3, 0, bArr4, 0, i5);
                System.arraycopy(bArrDigest2, 0, bArr4, i5, bArrDigest2.length);
                bArr4[i11] = PSSSigner.TRAILER_IMPLICIT;
                return bArr4;
            }
        }
    }
}
