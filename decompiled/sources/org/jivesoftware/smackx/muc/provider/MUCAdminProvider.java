package org.jivesoftware.smackx.muc.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.muc.packet.MUCAdmin;

/* JADX INFO: loaded from: classes10.dex */
public class MUCAdminProvider extends IQProvider<MUCAdmin> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public MUCAdmin parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        MUCAdmin mUCAdmin = new MUCAdmin();
        boolean z = false;
        while (!z) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                if (xmlPullParser.getName().equals("item")) {
                    mUCAdmin.addItem(MUCParserUtils.parseItem(xmlPullParser));
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals("query")) {
                z = true;
            }
        }
        return mUCAdmin;
    }
}
