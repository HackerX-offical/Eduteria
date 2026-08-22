package org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.jingle.element.JingleContentTransportInfo;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleS5BTransportInfo implements JingleContentTransportInfo {
    public static final String NAMESPACE = "urn:xmpp:jingle:transports:s5b:1";

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public final String getNamespace() {
        return "urn:xmpp:jingle:transports:s5b:1";
    }

    public static abstract class JingleS5BCandidateTransportInfo extends JingleS5BTransportInfo {
        public static final String ATTR_CID = "cid";
        private final String candidateId;

        protected JingleS5BCandidateTransportInfo(String str) {
            this.candidateId = str;
        }

        public final String getCandidateId() {
            return this.candidateId;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
            xmlStringBuilder.attribute("cid", getCandidateId());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof JingleS5BCandidateTransportInfo) {
                return toXML().toString().equals(((JingleS5BCandidateTransportInfo) obj).toXML().toString());
            }
            return false;
        }

        public final int hashCode() {
            return getCandidateId().toString().hashCode();
        }
    }

    public static final class CandidateActivated extends JingleS5BCandidateTransportInfo {
        public static final String ELEMENT = "candidate-activated";

        public CandidateActivated(String str) {
            super(str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static final class CandidateUsed extends JingleS5BCandidateTransportInfo {
        public static final String ELEMENT = "candidate-used";

        public CandidateUsed(String str) {
            super(str);
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }

    public static final class CandidateError extends JingleS5BTransportInfo {
        public static final String ELEMENT = "candidate-error";
        public static final CandidateError INSTANCE = new CandidateError();

        private CandidateError() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement(this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public boolean equals(Object obj) {
            return obj == INSTANCE;
        }

        public int hashCode() {
            return toXML().toString().hashCode();
        }
    }

    public static final class ProxyError extends JingleS5BTransportInfo {
        public static final String ELEMENT = "proxy-error";
        public static final ProxyError INSTANCE = new ProxyError();

        private ProxyError() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement(this);
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        public boolean equals(Object obj) {
            return obj == INSTANCE;
        }

        public int hashCode() {
            return toXML().toString().hashCode();
        }
    }
}
