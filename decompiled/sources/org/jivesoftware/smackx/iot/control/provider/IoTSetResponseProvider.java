package org.jivesoftware.smackx.iot.control.provider;

import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.control.element.IoTSetResponse;

/* JADX INFO: loaded from: classes10.dex */
public class IoTSetResponseProvider extends IQProvider<IoTSetResponse> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTSetResponse parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) {
        return new IoTSetResponse();
    }
}
