package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.concurrent.Cancellable;

/* JADX INFO: loaded from: classes9.dex */
public interface HttpExecutionAware {
    boolean isAborted();

    void setCancellable(Cancellable cancellable);
}
