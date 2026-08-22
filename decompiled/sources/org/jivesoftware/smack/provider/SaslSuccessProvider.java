package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class SaslSuccessProvider extends NonzaProvider<SaslNonza.Success> {
    public static final SaslSuccessProvider INSTANCE = new SaslSuccessProvider();

    private SaslSuccessProvider() {
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public SaslNonza.Success parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new SaslNonza.Success(xmlPullParser.nextText());
    }
}
