package org.jivesoftware.smackx.iot.discovery.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.discovery.element.IoTDisown;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class IoTDisownProvider extends IQProvider<IoTDisown> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTDisown parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new IoTDisown(ParserUtils.getJidAttribute(xmlPullParser), NodeInfoParser.parse(xmlPullParser));
    }
}
