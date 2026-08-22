package org.jivesoftware.smackx.sid.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.sid.element.StanzaIdElement;

/* JADX INFO: loaded from: classes10.dex */
public class StanzaIdProvider extends ExtensionElementProvider<StanzaIdElement> {
    public static final StanzaIdProvider INSTANCE = new StanzaIdProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public StanzaIdElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new StanzaIdElement(xmlPullParser.getAttributeValue(null, "id"), xmlPullParser.getAttributeValue(null, StanzaIdElement.ATTR_BY));
    }
}
