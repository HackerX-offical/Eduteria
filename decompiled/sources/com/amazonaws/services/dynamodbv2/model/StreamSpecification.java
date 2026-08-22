package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class StreamSpecification implements Serializable {
    private Boolean streamEnabled;
    private String streamViewType;

    public Boolean isStreamEnabled() {
        return this.streamEnabled;
    }

    public Boolean getStreamEnabled() {
        return this.streamEnabled;
    }

    public void setStreamEnabled(Boolean bool) {
        this.streamEnabled = bool;
    }

    public StreamSpecification withStreamEnabled(Boolean bool) {
        this.streamEnabled = bool;
        return this;
    }

    public String getStreamViewType() {
        return this.streamViewType;
    }

    public void setStreamViewType(String str) {
        this.streamViewType = str;
    }

    public StreamSpecification withStreamViewType(String str) {
        this.streamViewType = str;
        return this;
    }

    public void setStreamViewType(StreamViewType streamViewType) {
        this.streamViewType = streamViewType.toString();
    }

    public StreamSpecification withStreamViewType(StreamViewType streamViewType) {
        this.streamViewType = streamViewType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getStreamEnabled() != null) {
            sb.append("StreamEnabled: " + getStreamEnabled() + Constants.SEPARATOR_COMMA);
        }
        if (getStreamViewType() != null) {
            sb.append("StreamViewType: " + getStreamViewType());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getStreamEnabled() == null ? 0 : getStreamEnabled().hashCode()) + 31) * 31) + (getStreamViewType() != null ? getStreamViewType().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StreamSpecification)) {
            return false;
        }
        StreamSpecification streamSpecification = (StreamSpecification) obj;
        if ((streamSpecification.getStreamEnabled() == null) ^ (getStreamEnabled() == null)) {
            return false;
        }
        if (streamSpecification.getStreamEnabled() != null && !streamSpecification.getStreamEnabled().equals(getStreamEnabled())) {
            return false;
        }
        if ((streamSpecification.getStreamViewType() == null) ^ (getStreamViewType() == null)) {
            return false;
        }
        return streamSpecification.getStreamViewType() == null || streamSpecification.getStreamViewType().equals(getStreamViewType());
    }
}
