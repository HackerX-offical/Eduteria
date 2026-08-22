package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateTimeToLiveResult implements Serializable {
    private TimeToLiveSpecification timeToLiveSpecification;

    public TimeToLiveSpecification getTimeToLiveSpecification() {
        return this.timeToLiveSpecification;
    }

    public void setTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification) {
        this.timeToLiveSpecification = timeToLiveSpecification;
    }

    public UpdateTimeToLiveResult withTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification) {
        this.timeToLiveSpecification = timeToLiveSpecification;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTimeToLiveSpecification() != null) {
            sb.append("TimeToLiveSpecification: " + getTimeToLiveSpecification());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getTimeToLiveSpecification() == null ? 0 : getTimeToLiveSpecification().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateTimeToLiveResult)) {
            return false;
        }
        UpdateTimeToLiveResult updateTimeToLiveResult = (UpdateTimeToLiveResult) obj;
        if ((updateTimeToLiveResult.getTimeToLiveSpecification() == null) ^ (getTimeToLiveSpecification() == null)) {
            return false;
        }
        return updateTimeToLiveResult.getTimeToLiveSpecification() == null || updateTimeToLiveResult.getTimeToLiveSpecification().equals(getTimeToLiveSpecification());
    }
}
