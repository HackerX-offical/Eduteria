package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class RSAPublicBCPGKey extends BCPGObject implements BCPGKey {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    MPInteger f1371e;
    MPInteger n;

    public RSAPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.n = new MPInteger(bigInteger);
        this.f1371e = new MPInteger(bigInteger2);
    }

    public RSAPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.n = new MPInteger(bCPGInputStream);
        this.f1371e = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.n);
        bCPGOutputStream.writeObject(this.f1371e);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject, org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        try {
            return super.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.bcpg.BCPGKey
    public String getFormat() {
        return "PGP";
    }

    public BigInteger getModulus() {
        return this.n.getValue();
    }

    public BigInteger getPublicExponent() {
        return this.f1371e.getValue();
    }
}
