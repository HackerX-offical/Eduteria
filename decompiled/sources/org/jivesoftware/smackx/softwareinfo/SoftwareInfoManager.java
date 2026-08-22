package org.jivesoftware.smackx.softwareinfo;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public final class SoftwareInfoManager extends Manager {
    private static final Map<XMPPConnection, SoftwareInfoManager> INSTANCES = new WeakHashMap();
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    public static synchronized SoftwareInfoManager getInstanceFor(XMPPConnection xMPPConnection) {
        SoftwareInfoManager softwareInfoManager;
        Map<XMPPConnection, SoftwareInfoManager> map = INSTANCES;
        softwareInfoManager = map.get(xMPPConnection);
        if (softwareInfoManager == null) {
            softwareInfoManager = new SoftwareInfoManager(xMPPConnection);
            map.put(xMPPConnection, softwareInfoManager);
        }
        return softwareInfoManager;
    }

    private SoftwareInfoManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
    }

    public void publishSoftwareInformationForm(SoftwareInfoForm softwareInfoForm) {
        this.serviceDiscoveryManager.addExtendedInfo(softwareInfoForm.getDataForm());
    }

    public SoftwareInfoForm fromJid(Jid jid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        DataForm dataFormFrom = DataForm.from(this.serviceDiscoveryManager.discoverInfo(jid), SoftwareInfoForm.FORM_TYPE);
        if (dataFormFrom == null) {
            return null;
        }
        return SoftwareInfoForm.getBuilder().setDataForm(dataFormFrom).build();
    }
}
