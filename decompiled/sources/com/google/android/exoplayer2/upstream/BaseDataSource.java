package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseDataSource implements DataSource {
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final ArrayList<TransferListener> f604listeners = new ArrayList<>(1);

    protected BaseDataSource(boolean z) {
        this.isNetwork = z;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        if (this.f604listeners.contains(transferListener)) {
            return;
        }
        this.f604listeners.add(transferListener);
        this.listenerCount++;
    }

    protected final void transferInitializing(DataSpec dataSpec) {
        for (int i = 0; i < this.listenerCount; i++) {
            this.f604listeners.get(i).onTransferInitializing(this, dataSpec, this.isNetwork);
        }
    }

    protected final void transferStarted(DataSpec dataSpec) {
        this.dataSpec = dataSpec;
        for (int i = 0; i < this.listenerCount; i++) {
            this.f604listeners.get(i).onTransferStart(this, dataSpec, this.isNetwork);
        }
    }

    protected final void bytesTransferred(int i) {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i2 = 0; i2 < this.listenerCount; i2++) {
            this.f604listeners.get(i2).onBytesTransferred(this, dataSpec, this.isNetwork, i);
        }
    }

    protected final void transferEnded() {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i = 0; i < this.listenerCount; i++) {
            this.f604listeners.get(i).onTransferEnd(this, dataSpec, this.isNetwork);
        }
        this.dataSpec = null;
    }
}
