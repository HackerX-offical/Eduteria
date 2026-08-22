package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.util.json.JsonUtils;
import com.clevertap.android.sdk.Constants;
import com.google.gson.Gson;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes4.dex */
class TransferRecord {
    private static final Log LOGGER = LogFactory.getLog(TransferRecord.class);
    public String bucketName;
    public long bytesCurrent;
    public long bytesTotal;
    public String cannedAcl;
    public String eTag;
    public String expirationTimeRuleId;
    public String file;
    public long fileOffset;
    private Gson gson = new Gson();
    public String headerCacheControl;
    public String headerContentDisposition;
    public String headerContentEncoding;
    public String headerContentLanguage;
    public String headerContentType;
    public String headerExpire;
    public String headerStorageClass;
    public String httpExpires;
    public int id;
    public int isEncrypted;
    public int isLastPart;
    public int isMultipart;
    public int isRequesterPays;
    public String key;
    public int mainUploadId;
    public String md5;
    public String multipartId;
    public int partNumber;
    public long rangeLast;
    public long rangeStart;
    public long speed;
    public String sseAlgorithm;
    public String sseKMSKey;
    public TransferState state;
    private Future<?> submittedTask;
    public TransferUtilityOptions transferUtilityOptions;
    public TransferType type;
    public Map<String, String> userMetadata;
    public String versionId;

    public TransferRecord(int i) {
        this.id = i;
    }

    public void updateFromDB(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        this.mainUploadId = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_MAIN_UPLOAD_ID));
        this.type = TransferType.getType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
        this.state = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.bucketName = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BUCKET_NAME));
        this.key = cursor.getString(cursor.getColumnIndexOrThrow("key"));
        this.versionId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_VERSION_ID));
        this.bytesTotal = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_TOTAL));
        this.bytesCurrent = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_CURRENT));
        this.speed = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SPEED));
        this.isRequesterPays = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_REQUESTER_PAYS));
        this.isMultipart = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_MULTIPART));
        this.isLastPart = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_LAST_PART));
        this.isEncrypted = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_ENCRYPTED));
        this.partNumber = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM));
        this.eTag = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ETAG));
        this.file = cursor.getString(cursor.getColumnIndexOrThrow("file"));
        this.multipartId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_MULTIPART_ID));
        this.rangeStart = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_DATA_RANGE_START));
        this.rangeLast = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_DATA_RANGE_LAST));
        this.fileOffset = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_FILE_OFFSET));
        this.headerContentType = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_TYPE));
        this.headerContentLanguage = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_LANGUAGE));
        this.headerContentDisposition = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_DISPOSITION));
        this.headerContentEncoding = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_ENCODING));
        this.headerCacheControl = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CACHE_CONTROL));
        this.headerExpire = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_EXPIRE));
        this.userMetadata = JsonUtils.jsonToMap(cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_USER_METADATA)));
        this.expirationTimeRuleId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_EXPIRATION_TIME_RULE_ID));
        this.httpExpires = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HTTP_EXPIRES_DATE));
        this.sseAlgorithm = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SSE_ALGORITHM));
        this.sseKMSKey = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SSE_KMS_KEY));
        this.md5 = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_CONTENT_MD5));
        this.cannedAcl = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_CANNED_ACL));
        this.headerStorageClass = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_STORAGE_CLASS));
        this.transferUtilityOptions = (TransferUtilityOptions) this.gson.fromJson(cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_TRANSFER_UTILITY_OPTIONS)), TransferUtilityOptions.class);
    }

    public boolean start(AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        if (isRunning() || !checkIsReadyToRun() || !checkPreferredNetworkAvailability(transferStatusUpdater, connectivityManager)) {
            return false;
        }
        if (this.type.equals(TransferType.DOWNLOAD)) {
            this.submittedTask = TransferThreadPool.submitTask(new DownloadTask(this, amazonS3, transferStatusUpdater));
            return true;
        }
        this.submittedTask = TransferThreadPool.submitTask(new UploadTask(this, amazonS3, transferDBUtil, transferStatusUpdater));
        return true;
    }

    public boolean pause(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (isFinalState(this.state) || TransferState.PAUSED.equals(this.state)) {
            return false;
        }
        transferStatusUpdater.updateState(this.id, TransferState.PAUSED);
        if (isRunning()) {
            this.submittedTask.cancel(true);
        }
        return true;
    }

    boolean pauseIfRequiredForNetworkInterruption(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        boolean zCheckPreferredNetworkAvailability = checkPreferredNetworkAvailability(transferStatusUpdater, connectivityManager);
        boolean z = false;
        if (!zCheckPreferredNetworkAvailability && !isFinalState(this.state)) {
            z = true;
            if (isRunning()) {
                this.submittedTask.cancel(true);
            }
        }
        return z;
    }

    public boolean cancel(final AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (isFinalState(this.state)) {
            return false;
        }
        transferStatusUpdater.updateState(this.id, TransferState.CANCELED);
        if (isRunning()) {
            this.submittedTask.cancel(true);
        }
        if (TransferType.UPLOAD.equals(this.type) && this.isMultipart == 1) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        amazonS3.abortMultipartUpload(new AbortMultipartUploadRequest(TransferRecord.this.bucketName, TransferRecord.this.key, TransferRecord.this.multipartId));
                        TransferRecord.LOGGER.debug("Successfully clean up multipart upload: " + TransferRecord.this.id);
                    } catch (AmazonClientException e2) {
                        TransferRecord.LOGGER.debug("Failed to abort multiplart upload: " + TransferRecord.this.id, e2);
                    }
                }
            }).start();
        } else if (TransferType.DOWNLOAD.equals(this.type)) {
            new File(this.file).delete();
        }
        return true;
    }

    boolean isRunning() {
        Future<?> future = this.submittedTask;
        return (future == null || future.isDone()) ? false : true;
    }

    void waitTillFinish(long j) throws ExecutionException, InterruptedException, TimeoutException {
        if (isRunning()) {
            this.submittedTask.get(j, TimeUnit.MILLISECONDS);
        }
    }

    private boolean isFinalState(TransferState transferState) {
        return TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState);
    }

    private boolean checkIsReadyToRun() {
        return this.partNumber == 0 && !TransferState.COMPLETED.equals(this.state);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[id:");
        sb.append(this.id).append(",bucketName:").append(this.bucketName).append(",key:").append(this.key).append(",file:").append(this.file).append(",type:").append(this.type).append(",bytesTotal:").append(this.bytesTotal).append(",bytesCurrent:").append(this.bytesCurrent).append(",fileOffset:").append(this.fileOffset).append(",state:").append(this.state).append(",cannedAcl:").append(this.cannedAcl).append(",mainUploadId:").append(this.mainUploadId).append(",isMultipart:").append(this.isMultipart).append(",isLastPart:").append(this.isLastPart).append(",partNumber:").append(this.partNumber).append(",multipartId:").append(this.multipartId).append(",eTag:").append(this.eTag).append(",storageClass:").append(this.headerStorageClass).append(",userMetadata:").append(this.userMetadata.toString()).append(",transferUtilityOptions:").append(this.gson.toJson(this.transferUtilityOptions)).append(Constants.AES_SUFFIX);
        return sb.toString();
    }

    private boolean checkPreferredNetworkAvailability(TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        TransferUtilityOptions transferUtilityOptions;
        if (connectivityManager == null || (transferUtilityOptions = this.transferUtilityOptions) == null || transferUtilityOptions.getTransferNetworkConnectionType().isConnected(connectivityManager)) {
            return true;
        }
        LOGGER.info("Network Connection " + this.transferUtilityOptions.getTransferNetworkConnectionType() + " is not available.");
        transferStatusUpdater.updateState(this.id, TransferState.WAITING_FOR_NETWORK);
        return false;
    }
}
