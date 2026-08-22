package org.jivesoftware.smackx.iot.provisioning.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.provisioning.element.Unfriend;
import org.jxmpp.stringprep.XmppStringprepException;

/* JADX INFO: loaded from: classes10.dex */
public class UnfriendProvider extends ExtensionElementProvider<Unfriend> {
    @Override // org.jivesoftware.smack.provider.Provider
    public Unfriend parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmppStringprepException {
        return new Unfriend(ParserUtils.getBareJidAttribute(xmlPullParser));
    }
}
