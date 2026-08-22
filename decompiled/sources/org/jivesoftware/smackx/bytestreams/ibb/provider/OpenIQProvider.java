package org.jivesoftware.smackx.bytestreams.ibb.provider;

import java.io.IOException;
import java.util.Locale;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;

/* JADX INFO: loaded from: classes10.dex */
public class OpenIQProvider extends IQProvider<Open> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public Open parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        InBandBytestreamManager.StanzaType stanzaTypeValueOf;
        String attributeValue = xmlPullParser.getAttributeValue("", "sid");
        int i2 = Integer.parseInt(xmlPullParser.getAttributeValue("", JingleIBBTransport.ATTR_BLOCK_SIZE));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "stanza");
        if (attributeValue2 == null) {
            stanzaTypeValueOf = InBandBytestreamManager.StanzaType.IQ;
        } else {
            stanzaTypeValueOf = InBandBytestreamManager.StanzaType.valueOf(attributeValue2.toUpperCase(Locale.US));
        }
        xmlPullParser.next();
        return new Open(attributeValue, i2, stanzaTypeValueOf);
    }
}
