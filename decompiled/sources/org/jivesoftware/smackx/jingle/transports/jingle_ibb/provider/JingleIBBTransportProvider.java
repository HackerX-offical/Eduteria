package org.jivesoftware.smackx.jingle.transports.jingle_ibb.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.jingle.provider.JingleContentTransportProvider;
import org.jivesoftware.smackx.jingle.transports.jingle_ibb.element.JingleIBBTransport;

/* JADX INFO: loaded from: classes10.dex */
public class JingleIBBTransportProvider extends JingleContentTransportProvider<JingleIBBTransport> {
    @Override // org.jivesoftware.smackx.jingle.provider.JingleContentTransportProvider, org.jivesoftware.smack.provider.Provider
    public JingleIBBTransport parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        String attributeValue = xmlPullParser.getAttributeValue(null, JingleIBBTransport.ATTR_BLOCK_SIZE);
        return new JingleIBBTransport(attributeValue != null ? Short.valueOf(attributeValue).shortValue() : (short) -1, xmlPullParser.getAttributeValue(null, "sid"));
    }
}
