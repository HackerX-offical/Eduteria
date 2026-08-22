package org.jivesoftware.smackx.jingle.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle.element.JingleContentTransport;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleContentTransportProvider<T extends JingleContentTransport> extends ExtensionElementProvider<T> {
    @Override // org.jivesoftware.smack.provider.Provider
    public abstract T parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException;
}
