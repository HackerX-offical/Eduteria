package com.amazonaws.services.kms.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class KeyMetadata implements Serializable {
    private String aWSAccountId;
    private String arn;
    private String cloudHsmClusterId;
    private Date creationDate;
    private String customKeyStoreId;
    private Date deletionDate;
    private String description;
    private Boolean enabled;
    private String expirationModel;
    private String keyId;
    private String keyManager;
    private String keyState;
    private String keyUsage;
    private String origin;
    private Date validTo;

    public String getAWSAccountId() {
        return this.aWSAccountId;
    }

    public void setAWSAccountId(String str) {
        this.aWSAccountId = str;
    }

    public KeyMetadata withAWSAccountId(String str) {
        this.aWSAccountId = str;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public KeyMetadata withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getArn() {
        return this.arn;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public KeyMetadata withArn(String str) {
        this.arn = str;
        return this;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public KeyMetadata withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public KeyMetadata withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public KeyMetadata withDescription(String str) {
        this.description = str;
        return this;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public KeyMetadata withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public void setKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
    }

    public KeyMetadata withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public String getKeyState() {
        return this.keyState;
    }

    public void setKeyState(String str) {
        this.keyState = str;
    }

    public KeyMetadata withKeyState(String str) {
        this.keyState = str;
        return this;
    }

    public void setKeyState(KeyState keyState) {
        this.keyState = keyState.toString();
    }

    public KeyMetadata withKeyState(KeyState keyState) {
        this.keyState = keyState.toString();
        return this;
    }

    public Date getDeletionDate() {
        return this.deletionDate;
    }

    public void setDeletionDate(Date date) {
        this.deletionDate = date;
    }

    public KeyMetadata withDeletionDate(Date date) {
        this.deletionDate = date;
        return this;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public void setValidTo(Date date) {
        this.validTo = date;
    }

    public KeyMetadata withValidTo(Date date) {
        this.validTo = date;
        return this;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public KeyMetadata withOrigin(String str) {
        this.origin = str;
        return this;
    }

    public void setOrigin(OriginType originType) {
        this.origin = originType.toString();
    }

    public KeyMetadata withOrigin(OriginType originType) {
        this.origin = originType.toString();
        return this;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public KeyMetadata withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public KeyMetadata withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public String getExpirationModel() {
        return this.expirationModel;
    }

    public void setExpirationModel(String str) {
        this.expirationModel = str;
    }

    public KeyMetadata withExpirationModel(String str) {
        this.expirationModel = str;
        return this;
    }

    public void setExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
    }

    public KeyMetadata withExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
        return this;
    }

    public String getKeyManager() {
        return this.keyManager;
    }

    public void setKeyManager(String str) {
        this.keyManager = str;
    }

    public KeyMetadata withKeyManager(String str) {
        this.keyManager = str;
        return this;
    }

    public void setKeyManager(KeyManagerType keyManagerType) {
        this.keyManager = keyManagerType.toString();
    }

    public KeyMetadata withKeyManager(KeyManagerType keyManagerType) {
        this.keyManager = keyManagerType.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getAWSAccountId() != null) {
            sb.append("AWSAccountId: " + getAWSAccountId() + Constants.SEPARATOR_COMMA);
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + Constants.SEPARATOR_COMMA);
        }
        if (getArn() != null) {
            sb.append("Arn: " + getArn() + Constants.SEPARATOR_COMMA);
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + Constants.SEPARATOR_COMMA);
        }
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + Constants.SEPARATOR_COMMA);
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription() + Constants.SEPARATOR_COMMA);
        }
        if (getKeyUsage() != null) {
            sb.append("KeyUsage: " + getKeyUsage() + Constants.SEPARATOR_COMMA);
        }
        if (getKeyState() != null) {
            sb.append("KeyState: " + getKeyState() + Constants.SEPARATOR_COMMA);
        }
        if (getDeletionDate() != null) {
            sb.append("DeletionDate: " + getDeletionDate() + Constants.SEPARATOR_COMMA);
        }
        if (getValidTo() != null) {
            sb.append("ValidTo: " + getValidTo() + Constants.SEPARATOR_COMMA);
        }
        if (getOrigin() != null) {
            sb.append("Origin: " + getOrigin() + Constants.SEPARATOR_COMMA);
        }
        if (getCustomKeyStoreId() != null) {
            sb.append("CustomKeyStoreId: " + getCustomKeyStoreId() + Constants.SEPARATOR_COMMA);
        }
        if (getCloudHsmClusterId() != null) {
            sb.append("CloudHsmClusterId: " + getCloudHsmClusterId() + Constants.SEPARATOR_COMMA);
        }
        if (getExpirationModel() != null) {
            sb.append("ExpirationModel: " + getExpirationModel() + Constants.SEPARATOR_COMMA);
        }
        if (getKeyManager() != null) {
            sb.append("KeyManager: " + getKeyManager());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((getAWSAccountId() == null ? 0 : getAWSAccountId().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getArn() == null ? 0 : getArn().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getEnabled() == null ? 0 : getEnabled().hashCode())) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31) + (getKeyUsage() == null ? 0 : getKeyUsage().hashCode())) * 31) + (getKeyState() == null ? 0 : getKeyState().hashCode())) * 31) + (getDeletionDate() == null ? 0 : getDeletionDate().hashCode())) * 31) + (getValidTo() == null ? 0 : getValidTo().hashCode())) * 31) + (getOrigin() == null ? 0 : getOrigin().hashCode())) * 31) + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode())) * 31) + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode())) * 31) + (getExpirationModel() == null ? 0 : getExpirationModel().hashCode())) * 31) + (getKeyManager() != null ? getKeyManager().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeyMetadata)) {
            return false;
        }
        KeyMetadata keyMetadata = (KeyMetadata) obj;
        if ((keyMetadata.getAWSAccountId() == null) ^ (getAWSAccountId() == null)) {
            return false;
        }
        if (keyMetadata.getAWSAccountId() != null && !keyMetadata.getAWSAccountId().equals(getAWSAccountId())) {
            return false;
        }
        if ((keyMetadata.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (keyMetadata.getKeyId() != null && !keyMetadata.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((keyMetadata.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        if (keyMetadata.getArn() != null && !keyMetadata.getArn().equals(getArn())) {
            return false;
        }
        if ((keyMetadata.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (keyMetadata.getCreationDate() != null && !keyMetadata.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((keyMetadata.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (keyMetadata.getEnabled() != null && !keyMetadata.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((keyMetadata.getDescription() == null) ^ (getDescription() == null)) {
            return false;
        }
        if (keyMetadata.getDescription() != null && !keyMetadata.getDescription().equals(getDescription())) {
            return false;
        }
        if ((keyMetadata.getKeyUsage() == null) ^ (getKeyUsage() == null)) {
            return false;
        }
        if (keyMetadata.getKeyUsage() != null && !keyMetadata.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if ((keyMetadata.getKeyState() == null) ^ (getKeyState() == null)) {
            return false;
        }
        if (keyMetadata.getKeyState() != null && !keyMetadata.getKeyState().equals(getKeyState())) {
            return false;
        }
        if ((keyMetadata.getDeletionDate() == null) ^ (getDeletionDate() == null)) {
            return false;
        }
        if (keyMetadata.getDeletionDate() != null && !keyMetadata.getDeletionDate().equals(getDeletionDate())) {
            return false;
        }
        if ((keyMetadata.getValidTo() == null) ^ (getValidTo() == null)) {
            return false;
        }
        if (keyMetadata.getValidTo() != null && !keyMetadata.getValidTo().equals(getValidTo())) {
            return false;
        }
        if ((keyMetadata.getOrigin() == null) ^ (getOrigin() == null)) {
            return false;
        }
        if (keyMetadata.getOrigin() != null && !keyMetadata.getOrigin().equals(getOrigin())) {
            return false;
        }
        if ((keyMetadata.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (keyMetadata.getCustomKeyStoreId() != null && !keyMetadata.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((keyMetadata.getCloudHsmClusterId() == null) ^ (getCloudHsmClusterId() == null)) {
            return false;
        }
        if (keyMetadata.getCloudHsmClusterId() != null && !keyMetadata.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if ((keyMetadata.getExpirationModel() == null) ^ (getExpirationModel() == null)) {
            return false;
        }
        if (keyMetadata.getExpirationModel() != null && !keyMetadata.getExpirationModel().equals(getExpirationModel())) {
            return false;
        }
        if ((keyMetadata.getKeyManager() == null) ^ (getKeyManager() == null)) {
            return false;
        }
        return keyMetadata.getKeyManager() == null || keyMetadata.getKeyManager().equals(getKeyManager());
    }
}
