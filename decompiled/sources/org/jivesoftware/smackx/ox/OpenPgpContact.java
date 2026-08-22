package org.jivesoftware.smackx.ox;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.util.stringencoder.Base64;
import org.jivesoftware.smackx.ox.element.PubkeyElement;
import org.jivesoftware.smackx.ox.element.PublicKeysListElement;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.selection_strategy.BareJidUserId;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jivesoftware.smackx.ox.util.OpenPgpPubSubUtil;
import org.jivesoftware.smackx.pubsub.PubSubException;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.util.BCUtil;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpContact {
    private final Logger LOGGER;
    protected final BareJid jid;
    protected final OpenPgpStore store;
    protected final Map<OpenPgpV4Fingerprint, Throwable> unfetchableKeys = new HashMap();

    public OpenPgpContact(BareJid bareJid, OpenPgpStore openPgpStore) {
        this.jid = bareJid;
        this.store = openPgpStore;
        this.LOGGER = Logger.getLogger(OpenPgpContact.class.getName() + ":" + bareJid.toString());
    }

    public BareJid getJid() {
        return this.jid;
    }

    public PGPPublicKeyRingCollection getAnyPublicKeys() throws IOException, PGPException {
        return this.store.getPublicKeysOf(this.jid);
    }

    public PGPPublicKeyRingCollection getAnnouncedPublicKeys() throws IOException, PGPException {
        PGPPublicKeyRingCollection anyPublicKeys = getAnyPublicKeys();
        Map<OpenPgpV4Fingerprint, Date> announcedFingerprintsOf = this.store.getAnnouncedFingerprintsOf(this.jid);
        BareJidUserId.PubRingSelectionStrategy pubRingSelectionStrategy = new BareJidUserId.PubRingSelectionStrategy();
        PGPPublicKeyRingCollection pGPPublicKeyRingCollection = null;
        for (OpenPgpV4Fingerprint openPgpV4Fingerprint : announcedFingerprintsOf.keySet()) {
            PGPPublicKeyRing publicKeyRing = anyPublicKeys.getPublicKeyRing(openPgpV4Fingerprint.getKeyId());
            if (publicKeyRing != null) {
                PGPPublicKeyRing pGPPublicKeyRingRemoveUnassociatedKeysFromKeyRing = BCUtil.removeUnassociatedKeysFromKeyRing(publicKeyRing, publicKeyRing.getPublicKey(openPgpV4Fingerprint.getKeyId()));
                if (!pubRingSelectionStrategy.accept(getJid(), pGPPublicKeyRingRemoveUnassociatedKeysFromKeyRing)) {
                    this.LOGGER.log(Level.WARNING, "Ignore key " + Long.toHexString(pGPPublicKeyRingRemoveUnassociatedKeysFromKeyRing.getPublicKey().getKeyID()) + " as it lacks the user-id \"xmpp" + getJid().toString() + "\"");
                } else if (pGPPublicKeyRingCollection == null) {
                    pGPPublicKeyRingCollection = new PGPPublicKeyRingCollection(Collections.singleton(pGPPublicKeyRingRemoveUnassociatedKeysFromKeyRing));
                } else {
                    pGPPublicKeyRingCollection = PGPPublicKeyRingCollection.addPublicKeyRing(pGPPublicKeyRingCollection, pGPPublicKeyRingRemoveUnassociatedKeysFromKeyRing);
                }
            }
        }
        return pGPPublicKeyRingCollection;
    }

    protected PGPPublicKeyRingCollection getPublicKeysOfTrustState(PGPPublicKeyRingCollection pGPPublicKeyRingCollection, OpenPgpTrustStore.Trust trust) throws IOException {
        if (pGPPublicKeyRingCollection == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (PGPPublicKeyRing pGPPublicKeyRing : pGPPublicKeyRingCollection) {
            if (this.store.getTrust(getJid(), new OpenPgpV4Fingerprint(pGPPublicKeyRing)) != trust) {
                hashSet.add(pGPPublicKeyRing);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            pGPPublicKeyRingCollection = PGPPublicKeyRingCollection.removePublicKeyRing(pGPPublicKeyRingCollection, (PGPPublicKeyRing) it.next());
        }
        if (pGPPublicKeyRingCollection.iterator().hasNext()) {
            return pGPPublicKeyRingCollection;
        }
        return null;
    }

    public PGPPublicKeyRingCollection getTrustedAnnouncedKeys() throws IOException, PGPException {
        return getPublicKeysOfTrustState(getAnnouncedPublicKeys(), OpenPgpTrustStore.Trust.trusted);
    }

    public Set<OpenPgpV4Fingerprint> getTrustedFingerprints() throws IOException, PGPException {
        return getFingerprintsOfKeysWithState(getAnyPublicKeys(), OpenPgpTrustStore.Trust.trusted);
    }

    public Set<OpenPgpV4Fingerprint> getUntrustedFingerprints() throws IOException, PGPException {
        return getFingerprintsOfKeysWithState(getAnyPublicKeys(), OpenPgpTrustStore.Trust.untrusted);
    }

    public Set<OpenPgpV4Fingerprint> getUndecidedFingerprints() throws IOException, PGPException {
        return getFingerprintsOfKeysWithState(getAnyPublicKeys(), OpenPgpTrustStore.Trust.undecided);
    }

    public Set<OpenPgpV4Fingerprint> getFingerprintsOfKeysWithState(PGPPublicKeyRingCollection pGPPublicKeyRingCollection, OpenPgpTrustStore.Trust trust) throws IOException {
        PGPPublicKeyRingCollection publicKeysOfTrustState = getPublicKeysOfTrustState(pGPPublicKeyRingCollection, trust);
        HashSet hashSet = new HashSet();
        if (publicKeysOfTrustState != null) {
            Iterator<PGPPublicKeyRing> it = publicKeysOfTrustState.iterator();
            while (it.hasNext()) {
                hashSet.add(new OpenPgpV4Fingerprint(it.next()));
            }
        }
        return hashSet;
    }

    public OpenPgpTrustStore.Trust getTrust(OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException {
        return this.store.getTrust(getJid(), openPgpV4Fingerprint);
    }

    public boolean isTrusted(OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException {
        return getTrust(openPgpV4Fingerprint) == OpenPgpTrustStore.Trust.trusted;
    }

    public void trust(OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException {
        this.store.setTrust(getJid(), openPgpV4Fingerprint, OpenPgpTrustStore.Trust.trusted);
    }

    public void distrust(OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException {
        this.store.setTrust(getJid(), openPgpV4Fingerprint, OpenPgpTrustStore.Trust.untrusted);
    }

    public boolean hasUndecidedKeys() throws IOException, PGPException {
        return getUndecidedFingerprints().size() != 0;
    }

    public Map<OpenPgpV4Fingerprint, Throwable> getUnfetchableKeys() {
        return new HashMap(this.unfetchableKeys);
    }

    public void updateKeys(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, PubSubException.NotALeafNodeException, PubSubException.NotAPubSubNodeException, IOException, XMPPException.XMPPErrorException {
        PublicKeysListElement publicKeysListElementFetchPubkeysList = OpenPgpPubSubUtil.fetchPubkeysList(xMPPConnection, getJid());
        if (publicKeysListElementFetchPubkeysList == null) {
            return;
        }
        updateKeys(xMPPConnection, publicKeysListElementFetchPubkeysList);
    }

    public void updateKeys(XMPPConnection xMPPConnection, PublicKeysListElement publicKeysListElement) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, IOException {
        Map<OpenPgpV4Fingerprint, Date> map = new HashMap<>();
        for (OpenPgpV4Fingerprint openPgpV4Fingerprint : publicKeysListElement.getMetadata().keySet()) {
            map.put(openPgpV4Fingerprint, publicKeysListElement.getMetadata().get(openPgpV4Fingerprint).getDate());
        }
        this.store.setAnnouncedFingerprintsOf(getJid(), map);
        Map<OpenPgpV4Fingerprint, Date> publicKeyFetchDates = this.store.getPublicKeyFetchDates(getJid());
        for (OpenPgpV4Fingerprint openPgpV4Fingerprint2 : publicKeysListElement.getMetadata().keySet()) {
            Date date = publicKeyFetchDates.get(openPgpV4Fingerprint2);
            if (date != null && map.get(openPgpV4Fingerprint2) != null && date.after(map.get(openPgpV4Fingerprint2))) {
                this.LOGGER.log(Level.FINE, "Skip key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()) + " as we already have the most recent version. Last announced: " + map.get(openPgpV4Fingerprint2).toString() + " Last fetched: " + date.toString());
            } else {
                try {
                    PubkeyElement pubkeyElementFetchPubkey = OpenPgpPubSubUtil.fetchPubkey(xMPPConnection, getJid(), openPgpV4Fingerprint2);
                    this.unfetchableKeys.remove(openPgpV4Fingerprint2);
                    publicKeyFetchDates.put(openPgpV4Fingerprint2, new Date());
                    if (pubkeyElementFetchPubkey == null) {
                        this.LOGGER.log(Level.WARNING, "Public key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()) + " can not be imported: Is null");
                        this.unfetchableKeys.put(openPgpV4Fingerprint2, new NullPointerException("Public key is null."));
                    } else {
                        this.store.importPublicKey(getJid(), new PGPPublicKeyRing(Base64.decode(pubkeyElementFetchPubkey.getDataElement().getB64Data()), new BcKeyFingerprintCalculator()));
                    }
                } catch (IOException e2) {
                    e = e2;
                    this.LOGGER.log(Level.WARNING, "Public key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()) + " can not be imported.", e);
                    this.unfetchableKeys.put(openPgpV4Fingerprint2, e);
                } catch (PGPException e3) {
                    e = e3;
                    this.LOGGER.log(Level.WARNING, "Public key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()) + " can not be imported.", e);
                    this.unfetchableKeys.put(openPgpV4Fingerprint2, e);
                } catch (XMPPException.XMPPErrorException e4) {
                    e = e4;
                    this.LOGGER.log(Level.WARNING, "Error fetching public key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()), e);
                    this.unfetchableKeys.put(openPgpV4Fingerprint2, e);
                } catch (MissingUserIdOnKeyException e5) {
                    this.LOGGER.log(Level.WARNING, "Public key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()) + " is missing the user-id \"xmpp:" + ((Object) getJid()) + "\". Refuse to import it.", (Throwable) e5);
                    this.unfetchableKeys.put(openPgpV4Fingerprint2, e5);
                } catch (PubSubException.NotALeafNodeException e6) {
                    e = e6;
                    this.LOGGER.log(Level.WARNING, "Error fetching public key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()), e);
                    this.unfetchableKeys.put(openPgpV4Fingerprint2, e);
                } catch (PubSubException.NotAPubSubNodeException e7) {
                    e = e7;
                    this.LOGGER.log(Level.WARNING, "Error fetching public key " + Long.toHexString(openPgpV4Fingerprint2.getKeyId()), e);
                    this.unfetchableKeys.put(openPgpV4Fingerprint2, e);
                }
            }
        }
        this.store.setPublicKeyFetchDates(getJid(), publicKeyFetchDates);
    }
}
