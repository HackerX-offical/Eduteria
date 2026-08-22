package org.jivesoftware.smackx.ox.element;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.MultiMap;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.PacketUtil;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jxmpp.jid.Jid;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public abstract class OpenPgpContentElement implements ExtensionElement {
    public static final String ATTR_JID = "jid";
    public static final String ATTR_STAMP = "stamp";
    public static final String ELEM_PAYLOAD = "payload";
    public static final String ELEM_TIME = "time";
    public static final String ELEM_TO = "to";
    private final MultiMap<QName, ExtensionElement> payload = new MultiMap<>();
    private final Date timestamp;
    private String timestampString;
    private final Set<? extends Jid> to;

    protected OpenPgpContentElement(Set<? extends Jid> set, Date date, List<ExtensionElement> list) {
        this.to = set;
        this.timestamp = (Date) Objects.requireNonNull(date);
        for (ExtensionElement extensionElement : list) {
            this.payload.put(extensionElement.getQName(), extensionElement);
        }
    }

    public final Set<? extends Jid> getTo() {
        return this.to;
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final List<ExtensionElement> getExtensions() {
        List<ExtensionElement> listValues;
        synchronized (this.payload) {
            listValues = this.payload.values();
        }
        return listValues;
    }

    public List<ExtensionElement> getExtensions(String str, String str2) {
        return this.payload.getAll(new QName(str2, str));
    }

    public ExtensionElement getExtension(String str) {
        return PacketUtil.extensionElementFrom(getExtensions(), null, str);
    }

    public <PE extends ExtensionElement> PE getExtension(String str, String str2) {
        PE pe;
        if (str2 == null) {
            return null;
        }
        QName qName = new QName(str2, str);
        synchronized (this.payload) {
            pe = (PE) this.payload.getFirst(qName);
        }
        if (pe == null) {
            return null;
        }
        return pe;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:openpgp:0";
    }

    protected void ensureTimestampStringSet() {
        if (this.timestampString != null) {
            return;
        }
        this.timestampString = XmppDateTime.formatXEP0082Date(this.timestamp);
    }

    protected void addCommonXml(XmlStringBuilder xmlStringBuilder) {
        Set<? extends Jid> setEmptySet = this.to;
        if (setEmptySet == null) {
            setEmptySet = Collections.emptySet();
        }
        Iterator<? extends Jid> it = setEmptySet.iterator();
        while (it.hasNext()) {
            xmlStringBuilder.halfOpenElement("to").attribute("jid", it.next()).closeEmptyElement();
        }
        ensureTimestampStringSet();
        xmlStringBuilder.halfOpenElement("time").attribute("stamp", this.timestampString).closeEmptyElement();
        xmlStringBuilder.openElement("payload");
        Iterator<ExtensionElement> it2 = this.payload.values().iterator();
        while (it2.hasNext()) {
            xmlStringBuilder.append(it2.next().toXML(getNamespace()));
        }
        xmlStringBuilder.closeElement("payload");
    }

    public InputStream toInputStream() {
        return new ByteArrayInputStream(toXML().toString().getBytes(Charset.forName("UTF-8")));
    }
}
