package org.jivesoftware.smackx.bob;

import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public class BoBInfo {
    private final BoBData data;
    private final Set<ContentId> hashes;

    BoBInfo(Set<ContentId> set, BoBData boBData) {
        this.hashes = set;
        this.data = boBData;
    }

    public Set<ContentId> getHashes() {
        return this.hashes;
    }

    public BoBData getData() {
        return this.data;
    }
}
