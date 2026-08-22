package org.jivesoftware.smackx.iot.control;

import java.util.Collection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.iot.control.element.SetData;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public interface ThingControlRequest {
    void processRequest(Jid jid, Collection<SetData> collection) throws XMPPException.XMPPErrorException;
}
