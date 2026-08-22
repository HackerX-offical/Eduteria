package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListenerCallbackExecutor;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.CopyResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.PartETag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class CopyMonitor implements Callable<CopyResult>, TransferMonitor {
    private final CopyObjectRequest copyObjectRequest;
    private final CopyCallable multipartCopyCallable;
    private Future<CopyResult> nextFuture;
    private final ProgressListenerCallbackExecutor progressListenerChainCallbackExecutor;
    private final AmazonS3 s3;
    private final ExecutorService threadPool;
    private ScheduledExecutorService timedThreadPool;
    private final CopyImpl transfer;
    private String uploadId;
    private final List<Future<PartETag>> futures = new ArrayList();
    private boolean isCopyDone = false;
    private int pollInterval = 5000;

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized Future<CopyResult> getFuture() {
        return this.nextFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void setNextFuture(Future<CopyResult> future) {
        this.nextFuture = future;
    }

    @Override // com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferMonitor
    public synchronized boolean isDone() {
        return this.isCopyDone;
    }

    private synchronized void markAllDone() {
        this.isCopyDone = true;
    }

    public CopyMonitor(TransferManager transferManager, CopyImpl copyImpl, ExecutorService executorService, CopyCallable copyCallable, CopyObjectRequest copyObjectRequest, ProgressListenerChain progressListenerChain) {
        this.s3 = transferManager.getAmazonS3Client();
        this.multipartCopyCallable = copyCallable;
        this.threadPool = executorService;
        this.copyObjectRequest = copyObjectRequest;
        this.transfer = copyImpl;
        this.progressListenerChainCallbackExecutor = ProgressListenerCallbackExecutor.wrapListener(progressListenerChain);
        setNextFuture(executorService.submit(this));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public CopyResult call() throws Exception {
        try {
            if (this.uploadId == null) {
                return copy();
            }
            return poll();
        } catch (CancellationException unused) {
            this.transfer.setState(Transfer.TransferState.Canceled);
            fireProgressEvent(16);
            throw new AmazonClientException("Upload canceled");
        } catch (Exception e2) {
            this.transfer.setState(Transfer.TransferState.Failed);
            fireProgressEvent(8);
            throw e2;
        }
    }

    public void setTimedThreadPool(ScheduledExecutorService scheduledExecutorService) {
        this.timedThreadPool = scheduledExecutorService;
    }

    private CopyResult poll() throws InterruptedException {
        Iterator<Future<PartETag>> it = this.futures.iterator();
        while (it.hasNext()) {
            if (!it.next().isDone()) {
                reschedule();
                return null;
            }
        }
        Iterator<Future<PartETag>> it2 = this.futures.iterator();
        while (it2.hasNext()) {
            if (it2.next().isCancelled()) {
                throw new CancellationException();
            }
        }
        return completeMultipartUpload();
    }

    private void fireProgressEvent(int i) {
        if (this.progressListenerChainCallbackExecutor == null) {
            return;
        }
        ProgressEvent progressEvent = new ProgressEvent(0L);
        progressEvent.setEventCode(i);
        this.progressListenerChainCallbackExecutor.progressChanged(progressEvent);
    }

    private CopyResult copy() throws Exception {
        CopyResult copyResultCall = this.multipartCopyCallable.call();
        if (copyResultCall != null) {
            copyComplete();
            return copyResultCall;
        }
        this.uploadId = this.multipartCopyCallable.getMultipartUploadId();
        this.futures.addAll(this.multipartCopyCallable.getFutures());
        reschedule();
        return copyResultCall;
    }

    private void copyComplete() {
        markAllDone();
        this.transfer.setState(Transfer.TransferState.Completed);
        if (this.multipartCopyCallable.isMultipartCopy()) {
            fireProgressEvent(4);
        }
    }

    private void reschedule() {
        setNextFuture(this.timedThreadPool.schedule(new Callable<CopyResult>() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyMonitor.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public CopyResult call() throws Exception {
                CopyMonitor copyMonitor = CopyMonitor.this;
                copyMonitor.setNextFuture(copyMonitor.threadPool.submit(CopyMonitor.this));
                return null;
            }
        }, this.pollInterval, TimeUnit.MILLISECONDS));
    }

    private CopyResult completeMultipartUpload() {
        CompleteMultipartUploadResult completeMultipartUploadResultCompleteMultipartUpload = this.s3.completeMultipartUpload(new CompleteMultipartUploadRequest(this.copyObjectRequest.getDestinationBucketName(), this.copyObjectRequest.getDestinationKey(), this.uploadId, collectPartETags()));
        copyComplete();
        CopyResult copyResult = new CopyResult();
        copyResult.setSourceBucketName(this.copyObjectRequest.getSourceBucketName());
        copyResult.setSourceKey(this.copyObjectRequest.getSourceKey());
        copyResult.setDestinationBucketName(completeMultipartUploadResultCompleteMultipartUpload.getBucketName());
        copyResult.setDestinationKey(completeMultipartUploadResultCompleteMultipartUpload.getKey());
        copyResult.setETag(completeMultipartUploadResultCompleteMultipartUpload.getETag());
        copyResult.setVersionId(completeMultipartUploadResultCompleteMultipartUpload.getVersionId());
        return copyResult;
    }

    private List<PartETag> collectPartETags() {
        ArrayList arrayList = new ArrayList(this.futures.size());
        Iterator<Future<PartETag>> it = this.futures.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(it.next().get());
            } catch (Exception e2) {
                throw new AmazonClientException("Unable to copy part: " + e2.getCause().getMessage(), e2.getCause());
            }
        }
        return arrayList;
    }
}
