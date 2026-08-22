package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.IoTIsFriend;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class IoTIsFriendProvider extends IQProvider<IoTIsFriend> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTIsFriend parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new IoTIsFriend(ParserUtils.getJidAttribute(xmlPullParser));
    }
}
