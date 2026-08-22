package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class PointInTimeRecoverySpecification implements Serializable {
    private Boolean pointInTimeRecoveryEnabled;

    public Boolean isPointInTimeRecoveryEnabled() {
        return this.pointInTimeRecoveryEnabled;
    }

    public Boolean getPointInTimeRecoveryEnabled() {
        return this.pointInTimeRecoveryEnabled;
    }

    public void setPointInTimeRecoveryEnabled(Boolean bool) {
        this.pointInTimeRecoveryEnabled = bool;
    }

    public PointInTimeRecoverySpecification withPointInTimeRecoveryEnabled(Boolean bool) {
        this.pointInTimeRecoveryEnabled = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPointInTimeRecoveryEnabled() != null) {
            sb.append("PointInTimeRecoveryEnabled: " + getPointInTimeRecoveryEnabled());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getPointInTimeRecoveryEnabled() == null ? 0 : getPointInTimeRecoveryEnabled().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PointInTimeRecoverySpecification)) {
            return false;
        }
        PointInTimeRecoverySpecification pointInTimeRecoverySpecification = (PointInTimeRecoverySpecification) obj;
        if ((pointInTimeRecoverySpecification.getPointInTimeRecoveryEnabled() == null) ^ (getPointInTimeRecoveryEnabled() == null)) {
            return false;
        }
        return pointInTimeRecoverySpecification.getPointInTimeRecoveryEnabled() == null || pointInTimeRecoverySpecification.getPointInTimeRecoveryEnabled().equals(getPointInTimeRecoveryEnabled());
    }
}
