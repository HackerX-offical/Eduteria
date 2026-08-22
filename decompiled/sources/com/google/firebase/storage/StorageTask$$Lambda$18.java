package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCanceledListener;

/* JADX INFO: compiled from: com.google.firebase:firebase-storage@@19.1.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class StorageTask$$Lambda$18 implements OnCanceledListener {
    private final CancellationTokenSource arg$1;

    private StorageTask$$Lambda$18(CancellationTokenSource cancellationTokenSource) {
        this.arg$1 = cancellationTokenSource;
    }

    public static OnCanceledListener lambdaFactory$(CancellationTokenSource cancellationTokenSource) {
        return new StorageTask$$Lambda$18(cancellationTokenSource);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public void onCanceled() {
        this.arg$1.cancel();
    }
}
