package org.jivesoftware.smack.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public abstract class EmbeddedExtensionProvider<PE extends ExtensionElement> extends ExtensionElementProvider<PE> {
    protected abstract PE createReturnExtension(String str, String str2, Map<String, String> map, List<? extends ExtensionElement> list);

    @Override // org.jivesoftware.smack.provider.Provider
    public final PE parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String namespace = xmlPullParser.getNamespace();
        String name = xmlPullParser.getName();
        int attributeCount = xmlPullParser.getAttributeCount();
        HashMap map = new HashMap(attributeCount);
        for (int i2 = 0; i2 < attributeCount; i2++) {
            map.put(xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                PacketParserUtils.addExtensionElement(arrayList, xmlPullParser, xmlEnvironment);
            }
            if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return (PE) createReturnExtension(name, namespace, map, arrayList);
            }
        }
    }
}
