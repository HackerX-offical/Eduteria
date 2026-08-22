package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes10.dex */
public interface PBEProtectionRemoverFactory {
    PBESecretKeyDecryptor createDecryptor(String str) throws PGPException;
}
