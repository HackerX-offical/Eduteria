package org.bouncycastle.gpg.keybox.jcajce;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import org.bouncycastle.gpg.keybox.BlobVerifier;
import org.bouncycastle.gpg.keybox.KeyBox;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;

/* JADX INFO: loaded from: classes10.dex */
public class JcaKeyBox extends KeyBox {
    JcaKeyBox(InputStream inputStream, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) throws IOException {
        super(inputStream, keyFingerPrintCalculator, blobVerifier);
    }

    JcaKeyBox(byte[] bArr, KeyFingerPrintCalculator keyFingerPrintCalculator, BlobVerifier blobVerifier) throws NoSuchAlgorithmException, IOException, NoSuchProviderException {
        super(bArr, keyFingerPrintCalculator, blobVerifier);
    }
}
