package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ListGlobalTablesResult implements Serializable {
    private List<GlobalTable> globalTables;
    private String lastEvaluatedGlobalTableName;

    public List<GlobalTable> getGlobalTables() {
        return this.globalTables;
    }

    public void setGlobalTables(Collection<GlobalTable> collection) {
        if (collection == null) {
            this.globalTables = null;
        } else {
            this.globalTables = new ArrayList(collection);
        }
    }

    public ListGlobalTablesResult withGlobalTables(GlobalTable... globalTableArr) {
        if (getGlobalTables() == null) {
            this.globalTables = new ArrayList(globalTableArr.length);
        }
        for (GlobalTable globalTable : globalTableArr) {
            this.globalTables.add(globalTable);
        }
        return this;
    }

    public ListGlobalTablesResult withGlobalTables(Collection<GlobalTable> collection) {
        setGlobalTables(collection);
        return this;
    }

    public String getLastEvaluatedGlobalTableName() {
        return this.lastEvaluatedGlobalTableName;
    }

    public void setLastEvaluatedGlobalTableName(String str) {
        this.lastEvaluatedGlobalTableName = str;
    }

    public ListGlobalTablesResult withLastEvaluatedGlobalTableName(String str) {
        this.lastEvaluatedGlobalTableName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTables() != null) {
            sb.append("GlobalTables: " + getGlobalTables() + Constants.SEPARATOR_COMMA);
        }
        if (getLastEvaluatedGlobalTableName() != null) {
            sb.append("LastEvaluatedGlobalTableName: " + getLastEvaluatedGlobalTableName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getGlobalTables() == null ? 0 : getGlobalTables().hashCode()) + 31) * 31) + (getLastEvaluatedGlobalTableName() != null ? getLastEvaluatedGlobalTableName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListGlobalTablesResult)) {
            return false;
        }
        ListGlobalTablesResult listGlobalTablesResult = (ListGlobalTablesResult) obj;
        if ((listGlobalTablesResult.getGlobalTables() == null) ^ (getGlobalTables() == null)) {
            return false;
        }
        if (listGlobalTablesResult.getGlobalTables() != null && !listGlobalTablesResult.getGlobalTables().equals(getGlobalTables())) {
            return false;
        }
        if ((listGlobalTablesResult.getLastEvaluatedGlobalTableName() == null) ^ (getLastEvaluatedGlobalTableName() == null)) {
            return false;
        }
        return listGlobalTablesResult.getLastEvaluatedGlobalTableName() == null || listGlobalTablesResult.getLastEvaluatedGlobalTableName().equals(getLastEvaluatedGlobalTableName());
    }
}
