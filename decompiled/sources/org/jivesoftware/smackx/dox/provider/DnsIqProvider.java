package org.jivesoftware.smackx.dox.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.dox.element.DnsIq;

/* JADX INFO: loaded from: classes10.dex */
public class DnsIqProvider extends IQProvider<DnsIq> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public DnsIq parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return new DnsIq(xmlPullParser.nextText());
    }
}
