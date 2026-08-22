package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;

/* JADX INFO: loaded from: classes4.dex */
public interface TransferStateChangeListener {
    void transferStateChanged(Transfer transfer, Transfer.TransferState transferState);
}
