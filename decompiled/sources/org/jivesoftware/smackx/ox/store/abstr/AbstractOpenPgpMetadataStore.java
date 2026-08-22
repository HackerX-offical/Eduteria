package org.jivesoftware.smackx.ox.store.abstr;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractOpenPgpMetadataStore implements OpenPgpMetadataStore {
    private final Map<BareJid, Map<OpenPgpV4Fingerprint, Date>> announcedFingerprints = new HashMap();

    protected abstract Map<OpenPgpV4Fingerprint, Date> readAnnouncedFingerprintsOf(BareJid bareJid) throws IOException;

    protected abstract void writeAnnouncedFingerprintsOf(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException;

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore
    public Map<OpenPgpV4Fingerprint, Date> getAnnouncedFingerprintsOf(BareJid bareJid) throws IOException {
        Map<OpenPgpV4Fingerprint, Date> map = this.announcedFingerprints.get(bareJid);
        if (map != null) {
            return map;
        }
        Map<OpenPgpV4Fingerprint, Date> announcedFingerprintsOf = readAnnouncedFingerprintsOf(bareJid);
        this.announcedFingerprints.put(bareJid, announcedFingerprintsOf);
        return announcedFingerprintsOf;
    }

    @Override // org.jivesoftware.smackx.ox.store.definition.OpenPgpMetadataStore
    public void setAnnouncedFingerprintsOf(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException {
        this.announcedFingerprints.put(bareJid, map);
        writeAnnouncedFingerprintsOf(bareJid, map);
    }
}
