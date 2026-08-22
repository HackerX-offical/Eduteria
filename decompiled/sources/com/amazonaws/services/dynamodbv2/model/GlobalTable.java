package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GlobalTable implements Serializable {
    private String globalTableName;
    private List<Replica> replicationGroup;

    public String getGlobalTableName() {
        return this.globalTableName;
    }

    public void setGlobalTableName(String str) {
        this.globalTableName = str;
    }

    public GlobalTable withGlobalTableName(String str) {
        this.globalTableName = str;
        return this;
    }

    public List<Replica> getReplicationGroup() {
        return this.replicationGroup;
    }

    public void setReplicationGroup(Collection<Replica> collection) {
        if (collection == null) {
            this.replicationGroup = null;
        } else {
            this.replicationGroup = new ArrayList(collection);
        }
    }

    public GlobalTable withReplicationGroup(Replica... replicaArr) {
        if (getReplicationGroup() == null) {
            this.replicationGroup = new ArrayList(replicaArr.length);
        }
        for (Replica replica : replicaArr) {
            this.replicationGroup.add(replica);
        }
        return this;
    }

    public GlobalTable withReplicationGroup(Collection<Replica> collection) {
        setReplicationGroup(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTableName() != null) {
            sb.append("GlobalTableName: " + getGlobalTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicationGroup() != null) {
            sb.append("ReplicationGroup: " + getReplicationGroup());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode()) + 31) * 31) + (getReplicationGroup() != null ? getReplicationGroup().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GlobalTable)) {
            return false;
        }
        GlobalTable globalTable = (GlobalTable) obj;
        if ((globalTable.getGlobalTableName() == null) ^ (getGlobalTableName() == null)) {
            return false;
        }
        if (globalTable.getGlobalTableName() != null && !globalTable.getGlobalTableName().equals(getGlobalTableName())) {
            return false;
        }
        if ((globalTable.getReplicationGroup() == null) ^ (getReplicationGroup() == null)) {
            return false;
        }
        return globalTable.getReplicationGroup() == null || globalTable.getReplicationGroup().equals(getReplicationGroup());
    }
}
