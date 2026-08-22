package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateContinuousBackupsResult implements Serializable {
    private ContinuousBackupsDescription continuousBackupsDescription;

    public ContinuousBackupsDescription getContinuousBackupsDescription() {
        return this.continuousBackupsDescription;
    }

    public void setContinuousBackupsDescription(ContinuousBackupsDescription continuousBackupsDescription) {
        this.continuousBackupsDescription = continuousBackupsDescription;
    }

    public UpdateContinuousBackupsResult withContinuousBackupsDescription(ContinuousBackupsDescription continuousBackupsDescription) {
        this.continuousBackupsDescription = continuousBackupsDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getContinuousBackupsDescription() != null) {
            sb.append("ContinuousBackupsDescription: " + getContinuousBackupsDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getContinuousBackupsDescription() == null ? 0 : getContinuousBackupsDescription().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateContinuousBackupsResult)) {
            return false;
        }
        UpdateContinuousBackupsResult updateContinuousBackupsResult = (UpdateContinuousBackupsResult) obj;
        if ((updateContinuousBackupsResult.getContinuousBackupsDescription() == null) ^ (getContinuousBackupsDescription() == null)) {
            return false;
        }
        return updateContinuousBackupsResult.getContinuousBackupsDescription() == null || updateContinuousBackupsResult.getContinuousBackupsDescription().equals(getContinuousBackupsDescription());
    }
}
