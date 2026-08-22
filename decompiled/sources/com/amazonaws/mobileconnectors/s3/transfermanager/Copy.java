package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.s3.transfermanager.model.CopyResult;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface Copy extends Transfer {
    CopyResult waitForCopyResult() throws InterruptedException, AmazonClientException;
}
