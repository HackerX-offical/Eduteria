package org.bouncycastle.bcpg;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class OutputStreamPacket {
    protected BCPGOutputStream out;

    public OutputStreamPacket(BCPGOutputStream bCPGOutputStream) {
        this.out = bCPGOutputStream;
    }

    public abstract void close() throws IOException;

    public abstract BCPGOutputStream open() throws IOException;
}
