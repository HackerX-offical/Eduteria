package org.jivesoftware.smackx.message_retraction.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.message_retraction.element.RetractElement;

/* JADX INFO: loaded from: classes10.dex */
public class RetractElementProvider extends ExtensionElementProvider<RetractElement> {
    @Override // org.jivesoftware.smack.provider.Provider
    public RetractElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return new RetractElement();
    }
}
