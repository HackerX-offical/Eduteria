package org.jivesoftware.smackx.iot.discovery.element;

import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Objects;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class Tag implements NamedElement {
    private final String name;
    private final Type type;
    private final String value;

    public enum Type {
        str,
        num
    }

    public Tag(String str, Type type, String str2) {
        String str3 = (String) StringUtils.requireNotNullNorEmpty(str, "name must not be null nor empty");
        this.name = str3;
        Type type2 = (Type) Objects.requireNonNull(type);
        this.type = type2;
        String str4 = (String) StringUtils.requireNotNullNorEmpty(str2, "value must not be null nor empty");
        this.value = str4;
        if (str3.length() > 32) {
            throw new IllegalArgumentException("Meta Tag names must not be longer then 32 characters (XEP-0347 § 5.2");
        }
        if (type2 == Type.str && str4.length() > 128) {
            throw new IllegalArgumentException("Meta Tag string values must not be longer then 128 characters (XEP-0347 § 5.2");
        }
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this);
        xmlStringBuilder.attribute("name", this.name);
        xmlStringBuilder.attribute("value", this.value);
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return getType().toString();
    }

    public String toString() {
        return this.name + '(' + this.type + "):" + this.value;
    }
}
