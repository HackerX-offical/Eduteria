package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class RestoreTableFromBackupResult implements Serializable {
    private TableDescription tableDescription;

    public TableDescription getTableDescription() {
        return this.tableDescription;
    }

    public void setTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
    }

    public RestoreTableFromBackupResult withTableDescription(TableDescription tableDescription) {
        this.tableDescription = tableDescription;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableDescription() != null) {
            sb.append("TableDescription: " + getTableDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getTableDescription() == null ? 0 : getTableDescription().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RestoreTableFromBackupResult)) {
            return false;
        }
        RestoreTableFromBackupResult restoreTableFromBackupResult = (RestoreTableFromBackupResult) obj;
        if ((restoreTableFromBackupResult.getTableDescription() == null) ^ (getTableDescription() == null)) {
            return false;
        }
        return restoreTableFromBackupResult.getTableDescription() == null || restoreTableFromBackupResult.getTableDescription().equals(getTableDescription());
    }
}
