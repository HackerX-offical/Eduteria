package org.pgpainless.key.selection.key.impl;

import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.PGPSignature;
import org.bouncycastle.openpgp.operator.bc.BcPGPContentVerifierBuilderProvider;
import org.pgpainless.key.selection.key.PublicKeySelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class SignedByMasterKey {
    private static final Logger LOGGER = Logger.getLogger(SignedByMasterKey.class.getName());

    public static class PubkeySelectionStrategy extends PublicKeySelectionStrategy<PGPPublicKey> {
        @Override // org.pgpainless.key.selection.key.KeySelectionStrategy
        public boolean accept(PGPPublicKey pGPPublicKey, @Nonnull PGPPublicKey pGPPublicKey2) {
            if (!Arrays.equals(pGPPublicKey.getFingerprint(), pGPPublicKey2.getFingerprint())) {
                Iterator<PGPSignature> signaturesForKeyID = pGPPublicKey2.getSignaturesForKeyID(pGPPublicKey.getKeyID());
                while (true) {
                    if (!signaturesForKeyID.hasNext()) {
                        break;
                    }
                    PGPSignature next = signaturesForKeyID.next();
                    if (next.getSignatureType() == 24) {
                        try {
                            next.init(new BcPGPContentVerifierBuilderProvider(), pGPPublicKey);
                            return next.verifyCertification(pGPPublicKey, pGPPublicKey2);
                        } catch (PGPException unused) {
                            SignedByMasterKey.LOGGER.log(Level.WARNING, "Could not verify subkey signature of key " + Long.toHexString(pGPPublicKey.getKeyID()) + " on key " + Long.toHexString(pGPPublicKey2.getKeyID()));
                            return false;
                        }
                    }
                }
            } else {
                return true;
            }
        }
    }
}
