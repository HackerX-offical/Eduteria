package org.jivesoftware.smackx.ox.provider;

import java.io.IOException;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ox.element.SignElement;
import org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider;

/* JADX INFO: loaded from: classes10.dex */
public class SignElementProvider extends OpenPgpContentElementProvider<SignElement> {
    private static final Logger LOGGER = Logger.getLogger(SigncryptElementProvider.class.getName());
    public static final SignElementProvider INSTANCE = new SignElementProvider();

    @Override // org.jivesoftware.smackx.ox.provider.OpenPgpContentElementProvider, org.jivesoftware.smack.provider.Provider
    public SignElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        OpenPgpContentElementProvider.OpenPgpContentElementData openPgpContentElementData = parseOpenPgpContentElementData(xmlPullParser, i);
        if (StringUtils.isNotEmpty(openPgpContentElementData.rpad)) {
            LOGGER.warning("Ignoring rpad in XEP-0373 <sign/> element");
        }
        return new SignElement(openPgpContentElementData.to, openPgpContentElementData.timestamp, openPgpContentElementData.payload);
    }
}
