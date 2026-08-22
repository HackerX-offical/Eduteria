package org.jivesoftware.smackx.bob.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.Pair;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bob.BoBData;
import org.jivesoftware.smackx.bob.ContentId;
import org.jivesoftware.smackx.bob.element.BoBDataExtension;

/* JADX INFO: loaded from: classes10.dex */
public class BoBDataExtensionProvider extends ExtensionElementProvider<BoBDataExtension> {
    @Override // org.jivesoftware.smack.provider.Provider
    public BoBDataExtension parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Pair<ContentId, BoBData> contentIdAndBobData = BoBProviderUtil.parseContentIdAndBobData(xmlPullParser, i, xmlEnvironment);
        return new BoBDataExtension(contentIdAndBobData.getFirst(), contentIdAndBobData.getSecond());
    }
}
