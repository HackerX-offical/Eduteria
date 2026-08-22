package org.jivesoftware.smackx.eme.element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.MessageBuilder;
import org.jivesoftware.smack.packet.MessageView;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class ExplicitMessageEncryptionElement implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:eme:0";
    private final String encryptionNamespace;
    private boolean isUnknownProtocol;
    private final String name;
    private ExplicitMessageEncryptionProtocol protocolCache;
    private static final Map<String, ExplicitMessageEncryptionProtocol> PROTOCOL_LUT = new HashMap();
    public static final String ELEMENT = "encryption";
    public static final QName QNAME = new QName("urn:xmpp:eme:0", ELEMENT);

    public enum ExplicitMessageEncryptionProtocol {
        openpgpV0("urn:xmpp:openpgp:0", "OpenPGP for XMPP (XEP-0373)"),
        otrV0("urn:xmpp:otr:0", "Off-the-Record Messaging (XEP-0364)"),
        omemoVAxolotl("eu.siacs.conversations.axolotl", "OMEMO Multi End Message and Object Encryption (XEP-0384)"),
        legacyOpenPGP("jabber:x:encrypted", "Legacy OpenPGP for XMPP [DANGEROUS, DO NOT USE!]");

        private final String name;
        private final String namespace;

        ExplicitMessageEncryptionProtocol(String str, String str2) {
            this.namespace = str;
            this.name = str2;
            ExplicitMessageEncryptionElement.PROTOCOL_LUT.put(str, this);
        }

        public String getNamespace() {
            return this.namespace;
        }

        public String getName() {
            return this.name;
        }

        public static ExplicitMessageEncryptionProtocol from(String str) {
            return (ExplicitMessageEncryptionProtocol) ExplicitMessageEncryptionElement.PROTOCOL_LUT.get(str);
        }
    }

    public ExplicitMessageEncryptionElement(ExplicitMessageEncryptionProtocol explicitMessageEncryptionProtocol) {
        this(explicitMessageEncryptionProtocol.getNamespace(), explicitMessageEncryptionProtocol.getName());
    }

    public ExplicitMessageEncryptionElement(String str) {
        this(str, null);
    }

    public ExplicitMessageEncryptionElement(String str, String str2) {
        this.encryptionNamespace = (String) StringUtils.requireNotNullNorEmpty(str, "encryptionNamespace must not be null");
        this.name = str2;
    }

    public ExplicitMessageEncryptionProtocol getProtocol() {
        ExplicitMessageEncryptionProtocol explicitMessageEncryptionProtocol = this.protocolCache;
        if (explicitMessageEncryptionProtocol != null) {
            return explicitMessageEncryptionProtocol;
        }
        if (this.isUnknownProtocol) {
            return null;
        }
        ExplicitMessageEncryptionProtocol explicitMessageEncryptionProtocol2 = PROTOCOL_LUT.get(this.encryptionNamespace);
        if (explicitMessageEncryptionProtocol2 == null) {
            this.isUnknownProtocol = true;
            return null;
        }
        this.protocolCache = explicitMessageEncryptionProtocol2;
        return explicitMessageEncryptionProtocol2;
    }

    public String getEncryptionNamespace() {
        return this.encryptionNamespace;
    }

    public String getName() {
        return this.name;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:eme:0";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("namespace", getEncryptionNamespace());
        xmlStringBuilder.optAttribute("name", getName());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public static ExplicitMessageEncryptionElement from(Message message) {
        return (ExplicitMessageEncryptionElement) message.getExtension(ExplicitMessageEncryptionElement.class);
    }

    public static boolean hasProtocol(MessageView messageView, String str) {
        Iterator it = messageView.getExtensions(ExplicitMessageEncryptionElement.class).iterator();
        while (it.hasNext()) {
            if (((ExplicitMessageEncryptionElement) it.next()).getEncryptionNamespace().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasProtocol(MessageView messageView, ExplicitMessageEncryptionProtocol explicitMessageEncryptionProtocol) {
        return hasProtocol(messageView, explicitMessageEncryptionProtocol.namespace);
    }

    public static void set(MessageBuilder messageBuilder, ExplicitMessageEncryptionProtocol explicitMessageEncryptionProtocol) {
        if (hasProtocol(messageBuilder, explicitMessageEncryptionProtocol.namespace)) {
            return;
        }
        messageBuilder.addExtension(new ExplicitMessageEncryptionElement(explicitMessageEncryptionProtocol));
    }
}
