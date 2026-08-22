package org.jivesoftware.smackx.ox.store.definition;

import java.io.IOException;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public interface OpenPgpTrustStore {

    public enum Trust {
        trusted,
        untrusted,
        undecided
    }

    Trust getTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) throws IOException;

    void setTrust(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint, Trust trust) throws IOException;
}
