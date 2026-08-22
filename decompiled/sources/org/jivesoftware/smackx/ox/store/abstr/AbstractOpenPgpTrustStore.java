package org.jivesoftware.smackx.ox.store.abstr;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractOpenPgpTrustStore implements OpenPgpTrustStore {
    private final Map<BareJid, Map<OpenPgpV4Fingerprint, OpenPgpTrustStore.Trust>> trustCache = new HashMap();

    protected abstract OpenPgpTrustStore.Trust readTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException;

    protected abstract void writeTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint, OpenPgpTrustStore.Trust trust) throws IOException;

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore
    public OpenPgpTrustStore.Trust getTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException {
        Map<OpenPgpV4Fingerprint, OpenPgpTrustStore.Trust> map = this.trustCache.get(bareJid);
        if (map != null) {
            OpenPgpTrustStore.Trust trust = map.get(openPgpV4Fingerprint);
            if (trust != null) {
                return trust;
            }
        } else {
            map = new HashMap<>();
            this.trustCache.put(bareJid, map);
        }
        OpenPgpTrustStore.Trust trust2 = readTrust(bareJid, openPgpV4Fingerprint);
        map.put(openPgpV4Fingerprint, trust2);
        return trust2;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpTrustStore
    public void setTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint, OpenPgpTrustStore.Trust trust) throws IOException {
        Map<OpenPgpV4Fingerprint, OpenPgpTrustStore.Trust> map = this.trustCache.get(bareJid);
        if (map == null) {
            map = new HashMap<>();
            this.trustCache.put(bareJid, map);
        }
        if (map.get(openPgpV4Fingerprint) == trust) {
            return;
        }
        map.put(openPgpV4Fingerprint, trust);
        writeTrust(bareJid, openPgpV4Fingerprint, trust);
    }
}
