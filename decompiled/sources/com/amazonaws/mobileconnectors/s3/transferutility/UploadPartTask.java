package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.UploadTask;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import com.clevertap.android.sdk.Constants;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
class UploadPartTask implements Callable<Boolean> {
    private static final Log LOGGER = LogFactory.getLog(UploadPartTask.class);
    private final TransferDBUtil dbUtil;
    private final AmazonS3 s3;
    private final UploadPartRequest uploadPartRequest;
    private final UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata;
    private final UploadTask.UploadTaskProgressListener uploadTaskProgressListener;

    public UploadPartTask(UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata, UploadTask.UploadTaskProgressListener uploadTaskProgressListener, UploadPartRequest uploadPartRequest, AmazonS3 amazonS3, TransferDBUtil transferDBUtil) {
        this.uploadPartTaskMetadata = uploadPartTaskMetadata;
        this.uploadTaskProgressListener = uploadTaskProgressListener;
        this.uploadPartRequest = uploadPartRequest;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        try {
            this.uploadPartTaskMetadata.state = TransferState.IN_PROGRESS;
            this.uploadPartRequest.setGeneralProgressListener(new UploadPartTaskProgressListener(this.uploadTaskProgressListener));
            UploadPartResult uploadPartResultUploadPart = this.s3.uploadPart(this.uploadPartRequest);
            this.uploadPartTaskMetadata.state = TransferState.PART_COMPLETED;
            this.dbUtil.updateState(this.uploadPartRequest.getId(), TransferState.PART_COMPLETED);
            this.dbUtil.updateETag(this.uploadPartRequest.getId(), uploadPartResultUploadPart.getETag());
            return true;
        } catch (Exception e2) {
            Log log = LOGGER;
            log.error("Upload part interrupted: " + e2);
            new ProgressEvent(0L).setEventCode(32);
            this.uploadTaskProgressListener.progressChanged(new ProgressEvent(0L));
            try {
                if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                    log.info("Thread: [" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.uploadPartTaskMetadata.state = TransferState.WAITING_FOR_NETWORK;
                    this.dbUtil.updateState(this.uploadPartRequest.getId(), TransferState.WAITING_FOR_NETWORK);
                    log.info("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    return false;
                }
            } catch (TransferUtilityException e3) {
                LOGGER.error("TransferUtilityException: [" + e3 + Constants.AES_SUFFIX);
            }
            this.uploadPartTaskMetadata.state = TransferState.FAILED;
            this.dbUtil.updateState(this.uploadPartRequest.getId(), TransferState.FAILED);
            LOGGER.error("Encountered error uploading part ", e2);
            throw e2;
        }
    }

    private class UploadPartTaskProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private UploadTask.UploadTaskProgressListener uploadTaskProgressListener;

        public UploadPartTaskProgressListener(UploadTask.UploadTaskProgressListener uploadTaskProgressListener) {
            this.uploadTaskProgressListener = uploadTaskProgressListener;
        }

        @Override // com.amazonaws.event.ProgressListener
        public void progressChanged(ProgressEvent progressEvent) {
            if (32 == progressEvent.getEventCode()) {
                UploadPartTask.LOGGER.info("Reset Event triggerred. Resetting the bytesCurrent to 0.");
                this.bytesTransferredSoFar = 0L;
            } else {
                this.bytesTransferredSoFar += progressEvent.getBytesTransferred();
            }
            this.uploadTaskProgressListener.onProgressChanged(UploadPartTask.this.uploadPartRequest.getPartNumber(), this.bytesTransferredSoFar);
        }
    }
}
