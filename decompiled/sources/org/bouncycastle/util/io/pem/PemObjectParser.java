package org.bouncycastle.util.io.pem;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public interface PemObjectParser {
    Object parseObject(PemObject pemObject) throws IOException;
}
