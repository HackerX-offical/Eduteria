package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.minidns.dnsname.DnsName;
import org.minidns.record.Record;

/* JADX INFO: loaded from: classes10.dex */
public class MX extends Data {

    @Deprecated
    public final DnsName name;
    public final int priority;
    public final DnsName target;

    public static MX parse(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        return new MX(dataInputStream.readUnsignedShort(), DnsName.parse(dataInputStream, bArr));
    }

    public MX(int i, String str) {
        this(i, DnsName.from(str));
    }

    public MX(int i, DnsName dnsName) {
        this.priority = i;
        this.target = dnsName;
        this.name = dnsName;
    }

    @Override // org.minidns.record.Data
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeShort(this.priority);
        this.target.writeToStream(dataOutputStream);
    }

    public String toString() {
        return this.priority + " " + ((Object) this.target) + '.';
    }

    @Override // org.minidns.record.Data
    public Record.TYPE getType() {
        return Record.TYPE.MX;
    }
}
