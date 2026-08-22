package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateGlobalTableRequest extends AmazonWebServiceRequest implements Serializable {
    private String globalTableName;
    private List<ReplicaUpdate> replicaUpdates;

    public String getGlobalTableName() {
        return this.globalTableName;
    }

    public void setGlobalTableName(String str) {
        this.globalTableName = str;
    }

    public UpdateGlobalTableRequest withGlobalTableName(String str) {
        this.globalTableName = str;
        return this;
    }

    public List<ReplicaUpdate> getReplicaUpdates() {
        return this.replicaUpdates;
    }

    public void setReplicaUpdates(Collection<ReplicaUpdate> collection) {
        if (collection == null) {
            this.replicaUpdates = null;
        } else {
            this.replicaUpdates = new ArrayList(collection);
        }
    }

    public UpdateGlobalTableRequest withReplicaUpdates(ReplicaUpdate... replicaUpdateArr) {
        if (getReplicaUpdates() == null) {
            this.replicaUpdates = new ArrayList(replicaUpdateArr.length);
        }
        for (ReplicaUpdate replicaUpdate : replicaUpdateArr) {
            this.replicaUpdates.add(replicaUpdate);
        }
        return this;
    }

    public UpdateGlobalTableRequest withReplicaUpdates(Collection<ReplicaUpdate> collection) {
        setReplicaUpdates(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTableName() != null) {
            sb.append("GlobalTableName: " + getGlobalTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getReplicaUpdates() != null) {
            sb.append("ReplicaUpdates: " + getReplicaUpdates());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode()) + 31) * 31) + (getReplicaUpdates() != null ? getReplicaUpdates().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGlobalTableRequest)) {
            return false;
        }
        UpdateGlobalTableRequest updateGlobalTableRequest = (UpdateGlobalTableRequest) obj;
        if ((updateGlobalTableRequest.getGlobalTableName() == null) ^ (getGlobalTableName() == null)) {
            return false;
        }
        if (updateGlobalTableRequest.getGlobalTableName() != null && !updateGlobalTableRequest.getGlobalTableName().equals(getGlobalTableName())) {
            return false;
        }
        if ((updateGlobalTableRequest.getReplicaUpdates() == null) ^ (getReplicaUpdates() == null)) {
            return false;
        }
        return updateGlobalTableRequest.getReplicaUpdates() == null || updateGlobalTableRequest.getReplicaUpdates().equals(getReplicaUpdates());
    }
}
