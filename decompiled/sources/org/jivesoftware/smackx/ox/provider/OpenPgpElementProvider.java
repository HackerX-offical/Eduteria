package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.OpenPgpElement;

/* JADX INFO: loaded from: classes10.dex */
public class OpenPgpElementProvider extends ExtensionElementProvider<OpenPgpElement> {
    public static final OpenPgpElementProvider TEST_INSTANCE = new OpenPgpElementProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public OpenPgpElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new OpenPgpElement(xmlPullParser.nextText());
    }
}
