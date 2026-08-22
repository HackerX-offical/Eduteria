package org.pgpainless.key.generation;

import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.pgpainless.algorithm.AlgorithmSuite;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.Feature;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.KeyFlag;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;
import org.pgpainless.key.generation.KeySpecBuilderInterface;
import org.pgpainless.key.generation.type.KeyType;

/* JADX INFO: loaded from: classes10.dex */
public class KeySpecBuilder implements KeySpecBuilderInterface {
    private PGPSignatureSubpacketGenerator hashedSubPackets = new PGPSignatureSubpacketGenerator();
    private KeyType type;

    KeySpecBuilder(@Nonnull KeyType keyType) {
        this.type = keyType;
    }

    @Override // org.pgpainless.key.generation.KeySpecBuilderInterface
    public KeySpecBuilderInterface.WithDetailedConfiguration withKeyFlags(@Nonnull KeyFlag... keyFlagArr) {
        this.hashedSubPackets.setKeyFlags(false, KeyFlag.toBitmask(keyFlagArr));
        return new WithDetailedConfigurationImpl();
    }

    @Override // org.pgpainless.key.generation.KeySpecBuilderInterface
    public KeySpecBuilderInterface.WithDetailedConfiguration withDefaultKeyFlags() {
        return withKeyFlags(KeyFlag.CERTIFY_OTHER, KeyFlag.SIGN_DATA, KeyFlag.ENCRYPT_COMMS, KeyFlag.ENCRYPT_STORAGE, KeyFlag.AUTHENTICATION);
    }

    @Override // org.pgpainless.key.generation.KeySpecBuilderInterface
    public KeySpec withInheritedSubPackets() {
        return new KeySpec(this.type, null, true);
    }

    class WithDetailedConfigurationImpl implements KeySpecBuilderInterface.WithDetailedConfiguration {
        WithDetailedConfigurationImpl() {
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithDetailedConfiguration
        @Deprecated
        public KeySpecBuilderInterface.WithPreferredSymmetricAlgorithms withDetailedConfiguration() {
            return KeySpecBuilder.this.new WithPreferredSymmetricAlgorithmsImpl();
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithDetailedConfiguration
        public KeySpec withDefaultAlgorithms() {
            AlgorithmSuite defaultAlgorithmSuite = AlgorithmSuite.getDefaultAlgorithmSuite();
            KeySpecBuilder.this.hashedSubPackets.setPreferredCompressionAlgorithms(false, defaultAlgorithmSuite.getCompressionAlgorithmIds());
            KeySpecBuilder.this.hashedSubPackets.setPreferredSymmetricAlgorithms(false, defaultAlgorithmSuite.getSymmetricKeyAlgorithmIds());
            KeySpecBuilder.this.hashedSubPackets.setPreferredHashAlgorithms(false, defaultAlgorithmSuite.getHashAlgorithmIds());
            KeySpecBuilder.this.hashedSubPackets.setFeature(false, (byte) 1);
            return new KeySpec(KeySpecBuilder.this.type, KeySpecBuilder.this.hashedSubPackets, false);
        }
    }

    class WithPreferredSymmetricAlgorithmsImpl implements KeySpecBuilderInterface.WithPreferredSymmetricAlgorithms {
        WithPreferredSymmetricAlgorithmsImpl() {
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithPreferredSymmetricAlgorithms
        public KeySpecBuilderInterface.WithPreferredHashAlgorithms withPreferredSymmetricAlgorithms(@Nonnull SymmetricKeyAlgorithm... symmetricKeyAlgorithmArr) {
            int length = symmetricKeyAlgorithmArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = symmetricKeyAlgorithmArr[i].getAlgorithmId();
            }
            KeySpecBuilder.this.hashedSubPackets.setPreferredSymmetricAlgorithms(false, iArr);
            return KeySpecBuilder.this.new WithPreferredHashAlgorithmsImpl();
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithPreferredSymmetricAlgorithms
        public KeySpecBuilderInterface.WithPreferredHashAlgorithms withDefaultSymmetricAlgorithms() {
            KeySpecBuilder.this.hashedSubPackets.setPreferredSymmetricAlgorithms(false, AlgorithmSuite.getDefaultAlgorithmSuite().getSymmetricKeyAlgorithmIds());
            return KeySpecBuilder.this.new WithPreferredHashAlgorithmsImpl();
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithPreferredSymmetricAlgorithms
        public KeySpecBuilderInterface.WithFeatures withDefaultAlgorithms() {
            KeySpecBuilder.this.hashedSubPackets.setPreferredSymmetricAlgorithms(false, AlgorithmSuite.getDefaultAlgorithmSuite().getSymmetricKeyAlgorithmIds());
            KeySpecBuilder.this.hashedSubPackets.setPreferredCompressionAlgorithms(false, AlgorithmSuite.getDefaultAlgorithmSuite().getCompressionAlgorithmIds());
            KeySpecBuilder.this.hashedSubPackets.setPreferredHashAlgorithms(false, AlgorithmSuite.getDefaultAlgorithmSuite().getHashAlgorithmIds());
            return KeySpecBuilder.this.new WithFeaturesImpl();
        }
    }

    class WithPreferredHashAlgorithmsImpl implements KeySpecBuilderInterface.WithPreferredHashAlgorithms {
        WithPreferredHashAlgorithmsImpl() {
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithPreferredHashAlgorithms
        public KeySpecBuilderInterface.WithPreferredCompressionAlgorithms withPreferredHashAlgorithms(@Nonnull HashAlgorithm... hashAlgorithmArr) {
            int length = hashAlgorithmArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = hashAlgorithmArr[i].getAlgorithmId();
            }
            KeySpecBuilder.this.hashedSubPackets.setPreferredHashAlgorithms(false, iArr);
            return KeySpecBuilder.this.new WithPreferredCompressionAlgorithmsImpl();
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithPreferredHashAlgorithms
        public KeySpecBuilderInterface.WithPreferredCompressionAlgorithms withDefaultHashAlgorithms() {
            KeySpecBuilder.this.hashedSubPackets.setPreferredHashAlgorithms(false, AlgorithmSuite.getDefaultAlgorithmSuite().getHashAlgorithmIds());
            return KeySpecBuilder.this.new WithPreferredCompressionAlgorithmsImpl();
        }
    }

    class WithPreferredCompressionAlgorithmsImpl implements KeySpecBuilderInterface.WithPreferredCompressionAlgorithms {
        WithPreferredCompressionAlgorithmsImpl() {
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithPreferredCompressionAlgorithms
        public KeySpecBuilderInterface.WithFeatures withPreferredCompressionAlgorithms(@Nonnull CompressionAlgorithm... compressionAlgorithmArr) {
            int length = compressionAlgorithmArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = compressionAlgorithmArr[i].getAlgorithmId();
            }
            KeySpecBuilder.this.hashedSubPackets.setPreferredCompressionAlgorithms(false, iArr);
            return KeySpecBuilder.this.new WithFeaturesImpl();
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithPreferredCompressionAlgorithms
        public KeySpecBuilderInterface.WithFeatures withDefaultCompressionAlgorithms() {
            KeySpecBuilder.this.hashedSubPackets.setPreferredCompressionAlgorithms(false, AlgorithmSuite.getDefaultAlgorithmSuite().getCompressionAlgorithmIds());
            return KeySpecBuilder.this.new WithFeaturesImpl();
        }
    }

    class WithFeaturesImpl implements KeySpecBuilderInterface.WithFeatures {
        WithFeaturesImpl() {
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithFeatures
        public KeySpecBuilderInterface.WithFeatures withFeature(@Nonnull Feature feature) {
            KeySpecBuilder.this.hashedSubPackets.setFeature(false, feature.getFeatureId());
            return this;
        }

        @Override // org.pgpainless.key.generation.KeySpecBuilderInterface.WithFeatures
        public KeySpec done() {
            return new KeySpec(KeySpecBuilder.this.type, KeySpecBuilder.this.hashedSubPackets, false);
        }
    }
}
