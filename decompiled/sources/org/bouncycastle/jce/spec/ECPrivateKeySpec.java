package org.bouncycastle.jce.spec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class ECPrivateKeySpec extends ECKeySpec {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BigInteger f1455d;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f1455d = bigInteger;
    }

    public BigInteger getD() {
        return this.f1455d;
    }
}
