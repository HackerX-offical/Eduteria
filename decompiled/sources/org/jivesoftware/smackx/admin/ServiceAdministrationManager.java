package org.jivesoftware.smackx.admin;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.commands.AdHocCommandManager;
import org.jivesoftware.smackx.commands.RemoteCommand;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class ServiceAdministrationManager extends Manager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String COMMAND_NODE = "http://jabber.org/protocol/admin";
    private static final String COMMAND_NODE_HASHSIGN = "http://jabber.org/protocol/admin#";
    private static final Map<XMPPConnection, ServiceAdministrationManager> INSTANCES = new WeakHashMap();
    private final AdHocCommandManager adHocCommandManager;

    public static synchronized ServiceAdministrationManager getInstanceFor(XMPPConnection xMPPConnection) {
        ServiceAdministrationManager serviceAdministrationManager;
        Map<XMPPConnection, ServiceAdministrationManager> map = INSTANCES;
        serviceAdministrationManager = map.get(xMPPConnection);
        if (serviceAdministrationManager == null) {
            serviceAdministrationManager = new ServiceAdministrationManager(xMPPConnection);
            map.put(xMPPConnection, serviceAdministrationManager);
        }
        return serviceAdministrationManager;
    }

    public ServiceAdministrationManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.adHocCommandManager = AdHocCommandManager.getAddHocCommandsManager(xMPPConnection);
    }

    public RemoteCommand addUser() {
        return addUser(connection().getXMPPServiceDomain());
    }

    public RemoteCommand addUser(Jid jid) {
        return this.adHocCommandManager.getRemoteCommand(jid, "http://jabber.org/protocol/admin#add-user");
    }

    public void addUser(EntityBareJid entityBareJid, String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        RemoteCommand remoteCommandAddUser = addUser();
        remoteCommandAddUser.execute();
        FillableForm fillableForm = new FillableForm(remoteCommandAddUser.getForm());
        fillableForm.setAnswer("accountjid", entityBareJid);
        fillableForm.setAnswer("password", str);
        fillableForm.setAnswer("password-verify", str);
        remoteCommandAddUser.execute(fillableForm);
    }

    public RemoteCommand deleteUser() {
        return deleteUser(connection().getXMPPServiceDomain());
    }

    public RemoteCommand deleteUser(Jid jid) {
        return this.adHocCommandManager.getRemoteCommand(jid, "http://jabber.org/protocol/admin#delete-user");
    }

    public void deleteUser(EntityBareJid entityBareJid) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        deleteUser(Collections.singleton(entityBareJid));
    }

    public void deleteUser(Set<EntityBareJid> set) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        RemoteCommand remoteCommandDeleteUser = deleteUser();
        remoteCommandDeleteUser.execute();
        FillableForm fillableForm = new FillableForm(remoteCommandDeleteUser.getForm());
        fillableForm.setAnswer("accountjids", set);
        remoteCommandDeleteUser.execute(fillableForm);
    }
}
