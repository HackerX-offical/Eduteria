package org.jivesoftware.smackx.pubsub;

import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;

/* JADX INFO: loaded from: classes10.dex */
public interface EmbeddedPacketExtension extends ExtensionElement {
    List<ExtensionElement> getExtensions();
}
