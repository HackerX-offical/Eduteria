package org.jivesoftware.smackx.ox;

import java.io.IOException;
import java.util.Collections;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.util.BCUtil;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpSelf extends OpenPgpContact {
    OpenPgpSelf(BareJid bareJid, OpenPgpStore openPgpStore) {
        super(bareJid, openPgpStore);
    }

    public boolean hasSecretKeyAvailable() throws IOException, PGPException {
        return getSecretKeys() != null;
    }

    public PGPSecretKeyRingCollection getSecretKeys() throws IOException, PGPException {
        return this.store.getSecretKeysOf(this.jid);
    }

    public PGPSecretKeyRing getSigningKeyRing() throws IOException, PGPException {
        PGPSecretKeyRingCollection secretKeys = getSecretKeys();
        PGPSecretKeyRing pGPSecretKeyRing = null;
        if (secretKeys == null) {
            return null;
        }
        for (PGPSecretKeyRing pGPSecretKeyRing2 : secretKeys) {
            if (pGPSecretKeyRing == null || pGPSecretKeyRing2.getPublicKey().getCreationTime().after(pGPSecretKeyRing.getPublicKey().getCreationTime())) {
                pGPSecretKeyRing = pGPSecretKeyRing2;
            }
        }
        return pGPSecretKeyRing;
    }

    public OpenPgpV4Fingerprint getSigningKeyFingerprint() throws IOException, PGPException {
        PGPSecretKeyRing signingKeyRing = getSigningKeyRing();
        if (signingKeyRing != null) {
            return new OpenPgpV4Fingerprint(signingKeyRing.getPublicKey());
        }
        return null;
    }

    @Override // org.jivesoftware.smackx.ox.OpenPgpContact
    public PGPPublicKeyRingCollection getAnnouncedPublicKeys() throws IOException, PGPException {
        PGPSecretKeyRing signingKeyRing = getSigningKeyRing();
        return new PGPPublicKeyRingCollection(Collections.singleton(BCUtil.removeUnassociatedKeysFromKeyRing(getAnyPublicKeys().getPublicKeyRing(signingKeyRing.getPublicKey().getKeyID()), signingKeyRing.getPublicKey())));
    }
}
