package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateTimeToLiveRequest extends AmazonWebServiceRequest implements Serializable {
    private String tableName;
    private TimeToLiveSpecification timeToLiveSpecification;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public UpdateTimeToLiveRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public TimeToLiveSpecification getTimeToLiveSpecification() {
        return this.timeToLiveSpecification;
    }

    public void setTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification) {
        this.timeToLiveSpecification = timeToLiveSpecification;
    }

    public UpdateTimeToLiveRequest withTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification) {
        this.timeToLiveSpecification = timeToLiveSpecification;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getTimeToLiveSpecification() != null) {
            sb.append("TimeToLiveSpecification: " + getTimeToLiveSpecification());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getTimeToLiveSpecification() != null ? getTimeToLiveSpecification().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateTimeToLiveRequest)) {
            return false;
        }
        UpdateTimeToLiveRequest updateTimeToLiveRequest = (UpdateTimeToLiveRequest) obj;
        if ((updateTimeToLiveRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (updateTimeToLiveRequest.getTableName() != null && !updateTimeToLiveRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((updateTimeToLiveRequest.getTimeToLiveSpecification() == null) ^ (getTimeToLiveSpecification() == null)) {
            return false;
        }
        return updateTimeToLiveRequest.getTimeToLiveSpecification() == null || updateTimeToLiveRequest.getTimeToLiveSpecification().equals(getTimeToLiveSpecification());
    }
}
