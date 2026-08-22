package com.clevertap.android.sdk.utils;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: compiled from: DispatcherProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/clevertap/android/sdk/utils/DispatcherProvider;", "", "io", "Lkotlinx/coroutines/CoroutineDispatcher;", "main", "processing", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DispatcherProvider {
    CoroutineDispatcher io();

    CoroutineDispatcher main();

    CoroutineDispatcher processing();
}
