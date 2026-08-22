package org.jivesoftware.smackx.disco;

import java.util.List;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;

/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractNodeInformationProvider implements NodeInformationProvider {
    @Override // org.jivesoftware.smackx.disco.NodeInformationProvider
    public List<String> getNodeFeatures() {
        return null;
    }

    @Override // org.jivesoftware.smackx.disco.NodeInformationProvider
    public List<DiscoverInfo.Identity> getNodeIdentities() {
        return null;
    }

    @Override // org.jivesoftware.smackx.disco.NodeInformationProvider
    public List<DiscoverItems.Item> getNodeItems() {
        return null;
    }

    @Override // org.jivesoftware.smackx.disco.NodeInformationProvider
    public List<? extends ExtensionElement> getNodePacketExtensions() {
        return null;
    }
}
