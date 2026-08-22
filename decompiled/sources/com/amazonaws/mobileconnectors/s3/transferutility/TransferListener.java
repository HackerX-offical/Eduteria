package com.amazonaws.mobileconnectors.s3.transferutility;

/* JADX INFO: loaded from: classes4.dex */
public interface TransferListener {
    void onError(int i, Exception exc);

    void onProgressChanged(int i, long j, long j2);

    void onStateChanged(int i, TransferState transferState);
}
