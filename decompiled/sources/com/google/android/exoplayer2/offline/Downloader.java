package com.google.android.exoplayer2.offline;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public interface Downloader {

    public interface ProgressListener {
        void onProgress(long j, long j2, float f2);
    }

    void cancel();

    void download(ProgressListener progressListener) throws InterruptedException, IOException;

    void remove();
}
