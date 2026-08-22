package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ContinuousBackupsDescription implements Serializable {
    private String continuousBackupsStatus;
    private PointInTimeRecoveryDescription pointInTimeRecoveryDescription;

    public String getContinuousBackupsStatus() {
        return this.continuousBackupsStatus;
    }

    public void setContinuousBackupsStatus(String str) {
        this.continuousBackupsStatus = str;
    }

    public ContinuousBackupsDescription withContinuousBackupsStatus(String str) {
        this.continuousBackupsStatus = str;
        return this;
    }

    public void setContinuousBackupsStatus(ContinuousBackupsStatus continuousBackupsStatus) {
        this.continuousBackupsStatus = continuousBackupsStatus.toString();
    }

    public ContinuousBackupsDescription withContinuousBackupsStatus(ContinuousBackupsStatus continuousBackupsStatus) {
        this.continuousBackupsStatus = continuousBackupsStatus.toString();
        return this;
    }

    public PointInTimeRecoveryDescription getPointInTimeRecoveryDescription() {
        return this.pointInTimeRecoveryDescription;
    }

    public void setPointInTimeRecoveryDescription(PointInTimeRecoveryDescription pointInTimeRecoveryDescription) {
        this.pointInTimeRecoveryDescription = pointInTimeRecoveryDescription;
    }

    public ContinuousBackupsDescription withPointInTimeRecoveryDescription(PointInTimeRecoveryDescription pointInTimeRecoveryDescription) {
        this.pointInTimeRecoveryDescription = pointInTimeRecoveryDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getContinuousBackupsStatus() != null) {
            sb.append("ContinuousBackupsStatus: " + getContinuousBackupsStatus() + Constants.SEPARATOR_COMMA);
        }
        if (getPointInTimeRecoveryDescription() != null) {
            sb.append("PointInTimeRecoveryDescription: " + getPointInTimeRecoveryDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getContinuousBackupsStatus() == null ? 0 : getContinuousBackupsStatus().hashCode()) + 31) * 31) + (getPointInTimeRecoveryDescription() != null ? getPointInTimeRecoveryDescription().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContinuousBackupsDescription)) {
            return false;
        }
        ContinuousBackupsDescription continuousBackupsDescription = (ContinuousBackupsDescription) obj;
        if ((continuousBackupsDescription.getContinuousBackupsStatus() == null) ^ (getContinuousBackupsStatus() == null)) {
            return false;
        }
        if (continuousBackupsDescription.getContinuousBackupsStatus() != null && !continuousBackupsDescription.getContinuousBackupsStatus().equals(getContinuousBackupsStatus())) {
            return false;
        }
        if ((continuousBackupsDescription.getPointInTimeRecoveryDescription() == null) ^ (getPointInTimeRecoveryDescription() == null)) {
            return false;
        }
        return continuousBackupsDescription.getPointInTimeRecoveryDescription() == null || continuousBackupsDescription.getPointInTimeRecoveryDescription().equals(getPointInTimeRecoveryDescription());
    }
}
