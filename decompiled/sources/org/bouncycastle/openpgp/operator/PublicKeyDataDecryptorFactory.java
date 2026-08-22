package org.bouncycastle.openpgp.operator;

import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes10.dex */
public interface PublicKeyDataDecryptorFactory extends PGPDataDecryptorFactory {
    byte[] recoverSessionData(int i, byte[][] bArr) throws PGPException;
}
