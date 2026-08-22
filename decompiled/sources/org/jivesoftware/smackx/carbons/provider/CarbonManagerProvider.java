package org.jivesoftware.smackx.carbons.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;
import org.jivesoftware.smackx.forward.packet.Forwarded;
import org.jivesoftware.smackx.forward.provider.ForwardedProvider;

/* JADX INFO: loaded from: classes10.dex */
public class CarbonManagerProvider extends ExtensionElementProvider<CarbonExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public CarbonExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        CarbonExtension.Direction directionValueOf = CarbonExtension.Direction.valueOf(xmlPullParser.getName());
        Forwarded<Message> forwardedMessage = null;
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT && xmlPullParser.getName().equals(Forwarded.ELEMENT)) {
                forwardedMessage = ForwardedProvider.parseForwardedMessage(xmlPullParser, xmlEnvironment);
            } else if (next == XmlPullParser.Event.END_ELEMENT && directionValueOf == CarbonExtension.Direction.valueOf(xmlPullParser.getName())) {
                z = true;
            }
        }
        if (forwardedMessage == null) {
            throw new SmackParsingException("sent/received must contain exactly one <forwarded/> element");
        }
        return new CarbonExtension(directionValueOf, forwardedMessage);
    }
}
