package org.pgpainless.key;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpV4Fingerprint implements CharSequence, Comparable<OpenPgpV4Fingerprint> {
    public static final String SCHEME = "openpgp4fpr";
    private static final Charset utf8 = Charset.forName("UTF-8");
    private final String fingerprint;

    public OpenPgpV4Fingerprint(@Nonnull String str) {
        String upperCase = str.trim().toUpperCase();
        if (!isValid(upperCase)) {
            throw new IllegalArgumentException("Fingerprint " + str + " does not appear to be a valid OpenPGP v4 fingerprint.");
        }
        this.fingerprint = upperCase;
    }

    public OpenPgpV4Fingerprint(@Nonnull byte[] bArr) {
        this(new String(bArr, utf8));
    }

    public OpenPgpV4Fingerprint(@Nonnull PGPPublicKey pGPPublicKey) {
        this(Hex.encode(pGPPublicKey.getFingerprint()));
        if (pGPPublicKey.getVersion() != 4) {
            throw new IllegalArgumentException("Key is not a v4 OpenPgp key.");
        }
    }

    public OpenPgpV4Fingerprint(@Nonnull PGPSecretKey pGPSecretKey) {
        this(pGPSecretKey.getPublicKey());
    }

    public OpenPgpV4Fingerprint(@Nonnull PGPPublicKeyRing pGPPublicKeyRing) {
        this(pGPPublicKeyRing.getPublicKey());
    }

    public OpenPgpV4Fingerprint(@Nonnull PGPSecretKeyRing pGPSecretKeyRing) {
        this(pGPSecretKeyRing.getPublicKey());
    }

    private static boolean isValid(@Nonnull String str) {
        return str.matches("[0-9A-F]{40}");
    }

    public long getKeyId() {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(Hex.decode(toString().getBytes(utf8)));
        byteBufferWrap.position(12);
        return byteBufferWrap.getLong();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof CharSequence)) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return this.fingerprint.hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.fingerprint.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.fingerprint.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.fingerprint.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    @Nonnull
    public String toString() {
        return this.fingerprint;
    }

    public URI toUri() {
        try {
            return new URI(SCHEME, toString(), null);
        } catch (URISyntaxException e2) {
            throw new AssertionError(e2);
        }
    }

    public static OpenPgpV4Fingerprint fromUri(URI uri) {
        if (!SCHEME.equals(uri.getScheme())) {
            throw new IllegalArgumentException("URI scheme MUST equal 'openpgp4fpr'");
        }
        return new OpenPgpV4Fingerprint(uri.getSchemeSpecificPart());
    }

    @Override // java.lang.Comparable
    public int compareTo(@Nonnull OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        return this.fingerprint.compareTo(openPgpV4Fingerprint.fingerprint);
    }
}
