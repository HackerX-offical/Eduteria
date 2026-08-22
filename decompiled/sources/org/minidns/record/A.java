package org.minidns.record;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import org.minidns.record.Record;
import org.minidns.util.InetAddressUtil;

/* JADX INFO: loaded from: classes10.dex */
public class A extends InternetAddressRR<Inet4Address> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Override // org.minidns.record.Data
    public Record.TYPE getType() {
        return Record.TYPE.A;
    }

    public A(Inet4Address inet4Address) {
        super(inet4Address);
    }

    public A(int i, int i2, int i3, int i4) {
        super(new byte[]{(byte) i, (byte) i2, (byte) i3, (byte) i4});
        if (i < 0 || i > 255 || i2 < 0 || i2 > 255 || i3 < 0 || i3 > 255 || i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException();
        }
    }

    public A(byte[] bArr) {
        super(bArr);
        if (bArr.length != 4) {
            throw new IllegalArgumentException("IPv4 address in A record is always 4 byte");
        }
    }

    public A(CharSequence charSequence) {
        this(InetAddressUtil.ipv4From(charSequence));
    }

    public static A parse(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[4];
        dataInputStream.readFully(bArr);
        return new A(bArr);
    }

    public String toString() {
        return Integer.toString(this.ip[0] & 255) + InstructionFileId.DOT + Integer.toString(this.ip[1] & 255) + InstructionFileId.DOT + Integer.toString(this.ip[2] & 255) + InstructionFileId.DOT + Integer.toString(this.ip[3] & 255);
    }
}
