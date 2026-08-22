package org.jivesoftware.smackx.hoxt.provider;

import java.io.IOException;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.hoxt.packet.HttpOverXmppResp;
import org.jivesoftware.smackx.shim.packet.HeadersExtension;

/* JADX INFO: loaded from: classes10.dex */
public class HttpOverXmppRespProvider extends AbstractHttpOverXmppProvider<HttpOverXmppResp> {
    private static final String ATTRIBUTE_STATUS_CODE = "statusCode";
    private static final String ATTRIBUTE_STATUS_MESSAGE = "statusMessage";

    @Override // org.jivesoftware.smack.provider.IQProvider
    public HttpOverXmppResp parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        String attributeValue = xmlPullParser.getAttributeValue("", "version");
        String attributeValue2 = xmlPullParser.getAttributeValue("", ATTRIBUTE_STATUS_MESSAGE);
        int i2 = Integer.parseInt(xmlPullParser.getAttributeValue("", ATTRIBUTE_STATUS_CODE));
        HeadersExtension headers = parseHeaders(xmlPullParser);
        return HttpOverXmppResp.builder().setHeaders(headers).setData(parseData(xmlPullParser)).setStatusCode(i2).setStatusMessage(attributeValue2).setVersion(attributeValue).build();
    }
}
