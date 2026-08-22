package org.jivesoftware.smackx.iot;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.jivesoftware.smackx.iot.control.ThingControlRequest;
import org.jivesoftware.smackx.iot.data.ThingMomentaryReadOutRequest;
import org.jivesoftware.smackx.iot.discovery.element.Tag;
import org.jivesoftware.smackx.iot.element.NodeInfo;

/* JADX INFO: loaded from: classes10.dex */
public final class Thing {
    private final ThingControlRequest controlRequestHandler;
    private final HashMap<String, Tag> metaTags;
    private final ThingMomentaryReadOutRequest momentaryReadOutRequestHandler;
    private final NodeInfo nodeInfo;
    private final boolean selfOwned;
    private String toStringCache;

    private Thing(Builder builder) {
        this.metaTags = builder.metaTags;
        this.selfOwned = builder.selfOwned;
        this.nodeInfo = builder.nodeInfo;
        this.momentaryReadOutRequestHandler = builder.momentaryReadOutRequest;
        this.controlRequestHandler = builder.controlRequest;
    }

    public Collection<Tag> getMetaTags() {
        return this.metaTags.values();
    }

    public boolean isSelfOwened() {
        return this.selfOwned;
    }

    public NodeInfo getNodeInfo() {
        return this.nodeInfo;
    }

    public String getNodeId() {
        return this.nodeInfo.getNodeId();
    }

    public String getSourceId() {
        return this.nodeInfo.getSourceId();
    }

    public String getCacheType() {
        return this.nodeInfo.getCacheType();
    }

    public ThingMomentaryReadOutRequest getMomentaryReadOutRequestHandler() {
        return this.momentaryReadOutRequestHandler;
    }

    public ThingControlRequest getControlRequestHandler() {
        return this.controlRequestHandler;
    }

    public String toString() {
        if (this.toStringCache == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thing " + this.nodeInfo + " [");
            Iterator<Tag> it = this.metaTags.values().iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(' ');
                }
            }
            sb.append(']');
            this.toStringCache = sb.toString();
        }
        return this.toStringCache;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ThingControlRequest controlRequest;
        private ThingMomentaryReadOutRequest momentaryReadOutRequest;
        private boolean selfOwned;
        private HashMap<String, Tag> metaTags = new HashMap<>();
        private NodeInfo nodeInfo = NodeInfo.EMPTY;

        public Builder setSerialNumber(String str) {
            this.metaTags.put("SN", new Tag("SN", Tag.Type.str, str));
            return this;
        }

        public Builder setKey(String str) {
            this.metaTags.put("KEY", new Tag("KEY", Tag.Type.str, str));
            return this;
        }

        public Builder setManufacturer(String str) {
            this.metaTags.put("MAN", new Tag("MAN", Tag.Type.str, str));
            return this;
        }

        public Builder setModel(String str) {
            this.metaTags.put("MODEL", new Tag("MODEL", Tag.Type.str, str));
            return this;
        }

        public Builder setVersion(String str) {
            this.metaTags.put(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, new Tag(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, Tag.Type.num, str));
            return this;
        }

        public Builder setMomentaryReadOutRequestHandler(ThingMomentaryReadOutRequest thingMomentaryReadOutRequest) {
            this.momentaryReadOutRequest = thingMomentaryReadOutRequest;
            return this;
        }

        public Builder setControlRequestHandler(ThingControlRequest thingControlRequest) {
            this.controlRequest = thingControlRequest;
            return this;
        }

        public Thing build() {
            return new Thing(this);
        }
    }
}
