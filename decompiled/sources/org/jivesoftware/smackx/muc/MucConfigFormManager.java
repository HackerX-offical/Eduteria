package org.jivesoftware.smackx.muc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.MultiUserChatException;
import org.jivesoftware.smackx.xdata.FormField;
import org.jivesoftware.smackx.xdata.form.FillableForm;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.util.JidUtil;

/* JADX INFO: loaded from: classes10.dex */
public class MucConfigFormManager {
    public static final String FORM_TYPE = "http://jabber.org/protocol/muc#roomconfig";
    private static final String HASH_ROOMCONFIG = "#roomconfig";
    public static final String MUC_ROOMCONFIG_MEMBERSONLY = "muc#roomconfig_membersonly";
    public static final String MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM = "muc#roomconfig_passwordprotectedroom";
    public static final String MUC_ROOMCONFIG_ROOMOWNERS = "muc#roomconfig_roomowners";
    public static final String MUC_ROOMCONFIG_ROOMSECRET = "muc#roomconfig_roomsecret";
    private final FillableForm answerForm;
    private final MultiUserChat multiUserChat;
    private final List<Jid> owners;

    MucConfigFormManager(MultiUserChat multiUserChat) throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        this.multiUserChat = multiUserChat;
        FillableForm fillableForm = multiUserChat.getConfigurationForm().getFillableForm();
        this.answerForm = fillableForm;
        FormField field = fillableForm.getDataForm().getField(MUC_ROOMCONFIG_ROOMOWNERS);
        if (field != null) {
            List<? extends CharSequence> values = field.getValues();
            ArrayList arrayList = new ArrayList(values.size());
            this.owners = arrayList;
            JidUtil.jidsFrom(values, arrayList, null);
            return;
        }
        this.owners = null;
    }

    public boolean supportsRoomOwners() {
        return this.owners != null;
    }

    public MucConfigFormManager setRoomOwners(Collection<? extends Jid> collection) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (!supportsRoomOwners()) {
            throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_ROOMOWNERS);
        }
        this.owners.clear();
        this.owners.addAll(collection);
        return this;
    }

    public boolean supportsMembersOnly() {
        return this.answerForm.hasField(MUC_ROOMCONFIG_MEMBERSONLY);
    }

    public MucConfigFormManager makeMembersOnly() throws MultiUserChatException.MucConfigurationNotSupportedException {
        return setMembersOnly(true);
    }

    public MucConfigFormManager setMembersOnly(boolean z) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (!supportsMembersOnly()) {
            throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_MEMBERSONLY);
        }
        this.answerForm.setAnswer(MUC_ROOMCONFIG_MEMBERSONLY, z);
        return this;
    }

    public boolean supportsPasswordProtected() {
        return this.answerForm.hasField(MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM);
    }

    public MucConfigFormManager setAndEnablePassword(String str) throws MultiUserChatException.MucConfigurationNotSupportedException {
        return setIsPasswordProtected(true).setRoomSecret(str);
    }

    public MucConfigFormManager makePasswordProtected() throws MultiUserChatException.MucConfigurationNotSupportedException {
        return setIsPasswordProtected(true);
    }

    public MucConfigFormManager setIsPasswordProtected(boolean z) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (!supportsMembersOnly()) {
            throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM);
        }
        this.answerForm.setAnswer(MUC_ROOMCONFIG_PASSWORDPROTECTEDROOM, z);
        return this;
    }

    public MucConfigFormManager setRoomSecret(String str) throws MultiUserChatException.MucConfigurationNotSupportedException {
        if (!this.answerForm.hasField(MUC_ROOMCONFIG_ROOMSECRET)) {
            throw new MultiUserChatException.MucConfigurationNotSupportedException(MUC_ROOMCONFIG_ROOMSECRET);
        }
        this.answerForm.setAnswer(MUC_ROOMCONFIG_ROOMSECRET, str);
        return this;
    }

    public void submitConfigurationForm() throws SmackException.NotConnectedException, SmackException.NoResponseException, InterruptedException, XMPPException.XMPPErrorException {
        List<Jid> list = this.owners;
        if (list != null) {
            this.answerForm.setAnswer(MUC_ROOMCONFIG_ROOMOWNERS, JidUtil.toStringList(list));
        }
        this.multiUserChat.sendConfigurationForm(this.answerForm);
    }
}
