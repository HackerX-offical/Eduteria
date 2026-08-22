package org.jivesoftware.smackx.ox.selection_strategy;

import java.util.Date;
import java.util.Map;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.selection.keyring.PublicKeyRingSelectionStrategy;
import org.pgpainless.key.selection.keyring.SecretKeyRingSelectionStrategy;

/* JADX INFO: loaded from: classes10.dex */
public class AnnouncedKeys {

    public static class PubKeyRingSelectionStrategy extends PublicKeyRingSelectionStrategy<Map<OpenPgpV4Fingerprint, Date>> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(Map<OpenPgpV4Fingerprint, Date> map, PGPPublicKeyRing pGPPublicKeyRing) {
            return map.keySet().contains(new OpenPgpV4Fingerprint(pGPPublicKeyRing));
        }
    }

    public static class SecKeyRingSelectionStrategy extends SecretKeyRingSelectionStrategy<Map<OpenPgpV4Fingerprint, Date>> {
        @Override // org.pgpainless.key.selection.keyring.KeyRingSelectionStrategy
        public boolean accept(Map<OpenPgpV4Fingerprint, Date> map, PGPSecretKeyRing pGPSecretKeyRing) {
            return map.keySet().contains(new OpenPgpV4Fingerprint(pGPSecretKeyRing));
        }
    }
}
