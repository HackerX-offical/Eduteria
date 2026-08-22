package org.jivesoftware.smackx.disco.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class DiscoverItemsProvider extends IQProvider<DiscoverItems> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public DiscoverItems parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        DiscoverItems discoverItems = new DiscoverItems();
        discoverItems.setNode(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
        boolean z = false;
        Jid jidAttribute = null;
        String attributeValue = "";
        String attributeValue2 = attributeValue;
        String attributeValue3 = attributeValue2;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && "item".equals(xmlPullParser.getName())) {
                jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
                attributeValue = xmlPullParser.getAttributeValue("", "name");
                attributeValue2 = xmlPullParser.getAttributeValue("", NodeElement.ELEMENT);
                attributeValue3 = xmlPullParser.getAttributeValue("", "action");
            } else if (next == XmlPullParser.Event.END_ELEMENT && "item".equals(xmlPullParser.getName())) {
                DiscoverItems.Item item = new DiscoverItems.Item(jidAttribute);
                item.setName(attributeValue);
                item.setNode(attributeValue2);
                item.setAction(attributeValue3);
                discoverItems.addItem(item);
            } else if (next == XmlPullParser.Event.END_ELEMENT && "query".equals(xmlPullParser.getName())) {
                z = true;
            }
        }
        return discoverItems;
    }
}
