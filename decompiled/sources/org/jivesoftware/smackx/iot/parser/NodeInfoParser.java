package org.jivesoftware.smackx.iot.parser;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smackx.iot.element.NodeInfo;

/* JADX INFO: loaded from: classes10.dex */
public class NodeInfoParser {
    public static NodeInfo parse(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "nodeId");
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "sourceId");
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "cacheType");
        if (StringUtils.isNullOrEmpty(attributeValue) && StringUtils.isNullOrEmpty(attributeValue2) && StringUtils.isNullOrEmpty(attributeValue3)) {
            return NodeInfo.EMPTY;
        }
        return new NodeInfo(attributeValue, attributeValue2, attributeValue3);
    }
}
