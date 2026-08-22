package org.jivesoftware.smackx.amp;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

/* JADX INFO: loaded from: classes10.dex */
public class AMPDeliverCondition implements AMPExtension.Condition {
    public static final String NAME = "deliver";
    private final Value value;

    public enum Value {
        direct,
        forward,
        gateway,
        none,
        stored
    }

    public static boolean isSupported(XMPPConnection xMPPConnection) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return AMPManager.isConditionSupported(xMPPConnection, NAME);
    }

    public AMPDeliverCondition(Value value) {
        if (value == null) {
            throw new NullPointerException("Can't create AMPDeliverCondition with null value");
        }
        this.value = value;
    }

    @Override // org.jivesoftware.smackx.amp.packet.AMPExtension.Condition
    public String getName() {
        return NAME;
    }

    @Override // org.jivesoftware.smackx.amp.packet.AMPExtension.Condition
    public String getValue() {
        return this.value.toString();
    }
}
