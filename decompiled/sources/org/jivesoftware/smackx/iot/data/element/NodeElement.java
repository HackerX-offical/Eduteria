package org.jivesoftware.smackx.iot.data.element;

import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.element.NodeInfo;

/* JADX INFO: loaded from: classes10.dex */
public class NodeElement extends IoTDataExtensionElement {
    public static final String ELEMENT = "node";
    private final NodeInfo nodeInfo;
    private final List<TimestampElement> timestampElements;

    public NodeElement(NodeInfo nodeInfo, TimestampElement timestampElement) {
        this(nodeInfo, (List<TimestampElement>) Collections.singletonList(timestampElement));
    }

    public NodeElement(NodeInfo nodeInfo, List<TimestampElement> list) {
        this.nodeInfo = nodeInfo;
        this.timestampElements = Collections.unmodifiableList(list);
    }

    public List<TimestampElement> getTimestampElements() {
        return this.timestampElements;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder(this, xmlEnvironment);
        this.nodeInfo.appendTo(xmlStringBuilder);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.timestampElements);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }
}
