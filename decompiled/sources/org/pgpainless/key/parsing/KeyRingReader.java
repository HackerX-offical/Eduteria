package org.pgpainless.key.parsing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.pgpainless.key.collection.PGPKeyRing;

/* JADX INFO: loaded from: classes10.dex */
public class KeyRingReader {
    public static final Charset UTF8 = Charset.forName("UTF-8");

    @Nonnull
    public PGPPublicKeyRing publicKeyRing(@Nonnull InputStream inputStream) throws IOException {
        return readPublicKeyRing(inputStream);
    }

    public PGPPublicKeyRing publicKeyRing(@Nonnull byte[] bArr) throws IOException {
        return publicKeyRing(new ByteArrayInputStream(bArr));
    }

    public PGPPublicKeyRing publicKeyRing(@Nonnull String str) throws IOException {
        return publicKeyRing(str.getBytes(UTF8));
    }

    public PGPPublicKeyRingCollection publicKeyRingCollection(@Nonnull InputStream inputStream) throws IOException, PGPException {
        return readPublicKeyRingCollection(inputStream);
    }

    public PGPPublicKeyRingCollection publicKeyRingCollection(@Nonnull byte[] bArr) throws IOException, PGPException {
        return publicKeyRingCollection(new ByteArrayInputStream(bArr));
    }

    public PGPPublicKeyRingCollection publicKeyRingCollection(@Nonnull String str) throws IOException, PGPException {
        return publicKeyRingCollection(str.getBytes(UTF8));
    }

    public PGPSecretKeyRing secretKeyRing(@Nonnull InputStream inputStream) throws IOException, PGPException {
        return readSecretKeyRing(inputStream);
    }

    public PGPSecretKeyRing secretKeyRing(@Nonnull byte[] bArr) throws IOException, PGPException {
        return secretKeyRing(new ByteArrayInputStream(bArr));
    }

    public PGPSecretKeyRing secretKeyRing(@Nonnull String str) throws IOException, PGPException {
        return secretKeyRing(str.getBytes(UTF8));
    }

    public PGPSecretKeyRingCollection secretKeyRingCollection(@Nonnull InputStream inputStream) throws IOException, PGPException {
        return readSecretKeyRingCollection(inputStream);
    }

    public PGPSecretKeyRingCollection secretKeyRingCollection(@Nonnull byte[] bArr) throws IOException, PGPException {
        return secretKeyRingCollection(new ByteArrayInputStream(bArr));
    }

    public PGPSecretKeyRingCollection secretKeyRingCollection(@Nonnull String str) throws IOException, PGPException {
        return secretKeyRingCollection(str.getBytes(UTF8));
    }

    public PGPKeyRing keyRing(@Nullable InputStream inputStream, @Nullable InputStream inputStream2) throws IOException, PGPException {
        return readKeyRing(inputStream, inputStream2);
    }

    public PGPKeyRing keyRing(@Nullable byte[] bArr, @Nullable byte[] bArr2) throws IOException, PGPException {
        return keyRing(bArr != null ? new ByteArrayInputStream(bArr) : null, bArr2 != null ? new ByteArrayInputStream(bArr2) : null);
    }

    public PGPKeyRing keyRing(@Nullable String str, @Nullable String str2) throws IOException, PGPException {
        return keyRing(str != null ? str.getBytes(UTF8) : null, str2 != null ? str2.getBytes(UTF8) : null);
    }

    public static PGPPublicKeyRing readPublicKeyRing(@Nonnull InputStream inputStream) throws IOException {
        return new PGPPublicKeyRing(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator());
    }

    public static PGPPublicKeyRingCollection readPublicKeyRingCollection(@Nonnull InputStream inputStream) throws IOException, PGPException {
        return new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator());
    }

    public static PGPSecretKeyRing readSecretKeyRing(@Nonnull InputStream inputStream) throws IOException, PGPException {
        return new PGPSecretKeyRing(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator());
    }

    public static PGPSecretKeyRingCollection readSecretKeyRingCollection(@Nonnull InputStream inputStream) throws IOException, PGPException {
        return new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStream), new BcKeyFingerprintCalculator());
    }

    public static PGPKeyRing readKeyRing(@Nullable InputStream inputStream, @Nullable InputStream inputStream2) throws IOException, PGPException {
        validateStreamsNotBothNull(inputStream, inputStream2);
        return asPGPKeyRing(maybeReadPublicKeys(inputStream), maybeReadSecretKeys(inputStream2));
    }

    private static void validateStreamsNotBothNull(InputStream inputStream, InputStream inputStream2) {
        if (inputStream == null && inputStream2 == null) {
            throw new NullPointerException("publicIn and secretIn cannot be BOTH null.");
        }
    }

    private static PGPPublicKeyRing maybeReadPublicKeys(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            return readPublicKeyRing(inputStream);
        }
        return null;
    }

    private static PGPSecretKeyRing maybeReadSecretKeys(InputStream inputStream) throws IOException, PGPException {
        if (inputStream != null) {
            return readSecretKeyRing(inputStream);
        }
        return null;
    }

    private static PGPKeyRing asPGPKeyRing(PGPPublicKeyRing pGPPublicKeyRing, PGPSecretKeyRing pGPSecretKeyRing) {
        if (pGPSecretKeyRing == null) {
            return new PGPKeyRing(pGPPublicKeyRing);
        }
        if (pGPPublicKeyRing == null) {
            return new PGPKeyRing(pGPSecretKeyRing);
        }
        return new PGPKeyRing(pGPPublicKeyRing, pGPSecretKeyRing);
    }
}
