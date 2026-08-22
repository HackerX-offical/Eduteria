package org.jivesoftware.smackx.commands;

import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AdHocCommand {
    private AdHocCommandData data = new AdHocCommandData();

    public enum Action {
        execute,
        cancel,
        prev,
        next,
        complete,
        unknown
    }

    public enum Status {
        executing,
        completed,
        canceled
    }

    public abstract void cancel() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException;

    public abstract void complete(FillableForm fillableForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException;

    public abstract void execute() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException;

    public abstract Jid getOwnerJID();

    public abstract void next(FillableForm fillableForm) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException;

    public abstract void prev() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException;

    public static SpecificErrorCondition getSpecificErrorCondition(StanzaError stanzaError) {
        for (SpecificErrorCondition specificErrorCondition : SpecificErrorCondition.values()) {
            if (stanzaError.getExtension(specificErrorCondition.toString(), "http://jabber.org/protocol/commands") != null) {
                return specificErrorCondition;
            }
        }
        return null;
    }

    public void setName(String str) {
        this.data.setName(str);
    }

    public String getName() {
        return this.data.getName();
    }

    public void setNode(String str) {
        this.data.setNode(str);
    }

    public String getNode() {
        return this.data.getNode();
    }

    public List<AdHocCommandNote> getNotes() {
        return this.data.getNotes();
    }

    protected void addNote(AdHocCommandNote adHocCommandNote) {
        this.data.addNote(adHocCommandNote);
    }

    public String getRaw() {
        return this.data.getChildElementXML().toString();
    }

    public DataForm getForm() {
        return this.data.getForm();
    }

    protected void setForm(DataForm dataForm) {
        this.data.setForm(dataForm);
    }

    protected List<Action> getActions() {
        return this.data.getActions();
    }

    protected void addActionAvailable(Action action) {
        this.data.addAction(action);
    }

    protected Action getExecuteAction() {
        return this.data.getExecuteAction();
    }

    protected void setExecuteAction(Action action) {
        this.data.setExecuteAction(action);
    }

    public Status getStatus() {
        return this.data.getStatus();
    }

    public boolean isCompleted() {
        return getStatus() == Status.completed;
    }

    void setData(AdHocCommandData adHocCommandData) {
        this.data = adHocCommandData;
    }

    AdHocCommandData getData() {
        return this.data;
    }

    protected boolean isValidAction(Action action) {
        return getActions().contains(action) || Action.cancel.equals(action);
    }

    public enum SpecificErrorCondition {
        badAction("bad-action"),
        malformedAction("malformed-action"),
        badLocale("bad-locale"),
        badPayload("bad-payload"),
        badSessionid("bad-sessionid"),
        sessionExpired("session-expired");

        private final String value;

        SpecificErrorCondition(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }
}
