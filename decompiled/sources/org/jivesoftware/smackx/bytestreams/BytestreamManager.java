package org.jivesoftware.smackx.bytestreams;

import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface BytestreamManager {
    void addIncomingBytestreamListener(BytestreamListener bytestreamListener);

    void addIncomingBytestreamListener(BytestreamListener bytestreamListener, Jid jid);

    BytestreamSession establishSession(Jid jid) throws SmackException, InterruptedException, IOException, XMPPException;

    BytestreamSession establishSession(Jid jid, String str) throws SmackException, InterruptedException, IOException, XMPPException;

    void removeIncomingBytestreamListener(BytestreamListener bytestreamListener);

    void removeIncomingBytestreamListener(Jid jid);
}
