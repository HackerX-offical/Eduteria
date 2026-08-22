package org.bouncycastle.openpgp.operator;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes10.dex */
public interface PGPDigestCalculator {
    int getAlgorithm();

    byte[] getDigest();

    OutputStream getOutputStream();

    void reset();
}
