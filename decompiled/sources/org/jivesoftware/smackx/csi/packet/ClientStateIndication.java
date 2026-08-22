package org.jivesoftware.smackx.csi.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Nonza;
import org.jivesoftware.smack.packet.XmlEnvironment;

/* JADX INFO: loaded from: classes10.dex */
public class ClientStateIndication {
    public static final String NAMESPACE = "urn:xmpp:csi:0";

    public static final class Active implements Nonza {
        public static final String ELEMENT = "active";
        public static final Active INSTANCE = new Active();

        private Active() {
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ClientStateIndication.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "active";
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<active xmlns='urn:xmpp:csi:0'/>";
        }
    }

    public static final class Inactive implements Nonza {
        public static final String ELEMENT = "inactive";
        public static final Inactive INSTANCE = new Inactive();

        private Inactive() {
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ClientStateIndication.NAMESPACE;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<inactive xmlns='urn:xmpp:csi:0'/>";
        }
    }

    public static final class Feature implements ExtensionElement {
        public static final String ELEMENT = "csi";
        public static final Feature INSTANCE = new Feature();

        private Feature() {
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public String toXML(XmlEnvironment xmlEnvironment) {
            return "<csi xmlns='urn:xmpp:csi:0'/>";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return ClientStateIndication.NAMESPACE;
        }
    }
}
