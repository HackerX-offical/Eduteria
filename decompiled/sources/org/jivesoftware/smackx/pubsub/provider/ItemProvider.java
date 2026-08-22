package org.jivesoftware.smackx.pubsub.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.provider.ProviderManager;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.Item;
import org.jivesoftware.smackx.pubsub.PayloadItem;
import org.jivesoftware.smackx.pubsub.SimplePayload;

/* JADX INFO: loaded from: classes10.dex */
public class ItemProvider extends ExtensionElementProvider<Item> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Item parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, NodeElement.ELEMENT);
        Item.ItemNamespace itemNamespaceFromXmlns = Item.ItemNamespace.fromXmlns(xmlPullParser.getNamespace());
        if (xmlPullParser.next() == XmlPullParser.Event.END_ELEMENT) {
            return new Item(itemNamespaceFromXmlns, attributeValue, attributeValue2);
        }
        ExtensionElementProvider<ExtensionElement> extensionProvider = ProviderManager.getExtensionProvider(xmlPullParser.getName(), xmlPullParser.getNamespace());
        if (extensionProvider == null) {
            return new PayloadItem(itemNamespaceFromXmlns, attributeValue, attributeValue2, new SimplePayload(PacketParserUtils.parseElement(xmlPullParser, true).toString()));
        }
        return new PayloadItem(itemNamespaceFromXmlns, attributeValue, attributeValue2, extensionProvider.parse(xmlPullParser));
    }
}
