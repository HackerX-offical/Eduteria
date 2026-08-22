package org.jivesoftware.smackx.iot.data.element;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public class TimestampElement extends IoTDataExtensionElement {
    public static final String ELEMENT = "timestamp";
    private final Date date;
    private final List<? extends IoTDataField> fields;

    public TimestampElement(Date date, List<? extends IoTDataField> list) {
        this.date = date;
        this.fields = Collections.unmodifiableList(list);
    }

    public List<? extends IoTDataField> getDataFields() {
        return this.fields;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "timestamp";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("value", this.date);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.fields);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
