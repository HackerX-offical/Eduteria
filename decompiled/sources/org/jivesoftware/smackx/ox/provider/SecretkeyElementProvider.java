package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import java.nio.charset.Charset;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.SecretkeyElement;

/* JADX INFO: loaded from: classes10.dex */
public class SecretkeyElementProvider extends ExtensionElementProvider<SecretkeyElement> {
    public static final SecretkeyElementProvider TEST_INSTANCE = new SecretkeyElementProvider();

    @Override // org.jivesoftware.smack.provider.Provider
    public SecretkeyElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new SecretkeyElement(xmlPullParser.nextText().getBytes(Charset.forName("UTF-8")));
    }
}
