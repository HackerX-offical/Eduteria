package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCOwner;

/* JADX INFO: loaded from: classes10.dex */
public class MUCOwnerProvider extends IQProvider<MUCOwner> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MUCOwner parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        MUCOwner mUCOwner = new MUCOwner();
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("item")) {
                    mUCOwner.addItem(MUCParserUtils.parseItem(xmlPullParser));
                } else if (xmlPullParser.getName().equals(Destroy.ELEMENT)) {
                    mUCOwner.setDestroy(MUCParserUtils.parseDestroy(xmlPullParser));
                } else {
                    PacketParserUtils.addExtensionElement(mUCOwner, xmlPullParser, xmlEnvironment);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        return mUCOwner;
    }
}
