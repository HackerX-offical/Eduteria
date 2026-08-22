package org.jivesoftware.smackx.iot.element;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* JADX INFO: loaded from: classes10.dex */
public final class NodeInfo {
    public static final NodeInfo EMPTY = new NodeInfo();
    private final String cacheType;
    private final String nodeId;
    private final String sourceId;

    private NodeInfo() {
        this.nodeId = null;
        this.sourceId = null;
        this.cacheType = null;
    }

    public NodeInfo(String str, String str2, String str3) {
        this.nodeId = (String) StringUtils.requireNotNullNorEmpty(str, "Node ID must not be null nor empty");
        this.sourceId = str2;
        this.cacheType = str3;
    }

    public String getNodeId() {
        return this.nodeId;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public String getCacheType() {
        return this.cacheType;
    }

    public void appendTo(XmlStringBuilder xmlStringBuilder) {
        String str = this.nodeId;
        if (str == null) {
            return;
        }
        xmlStringBuilder.attribute("nodeId", str).optAttribute("sourceId", this.sourceId).optAttribute("cacheType", this.cacheType);
    }

    public int hashCode() {
        if (this == EMPTY) {
            return 0;
        }
        int iHashCode = (this.nodeId.hashCode() + 31) * 31;
        String str = this.sourceId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.cacheType;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NodeInfo)) {
            return false;
        }
        NodeInfo nodeInfo = (NodeInfo) obj;
        return this.nodeId.equals(nodeInfo.nodeId) && StringUtils.nullSafeCharSequenceEquals(this.sourceId, nodeInfo.sourceId) && StringUtils.nullSafeCharSequenceEquals(this.cacheType, nodeInfo.cacheType);
    }
}
