package org.pgpainless.key.generation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.bouncycastle.openpgp.PGPSignatureSubpacketGenerator;
import org.bouncycastle.openpgp.PGPSignatureSubpacketVector;
import org.pgpainless.key.generation.type.KeyType;

/* JADX INFO: loaded from: classes10.dex */
public class KeySpec {
    private final boolean inheritedSubPackets;
    private final KeyType keyType;
    private final PGPSignatureSubpacketGenerator subpacketGenerator;

    KeySpec(@Nonnull KeyType keyType, @Nullable PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator, boolean z) {
        this.keyType = keyType;
        this.subpacketGenerator = pGPSignatureSubpacketGenerator;
        this.inheritedSubPackets = z;
    }

    @Nonnull
    KeyType getKeyType() {
        return this.keyType;
    }

    @Nullable
    PGPSignatureSubpacketVector getSubpackets() {
        PGPSignatureSubpacketGenerator pGPSignatureSubpacketGenerator = this.subpacketGenerator;
        if (pGPSignatureSubpacketGenerator != null) {
            return pGPSignatureSubpacketGenerator.generate();
        }
        return null;
    }

    boolean isInheritedSubPackets() {
        return this.inheritedSubPackets;
    }

    public static KeySpecBuilder getBuilder(KeyType keyType) {
        return new KeySpecBuilder(keyType);
    }
}
