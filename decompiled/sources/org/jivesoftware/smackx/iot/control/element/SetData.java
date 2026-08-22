package org.jivesoftware.smackx.iot.control.element;

import java.util.Locale;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class SetData implements ExtensionElement {
    private final String name;
    private final Type type;
    private final String value;

    public enum Type {
        BOOL,
        INT,
        LONG,
        DOUBLE;

        private final String toStringCache = name().toLowerCase(Locale.US);

        Type() {
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toStringCache;
        }
    }

    protected SetData(String str, Type type, String str2) {
        this.name = str;
        this.type = type;
        this.value = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public final String getElementName() {
        return getType().toString();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public final String getNamespace() {
        return "urn:xmpp:iot:control";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("name", this.name);
        xmlStringBuilder.attribute("value", this.value);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }
}
