package com.clevertap.android.sdk.inapp.images.repo;

import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy;
import com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileResourcesRepo.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\b`\u0018\u00002\u00020\u0001J\"\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\rH\u0016JQ\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\r2-\u0010\u0011\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u0012H\u0016Jµ\u0001\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\r2/\b\u0002\u0010\u0011\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u00122/\b\u0002\u0010\u0018\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000b0\u00122/\b\u0002\u0010\u0019\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000b0\u0012H&J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u0016\u0010\u001a\u001a\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\rH&J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0010H&J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0010H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/repo/FileResourcesRepo;", "", "cleanupStrategy", "Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;", "getCleanupStrategy", "()Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;", "preloaderStrategy", "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;", "getPreloaderStrategy", "()Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;", "preloadFilesAndCache", "", "urlMeta", "", "Lkotlin/Pair;", "", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "completionCallback", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "urlStatusMap", "successBlock", "failureBlock", "cleanupStaleFiles", "urls", "cleanupExpiredResources", "cacheTpe", "cleanupAllResources", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FileResourcesRepo {
    void cleanupAllResources(CtCacheType cacheTpe);

    void cleanupExpiredResources(CtCacheType cacheTpe);

    void cleanupStaleFiles();

    void cleanupStaleFiles(List<String> urls);

    FileCleanupStrategy getCleanupStrategy();

    FilePreloaderStrategy getPreloaderStrategy();

    void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> urlMeta);

    void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> urlMeta, Function1<? super Map<String, Boolean>, Unit> completionCallback);

    void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> urlMeta, Function1<? super Map<String, Boolean>, Unit> completionCallback, Function1<? super Pair<String, ? extends CtCacheType>, Unit> successBlock, Function1<? super Pair<String, ? extends CtCacheType>, Unit> failureBlock);

    /* JADX INFO: compiled from: FileResourcesRepo.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void preloadFilesAndCache(FileResourcesRepo fileResourcesRepo, List<? extends Pair<String, ? extends CtCacheType>> urlMeta) {
            Intrinsics.checkNotNullParameter(urlMeta, "urlMeta");
            fileResourcesRepo.preloadFilesAndCache(urlMeta, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$0((Map) obj);
                }
            }, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$1((Pair) obj);
                }
            }, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$2((Pair) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$0(Map it) {
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

        public static void preloadFilesAndCache(FileResourcesRepo fileResourcesRepo, List<? extends Pair<String, ? extends CtCacheType>> urlMeta, Function1<? super Map<String, Boolean>, Unit> completionCallback) {
            Intrinsics.checkNotNullParameter(urlMeta, "urlMeta");
            Intrinsics.checkNotNullParameter(completionCallback, "completionCallback");
            fileResourcesRepo.preloadFilesAndCache(urlMeta, completionCallback, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$3((Pair) obj);
                }
            }, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$4((Pair) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$3(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$4(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void preloadFilesAndCache$default(FileResourcesRepo fileResourcesRepo, List list, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preloadFilesAndCache");
            }
            if ((i & 2) != 0) {
                function1 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$5((Map) obj2);
                    }
                };
            }
            if ((i & 4) != 0) {
                function12 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$6((Pair) obj2);
                    }
                };
            }
            if ((i & 8) != 0) {
                function13 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo$DefaultImpls$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return FileResourcesRepo.DefaultImpls.preloadFilesAndCache$lambda$7((Pair) obj2);
                    }
                };
            }
            fileResourcesRepo.preloadFilesAndCache(list, function1, function12, function13);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$5(Map it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$6(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit preloadFilesAndCache$lambda$7(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        public static void cleanupStaleFiles(FileResourcesRepo fileResourcesRepo) {
            fileResourcesRepo.cleanupStaleFiles(CollectionsKt.emptyList());
        }
    }
}
