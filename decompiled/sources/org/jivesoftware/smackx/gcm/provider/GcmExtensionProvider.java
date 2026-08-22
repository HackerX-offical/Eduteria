package org.jivesoftware.smackx.gcm.provider;

import org.jivesoftware.smackx.gcm.packet.GcmPacketExtension;
import org.jivesoftware.smackx.json.provider.AbstractJsonExtensionProvider;

/* JADX INFO: loaded from: classes10.dex */
public class GcmExtensionProvider extends AbstractJsonExtensionProvider<GcmPacketExtension> {
    @Override // org.jivesoftware.smackx.json.provider.AbstractJsonExtensionProvider
    public GcmPacketExtension from(String str) {
        return new GcmPacketExtension(str);
    }
}
