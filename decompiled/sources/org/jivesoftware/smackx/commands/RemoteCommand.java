package org.jivesoftware.smackx.commands;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class RemoteCommand extends AdHocCommand {
    private final XMPPConnection connection;
    private final Jid jid;
    private String sessionID;

    protected RemoteCommand(XMPPConnection xMPPConnection, String str, Jid jid) {
        this.connection = xMPPConnection;
        this.jid = jid;
        setNode(str);
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void cancel() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.cancel);
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void complete(FillableForm fillableForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.complete, fillableForm.getDataFormToSubmit());
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void execute() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.execute);
    }

    public void execute(FillableForm fillableForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.execute, fillableForm.getDataFormToSubmit());
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void next(FillableForm fillableForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.next, fillableForm.getDataFormToSubmit());
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public void prev() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        executeAction(AdHocCommand.Action.prev);
    }

    private void executeAction(AdHocCommand.Action action) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        executeAction(action, null);
    }

    private void executeAction(AdHocCommand.Action action, DataForm dataForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        AdHocCommandData adHocCommandData = new AdHocCommandData();
        adHocCommandData.setType(IQ.Type.set);
        adHocCommandData.setTo(getOwnerJID());
        adHocCommandData.setNode(getNode());
        adHocCommandData.setSessionID(this.sessionID);
        adHocCommandData.setAction(action);
        adHocCommandData.setForm(dataForm);
        AdHocCommandData adHocCommandData2 = (AdHocCommandData) this.connection.createStanzaCollectorAndSend(adHocCommandData).nextResultOrThrow();
        if (adHocCommandData2 != null) {
            this.sessionID = adHocCommandData2.getSessionID();
            super.setData(adHocCommandData2);
        }
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public Jid getOwnerJID() {
        return this.jid;
    }
}
