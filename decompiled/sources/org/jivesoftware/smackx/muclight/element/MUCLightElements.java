package org.jivesoftware.smackx.muclight.element;

import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.Element;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MUCLightElements {

    public static class AffiliationsChangeExtension implements ExtensionElement {
        public static final String ELEMENT = "x";
        public static final String NAMESPACE = "urn:xmpp:muclight:0#affiliations";
        public static final QName QNAME = new QName("urn:xmpp:muclight:0#affiliations", "x");
        private final HashMap<Jid, MUCLightAffiliation> affiliations;
        private final String prevVersion;
        private final String version;

        public AffiliationsChangeExtension(HashMap<Jid, MUCLightAffiliation> map, String str, String str2) {
            this.affiliations = map;
            this.prevVersion = str;
            this.version = str2;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "x";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "urn:xmpp:muclight:0#affiliations";
        }

        public HashMap<Jid, MUCLightAffiliation> getAffiliations() {
            return this.affiliations;
        }

        public String getPrevVersion() {
            return this.prevVersion;
        }

        public String getVersion() {
            return this.version;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("prev-version", this.prevVersion);
            xmlStringBuilder.optElement("version", this.version);
            for (Map.Entry<Jid, MUCLightAffiliation> entry : this.affiliations.entrySet()) {
                xmlStringBuilder.append(new UserWithAffiliationElement(entry.getKey(), entry.getValue()));
            }
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public static AffiliationsChangeExtension from(Message message) {
            return (AffiliationsChangeExtension) message.getExtension(AffiliationsChangeExtension.class);
        }
    }

    public static class ConfigurationsChangeExtension implements ExtensionElement {
        public static final String ELEMENT = "x";
        public static final String NAMESPACE = "urn:xmpp:muclight:0#configuration";
        private final HashMap<String, String> customConfigs;
        private final String prevVersion;
        private final String roomName;
        private final String subject;
        private final String version;

        public ConfigurationsChangeExtension(String str, String str2, String str3, String str4, HashMap<String, String> map) {
            this.prevVersion = str;
            this.version = str2;
            this.roomName = str3;
            this.subject = str4;
            this.customConfigs = map;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return "x";
        }

        @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
        public String getNamespace() {
            return "urn:xmpp:muclight:0#configuration";
        }

        public String getPrevVersion() {
            return this.prevVersion;
        }

        public String getVersion() {
            return this.version;
        }

        public String getRoomName() {
            return this.roomName;
        }

        public String getSubject() {
            return this.subject;
        }

        public HashMap<String, String> getCustomConfigs() {
            return this.customConfigs;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.optElement("prev-version", this.prevVersion);
            xmlStringBuilder.optElement("version", this.version);
            xmlStringBuilder.optElement("roomname", this.roomName);
            xmlStringBuilder.optElement("subject", this.subject);
            HashMap<String, String> map = this.customConfigs;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    xmlStringBuilder.element(entry.getKey(), entry.getValue());
                }
            }
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }

        public static ConfigurationsChangeExtension from(Message message) {
            return (ConfigurationsChangeExtension) message.getExtensionElement("x", "urn:xmpp:muclight:0#configuration");
        }
    }

    public static class ConfigurationElement implements Element {
        private MUCLightRoomConfiguration configuration;

        public ConfigurationElement(MUCLightRoomConfiguration mUCLightRoomConfiguration) {
            this.configuration = mUCLightRoomConfiguration;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("configuration");
            xmlStringBuilder.element("roomname", this.configuration.getRoomName());
            xmlStringBuilder.optElement("subject", this.configuration.getSubject());
            if (this.configuration.getCustomConfigs() != null) {
                for (Map.Entry<String, String> entry : this.configuration.getCustomConfigs().entrySet()) {
                    xmlStringBuilder.element(entry.getKey(), entry.getValue());
                }
            }
            xmlStringBuilder.closeElement("configuration");
            return xmlStringBuilder;
        }
    }

    public static class OccupantsElement implements Element {
        private HashMap<Jid, MUCLightAffiliation> occupants;

        public OccupantsElement(HashMap<Jid, MUCLightAffiliation> map) {
            this.occupants = map;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.openElement("occupants");
            for (Map.Entry<Jid, MUCLightAffiliation> entry : this.occupants.entrySet()) {
                xmlStringBuilder.append(new UserWithAffiliationElement(entry.getKey(), entry.getValue()));
            }
            xmlStringBuilder.closeElement("occupants");
            return xmlStringBuilder;
        }
    }

    public static class UserWithAffiliationElement implements Element {
        private MUCLightAffiliation affiliation;
        private Jid user;

        public UserWithAffiliationElement(Jid jid, MUCLightAffiliation mUCLightAffiliation) {
            this.user = jid;
            this.affiliation = mUCLightAffiliation;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            xmlStringBuilder.halfOpenElement("user");
            xmlStringBuilder.attribute("affiliation", this.affiliation);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.user);
            xmlStringBuilder.closeElement("user");
            return xmlStringBuilder;
        }
    }

    public static class BlockingElement implements Element {
        private Boolean allow;
        private Boolean isRoom;
        private Jid jid;

        public BlockingElement(Jid jid, Boolean bool, Boolean bool2) {
            this.jid = jid;
            this.allow = bool;
            this.isRoom = bool2;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public CharSequence toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
            String str = this.isRoom.booleanValue() ? "room" : "user";
            xmlStringBuilder.halfOpenElement(str);
            xmlStringBuilder.attribute("action", this.allow.booleanValue() ? "allow" : "deny");
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(this.jid);
            xmlStringBuilder.closeElement(str);
            return xmlStringBuilder;
        }
    }
}
