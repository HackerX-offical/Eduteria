package org.jivesoftware.smackx.muclight.provider;

import java.io.IOException;
import java.util.HashMap;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muclight.MUCLightAffiliation;
import org.jivesoftware.smackx.muclight.element.MUCLightElements;
import org.jxmpp.jid.impl.JidCreate;

/* JADX INFO: loaded from: classes10.dex */
public class MUCLightAffiliationsChangeProvider extends ExtensionElementProvider<MUCLightElements.AffiliationsChangeExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public MUCLightElements.AffiliationsChangeExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        String strNextText = null;
        String strNextText2 = null;
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("prev-version")) {
                    strNextText = xmlPullParser.nextText();
                }
                if (xmlPullParser.getName().equals("version")) {
                    strNextText2 = xmlPullParser.nextText();
                }
                if (xmlPullParser.getName().equals("user")) {
                    map.put(JidCreate.from(xmlPullParser.nextText()), MUCLightAffiliation.fromString(xmlPullParser.getAttributeValue("", "affiliation")));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return new MUCLightElements.AffiliationsChangeExtension(map, strNextText, strNextText2);
            }
        }
    }
}
