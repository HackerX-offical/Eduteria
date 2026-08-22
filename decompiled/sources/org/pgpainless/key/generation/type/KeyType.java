package org.pgpainless.key.generation.type;

import java.security.spec.AlgorithmParameterSpec;
import org.pgpainless.algorithm.PublicKeyAlgorithm;

/* JADX INFO: loaded from: classes10.dex */
public interface KeyType {
    PublicKeyAlgorithm getAlgorithm();

    AlgorithmParameterSpec getAlgorithmSpec();

    String getName();
}
