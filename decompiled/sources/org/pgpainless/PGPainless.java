package org.pgpainless;

import java.io.IOException;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.decryption_verification.DecryptionBuilder;
import org.pgpainless.encryption_signing.EncryptionBuilder;
import org.pgpainless.key.generation.KeyRingBuilder;
import org.pgpainless.key.parsing.KeyRingReader;
import org.pgpainless.symmetric_encryption.SymmetricEncryptorDecryptor;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public class PGPainless {
    public static KeyRingBuilder generateKeyRing() {
        return new KeyRingBuilder();
    }

    public static KeyRingReader readKeyRing() {
        return new KeyRingReader();
    }

    public static EncryptionBuilder createEncryptor() {
        return new EncryptionBuilder();
    }

    public static DecryptionBuilder createDecryptor() {
        return new DecryptionBuilder();
    }

    public static byte[] encryptWithPassword(@Nonnull byte[] bArr, @Nonnull Passphrase passphrase, @Nonnull SymmetricKeyAlgorithm symmetricKeyAlgorithm) throws IOException, PGPException {
        return SymmetricEncryptorDecryptor.symmetricallyEncrypt(bArr, passphrase, symmetricKeyAlgorithm, CompressionAlgorithm.UNCOMPRESSED);
    }

    public static byte[] decryptWithPassword(@Nonnull byte[] bArr, @Nonnull Passphrase passphrase) throws IOException, PGPException {
        return SymmetricEncryptorDecryptor.symmetricallyDecrypt(bArr, passphrase);
    }
}
