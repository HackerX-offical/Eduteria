package com.amazonaws.services.s3.model;

/* JADX INFO: loaded from: classes4.dex */
public class ReplicationDestinationConfig {
    private String bucketARN;
    private String storageClass;

    public String getBucketARN() {
        return this.bucketARN;
    }

    public void setBucketARN(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Bucket name cannot be null");
        }
        this.bucketARN = str;
    }

    public ReplicationDestinationConfig withBucketARN(String str) {
        setBucketARN(str);
        return this;
    }

    public void setStorageClass(String str) {
        this.storageClass = str;
    }

    public void setStorageClass(StorageClass storageClass) {
        String string;
        if (storageClass == null) {
            string = null;
        } else {
            string = storageClass.toString();
        }
        setStorageClass(string);
    }

    public ReplicationDestinationConfig withStorageClass(String str) {
        setStorageClass(str);
        return this;
    }

    public ReplicationDestinationConfig withStorageClass(StorageClass storageClass) {
        String string;
        if (storageClass == null) {
            string = null;
        } else {
            string = storageClass.toString();
        }
        setStorageClass(string);
        return this;
    }

    public String getStorageClass() {
        return this.storageClass;
    }
}
