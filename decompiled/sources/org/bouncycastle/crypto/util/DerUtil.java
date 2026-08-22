package org.bouncycastle.crypto.util;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
class DerUtil {
    DerUtil() {
    }

    static ASN1OctetString getOctetString(byte[] bArr) {
        return bArr == null ? new DEROctetString(new byte[0]) : new DEROctetString(Arrays.clone(bArr));
    }

    static byte[] toByteArray(ASN1Primitive aSN1Primitive) {
        try {
            return aSN1Primitive.getEncoded();
        } catch (IOException e2) {
            throw new IllegalStateException("Cannot get encoding: " + e2.getMessage()) { // from class: org.bouncycastle.crypto.util.DerUtil.1
                @Override // java.lang.Throwable
                public Throwable getCause() {
                    return e2;
                }
            };
        }
    }
}
