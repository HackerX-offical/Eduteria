package org.jivesoftware.smackx.bob.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.Pair;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bob.BoBData;
import org.jivesoftware.smackx.bob.ContentId;

/* JADX INFO: loaded from: classes10.dex */
public class BoBProviderUtil {
    public static Pair<ContentId, BoBData> parseContentIdAndBobData(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        ContentId contentIdFromCid = ContentId.fromCid(xmlPullParser.getAttributeValue("", "cid"));
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        return Pair.create(contentIdFromCid, attributeValue != null ? new BoBData(attributeValue, xmlPullParser.nextText(), ParserUtils.getIntegerAttribute(xmlPullParser, "max-age")) : null);
    }
}
