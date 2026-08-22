package org.jivesoftware.smackx.jingle.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.jingle.element.JingleError;

/* JADX INFO: loaded from: classes10.dex */
public class JingleErrorProvider extends ExtensionElementProvider<JingleError> {
    @Override // org.jivesoftware.smack.provider.Provider
    public JingleError parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return JingleError.fromString(xmlPullParser.getName());
    }
}
