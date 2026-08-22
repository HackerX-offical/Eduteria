package com.amazonaws.mobileconnectors.s3.transfermanager.internal;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public interface TransferMonitor {
    Future<?> getFuture();

    boolean isDone();
}
