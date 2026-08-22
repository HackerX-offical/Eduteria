package com.clevertap.android.sdk.inapp.images.cleanup;

import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.utils.CtDefaultDispatchers;
import com.clevertap.android.sdk.utils.DispatcherProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: FileCleanupStrategyCoroutine.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ9\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategyCoroutine;", "Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;", "fileResourceProvider", "Lkotlin/Function0;", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "dispatchers", "Lcom/clevertap/android/sdk/utils/DispatcherProvider;", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/clevertap/android/sdk/utils/DispatcherProvider;)V", "getFileResourceProvider", "()Lkotlin/jvm/functions/Function0;", "jobs", "", "Lkotlinx/coroutines/Job;", "clearFileAssets", "", "urls", "", "", "successBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "stop", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileCleanupStrategyCoroutine implements FileCleanupStrategy {
    private final DispatcherProvider dispatchers;
    private final Function0<FileResourceProvider> fileResourceProvider;
    private List<Job> jobs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileCleanupStrategyCoroutine(Function0<FileResourceProvider> fileResourceProvider) {
        this(fileResourceProvider, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
    }

    public FileCleanupStrategyCoroutine(Function0<FileResourceProvider> fileResourceProvider, DispatcherProvider dispatchers) {
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.fileResourceProvider = fileResourceProvider;
        this.dispatchers = dispatchers;
        this.jobs = new ArrayList();
    }

    @Override // com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy
    public Function0<FileResourceProvider> getFileResourceProvider() {
        return this.fileResourceProvider;
    }

    public /* synthetic */ FileCleanupStrategyCoroutine(Function0 function0, CtDefaultDispatchers ctDefaultDispatchers, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? new CtDefaultDispatchers() : ctDefaultDispatchers);
    }

    @Override // com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy
    public void clearFileAssets(List<String> urls, Function1<? super String, Unit> successBlock) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        this.jobs.add(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.dispatchers.io()), null, null, new FileCleanupStrategyCoroutine$clearFileAssets$job$1(urls, this, successBlock, null), 3, null));
    }

    @Override // com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy
    public void stop() {
        Iterator<T> it = this.jobs.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
    }
}
