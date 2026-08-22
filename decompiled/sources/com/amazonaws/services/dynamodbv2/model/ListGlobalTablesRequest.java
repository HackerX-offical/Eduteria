package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ListGlobalTablesRequest extends AmazonWebServiceRequest implements Serializable {
    private String exclusiveStartGlobalTableName;
    private Integer limit;
    private String regionName;

    public String getExclusiveStartGlobalTableName() {
        return this.exclusiveStartGlobalTableName;
    }

    public void setExclusiveStartGlobalTableName(String str) {
        this.exclusiveStartGlobalTableName = str;
    }

    public ListGlobalTablesRequest withExclusiveStartGlobalTableName(String str) {
        this.exclusiveStartGlobalTableName = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListGlobalTablesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public ListGlobalTablesRequest withRegionName(String str) {
        this.regionName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getExclusiveStartGlobalTableName() != null) {
            sb.append("ExclusiveStartGlobalTableName: " + getExclusiveStartGlobalTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + Constants.SEPARATOR_COMMA);
        }
        if (getRegionName() != null) {
            sb.append("RegionName: " + getRegionName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getExclusiveStartGlobalTableName() == null ? 0 : getExclusiveStartGlobalTableName().hashCode()) + 31) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31) + (getRegionName() != null ? getRegionName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListGlobalTablesRequest)) {
            return false;
        }
        ListGlobalTablesRequest listGlobalTablesRequest = (ListGlobalTablesRequest) obj;
        if ((listGlobalTablesRequest.getExclusiveStartGlobalTableName() == null) ^ (getExclusiveStartGlobalTableName() == null)) {
            return false;
        }
        if (listGlobalTablesRequest.getExclusiveStartGlobalTableName() != null && !listGlobalTablesRequest.getExclusiveStartGlobalTableName().equals(getExclusiveStartGlobalTableName())) {
            return false;
        }
        if ((listGlobalTablesRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listGlobalTablesRequest.getLimit() != null && !listGlobalTablesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listGlobalTablesRequest.getRegionName() == null) ^ (getRegionName() == null)) {
            return false;
        }
        return listGlobalTablesRequest.getRegionName() == null || listGlobalTablesRequest.getRegionName().equals(getRegionName());
    }
}
