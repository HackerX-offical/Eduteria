package org.jivesoftware.smackx.json.provider;

import org.jivesoftware.smackx.json.packet.JsonPacketExtension;

/* JADX INFO: loaded from: classes10.dex */
public class JsonExtensionProvider extends AbstractJsonExtensionProvider<JsonPacketExtension> {
    @Override // org.jivesoftware.smackx.json.provider.AbstractJsonExtensionProvider
    public JsonPacketExtension from(String str) {
        return new JsonPacketExtension(str);
    }
}
