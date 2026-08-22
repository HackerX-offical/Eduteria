package com.clevertap.android.sdk.inapp.images.cleanup;

import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.CTExecutors;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileCleanupStrategyExecutors.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B!\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f0\u0011H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategyExecutors;", "Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;", "fileResourceProvider", "Lkotlin/Function0;", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "executor", "Lcom/clevertap/android/sdk/task/CTExecutors;", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/clevertap/android/sdk/task/CTExecutors;)V", "getFileResourceProvider", "()Lkotlin/jvm/functions/Function0;", "clearFileAssets", "", "urls", "", "", "successBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "stop", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileCleanupStrategyExecutors implements FileCleanupStrategy {
    private static final String TAG = "fileCleanupExecutor";
    private final CTExecutors executor;
    private final Function0<FileResourceProvider> fileResourceProvider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileCleanupStrategyExecutors(Function0<FileResourceProvider> fileResourceProvider) {
        this(fileResourceProvider, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
    }

    @Override // com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy
    public void stop() {
    }

    public FileCleanupStrategyExecutors(Function0<FileResourceProvider> fileResourceProvider, CTExecutors executor) {
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.fileResourceProvider = fileResourceProvider;
        this.executor = executor;
    }

    @Override // com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy
    public Function0<FileResourceProvider> getFileResourceProvider() {
        return this.fileResourceProvider;
    }

    public /* synthetic */ FileCleanupStrategyExecutors(Function0 function0, CTExecutors cTExecutors, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? CTExecutorFactory.executorResourceDownloader() : cTExecutors);
    }

    @Override // com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy
    public void clearFileAssets(List<String> urls, final Function1<? super String, Unit> successBlock) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        for (final String str : urls) {
            this.executor.ioTaskNonUi().execute(TAG, new Callable() { // from class: com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategyExecutors$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return FileCleanupStrategyExecutors.clearFileAssets$lambda$0(this.f$0, str, successBlock);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearFileAssets$lambda$0(FileCleanupStrategyExecutors this$0, String url, Function1 successBlock) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
        this$0.getFileResourceProvider().invoke().deleteData(url);
        successBlock.invoke(url);
        return Unit.INSTANCE;
    }
}
