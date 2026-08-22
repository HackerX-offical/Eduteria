package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.CryptElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;

/* JADX INFO: loaded from: classes10.dex */
public class CryptElementProvider extends OpenPgpContentElementProvider<CryptElement> {
    public static final CryptElementProvider INSTANCE = new CryptElementProvider();

    @Override // org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider, org.jivesoftware.smack.provider.Provider
    public CryptElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        OpenPgpContentElementProvider.OpenPgpContentElementData openPgpContentElementData = parseOpenPgpContentElementData(xmlPullParser, i);
        return new CryptElement(openPgpContentElementData.to, openPgpContentElementData.rpad, openPgpContentElementData.timestamp, openPgpContentElementData.payload);
    }
}
