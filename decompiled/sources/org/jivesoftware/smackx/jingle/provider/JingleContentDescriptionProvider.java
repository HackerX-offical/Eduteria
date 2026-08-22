package org.jivesoftware.smackx.jingle.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.jingle.element.JingleContentDescription;

/* JADX INFO: loaded from: classes10.dex */
public abstract class JingleContentDescriptionProvider<D extends JingleContentDescription> extends ExtensionElementProvider<D> {
    @Override // org.jivesoftware.smack.provider.Provider
    public abstract D parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException;
}
