package org.jivesoftware.smackx.iot;

import java.util.logging.Logger;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.iot.provisioning.IoTProvisioningManager;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class IoTManager extends Manager {
    private static final Logger LOGGER = Logger.getLogger(IoTManager.class.getName());
    private static boolean autoEnable;
    private boolean allowNonFriends;
    private final IoTProvisioningManager ioTProvisioningManager;

    public static void setAutoEnableIoTManagers(boolean z) {
        autoEnable = z;
    }

    public static boolean isAutoEnableActive() {
        return autoEnable;
    }

    protected IoTManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.ioTProvisioningManager = IoTProvisioningManager.getInstanceFor(xMPPConnection);
    }

    public void setAllowNonFriends(boolean z) {
        this.allowNonFriends = z;
    }

    protected boolean isAllowed(Jid jid) {
        if (this.allowNonFriends) {
            return true;
        }
        return this.ioTProvisioningManager.isMyFriend(jid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract class IoTIqRequestHandler extends AbstractIqRequestHandler {
        protected abstract IQ handleIoTIqRequest(IQ iq);

        protected IoTIqRequestHandler(String str, String str2, IQ.Type type, IQRequestHandler.Mode mode) {
            super(str, str2, type, mode);
        }

        @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
        public final IQ handleIQRequest(IQ iq) {
            if (!IoTManager.this.isAllowed(iq.getFrom())) {
                IoTManager.LOGGER.warning("Ignoring IQ request " + iq);
                return null;
            }
            return handleIoTIqRequest(iq);
        }
    }
}
