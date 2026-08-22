package com.clevertap.android.sdk.inapp.images.repo;

import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.inapp.images.cleanup.FileCleanupStrategy;
import com.clevertap.android.sdk.inapp.images.preload.FilePreloaderStrategy;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo;
import com.clevertap.android.sdk.inapp.store.preference.FileStore;
import com.clevertap.android.sdk.inapp.store.preference.InAppAssetsStore;
import com.clevertap.android.sdk.inapp.store.preference.LegacyInAppStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: FileResourcesRepoImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ¯\u0001\u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\u00152-\u0010\u0019\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00130\u001a2-\u0010 \u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00130\u001a2-\u0010!\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00130\u001aH\u0016J$\u0010\"\u001a\u00020\u00132\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00132\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0018H\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0018H\u0016JW\u0010+\u001a\u00020\u00132\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u00152\b\b\u0002\u0010-\u001a\u00020.2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0017002#\b\u0002\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020.0\u001aH\u0002J\u0016\u00103\u001a\u00020\u00132\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015H\u0002J\b\u00105\u001a\u00020\u0013H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/repo/FileResourcesRepoImpl;", "Lcom/clevertap/android/sdk/inapp/images/repo/FileResourcesRepo;", "cleanupStrategy", "Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;", "preloaderStrategy", "Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;", "inAppAssetsStore", "Lcom/clevertap/android/sdk/inapp/store/preference/InAppAssetsStore;", "fileStore", "Lcom/clevertap/android/sdk/inapp/store/preference/FileStore;", "legacyInAppsStore", "Lcom/clevertap/android/sdk/inapp/store/preference/LegacyInAppStore;", "<init>", "(Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;Lcom/clevertap/android/sdk/inapp/store/preference/InAppAssetsStore;Lcom/clevertap/android/sdk/inapp/store/preference/FileStore;Lcom/clevertap/android/sdk/inapp/store/preference/LegacyInAppStore;)V", "getCleanupStrategy", "()Lcom/clevertap/android/sdk/inapp/images/cleanup/FileCleanupStrategy;", "getPreloaderStrategy", "()Lcom/clevertap/android/sdk/inapp/images/preload/FilePreloaderStrategy;", "preloadFilesAndCache", "", "urlMeta", "", "Lkotlin/Pair;", "", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "completionCallback", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "urlStatusMap", "successBlock", "failureBlock", "updateRepoStatus", "meta", "downloadState", "Lcom/clevertap/android/sdk/inapp/images/repo/DownloadState;", "cleanupStaleFiles", "urls", "cleanupExpiredResources", "cacheTpe", "cleanupAllResources", "cleanupStaleFilesNow", "validUrls", "currentTime", "", "allFileUrls", "", "expiryTs", "url", "cleanupAllFiles", "cleanupUrls", "repoUpdated", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileResourcesRepoImpl implements FileResourcesRepo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long EXPIRY_OFFSET_MILLIS;
    private static final HashMap<String, DownloadState> downloadInProgressUrls;
    private static final Object fetchAllFilesLock;
    private static final Set<DownloadTriggerForUrls> urlTriggers;
    private final FileCleanupStrategy cleanupStrategy;
    private final FileStore fileStore;
    private final InAppAssetsStore inAppAssetsStore;
    private final LegacyInAppStore legacyInAppsStore;
    private final FilePreloaderStrategy preloaderStrategy;

    /* JADX INFO: compiled from: FileResourcesRepoImpl.kt */
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

    @JvmStatic
    public static final void saveUrlExpiryToStore(Pair<String, ? extends CtCacheType> pair, Pair<FileStore, InAppAssetsStore> pair2) {
        INSTANCE.saveUrlExpiryToStore(pair, pair2);
    }

    public FileResourcesRepoImpl(FileCleanupStrategy cleanupStrategy, FilePreloaderStrategy preloaderStrategy, InAppAssetsStore inAppAssetsStore, FileStore fileStore, LegacyInAppStore legacyInAppsStore) {
        Intrinsics.checkNotNullParameter(cleanupStrategy, "cleanupStrategy");
        Intrinsics.checkNotNullParameter(preloaderStrategy, "preloaderStrategy");
        Intrinsics.checkNotNullParameter(inAppAssetsStore, "inAppAssetsStore");
        Intrinsics.checkNotNullParameter(fileStore, "fileStore");
        Intrinsics.checkNotNullParameter(legacyInAppsStore, "legacyInAppsStore");
        this.cleanupStrategy = cleanupStrategy;
        this.preloaderStrategy = preloaderStrategy;
        this.inAppAssetsStore = inAppAssetsStore;
        this.fileStore = fileStore;
        this.legacyInAppsStore = legacyInAppsStore;
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public void cleanupStaleFiles() {
        FileResourcesRepo.DefaultImpls.cleanupStaleFiles(this);
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> list) {
        FileResourcesRepo.DefaultImpls.preloadFilesAndCache(this, list);
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> list, Function1<? super Map<String, Boolean>, Unit> function1) {
        FileResourcesRepo.DefaultImpls.preloadFilesAndCache(this, list, function1);
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public FileCleanupStrategy getCleanupStrategy() {
        return this.cleanupStrategy;
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public FilePreloaderStrategy getPreloaderStrategy() {
        return this.preloaderStrategy;
    }

    /* JADX INFO: compiled from: FileResourcesRepoImpl.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/repo/FileResourcesRepoImpl$Companion;", "", "<init>", "()V", "EXPIRY_OFFSET_MILLIS", "", "urlTriggers", "", "Lcom/clevertap/android/sdk/inapp/images/repo/DownloadTriggerForUrls;", "downloadInProgressUrls", "Ljava/util/HashMap;", "", "Lcom/clevertap/android/sdk/inapp/images/repo/DownloadState;", "fetchAllFilesLock", "saveUrlExpiryToStore", "", "urlMeta", "Lkotlin/Pair;", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "storePair", "Lcom/clevertap/android/sdk/inapp/store/preference/FileStore;", "Lcom/clevertap/android/sdk/inapp/store/preference/InAppAssetsStore;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: FileResourcesRepoImpl.kt */
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void saveUrlExpiryToStore(Pair<String, ? extends CtCacheType> urlMeta, Pair<FileStore, InAppAssetsStore> storePair) {
            Intrinsics.checkNotNullParameter(urlMeta, "urlMeta");
            Intrinsics.checkNotNullParameter(storePair, "storePair");
            String first = urlMeta.getFirst();
            long jCurrentTimeMillis = System.currentTimeMillis() + FileResourcesRepoImpl.EXPIRY_OFFSET_MILLIS;
            FileStore first2 = storePair.getFirst();
            InAppAssetsStore second = storePair.getSecond();
            int i = WhenMappings.$EnumSwitchMapping$0[urlMeta.getSecond().ordinal()];
            if (i == 1 || i == 2) {
                second.saveAssetUrl(first, jCurrentTimeMillis);
                first2.saveFileUrl(first, jCurrentTimeMillis);
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                first2.saveFileUrl(first, jCurrentTimeMillis);
            }
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        EXPIRY_OFFSET_MILLIS = Duration.m13751getInWholeMillisecondsimpl(DurationKt.toDuration(14, DurationUnit.DAYS));
        urlTriggers = new LinkedHashSet();
        downloadInProgressUrls = new HashMap<>();
        fetchAllFilesLock = new Object();
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public void preloadFilesAndCache(List<? extends Pair<String, ? extends CtCacheType>> urlMeta, Function1<? super Map<String, Boolean>, Unit> completionCallback, final Function1<? super Pair<String, ? extends CtCacheType>, Unit> successBlock, final Function1<? super Pair<String, ? extends CtCacheType>, Unit> failureBlock) {
        Intrinsics.checkNotNullParameter(urlMeta, "urlMeta");
        Intrinsics.checkNotNullParameter(completionCallback, "completionCallback");
        Intrinsics.checkNotNullParameter(successBlock, "successBlock");
        Intrinsics.checkNotNullParameter(failureBlock, "failureBlock");
        getPreloaderStrategy().preloadFilesAndCache(urlMeta, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileResourcesRepoImpl.preloadFilesAndCache$lambda$0(this.f$0, successBlock, (Pair) obj);
            }
        }, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileResourcesRepoImpl.preloadFilesAndCache$lambda$1(this.f$0, failureBlock, (Pair) obj);
            }
        }, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileResourcesRepoImpl.preloadFilesAndCache$lambda$2(this.f$0, (Pair) obj);
            }
        }, completionCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadFilesAndCache$lambda$0(FileResourcesRepoImpl this$0, Function1 successBlock, Pair meta) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(successBlock, "$successBlock");
        Intrinsics.checkNotNullParameter(meta, "meta");
        INSTANCE.saveUrlExpiryToStore(meta, new Pair<>(this$0.fileStore, this$0.inAppAssetsStore));
        this$0.updateRepoStatus(meta, DownloadState.SUCCESSFUL);
        successBlock.invoke(meta);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadFilesAndCache$lambda$1(FileResourcesRepoImpl this$0, Function1 failureBlock, Pair meta) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(failureBlock, "$failureBlock");
        Intrinsics.checkNotNullParameter(meta, "meta");
        this$0.updateRepoStatus(meta, DownloadState.FAILED);
        failureBlock.invoke(meta);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit preloadFilesAndCache$lambda$2(FileResourcesRepoImpl this$0, Pair meta) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(meta, "meta");
        this$0.updateRepoStatus(meta, DownloadState.IN_PROGRESS);
        return Unit.INSTANCE;
    }

    private final void updateRepoStatus(Pair<String, ? extends CtCacheType> meta, DownloadState downloadState) {
        if (urlTriggers.isEmpty()) {
            return;
        }
        synchronized (fetchAllFilesLock) {
            downloadInProgressUrls.put(meta.getFirst(), downloadState);
            repoUpdated();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public void cleanupStaleFiles(List<String> urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.legacyInAppsStore.lastCleanupTs() < EXPIRY_OFFSET_MILLIS) {
            return;
        }
        cleanupStaleFilesNow$default(this, urls, jCurrentTimeMillis, null, null, 12, null);
        this.legacyInAppsStore.updateAssetCleanupTs(jCurrentTimeMillis);
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public void cleanupExpiredResources(CtCacheType cacheTpe) {
        Set<String> allAssetUrls;
        Intrinsics.checkNotNullParameter(cacheTpe, "cacheTpe");
        int i = WhenMappings.$EnumSwitchMapping$0[cacheTpe.ordinal()];
        if (i == 1 || i == 2) {
            allAssetUrls = this.inAppAssetsStore.getAllAssetUrls();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            allAssetUrls = SetsKt.plus((Set) this.fileStore.getAllFileUrls(), (Iterable) this.inAppAssetsStore.getAllAssetUrls());
        }
        cleanupStaleFilesNow$default(this, null, 0L, allAssetUrls, null, 11, null);
    }

    @Override // com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepo
    public void cleanupAllResources(CtCacheType cacheTpe) {
        Set<String> allAssetUrls;
        Intrinsics.checkNotNullParameter(cacheTpe, "cacheTpe");
        int i = WhenMappings.$EnumSwitchMapping$0[cacheTpe.ordinal()];
        if (i == 1 || i == 2) {
            allAssetUrls = this.inAppAssetsStore.getAllAssetUrls();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            allAssetUrls = SetsKt.plus((Set) this.fileStore.getAllFileUrls(), (Iterable) this.inAppAssetsStore.getAllAssetUrls());
        }
        cleanupAllFiles(CollectionsKt.toList(allAssetUrls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void cleanupStaleFilesNow$default(final FileResourcesRepoImpl fileResourcesRepoImpl, List list, long j, Set set, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            j = System.currentTimeMillis();
        }
        if ((i & 4) != 0) {
            set = SetsKt.plus((Set) fileResourcesRepoImpl.fileStore.getAllFileUrls(), (Iterable) fileResourcesRepoImpl.inAppAssetsStore.getAllAssetUrls());
        }
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImpl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return Long.valueOf(FileResourcesRepoImpl.cleanupStaleFilesNow$lambda$4(this.f$0, (String) obj2));
                }
            };
        }
        List list2 = list;
        fileResourcesRepoImpl.cleanupStaleFilesNow(list2, j, set, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long cleanupStaleFilesNow$lambda$4(FileResourcesRepoImpl this$0, String key) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(key, "key");
        return Math.max(this$0.fileStore.expiryForUrl(key), this$0.inAppAssetsStore.expiryForUrl(key));
    }

    private final void cleanupStaleFilesNow(List<String> validUrls, long currentTime, Set<String> allFileUrls, Function1<? super String, Long> expiryTs) {
        List<String> list = validUrls;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            linkedHashMap.put(obj, (String) obj);
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        Set mutableSet = CollectionsKt.toMutableSet(allFileUrls);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : mutableSet) {
            String str = (String) obj2;
            boolean zContainsKey = linkedHashMap2.containsKey(str);
            boolean z = currentTime > expiryTs.invoke(str).longValue();
            if (!zContainsKey && z) {
                arrayList.add(obj2);
            }
        }
        cleanupAllFiles(arrayList);
    }

    private final void cleanupAllFiles(List<String> cleanupUrls) {
        getCleanupStrategy().clearFileAssets(cleanupUrls, new Function1() { // from class: com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileResourcesRepoImpl.cleanupAllFiles$lambda$7(this.f$0, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cleanupAllFiles$lambda$7(FileResourcesRepoImpl this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "url");
        this$0.fileStore.clearFileUrl(url);
        this$0.inAppAssetsStore.clearAssetUrl(url);
        return Unit.INSTANCE;
    }

    private final void repoUpdated() {
        for (DownloadTriggerForUrls downloadTriggerForUrls : urlTriggers) {
            List<String> urls = downloadTriggerForUrls.getUrls();
            if (!(urls instanceof Collection) || !urls.isEmpty()) {
                for (String str : urls) {
                    HashMap<String, DownloadState> map = downloadInProgressUrls;
                    if (map.get(str) == DownloadState.SUCCESSFUL || map.get(str) == DownloadState.FAILED) {
                    }
                }
            }
            downloadTriggerForUrls.getCallback().invoke();
        }
    }
}
