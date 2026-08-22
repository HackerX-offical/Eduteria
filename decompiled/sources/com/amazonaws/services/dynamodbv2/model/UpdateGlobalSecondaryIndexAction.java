package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateGlobalSecondaryIndexAction implements Serializable {
    private String indexName;
    private ProvisionedThroughput provisionedThroughput;

    public String getIndexName() {
        return this.indexName;
    }

    public void setIndexName(String str) {
        this.indexName = str;
    }

    public UpdateGlobalSecondaryIndexAction withIndexName(String str) {
        this.indexName = str;
        return this;
    }

    public ProvisionedThroughput getProvisionedThroughput() {
        return this.provisionedThroughput;
    }

    public void setProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
    }

    public UpdateGlobalSecondaryIndexAction withProvisionedThroughput(ProvisionedThroughput provisionedThroughput) {
        this.provisionedThroughput = provisionedThroughput;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIndexName() != null) {
            sb.append("IndexName: " + getIndexName() + Constants.SEPARATOR_COMMA);
        }
        if (getProvisionedThroughput() != null) {
            sb.append("ProvisionedThroughput: " + getProvisionedThroughput());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getIndexName() == null ? 0 : getIndexName().hashCode()) + 31) * 31) + (getProvisionedThroughput() != null ? getProvisionedThroughput().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGlobalSecondaryIndexAction)) {
            return false;
        }
        UpdateGlobalSecondaryIndexAction updateGlobalSecondaryIndexAction = (UpdateGlobalSecondaryIndexAction) obj;
        if ((updateGlobalSecondaryIndexAction.getIndexName() == null) ^ (getIndexName() == null)) {
            return false;
        }
        if (updateGlobalSecondaryIndexAction.getIndexName() != null && !updateGlobalSecondaryIndexAction.getIndexName().equals(getIndexName())) {
            return false;
        }
        if ((updateGlobalSecondaryIndexAction.getProvisionedThroughput() == null) ^ (getProvisionedThroughput() == null)) {
            return false;
        }
        return updateGlobalSecondaryIndexAction.getProvisionedThroughput() == null || updateGlobalSecondaryIndexAction.getProvisionedThroughput().equals(getProvisionedThroughput());
    }
}
