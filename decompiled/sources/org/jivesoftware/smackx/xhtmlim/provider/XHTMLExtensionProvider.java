package org.jivesoftware.smackx.xhtmlim.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.xhtmlim.packet.XHTMLExtension;

/* JADX INFO: loaded from: classes10.dex */
public class XHTMLExtensionProvider extends ExtensionElementProvider<XHTMLExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public XHTMLExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        XHTMLExtension xHTMLExtension = new XHTMLExtension();
        while (true) {
            XmlPullParser.Event eventType = xmlPullParser.getEventType();
            if (eventType == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("body")) {
                    xHTMLExtension.addBody(PacketParserUtils.parseElement(xmlPullParser));
                }
            } else if (eventType == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return xHTMLExtension;
            }
            xmlPullParser.next();
        }
    }
}
