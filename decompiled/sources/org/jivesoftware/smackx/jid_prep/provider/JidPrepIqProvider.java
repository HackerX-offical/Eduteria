package org.jivesoftware.smackx.jid_prep.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jid_prep.element.JidPrepIq;

/* JADX INFO: loaded from: classes10.dex */
public class JidPrepIqProvider extends IQProvider<JidPrepIq> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public JidPrepIq parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return new JidPrepIq(xmlPullParser.nextText());
    }
}
