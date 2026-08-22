package org.jivesoftware.smack.sasl.packet;

import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.AbstractError;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.SASLError;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public interface SaslNonza extends Nonza {
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-sasl";

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    default String getNamespace() {
        return "urn:ietf:params:xml:ns:xmpp-sasl";
    }

    public static class AuthMechanism implements SaslNonza {
        public static final String ELEMENT = "auth";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", "auth");
        private final String authenticationText;
        private final String mechanism;

        public AuthMechanism(String str, String str2) {
            this.mechanism = (String) Objects.requireNonNull(str, "SASL mechanism shouldn't be null.");
            this.authenticationText = (String) StringUtils.requireNotNullNorEmpty(str2, "SASL authenticationText must not be null nor empty (RFC6120 6.4.2)");
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("mechanism", this.mechanism).rightAngleBracket();
            xmlStringBuilder.escape(this.authenticationText);
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public String getMechanism() {
            return this.mechanism;
        }

        public String getAuthenticationText() {
            return this.authenticationText;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "auth";
        }
    }

    public static class Challenge implements SaslNonza {
        public static final String ELEMENT = "challenge";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", "challenge");
        private final String data;

        public Challenge(String str) {
            this.data = StringUtils.returnIfNotEmptyTrimmed(str);
        }

        public String getData() {
            return this.data;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.data, this);
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "challenge";
        }
    }

    public static class Response implements SaslNonza {
        public static final String ELEMENT = "response";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", ELEMENT);
        private final String authenticationText;

        public Response() {
            this.authenticationText = null;
        }

        public Response(String str) {
            this.authenticationText = StringUtils.returnIfNotEmptyTrimmed(str);
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.authenticationText, this);
            return xmlStringBuilder;
        }

        public String getAuthenticationText() {
            return this.authenticationText;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static class Success implements SaslNonza {
        public static final String ELEMENT = "success";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", "success");
        private final String data;

        public Success(String str) {
            this.data = StringUtils.returnIfNotEmptyTrimmed(str);
        }

        public String getData() {
            return this.data;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.optTextChild(this.data, this);
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "success";
        }
    }

    public static class SASLFailure extends AbstractError implements SaslNonza {
        public static final String ELEMENT = "failure";
        public static final QName QNAME = new QName("urn:ietf:params:xml:ns:xmpp-sasl", "failure");
        private final SASLError saslError;
        private final String saslErrorString;

        public SASLFailure(String str) {
            this(str, null);
        }

        public SASLFailure(String str, Map<String, String> map) {
            super(map);
            SASLError sASLErrorFromString = SASLError.fromString(str);
            if (sASLErrorFromString == null) {
                this.saslError = SASLError.not_authorized;
            } else {
                this.saslError = sASLErrorFromString;
            }
            this.saslErrorString = str;
        }

        public SASLError getSASLError() {
            return this.saslError;
        }

        public String getSASLErrorString() {
            return this.saslErrorString;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("failure").xmlnsAttribute("urn:ietf:params:xml:ns:xmpp-sasl").rightAngleBracket();
            xmlStringBuilder.emptyElement(this.saslErrorString);
            addDescriptiveTextsAndExtensions(xmlStringBuilder);
            xmlStringBuilder.closeElement("failure");
            return xmlStringBuilder;
        }

        public String toString() {
            return toXML().toString();
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "failure";
        }
    }
}
