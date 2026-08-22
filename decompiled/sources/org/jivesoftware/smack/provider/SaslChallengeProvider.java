package org.jivesoftware.smack.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;

/* JADX INFO: loaded from: classes10.dex */
public final class SaslChallengeProvider extends NonzaProvider<SaslNonza.Challenge> {
    public static final SaslChallengeProvider INSTANCE = new SaslChallengeProvider();

    private SaslChallengeProvider() {
    }

    @Override // org.jivesoftware.smack.provider.Provider
    public SaslNonza.Challenge parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new SaslNonza.Challenge(xmlPullParser.nextText());
    }
}
