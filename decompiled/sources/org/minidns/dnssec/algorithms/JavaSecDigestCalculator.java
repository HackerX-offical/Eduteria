package org.minidns.dnssec.algorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.minidns.dnssec.DigestCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class JavaSecDigestCalculator implements DigestCalculator {
    private MessageDigest md;

    public JavaSecDigestCalculator(String str) throws NoSuchAlgorithmException {
        this.md = MessageDigest.getInstance(str);
    }

    @Override // org.minidns.dnssec.DigestCalculator
    public byte[] digest(byte[] bArr) {
        return this.md.digest(bArr);
    }
}
