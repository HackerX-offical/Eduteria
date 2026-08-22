package org.jivesoftware.smackx.ping.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.ping.packet.Ping;

/* JADX INFO: loaded from: classes10.dex */
public class PingProvider extends IQProvider<Ping> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public Ping parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        return new Ping();
    }
}
