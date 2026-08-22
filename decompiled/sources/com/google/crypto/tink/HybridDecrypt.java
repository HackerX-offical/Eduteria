package com.google.crypto.tink;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes7.dex */
public interface HybridDecrypt {
    byte[] decrypt(final byte[] ciphertext, final byte[] contextInfo) throws GeneralSecurityException;
}
