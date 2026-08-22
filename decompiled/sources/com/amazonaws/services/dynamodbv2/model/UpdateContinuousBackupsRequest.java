package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateContinuousBackupsRequest extends AmazonWebServiceRequest implements Serializable {
    private PointInTimeRecoverySpecification pointInTimeRecoverySpecification;
    private String tableName;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public UpdateContinuousBackupsRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public PointInTimeRecoverySpecification getPointInTimeRecoverySpecification() {
        return this.pointInTimeRecoverySpecification;
    }

    public void setPointInTimeRecoverySpecification(PointInTimeRecoverySpecification pointInTimeRecoverySpecification) {
        this.pointInTimeRecoverySpecification = pointInTimeRecoverySpecification;
    }

    public UpdateContinuousBackupsRequest withPointInTimeRecoverySpecification(PointInTimeRecoverySpecification pointInTimeRecoverySpecification) {
        this.pointInTimeRecoverySpecification = pointInTimeRecoverySpecification;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getPointInTimeRecoverySpecification() != null) {
            sb.append("PointInTimeRecoverySpecification: " + getPointInTimeRecoverySpecification());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getPointInTimeRecoverySpecification() != null ? getPointInTimeRecoverySpecification().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateContinuousBackupsRequest)) {
            return false;
        }
        UpdateContinuousBackupsRequest updateContinuousBackupsRequest = (UpdateContinuousBackupsRequest) obj;
        if ((updateContinuousBackupsRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (updateContinuousBackupsRequest.getTableName() != null && !updateContinuousBackupsRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((updateContinuousBackupsRequest.getPointInTimeRecoverySpecification() == null) ^ (getPointInTimeRecoverySpecification() == null)) {
            return false;
        }
        return updateContinuousBackupsRequest.getPointInTimeRecoverySpecification() == null || updateContinuousBackupsRequest.getPointInTimeRecoverySpecification().equals(getPointInTimeRecoverySpecification());
    }
}
