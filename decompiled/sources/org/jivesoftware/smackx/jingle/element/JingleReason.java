package org.jivesoftware.smackx.jingle.element;

import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class JingleReason implements FullyQualifiedElement {
    public static final String ELEMENT = "reason";
    public static final String NAMESPACE = "urn:xmpp:jingle:1";
    protected final Reason reason;
    public static final JingleReason Busy = new JingleReason(Reason.busy);
    public static final JingleReason Cancel = new JingleReason(Reason.cancel);
    public static final JingleReason ConnectivityError = new JingleReason(Reason.connectivity_error);
    public static final JingleReason Decline = new JingleReason(Reason.decline);
    public static final JingleReason Expired = new JingleReason(Reason.expired);
    public static final JingleReason FailedApplication = new JingleReason(Reason.failed_application);
    public static final JingleReason FailedTransport = new JingleReason(Reason.failed_transport);
    public static final JingleReason GeneralError = new JingleReason(Reason.general_error);
    public static final JingleReason Gone = new JingleReason(Reason.gone);
    public static final JingleReason IncompatibleParameters = new JingleReason(Reason.incompatible_parameters);
    public static final JingleReason MediaError = new JingleReason(Reason.media_error);
    public static final JingleReason SecurityError = new JingleReason(Reason.security_error);
    public static final JingleReason Success = new JingleReason(Reason.success);
    public static final JingleReason Timeout = new JingleReason(Reason.timeout);
    public static final JingleReason UnsupportedApplications = new JingleReason(Reason.unsupported_applications);
    public static final JingleReason UnsupportedTransports = new JingleReason(Reason.unsupported_transports);

    public static AlternativeSession AlternativeSession(String str) {
        return new AlternativeSession(str);
    }

    public enum Reason {
        alternative_session,
        busy,
        cancel,
        connectivity_error,
        decline,
        expired,
        failed_application,
        failed_transport,
        general_error,
        gone,
        incompatible_parameters,
        media_error,
        security_error,
        success,
        timeout,
        unsupported_applications,
        unsupported_transports;

        protected static final Map<String, Reason> LUT = new HashMap(values().length);
        protected final String asString = name().replace('_', '-');

        static {
            for (Reason reason : values()) {
                LUT.put(reason.toString(), reason);
            }
        }

        Reason() {
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.asString;
        }

        public static Reason fromString(String str) {
            Reason reason = LUT.get(str);
            if (reason != null) {
                return reason;
            }
            throw new IllegalArgumentException("Unknown reason: " + str);
        }
    }

    public JingleReason(Reason reason) {
        this.reason = reason;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "reason";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:jingle:1";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.emptyElement(this.reason);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public Reason asEnum() {
        return this.reason;
    }

    public static class AlternativeSession extends JingleReason {
        public static final String SID = "sid";
        private final String sessionId;

        public AlternativeSession(String str) {
            super(Reason.alternative_session);
            if (StringUtils.isNullOrEmpty(str)) {
                throw new NullPointerException("SessionID must not be null or empty.");
            }
            this.sessionId = str;
        }

        @Override // org.jivesoftware.smackx.jingle.element.JingleReason, org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.openElement(this.reason.asString);
            xmlStringBuilder.openElement("sid");
            xmlStringBuilder.append((CharSequence) this.sessionId);
            xmlStringBuilder.closeElement("sid");
            xmlStringBuilder.closeElement(this.reason.asString);
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public String getAlternativeSessionId() {
            return this.sessionId;
        }
    }
}
