package org.jivesoftware.smack;

import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.StanzaError;
import org.jivesoftware.smack.packet.StreamError;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class XMPPException extends Exception {
    private static final long serialVersionUID = 6881651633890968625L;

    protected XMPPException() {
    }

    protected XMPPException(String str) {
        super(str);
    }

    protected XMPPException(String str, Throwable th) {
        super(str, th);
    }

    public static class XMPPErrorException extends XMPPException {
        private static final long serialVersionUID = 212790389529249604L;
        private final StanzaError error;
        private final Stanza request;
        private final Stanza stanza;

        public XMPPErrorException(Stanza stanza, StanzaError stanzaError) {
            this(stanza, stanzaError, null);
        }

        public XMPPErrorException(Stanza stanza, StanzaError stanzaError, Stanza stanza2) {
            this.error = stanzaError;
            this.stanza = stanza;
            this.request = stanza2;
        }

        public StanzaError getStanzaError() {
            return this.error;
        }

        public Stanza getStanza() {
            return this.stanza;
        }

        public Stanza getRequest() {
            return this.request;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            Jid from;
            StringBuilder sb = new StringBuilder();
            Stanza stanza = this.stanza;
            if (stanza != null && (from = stanza.getFrom()) != null) {
                sb.append("XMPP error reply received from " + ((Object) from) + ": ");
            }
            sb.append(this.error);
            if (this.request != null) {
                sb.append(" as result of the following request: ");
                sb.append(this.request);
            }
            return sb.toString();
        }

        public static void ifHasErrorThenThrow(Stanza stanza) throws XMPPErrorException {
            ifHasErrorThenThrow(stanza, null);
        }

        public static void ifHasErrorThenThrow(Stanza stanza, Stanza stanza2) throws XMPPErrorException {
            StanzaError error = stanza.getError();
            if (error != null) {
                throw new XMPPErrorException(stanza, error, stanza2);
            }
        }
    }

    public static class FailedNonzaException extends XMPPException {
        private static final long serialVersionUID = 1;
        private final StanzaError.Condition condition;
        private final Nonza nonza;

        public FailedNonzaException(Nonza nonza) {
            this(nonza, null);
        }

        public FailedNonzaException(Nonza nonza, StanzaError.Condition condition) {
            this.condition = condition;
            this.nonza = nonza;
        }

        public StanzaError.Condition getCondition() {
            return this.condition;
        }

        public Nonza getNonza() {
            return this.nonza;
        }
    }

    public static class StreamErrorException extends XMPPException {
        private static final long serialVersionUID = 3400556867134848886L;
        private final StreamError streamError;

        public StreamErrorException(StreamError streamError) {
            super(streamError.getCondition().toString() + " You can read more about the meaning of this stream error at http://xmpp.org/rfcs/rfc6120.html#streams-error-conditions\n" + streamError.toString());
            this.streamError = streamError;
        }

        public StreamError getStreamError() {
            return this.streamError;
        }
    }
}
