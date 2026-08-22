package org.pgpainless.key.generation.type.curve;

import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes10.dex */
public enum EllipticCurve {
    _P256("P-256");

    private final String name;

    EllipticCurve(@Nonnull String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
