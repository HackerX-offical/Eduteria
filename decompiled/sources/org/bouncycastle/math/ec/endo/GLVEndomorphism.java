package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes10.dex */
public interface GLVEndomorphism extends ECEndomorphism {
    BigInteger[] decomposeScalar(BigInteger bigInteger);
}
