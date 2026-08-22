package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes10.dex */
public interface ECPairTransform {
    void init(CipherParameters cipherParameters);

    ECPair transform(ECPair eCPair);
}
