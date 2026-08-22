package org.jivesoftware.smackx.bytestreams.socks5.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.jingle.transports.jingle_s5b.elements.JingleS5BTransportCandidate;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class BytestreamsProvider extends IQProvider<Bytestream> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public Bytestream parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Bytestream bytestream = new Bytestream();
        String attributeValue = xmlPullParser.getAttributeValue("", "sid");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "mode");
        boolean z = false;
        loop0: while (true) {
            String attributeValue3 = null;
            Jid jidAttribute = null;
            String attributeValue4 = null;
            while (!z) {
                XmlPullParser.Event next = xmlPullParser.next();
                String name = xmlPullParser.getName();
                if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (name.equals(Bytestream.StreamHost.ELEMENTNAME)) {
                        jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
                        attributeValue4 = xmlPullParser.getAttributeValue("", JingleS5BTransportCandidate.ATTR_HOST);
                        attributeValue3 = xmlPullParser.getAttributeValue("", "port");
                    } else if (name.equals(Bytestream.StreamHostUsed.ELEMENTNAME)) {
                        bytestream.setUsedHost(ParserUtils.getJidAttribute(xmlPullParser));
                    } else if (name.equals(Bytestream.Activate.ELEMENTNAME)) {
                        bytestream.setToActivate(ParserUtils.getJidAttribute(xmlPullParser));
                    }
                } else if (next != XmlPullParser.Event.END_ELEMENT) {
                    continue;
                } else if (name.equals("streamhost")) {
                    if (attributeValue3 == null) {
                        bytestream.addStreamHost(jidAttribute, attributeValue4);
                    } else {
                        bytestream.addStreamHost(jidAttribute, attributeValue4, Integer.parseInt(attributeValue3));
                    }
                } else if (name.equals("query")) {
                    z = true;
                }
            }
            break loop0;
        }
        if (attributeValue2 == null) {
            bytestream.setMode(Bytestream.Mode.tcp);
        } else {
            bytestream.setMode(Bytestream.Mode.fromName(attributeValue2));
        }
        bytestream.setSessionID(attributeValue);
        return bytestream;
    }
}
