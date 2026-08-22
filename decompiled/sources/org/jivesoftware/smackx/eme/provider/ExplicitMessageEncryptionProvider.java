package org.jivesoftware.smackx.eme.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.eme.element.ExplicitMessageEncryptionElement;

/* JADX INFO: loaded from: classes10.dex */
public class ExplicitMessageEncryptionProvider extends ExtensionElementProvider<ExplicitMessageEncryptionElement> {
    @Override // org.jivesoftware.smack.provider.Provider
    public ExplicitMessageEncryptionElement parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new ExplicitMessageEncryptionElement(xmlPullParser.getAttributeValue(null, "namespace"), xmlPullParser.getAttributeValue(null, "name"));
    }
}
