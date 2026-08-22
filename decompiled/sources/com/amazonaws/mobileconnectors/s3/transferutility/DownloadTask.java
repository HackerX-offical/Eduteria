package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.clevertap.android.sdk.Constants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
class DownloadTask implements Callable<Boolean> {
    private static final Log LOGGER = LogFactory.getLog(DownloadTask.class);
    private static final int SIXTEEN_KB = 16384;
    private final TransferRecord download;
    private final AmazonS3 s3;
    private final TransferStatusUpdater updater;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        this.download = transferRecord;
        this.s3 = amazonS3;
        this.updater = transferStatusUpdater;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Throwable {
        boolean z;
        try {
            if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                LOGGER.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
                return false;
            }
        } catch (TransferUtilityException e2) {
            LOGGER.error("TransferUtilityException: [" + e2 + Constants.AES_SUFFIX);
        }
        this.updater.updateState(this.download.id, TransferState.IN_PROGRESS);
        ProgressListener progressListenerNewProgressListener = this.updater.newProgressListener(this.download.id);
        try {
            GetObjectRequest getObjectRequest = new GetObjectRequest(this.download.bucketName, this.download.key);
            TransferUtility.appendTransferServiceUserAgentString(getObjectRequest);
            File file = new File(this.download.file);
            long length = file.length();
            if (length > 0) {
                z = false;
                try {
                    LOGGER.debug(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.download.id), Long.valueOf(length)));
                    getObjectRequest.setRange(length, -1L);
                } catch (Exception e3) {
                    e = e3;
                    Exception exc = e;
                    if (TransferState.CANCELED.equals(this.download.state)) {
                        LOGGER.info("Transfer is " + this.download.state);
                        return Boolean.valueOf(z);
                    }
                    if (TransferState.PAUSED.equals(this.download.state)) {
                        LOGGER.info("Transfer is " + this.download.state);
                        new ProgressEvent(0L).setEventCode(32);
                        progressListenerNewProgressListener.progressChanged(new ProgressEvent(0L));
                        return Boolean.valueOf(z);
                    }
                    try {
                        if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                            Log log = LOGGER;
                            log.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                            this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
                            log.debug("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                            new ProgressEvent(0L).setEventCode(32);
                            progressListenerNewProgressListener.progressChanged(new ProgressEvent(0L));
                            return Boolean.valueOf(z);
                        }
                    } catch (TransferUtilityException e4) {
                        LOGGER.error("TransferUtilityException: [" + e4 + Constants.AES_SUFFIX);
                    }
                    if (RetryUtils.isInterrupted(exc)) {
                        LOGGER.info("Transfer is interrupted. " + exc);
                        this.updater.updateState(this.download.id, TransferState.FAILED);
                        return Boolean.valueOf(z);
                    }
                    LOGGER.debug("Failed to download: " + this.download.id + " due to " + exc.getMessage());
                    this.updater.throwError(this.download.id, exc);
                    this.updater.updateState(this.download.id, TransferState.FAILED);
                    return Boolean.valueOf(z);
                }
            } else {
                z = false;
            }
            getObjectRequest.setGeneralProgressListener(progressListenerNewProgressListener);
            S3Object object = this.s3.getObject(getObjectRequest);
            if (object == null) {
                this.updater.throwError(this.download.id, new IllegalStateException("AmazonS3.getObject returns null"));
                this.updater.updateState(this.download.id, TransferState.FAILED);
                return Boolean.valueOf(z);
            }
            long instanceLength = object.getObjectMetadata().getInstanceLength();
            this.updater.updateProgress(this.download.id, length, instanceLength, true);
            saveToFile(object.getObjectContent(), file);
            this.updater.updateProgress(this.download.id, instanceLength, instanceLength, true);
            this.updater.updateState(this.download.id, TransferState.COMPLETED);
            return true;
        } catch (Exception e5) {
            e = e5;
            z = false;
        }
    }

    private void saveToFile(InputStream inputStream, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, file.length() > 0));
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        try {
                            break;
                        } catch (IOException e2) {
                            LOGGER.warn("got exception", e2);
                        }
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        LOGGER.warn("got exception", e3);
                    }
                }
            } catch (SocketTimeoutException e4) {
                e = e4;
                String str = "SocketTimeoutException: Unable to retrieve contents over network: " + e.getMessage();
                LOGGER.error(str);
                throw new AmazonClientException(str, e);
            } catch (IOException e5) {
                e = e5;
                throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e6) {
                        LOGGER.warn("got exception", e6);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        LOGGER.warn("got exception", e7);
                        throw th;
                    }
                }
                throw th;
            }
        } catch (SocketTimeoutException e8) {
            e = e8;
        } catch (IOException e9) {
            e = e9;
        }
    }
}
