package org.jivesoftware.smackx.muclight.provider;

import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.MUCLightRoomConfiguration;
import org.jivesoftware.smackx.muclight.element.MUCLightInfoIQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightInfoIQProvider extends IQProvider<MUCLightInfoIQ> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MUCLightInfoIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap<Jid, MUCLightAffiliation> map = new HashMap<>();
        String strNextText = null;
        String strNextText2 = null;
        String strNextText3 = null;
        HashMap map2 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("version")) {
                    strNextText = xmlPullParser.nextText();
                }
                if (xmlPullParser.getName().equals("configuration")) {
                    int depth = xmlPullParser.getDepth();
                    while (true) {
                        XmlPullParser.Event next2 = xmlPullParser.next();
                        if (next2 == XmlPullParser.Event.START_ELEMENT) {
                            if (xmlPullParser.getName().equals("roomname")) {
                                strNextText2 = xmlPullParser.nextText();
                            } else if (xmlPullParser.getName().equals("subject")) {
                                strNextText3 = xmlPullParser.nextText();
                            } else {
                                if (map2 == null) {
                                    map2 = new HashMap();
                                }
                                map2.put(xmlPullParser.getName(), xmlPullParser.nextText());
                            }
                        } else if (next2 == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                            break;
                        }
                    }
                }
                if (xmlPullParser.getName().equals("occupants")) {
                    map = iterateOccupants(xmlPullParser);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return new MUCLightInfoIQ(strNextText, new MUCLightRoomConfiguration(strNextText2, strNextText3, map2), map);
            }
        }
    }

    private static HashMap<Jid, MUCLightAffiliation> iterateOccupants(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap<Jid, MUCLightAffiliation> map = new HashMap<>();
        int depth = xmlPullParser.getDepth();
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("user")) {
                    map.put(JidCreate.from(xmlPullParser.nextText()), MUCLightAffiliation.fromString(xmlPullParser.getAttributeValue("", "affiliation")));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == depth) {
                return map;
            }
        }
    }
}
