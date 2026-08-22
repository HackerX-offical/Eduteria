package org.jivesoftware.smackx.muclight.provider;

import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightConfigurationsChangeProvider extends ExtensionElementProvider<MUCLightElements.ConfigurationsChangeExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MUCLightElements.ConfigurationsChangeExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String strNextText = null;
        String strNextText2 = null;
        String strNextText3 = null;
        String strNextText4 = null;
        HashMap map = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("prev-version")) {
                    strNextText = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals("version")) {
                    strNextText2 = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals("roomname")) {
                    strNextText3 = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals("subject")) {
                    strNextText4 = xmlPullParser.nextText();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(xmlPullParser.getName(), xmlPullParser.nextText());
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return new MUCLightElements.ConfigurationsChangeExtension(strNextText, strNextText2, strNextText3, strNextText4, map);
            }
        }
    }
}
