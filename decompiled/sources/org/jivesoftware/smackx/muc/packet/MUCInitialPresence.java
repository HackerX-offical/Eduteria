package org.jivesoftware.smackx.muc.packet;

import java.util.Date;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.last_interaction.element.IdleElement;
import org.jxmpp.util.XmppDateTime;

/* JADX INFO: loaded from: classes10.dex */
public class MUCInitialPresence implements ExtensionElement {
    public static final String ELEMENT = "x";
    public static final String NAMESPACE = "http://jabber.org/protocol/muc";
    public static final QName QNAME = new QName("http://jabber.org/protocol/muc", "x");
    private History history;
    private String password;

    @Deprecated
    public MUCInitialPresence() {
    }

    public MUCInitialPresence(String str, int i, int i2, int i3, Date date) {
        this.password = str;
        if (i > -1 || i2 > -1 || i3 > -1 || date != null) {
            this.history = new History(i, i2, i3, date);
        } else {
            this.history = null;
        }
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "x";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "http://jabber.org/protocol/muc";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement("password", getPassword());
        xmlStringBuilder.optElement(getHistory());
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public History getHistory() {
        return this.history;
    }

    public String getPassword() {
        return this.password;
    }

    @Deprecated
    public void setHistory(History history) {
        this.history = history;
    }

    @Deprecated
    public void setPassword(String str) {
        this.password = str;
    }

    @Deprecated
    public static MUCInitialPresence getFrom(Stanza stanza) {
        return from(stanza);
    }

    public static MUCInitialPresence from(Stanza stanza) {
        return (MUCInitialPresence) stanza.getExtension(MUCInitialPresence.class);
    }

    public static class History implements NamedElement {
        public static final String ELEMENT = "history";
        private final int maxChars;
        private final int maxStanzas;
        private final int seconds;
        private final Date since;

        public History(int i, int i2, int i3, Date date) {
            if (i < 0 && i2 < 0 && i3 < 0 && date == null) {
                throw new IllegalArgumentException();
            }
            this.maxChars = i;
            this.maxStanzas = i2;
            this.seconds = i3;
            this.since = date;
        }

        public int getMaxChars() {
            return this.maxChars;
        }

        public int getMaxStanzas() {
            return this.maxStanzas;
        }

        public int getSeconds() {
            return this.seconds;
        }

        public Date getSince() {
            return this.since;
        }

        @Override // org.jivesoftware.smack.packet.Element
        public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
            xmlStringBuilder.optIntAttribute("maxchars", getMaxChars());
            xmlStringBuilder.optIntAttribute("maxstanzas", getMaxStanzas());
            xmlStringBuilder.optIntAttribute("seconds", getSeconds());
            if (getSince() != null) {
                xmlStringBuilder.attribute(IdleElement.ATTR_SINCE, XmppDateTime.formatXEP0082Date(getSince()));
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }

        @Override // org.jivesoftware.smack.packet.NamedElement
        public String getElementName() {
            return ELEMENT;
        }
    }
}
