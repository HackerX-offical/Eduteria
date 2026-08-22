package org.jivesoftware.smack.packet;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes10.dex */
public final class StreamClose implements Nonza {
    public static final StreamClose INSTANCE = new StreamClose();

    private StreamClose() {
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        return "</" + getElementName() + Typography.greater;
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "(none)";
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return StreamOpen.ELEMENT;
    }
}
