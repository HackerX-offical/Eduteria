package org.jivesoftware.smackx.sid.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.sid.element.OriginIdElement;

/* JADX INFO: loaded from: classes10.dex */
public class OriginIdProvider extends ExtensionElementProvider<OriginIdElement> {
    public static final OriginIdProvider INSTANCE;

    @Deprecated
    public static final OriginIdProvider TEST_INSTANCE;

    static {
        OriginIdProvider originIdProvider = new OriginIdProvider();
        INSTANCE = originIdProvider;
        TEST_INSTANCE = originIdProvider;
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public OriginIdElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new OriginIdElement(xmlPullParser.getAttributeValue(null, "id"));
    }
}
