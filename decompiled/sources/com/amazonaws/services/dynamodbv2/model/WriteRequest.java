package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class WriteRequest implements Serializable {
    private DeleteRequest deleteRequest;
    private PutRequest putRequest;

    public WriteRequest() {
    }

    public WriteRequest(PutRequest putRequest) {
        setPutRequest(putRequest);
    }

    public WriteRequest(DeleteRequest deleteRequest) {
        setDeleteRequest(deleteRequest);
    }

    public PutRequest getPutRequest() {
        return this.putRequest;
    }

    public void setPutRequest(PutRequest putRequest) {
        this.putRequest = putRequest;
    }

    public WriteRequest withPutRequest(PutRequest putRequest) {
        this.putRequest = putRequest;
        return this;
    }

    public DeleteRequest getDeleteRequest() {
        return this.deleteRequest;
    }

    public void setDeleteRequest(DeleteRequest deleteRequest) {
        this.deleteRequest = deleteRequest;
    }

    public WriteRequest withDeleteRequest(DeleteRequest deleteRequest) {
        this.deleteRequest = deleteRequest;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPutRequest() != null) {
            sb.append("PutRequest: " + getPutRequest() + Constants.SEPARATOR_COMMA);
        }
        if (getDeleteRequest() != null) {
            sb.append("DeleteRequest: " + getDeleteRequest());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getPutRequest() == null ? 0 : getPutRequest().hashCode()) + 31) * 31) + (getDeleteRequest() != null ? getDeleteRequest().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WriteRequest)) {
            return false;
        }
        WriteRequest writeRequest = (WriteRequest) obj;
        if ((writeRequest.getPutRequest() == null) ^ (getPutRequest() == null)) {
            return false;
        }
        if (writeRequest.getPutRequest() != null && !writeRequest.getPutRequest().equals(getPutRequest())) {
            return false;
        }
        if ((writeRequest.getDeleteRequest() == null) ^ (getDeleteRequest() == null)) {
            return false;
        }
        return writeRequest.getDeleteRequest() == null || writeRequest.getDeleteRequest().equals(getDeleteRequest());
    }
}
