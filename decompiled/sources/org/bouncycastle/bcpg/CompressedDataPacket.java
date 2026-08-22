package org.bouncycastle.bcpg;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class CompressedDataPacket extends InputStreamPacket {
    int algorithm;

    CompressedDataPacket(BCPGInputStream bCPGInputStream) throws IOException {
        super(bCPGInputStream);
        this.algorithm = bCPGInputStream.read();
    }

    public int getAlgorithm() {
        return this.algorithm;
    }
}
