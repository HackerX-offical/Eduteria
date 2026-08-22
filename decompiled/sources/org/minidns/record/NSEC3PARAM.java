package org.minidns.record;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.minidns.record.NSEC3;
import org.minidns.record.Record;

/* JADX INFO: loaded from: classes10.dex */
public class NSEC3PARAM extends Data {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final byte flags;
    public final NSEC3.HashAlgorithm hashAlgorithm;
    public final byte hashAlgorithmByte;
    public final int iterations;
    private final byte[] salt;

    public static NSEC3PARAM parse(DataInputStream dataInputStream) throws IOException {
        byte b2 = dataInputStream.readByte();
        byte b3 = dataInputStream.readByte();
        int unsignedShort = dataInputStream.readUnsignedShort();
        int unsignedByte = dataInputStream.readUnsignedByte();
        byte[] bArr = new byte[unsignedByte];
        if (dataInputStream.read(bArr) == unsignedByte || unsignedByte == 0) {
            return new NSEC3PARAM(b2, b3, unsignedShort, bArr);
        }
        throw new IOException();
    }

    private NSEC3PARAM(NSEC3.HashAlgorithm hashAlgorithm, byte b2, byte b3, int i, byte[] bArr) {
        this.hashAlgorithmByte = b2;
        this.hashAlgorithm = hashAlgorithm == null ? NSEC3.HashAlgorithm.forByte(b2) : hashAlgorithm;
        this.flags = b3;
        this.iterations = i;
        this.salt = bArr;
    }

    NSEC3PARAM(byte b2, byte b3, int i, byte[] bArr) {
        this(null, b2, b3, i, bArr);
    }

    @Override // org.minidns.record.Data
    public Record.TYPE getType() {
        return Record.TYPE.NSEC3PARAM;
    }

    @Override // org.minidns.record.Data
    public void serialize(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.hashAlgorithmByte);
        dataOutputStream.writeByte(this.flags);
        dataOutputStream.writeShort(this.iterations);
        dataOutputStream.writeByte(this.salt.length);
        dataOutputStream.write(this.salt);
    }

    public String toString() {
        return this.hashAlgorithm + ' ' + ((int) this.flags) + ' ' + this.iterations + ' ' + (this.salt.length == 0 ? "-" : new BigInteger(1, this.salt).toString(16).toUpperCase());
    }

    public int getSaltLength() {
        return this.salt.length;
    }
}
