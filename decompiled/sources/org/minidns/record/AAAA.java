package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet6Address;
import org.minidns.record.Record;
import org.minidns.util.InetAddressUtil;

/* JADX INFO: loaded from: classes10.dex */
public class AAAA extends InternetAddressRR<Inet6Address> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.minidns.record.Data
    public Record.TYPE getType() {
        return Record.TYPE.AAAA;
    }

    public AAAA(Inet6Address inet6Address) {
        super(inet6Address);
    }

    public AAAA(byte[] bArr) {
        super(bArr);
        if (bArr.length != 16) {
            throw new IllegalArgumentException("IPv6 address in AAAA record is always 16 byte");
        }
    }

    public AAAA(CharSequence charSequence) {
        this(InetAddressUtil.ipv6From(charSequence));
    }

    public static AAAA parse(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[16];
        dataInputStream.readFully(bArr);
        return new AAAA(bArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.ip.length; i += 2) {
            if (i != 0) {
                sb.append(':');
            }
            sb.append(Integer.toHexString(((this.ip[i] & 255) << 8) + (this.ip[i + 1] & 255)));
        }
        return sb.toString();
    }
}
