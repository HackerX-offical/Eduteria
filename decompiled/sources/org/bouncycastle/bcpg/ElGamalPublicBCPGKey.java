package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class ElGamalPublicBCPGKey extends BCPGObject implements BCPGKey {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    MPInteger f1370g;
    MPInteger p;
    MPInteger y;

    public ElGamalPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.p = new MPInteger(bigInteger);
        this.f1370g = new MPInteger(bigInteger2);
        this.y = new MPInteger(bigInteger3);
    }

    public ElGamalPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.p = new MPInteger(bCPGInputStream);
        this.f1370g = new MPInteger(bCPGInputStream);
        this.y = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.p);
        bCPGOutputStream.writeObject(this.f1370g);
        bCPGOutputStream.writeObject(this.y);
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

    public BigInteger getG() {
        return this.f1370g.getValue();
    }

    public BigInteger getP() {
        return this.p.getValue();
    }

    public BigInteger getY() {
        return this.y.getValue();
    }
}
