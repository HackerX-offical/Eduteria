package org.bouncycastle.openpgp.jcajce;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class JcaPGPSecretKeyRing extends PGPSecretKeyRing {
    private static KeyFingerPrintCalculator fingerPrintCalculator = new JcaKeyFingerprintCalculator();

    public JcaPGPSecretKeyRing(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, fingerPrintCalculator);
    }

    public JcaPGPSecretKeyRing(byte[] bArr) throws IOException, PGPException {
        super(bArr, fingerPrintCalculator);
    }
}
