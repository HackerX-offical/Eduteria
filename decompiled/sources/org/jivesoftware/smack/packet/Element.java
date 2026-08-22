package org.jivesoftware.smack.packet;

/* JADX INFO: loaded from: classes10.dex */
public interface Element {
    CharSequence toXML(XmlEnvironment xmlEnvironment);

    default CharSequence toXML(String str) {
        return toXML(new XmlEnvironment(str));
    }

    default CharSequence toXML() {
        return toXML(XmlEnvironment.EMPTY);
    }
}
