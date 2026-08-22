package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.IoTIsFriendResponse;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class IoTIsFriendResponseProvider extends IQProvider<IoTIsFriendResponse> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTIsFriendResponse parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new IoTIsFriendResponse(ParserUtils.getJidAttribute(xmlPullParser).asBareJid(), ParserUtils.getBooleanAttribute(xmlPullParser, "result").booleanValue());
    }
}
