package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ListTablesRequest extends AmazonWebServiceRequest implements Serializable {
    private String exclusiveStartTableName;
    private Integer limit;

    public ListTablesRequest() {
    }

    public ListTablesRequest(String str) {
        setExclusiveStartTableName(str);
    }

    public ListTablesRequest(String str, Integer num) {
        setExclusiveStartTableName(str);
        setLimit(num);
    }

    public String getExclusiveStartTableName() {
        return this.exclusiveStartTableName;
    }

    public void setExclusiveStartTableName(String str) {
        this.exclusiveStartTableName = str;
    }

    public ListTablesRequest withExclusiveStartTableName(String str) {
        this.exclusiveStartTableName = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListTablesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getExclusiveStartTableName() != null) {
            sb.append("ExclusiveStartTableName: " + getExclusiveStartTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getExclusiveStartTableName() == null ? 0 : getExclusiveStartTableName().hashCode()) + 31) * 31) + (getLimit() != null ? getLimit().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTablesRequest)) {
            return false;
        }
        ListTablesRequest listTablesRequest = (ListTablesRequest) obj;
        if ((listTablesRequest.getExclusiveStartTableName() == null) ^ (getExclusiveStartTableName() == null)) {
            return false;
        }
        if (listTablesRequest.getExclusiveStartTableName() != null && !listTablesRequest.getExclusiveStartTableName().equals(getExclusiveStartTableName())) {
            return false;
        }
        if ((listTablesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        return listTablesRequest.getLimit() == null || listTablesRequest.getLimit().equals(getLimit());
    }
}
