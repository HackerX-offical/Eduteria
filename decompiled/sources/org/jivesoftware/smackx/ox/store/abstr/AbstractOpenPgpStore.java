package org.jivesoftware.smackx.ox.store.abstr;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.ox.OpenPgpContact;
import org.jivesoftware.smackx.ox.callback.SecretKeyPassphraseCallback;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpStore;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.collection.PGPKeyRing;
import org.pgpainless.key.protection.SecretKeyRingProtector;
import org.pgpainless.key.protection.UnprotectedKeysProtector;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractOpenPgpStore implements OpenPgpStore {
    protected final OpenPgpKeyStore keyStore;
    protected final OpenPgpMetadataStore metadataStore;
    protected SecretKeyPassphraseCallback secretKeyPassphraseCallback;
    protected final OpenPgpTrustStore trustStore;
    protected SecretKeyRingProtector unlocker = new UnprotectedKeysProtector();
    protected final Map<BareJid, OpenPgpContact> contacts = new HashMap();

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void deletePublicKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        this.keyStore.deletePublicKeyRing(bareJid, openPgpV4Fingerprint);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void deleteSecretKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        this.keyStore.deleteSecretKeyRing(bareJid, openPgpV4Fingerprint);
    }

    protected AbstractOpenPgpStore(OpenPgpKeyStore openPgpKeyStore, OpenPgpMetadataStore openPgpMetadataStore, OpenPgpTrustStore openPgpTrustStore) {
        this.keyStore = (OpenPgpKeyStore) Objects.requireNonNull(openPgpKeyStore);
        this.metadataStore = (OpenPgpMetadataStore) Objects.requireNonNull(openPgpMetadataStore);
        this.trustStore = (OpenPgpTrustStore) Objects.requireNonNull(openPgpTrustStore);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpStore
    public OpenPgpContact getOpenPgpContact(BareJid bareJid) {
        OpenPgpContact openPgpContact = this.contacts.get(bareJid);
        if (openPgpContact != null) {
            return openPgpContact;
        }
        OpenPgpContact openPgpContact2 = new OpenPgpContact(bareJid, this);
        this.contacts.put(bareJid, openPgpContact2);
        return openPgpContact2;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpStore
    public void setKeyRingProtector(SecretKeyRingProtector secretKeyRingProtector) {
        this.unlocker = secretKeyRingProtector;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpStore
    public SecretKeyRingProtector getKeyRingProtector() {
        return this.unlocker;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpStore
    public void setSecretKeyPassphraseCallback(SecretKeyPassphraseCallback secretKeyPassphraseCallback) {
        this.secretKeyPassphraseCallback = secretKeyPassphraseCallback;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPPublicKeyRingCollection getPublicKeysOf(BareJid bareJid) throws IOException, PGPException {
        return this.keyStore.getPublicKeysOf(bareJid);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPSecretKeyRingCollection getSecretKeysOf(BareJid bareJid) throws IOException, PGPException {
        return this.keyStore.getSecretKeysOf(bareJid);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPPublicKeyRing getPublicKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        return this.keyStore.getPublicKeyRing(bareJid, openPgpV4Fingerprint);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPSecretKeyRing getSecretKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException {
        return this.keyStore.getSecretKeyRing(bareJid, openPgpV4Fingerprint);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public PGPKeyRing generateKeyRing(BareJid bareJid) throws NoSuchAlgorithmException, PGPException, NoSuchProviderException, InvalidAlgorithmParameterException {
        return this.keyStore.generateKeyRing(bareJid);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void importSecretKey(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) throws MissingUserIdOnKeyException, IOException, PGPException {
        this.keyStore.importSecretKey(bareJid, pGPSecretKeyRing);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void importPublicKey(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) throws MissingUserIdOnKeyException, IOException, PGPException {
        this.keyStore.importPublicKey(bareJid, pGPPublicKeyRing);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public Map<OpenPgpV4Fingerprint, Date> getPublicKeyFetchDates(BareJid bareJid) throws IOException {
        return this.keyStore.getPublicKeyFetchDates(bareJid);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpKeyStore
    public void setPublicKeyFetchDates(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException {
        this.keyStore.setPublicKeyFetchDates(bareJid, map);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore
    public Map<OpenPgpV4Fingerprint, Date> getAnnouncedFingerprintsOf(BareJid bareJid) throws IOException {
        return this.metadataStore.getAnnouncedFingerprintsOf(bareJid);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore
    public void setAnnouncedFingerprintsOf(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException {
        this.metadataStore.setAnnouncedFingerprintsOf(bareJid, map);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore
    public OpenPgpTrustStore.Trust getTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException {
        return this.trustStore.getTrust(bareJid, openPgpV4Fingerprint);
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore
    public void setTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint, OpenPgpTrustStore.Trust trust) throws IOException {
        this.trustStore.setTrust(bareJid, openPgpV4Fingerprint, trust);
    }
}
