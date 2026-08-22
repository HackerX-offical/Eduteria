package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class DescribeTimeToLiveResult implements Serializable {
    private TimeToLiveDescription timeToLiveDescription;

    public TimeToLiveDescription getTimeToLiveDescription() {
        return this.timeToLiveDescription;
    }

    public void setTimeToLiveDescription(TimeToLiveDescription timeToLiveDescription) {
        this.timeToLiveDescription = timeToLiveDescription;
    }

    public DescribeTimeToLiveResult withTimeToLiveDescription(TimeToLiveDescription timeToLiveDescription) {
        this.timeToLiveDescription = timeToLiveDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTimeToLiveDescription() != null) {
            sb.append("TimeToLiveDescription: " + getTimeToLiveDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getTimeToLiveDescription() == null ? 0 : getTimeToLiveDescription().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTimeToLiveResult)) {
            return false;
        }
        DescribeTimeToLiveResult describeTimeToLiveResult = (DescribeTimeToLiveResult) obj;
        if ((describeTimeToLiveResult.getTimeToLiveDescription() == null) ^ (getTimeToLiveDescription() == null)) {
            return false;
        }
        return describeTimeToLiveResult.getTimeToLiveDescription() == null || describeTimeToLiveResult.getTimeToLiveDescription().equals(getTimeToLiveDescription());
    }
}
