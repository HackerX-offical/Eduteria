package org.jivesoftware.smackx.iot.discovery.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemove;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;
import org.jxmpp.jid.Jid;

/* JADX INFO: loaded from: classes10.dex */
public class IoTRemoveProvider extends IQProvider<IoTRemove> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTRemove parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws IOException {
        Jid jidAttribute = ParserUtils.getJidAttribute(xmlPullParser);
        if (jidAttribute.hasResource()) {
            throw new IOException("JID must be without resourcepart");
        }
        return new IoTRemove(jidAttribute.asBareJid(), NodeInfoParser.parse(xmlPullParser));
    }
}
