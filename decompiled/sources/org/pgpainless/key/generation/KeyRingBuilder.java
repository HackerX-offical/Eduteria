package org.pgpainless.key.generation;

import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPKeyPair;
import org.bouncycastle.openpgp.PGPKeyRingGenerator;
import org.bouncycastle.openpgp.PGPSignatureSubpacketVector;
import org.bouncycastle.openpgp.operator.PBESecretKeyEncryptor;
import org.bouncycastle.openpgp.operator.PGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPContentSignerBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPDigestCalculatorProviderBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyEncryptorBuilder;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.KeyFlag;
import org.pgpainless.key.collection.PGPKeyRing;
import org.pgpainless.key.generation.KeyRingBuilderInterface;
import org.pgpainless.key.generation.type.ECDH;
import org.pgpainless.key.generation.type.ECDSA;
import org.pgpainless.key.generation.type.KeyType;
import org.pgpainless.key.generation.type.RSA_GENERAL;
import org.pgpainless.key.generation.type.curve.EllipticCurve;
import org.pgpainless.key.generation.type.length.RsaLength;
import org.pgpainless.provider.ProviderFactory;
import org.pgpainless.util.Passphrase;

/* JADX INFO: loaded from: classes10.dex */
public class KeyRingBuilder implements KeyRingBuilderInterface {
    private final Charset UTF8 = Charset.forName("UTF-8");
    private List<KeySpec> keySpecs = new ArrayList();
    private Passphrase passphrase;
    private String userId;

    public PGPKeyRing simpleRsaKeyRing(@Nonnull String str, @Nonnull RsaLength rsaLength) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
        return simpleRsaKeyRing(str, rsaLength, null);
    }

    public PGPKeyRing simpleRsaKeyRing(@Nonnull String str, @Nonnull RsaLength rsaLength, String str2) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
        KeyRingBuilderInterface.WithPassphrase withPassphraseWithPrimaryUserId = withMasterKey(KeySpec.getBuilder(RSA_GENERAL.withLength(rsaLength)).withDefaultKeyFlags().withDefaultAlgorithms()).withPrimaryUserId(str);
        if (str2 == null) {
            return withPassphraseWithPrimaryUserId.withoutPassphrase().build();
        }
        return withPassphraseWithPrimaryUserId.withPassphrase(new Passphrase(str2.toCharArray())).build();
    }

    public PGPKeyRing simpleEcKeyRing(@Nonnull String str) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
        return simpleEcKeyRing(str, null);
    }

    public PGPKeyRing simpleEcKeyRing(@Nonnull String str, String str2) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
        KeyRingBuilderInterface.WithPassphrase withPassphraseWithPrimaryUserId = withSubKey(KeySpec.getBuilder(ECDH.fromCurve(EllipticCurve._P256)).withKeyFlags(KeyFlag.ENCRYPT_STORAGE, KeyFlag.ENCRYPT_COMMS).withDefaultAlgorithms()).withMasterKey(KeySpec.getBuilder(ECDSA.fromCurve(EllipticCurve._P256)).withKeyFlags(KeyFlag.AUTHENTICATION, KeyFlag.CERTIFY_OTHER, KeyFlag.SIGN_DATA).withDefaultAlgorithms()).withPrimaryUserId(str);
        if (str2 == null) {
            return withPassphraseWithPrimaryUserId.withoutPassphrase().build();
        }
        return withPassphraseWithPrimaryUserId.withPassphrase(new Passphrase(str2.toCharArray())).build();
    }

    @Override // org.pgpainless.key.generation.KeyRingBuilderInterface
    public KeyRingBuilderInterface withSubKey(@Nonnull KeySpec keySpec) {
        this.keySpecs.add(keySpec);
        return this;
    }

    @Override // org.pgpainless.key.generation.KeyRingBuilderInterface
    public KeyRingBuilderInterface.WithPrimaryUserId withMasterKey(@Nonnull KeySpec keySpec) {
        verifyMasterKeyCanCertify(keySpec);
        this.keySpecs.add(0, keySpec);
        return new WithPrimaryUserIdImpl();
    }

    private void verifyMasterKeyCanCertify(KeySpec keySpec) {
        if (!canCertifyOthers(keySpec)) {
            throw new IllegalArgumentException("Certification Key MUST have KeyFlag CERTIFY_OTHER");
        }
    }

    private boolean canCertifyOthers(KeySpec keySpec) {
        return KeyFlag.hasKeyFlag(keySpec.getSubpackets().getKeyFlags(), KeyFlag.CERTIFY_OTHER);
    }

    class WithPrimaryUserIdImpl implements KeyRingBuilderInterface.WithPrimaryUserId {
        WithPrimaryUserIdImpl() {
        }

        @Override // org.pgpainless.key.generation.KeyRingBuilderInterface.WithPrimaryUserId
        public KeyRingBuilderInterface.WithPassphrase withPrimaryUserId(@Nonnull String str) {
            KeyRingBuilder.this.userId = str;
            return KeyRingBuilder.this.new WithPassphraseImpl();
        }

        @Override // org.pgpainless.key.generation.KeyRingBuilderInterface.WithPrimaryUserId
        public KeyRingBuilderInterface.WithPassphrase withPrimaryUserId(@Nonnull byte[] bArr) {
            return withPrimaryUserId(new String(bArr, KeyRingBuilder.this.UTF8));
        }
    }

    class WithPassphraseImpl implements KeyRingBuilderInterface.WithPassphrase {
        WithPassphraseImpl() {
        }

        @Override // org.pgpainless.key.generation.KeyRingBuilderInterface.WithPassphrase
        public KeyRingBuilderInterface.Build withPassphrase(@Nonnull Passphrase passphrase) {
            KeyRingBuilder.this.passphrase = passphrase;
            return new BuildImpl();
        }

        @Override // org.pgpainless.key.generation.KeyRingBuilderInterface.WithPassphrase
        public KeyRingBuilderInterface.Build withoutPassphrase() {
            KeyRingBuilder.this.passphrase = null;
            return new BuildImpl();
        }

        class BuildImpl implements KeyRingBuilderInterface.Build {
            private PGPDigestCalculator digestCalculator;
            private PBESecretKeyEncryptor secretKeyEncryptor;

            BuildImpl() {
            }

            @Override // org.pgpainless.key.generation.KeyRingBuilderInterface.Build
            public PGPKeyRing build() throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
                this.digestCalculator = buildDigestCalculator();
                this.secretKeyEncryptor = buildSecretKeyEncryptor();
                KeySpec keySpec = (KeySpec) KeyRingBuilder.this.keySpecs.remove(0);
                PGPKeyPair pGPKeyPairGenerateKeyPair = generateKeyPair(keySpec);
                PGPKeyRingGenerator pGPKeyRingGeneratorBuildRingGenerator = buildRingGenerator(pGPKeyPairGenerateKeyPair, buildContentSigner(pGPKeyPairGenerateKeyPair), keySpec.getSubpackets());
                addSubKeys(pGPKeyRingGeneratorBuildRingGenerator);
                return new PGPKeyRing(pGPKeyRingGeneratorBuildRingGenerator.generatePublicKeyRing(), pGPKeyRingGeneratorBuildRingGenerator.generateSecretKeyRing());
            }

            private PGPKeyRingGenerator buildRingGenerator(PGPKeyPair pGPKeyPair, PGPContentSignerBuilder pGPContentSignerBuilder, PGPSignatureSubpacketVector pGPSignatureSubpacketVector) throws PGPException {
                return new PGPKeyRingGenerator(19, pGPKeyPair, KeyRingBuilder.this.userId, this.digestCalculator, pGPSignatureSubpacketVector, null, pGPContentSignerBuilder, this.secretKeyEncryptor);
            }

            private void addSubKeys(PGPKeyRingGenerator pGPKeyRingGenerator) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
                for (KeySpec keySpec : KeyRingBuilder.this.keySpecs) {
                    PGPKeyPair pGPKeyPairGenerateKeyPair = generateKeyPair(keySpec);
                    if (keySpec.isInheritedSubPackets()) {
                        pGPKeyRingGenerator.addSubKey(pGPKeyPairGenerateKeyPair);
                    } else {
                        pGPKeyRingGenerator.addSubKey(pGPKeyPairGenerateKeyPair, keySpec.getSubpackets(), null);
                    }
                }
            }

            private PGPContentSignerBuilder buildContentSigner(PGPKeyPair pGPKeyPair) {
                return new JcaPGPContentSignerBuilder(pGPKeyPair.getPublicKey().getAlgorithm(), HashAlgorithm.SHA512.getAlgorithmId()).setProvider(ProviderFactory.getProvider());
            }

            private PBESecretKeyEncryptor buildSecretKeyEncryptor() {
                PBESecretKeyEncryptor pBESecretKeyEncryptorBuild = KeyRingBuilder.this.passphrase == null ? null : new JcePBESecretKeyEncryptorBuilder(9, this.digestCalculator).setProvider(ProviderFactory.getProvider()).build(KeyRingBuilder.this.passphrase.getChars());
                if (KeyRingBuilder.this.passphrase != null) {
                    KeyRingBuilder.this.passphrase.clear();
                }
                return pBESecretKeyEncryptorBuild;
            }

            private PGPDigestCalculator buildDigestCalculator() throws PGPException {
                return new JcaPGPDigestCalculatorProviderBuilder().setProvider(ProviderFactory.getProvider()).build().get(HashAlgorithm.SHA1.getAlgorithmId());
            }

            private PGPKeyPair generateKeyPair(KeySpec keySpec) throws NoSuchAlgorithmException, PGPException, InvalidAlgorithmParameterException {
                KeyType keyType = keySpec.getKeyType();
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(keyType.getName(), ProviderFactory.getProvider());
                keyPairGenerator.initialize(keyType.getAlgorithmSpec());
                return new JcaPGPKeyPair(keyType.getAlgorithm().getAlgorithmId(), keyPairGenerator.generateKeyPair(), new Date());
            }
        }
    }
}
