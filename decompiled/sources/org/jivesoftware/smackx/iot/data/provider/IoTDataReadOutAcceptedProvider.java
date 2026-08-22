package org.jivesoftware.smackx.iot.data.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.data.element.IoTDataReadOutAccepted;

/* JADX INFO: loaded from: classes10.dex */
public class IoTDataReadOutAcceptedProvider extends IQProvider<IoTDataReadOutAccepted> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTDataReadOutAccepted parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws IOException {
        return new IoTDataReadOutAccepted(ParserUtils.getIntegerAttributeOrThrow(xmlPullParser, "seqnr", "IoT data request <accepted/> without sequence number"), ParserUtils.getBooleanAttribute(xmlPullParser, "queued", false));
    }
}
