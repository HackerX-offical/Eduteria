package org.bouncycastle.openpgp.operator;

import java.io.InputStream;

/* JADX INFO: loaded from: classes10.dex */
public interface PGPDataDecryptor {
    int getBlockSize();

    InputStream getInputStream(InputStream inputStream);

    PGPDigestCalculator getIntegrityCalculator();
}
