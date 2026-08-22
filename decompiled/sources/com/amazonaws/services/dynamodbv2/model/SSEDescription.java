package com.amazonaws.services.dynamodbv2.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class SSEDescription implements Serializable {
    private String kMSMasterKeyArn;
    private String sSEType;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public SSEDescription withStatus(String str) {
        this.status = str;
        return this;
    }

    public void setStatus(SSEStatus sSEStatus) {
        this.status = sSEStatus.toString();
    }

    public SSEDescription withStatus(SSEStatus sSEStatus) {
        this.status = sSEStatus.toString();
        return this;
    }

    public String getSSEType() {
        return this.sSEType;
    }

    public void setSSEType(String str) {
        this.sSEType = str;
    }

    public SSEDescription withSSEType(String str) {
        this.sSEType = str;
        return this;
    }

    public void setSSEType(SSEType sSEType) {
        this.sSEType = sSEType.toString();
    }

    public SSEDescription withSSEType(SSEType sSEType) {
        this.sSEType = sSEType.toString();
        return this;
    }

    public String getKMSMasterKeyArn() {
        return this.kMSMasterKeyArn;
    }

    public void setKMSMasterKeyArn(String str) {
        this.kMSMasterKeyArn = str;
    }

    public SSEDescription withKMSMasterKeyArn(String str) {
        this.kMSMasterKeyArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + Constants.SEPARATOR_COMMA);
        }
        if (getSSEType() != null) {
            sb.append("SSEType: " + getSSEType() + Constants.SEPARATOR_COMMA);
        }
        if (getKMSMasterKeyArn() != null) {
            sb.append("KMSMasterKeyArn: " + getKMSMasterKeyArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getStatus() == null ? 0 : getStatus().hashCode()) + 31) * 31) + (getSSEType() == null ? 0 : getSSEType().hashCode())) * 31) + (getKMSMasterKeyArn() != null ? getKMSMasterKeyArn().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SSEDescription)) {
            return false;
        }
        SSEDescription sSEDescription = (SSEDescription) obj;
        if ((sSEDescription.getStatus() == null) ^ (getStatus() == null)) {
            return false;
        }
        if (sSEDescription.getStatus() != null && !sSEDescription.getStatus().equals(getStatus())) {
            return false;
        }
        if ((sSEDescription.getSSEType() == null) ^ (getSSEType() == null)) {
            return false;
        }
        if (sSEDescription.getSSEType() != null && !sSEDescription.getSSEType().equals(getSSEType())) {
            return false;
        }
        if ((sSEDescription.getKMSMasterKeyArn() == null) ^ (getKMSMasterKeyArn() == null)) {
            return false;
        }
        return sSEDescription.getKMSMasterKeyArn() == null || sSEDescription.getKMSMasterKeyArn().equals(getKMSMasterKeyArn());
    }
}
