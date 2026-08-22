package org.jivesoftware.smackx.ox.exception;

import com.amazonaws.services.s3.model.InstructionFileId;
import org.jxmpp.jid.BareJid;
import org.pgpainless.key.OpenPgpV4Fingerprint;

/* JADX INFO: loaded from: classes10.dex */
public class MissingOpenPgpKeyException extends Exception {
    private static final long serialVersionUID = 1;
    private final OpenPgpV4Fingerprint fingerprint;
    private final BareJid owner;

    public MissingOpenPgpKeyException(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint) {
        super("Missing key " + openPgpV4Fingerprint.toString() + " for owner " + ((Object) bareJid) + InstructionFileId.DOT);
        this.owner = bareJid;
        this.fingerprint = openPgpV4Fingerprint;
    }

    public MissingOpenPgpKeyException(BareJid bareJid, OpenPgpV4Fingerprint openPgpV4Fingerprint, Throwable th) {
        super("Missing key " + openPgpV4Fingerprint.toString() + " for owner " + ((Object) bareJid) + InstructionFileId.DOT, th);
        this.owner = bareJid;
        this.fingerprint = openPgpV4Fingerprint;
    }

    public BareJid getOwner() {
        return this.owner;
    }

    public OpenPgpV4Fingerprint getFingerprint() {
        return this.fingerprint;
    }
}
