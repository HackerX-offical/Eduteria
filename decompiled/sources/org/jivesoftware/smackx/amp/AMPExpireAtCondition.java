package org.jivesoftware.smackx.amp;

import java.util.Date;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.amp.packet.AMPExtension;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class AMPExpireAtCondition implements AMPExtension.Condition {
    public static final String NAME = "expire-at";
    private final String value;

    public static boolean isSupported(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return AMPManager.isConditionSupported(xMPPConnection, NAME);
    }

    public AMPExpireAtCondition(Date date) {
        if (date == null) {
            throw new NullPointerException("Can't create AMPExpireAtCondition with null value");
        }
        this.value = XmppDateTime.formatXEP0082Date(date);
    }

    public AMPExpireAtCondition(String str) {
        if (str == null) {
            throw new NullPointerException("Can't create AMPExpireAtCondition with null value");
        }
        this.value = str;
    }

    @Override // org.jivesoftware.smackx.amp.packet.AMPExtension.Condition
    public String getName() {
        return NAME;
    }

    @Override // org.jivesoftware.smackx.amp.packet.AMPExtension.Condition
    public String getValue() {
        return this.value;
    }
}
