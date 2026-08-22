package org.jivesoftware.smackx.iot.provisioning.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.SimpleIQ;

/* JADX INFO: loaded from: classes10.dex */
public class ClearCache extends SimpleIQ {
    public static final String ELEMENT = "clearCache";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";

    public ClearCache() {
        super(ELEMENT, "urn:xmpp:iot:provisioning");
        setType(IQ.Type.get);
    }
}
