package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.SigncryptElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;

/* JADX INFO: loaded from: classes10.dex */
public class SigncryptElementProvider extends OpenPgpContentElementProvider<SigncryptElement> {
    public static final SigncryptElementProvider INSTANCE = new SigncryptElementProvider();

    @Override // org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider, org.jivesoftware.smack.provider.Provider
    public SigncryptElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        OpenPgpContentElementProvider.OpenPgpContentElementData openPgpContentElementData = parseOpenPgpContentElementData(xmlPullParser, i);
        return new SigncryptElement(openPgpContentElementData.to, openPgpContentElementData.rpad, openPgpContentElementData.timestamp, openPgpContentElementData.payload);
    }
}
