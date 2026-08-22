package org.jivesoftware.smackx.jingle_filetransfer.element;

import org.jivesoftware.smack.packet.FullyQualifiedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.hashes.element.HashElement;

/* JADX INFO: loaded from: classes10.dex */
public class Range implements FullyQualifiedElement {
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_OFFSET = "offset";
    public static final String ELEMENT = "range";
    public static final String NAMESPACE = "urn:xmpp:jingle:apps:file-transfer:5";
    private final HashElement hash;
    private final Integer length;
    private final Integer offset;

    public Range() {
        this(null, null, null);
    }

    public Range(int i) {
        this(null, Integer.valueOf(i), null);
    }

    public Range(int i, int i2) {
        this(Integer.valueOf(i), Integer.valueOf(i2), null);
    }

    public Range(Integer num, Integer num2, HashElement hashElement) {
        this.offset = num;
        this.length = num2;
        this.hash = hashElement;
    }

    public int getOffset() {
        return this.offset.intValue();
    }

    public int getLength() {
        return this.length.intValue();
    }

    public HashElement getHash() {
        return this.hash;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "range";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:jingle:apps:file-transfer:5";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public CharSequence toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
        xmlStringBuilder.optAttribute("offset", this.offset);
        xmlStringBuilder.optAttribute(ATTR_LENGTH, this.length);
        if (this.hash != null) {
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.append(this.hash);
            xmlStringBuilder.closeElement(this);
            return xmlStringBuilder;
        }
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Range)) {
            Range range = (Range) obj;
            if (getOffset() == range.getOffset() && getLength() == range.getLength() && getHash().equals(range.getHash())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return toXML().toString().hashCode();
    }
}
