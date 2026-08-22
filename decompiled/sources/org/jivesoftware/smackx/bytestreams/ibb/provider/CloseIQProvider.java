package org.jivesoftware.smackx.bytestreams.ibb.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

/* JADX INFO: loaded from: classes10.dex */
public class CloseIQProvider extends IQProvider<Close> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public Close parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new Close(xmlPullParser.getAttributeValue("", "sid"));
    }
}
