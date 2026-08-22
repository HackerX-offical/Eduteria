package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReplicaSettingsDescription implements Serializable {
    private String regionName;
    private List<ReplicaGlobalSecondaryIndexSettingsDescription> replicaGlobalSecondaryIndexSettings;
    private AutoScalingSettingsDescription replicaProvisionedReadCapacityAutoScalingSettings;
    private Long replicaProvisionedReadCapacityUnits;
    private AutoScalingSettingsDescription replicaProvisionedWriteCapacityAutoScalingSettings;
    private Long replicaProvisionedWriteCapacityUnits;
    private String replicaStatus;

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public ReplicaSettingsDescription withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public String getReplicaStatus() {
        return this.replicaStatus;
    }

    public void setReplicaStatus(String str) {
        this.replicaStatus = str;
    }

    public ReplicaSettingsDescription withReplicaStatus(String str) {
        this.replicaStatus = str;
        return this;
    }

    public void setReplicaStatus(ReplicaStatus replicaStatus) {
        this.replicaStatus = replicaStatus.toString();
    }

    public ReplicaSettingsDescription withReplicaStatus(ReplicaStatus replicaStatus) {
        this.replicaStatus = replicaStatus.toString();
        return this;
    }

    public Long getReplicaProvisionedReadCapacityUnits() {
        return this.replicaProvisionedReadCapacityUnits;
    }

    public void setReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
    }

    public ReplicaSettingsDescription withReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getReplicaProvisionedReadCapacityAutoScalingSettings() {
        return this.replicaProvisionedReadCapacityAutoScalingSettings;
    }

    public void setReplicaProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaSettingsDescription withReplicaProvisionedReadCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedReadCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public Long getReplicaProvisionedWriteCapacityUnits() {
        return this.replicaProvisionedWriteCapacityUnits;
    }

    public void setReplicaProvisionedWriteCapacityUnits(Long l) {
        this.replicaProvisionedWriteCapacityUnits = l;
    }

    public ReplicaSettingsDescription withReplicaProvisionedWriteCapacityUnits(Long l) {
        this.replicaProvisionedWriteCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsDescription getReplicaProvisionedWriteCapacityAutoScalingSettings() {
        return this.replicaProvisionedWriteCapacityAutoScalingSettings;
    }

    public void setReplicaProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
    }

    public ReplicaSettingsDescription withReplicaProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescription autoScalingSettingsDescription) {
        this.replicaProvisionedWriteCapacityAutoScalingSettings = autoScalingSettingsDescription;
        return this;
    }

    public List<ReplicaGlobalSecondaryIndexSettingsDescription> getReplicaGlobalSecondaryIndexSettings() {
        return this.replicaGlobalSecondaryIndexSettings;
    }

    public void setReplicaGlobalSecondaryIndexSettings(Collection<ReplicaGlobalSecondaryIndexSettingsDescription> collection) {
        if (collection == null) {
            this.replicaGlobalSecondaryIndexSettings = null;
        } else {
            this.replicaGlobalSecondaryIndexSettings = new ArrayList(collection);
        }
    }

    public ReplicaSettingsDescription withReplicaGlobalSecondaryIndexSettings(ReplicaGlobalSecondaryIndexSettingsDescription... replicaGlobalSecondaryIndexSettingsDescriptionArr) {
        if (getReplicaGlobalSecondaryIndexSettings() == null) {
            this.replicaGlobalSecondaryIndexSettings = new ArrayList(replicaGlobalSecondaryIndexSettingsDescriptionArr.length);
        }
        for (ReplicaGlobalSecondaryIndexSettingsDescription replicaGlobalSecondaryIndexSettingsDescription : replicaGlobalSecondaryIndexSettingsDescriptionArr) {
            this.replicaGlobalSecondaryIndexSettings.add(replicaGlobalSecondaryIndexSettingsDescription);
        }
        return this;
    }

    public ReplicaSettingsDescription withReplicaGlobalSecondaryIndexSettings(Collection<ReplicaGlobalSecondaryIndexSettingsDescription> collection) {
        setReplicaGlobalSecondaryIndexSettings(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRegionName() != null) {
            sb.append("RegionName: " + getRegionName() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaStatus() != null) {
            sb.append("ReplicaStatus: " + getReplicaStatus() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaProvisionedReadCapacityUnits() != null) {
            sb.append("ReplicaProvisionedReadCapacityUnits: " + getReplicaProvisionedReadCapacityUnits() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaProvisionedReadCapacityAutoScalingSettings() != null) {
            sb.append("ReplicaProvisionedReadCapacityAutoScalingSettings: " + getReplicaProvisionedReadCapacityAutoScalingSettings() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaProvisionedWriteCapacityUnits() != null) {
            sb.append("ReplicaProvisionedWriteCapacityUnits: " + getReplicaProvisionedWriteCapacityUnits() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaProvisionedWriteCapacityAutoScalingSettings() != null) {
            sb.append("ReplicaProvisionedWriteCapacityAutoScalingSettings: " + getReplicaProvisionedWriteCapacityAutoScalingSettings() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaGlobalSecondaryIndexSettings() != null) {
            sb.append("ReplicaGlobalSecondaryIndexSettings: " + getReplicaGlobalSecondaryIndexSettings());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((getRegionName() == null ? 0 : getRegionName().hashCode()) + 31) * 31) + (getReplicaStatus() == null ? 0 : getReplicaStatus().hashCode())) * 31) + (getReplicaProvisionedReadCapacityUnits() == null ? 0 : getReplicaProvisionedReadCapacityUnits().hashCode())) * 31) + (getReplicaProvisionedReadCapacityAutoScalingSettings() == null ? 0 : getReplicaProvisionedReadCapacityAutoScalingSettings().hashCode())) * 31) + (getReplicaProvisionedWriteCapacityUnits() == null ? 0 : getReplicaProvisionedWriteCapacityUnits().hashCode())) * 31) + (getReplicaProvisionedWriteCapacityAutoScalingSettings() == null ? 0 : getReplicaProvisionedWriteCapacityAutoScalingSettings().hashCode())) * 31) + (getReplicaGlobalSecondaryIndexSettings() != null ? getReplicaGlobalSecondaryIndexSettings().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaSettingsDescription)) {
            return false;
        }
        ReplicaSettingsDescription replicaSettingsDescription = (ReplicaSettingsDescription) obj;
        if ((replicaSettingsDescription.getRegionName() == null) ^ (getRegionName() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getRegionName() != null && !replicaSettingsDescription.getRegionName().equals(getRegionName())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaStatus() == null) ^ (getReplicaStatus() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaStatus() != null && !replicaSettingsDescription.getReplicaStatus().equals(getReplicaStatus())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits() == null) ^ (getReplicaProvisionedReadCapacityUnits() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits() != null && !replicaSettingsDescription.getReplicaProvisionedReadCapacityUnits().equals(getReplicaProvisionedReadCapacityUnits())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings() == null) ^ (getReplicaProvisionedReadCapacityAutoScalingSettings() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings() != null && !replicaSettingsDescription.getReplicaProvisionedReadCapacityAutoScalingSettings().equals(getReplicaProvisionedReadCapacityAutoScalingSettings())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits() == null) ^ (getReplicaProvisionedWriteCapacityUnits() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits() != null && !replicaSettingsDescription.getReplicaProvisionedWriteCapacityUnits().equals(getReplicaProvisionedWriteCapacityUnits())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings() == null) ^ (getReplicaProvisionedWriteCapacityAutoScalingSettings() == null)) {
            return false;
        }
        if (replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings() != null && !replicaSettingsDescription.getReplicaProvisionedWriteCapacityAutoScalingSettings().equals(getReplicaProvisionedWriteCapacityAutoScalingSettings())) {
            return false;
        }
        if ((replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings() == null) ^ (getReplicaGlobalSecondaryIndexSettings() == null)) {
            return false;
        }
        return replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings() == null || replicaSettingsDescription.getReplicaGlobalSecondaryIndexSettings().equals(getReplicaGlobalSecondaryIndexSettings());
    }
}
