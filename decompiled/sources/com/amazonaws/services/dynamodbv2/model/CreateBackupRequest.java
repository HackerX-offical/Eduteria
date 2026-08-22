package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class CreateBackupRequest extends AmazonWebServiceRequest implements Serializable {
    private String backupName;
    private String tableName;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public CreateBackupRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public String getBackupName() {
        return this.backupName;
    }

    public void setBackupName(String str) {
        this.backupName = str;
    }

    public CreateBackupRequest withBackupName(String str) {
        this.backupName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName() + Constants.SEPARATOR_COMMA);
        }
        if (getBackupName() != null) {
            sb.append("BackupName: " + getBackupName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((getTableName() == null ? 0 : getTableName().hashCode()) + 31) * 31) + (getBackupName() != null ? getBackupName().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateBackupRequest)) {
            return false;
        }
        CreateBackupRequest createBackupRequest = (CreateBackupRequest) obj;
        if ((createBackupRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        if (createBackupRequest.getTableName() != null && !createBackupRequest.getTableName().equals(getTableName())) {
            return false;
        }
        if ((createBackupRequest.getBackupName() == null) ^ (getBackupName() == null)) {
            return false;
        }
        return createBackupRequest.getBackupName() == null || createBackupRequest.getBackupName().equals(getBackupName());
    }
}
