package org.jivesoftware.smackx.offline.packet;

import java.io.IOException;
import javax.xml.namespace.QName;
import kotlin.text.Typography;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smack.xml.XmlPullParser;
import org.jivesoftware.smack.xml.XmlPullParserException;
import org.jivesoftware.smackx.iot.data.element.NodeElement;

/* JADX INFO: loaded from: classes10.dex */
public class OfflineMessageInfo implements ExtensionElement {
    public static final QName QNAME = new QName("http://jabber.org/protocol/offline", OfflineMessageRequest.ELEMENT);
    private String node = null;

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return QNAME.getLocalPart();
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return QNAME.getNamespaceURI();
    }

    public String getNode() {
        return this.node;
    }

    public void setNode(String str) {
        this.node = str;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public String toXML(XmlEnvironment xmlEnvironment) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getElementName()).append(" xmlns=\"").append(getNamespace()).append("\">");
        if (getNode() != null) {
            sb.append("<item node=\"").append(getNode()).append("\"/>");
        }
        sb.append("</").append(getElementName()).append(Typography.greater);
        return sb.toString();
    }

    public static class Provider extends ExtensionElementProvider<OfflineMessageInfo> {
        @Override // org.jivesoftware.smack.provider.Provider
        public OfflineMessageInfo parse(XmlPullParser xmlPullParser, int i, XmlEnvironment xmlEnvironment) throws XmlPullParserException, IOException {
            OfflineMessageInfo offlineMessageInfo = new OfflineMessageInfo();
            boolean z = false;
            while (!z) {
                XmlPullParser.Event next = xmlPullParser.next();
                if (next == XmlPullParser.Event.START_ELEMENT) {
                    if (xmlPullParser.getName().equals("item")) {
                        offlineMessageInfo.setNode(xmlPullParser.getAttributeValue("", NodeElement.ELEMENT));
                    }
                } else if (next == XmlPullParser.Event.END_ELEMENT && xmlPullParser.getName().equals(OfflineMessageRequest.ELEMENT)) {
                    z = true;
                }
            }
            return offlineMessageInfo;
        }
    }
}
