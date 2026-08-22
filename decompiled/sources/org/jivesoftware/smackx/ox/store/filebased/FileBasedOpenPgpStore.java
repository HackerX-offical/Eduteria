package org.jivesoftware.smackx.ox.store.filebased;

import java.io.File;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smackx.ox.store.abstr.AbstractOpenPgpStore;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public class FileBasedOpenPgpStore extends AbstractOpenPgpStore {
    public FileBasedOpenPgpStore(File file) {
        super(new FileBasedOpenPgpKeyStore(file), new FileBasedOpenPgpMetadataStore(file), new FileBasedOpenPgpTrustStore(file));
    }

    public static File getContactsPath(File file, BareJid bareJid) {
        return new File(file, (String) Objects.requireNonNull(bareJid.asUrlEncodedString()));
    }
}
