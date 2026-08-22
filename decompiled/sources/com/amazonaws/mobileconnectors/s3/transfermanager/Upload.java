package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.s3.transfermanager.exception.PauseException;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.UploadResult;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface Upload extends Transfer {
    void abort();

    PersistableUpload pause() throws PauseException;

    PauseResult<PersistableUpload> tryPause(boolean z);

    UploadResult waitForUploadResult() throws InterruptedException, AmazonClientException;
}
