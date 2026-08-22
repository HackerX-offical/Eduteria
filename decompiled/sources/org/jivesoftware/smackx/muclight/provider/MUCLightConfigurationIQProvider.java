package org.jivesoftware.smackx.muclight.provider;

import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightConfigurationIQ;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightConfigurationIQProvider extends IQProvider<MUCLightConfigurationIQ> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MUCLightConfigurationIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        String strNextText = null;
        String strNextText2 = null;
        HashMap map = null;
        String strNextText3 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("version")) {
                    strNextText3 = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals("roomname")) {
                    strNextText = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().equals("subject")) {
                    strNextText2 = xmlPullParser.nextText();
                } else {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(xmlPullParser.getName(), xmlPullParser.nextText());
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return new MUCLightConfigurationIQ(strNextText3, new MUCLightRoomConfiguration(strNextText, strNextText2, map));
            }
        }
    }
}
