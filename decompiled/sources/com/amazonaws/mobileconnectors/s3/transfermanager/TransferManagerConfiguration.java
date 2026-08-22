package com.amazonaws.mobileconnectors.s3.transfermanager;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TransferManagerConfiguration {
    private static final long DEFAULT_MINIMUM_COPY_PART_SIZE = 104857600;
    private static final int DEFAULT_MINIMUM_UPLOAD_PART_SIZE = 5242880;
    private static final long DEFAULT_MULTIPART_COPY_THRESHOLD = 5368709120L;
    private static final long DEFAULT_MULTIPART_UPLOAD_THRESHOLD = 16777216;
    private long minimumUploadPartSize = 5242880;
    private long multipartUploadThreshold = DEFAULT_MULTIPART_UPLOAD_THRESHOLD;
    private long multipartCopyThreshold = DEFAULT_MULTIPART_COPY_THRESHOLD;
    private long multipartCopyPartSize = DEFAULT_MINIMUM_COPY_PART_SIZE;

    public long getMinimumUploadPartSize() {
        return this.minimumUploadPartSize;
    }

    public void setMinimumUploadPartSize(long j) {
        this.minimumUploadPartSize = j;
    }

    public long getMultipartUploadThreshold() {
        return this.multipartUploadThreshold;
    }

    public void setMultipartUploadThreshold(long j) {
        this.multipartUploadThreshold = j;
    }

    public long getMultipartCopyPartSize() {
        return this.multipartCopyPartSize;
    }

    public void setMultipartCopyPartSize(long j) {
        this.multipartCopyPartSize = j;
    }

    public long getMultipartCopyThreshold() {
        return this.multipartCopyThreshold;
    }

    public void setMultipartCopyThreshold(long j) {
        this.multipartCopyThreshold = j;
    }
}
