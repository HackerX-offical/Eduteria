package org.jivesoftware.smackx.disco.provider;

import com.appnew.android.Utils.Const;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import org.jivesoftware.smack.packet.IqData;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.parsing.SmackParsingException;
import org.jivesoftware.smack.provider.AbstractC0760IqProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfoBuilder;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: loaded from: classes10.dex */
public class DiscoverInfoProvider extends AbstractC0760IqProvider<DiscoverInfo> {
    @Override // org.jivesoftware.smack.provider.AbstractC0760IqProvider
    public DiscoverInfo parse(XmlPullParser xmlPullParser, int i, IqData iqData, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException, SmackParsingException {
        DiscoverInfoBuilder discoverInfoBuilderBuilder = DiscoverInfo.builder(iqData);
        discoverInfoBuilderBuilder.setNode(xmlPullParser.getAttributeValue(NodeElement.ELEMENT));
        while (true) {
            XmlPullParser.Event next = xmlPullParser.next();
            if (next == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                if (xmlPullParser.getNamespace().equals(DiscoverInfo.NAMESPACE)) {
                    name.hashCode();
                    if (name.equals("feature")) {
                        discoverInfoBuilderBuilder.addFeature(xmlPullParser.getAttributeValue("var"));
                    } else if (name.equals(HTTP.IDENTITY_CODING)) {
                        discoverInfoBuilderBuilder.addIdentity(new DiscoverInfo.Identity(xmlPullParser.getAttributeValue(Const.CATEGORY), xmlPullParser.getAttributeValue("type"), xmlPullParser.getAttributeValue("name"), ParserUtils.getXmlLang(xmlPullParser)));
                    }
                } else {
                    PacketParserUtils.addExtensionElement(discoverInfoBuilderBuilder, xmlPullParser, xmlEnvironment);
                }
            } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getDepth() == i) {
                return discoverInfoBuilderBuilder.buildWithoutValidiation();
            }
        }
    }
}
