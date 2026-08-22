package org.jivesoftware.smackx.ox.exception;

import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class MissingUserIdOnKeyException extends Exception {
    private static final long serialVersionUID = 1;

    public MissingUserIdOnKeyException(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        super("Key " + openPgpV4Fingerprint.toString() + " does not have a user-id of \"xmpp:" + bareJid.toString() + "\".");
    }
}
