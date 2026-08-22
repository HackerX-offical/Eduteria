package org.jivesoftware.smackx.last_interaction.element;

import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class IdleElement implements ExtensionElement {
    public static final String ATTR_SINCE = "since";
    private final Date since;
    public static final String NAMESPACE = "urn:xmpp:idle:1";
    public static final String ELEMENT = "idle";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);

    public IdleElement() {
        this(new Date());
    }

    public IdleElement(Date date) {
        this.since = (Date) Objects.requireNonNull(date);
    }

    public Date getSince() {
        return this.since;
    }

    public static void addToPresence(Presence presence) {
        presence.addExtension(new IdleElement());
    }

    public static IdleElement fromPresence(Presence presence) {
        return (IdleElement) presence.getExtension(IdleElement.class);
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).attribute(ATTR_SINCE, this.since).closeEmptyElement();
    }
}
