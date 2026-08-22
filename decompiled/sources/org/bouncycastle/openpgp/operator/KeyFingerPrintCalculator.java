package org.bouncycastle.openpgp.operator;

import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.openpgp.PGPException;

/* JADX INFO: loaded from: classes10.dex */
public interface KeyFingerPrintCalculator {
    byte[] calculateFingerprint(PublicKeyPacket publicKeyPacket) throws PGPException;
}
