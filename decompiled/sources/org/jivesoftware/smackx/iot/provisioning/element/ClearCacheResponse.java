package org.jivesoftware.smackx.iot.provisioning.element;

import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.SimpleIQ;

/* JADX INFO: loaded from: classes10.dex */
public class ClearCacheResponse extends SimpleIQ {
    public static final String ELEMENT = "clearCacheResponse";
    public static final String NAMESPACE = "urn:xmpp:iot:provisioning";

    public ClearCacheResponse() {
        super(ELEMENT, "urn:xmpp:iot:provisioning");
        setType(IQ.Type.result);
    }

    public ClearCacheResponse(ClearCache clearCache) {
        this();
        setStanzaId(clearCache.getStanzaId());
        setTo(clearCache.getFrom());
    }
}
