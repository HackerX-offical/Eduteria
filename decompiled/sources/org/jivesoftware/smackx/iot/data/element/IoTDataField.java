package org.jivesoftware.smackx.iot.data.element;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class IoTDataField extends IoTDataExtensionElement {
    private final String name;
    private final Type type;
    private String valueString;

    protected abstract String getValueInternal();

    enum Type {
        integer("int"),
        bool("boolean");

        private final String stringRepresentation;

        Type(String str) {
            this.stringRepresentation = str;
        }
    }

    protected IoTDataField(Type type, String str) {
        this.type = type;
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public final String getElementName() {
        return this.type.stringRepresentation;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        xmlStringBuilder.attribute("name", this.name).attribute("value", getValueString());
        xmlStringBuilder.closeEmptyElement();
        return xmlStringBuilder;
    }

    public final String getValueString() {
        if (this.valueString == null) {
            this.valueString = getValueInternal();
        }
        return this.valueString;
    }

    public static class IntField extends IoTDataField {
        private final int value;

        @Override // org.jivesoftware.smackx.iot.data.element.IoTDataField, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return super.toXML(xmlEnvironment);
        }

        public IntField(String str, int i) {
            super(Type.integer, str);
            this.value = i;
        }

        @Override // org.jivesoftware.smackx.iot.data.element.IoTDataField
        protected String getValueInternal() {
            return Integer.toString(this.value);
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class BooleanField extends IoTDataField {
        private final boolean value;

        @Override // org.jivesoftware.smackx.iot.data.element.IoTDataField, org.jivesoftware.smack.packet.Element
        public /* bridge */ /* synthetic */ CharSequence toXML(XmlEnvironment xmlEnvironment) {
            return super.toXML(xmlEnvironment);
        }

        public BooleanField(String str, boolean z) {
            super(Type.bool, str);
            this.value = z;
        }

        @Override // org.jivesoftware.smackx.iot.data.element.IoTDataField
        protected String getValueInternal() {
            return Boolean.toString(this.value);
        }

        public boolean getValue() {
            return this.value;
        }
    }
}
