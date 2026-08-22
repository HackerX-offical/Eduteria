package com.clevertap.android.sdk.inapp.images.preload;

import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.utils.CtDefaultDispatchers;
import com.clevertap.android.sdk.utils.DispatcherProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: FilePreloaderCoroutine.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BK\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010JÞ\u0001\u0010 \u001a\u00020!2\u0018\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$0#2-\u0010'\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!0(2-\u0010,\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!0(2-\u0010-\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!0(2-\u0010.\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0/¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020!0(H\u0016J\u0095\u0002\u00101\u001a\u00020!2\u0018\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$0#2-\u0010'\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020!0(2/\b\u0002\u0010,\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020!0(2/\b\u0002\u0010-\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020!0(2/\b\u0002\u0010.\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0/¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020!0(2/\u00103\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(2\u0012\u0006\u0012\u0004\u0018\u0001040(H\u0002J\b\u00105\u001a\u00020!H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderCoroutine;", "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;", "fileResourceProvider", "Lkotlin/Function0;", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "dispatchers", "Lcom/clevertap/android/sdk/utils/DispatcherProvider;", "config", "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "timeoutForPreload", "", "deepLogging", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/utils/DispatcherProvider;Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;JZ)V", "getFileResourceProvider", "()Lkotlin/jvm/functions/Function0;", "getLogger", "()Lcom/clevertap/android/sdk/ILogger;", "getConfig", "()Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "getTimeoutForPreload", "()J", "jobs", "", "Lkotlinx/coroutines/Job;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "preloadFilesAndCache", "", "urlMetas", "", "Lkotlin/Pair;", "", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "successBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "urlMeta", "failureBlock", "startedBlock", "preloadFinished", "", "urlDownloadStatus", "preloadAssets", "meta", "assetBlock", "", "cleanup", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilePreloaderCoroutine implements FilePreloaderStrategy {
    private final FilePreloadConfig config;
    private final boolean deepLogging;
    private final Function0<FileResourceProvider> fileResourceProvider;
    private final CoroutineExceptionHandler handler;
    private final List<Job> jobs;
    private final ILogger logger;
    private final CoroutineScope scope;
    private final long timeoutForPreload;

    /* JADX INFO: compiled from: FilePreloaderCoroutine.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CtCacheType.values().length];
            try {
                iArr[CtCacheType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CtCacheType.GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CtCacheType.FILES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderCoroutine(Function0<FileResourceProvider> fileResourceProvider) {
        this(fileResourceProvider, null, null, null, 0L, false, 62, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderCoroutine(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger) {
        this(fileResourceProvider, iLogger, null, null, 0L, false, 60, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderCoroutine(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger, DispatcherProvider dispatchers) {
        this(fileResourceProvider, iLogger, dispatchers, null, 0L, false, 56, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderCoroutine(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger, DispatcherProvider dispatchers, FilePreloadConfig config) {
        this(fileResourceProvider, iLogger, dispatchers, config, 0L, false, 48, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderCoroutine(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger, DispatcherProvider dispatchers, FilePreloadConfig config, long j) {
        this(fileResourceProvider, iLogger, dispatchers, config, j, false, 32, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    public FilePreloaderCoroutine(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger, DispatcherProvider dispatchers, FilePreloadConfig config, long j, boolean z) {
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(config, "config");
        this.fileResourceProvider = fileResourceProvider;
        this.logger = iLogger;
        this.config = config;
        this.timeoutForPreload = j;
        this.deepLogging = z;
        this.jobs = new ArrayList();
        this.handler = new FilePreloaderCoroutine$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this);
        this.scope = CoroutineScopeKt.CoroutineScope(dispatchers.io().limitedParallelism(getConfig().getParallelDownloads()));
    }

    @Override // com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy
    public Function0<FileResourceProvider> getFileResourceProvider() {
        return this.fileResourceProvider;
    }

    @Override // com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy
    public ILogger getLogger() {
        return this.logger;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FilePreloaderCoroutine(Function0 function0, ILogger iLogger, DispatcherProvider dispatcherProvider, FilePreloadConfig filePreloadConfig, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long jM13751getInWholeMillisecondsimpl;
        ILogger iLogger2 = (i & 2) != 0 ? null : iLogger;
        CtDefaultDispatchers ctDefaultDispatchers = (i & 4) != 0 ? new CtDefaultDispatchers() : dispatcherProvider;
        FilePreloadConfig filePreloadConfigM11914default = (i & 8) != 0 ? FilePreloadConfig.INSTANCE.m11914default() : filePreloadConfig;
        if ((i & 16) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            jM13751getInWholeMillisecondsimpl = Duration.m13751getInWholeMillisecondsimpl(DurationKt.toDuration(5, DurationUnit.MINUTES));
        } else {
            jM13751getInWholeMillisecondsimpl = j;
        }
        this(function0, iLogger2, ctDefaultDispatchers, filePreloadConfigM11914default, jM13751getInWholeMillisecondsimpl, (i & 32) != 0 ? false : z);
    }

    @Override // com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy
    public FilePreloadConfig getConfig() {
        return this.config;
    }

    @Override // com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy
    public long getTimeoutForPreload() {
        return this.timeoutForPreload;
    }

    @Override // com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy
    public void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> urlMetas, Function1<? super Pair<String, ? extends CtCacheType>, Unit> successBlock, Function1<? super Pair<String, ? extends CtCacheType>, Unit> failureBlock, Function1<? super Pair<String, ? extends CtCacheType>, Unit> startedBlock, Function1<? super Map<String, Boolean>, Unit> preloadFinished) {
        Intrinsics.checkNotNullParameter(urlMetas, "urlMetas");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(failureBlock, "failureBlock");
        Intrinsics.checkNotNullParameter(startedBlock, "startedBlock");
        Intrinsics.checkNotNullParameter(preloadFinished, "preloadFinished");
        preloadAssets(urlMetas, successBlock, failureBlock, startedBlock, preloadFinished, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderCoroutine$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FilePreloaderCoroutine.preloadFilesAndCache$lambda$1(this.f$0, (Pair) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object preloadFilesAndCache$lambda$1(FilePreloaderCoroutine this$0, Pair urlMeta) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(urlMeta, "urlMeta");
        String str = (String) urlMeta.getFirst();
        int i = WhenMappings.$EnumSwitchMapping$0[((CtCacheType) urlMeta.getSecond()).ordinal()];
        if (i == 1) {
            return this$0.getFileResourceProvider().invoke().fetchInAppImageV1(str);
        }
        if (i == 2) {
            return this$0.getFileResourceProvider().invoke().fetchInAppGifV1(str);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return this$0.getFileResourceProvider().invoke().fetchFile(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void preloadAssets$default(FilePreloaderCoroutine filePreloaderCoroutine, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Object obj) {
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderCoroutine$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FilePreloaderCoroutine.preloadAssets$lambda$2((Pair) obj2);
                }
            };
        }
        Function1 function16 = function12;
        if ((i & 8) != 0) {
            function13 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderCoroutine$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FilePreloaderCoroutine.preloadAssets$lambda$3((Pair) obj2);
                }
            };
        }
        Function1 function17 = function13;
        if ((i & 16) != 0) {
            function14 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderCoroutine$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FilePreloaderCoroutine.preloadAssets$lambda$4((Map) obj2);
                }
            };
        }
        filePreloaderCoroutine.preloadAssets(list, function1, function16, function17, function14, function15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadAssets$lambda$2(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadAssets$lambda$3(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadAssets$lambda$4(Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private final void preloadAssets(List<? extends Pair<String, ? extends CtCacheType>> urlMetas, Function1<? super Pair<String, ? extends CtCacheType>, Unit> successBlock, Function1<? super Pair<String, ? extends CtCacheType>, Unit> failureBlock, Function1<? super Pair<String, ? extends CtCacheType>, Unit> startedBlock, Function1<? super Map<String, Boolean>, Unit> preloadFinished, Function1<? super Pair<String, ? extends CtCacheType>, ? extends Object> assetBlock) {
        this.jobs.add(BuildersKt__Builders_commonKt.launch$default(this.scope, this.handler, null, new FilePreloaderCoroutine$preloadAssets$job$1(urlMetas, this, preloadFinished, startedBlock, assetBlock, successBlock, failureBlock, null), 2, null));
    }

    @Override // com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy
    public void cleanup() {
        Iterator<T> it = this.jobs.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
    }
}
