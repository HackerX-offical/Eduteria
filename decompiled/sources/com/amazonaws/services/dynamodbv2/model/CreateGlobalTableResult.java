package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class CreateGlobalTableResult implements Serializable {
    private GlobalTableDescription globalTableDescription;

    public GlobalTableDescription getGlobalTableDescription() {
        return this.globalTableDescription;
    }

    public void setGlobalTableDescription(GlobalTableDescription globalTableDescription) {
        this.globalTableDescription = globalTableDescription;
    }

    public CreateGlobalTableResult withGlobalTableDescription(GlobalTableDescription globalTableDescription) {
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
        if (obj == null || !(obj instanceof CreateGlobalTableResult)) {
            return false;
        }
        CreateGlobalTableResult createGlobalTableResult = (CreateGlobalTableResult) obj;
        if ((createGlobalTableResult.getGlobalTableDescription() == null) ^ (getGlobalTableDescription() == null)) {
            return false;
        }
        return createGlobalTableResult.getGlobalTableDescription() == null || createGlobalTableResult.getGlobalTableDescription().equals(getGlobalTableDescription());
    }
}
