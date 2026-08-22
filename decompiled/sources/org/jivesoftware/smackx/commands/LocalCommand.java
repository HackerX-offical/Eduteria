package org.jivesoftware.smackx.commands;

import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class LocalCommand extends AdHocCommand {
    private final long creationDate = System.currentTimeMillis();
    private int currentStage = -1;
    private Jid ownerJID;
    private String sessionID;

    public abstract boolean hasPermission(Jid jid);

    public abstract boolean isLastStage();

    public void setSessionID(String str) {
        this.sessionID = str;
        getData().setSessionID(str);
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setOwnerJID(Jid jid) {
        this.ownerJID = jid;
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    public Jid getOwnerJID() {
        return this.ownerJID;
    }

    public long getCreationDate() {
        return this.creationDate;
    }

    public int getCurrentStage() {
        return this.currentStage;
    }

    @Override // org.jivesoftware.smackx.commands.AdHocCommand
    void setData(AdHocCommandData adHocCommandData) {
        adHocCommandData.setSessionID(this.sessionID);
        super.setData(adHocCommandData);
    }

    void incrementStage() {
        this.currentStage++;
    }

    void decrementStage() {
        this.currentStage--;
    }
}
