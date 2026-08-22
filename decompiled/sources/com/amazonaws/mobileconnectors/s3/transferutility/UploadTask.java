package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import com.clevertap.android.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
class UploadTask implements Callable<Boolean> {
    private static final String OBJECT_TAGS_DELIMITER = "&";
    private static final String OBJECT_TAG_KEY_VALUE_SEPARATOR = "=";
    private static final String REQUESTER_PAYS = "requester";
    private final TransferDBUtil dbUtil;
    private List<UploadPartRequest> requestList;
    private final AmazonS3 s3;
    private final TransferStatusUpdater updater;
    private final TransferRecord upload;
    Map<Integer, UploadPartTaskMetadata> uploadPartTasks = new HashMap();
    private static final Log LOGGER = LogFactory.getLog(UploadTask.class);
    private static final Map<String, CannedAccessControlList> CANNED_ACL_MAP = new HashMap();

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            CANNED_ACL_MAP.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater) {
        this.upload = transferRecord;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
        this.updater = transferStatusUpdater;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        try {
            if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                return false;
            }
        } catch (TransferUtilityException e2) {
            LOGGER.error("TransferUtilityException: [" + e2 + Constants.AES_SUFFIX);
        }
        this.updater.updateState(this.upload.id, TransferState.IN_PROGRESS);
        if (this.upload.isMultipart == 1 && this.upload.partNumber == 0) {
            return uploadMultipartAndWaitForCompletion();
        }
        if (this.upload.isMultipart == 0) {
            return uploadSinglePartAndWaitForCompletion();
        }
        return false;
    }

    private Boolean uploadMultipartAndWaitForCompletion() throws ExecutionException {
        long j;
        if (this.upload.multipartId == null || this.upload.multipartId.isEmpty()) {
            PutObjectRequest putObjectRequestCreatePutObjectRequest = createPutObjectRequest(this.upload);
            TransferUtility.appendMultipartTransferServiceUserAgentString(putObjectRequestCreatePutObjectRequest);
            try {
                this.upload.multipartId = initiateMultipartUpload(putObjectRequestCreatePutObjectRequest);
                this.dbUtil.updateMultipartId(this.upload.id, this.upload.multipartId);
                j = 0;
            } catch (AmazonClientException e2) {
                LOGGER.error("Error initiating multipart upload: " + this.upload.id + " due to " + e2.getMessage(), e2);
                this.updater.throwError(this.upload.id, e2);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        } else {
            long jQueryBytesTransferredByMainUploadId = this.dbUtil.queryBytesTransferredByMainUploadId(this.upload.id);
            if (jQueryBytesTransferredByMainUploadId > 0) {
                LOGGER.info(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.upload.id), Long.valueOf(jQueryBytesTransferredByMainUploadId)));
            }
            j = jQueryBytesTransferredByMainUploadId;
        }
        UploadTaskProgressListener uploadTaskProgressListener = new UploadTaskProgressListener(this.upload);
        this.updater.updateProgress(this.upload.id, j, this.upload.bytesTotal, false);
        this.requestList = this.dbUtil.getNonCompletedPartRequestsFromDB(this.upload.id, this.upload.multipartId);
        LOGGER.info("Multipart upload " + this.upload.id + " in " + this.requestList.size() + " parts.");
        for (UploadPartRequest uploadPartRequest : this.requestList) {
            TransferUtility.appendMultipartTransferServiceUserAgentString(uploadPartRequest);
            UploadPartTaskMetadata uploadPartTaskMetadata = new UploadPartTaskMetadata();
            uploadPartTaskMetadata.uploadPartRequest = uploadPartRequest;
            uploadPartTaskMetadata.bytesTransferredSoFar = 0L;
            uploadPartTaskMetadata.state = TransferState.WAITING;
            this.uploadPartTasks.put(Integer.valueOf(uploadPartRequest.getPartNumber()), uploadPartTaskMetadata);
            UploadTaskProgressListener uploadTaskProgressListener2 = uploadTaskProgressListener;
            uploadPartTaskMetadata.uploadPartTask = TransferThreadPool.submitTask(new UploadPartTask(uploadPartTaskMetadata, uploadTaskProgressListener2, uploadPartRequest, this.s3, this.dbUtil));
            uploadTaskProgressListener = uploadTaskProgressListener2;
        }
        try {
            Iterator<UploadPartTaskMetadata> it = this.uploadPartTasks.values().iterator();
            boolean zBooleanValue = true;
            while (it.hasNext()) {
                zBooleanValue &= it.next().uploadPartTask.get().booleanValue();
            }
            if (!zBooleanValue) {
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                        return false;
                    }
                } catch (TransferUtilityException e3) {
                    LOGGER.error("TransferUtilityException: [" + e3 + Constants.AES_SUFFIX);
                }
            }
            LOGGER.info("Completing the multi-part upload transfer for " + this.upload.id);
            try {
                completeMultiPartUpload(this.upload.id, this.upload.bucketName, this.upload.key, this.upload.multipartId);
                this.updater.updateProgress(this.upload.id, this.upload.bytesTotal, this.upload.bytesTotal, true);
                this.updater.updateState(this.upload.id, TransferState.COMPLETED);
                return true;
            } catch (AmazonClientException e4) {
                LOGGER.error("Failed to complete multipart: " + this.upload.id + " due to " + e4.getMessage(), e4);
                abortMultiPartUpload(this.upload.id, this.upload.bucketName, this.upload.key, this.upload.multipartId);
                this.updater.throwError(this.upload.id, e4);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        } catch (Exception e5) {
            Log log = LOGGER;
            log.error("Upload resulted in an exception. " + e5);
            if (TransferState.CANCELED.equals(this.upload.state) || TransferState.PAUSED.equals(this.upload.state)) {
                log.info("Transfer is " + this.upload.state);
                return false;
            }
            Iterator<UploadPartTaskMetadata> it2 = this.uploadPartTasks.values().iterator();
            while (it2.hasNext()) {
                it2.next().uploadPartTask.cancel(true);
            }
            Iterator<UploadPartTaskMetadata> it3 = this.uploadPartTasks.values().iterator();
            while (it3.hasNext()) {
                if (TransferState.WAITING_FOR_NETWORK.equals(it3.next().state)) {
                    LOGGER.info("Individual part is WAITING_FOR_NETWORK.");
                    this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                    return false;
                }
            }
            try {
                if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                    LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                    this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                    return false;
                }
            } catch (TransferUtilityException e6) {
                LOGGER.error("TransferUtilityException: [" + e6 + Constants.AES_SUFFIX);
            }
            if (RetryUtils.isInterrupted(e5)) {
                LOGGER.info("Transfer is interrupted. " + e5);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
            LOGGER.error("Error encountered during multi-part upload: " + this.upload.id + " due to " + e5.getMessage(), e5);
            this.updater.throwError(this.upload.id, e5);
            this.updater.updateState(this.upload.id, TransferState.FAILED);
            return false;
        }
    }

    private Boolean uploadSinglePartAndWaitForCompletion() {
        PutObjectRequest putObjectRequestCreatePutObjectRequest = createPutObjectRequest(this.upload);
        ProgressListener progressListenerNewProgressListener = this.updater.newProgressListener(this.upload.id);
        long length = putObjectRequestCreatePutObjectRequest.getFile().length();
        TransferUtility.appendTransferServiceUserAgentString(putObjectRequestCreatePutObjectRequest);
        putObjectRequestCreatePutObjectRequest.setGeneralProgressListener(progressListenerNewProgressListener);
        try {
            this.s3.putObject(putObjectRequestCreatePutObjectRequest);
            this.updater.updateProgress(this.upload.id, length, length, true);
            this.updater.updateState(this.upload.id, TransferState.COMPLETED);
            return true;
        } catch (Exception e2) {
            if (TransferState.CANCELED.equals(this.upload.state)) {
                LOGGER.info("Transfer is " + this.upload.state);
                return false;
            }
            if (TransferState.PAUSED.equals(this.upload.state)) {
                LOGGER.info("Transfer is " + this.upload.state);
                new ProgressEvent(0L).setEventCode(32);
                progressListenerNewProgressListener.progressChanged(new ProgressEvent(0L));
                return false;
            }
            try {
                if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                    Log log = LOGGER;
                    log.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                    log.debug("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).setEventCode(32);
                    progressListenerNewProgressListener.progressChanged(new ProgressEvent(0L));
                    return false;
                }
            } catch (TransferUtilityException e3) {
                LOGGER.error("TransferUtilityException: [" + e3 + Constants.AES_SUFFIX);
            }
            if (RetryUtils.isInterrupted(e2)) {
                LOGGER.info("Transfer is interrupted. " + e2);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
            LOGGER.debug("Failed to upload: " + this.upload.id + " due to " + e2.getMessage());
            this.updater.throwError(this.upload.id, e2);
            this.updater.updateState(this.upload.id, TransferState.FAILED);
            return false;
        }
    }

    private void completeMultiPartUpload(int i, String str, String str2, String str3) throws AmazonClientException {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.dbUtil.queryPartETagsOfUpload(i));
        TransferUtility.appendMultipartTransferServiceUserAgentString(completeMultipartUploadRequest);
        this.s3.completeMultipartUpload(completeMultipartUploadRequest);
    }

    private void abortMultiPartUpload(int i, String str, String str2, String str3) {
        Log log = LOGGER;
        log.info("Aborting the multipart since complete multipart failed.");
        try {
            this.s3.abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
            log.debug("Successfully aborted multipart upload: " + i);
        } catch (AmazonClientException e2) {
            LOGGER.debug("Failed to abort the multipart upload: " + i, e2);
        }
    }

    private String initiateMultipartUpload(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest initiateMultipartUploadRequestWithSSEAwsKeyManagementParams = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata()).withSSEAwsKeyManagementParams(putObjectRequest.getSSEAwsKeyManagementParams());
        TransferUtility.appendMultipartTransferServiceUserAgentString(initiateMultipartUploadRequestWithSSEAwsKeyManagementParams);
        return this.s3.initiateMultipartUpload(initiateMultipartUploadRequestWithSSEAwsKeyManagementParams).getUploadId();
    }

    private PutObjectRequest createPutObjectRequest(TransferRecord transferRecord) {
        File file = new File(transferRecord.file);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.bucketName, transferRecord.key, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.length());
        if (transferRecord.headerCacheControl != null) {
            objectMetadata.setCacheControl(transferRecord.headerCacheControl);
        }
        if (transferRecord.headerContentDisposition != null) {
            objectMetadata.setContentDisposition(transferRecord.headerContentDisposition);
        }
        if (transferRecord.headerContentEncoding != null) {
            objectMetadata.setContentEncoding(transferRecord.headerContentEncoding);
        }
        if (transferRecord.headerContentType != null) {
            objectMetadata.setContentType(transferRecord.headerContentType);
        } else {
            objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
        }
        if (transferRecord.headerStorageClass != null) {
            putObjectRequest.setStorageClass(transferRecord.headerStorageClass);
        }
        if (transferRecord.expirationTimeRuleId != null) {
            objectMetadata.setExpirationTimeRuleId(transferRecord.expirationTimeRuleId);
        }
        if (transferRecord.httpExpires != null) {
            objectMetadata.setHttpExpiresDate(new Date(Long.valueOf(transferRecord.httpExpires).longValue()));
        }
        if (transferRecord.sseAlgorithm != null) {
            objectMetadata.setSSEAlgorithm(transferRecord.sseAlgorithm);
        }
        if (transferRecord.userMetadata != null) {
            objectMetadata.setUserMetadata(transferRecord.userMetadata);
            String str = transferRecord.userMetadata.get(Headers.S3_TAGGING);
            if (str != null) {
                try {
                    String[] strArrSplit = str.split(OBJECT_TAGS_DELIMITER);
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : strArrSplit) {
                        String[] strArrSplit2 = str2.split(OBJECT_TAG_KEY_VALUE_SEPARATOR);
                        arrayList.add(new Tag(strArrSplit2[0], strArrSplit2[1]));
                    }
                    putObjectRequest.setTagging(new ObjectTagging(arrayList));
                } catch (Exception e2) {
                    LOGGER.error("Error in passing the object tags as request headers.", e2);
                }
            }
            String str3 = transferRecord.userMetadata.get(Headers.REDIRECT_LOCATION);
            if (str3 != null) {
                putObjectRequest.setRedirectLocation(str3);
            }
            String str4 = transferRecord.userMetadata.get(Headers.REQUESTER_PAYS_HEADER);
            if (str4 != null) {
                putObjectRequest.setRequesterPays("requester".equals(str4));
            }
        }
        if (transferRecord.md5 != null) {
            objectMetadata.setContentMD5(transferRecord.md5);
        }
        if (transferRecord.sseKMSKey != null) {
            putObjectRequest.setSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(transferRecord.sseKMSKey));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setCannedAcl(getCannedAclFromString(transferRecord.cannedAcl));
        return putObjectRequest;
    }

    private static CannedAccessControlList getCannedAclFromString(String str) {
        if (str == null) {
            return null;
        }
        return CANNED_ACL_MAP.get(str);
    }

    class UploadTaskProgressListener implements ProgressListener {
        private long prevTotalBytesTransferredOfAllParts;

        @Override // com.amazonaws.event.ProgressListener
        public void progressChanged(ProgressEvent progressEvent) {
        }

        UploadTaskProgressListener(TransferRecord transferRecord) {
            this.prevTotalBytesTransferredOfAllParts = transferRecord.bytesCurrent;
        }

        public synchronized void onProgressChanged(int i, long j) {
            UploadPartTaskMetadata uploadPartTaskMetadata = UploadTask.this.uploadPartTasks.get(Integer.valueOf(i));
            if (uploadPartTaskMetadata == null) {
                UploadTask.LOGGER.info("Update received for unknown part. Ignoring.");
                return;
            }
            uploadPartTaskMetadata.bytesTransferredSoFar = j;
            Iterator<Map.Entry<Integer, UploadPartTaskMetadata>> it = UploadTask.this.uploadPartTasks.entrySet().iterator();
            long j2 = 0;
            while (it.hasNext()) {
                j2 += it.next().getValue().bytesTransferredSoFar;
            }
            if (j2 > this.prevTotalBytesTransferredOfAllParts) {
                UploadTask.this.updater.updateProgress(UploadTask.this.upload.id, j2, UploadTask.this.upload.bytesTotal, true);
                this.prevTotalBytesTransferredOfAllParts = j2;
            }
        }
    }

    class UploadPartTaskMetadata {
        long bytesTransferredSoFar;
        TransferState state;
        UploadPartRequest uploadPartRequest;
        Future<Boolean> uploadPartTask;

        UploadPartTaskMetadata() {
        }
    }
}
