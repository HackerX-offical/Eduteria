package org.jivesoftware.smack;

import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.c2s.XmppClientToServerTransport;
import org.jivesoftware.smack.filter.StanzaFilter;
import org.jivesoftware.smack.util.Consumer;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpoint;
import org.jivesoftware.smack.util.rce.RemoteConnectionEndpointLookupFailure;
import org.jivesoftware.smack.util.rce.RemoteConnectionException;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SmackException extends Exception {
    private static final long serialVersionUID = 1844674365368214458L;

    public static class IllegalStateChangeException extends SmackException {
        private static final long serialVersionUID = -1766023961577168927L;
    }

    protected SmackException(Throwable th) {
        super(th);
    }

    protected SmackException(String str) {
        super(str);
    }

    protected SmackException(String str, Throwable th) {
        super(str, th);
    }

    protected SmackException() {
    }

    public static final class NoResponseException extends SmackException {
        private static final long serialVersionUID = -6523363748984543636L;
        private final StanzaFilter filter;

        private NoResponseException(String str) {
            this(str, null);
        }

        private NoResponseException(String str, StanzaFilter stanzaFilter) {
            super(str);
            this.filter = stanzaFilter;
        }

        public StanzaFilter getFilter() {
            return this.filter;
        }

        public static NoResponseException newWith(XMPPConnection xMPPConnection, String str) {
            StringBuilder waitingFor = getWaitingFor(xMPPConnection);
            waitingFor.append(" While waiting for ").append(str);
            waitingFor.append(" [").append(xMPPConnection).append(']');
            return new NoResponseException(waitingFor.toString());
        }

        public static NoResponseException newWith(long j, StanzaCollector stanzaCollector, boolean z) {
            return newWith(j, stanzaCollector.getStanzaFilter(), z);
        }

        public static NoResponseException newWith(XMPPConnection xMPPConnection, StanzaFilter stanzaFilter) {
            return newWith(xMPPConnection.getReplyTimeout(), stanzaFilter, false);
        }

        public static NoResponseException newWith(long j, StanzaFilter stanzaFilter, boolean z) {
            StringBuilder waitingFor = getWaitingFor(j);
            if (z) {
                waitingFor.append(" StanzaCollector has been cancelled.");
            }
            waitingFor.append(" Waited for response using: ");
            if (stanzaFilter != null) {
                waitingFor.append(stanzaFilter.toString());
            } else {
                waitingFor.append("No filter used or filter was 'null'");
            }
            waitingFor.append('.');
            return new NoResponseException(waitingFor.toString(), stanzaFilter);
        }

        private static StringBuilder getWaitingFor(XMPPConnection xMPPConnection) {
            return getWaitingFor(xMPPConnection.getReplyTimeout());
        }

        private static StringBuilder getWaitingFor(long j) {
            StringBuilder sb = new StringBuilder(256);
            sb.append("No response received within reply timeout. Timeout was " + j + "ms (~" + (j / 1000) + "s).");
            return sb;
        }
    }

    public static class NotLoggedInException extends SmackException {
        private static final long serialVersionUID = 3216216839100019278L;

        public NotLoggedInException() {
            super("Client is not logged in");
        }
    }

    public static class AlreadyLoggedInException extends SmackException {
        private static final long serialVersionUID = 5011416918049935231L;

        public AlreadyLoggedInException() {
            super("Client is already logged in");
        }
    }

    public static class AlreadyConnectedException extends SmackException {
        private static final long serialVersionUID = 5011416918049135231L;

        public AlreadyConnectedException() {
            super("Client is already connected");
        }
    }

    public static class NotConnectedException extends SmackException {
        private static final long serialVersionUID = 9197980400776001173L;

        public NotConnectedException() {
            this(null);
        }

        public NotConnectedException(String str) {
            super("Client is not, or no longer, connected." + (str != null ? " " + str : ""));
        }

        public NotConnectedException(XMPPConnection xMPPConnection, String str) {
            super("The connection " + xMPPConnection.toString() + " is no longer connected. " + str);
        }

        public NotConnectedException(XMPPConnection xMPPConnection, StanzaFilter stanzaFilter) {
            super("The connection " + xMPPConnection + " is no longer connected while waiting for response with " + stanzaFilter);
        }

        public NotConnectedException(XMPPConnection xMPPConnection, StanzaFilter stanzaFilter, Exception exc) {
            super("The connection " + xMPPConnection + " is no longer connected while waiting for response with " + stanzaFilter + " because of " + exc, exc);
        }
    }

    public static abstract class SecurityRequiredException extends SmackException {
        private static final long serialVersionUID = 384291845029773545L;

        public SecurityRequiredException(String str) {
            super(str);
        }
    }

    public static class SecurityRequiredByClientException extends SecurityRequiredException {
        private static final long serialVersionUID = 2395325821201543159L;

        public SecurityRequiredByClientException() {
            super("SSL/TLS required by client but not supported by server");
        }
    }

    public static class SecurityRequiredByServerException extends SecurityRequiredException {
        private static final long serialVersionUID = 8268148813117631819L;

        public SecurityRequiredByServerException() {
            super("SSL/TLS required by server but disabled in client");
        }
    }

    public static class SecurityNotPossibleException extends SmackException {
        private static final long serialVersionUID = -6836090872690331336L;

        public SecurityNotPossibleException(String str) {
            super(str);
        }
    }

    public static abstract class ConnectionException extends SmackException {
        private static final long serialVersionUID = 1;

        protected ConnectionException(Throwable th) {
            super(th);
        }

        protected ConnectionException(String str) {
            super(str);
        }
    }

    public static final class GenericConnectionException extends ConnectionException {
        private static final long serialVersionUID = 1;

        @Deprecated
        public GenericConnectionException(Throwable th) {
            super(th);
        }
    }

    public static final class EndpointConnectionException extends ConnectionException {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long serialVersionUID = 1;
        private final List<? extends RemoteConnectionException<?>> connectionExceptions;
        private final List<RemoteConnectionEndpointLookupFailure> lookupFailures;

        private EndpointConnectionException(String str, List<RemoteConnectionEndpointLookupFailure> list, List<? extends RemoteConnectionException<?>> list2) {
            super(str);
            this.lookupFailures = list;
            this.connectionExceptions = list2;
        }

        public static EndpointConnectionException from(List<RemoteConnectionEndpointLookupFailure> list, List<? extends RemoteConnectionException<?>> list2) {
            final StringBuilder sb = new StringBuilder(256);
            if (!list.isEmpty()) {
                sb.append("Could not lookup the following endpoints: ");
                StringUtils.appendTo(list, sb);
            }
            if (!list2.isEmpty()) {
                sb.append("The following addresses failed: ");
                StringUtils.appendTo(list2, sb, new Consumer() { // from class: org.jivesoftware.smack.SmackException$EndpointConnectionException$$ExternalSyntheticLambda0
                    @Override // org.jivesoftware.smack.util.Consumer
                    public final void accept(Object obj) {
                        sb.append(((RemoteConnectionException) obj).getErrorMessage());
                    }
                });
            }
            return new EndpointConnectionException(sb.toString(), list, list2);
        }

        public List<RemoteConnectionEndpointLookupFailure> getLookupFailures() {
            return this.lookupFailures;
        }

        public List<? extends RemoteConnectionException<? extends RemoteConnectionEndpoint>> getConnectionExceptions() {
            return this.connectionExceptions;
        }
    }

    public static final class NoEndpointsDiscoveredException extends ConnectionException {
        private static final long serialVersionUID = 1;
        private final List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> lookupFailures;

        private NoEndpointsDiscoveredException(String str, List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> list) {
            super(str);
            this.lookupFailures = Collections.unmodifiableList(list);
        }

        public List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> getLookupFailures() {
            return this.lookupFailures;
        }

        public static NoEndpointsDiscoveredException from(List<XmppClientToServerTransport.LookupConnectionEndpointsFailed> list) {
            StringBuilder sb = new StringBuilder();
            if (list.isEmpty()) {
                sb.append("No endpoint lookup finished within the timeout");
            } else {
                sb.append("No endpoints could be discovered due the following lookup failures: ");
                StringUtils.appendTo(list, sb);
            }
            return new NoEndpointsDiscoveredException(sb.toString(), list);
        }
    }

    public static class FeatureNotSupportedException extends SmackException {
        private static final long serialVersionUID = 4713404802621452016L;
        private final String feature;
        private final Jid jid;

        public FeatureNotSupportedException(String str) {
            this(str, null);
        }

        public FeatureNotSupportedException(String str, Jid jid) {
            super(str + " not supported" + (jid == null ? "" : " by '" + ((Object) jid) + "'"));
            this.jid = jid;
            this.feature = str;
        }

        public String getFeature() {
            return this.feature;
        }

        public Jid getJid() {
            return this.jid;
        }
    }

    public static class ResourceBindingNotOfferedException extends SmackException {
        private static final long serialVersionUID = 2346934138253437571L;

        public ResourceBindingNotOfferedException() {
            super("Resource binding was not offered by server");
        }
    }

    public static class SmackWrappedException extends SmackException {
        private static final long serialVersionUID = 1;

        public SmackWrappedException(Exception exc) {
            super(exc);
        }

        public SmackWrappedException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static class SmackMessageException extends SmackException {
        private static final long serialVersionUID = 1;

        public SmackMessageException(String str) {
            super(str);
        }
    }

    public static class SmackSaslException extends SmackException {
        private static final long serialVersionUID = 1;

        public SmackSaslException(Exception exc) {
            super(exc);
        }

        public SmackSaslException(String str) {
            super(str);
        }

        public SmackSaslException(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static class SmackCertificateException extends SmackException {
        private static final long serialVersionUID = 1;
        private final CertificateException certificateException;

        public SmackCertificateException(CertificateException certificateException) {
            this.certificateException = certificateException;
        }

        public CertificateException getCertificateException() {
            return this.certificateException;
        }
    }
}
