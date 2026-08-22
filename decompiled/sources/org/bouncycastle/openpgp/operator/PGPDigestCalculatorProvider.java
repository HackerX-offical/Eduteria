package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes10.dex */
public interface PGPDigestCalculatorProvider {
    PGPDigestCalculator get(int i) throws PGPException;
}
