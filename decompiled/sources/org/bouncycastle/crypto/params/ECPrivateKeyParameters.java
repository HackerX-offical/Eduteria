package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public class ECPrivateKeyParameters extends ECKeyParameters {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BigInteger f1407d;

    public ECPrivateKeyParameters(BigInteger bigInteger, ECDomainParameters eCDomainParameters) {
        super(true, eCDomainParameters);
        this.f1407d = eCDomainParameters.validatePrivateScalar(bigInteger);
    }

    public BigInteger getD() {
        return this.f1407d;
    }
}
