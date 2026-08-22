package org.jivesoftware.smackx.ox.element;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.ox.util.Util;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpElement implements ExtensionElement {
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    private final String base64EncodedOpenPgpMessage;
    public static final String ELEMENT = "openpgp";
    public static final QName QNAME = new QName("urn:xmpp:openpgp:0", ELEMENT);

    public OpenPgpElement(String str) {
        this.base64EncodedOpenPgpMessage = (String) StringUtils.requireNotNullNorEmpty(str, "base64 encoded message MUST NOT be null nor empty.");
    }

    public InputStream toInputStream() {
        return new ByteArrayInputStream(this.base64EncodedOpenPgpMessage.getBytes(Util.UTF8));
    }

    public String getEncryptedBase64MessageContent() {
        return this.base64EncodedOpenPgpMessage;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public QName getQName() {
        return QNAME;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket().append((CharSequence) this.base64EncodedOpenPgpMessage).closeElement(this);
        return xmlStringBuilder;
    }

    public static OpenPgpElement fromStanza(Stanza stanza) {
        return (OpenPgpElement) stanza.getExtension(OpenPgpElement.class);
    }
}
