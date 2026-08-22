package com.clevertap.android.sdk.inapp.images.preload;

import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.CTExecutors;
import com.clevertap.android.sdk.task.OnFailureListener;
import com.clevertap.android.sdk.task.OnSuccessListener;
import com.clevertap.android.sdk.task.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: FilePreloaderExecutors.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BA\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJÞ\u0001\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b0\u001a2-\u0010\u001e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00180\u001f2-\u0010#\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00180\u001f2-\u0010$\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00180\u001f2-\u0010%\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020'0&¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00180\u001fH\u0016J\u0091\u0002\u0010)\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b0\u001a2-\u0010\u001e\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00180\u001f2/\b\u0002\u0010#\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00180\u001f2-\u0010$\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00180\u001f2-\u0010%\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020'0&¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00180\u001f2/\u0010+\u001a+\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(*\u0012\u0006\u0012\u0004\u0018\u00010,0\u001fH\u0002J\b\u0010-\u001a\u00020\u0018H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006."}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderExecutors;", "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;", "fileResourceProvider", "Lkotlin/Function0;", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "executor", "Lcom/clevertap/android/sdk/task/CTExecutors;", "config", "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "timeoutForPreload", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/task/CTExecutors;Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;J)V", "getFileResourceProvider", "()Lkotlin/jvm/functions/Function0;", "getLogger", "()Lcom/clevertap/android/sdk/ILogger;", "getConfig", "()Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "getTimeoutForPreload", "()J", "preloadFilesAndCache", "", "urlMetas", "", "Lkotlin/Pair;", "", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "successBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "urlMeta", "failureBlock", "startedBlock", "preloadFinished", "", "", "urlDownloadStatus", "preloadAssets", "meta", "assetBlock", "", "cleanup", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FilePreloaderExecutors implements FilePreloaderStrategy {
    private final FilePreloadConfig config;
    private final CTExecutors executor;
    private final Function0<FileResourceProvider> fileResourceProvider;
    private final ILogger logger;
    private final long timeoutForPreload;

    /* JADX INFO: compiled from: FilePreloaderExecutors.kt */
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
    public FilePreloaderExecutors(Function0<FileResourceProvider> fileResourceProvider) {
        this(fileResourceProvider, null, null, null, 0L, 30, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderExecutors(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger) {
        this(fileResourceProvider, iLogger, null, null, 0L, 28, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderExecutors(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger, CTExecutors executor) {
        this(fileResourceProvider, iLogger, executor, null, 0L, 24, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(executor, "executor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilePreloaderExecutors(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger, CTExecutors executor, FilePreloadConfig config) {
        this(fileResourceProvider, iLogger, executor, config, 0L, 16, null);
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(config, "config");
    }

    @Override // com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy
    public void cleanup() {
    }

    public FilePreloaderExecutors(Function0<FileResourceProvider> fileResourceProvider, ILogger iLogger, CTExecutors executor, FilePreloadConfig config, long j) {
        Intrinsics.checkNotNullParameter(fileResourceProvider, "fileResourceProvider");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(config, "config");
        this.fileResourceProvider = fileResourceProvider;
        this.logger = iLogger;
        this.executor = executor;
        this.config = config;
        this.timeoutForPreload = j;
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
    public /* synthetic */ FilePreloaderExecutors(Function0 function0, ILogger iLogger, CTExecutors cTExecutors, FilePreloadConfig filePreloadConfig, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ILogger iLogger2 = (i & 2) != 0 ? null : iLogger;
        CTExecutors cTExecutorsExecutorResourceDownloader = (i & 4) != 0 ? CTExecutorFactory.executorResourceDownloader() : cTExecutors;
        FilePreloadConfig filePreloadConfigM11914default = (i & 8) != 0 ? FilePreloadConfig.INSTANCE.m11914default() : filePreloadConfig;
        if ((i & 16) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = Duration.m13751getInWholeMillisecondsimpl(DurationKt.toDuration(5, DurationUnit.MINUTES));
        }
        this(function0, iLogger2, cTExecutorsExecutorResourceDownloader, filePreloadConfigM11914default, j);
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
        preloadAssets(urlMetas, successBlock, failureBlock, startedBlock, preloadFinished, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderExecutors$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FilePreloaderExecutors.preloadFilesAndCache$lambda$0(this.f$0, (Pair) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object preloadFilesAndCache$lambda$0(FilePreloaderExecutors this$0, Pair urlMeta) {
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
    static /* synthetic */ void preloadAssets$default(FilePreloaderExecutors filePreloaderExecutors, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Object obj) {
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderExecutors$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return FilePreloaderExecutors.preloadAssets$lambda$1((Pair) obj2);
                }
            };
        }
        filePreloaderExecutors.preloadAssets(list, function1, function12, function13, function14, function15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadAssets$lambda$1(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private final void preloadAssets(List<? extends Pair<String, ? extends CtCacheType>> urlMetas, final Function1<? super Pair<String, ? extends CtCacheType>, Unit> successBlock, final Function1<? super Pair<String, ? extends CtCacheType>, Unit> failureBlock, final Function1<? super Pair<String, ? extends CtCacheType>, Unit> startedBlock, Function1<? super Map<String, Boolean>, Unit> preloadFinished, final Function1<? super Pair<String, ? extends CtCacheType>, ? extends Object> assetBlock) {
        final CountDownLatch countDownLatch = new CountDownLatch(urlMetas.size());
        List<? extends Pair<String, ? extends CtCacheType>> list = urlMetas;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(TuplesKt.to(((Pair) it.next()).getFirst(), false));
        }
        ArrayList<Pair> arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Pair pair : arrayList2) {
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        final Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
        for (final Pair<String, ? extends CtCacheType> pair2 : urlMetas) {
            Task taskIoTaskWithCallbackOnCurrentThread = this.executor.ioTaskWithCallbackOnCurrentThread();
            taskIoTaskWithCallbackOnCurrentThread.addOnSuccessListener(new OnSuccessListener() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderExecutors$$ExternalSyntheticLambda2
                @Override // com.clevertap.android.sdk.task.OnSuccessListener
                public final void onSuccess(Object obj) {
                    FilePreloaderExecutors.preloadAssets$lambda$4(countDownLatch, (Unit) obj);
                }
            });
            taskIoTaskWithCallbackOnCurrentThread.addOnFailureListener(new OnFailureListener() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderExecutors$$ExternalSyntheticLambda3
                @Override // com.clevertap.android.sdk.task.OnFailureListener
                public final void onFailure(Object obj) {
                    FilePreloaderExecutors.preloadAssets$lambda$5(countDownLatch, (Exception) obj);
                }
            });
            taskIoTaskWithCallbackOnCurrentThread.execute("tag", new Callable() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderExecutors$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return FilePreloaderExecutors.preloadAssets$lambda$6(startedBlock, pair2, assetBlock, mutableMap, successBlock, failureBlock);
                }
            });
        }
        try {
            if (countDownLatch.await(5L, TimeUnit.MINUTES)) {
                preloadFinished.invoke(mutableMap);
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadAssets$lambda$4(CountDownLatch countDownLatch, Unit unit) {
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preloadAssets$lambda$5(CountDownLatch countDownLatch, Exception exc) {
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadAssets$lambda$6(Function1 startedBlock, Pair url, Function1 assetBlock, Map downloadStatus, Function1 successBlock, Function1 failureBlock) {
        Intrinsics.checkNotNullParameter(startedBlock, "$startedBlock");
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(assetBlock, "$assetBlock");
        Intrinsics.checkNotNullParameter(downloadStatus, "$downloadStatus");
        Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
        Intrinsics.checkNotNullParameter(failureBlock, "$failureBlock");
        startedBlock.invoke(url);
        if (assetBlock.invoke(url) != null) {
            downloadStatus.put(url.getFirst(), true);
            successBlock.invoke(url);
        } else {
            downloadStatus.put(url.getFirst(), false);
            failureBlock.invoke(url);
        }
        return Unit.INSTANCE;
    }
}
