package org.jivesoftware.smackx.bob.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.Pair;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bob.BoBData;
import org.jivesoftware.smackx.bob.ContentId;
import org.jivesoftware.smackx.bob.element.BoBIQ;

/* JADX INFO: loaded from: classes10.dex */
public class BoBIQProvider extends IQProvider<BoBIQ> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public BoBIQ parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Pair<ContentId, BoBData> contentIdAndBobData = BoBProviderUtil.parseContentIdAndBobData(xmlPullParser, i, xmlEnvironment);
        return new BoBIQ(contentIdAndBobData.getFirst(), contentIdAndBobData.getSecond());
    }
}
