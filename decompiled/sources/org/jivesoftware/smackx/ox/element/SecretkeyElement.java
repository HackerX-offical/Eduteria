package org.jivesoftware.smackx.ox.element;

import java.nio.charset.Charset;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class SecretkeyElement implements ExtensionElement {
    public static final String ELEMENT = "secretkey";
    public static final String NAMESPACE = "urn:xmpp:openpgp:0";
    private final byte[] b64Data;

    public SecretkeyElement(byte[] bArr) {
        this.b64Data = (byte[]) Objects.requireNonNull(bArr);
    }

    public byte[] getB64Data() {
        return this.b64Data;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).rightAngleBracket().append((CharSequence) new String(this.b64Data, Charset.forName("UTF-8"))).closeElement(this);
    }
}
