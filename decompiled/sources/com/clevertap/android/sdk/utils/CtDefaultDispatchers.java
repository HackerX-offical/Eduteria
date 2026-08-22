package com.clevertap.android.sdk.utils;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CtDefaultDispatchers.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"Lcom/clevertap/android/sdk/utils/CtDefaultDispatchers;", "Lcom/clevertap/android/sdk/utils/DispatcherProvider;", "<init>", "()V", "io", "Lkotlinx/coroutines/CoroutineDispatcher;", "main", "processing", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CtDefaultDispatchers implements DispatcherProvider {
    @Override // com.clevertap.android.sdk.utils.DispatcherProvider
    public CoroutineDispatcher io() {
        return Dispatchers.getIO();
    }

    @Override // com.clevertap.android.sdk.utils.DispatcherProvider
    public CoroutineDispatcher main() {
        return Dispatchers.getMain();
    }

    @Override // com.clevertap.android.sdk.utils.DispatcherProvider
    public CoroutineDispatcher processing() {
        return Dispatchers.getUnconfined();
    }
}
