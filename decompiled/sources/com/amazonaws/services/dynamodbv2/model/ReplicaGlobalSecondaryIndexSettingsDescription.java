package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ReplicaGlobalSecondaryIndexSettingsDescription implements Serializable {
    private String indexName;
    private String indexStatus;
    private AutoScalingSettingsDescription provisionedReadCapacityAutoScalingSettings;
    private Long provisionedReadCapacityUnits;
    private AutoScalingSettingsDescription provisionedWriteCapacityAutoScalingSettings;
    private Long provisionedWriteCapacityUnits;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public String getIndexStatus() {
        return this.indexStatus;
    }

    public void setIndexStatus(String str) {
        this.indexStatus = str;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withIndexStatus(String str) {
        this.indexStatus = str;
        return this;
    }

    public void setIndexStatus(IndexStatus indexStatus) {
        this.indexStatus = indexStatus.toString();
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withIndexStatus(IndexStatus indexStatus) {
        this.indexStatus = indexStatus.toString();
        return this;
    }

    public Long getProvisionedReadCapacityUnits() {
        return this.provisionedReadCapacityUnits;
    }

    public void setProvisionedReadCapacityUnits(Long l) {
        this.provisionedReadCapacityUnits = l;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedReadCapacityUnits(Long l) {
        this.provisionedReadCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getProvisionedReadCapacityAutoScalingSettings() {
        return this.provisionedReadCapacityAutoScalingSettings;
    }

    public void setProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public Long getProvisionedWriteCapacityUnits() {
        return this.provisionedWriteCapacityUnits;
    }

    public void setProvisionedWriteCapacityUnits(Long l) {
        this.provisionedWriteCapacityUnits = l;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedWriteCapacityUnits(Long l) {
        this.provisionedWriteCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getProvisionedWriteCapacityAutoScalingSettings() {
        return this.provisionedWriteCapacityAutoScalingSettings;
    }

    public void setProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaGlobalSecondaryIndexSettingsDescription withProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.provisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + Constants.SEPARATOR_COMMA);
        }
        if (getIndexStatus() != null) {
            sb.append("IndexStatus: " + getIndexStatus() + Constants.SEPARATOR_COMMA);
        }
        if (getProvisionedReadCapacityUnits() != null) {
            sb.append("ProvisionedReadCapacityUnits: " + getProvisionedReadCapacityUnits() + Constants.SEPARATOR_COMMA);
        }
        if (getProvisionedReadCapacityAutoScalingSettings() != null) {
            sb.append("ProvisionedReadCapacityAutoScalingSettings: " + getProvisionedReadCapacityAutoScalingSettings() + Constants.SEPARATOR_COMMA);
        }
        if (getProvisionedWriteCapacityUnits() != null) {
            sb.append("ProvisionedWriteCapacityUnits: " + getProvisionedWriteCapacityUnits() + Constants.SEPARATOR_COMMA);
        }
        if (getProvisionedWriteCapacityAutoScalingSettings() != null) {
            sb.append("ProvisionedWriteCapacityAutoScalingSettings: " + getProvisionedWriteCapacityAutoScalingSettings());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31) + (getIndexStatus() == null ? 0 : getIndexStatus().hashCode())) * 31) + (getProvisionedReadCapacityUnits() == null ? 0 : getProvisionedReadCapacityUnits().hashCode())) * 31) + (getProvisionedReadCapacityAutoScalingSettings() == null ? 0 : getProvisionedReadCapacityAutoScalingSettings().hashCode())) * 31) + (getProvisionedWriteCapacityUnits() == null ? 0 : getProvisionedWriteCapacityUnits().hashCode())) * 31) + (getProvisionedWriteCapacityAutoScalingSettings() != null ? getProvisionedWriteCapacityAutoScalingSettings().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaGlobalSecondaryIndexSettingsDescription)) {
            return false;
        }
        ReplicaGlobalSecondaryIndexSettingsDescription replicaGlobalSecondaryIndexSettingsDescription = (ReplicaGlobalSecondaryIndexSettingsDescription) obj;
        if ((replicaGlobalSecondaryIndexSettingsDescription.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getIndexName() != null && !replicaGlobalSecondaryIndexSettingsDescription.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getIndexStatus() == null) ^ (getIndexStatus() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getIndexStatus() != null && !replicaGlobalSecondaryIndexSettingsDescription.getIndexStatus().equals(getIndexStatus())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityUnits() == null) ^ (getProvisionedReadCapacityUnits() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityUnits() != null && !replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityUnits().equals(getProvisionedReadCapacityUnits())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityAutoScalingSettings() == null) ^ (getProvisionedReadCapacityAutoScalingSettings() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityAutoScalingSettings() != null && !replicaGlobalSecondaryIndexSettingsDescription.getProvisionedReadCapacityAutoScalingSettings().equals(getProvisionedReadCapacityAutoScalingSettings())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityUnits() == null) ^ (getProvisionedWriteCapacityUnits() == null)) {
            return false;
        }
        if (replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityUnits() != null && !replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityUnits().equals(getProvisionedWriteCapacityUnits())) {
            return false;
        }
        if ((replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityAutoScalingSettings() == null) ^ (getProvisionedWriteCapacityAutoScalingSettings() == null)) {
            return false;
        }
        return replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityAutoScalingSettings() == null || replicaGlobalSecondaryIndexSettingsDescription.getProvisionedWriteCapacityAutoScalingSettings().equals(getProvisionedWriteCapacityAutoScalingSettings());
    }
}
