package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class PointInTimeRecoveryDescription implements Serializable {
    private Date earliestRestorableDateTime;
    private Date latestRestorableDateTime;
    private String pointInTimeRecoveryStatus;

    public String getPointInTimeRecoveryStatus() {
        return this.pointInTimeRecoveryStatus;
    }

    public void setPointInTimeRecoveryStatus(String str) {
        this.pointInTimeRecoveryStatus = str;
    }

    public PointInTimeRecoveryDescription withPointInTimeRecoveryStatus(String str) {
        this.pointInTimeRecoveryStatus = str;
        return this;
    }

    public void setPointInTimeRecoveryStatus(PointInTimeRecoveryStatus pointInTimeRecoveryStatus) {
        this.pointInTimeRecoveryStatus = pointInTimeRecoveryStatus.toString();
    }

    public PointInTimeRecoveryDescription withPointInTimeRecoveryStatus(PointInTimeRecoveryStatus pointInTimeRecoveryStatus) {
        this.pointInTimeRecoveryStatus = pointInTimeRecoveryStatus.toString();
        return this;
    }

    public Date getEarliestRestorableDateTime() {
        return this.earliestRestorableDateTime;
    }

    public void setEarliestRestorableDateTime(Date date) {
        this.earliestRestorableDateTime = date;
    }

    public PointInTimeRecoveryDescription withEarliestRestorableDateTime(Date date) {
        this.earliestRestorableDateTime = date;
        return this;
    }

    public Date getLatestRestorableDateTime() {
        return this.latestRestorableDateTime;
    }

    public void setLatestRestorableDateTime(Date date) {
        this.latestRestorableDateTime = date;
    }

    public PointInTimeRecoveryDescription withLatestRestorableDateTime(Date date) {
        this.latestRestorableDateTime = date;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPointInTimeRecoveryStatus() != null) {
            sb.append("PointInTimeRecoveryStatus: " + getPointInTimeRecoveryStatus() + Constants.SEPARATOR_COMMA);
        }
        if (getEarliestRestorableDateTime() != null) {
            sb.append("EarliestRestorableDateTime: " + getEarliestRestorableDateTime() + Constants.SEPARATOR_COMMA);
        }
        if (getLatestRestorableDateTime() != null) {
            sb.append("LatestRestorableDateTime: " + getLatestRestorableDateTime());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getPointInTimeRecoveryStatus() == null ? 0 : getPointInTimeRecoveryStatus().hashCode()) + 31) * 31) + (getEarliestRestorableDateTime() == null ? 0 : getEarliestRestorableDateTime().hashCode())) * 31) + (getLatestRestorableDateTime() != null ? getLatestRestorableDateTime().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PointInTimeRecoveryDescription)) {
            return false;
        }
        PointInTimeRecoveryDescription pointInTimeRecoveryDescription = (PointInTimeRecoveryDescription) obj;
        if ((pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus() == null) ^ (getPointInTimeRecoveryStatus() == null)) {
            return false;
        }
        if (pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus() != null && !pointInTimeRecoveryDescription.getPointInTimeRecoveryStatus().equals(getPointInTimeRecoveryStatus())) {
            return false;
        }
        if ((pointInTimeRecoveryDescription.getEarliestRestorableDateTime() == null) ^ (getEarliestRestorableDateTime() == null)) {
            return false;
        }
        if (pointInTimeRecoveryDescription.getEarliestRestorableDateTime() != null && !pointInTimeRecoveryDescription.getEarliestRestorableDateTime().equals(getEarliestRestorableDateTime())) {
            return false;
        }
        if ((pointInTimeRecoveryDescription.getLatestRestorableDateTime() == null) ^ (getLatestRestorableDateTime() == null)) {
            return false;
        }
        return pointInTimeRecoveryDescription.getLatestRestorableDateTime() == null || pointInTimeRecoveryDescription.getLatestRestorableDateTime().equals(getLatestRestorableDateTime());
    }
}
