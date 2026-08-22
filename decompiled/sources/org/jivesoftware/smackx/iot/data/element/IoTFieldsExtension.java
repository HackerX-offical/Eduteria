package org.jivesoftware.smackx.iot.data.element;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XmlEnvironment;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iot.element.NodeInfo;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: loaded from: classes10.dex */
public class IoTFieldsExtension implements ExtensionElement {
    public static final String ELEMENT = "fields";
    public static final String NAMESPACE = "urn:xmpp:iot:sensordata";
    public static final QName QNAME = new QName("urn:xmpp:iot:sensordata", "fields");
    private final boolean done;
    private final List<NodeElement> nodes;
    private final int seqNr;

    public IoTFieldsExtension(int i, boolean z, NodeElement nodeElement) {
        this(i, z, (List<NodeElement>) Collections.singletonList(nodeElement));
    }

    public IoTFieldsExtension(int i, boolean z, List<NodeElement> list) {
        this.seqNr = i;
        this.done = z;
        this.nodes = Collections.unmodifiableList(list);
    }

    public int getSequenceNr() {
        return this.seqNr;
    }

    public boolean isDone() {
        return this.done;
    }

    public List<NodeElement> getNodes() {
        return this.nodes;
    }

    @Override // org.jivesoftware.smack.packet.NamedElement
    public String getElementName() {
        return "fields";
    }

    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public String getNamespace() {
        return "urn:xmpp:iot:sensordata";
    }

    @Override // org.jivesoftware.smack.packet.Element
    public XmlStringBuilder toXML(XmlEnvironment xmlEnvironment) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute("seqnr", Integer.toString(this.seqNr));
        xmlStringBuilder.attribute(ES6Iterator.DONE_PROPERTY, this.done);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.append(this.nodes);
        xmlStringBuilder.closeElement(this);
        return xmlStringBuilder;
    }

    public static IoTFieldsExtension buildFor(int i, boolean z, NodeInfo nodeInfo, List<? extends IoTDataField> list) {
        return new IoTFieldsExtension(i, z, new NodeElement(nodeInfo, new TimestampElement(new Date(), list)));
    }

    public static IoTFieldsExtension from(Message message) {
        return (IoTFieldsExtension) message.getExtension(IoTFieldsExtension.class);
    }
}
