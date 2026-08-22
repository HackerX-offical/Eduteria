package org.pgpainless.key.generation;

import javax.annotation.Nonnull;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.algorithm.Feature;
import org.pgpainless.algorithm.HashAlgorithm;
import org.pgpainless.algorithm.KeyFlag;
import org.pgpainless.algorithm.SymmetricKeyAlgorithm;

/* JADX INFO: loaded from: classes10.dex */
public interface KeySpecBuilderInterface {

    public interface WithDetailedConfiguration {
        KeySpec withDefaultAlgorithms();

        WithPreferredSymmetricAlgorithms withDetailedConfiguration();
    }

    public interface WithFeatures {
        KeySpec done();

        WithFeatures withFeature(@Nonnull Feature feature);
    }

    public interface WithPreferredCompressionAlgorithms {
        WithFeatures withDefaultCompressionAlgorithms();

        WithFeatures withPreferredCompressionAlgorithms(@Nonnull CompressionAlgorithm... compressionAlgorithmArr);
    }

    public interface WithPreferredHashAlgorithms {
        WithPreferredCompressionAlgorithms withDefaultHashAlgorithms();

        WithPreferredCompressionAlgorithms withPreferredHashAlgorithms(@Nonnull HashAlgorithm... hashAlgorithmArr);
    }

    public interface WithPreferredSymmetricAlgorithms {
        WithFeatures withDefaultAlgorithms();

        WithPreferredHashAlgorithms withDefaultSymmetricAlgorithms();

        WithPreferredHashAlgorithms withPreferredSymmetricAlgorithms(@Nonnull SymmetricKeyAlgorithm... symmetricKeyAlgorithmArr);
    }

    WithDetailedConfiguration withDefaultKeyFlags();

    KeySpec withInheritedSubPackets();

    WithDetailedConfiguration withKeyFlags(@Nonnull KeyFlag... keyFlagArr);
}
