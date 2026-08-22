package org.minidns.record;

import java.io.DataInputStream;
import java.io.IOException;
import org.minidns.constants.DnssecConstants;
import org.minidns.record.DelegatingDnssecRR;
import org.minidns.record.Record;

/* JADX INFO: loaded from: classes10.dex */
public class DS extends DelegatingDnssecRR {
    public static DS parse(DataInputStream dataInputStream, int i) throws IOException {
        DelegatingDnssecRR.SharedData sharedData = DelegatingDnssecRR.parseSharedData(dataInputStream, i);
        return new DS(sharedData.keyTag, sharedData.algorithm, sharedData.digestType, sharedData.digest);
    }

    public DS(int i, byte b2, byte b3, byte[] bArr) {
        super(i, b2, b3, bArr);
    }

    public DS(int i, DnssecConstants.SignatureAlgorithm signatureAlgorithm, byte b2, byte[] bArr) {
        super(i, signatureAlgorithm, b2, bArr);
    }

    public DS(int i, DnssecConstants.SignatureAlgorithm signatureAlgorithm, DnssecConstants.DigestAlgorithm digestAlgorithm, byte[] bArr) {
        super(i, signatureAlgorithm, digestAlgorithm, bArr);
    }

    @Override // org.minidns.record.Data
    public Record.TYPE getType() {
        return Record.TYPE.DS;
    }
}
