package org.jivesoftware.smackx.ox.store.definition;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.Map;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.jivesoftware.smackx.ox.exception.MissingUserIdOnKeyException;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;
import org.pgpainless.key.collection.PGPKeyRing;

/* JADX INFO: loaded from: classes10.dex */
public interface OpenPgpKeyStore {
    void deletePublicKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException;

    void deleteSecretKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException;

    PGPKeyRing generateKeyRing(BareJid bareJid) throws NoSuchAlgorithmException, PGPException, NoSuchProviderException, InvalidAlgorithmParameterException;

    Map<OpenPgpV4Fingerprint, Date> getPublicKeyFetchDates(BareJid bareJid) throws IOException;

    PGPPublicKeyRing getPublicKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException;

    PGPPublicKeyRingCollection getPublicKeysOf(BareJid bareJid) throws IOException, PGPException;

    PGPSecretKeyRing getSecretKeyRing(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException, PGPException;

    PGPSecretKeyRingCollection getSecretKeysOf(BareJid bareJid) throws IOException, PGPException;

    void importPublicKey(BareJid bareJid, PGPPublicKeyRing pGPPublicKeyRing) throws MissingUserIdOnKeyException, IOException, PGPException;

    void importSecretKey(BareJid bareJid, PGPSecretKeyRing pGPSecretKeyRing) throws MissingUserIdOnKeyException, IOException, PGPException;

    void setPublicKeyFetchDates(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException;
}
