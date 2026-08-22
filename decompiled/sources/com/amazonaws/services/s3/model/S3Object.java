package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.clevertap.android.sdk.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class S3Object implements Closeable, Serializable, S3RequesterChargedResult {
    private boolean isRequesterCharged;
    private transient S3ObjectInputStream objectContent;
    private String redirectLocation;
    private Integer taggingCount;
    private String key = null;
    private String bucketName = null;
    private ObjectMetadata metadata = new ObjectMetadata();

    public ObjectMetadata getObjectMetadata() {
        return this.metadata;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public S3ObjectInputStream getObjectContent() {
        return this.objectContent;
    }

    public void setObjectContent(S3ObjectInputStream s3ObjectInputStream) {
        this.objectContent = s3ObjectInputStream;
    }

    public void setObjectContent(InputStream inputStream) {
        S3ObjectInputStream s3ObjectInputStream = this.objectContent;
        setObjectContent(new S3ObjectInputStream(inputStream, s3ObjectInputStream != null ? s3ObjectInputStream.getHttpRequest() : null));
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public Integer getTaggingCount() {
        return this.taggingCount;
    }

    public void setTaggingCount(Integer num) {
        this.taggingCount = num;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("S3Object [key=").append(getKey()).append(",bucket=");
        String str = this.bucketName;
        if (str == null) {
            str = "<Unknown>";
        }
        return sbAppend.append(str).append(Constants.AES_SUFFIX).toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (getObjectContent() != null) {
            getObjectContent().close();
        }
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }
}
