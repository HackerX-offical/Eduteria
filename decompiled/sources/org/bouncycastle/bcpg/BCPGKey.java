package org.bouncycastle.bcpg;

import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes10.dex */
public interface BCPGKey extends Encodable {
    @Override // org.bouncycastle.util.Encodable
    byte[] getEncoded();

    String getFormat();
}
