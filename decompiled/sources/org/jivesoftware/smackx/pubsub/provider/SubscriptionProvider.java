package org.jivesoftware.smackx.pubsub.provider;

import com.appnew.android.Utils.Const;
import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;
import org.jivesoftware.smackx.pubsub.Subscription;
import org.jivesoftware.smackx.xdata.FormField;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class SubscriptionProvider extends ExtensionElementProvider<Subscription> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Subscription parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Jid jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
        String attributeValue = xmlPullParser.getAttributeValue(null, NodeElement.ELEMENT);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "subid");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, Const.SUBSCRIPTION);
        boolean z = false;
        if (xmlPullParser.next() == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals("subscribe-options")) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals(FormField.Required.ELEMENT)) {
                z = true;
            }
            while (next != XmlPullParser.Event.END_ELEMENT && !xmlPullParser.getName().equals("subscribe-options")) {
                next = xmlPullParser.next();
            }
        }
        while (xmlPullParser.getEventType() != XmlPullParser.Event.END_ELEMENT) {
            xmlPullParser.next();
        }
        return new Subscription(jidAttribute, attributeValue, attributeValue2, attributeValue3 != null ? Subscription.State.valueOf(attributeValue3) : null, z);
    }
}
