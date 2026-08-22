package org.jivesoftware.smackx.hoxt.packet;

import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Base64BinaryChunk implements ExtensionElement {
    public static final String ATTRIBUTE_LAST = "last";
    public static final String ATTRIBUTE_NR = "nr";
    public static final String ATTRIBUTE_STREAM_ID = "streamId";
    public static final String ELEMENT_CHUNK = "chunk";
    public static final QName QNAME = new QName("urn:xmpp:http", ELEMENT_CHUNK);
    private final boolean last;
    private final int nr;
    private final String streamId;
    private final String text;

    public Base64BinaryChunk(String str, String str2, int i, boolean z) {
        this.text = (String) Objects.requireNonNull(str, "text must not be null");
        this.streamId = (String) Objects.requireNonNull(str2, "streamId must not be null");
        if (i < 0) {
            throw new IllegalArgumentException("nr must be a non negative integer");
        }
        this.nr = i;
        this.last = z;
    }

    public Base64BinaryChunk(String str, String str2, int i) {
        this(str, str2, i, false);
    }

    public String getStreamId() {
        return this.streamId;
    }

    public boolean isLast() {
        return this.last;
    }

    public String getText() {
        return this.text;
    }

    public int getNr() {
        return this.nr;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return QNAME.getLocalPart();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(ATTRIBUTE_STREAM_ID, this.streamId);
        xmlStringBuilder.attribute(ATTRIBUTE_NR, this.nr);
        xmlStringBuilder.optBooleanAttribute("last", this.last);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append((CharSequence) this.text);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
