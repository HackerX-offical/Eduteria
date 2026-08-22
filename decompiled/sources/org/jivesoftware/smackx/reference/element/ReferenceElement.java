package org.jivesoftware.smackx.reference.element;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.reference.ReferenceManager;
import org.jxmpp.jid.BareJid;

/* JADX INFO: loaded from: classes10.dex */
public class ReferenceElement implements ExtensionElement {
    public static final String ATTR_ANCHOR = "anchor";
    public static final String ATTR_BEGIN = "begin";
    public static final String ATTR_END = "end";
    public static final String ATTR_TYPE = "type";
    public static final String ATTR_URI = "uri";
    public static final String ELEMENT = "reference";
    private final String anchor;
    private final Integer begin;
    private final ExtensionElement child;
    private final Integer end;
    private final Type type;
    private final URI uri;

    public enum Type {
        mention,
        data
    }

    public ReferenceElement(Integer num, Integer num2, Type type, String str, URI uri, ExtensionElement extensionElement) {
        if (num != null && num.intValue() < 0) {
            throw new IllegalArgumentException("Attribute 'begin' MUST NOT be smaller than 0.");
        }
        if (num2 != null && num2.intValue() < 0) {
            throw new IllegalArgumentException("Attribute 'end' MUST NOT be smaller than 0.");
        }
        if (num != null && num2 != null && num.intValue() >= num2.intValue()) {
            throw new IllegalArgumentException("Attribute 'begin' MUST be smaller than attribute 'end'.");
        }
        Objects.requireNonNull(type);
        this.begin = num;
        this.end = num2;
        this.type = type;
        this.anchor = str;
        this.uri = uri;
        this.child = extensionElement;
    }

    public ReferenceElement(Integer num, Integer num2, Type type, String str, URI uri) {
        this(num, num2, type, str, uri, null);
    }

    public Integer getBegin() {
        return this.begin;
    }

    public Integer getEnd() {
        return this.end;
    }

    public Type getType() {
        return this.type;
    }

    public String getAnchor() {
        return this.anchor;
    }

    public URI getUri() {
        return this.uri;
    }

    public static void addMention(Stanza stanza, int i, int i2, BareJid bareJid) {
        try {
            stanza.addExtension(new ReferenceElement(Integer.valueOf(i), Integer.valueOf(i2), Type.mention, null, new URI("xmpp:" + bareJid.toString())));
        } catch (URISyntaxException unused) {
            throw new AssertionError("Cannot create URI from bareJid.");
        }
    }

    public static List<ReferenceElement> getReferencesFromStanza(Stanza stanza) {
        ArrayList arrayList = new ArrayList();
        Iterator<ExtensionElement> it = stanza.getExtensions(ELEMENT, ReferenceManager.NAMESPACE).iterator();
        while (it.hasNext()) {
            arrayList.add((ReferenceElement) it.next());
        }
        return arrayList;
    }

    public static boolean containsReferences(Stanza stanza) {
        return getReferencesFromStanza(stanza).size() > 0;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return ReferenceManager.NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        Integer num = this.begin;
        XmlStringBuilder xmlStringBuilderOptIntAttribute = xmlStringBuilder.optIntAttribute(ATTR_BEGIN, num != null ? num.intValue() : -1);
        Integer num2 = this.end;
        XmlStringBuilder xmlStringBuilderOptAttribute = xmlStringBuilderOptIntAttribute.optIntAttribute("end", num2 != null ? num2.intValue() : -1).attribute("type", this.type.toString()).optAttribute(ATTR_ANCHOR, this.anchor);
        URI uri = this.uri;
        XmlStringBuilder xmlStringBuilderOptAttribute2 = xmlStringBuilderOptAttribute.optAttribute("uri", uri != null ? uri.toString() : null);
        if (this.child == null) {
            return xmlStringBuilderOptAttribute2.closeEmptyElement();
        }
        return xmlStringBuilderOptAttribute2.rightAngleBracket().append(this.child.toXML()).closeElement(this);
    }
}
