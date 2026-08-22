package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ProvisionedThroughput implements Serializable {
    private Long readCapacityUnits;
    private Long writeCapacityUnits;

    public ProvisionedThroughput() {
    }

    public ProvisionedThroughput(Long l, Long l2) {
        setReadCapacityUnits(l);
        setWriteCapacityUnits(l2);
    }

    public Long getReadCapacityUnits() {
        return this.readCapacityUnits;
    }

    public void setReadCapacityUnits(Long l) {
        this.readCapacityUnits = l;
    }

    public ProvisionedThroughput withReadCapacityUnits(Long l) {
        this.readCapacityUnits = l;
        return this;
    }

    public Long getWriteCapacityUnits() {
        return this.writeCapacityUnits;
    }

    public void setWriteCapacityUnits(Long l) {
        this.writeCapacityUnits = l;
    }

    public ProvisionedThroughput withWriteCapacityUnits(Long l) {
        this.writeCapacityUnits = l;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getReadCapacityUnits() != null) {
            sb.append("ReadCapacityUnits: " + getReadCapacityUnits() + Constants.SEPARATOR_COMMA);
        }
        if (getWriteCapacityUnits() != null) {
            sb.append("WriteCapacityUnits: " + getWriteCapacityUnits());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getReadCapacityUnits() == null ? 0 : getReadCapacityUnits().hashCode()) + 31) * 31) + (getWriteCapacityUnits() != null ? getWriteCapacityUnits().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProvisionedThroughput)) {
            return false;
        }
        ProvisionedThroughput provisionedThroughput = (ProvisionedThroughput) obj;
        if ((provisionedThroughput.getReadCapacityUnits() == null) ^ (getReadCapacityUnits() == null)) {
            return false;
        }
        if (provisionedThroughput.getReadCapacityUnits() != null && !provisionedThroughput.getReadCapacityUnits().equals(getReadCapacityUnits())) {
            return false;
        }
        if ((provisionedThroughput.getWriteCapacityUnits() == null) ^ (getWriteCapacityUnits() == null)) {
            return false;
        }
        return provisionedThroughput.getWriteCapacityUnits() == null || provisionedThroughput.getWriteCapacityUnits().equals(getWriteCapacityUnits());
    }
}
