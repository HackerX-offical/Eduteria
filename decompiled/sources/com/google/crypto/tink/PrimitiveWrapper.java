package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes7.dex */
public interface PrimitiveWrapper<B, P> {
    Class<B> getInputPrimitiveClass();

    Class<P> getPrimitiveClass();

    P wrap(PrimitiveSet<B> primitiveSet) throws GeneralSecurityException;
}
