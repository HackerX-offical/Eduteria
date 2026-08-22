package org.jivesoftware.smackx.muclight.provider;

import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.element.MUCLightBlockingIQ;
import org.jxmpp.jid.Jid;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightBlockingIQProvider extends IQProvider<MUCLightBlockingIQ> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MUCLightBlockingIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap<Jid, Boolean> blocking = null;
        HashMap<Jid, Boolean> blocking2 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("room")) {
                    blocking = parseBlocking(xmlPullParser, blocking);
                }
                if (xmlPullParser.getName().equals("user")) {
                    blocking2 = parseBlocking(xmlPullParser, blocking2);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                MUCLightBlockingIQ mUCLightBlockingIQ = new MUCLightBlockingIQ(blocking, blocking2);
                mUCLightBlockingIQ.setType(IQ.Type.result);
                return mUCLightBlockingIQ;
            }
        }
    }

    private static HashMap<Jid, Boolean> parseBlocking(XmlPullParser xmlPullParser, HashMap<Jid, Boolean> map) throws XmlPullParserException, IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        String attributeValue = xmlPullParser.getAttributeValue("", "action");
        if (attributeValue.equals("deny")) {
            map.put(JidCreate.from(xmlPullParser.nextText()), false);
            return map;
        }
        if (attributeValue.equals("allow")) {
            map.put(JidCreate.from(xmlPullParser.nextText()), true);
        }
        return map;
    }
}
