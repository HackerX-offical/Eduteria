package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ReplicaSettingsUpdate implements Serializable {
    private String regionName;
    private List<ReplicaGlobalSecondaryIndexSettingsUpdate> replicaGlobalSecondaryIndexSettingsUpdate;
    private AutoScalingSettingsUpdate replicaProvisionedReadCapacityAutoScalingSettingsUpdate;
    private Long replicaProvisionedReadCapacityUnits;

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public ReplicaSettingsUpdate withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public Long getReplicaProvisionedReadCapacityUnits() {
        return this.replicaProvisionedReadCapacityUnits;
    }

    public void setReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
    }

    public ReplicaSettingsUpdate withReplicaProvisionedReadCapacityUnits(Long l) {
        this.replicaProvisionedReadCapacityUnits = l;
        return this;
    }

    public AutoScalingSettingsUpdate getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() {
        return this.replicaProvisionedReadCapacityAutoScalingSettingsUpdate;
    }

    public void setReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.replicaProvisionedReadCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
    }

    public ReplicaSettingsUpdate withReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdate autoScalingSettingsUpdate) {
        this.replicaProvisionedReadCapacityAutoScalingSettingsUpdate = autoScalingSettingsUpdate;
        return this;
    }

    public List<ReplicaGlobalSecondaryIndexSettingsUpdate> getReplicaGlobalSecondaryIndexSettingsUpdate() {
        return this.replicaGlobalSecondaryIndexSettingsUpdate;
    }

    public void setReplicaGlobalSecondaryIndexSettingsUpdate(Collection<ReplicaGlobalSecondaryIndexSettingsUpdate> collection) {
        if (collection == null) {
            this.replicaGlobalSecondaryIndexSettingsUpdate = null;
        } else {
            this.replicaGlobalSecondaryIndexSettingsUpdate = new ArrayList(collection);
        }
    }

    public ReplicaSettingsUpdate withReplicaGlobalSecondaryIndexSettingsUpdate(ReplicaGlobalSecondaryIndexSettingsUpdate... replicaGlobalSecondaryIndexSettingsUpdateArr) {
        if (getReplicaGlobalSecondaryIndexSettingsUpdate() == null) {
            this.replicaGlobalSecondaryIndexSettingsUpdate = new ArrayList(replicaGlobalSecondaryIndexSettingsUpdateArr.length);
        }
        for (ReplicaGlobalSecondaryIndexSettingsUpdate replicaGlobalSecondaryIndexSettingsUpdate : replicaGlobalSecondaryIndexSettingsUpdateArr) {
            this.replicaGlobalSecondaryIndexSettingsUpdate.add(replicaGlobalSecondaryIndexSettingsUpdate);
        }
        return this;
    }

    public ReplicaSettingsUpdate withReplicaGlobalSecondaryIndexSettingsUpdate(Collection<ReplicaGlobalSecondaryIndexSettingsUpdate> collection) {
        setReplicaGlobalSecondaryIndexSettingsUpdate(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getRegionName() != null) {
            sb.append("RegionName: " + getRegionName() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaProvisionedReadCapacityUnits() != null) {
            sb.append("ReplicaProvisionedReadCapacityUnits: " + getReplicaProvisionedReadCapacityUnits() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() != null) {
            sb.append("ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate: " + getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaGlobalSecondaryIndexSettingsUpdate() != null) {
            sb.append("ReplicaGlobalSecondaryIndexSettingsUpdate: " + getReplicaGlobalSecondaryIndexSettingsUpdate());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((getRegionName() == null ? 0 : getRegionName().hashCode()) + 31) * 31) + (getReplicaProvisionedReadCapacityUnits() == null ? 0 : getReplicaProvisionedReadCapacityUnits().hashCode())) * 31) + (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null ? 0 : getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate().hashCode())) * 31) + (getReplicaGlobalSecondaryIndexSettingsUpdate() != null ? getReplicaGlobalSecondaryIndexSettingsUpdate().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReplicaSettingsUpdate)) {
            return false;
        }
        ReplicaSettingsUpdate replicaSettingsUpdate = (ReplicaSettingsUpdate) obj;
        if ((replicaSettingsUpdate.getRegionName() == null) ^ (getRegionName() == null)) {
            return false;
        }
        if (replicaSettingsUpdate.getRegionName() != null && !replicaSettingsUpdate.getRegionName().equals(getRegionName())) {
            return false;
        }
        if ((replicaSettingsUpdate.getReplicaProvisionedReadCapacityUnits() == null) ^ (getReplicaProvisionedReadCapacityUnits() == null)) {
            return false;
        }
        if (replicaSettingsUpdate.getReplicaProvisionedReadCapacityUnits() != null && !replicaSettingsUpdate.getReplicaProvisionedReadCapacityUnits().equals(getReplicaProvisionedReadCapacityUnits())) {
            return false;
        }
        if ((replicaSettingsUpdate.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null) ^ (getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() == null)) {
            return false;
        }
        if (replicaSettingsUpdate.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate() != null && !replicaSettingsUpdate.getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate().equals(getReplicaProvisionedReadCapacityAutoScalingSettingsUpdate())) {
            return false;
        }
        if ((replicaSettingsUpdate.getReplicaGlobalSecondaryIndexSettingsUpdate() == null) ^ (getReplicaGlobalSecondaryIndexSettingsUpdate() == null)) {
            return false;
        }
        return replicaSettingsUpdate.getReplicaGlobalSecondaryIndexSettingsUpdate() == null || replicaSettingsUpdate.getReplicaGlobalSecondaryIndexSettingsUpdate().equals(getReplicaGlobalSecondaryIndexSettingsUpdate());
    }
}
