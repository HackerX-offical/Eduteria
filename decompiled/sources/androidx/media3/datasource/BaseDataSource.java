package androidx.media3.datasource;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDataSource implements DataSource {
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;

    /* JADX INFO: renamed from: listeners, reason: collision with root package name */
    private final ArrayList<TransferListener> f217listeners = new ArrayList<>(1);

    protected BaseDataSource(boolean z) {
        this.isNetwork = z;
    }

    @Override // androidx.media3.datasource.DataSource
    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        if (this.f217listeners.contains(transferListener)) {
            return;
        }
        this.f217listeners.add(transferListener);
        this.listenerCount++;
    }

    protected final void transferInitializing(DataSpec dataSpec) {
        for (int i = 0; i < this.listenerCount; i++) {
            this.f217listeners.get(i).onTransferInitializing(this, dataSpec, this.isNetwork);
        }
    }

    protected final void transferStarted(DataSpec dataSpec) {
        this.dataSpec = dataSpec;
        for (int i = 0; i < this.listenerCount; i++) {
            this.f217listeners.get(i).onTransferStart(this, dataSpec, this.isNetwork);
        }
    }

    protected final void bytesTransferred(int i) {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i2 = 0; i2 < this.listenerCount; i2++) {
            this.f217listeners.get(i2).onBytesTransferred(this, dataSpec, this.isNetwork, i);
        }
    }

    protected final void transferEnded() {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i = 0; i < this.listenerCount; i++) {
            this.f217listeners.get(i).onTransferEnd(this, dataSpec, this.isNetwork);
        }
        this.dataSpec = null;
    }
}
