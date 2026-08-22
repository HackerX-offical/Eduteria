package org.jivesoftware.smackx.forward.packet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

/* JADX INFO: loaded from: classes10.dex */
public class Forwarded<S extends Stanza> implements ExtensionElement {
    private final DelayInformation delay;
    private final S forwardedStanza;
    public static final String NAMESPACE = "urn:xmpp:forward:0";
    public static final String ELEMENT = "forwarded";
    public static final QName QNAME = new QName(NAMESPACE, ELEMENT);

    @Deprecated
    public Forwarded(DelayInformation delayInformation, S s) {
        this(s, delayInformation);
    }

    public Forwarded(S s) {
        this(s, (DelayInformation) null);
    }

    public Forwarded(S s, DelayInformation delayInformation) {
        this.forwardedStanza = (S) Objects.requireNonNull(s);
        this.delay = delayInformation;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return NAMESPACE;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(getDelayInformation());
        xmlStringBuilder.append(this.forwardedStanza);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public S getForwardedStanza() {
        return this.forwardedStanza;
    }

    public DelayInformation getDelayInformation() {
        return this.delay;
    }

    public boolean isForwarded(Class<? extends Stanza> cls) {
        return cls.isAssignableFrom(this.forwardedStanza.getClass());
    }

    public static Forwarded<?> from(Stanza stanza) {
        return (Forwarded) stanza.getExtension(Forwarded.class);
    }

    public static List<Message> extractMessagesFrom(Collection<Forwarded<Message>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<Forwarded<Message>> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Message) it.next().getForwardedStanza());
        }
        return arrayList;
    }
}
