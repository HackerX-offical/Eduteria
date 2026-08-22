package org.jivesoftware.smackx.search;

import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public class UserSearchManager {
    private final XMPPConnection con;
    private final UserSearch userSearch = new UserSearch();

    public UserSearchManager(XMPPConnection xMPPConnection) {
        this.con = xMPPConnection;
    }

    public DataForm getSearchForm(DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.userSearch.getSearchForm(this.con, domainBareJid);
    }

    public ReportedData getSearchResults(DataForm dataForm, DomainBareJid domainBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return this.userSearch.sendSearchForm(this.con, dataForm, domainBareJid);
    }

    public List<DomainBareJid> getSearchServices() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        return ServiceDiscoveryManager.getInstanceFor(this.con).findServices("jabber:iq:search", false, false);
    }
}
