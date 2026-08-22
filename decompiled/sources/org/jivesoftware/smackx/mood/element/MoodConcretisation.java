package org.jivesoftware.smackx.mood.element;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MoodConcretisation implements ExtensionElement {
    @Override // org.jivesoftware.smack.packet.Element
    public final XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        return new XmlStringBuilder((ExtensionElement) this).closeEmptyElement();
    }

    public String getMood() {
        return getElementName();
    }
}
