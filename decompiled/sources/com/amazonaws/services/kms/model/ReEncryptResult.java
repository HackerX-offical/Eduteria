package com.amazonaws.services.kms.model;

import com.clevertap.android.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class ReEncryptResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String keyId;
    private String sourceKeyId;

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public ReEncryptResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public String getSourceKeyId() {
        return this.sourceKeyId;
    }

    public void setSourceKeyId(String str) {
        this.sourceKeyId = str;
    }

    public ReEncryptResult withSourceKeyId(String str) {
        this.sourceKeyId = str;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public ReEncryptResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + Constants.SEPARATOR_COMMA);
        }
        if (getSourceKeyId() != null) {
            sb.append("SourceKeyId: " + getSourceKeyId() + Constants.SEPARATOR_COMMA);
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return (((((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31) + (getSourceKeyId() == null ? 0 : getSourceKeyId().hashCode())) * 31) + (getKeyId() != null ? getKeyId().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReEncryptResult)) {
            return false;
        }
        ReEncryptResult reEncryptResult = (ReEncryptResult) obj;
        if ((reEncryptResult.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (reEncryptResult.getCiphertextBlob() != null && !reEncryptResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((reEncryptResult.getSourceKeyId() == null) ^ (getSourceKeyId() == null)) {
            return false;
        }
        if (reEncryptResult.getSourceKeyId() != null && !reEncryptResult.getSourceKeyId().equals(getSourceKeyId())) {
            return false;
        }
        if ((reEncryptResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return reEncryptResult.getKeyId() == null || reEncryptResult.getKeyId().equals(getKeyId());
    }
}
