package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes10.dex */
public interface PGPContentVerifierBuilderProvider {
    PGPContentVerifierBuilder get(int i, int i2) throws PGPException;
}
