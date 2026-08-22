package org.jivesoftware.smackx.iot.data.element;

import org.jivesoftware.smack.packet.ExtensionElement;

/* JADX INFO: loaded from: classes10.dex */
public abstract class IoTDataExtensionElement implements ExtensionElement {
    @Override // org.jivesoftware.smack.packet.FullyQualifiedElement
    public final String getNamespace() {
        return "urn:xmpp:iot:sensordata";
    }
}
