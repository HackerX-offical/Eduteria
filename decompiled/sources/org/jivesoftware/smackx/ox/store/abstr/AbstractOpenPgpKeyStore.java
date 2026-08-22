package org.jivesoftware.smackx.ox.store.abstr;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.selection_strategy.BareJidUserId;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore;
import org.jxmpp.jid.BareJid;
import org.pgpainless.PGPainless;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.collection.PGPKeyRing;
import org.pgpainless.util.BCUtil;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractOpenPgpKeyStore implements OpenPgpKeyStore {
    protected static final Logger LOGGER = Logger.getLogger(AbstractOpenPgpKeyStore.class.getName());
    protected Map<BareJid, PGPPublicKeyRingCollection> publicKeyRingCollections = new HashMap();
    protected Map<BareJid, PGPSecretKeyRingCollection> secretKeyRingCollections = new HashMap();
    protected Map<BareJid, Map<OpenPgpV4Fingerprint, Date>> keyFetchDates = new HashMap();

    protected abstract Map<OpenPgpV4Fingerprint, Date> readKeyFetchDates(BareJid bareJid) throws IOException;

    protected abstract PGPPublicKeyRingCollection readPublicKeysOf(BareJid bareJid) throws IOException, PGPException;

    protected abstract PGPSecretKeyRingCollection readSecretKeysOf(BareJid bareJid) throws IOException, PGPException;

    protected abstract void writeKeyFetchDates(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException;

    protected abstract void writePublicKeysOf(BareJid bareJid, PGPPublicKeyRingCollection pGPPublicKeyRingCollection) throws IOException;

    protected abstract void writeSecretKeysOf(BareJid bareJid, PGPSecretKeyRingCollection pGPSecretKeyRingCollection) throws IOException;

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public Map<OpenPgpV4Fingerprint, Date> getPublicKeyFetchDates(BareJid bareJid) throws IOException {
        Map<OpenPgpV4Fingerprint, Date> map = this.keyFetchDates.get(bareJid);
        if (map != null) {
            return map;
        }
        Map<OpenPgpV4Fingerprint, Date> keyFetchDates = readKeyFetchDates(bareJid);
        this.keyFetchDates.put(bareJid, keyFetchDates);
        return keyFetchDates;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void setPublicKeyFetchDates(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException {
        this.keyFetchDates.put(bareJid, map);
        writeKeyFetchDates(bareJid, map);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPPublicKeyRingCollection getPublicKeysOf(BareJid bareJid) throws IOException, PGPException {
        PGPPublicKeyRingCollection publicKeysOf = this.publicKeyRingCollections.get(bareJid);
        if (publicKeysOf == null && (publicKeysOf = readPublicKeysOf(bareJid)) != null) {
            this.publicKeyRingCollections.put(bareJid, publicKeysOf);
        }
        return publicKeysOf;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPSecretKeyRingCollection getSecretKeysOf(BareJid bareJid) throws IOException, PGPException {
        PGPSecretKeyRingCollection secretKeysOf = this.secretKeyRingCollections.get(bareJid);
        if (secretKeysOf == null && (secretKeysOf = readSecretKeysOf(bareJid)) != null) {
            this.secretKeyRingCollections.put(bareJid, secretKeysOf);
        }
        return secretKeysOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.bouncycastle.openpgp.PGPSecretKeyRingCollection] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, org.bouncycastle.openpgp.PGPSecretKeyRingCollection] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.bouncycastle.openpgp.PGPSecretKeyRing[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore] */
    /* JADX WARN: Type inference failed for: r8v1, types: [org.bouncycastle.openpgp.PGPSecretKeyRing] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2, types: [org.bouncycastle.openpgp.PGPSecretKeyRing] */
    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void importSecretKey(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) throws MissingUserIdOnKeyException, IOException, PGPException {
        ?? r0;
        if (!new BareJidUserId.SecRingSelectionStrategy().accept(bareJid, pGPSecretKeyRing)) {
            throw new MissingUserIdOnKeyException(bareJid, new OpenPgpV4Fingerprint(pGPSecretKeyRing));
        }
        ?? RemoveUnassociatedKeysFromKeyRing = BCUtil.removeUnassociatedKeysFromKeyRing(pGPSecretKeyRing, pGPSecretKeyRing.getPublicKey());
        ?? secretKeysOf = getSecretKeysOf(bareJid);
        try {
            if (secretKeysOf != 0) {
                RemoveUnassociatedKeysFromKeyRing = PGPSecretKeyRingCollection.addSecretKeyRing(secretKeysOf, RemoveUnassociatedKeysFromKeyRing);
            } else {
                RemoveUnassociatedKeysFromKeyRing = BCUtil.keyRingsToKeyRingCollection((PGPSecretKeyRing[]) new PGPSecretKeyRing[]{RemoveUnassociatedKeysFromKeyRing});
            }
            secretKeysOf = RemoveUnassociatedKeysFromKeyRing;
            r0 = secretKeysOf;
        } catch (IllegalArgumentException unused) {
            LOGGER.log(Level.INFO, "Skipping secret key ring " + Long.toHexString(RemoveUnassociatedKeysFromKeyRing.getPublicKey().getKeyID()) + " as it is already in the key ring of " + bareJid.toString());
            r0 = secretKeysOf;
        }
        this.secretKeyRingCollections.put(bareJid, (PGPSecretKeyRingCollection) r0);
        writeSecretKeysOf(bareJid, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.bouncycastle.openpgp.PGPPublicKeyRingCollection] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, org.bouncycastle.openpgp.PGPPublicKeyRingCollection] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v3, types: [org.bouncycastle.openpgp.PGPPublicKeyRing[]] */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpKeyStore] */
    /* JADX WARN: Type inference failed for: r8v1, types: [org.bouncycastle.openpgp.PGPPublicKeyRing] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2, types: [org.bouncycastle.openpgp.PGPPublicKeyRing] */
    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void importPublicKey(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) throws MissingUserIdOnKeyException, IOException, PGPException {
        ?? r0;
        if (!new BareJidUserId.PubRingSelectionStrategy().accept(bareJid, pGPPublicKeyRing)) {
            throw new MissingUserIdOnKeyException(bareJid, new OpenPgpV4Fingerprint(pGPPublicKeyRing));
        }
        ?? RemoveUnassociatedKeysFromKeyRing = BCUtil.removeUnassociatedKeysFromKeyRing(pGPPublicKeyRing, pGPPublicKeyRing.getPublicKey());
        ?? publicKeysOf = getPublicKeysOf(bareJid);
        try {
            if (publicKeysOf != 0) {
                RemoveUnassociatedKeysFromKeyRing = PGPPublicKeyRingCollection.addPublicKeyRing(publicKeysOf, RemoveUnassociatedKeysFromKeyRing);
            } else {
                RemoveUnassociatedKeysFromKeyRing = BCUtil.keyRingsToKeyRingCollection((PGPPublicKeyRing[]) new PGPPublicKeyRing[]{RemoveUnassociatedKeysFromKeyRing});
            }
            publicKeysOf = RemoveUnassociatedKeysFromKeyRing;
            r0 = publicKeysOf;
        } catch (IllegalArgumentException unused) {
            LOGGER.log(Level.INFO, "Skipping public key ring " + Long.toHexString(RemoveUnassociatedKeysFromKeyRing.getPublicKey().getKeyID()) + " as it is already in the key ring of " + bareJid.toString());
            r0 = publicKeysOf;
        }
        this.publicKeyRingCollections.put(bareJid, (PGPPublicKeyRingCollection) r0);
        writePublicKeysOf(bareJid, r0);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPPublicKeyRing getPublicKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        PGPPublicKeyRingCollection publicKeysOf = getPublicKeysOf(bareJid);
        if (publicKeysOf != null) {
            return publicKeysOf.getPublicKeyRing(openPgpV4Fingerprint.getKeyId());
        }
        return null;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPSecretKeyRing getSecretKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        PGPSecretKeyRingCollection secretKeysOf = getSecretKeysOf(bareJid);
        if (secretKeysOf != null) {
            return secretKeysOf.getSecretKeyRing(openPgpV4Fingerprint.getKeyId());
        }
        return null;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void deletePublicKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        PGPPublicKeyRingCollection publicKeysOf = getPublicKeysOf(bareJid);
        if (publicKeysOf.contains(openPgpV4Fingerprint.getKeyId())) {
            PGPPublicKeyRingCollection pGPPublicKeyRingCollectionRemovePublicKeyRing = PGPPublicKeyRingCollection.removePublicKeyRing(publicKeysOf, publicKeysOf.getPublicKeyRing(openPgpV4Fingerprint.getKeyId()));
            if (!pGPPublicKeyRingCollectionRemovePublicKeyRing.iterator().hasNext()) {
                pGPPublicKeyRingCollectionRemovePublicKeyRing = null;
            }
            this.publicKeyRingCollections.put(bareJid, pGPPublicKeyRingCollectionRemovePublicKeyRing);
            writePublicKeysOf(bareJid, pGPPublicKeyRingCollectionRemovePublicKeyRing);
        }
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void deleteSecretKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        PGPSecretKeyRingCollection secretKeysOf = getSecretKeysOf(bareJid);
        if (secretKeysOf.contains(openPgpV4Fingerprint.getKeyId())) {
            PGPSecretKeyRingCollection pGPSecretKeyRingCollectionRemoveSecretKeyRing = PGPSecretKeyRingCollection.removeSecretKeyRing(secretKeysOf, secretKeysOf.getSecretKeyRing(openPgpV4Fingerprint.getKeyId()));
            if (!pGPSecretKeyRingCollectionRemoveSecretKeyRing.iterator().hasNext()) {
                pGPSecretKeyRingCollectionRemoveSecretKeyRing = null;
            }
            this.secretKeyRingCollections.put(bareJid, pGPSecretKeyRingCollectionRemoveSecretKeyRing);
            writeSecretKeysOf(bareJid, pGPSecretKeyRingCollectionRemoveSecretKeyRing);
        }
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPKeyRing generateKeyRing(BareJid bareJid) throws NoSuchAlgorithmException, PGPException, NoSuchProviderException, InvalidAlgorithmParameterException {
        return PGPainless.generateKeyRing().simpleEcKeyRing("xmpp:" + bareJid.toString());
    }
}
