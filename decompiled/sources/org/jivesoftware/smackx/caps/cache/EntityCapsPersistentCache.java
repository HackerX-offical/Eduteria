package org.jivesoftware.smackx.caps.cache;

import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

/* JADX INFO: loaded from: classes10.dex */
public interface EntityCapsPersistentCache {
    void addDiscoverInfoByNodePersistent(String str, DiscoverInfo discoverInfo);

    void emptyCache();

    DiscoverInfo lookup(String str);
}
