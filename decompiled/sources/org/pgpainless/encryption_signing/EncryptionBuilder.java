package org.pgpainless.encryption_signing;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
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
import org.pgpainless.encryption_signing.EncryptionBuilderInterface;
import org.pgpainless.exception.SecretKeyNotFoundException;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.protection.SecretKeyRingProtector;
import org.pgpainless.key.selection.key.PublicKeySelectionStrategy;
import org.pgpainless.key.selection.key.SecretKeySelectionStrategy;
import org.pgpainless.key.selection.key.impl.EncryptionKeySelectionStrategy;
import org.pgpainless.key.selection.key.impl.NoRevocation;
import org.pgpainless.key.selection.key.impl.SignatureKeySelectionStrategy;
import org.pgpainless.key.selection.key.util.And;
import org.pgpainless.key.selection.keyring.PublicKeyRingSelectionStrategy;
import org.pgpainless.key.selection.keyring.SecretKeyRingSelectionStrategy;
import org.pgpainless.util.MultiMap;

/* JADX INFO: loaded from: classes10.dex */
public class EncryptionBuilder implements EncryptionBuilderInterface {
    private OutputStream outputStream;
    private SecretKeyRingProtector signingKeysDecryptor;
    private final Set<PGPPublicKey> encryptionKeys = new HashSet();
    private boolean detachedSignature = false;
    private final Set<PGPSecretKey> signingKeys = new HashSet();
    private SymmetricKeyAlgorithm symmetricKeyAlgorithm = SymmetricKeyAlgorithm.AES_128;
    private HashAlgorithm hashAlgorithm = HashAlgorithm.SHA256;
    private CompressionAlgorithm compressionAlgorithm = CompressionAlgorithm.UNCOMPRESSED;
    private boolean asciiArmor = false;

    @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface
    public EncryptionBuilderInterface.ToRecipients onOutputStream(@Nonnull OutputStream outputStream) {
        this.outputStream = outputStream;
        return new ToRecipientsImpl();
    }

    class ToRecipientsImpl implements EncryptionBuilderInterface.ToRecipients {
        ToRecipientsImpl() {
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.ToRecipients
        public EncryptionBuilderInterface.WithAlgorithms toRecipients(@Nonnull PGPPublicKey... pGPPublicKeyArr) {
            for (PGPPublicKey pGPPublicKey : pGPPublicKeyArr) {
                if (EncryptionBuilder.this.encryptionKeySelector().accept(null, pGPPublicKey)) {
                    EncryptionBuilder.this.encryptionKeys.add(pGPPublicKey);
                } else {
                    throw new IllegalArgumentException("Key " + pGPPublicKey.getKeyID() + " is not a valid encryption key.");
                }
            }
            if (EncryptionBuilder.this.encryptionKeys.isEmpty()) {
                throw new IllegalStateException("No valid encryption keys found!");
            }
            return EncryptionBuilder.this.new WithAlgorithmsImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.ToRecipients
        public EncryptionBuilderInterface.WithAlgorithms toRecipients(@Nonnull PGPPublicKeyRing... pGPPublicKeyRingArr) {
            for (PGPPublicKeyRing pGPPublicKeyRing : pGPPublicKeyRingArr) {
                for (PGPPublicKey pGPPublicKey : pGPPublicKeyRing) {
                    if (EncryptionBuilder.this.encryptionKeySelector().accept(null, pGPPublicKey)) {
                        EncryptionBuilder.this.encryptionKeys.add(pGPPublicKey);
                    }
                }
            }
            if (EncryptionBuilder.this.encryptionKeys.isEmpty()) {
                throw new IllegalStateException("No valid encryption keys found!");
            }
            return EncryptionBuilder.this.new WithAlgorithmsImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.ToRecipients
        public EncryptionBuilderInterface.WithAlgorithms toRecipients(@Nonnull PGPPublicKeyRingCollection... pGPPublicKeyRingCollectionArr) {
            for (PGPPublicKeyRingCollection pGPPublicKeyRingCollection : pGPPublicKeyRingCollectionArr) {
                Iterator<PGPPublicKeyRing> it = pGPPublicKeyRingCollection.iterator();
                while (it.hasNext()) {
                    for (PGPPublicKey pGPPublicKey : it.next()) {
                        if (EncryptionBuilder.this.encryptionKeySelector().accept(null, pGPPublicKey)) {
                            EncryptionBuilder.this.encryptionKeys.add(pGPPublicKey);
                        }
                    }
                }
            }
            if (EncryptionBuilder.this.encryptionKeys.isEmpty()) {
                throw new IllegalStateException("No valid encryption keys found!");
            }
            return EncryptionBuilder.this.new WithAlgorithmsImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.ToRecipients
        public <O> EncryptionBuilderInterface.WithAlgorithms toRecipients(@Nonnull PublicKeyRingSelectionStrategy<O> publicKeyRingSelectionStrategy, @Nonnull MultiMap<O, PGPPublicKeyRingCollection> multiMap) {
            if (multiMap.isEmpty()) {
                throw new IllegalArgumentException("Recipient map MUST NOT be empty.");
            }
            MultiMap<O, PGPPublicKeyRing> multiMapSelectKeyRingsFromCollections = publicKeyRingSelectionStrategy.selectKeyRingsFromCollections(multiMap);
            Iterator<O> it = multiMapSelectKeyRingsFromCollections.keySet().iterator();
            while (it.hasNext()) {
                Iterator<PGPPublicKeyRing> it2 = multiMapSelectKeyRingsFromCollections.get(it.next()).iterator();
                while (it2.hasNext()) {
                    for (PGPPublicKey pGPPublicKey : it2.next()) {
                        if (EncryptionBuilder.this.encryptionKeySelector().accept(null, pGPPublicKey)) {
                            EncryptionBuilder.this.encryptionKeys.add(pGPPublicKey);
                        }
                    }
                }
            }
            if (EncryptionBuilder.this.encryptionKeys.isEmpty()) {
                throw new IllegalStateException("No valid encryption keys found!");
            }
            return EncryptionBuilder.this.new WithAlgorithmsImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.ToRecipients
        public EncryptionBuilderInterface.DetachedSign doNotEncrypt() {
            return EncryptionBuilder.this.new DetachedSignImpl();
        }
    }

    class WithAlgorithmsImpl implements EncryptionBuilderInterface.WithAlgorithms {
        WithAlgorithmsImpl() {
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.WithAlgorithms
        public EncryptionBuilderInterface.WithAlgorithms andToSelf(@Nonnull PGPPublicKey... pGPPublicKeyArr) {
            if (pGPPublicKeyArr.length == 0) {
                throw new IllegalArgumentException("Recipient list MUST NOT be empty.");
            }
            for (PGPPublicKey pGPPublicKey : pGPPublicKeyArr) {
                if (EncryptionBuilder.this.encryptionKeySelector().accept(null, pGPPublicKey)) {
                    EncryptionBuilder.this.encryptionKeys.add(pGPPublicKey);
                } else {
                    throw new IllegalArgumentException("Key " + pGPPublicKey.getKeyID() + " is not a valid encryption key.");
                }
            }
            return this;
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.WithAlgorithms
        public EncryptionBuilderInterface.WithAlgorithms andToSelf(@Nonnull PGPPublicKeyRing... pGPPublicKeyRingArr) {
            if (pGPPublicKeyRingArr.length == 0) {
                throw new IllegalArgumentException("Recipient list MUST NOT be empty.");
            }
            for (PGPPublicKeyRing pGPPublicKeyRing : pGPPublicKeyRingArr) {
                Iterator<PGPPublicKey> publicKeys = pGPPublicKeyRing.getPublicKeys();
                while (publicKeys.hasNext()) {
                    PGPPublicKey next = publicKeys.next();
                    if (EncryptionBuilder.this.encryptionKeySelector().accept(null, next)) {
                        EncryptionBuilder.this.encryptionKeys.add(next);
                    }
                }
            }
            return this;
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.WithAlgorithms
        public EncryptionBuilderInterface.WithAlgorithms andToSelf(@Nonnull PGPPublicKeyRingCollection pGPPublicKeyRingCollection) {
            Iterator<PGPPublicKeyRing> it = pGPPublicKeyRingCollection.iterator();
            while (it.hasNext()) {
                Iterator<PGPPublicKey> publicKeys = it.next().getPublicKeys();
                while (publicKeys.hasNext()) {
                    PGPPublicKey next = publicKeys.next();
                    if (EncryptionBuilder.this.encryptionKeySelector().accept(null, next)) {
                        EncryptionBuilder.this.encryptionKeys.add(next);
                    }
                }
            }
            return this;
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.WithAlgorithms
        public <O> EncryptionBuilderInterface.WithAlgorithms andToSelf(@Nonnull PublicKeyRingSelectionStrategy<O> publicKeyRingSelectionStrategy, @Nonnull MultiMap<O, PGPPublicKeyRingCollection> multiMap) {
            if (multiMap.isEmpty()) {
                throw new IllegalArgumentException("Recipient list MUST NOT be empty.");
            }
            MultiMap<O, PGPPublicKeyRing> multiMapSelectKeyRingsFromCollections = publicKeyRingSelectionStrategy.selectKeyRingsFromCollections(multiMap);
            Iterator<O> it = multiMapSelectKeyRingsFromCollections.keySet().iterator();
            while (it.hasNext()) {
                Iterator<PGPPublicKeyRing> it2 = multiMapSelectKeyRingsFromCollections.get(it.next()).iterator();
                while (it2.hasNext()) {
                    Iterator<PGPPublicKey> publicKeys = it2.next().getPublicKeys();
                    while (publicKeys.hasNext()) {
                        PGPPublicKey next = publicKeys.next();
                        if (EncryptionBuilder.this.encryptionKeySelector().accept(null, next)) {
                            EncryptionBuilder.this.encryptionKeys.add(next);
                        }
                    }
                }
            }
            return this;
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.WithAlgorithms
        public EncryptionBuilderInterface.DetachedSign usingAlgorithms(@Nonnull SymmetricKeyAlgorithm symmetricKeyAlgorithm, @Nonnull HashAlgorithm hashAlgorithm, @Nonnull CompressionAlgorithm compressionAlgorithm) {
            EncryptionBuilder.this.symmetricKeyAlgorithm = symmetricKeyAlgorithm;
            EncryptionBuilder.this.hashAlgorithm = hashAlgorithm;
            EncryptionBuilder.this.compressionAlgorithm = compressionAlgorithm;
            return EncryptionBuilder.this.new DetachedSignImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.WithAlgorithms
        public EncryptionBuilderInterface.DetachedSign usingSecureAlgorithms() {
            EncryptionBuilder.this.symmetricKeyAlgorithm = SymmetricKeyAlgorithm.AES_256;
            EncryptionBuilder.this.hashAlgorithm = HashAlgorithm.SHA512;
            EncryptionBuilder.this.compressionAlgorithm = CompressionAlgorithm.UNCOMPRESSED;
            return EncryptionBuilder.this.new DetachedSignImpl();
        }
    }

    class DetachedSignImpl implements EncryptionBuilderInterface.DetachedSign {
        DetachedSignImpl() {
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.DetachedSign
        public EncryptionBuilderInterface.SignWith createDetachedSignature() {
            EncryptionBuilder.this.detachedSignature = true;
            return EncryptionBuilder.this.new SignWithImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.DetachedSign
        public EncryptionBuilderInterface.Armor doNotSign() {
            return EncryptionBuilder.this.new ArmorImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.SignWith
        public EncryptionBuilderInterface.Armor signWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKey... pGPSecretKeyArr) {
            return EncryptionBuilder.this.new SignWithImpl().signWith(secretKeyRingProtector, pGPSecretKeyArr);
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.SignWith
        public EncryptionBuilderInterface.Armor signWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKeyRing... pGPSecretKeyRingArr) {
            return EncryptionBuilder.this.new SignWithImpl().signWith(secretKeyRingProtector, pGPSecretKeyRingArr);
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.SignWith
        public <O> EncryptionBuilderInterface.Armor signWith(@Nonnull SecretKeyRingSelectionStrategy<O> secretKeyRingSelectionStrategy, @Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull MultiMap<O, PGPSecretKeyRingCollection> multiMap) throws SecretKeyNotFoundException {
            return EncryptionBuilder.this.new SignWithImpl().signWith(secretKeyRingSelectionStrategy, secretKeyRingProtector, multiMap);
        }
    }

    class SignWithImpl implements EncryptionBuilderInterface.SignWith {
        SignWithImpl() {
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.SignWith
        public EncryptionBuilderInterface.Armor signWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKey... pGPSecretKeyArr) {
            if (pGPSecretKeyArr.length == 0) {
                throw new IllegalArgumentException("Recipient list MUST NOT be empty.");
            }
            for (PGPSecretKey pGPSecretKey : pGPSecretKeyArr) {
                if (EncryptionBuilder.this.signingKeySelector().accept(null, pGPSecretKey)) {
                    EncryptionBuilder.this.signingKeys.add(pGPSecretKey);
                } else {
                    throw new IllegalArgumentException("Key " + pGPSecretKey.getKeyID() + " is not a valid signing key.");
                }
            }
            EncryptionBuilder.this.signingKeysDecryptor = secretKeyRingProtector;
            return EncryptionBuilder.this.new ArmorImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.SignWith
        public EncryptionBuilderInterface.Armor signWith(@Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull PGPSecretKeyRing... pGPSecretKeyRingArr) {
            if (pGPSecretKeyRingArr.length == 0) {
                throw new IllegalArgumentException("Recipient list MUST NOT be empty.");
            }
            for (PGPSecretKeyRing pGPSecretKeyRing : pGPSecretKeyRingArr) {
                Iterator<PGPSecretKey> secretKeys = pGPSecretKeyRing.getSecretKeys();
                while (secretKeys.hasNext()) {
                    PGPSecretKey next = secretKeys.next();
                    if (EncryptionBuilder.this.signingKeySelector().accept(null, next)) {
                        EncryptionBuilder.this.signingKeys.add(next);
                    }
                }
            }
            EncryptionBuilder.this.signingKeysDecryptor = secretKeyRingProtector;
            return EncryptionBuilder.this.new ArmorImpl();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.SignWith
        public <O> EncryptionBuilderInterface.Armor signWith(@Nonnull SecretKeyRingSelectionStrategy<O> secretKeyRingSelectionStrategy, @Nonnull SecretKeyRingProtector secretKeyRingProtector, @Nonnull MultiMap<O, PGPSecretKeyRingCollection> multiMap) {
            if (multiMap.isEmpty()) {
                throw new IllegalArgumentException("Recipient list MUST NOT be empty.");
            }
            MultiMap<O, PGPSecretKeyRing> multiMapSelectKeyRingsFromCollections = secretKeyRingSelectionStrategy.selectKeyRingsFromCollections(multiMap);
            Iterator<O> it = multiMapSelectKeyRingsFromCollections.keySet().iterator();
            while (it.hasNext()) {
                Iterator<PGPSecretKeyRing> it2 = multiMapSelectKeyRingsFromCollections.get(it.next()).iterator();
                while (it2.hasNext()) {
                    Iterator<PGPSecretKey> secretKeys = it2.next().getSecretKeys();
                    while (secretKeys.hasNext()) {
                        PGPSecretKey next = secretKeys.next();
                        if (EncryptionBuilder.this.signingKeySelector().accept(null, next)) {
                            EncryptionBuilder.this.signingKeys.add(next);
                        }
                    }
                }
            }
            return EncryptionBuilder.this.new ArmorImpl();
        }
    }

    class ArmorImpl implements EncryptionBuilderInterface.Armor {
        ArmorImpl() {
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.Armor
        public EncryptionStream asciiArmor() throws IOException, PGPException {
            EncryptionBuilder.this.asciiArmor = true;
            return build();
        }

        @Override // org.pgpainless.encryption_signing.EncryptionBuilderInterface.Armor
        public EncryptionStream noArmor() throws IOException, PGPException {
            EncryptionBuilder.this.asciiArmor = false;
            return build();
        }

        private EncryptionStream build() throws IOException, PGPException {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (PGPSecretKey pGPSecretKey : EncryptionBuilder.this.signingKeys) {
                concurrentHashMap.put(new OpenPgpV4Fingerprint(pGPSecretKey), pGPSecretKey.extractPrivateKey(EncryptionBuilder.this.signingKeysDecryptor.getDecryptor(Long.valueOf(pGPSecretKey.getKeyID()))));
            }
            return new EncryptionStream(EncryptionBuilder.this.outputStream, EncryptionBuilder.this.encryptionKeys, EncryptionBuilder.this.detachedSignature, concurrentHashMap, EncryptionBuilder.this.symmetricKeyAlgorithm, EncryptionBuilder.this.hashAlgorithm, EncryptionBuilder.this.compressionAlgorithm, EncryptionBuilder.this.asciiArmor);
        }
    }

    <O> PublicKeySelectionStrategy<O> encryptionKeySelector() {
        return new And.PubKeySelectionStrategy(new NoRevocation.PubKeySelectionStrategy(), new EncryptionKeySelectionStrategy());
    }

    <O> SecretKeySelectionStrategy<O> signingKeySelector() {
        return new And.SecKeySelectionStrategy(new NoRevocation.SecKeySelectionStrategy(), new SignatureKeySelectionStrategy());
    }
}
