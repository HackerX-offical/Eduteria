package org.jivesoftware.smackx.iot.discovery.provider;

import java.io.IOException;
import java.util.ArrayList;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.discovery.element.IoTRegister;
import org.jivesoftware.smackx.iot.discovery.element.Tag;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.jivesoftware.smackx.iot.parser.NodeInfoParser;

/* JADX INFO: loaded from: classes10.dex */
public class IoTRegisterProvider extends IQProvider<IoTRegister> {
    @Override // org.jivesoftware.smack.provider.IQProvider
    public IoTRegister parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
        Tag.Type type;
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, "selfOwned", false);
        NodeInfo nodeInfo = NodeInfoParser.parse(xmlPullParser);
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.getDepth() != i) {
            if (xmlPullParser.next() == XmlPullParser.Event.START_ELEMENT) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (!name.equals("num")) {
                    type = !name.equals("str") ? null : Tag.Type.str;
                } else {
                    type = Tag.Type.num;
                }
                if (type != null) {
                    arrayList.add(new Tag(xmlPullParser.getAttributeValue(null, "name"), type, xmlPullParser.getAttributeValue(null, "value")));
                }
            }
        }
        return new IoTRegister(arrayList, nodeInfo, booleanAttribute);
    }
}
