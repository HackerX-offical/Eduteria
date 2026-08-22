package org.bouncycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.SRP6GroupParameters;

/* JADX INFO: loaded from: classes10.dex */
public class SRP6Client {
    protected BigInteger A;
    protected BigInteger B;
    protected BigInteger Key;
    protected BigInteger M1;
    protected BigInteger M2;
    protected BigInteger N;
    protected BigInteger S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected BigInteger f1377a;
    protected Digest digest;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected BigInteger f1378g;
    protected SecureRandom random;
    protected BigInteger u;
    protected BigInteger x;

    private BigInteger calculateS() {
        BigInteger bigIntegerCalculateK = SRP6Util.calculateK(this.digest, this.N, this.f1378g);
        return this.B.subtract(this.f1378g.modPow(this.x, this.N).multiply(bigIntegerCalculateK).mod(this.N)).mod(this.N).modPow(this.u.multiply(this.x).add(this.f1377a), this.N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.A;
        if (bigInteger3 == null || (bigInteger = this.B) == null || (bigInteger2 = this.S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger bigIntegerCalculateM1 = SRP6Util.calculateM1(this.digest, this.N, bigInteger3, bigInteger, bigInteger2);
        this.M1 = bigIntegerCalculateM1;
        return bigIntegerCalculateM1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerValidatePublicValue = SRP6Util.validatePublicValue(this.N, bigInteger);
        this.B = bigIntegerValidatePublicValue;
        this.u = SRP6Util.calculateU(this.digest, this.N, this.A, bigIntegerValidatePublicValue);
        BigInteger bigIntegerCalculateS = calculateS();
        this.S = bigIntegerCalculateS;
        return bigIntegerCalculateS;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.S;
        if (bigInteger == null || this.M1 == null || this.M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger bigIntegerCalculateKey = SRP6Util.calculateKey(this.digest, this.N, bigInteger);
        this.Key = bigIntegerCalculateKey;
        return bigIntegerCalculateKey;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.x = SRP6Util.calculateX(this.digest, this.N, bArr, bArr2, bArr3);
        BigInteger bigIntegerSelectPrivateValue = selectPrivateValue();
        this.f1377a = bigIntegerSelectPrivateValue;
        BigInteger bigIntegerModPow = this.f1378g.modPow(bigIntegerSelectPrivateValue, this.N);
        this.A = bigIntegerModPow;
        return bigIntegerModPow;
    }

    public void init(BigInteger bigInteger, BigInteger bigInteger2, Digest digest, SecureRandom secureRandom) {
        this.N = bigInteger;
        this.f1378g = bigInteger2;
        this.digest = digest;
        this.random = secureRandom;
    }

    public void init(SRP6GroupParameters sRP6GroupParameters, Digest digest, SecureRandom secureRandom) {
        init(sRP6GroupParameters.getN(), sRP6GroupParameters.getG(), digest, secureRandom);
    }

    protected BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.digest, this.N, this.f1378g, this.random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.A;
        if (bigInteger4 == null || (bigInteger2 = this.M1) == null || (bigInteger3 = this.S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        }
        if (!SRP6Util.calculateM2(this.digest, this.N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        }
        this.M2 = bigInteger;
        return true;
    }
}
