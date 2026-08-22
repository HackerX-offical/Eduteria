package com.clevertap.android.sdk.task;

import com.android.billingclient.api.BillingFlowParams;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CTExecutorFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/task/CTExecutorFactory;", "", "<init>", "()V", "TAG_RESOURCE_DOWNLOADER", "", "executorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/clevertap/android/sdk/task/CTExecutors;", "executors", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "executorResourceDownloader", "ioPoolSize", "", "getOrCreateExecutorApi21", "key", "supplier", "Lkotlin/Function0;", "removeExecutor", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTExecutorFactory {
    private static final String TAG_RESOURCE_DOWNLOADER = "Resource Downloader";
    public static final CTExecutorFactory INSTANCE = new CTExecutorFactory();
    private static final ConcurrentHashMap<String, CTExecutors> executorMap = new ConcurrentHashMap<>();

    private CTExecutorFactory() {
    }

    @JvmStatic
    public static final CTExecutors executors(final CleverTapInstanceConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("Can't create task for null config".toString());
        }
        String accountId = config.getAccountId();
        ConcurrentHashMap<String, CTExecutors> concurrentHashMap = executorMap;
        final Function1 function1 = new Function1() { // from class: com.clevertap.android.sdk.task.CTExecutorFactory$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CTExecutorFactory.executors$lambda$1(config, (String) obj);
            }
        };
        CTExecutors cTExecutorsComputeIfAbsent = concurrentHashMap.computeIfAbsent(accountId, new Function() { // from class: com.clevertap.android.sdk.task.CTExecutorFactory$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CTExecutorFactory.executors$lambda$2(function1, obj);
            }
        });
        Intrinsics.checkNotNull(cTExecutorsComputeIfAbsent);
        return cTExecutorsComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CTExecutors executors$lambda$1(CleverTapInstanceConfig cleverTapInstanceConfig, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new CTExecutors(cleverTapInstanceConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CTExecutors executors$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (CTExecutors) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CTExecutors executors$lambda$3(CleverTapInstanceConfig cleverTapInstanceConfig) {
        return new CTExecutors(cleverTapInstanceConfig);
    }

    @JvmStatic
    public static final CTExecutors executorResourceDownloader() {
        return executorResourceDownloader(8);
    }

    @JvmStatic
    public static final CTExecutors executorResourceDownloader(final int ioPoolSize) {
        ConcurrentHashMap<String, CTExecutors> concurrentHashMap = executorMap;
        final Function1 function1 = new Function1() { // from class: com.clevertap.android.sdk.task.CTExecutorFactory$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CTExecutorFactory.executorResourceDownloader$lambda$4(ioPoolSize, (String) obj);
            }
        };
        CTExecutors cTExecutorsComputeIfAbsent = concurrentHashMap.computeIfAbsent(TAG_RESOURCE_DOWNLOADER, new Function() { // from class: com.clevertap.android.sdk.task.CTExecutorFactory$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CTExecutorFactory.executorResourceDownloader$lambda$5(function1, obj);
            }
        });
        Intrinsics.checkNotNull(cTExecutorsComputeIfAbsent);
        return cTExecutorsComputeIfAbsent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CTExecutors executorResourceDownloader$lambda$4(int i, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new CTExecutors(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CTExecutors executorResourceDownloader$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (CTExecutors) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CTExecutors executorResourceDownloader$lambda$6(int i) {
        return new CTExecutors(i);
    }

    private final CTExecutors getOrCreateExecutorApi21(String key, Function0<? extends CTExecutors> supplier) {
        ConcurrentHashMap<String, CTExecutors> concurrentHashMap = executorMap;
        CTExecutors cTExecutors = concurrentHashMap.get(key);
        if (cTExecutors != null) {
            return cTExecutors;
        }
        CTExecutors cTExecutorsInvoke = supplier.invoke();
        CTExecutors cTExecutorsPutIfAbsent = concurrentHashMap.putIfAbsent(key, cTExecutorsInvoke);
        return cTExecutorsPutIfAbsent == null ? cTExecutorsInvoke : cTExecutorsPutIfAbsent;
    }

    @JvmStatic
    public static final boolean removeExecutor(String accountId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        return executorMap.remove(accountId) != null;
    }
}
