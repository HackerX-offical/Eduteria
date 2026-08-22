package org.jivesoftware.smackx.ox.store.definition;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public interface OpenPgpMetadataStore {
    Map<OpenPgpV4Fingerprint, Date> getAnnouncedFingerprintsOf(BareJid bareJid) throws IOException;

    void setAnnouncedFingerprintsOf(BareJid bareJid, Map<OpenPgpV4Fingerprint, Date> map) throws IOException;
}
