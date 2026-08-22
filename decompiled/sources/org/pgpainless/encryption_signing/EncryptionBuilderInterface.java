package org.pgpainless.encryption_signing;

import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.exception.SecretKeyNotFoundException;
import org.pgpainless.key.protection.SecretKeyRingProtector;
import org.pgpainless.key.protection.UnprotectedKeysProtector;
import org.pgpainless.key.selection.keyring.PublicKeyRingSelectionStrategy;
import org.pgpainless.key.selection.keyring.SecretKeyRingSelectionStrategy;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public interface EncryptionBuilderInterface {

    public interface Armor {
        EncryptionStream asciiArmor() throws IOException, PGPException;

        EncryptionStream noArmor() throws IOException, PGPException;
    }

    public interface DetachedSign extends SignWith {
        SignWith createDetachedSignature();

        Armor doNotSign();
    }

    public interface ToRecipients {
        DetachedSign doNotEncrypt();

        <O> WithAlgorithms toRecipients(@Nonnull PublicKeyRingSelectionStrategy<O> publicKeyRingSelectionStrategy, @Nonnull MultiMap<O, PGPPublicKeyRingCollection> multiMap);

        WithAlgorithms toRecipients(@Nonnull PGPPublicKey... pGPPublicKeyArr);

        WithAlgorithms toRecipients(@Nonnull PGPPublicKeyRing... pGPPublicKeyRingArr);

        WithAlgorithms toRecipients(@Nonnull PGPPublicKeyRingCollection... pGPPublicKeyRingCollectionArr);
    }

    public interface WithAlgorithms {
        WithAlgorithms andToSelf(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection);

        <O> WithAlgorithms andToSelf(@Nonnull PublicKeyRingSelectionStrategy<O> publicKeyRingSelectionStrategy, @Nonnull MultiMap<O, PGPPublicKeyRingCollection> multiMap);

        WithAlgorithms andToSelf(@Nonnull PGPPublicKey... pGPPublicKeyArr);

        WithAlgorithms andToSelf(@Nonnull PGPPublicKeyRing... pGPPublicKeyRingArr);

        DetachedSign usingAlgorithms(@Nonnull SymmetricKeyAlgorithm symmetricKeyAlgorithm, @Nonnull HashAlgorithm hashAlgorithm, @Nonnull CompressionAlgorithm compressionAlgorithm);

        DetachedSign usingSecureAlgorithms();
    }

    ToRecipients onOutputStream(@Nonnull OutputStream outputStream);

    public interface SignWith {
        Armor signWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKey... pGPSecretKeyArr);

        Armor signWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKeyRing... pGPSecretKeyRingArr);

        <O> Armor signWith(@Nonnull SecretKeyRingSelectionStrategy<O> secretKeyRingSelectionStrategy, @Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull MultiMap<O, PGPSecretKeyRingCollection> multiMap) throws SecretKeyNotFoundException;

        default Armor signWith(@Nonnull PGPSecretKey... pGPSecretKeyArr) {
            return signWith(new UnprotectedKeysProtector(), pGPSecretKeyArr);
        }
    }
}
