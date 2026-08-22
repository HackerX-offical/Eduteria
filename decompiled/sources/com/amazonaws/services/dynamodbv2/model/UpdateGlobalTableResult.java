package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateGlobalTableResult implements Serializable {
    private GlobalTableDescription globalTableDescription;

    public GlobalTableDescription getGlobalTableDescription() {
        return this.globalTableDescription;
    }

    public void setGlobalTableDescription(GlobalTableDescription globalTableDescription) {
        this.globalTableDescription = globalTableDescription;
    }

    public UpdateGlobalTableResult withGlobalTableDescription(GlobalTableDescription globalTableDescription) {
        this.globalTableDescription = globalTableDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTableDescription() != null) {
            sb.append("GlobalTableDescription: " + getGlobalTableDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getGlobalTableDescription() == null ? 0 : getGlobalTableDescription().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGlobalTableResult)) {
            return false;
        }
        UpdateGlobalTableResult updateGlobalTableResult = (UpdateGlobalTableResult) obj;
        if ((updateGlobalTableResult.getGlobalTableDescription() == null) ^ (getGlobalTableDescription() == null)) {
            return false;
        }
        return updateGlobalTableResult.getGlobalTableDescription() == null || updateGlobalTableResult.getGlobalTableDescription().equals(getGlobalTableDescription());
    }
}
