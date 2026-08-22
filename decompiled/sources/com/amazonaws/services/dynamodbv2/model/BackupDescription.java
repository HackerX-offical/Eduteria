package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class BackupDescription implements Serializable {
    private BackupDetails backupDetails;
    private SourceTableDetails sourceTableDetails;
    private SourceTableFeatureDetails sourceTableFeatureDetails;

    public BackupDetails getBackupDetails() {
        return this.backupDetails;
    }

    public void setBackupDetails(BackupDetails backupDetails) {
        this.backupDetails = backupDetails;
    }

    public BackupDescription withBackupDetails(BackupDetails backupDetails) {
        this.backupDetails = backupDetails;
        return this;
    }

    public SourceTableDetails getSourceTableDetails() {
        return this.sourceTableDetails;
    }

    public void setSourceTableDetails(SourceTableDetails sourceTableDetails) {
        this.sourceTableDetails = sourceTableDetails;
    }

    public BackupDescription withSourceTableDetails(SourceTableDetails sourceTableDetails) {
        this.sourceTableDetails = sourceTableDetails;
        return this;
    }

    public SourceTableFeatureDetails getSourceTableFeatureDetails() {
        return this.sourceTableFeatureDetails;
    }

    public void setSourceTableFeatureDetails(SourceTableFeatureDetails sourceTableFeatureDetails) {
        this.sourceTableFeatureDetails = sourceTableFeatureDetails;
    }

    public BackupDescription withSourceTableFeatureDetails(SourceTableFeatureDetails sourceTableFeatureDetails) {
        this.sourceTableFeatureDetails = sourceTableFeatureDetails;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getBackupDetails() != null) {
            sb.append("BackupDetails: " + getBackupDetails() + Constants.SEPARATOR_COMMA);
        }
        if (getSourceTableDetails() != null) {
            sb.append("SourceTableDetails: " + getSourceTableDetails() + Constants.SEPARATOR_COMMA);
        }
        if (getSourceTableFeatureDetails() != null) {
            sb.append("SourceTableFeatureDetails: " + getSourceTableFeatureDetails());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getBackupDetails() == null ? 0 : getBackupDetails().hashCode()) + 31) * 31) + (getSourceTableDetails() == null ? 0 : getSourceTableDetails().hashCode())) * 31) + (getSourceTableFeatureDetails() != null ? getSourceTableFeatureDetails().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BackupDescription)) {
            return false;
        }
        BackupDescription backupDescription = (BackupDescription) obj;
        if ((backupDescription.getBackupDetails() == null) ^ (getBackupDetails() == null)) {
            return false;
        }
        if (backupDescription.getBackupDetails() != null && !backupDescription.getBackupDetails().equals(getBackupDetails())) {
            return false;
        }
        if ((backupDescription.getSourceTableDetails() == null) ^ (getSourceTableDetails() == null)) {
            return false;
        }
        if (backupDescription.getSourceTableDetails() != null && !backupDescription.getSourceTableDetails().equals(getSourceTableDetails())) {
            return false;
        }
        if ((backupDescription.getSourceTableFeatureDetails() == null) ^ (getSourceTableFeatureDetails() == null)) {
            return false;
        }
        return backupDescription.getSourceTableFeatureDetails() == null || backupDescription.getSourceTableFeatureDetails().equals(getSourceTableFeatureDetails());
    }
}
