package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: loaded from: classes10.dex */
public class NS extends RRWithTarget {
    public static NS parse(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new NS(DnsName.parse(dataInputStream, bArr));
    }

    public NS(DnsName dnsName) {
        super(dnsName);
    }

    @Override // org.minidns.record.Data
    public Record.TYPE getType() {
        return Record.TYPE.NS;
    }
}
