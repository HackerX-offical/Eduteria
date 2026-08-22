package org.jivesoftware.smackx.iot.discovery.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.discovery.element.IoTRemoved;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;

/* JADX INFO: loaded from: classes10.dex */
public class IoTRemovedProvider extends IQProvider<IoTRemoved> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTRemoved parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new IoTRemoved(NodeInfoParser.parse(xmlPullParser));
    }
}
