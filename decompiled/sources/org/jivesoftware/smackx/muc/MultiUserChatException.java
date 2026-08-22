package org.jivesoftware.smackx.muc;

import org.jivesoftware.smack.SmackException;
import org.jxmpp.jid.DomainBareJid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MultiUserChatException extends SmackException {
    private static final long serialVersionUID = 1;

    public static class MissingMucCreationAcknowledgeException extends MultiUserChatException {
        private static final long serialVersionUID = 1;
    }

    public static class MucAlreadyJoinedException extends MultiUserChatException {
        private static final long serialVersionUID = 1;
    }

    protected MultiUserChatException() {
    }

    protected MultiUserChatException(String str) {
        super(str);
    }

    public static class MucNotJoinedException extends MultiUserChatException {
        private static final long serialVersionUID = 1;

        public MucNotJoinedException(MultiUserChat multiUserChat) {
            super("Client not currently joined " + ((Object) multiUserChat.getRoom()));
        }
    }

    public static class MucConfigurationNotSupportedException extends MultiUserChatException {
        private static final long serialVersionUID = 1;

        public MucConfigurationNotSupportedException(String str) {
            super("The MUC configuration '" + str + "' is not supported by the MUC service");
        }
    }

    public static class NotAMucServiceException extends MultiUserChatException {
        private static final long serialVersionUID = 1;

        NotAMucServiceException(DomainBareJid domainBareJid) {
            super("Can't perform operation because " + ((Object) domainBareJid) + " does not provide a MUC (XEP-45) service.");
        }

        NotAMucServiceException(MultiUserChat multiUserChat) {
            super("Can not join '" + ((Object) multiUserChat.getRoom()) + "', because '" + ((Object) multiUserChat.getRoom().asDomainBareJid()) + "' does not provide a MUC (XEP-45) service.");
        }
    }
}
