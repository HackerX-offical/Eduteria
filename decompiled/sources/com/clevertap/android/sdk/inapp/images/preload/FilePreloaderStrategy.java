package com.clevertap.android.sdk.inapp.images.preload;

import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.inapp.images.FileResourceProvider;
import com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilePreloaderStrategy.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001Jæ\u0001\u0010\u0013\u001a\u00020\u00142\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00170\u00162/\b\u0002\u0010\u001a\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001b2/\b\u0002\u0010\u001f\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001b2/\b\u0002\u0010 \u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001b2/\b\u0002\u0010!\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020#0\"¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00140\u001bH&J\b\u0010%\u001a\u00020\u0014H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;", "", "fileResourceProvider", "Lkotlin/Function0;", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "getFileResourceProvider", "()Lkotlin/jvm/functions/Function0;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "getLogger", "()Lcom/clevertap/android/sdk/ILogger;", "config", "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "getConfig", "()Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloadConfig;", "timeoutForPreload", "", "getTimeoutForPreload", "()J", "preloadFilesAndCache", "", "urlMetas", "", "Lkotlin/Pair;", "", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "successBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "urlMeta", "failureBlock", "startedBlock", "preloadFinished", "", "", "urlDownloadStatus", "cleanup", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FilePreloaderStrategy {
    void cleanup();

    FilePreloadConfig getConfig();

    Function0<FileResourceProvider> getFileResourceProvider();

    ILogger getLogger();

    long getTimeoutForPreload();

    void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> urlMetas, Function1<? super Pair<String, ? extends CtCacheType>, Unit> successBlock, Function1<? super Pair<String, ? extends CtCacheType>, Unit> failureBlock, Function1<? super Pair<String, ? extends CtCacheType>, Unit> startedBlock, Function1<? super Map<String, Boolean>, Unit> preloadFinished);

    /* JADX INFO: compiled from: FilePreloaderStrategy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void preloadFilesAndCache$default(FilePreloaderStrategy filePreloaderStrategy, List list, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadFilesAndCache");
            }
            if ((i & 2) != 0) {
                function1 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy$DefaultImpls$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FilePreloaderStrategy.DefaultImpls.preloadFilesAndCache$lambda$0((Pair) obj2);
                    }
                };
            }
            Function1 function15 = function1;
            if ((i & 4) != 0) {
                function12 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy$DefaultImpls$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FilePreloaderStrategy.DefaultImpls.preloadFilesAndCache$lambda$1((Pair) obj2);
                    }
                };
            }
            Function1 function16 = function12;
            if ((i & 8) != 0) {
                function13 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy$DefaultImpls$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FilePreloaderStrategy.DefaultImpls.preloadFilesAndCache$lambda$2((Pair) obj2);
                    }
                };
            }
            Function1 function17 = function13;
            if ((i & 16) != 0) {
                function14 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy$DefaultImpls$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FilePreloaderStrategy.DefaultImpls.preloadFilesAndCache$lambda$3((Map) obj2);
                    }
                };
            }
            filePreloaderStrategy.preloadFilesAndCache(list, function15, function16, function17, function14);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$0(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$1(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$2(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$3(Map it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }
    }
}
