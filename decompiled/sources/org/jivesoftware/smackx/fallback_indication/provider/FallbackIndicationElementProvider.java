package org.jivesoftware.smackx.fallback_indication.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.fallback_indication.element.FallbackIndicationElement;

/* JADX INFO: loaded from: classes10.dex */
public class FallbackIndicationElementProvider extends ExtensionElementProvider<FallbackIndicationElement> {
    @Override // org.jivesoftware.smack.provider.Provider
    public FallbackIndicationElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        return FallbackIndicationElement.INSTANCE;
    }
}
