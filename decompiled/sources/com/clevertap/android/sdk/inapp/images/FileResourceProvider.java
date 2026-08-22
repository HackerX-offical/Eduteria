package com.clevertap.android.sdk.inapp.images;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.appnew.android.Utils.Const;
import com.clevertap.android.sdk.ILogger;
import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.inapp.images.memory.FileMemoryAccessObject;
import com.clevertap.android.sdk.inapp.images.memory.InAppGifMemoryAccessObjectV1;
import com.clevertap.android.sdk.inapp.images.memory.InAppImageMemoryAccessObjectV1;
import com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObject;
import com.clevertap.android.sdk.inapp.images.memory.MemoryCreator;
import com.clevertap.android.sdk.inapp.images.memory.MemoryDataTransformationType;
import com.clevertap.android.sdk.inapp.images.repo.FileResourcesRepoImplKt;
import com.clevertap.android.sdk.network.DownloadedBitmap;
import com.clevertap.android.sdk.utils.CTCaches;
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileResourceProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 C2\u00020\u0001:\u0001CBg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u001d\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0014\u0010\u0018J8\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020%0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H 0\u001dH\u0002J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\"J\u0012\u0010)\u001a\u0004\u0018\u00010*2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010+\u001a\u0004\u0018\u00010%2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010,\u001a\u0004\u0018\u00010%2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010-\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0012\u0010.\u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010/\u001a\u0004\u0018\u00010*2\u0006\u0010(\u001a\u00020\"J\u0010\u00100\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020\"J\u0010\u00101\u001a\u0004\u0018\u00010%2\u0006\u0010(\u001a\u00020\"J\u001e\u00102\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0006\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J9\u00106\u001a\u0004\u0018\u0001H \"\u0004\b\u0000\u0010 2\u0014\u00107\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u001b0$2\f\u00108\u001a\b\u0012\u0004\u0012\u0002H 09H\u0002¢\u0006\u0002\u0010:Jo\u0010;\u001a\u0004\u0018\u0001H \"\u0004\b\u0000\u0010 2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0$2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H 0\u001d2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u0001H 0>2 \u0010?\u001a\u001c\u0012\u0004\u0012\u000204\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020%\u0018\u00010$0>H\u0002¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\"H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001c0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "", Const.IMAGES, "Ljava/io/File;", "gifs", "allFileTypesDir", "logger", "Lcom/clevertap/android/sdk/ILogger;", "inAppRemoteSource", "Lcom/clevertap/android/sdk/inapp/images/FileFetchApiContract;", "ctCaches", "Lcom/clevertap/android/sdk/utils/CTCaches;", "imageMAO", "Lcom/clevertap/android/sdk/inapp/images/memory/InAppImageMemoryAccessObjectV1;", "gifMAO", "Lcom/clevertap/android/sdk/inapp/images/memory/InAppGifMemoryAccessObjectV1;", "fileMAO", "Lcom/clevertap/android/sdk/inapp/images/memory/FileMemoryAccessObject;", "deepLogging", "", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;Lcom/clevertap/android/sdk/ILogger;Lcom/clevertap/android/sdk/inapp/images/FileFetchApiContract;Lcom/clevertap/android/sdk/utils/CTCaches;Lcom/clevertap/android/sdk/inapp/images/memory/InAppImageMemoryAccessObjectV1;Lcom/clevertap/android/sdk/inapp/images/memory/InAppGifMemoryAccessObjectV1;Lcom/clevertap/android/sdk/inapp/images/memory/FileMemoryAccessObject;Z)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lcom/clevertap/android/sdk/ILogger;)V", "mapOfMAO", "", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "", "Lcom/clevertap/android/sdk/inapp/images/memory/MemoryAccessObject;", "saveData", "", ExifInterface.GPS_DIRECTION_TRUE, "cacheKey", "", "data", "Lkotlin/Pair;", "", "mao", "isFileCached", "url", "cachedInAppImageV1", "Landroid/graphics/Bitmap;", "cachedInAppGifV1", "cachedFileInBytes", "cachedFilePath", "cachedFileInstance", "fetchInAppImageV1", "fetchInAppGifV1", "fetchFile", "downloadedBytesFromApi", "downloadedBitmap", "Lcom/clevertap/android/sdk/network/DownloadedBitmap;", "deleteData", "fetchCachedData", "cacheKeyAndType", "transformationType", "Lcom/clevertap/android/sdk/inapp/images/memory/MemoryDataTransformationType;", "(Lkotlin/Pair;Lcom/clevertap/android/sdk/inapp/images/memory/MemoryDataTransformationType;)Ljava/lang/Object;", "fetchData", "urlMeta", "cachedDataFetcherBlock", "Lkotlin/Function1;", "dataToSaveBlock", "(Lkotlin/Pair;Lcom/clevertap/android/sdk/inapp/images/memory/MemoryAccessObject;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "log", "message", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileResourceProvider {
    private static final String ALL_FILE_TYPES_DIRECTORY_NAME = "CleverTap.Files.";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String GIF_DIRECTORY_NAME = "CleverTap.Gif.";
    private static final String IMAGE_DIRECTORY_NAME = "CleverTap.Images.";
    private static volatile FileResourceProvider instance;
    private final boolean deepLogging;
    private final FileMemoryAccessObject fileMAO;
    private final InAppGifMemoryAccessObjectV1 gifMAO;
    private final InAppImageMemoryAccessObjectV1 imageMAO;
    private final FileFetchApiContract inAppRemoteSource;
    private final ILogger logger;
    private final Map<CtCacheType, List<MemoryAccessObject<?>>> mapOfMAO;

    /* JADX INFO: compiled from: FileResourceProvider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadedBitmap.Status.values().length];
            try {
                iArr[DownloadedBitmap.Status.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final FileResourceProvider getInstance(Context context, ILogger iLogger) {
        return INSTANCE.getInstance(context, iLogger);
    }

    public FileResourceProvider(File images, File gifs, File allFileTypesDir, ILogger iLogger, FileFetchApiContract inAppRemoteSource, CTCaches ctCaches, InAppImageMemoryAccessObjectV1 imageMAO, InAppGifMemoryAccessObjectV1 gifMAO, FileMemoryAccessObject fileMAO, boolean z) {
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(gifs, "gifs");
        Intrinsics.checkNotNullParameter(allFileTypesDir, "allFileTypesDir");
        Intrinsics.checkNotNullParameter(inAppRemoteSource, "inAppRemoteSource");
        Intrinsics.checkNotNullParameter(ctCaches, "ctCaches");
        Intrinsics.checkNotNullParameter(imageMAO, "imageMAO");
        Intrinsics.checkNotNullParameter(gifMAO, "gifMAO");
        Intrinsics.checkNotNullParameter(fileMAO, "fileMAO");
        this.logger = iLogger;
        this.inAppRemoteSource = inAppRemoteSource;
        this.imageMAO = imageMAO;
        this.gifMAO = gifMAO;
        this.fileMAO = fileMAO;
        this.deepLogging = z;
        this.mapOfMAO = MapsKt.mapOf(TuplesKt.to(CtCacheType.IMAGE, CollectionsKt.listOf((Object[]) new MemoryAccessObject[]{imageMAO, fileMAO, gifMAO})), TuplesKt.to(CtCacheType.GIF, CollectionsKt.listOf((Object[]) new MemoryAccessObject[]{gifMAO, fileMAO, imageMAO})), TuplesKt.to(CtCacheType.FILES, CollectionsKt.listOf((Object[]) new MemoryAccessObject[]{fileMAO, imageMAO, gifMAO})));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ FileResourceProvider(File file, File file2, File file3, ILogger iLogger, FileFetchApiContract fileFetchApiContract, CTCaches cTCaches, InAppImageMemoryAccessObjectV1 inAppImageMemoryAccessObjectV1, InAppGifMemoryAccessObjectV1 inAppGifMemoryAccessObjectV1, FileMemoryAccessObject fileMemoryAccessObject, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        File file4;
        CTCaches cTCachesInstance;
        ILogger iLogger2 = (i & 8) != 0 ? null : iLogger;
        FileFetchApiContract fileFetchApi = (i & 16) != 0 ? new FileFetchApi() : fileFetchApiContract;
        if ((i & 32) != 0) {
            file4 = file3;
            cTCachesInstance = CTCaches.INSTANCE.instance(MemoryCreator.INSTANCE.createInAppImageMemoryV1(file, iLogger2), MemoryCreator.INSTANCE.createInAppGifMemoryV1(file2, iLogger2), MemoryCreator.INSTANCE.createFileMemoryV2(file4, iLogger2));
        } else {
            file4 = file3;
            cTCachesInstance = cTCaches;
        }
        this(file, file2, file4, iLogger2, fileFetchApi, cTCachesInstance, (i & 64) != 0 ? new InAppImageMemoryAccessObjectV1(cTCachesInstance, iLogger2) : inAppImageMemoryAccessObjectV1, (i & 128) != 0 ? new InAppGifMemoryAccessObjectV1(cTCachesInstance, iLogger2) : inAppGifMemoryAccessObjectV1, (i & 256) != 0 ? new FileMemoryAccessObject(cTCachesInstance, iLogger2) : fileMemoryAccessObject, (i & 512) != 0 ? false : z);
    }

    public /* synthetic */ FileResourceProvider(Context context, ILogger iLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : iLogger);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FileResourceProvider(Context context, ILogger iLogger) {
        Intrinsics.checkNotNullParameter(context, "context");
        File dir = context.getDir(IMAGE_DIRECTORY_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(dir, "getDir(...)");
        File dir2 = context.getDir(GIF_DIRECTORY_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(dir2, "getDir(...)");
        File dir3 = context.getDir(ALL_FILE_TYPES_DIRECTORY_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(dir3, "getDir(...)");
        this(dir, dir2, dir3, iLogger, null, null, null, null, null, false, 1008, null);
    }

    /* JADX INFO: compiled from: FileResourceProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider$Companion;", "", "<init>", "()V", "IMAGE_DIRECTORY_NAME", "", "GIF_DIRECTORY_NAME", "ALL_FILE_TYPES_DIRECTORY_NAME", "instance", "Lcom/clevertap/android/sdk/inapp/images/FileResourceProvider;", "getInstance", "context", "Landroid/content/Context;", "logger", "Lcom/clevertap/android/sdk/ILogger;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ FileResourceProvider getInstance$default(Companion companion, Context context, ILogger iLogger, int i, Object obj) {
            if ((i & 2) != 0) {
                iLogger = null;
            }
            return companion.getInstance(context, iLogger);
        }

        @JvmStatic
        public final FileResourceProvider getInstance(Context context, ILogger logger) {
            FileResourceProvider fileResourceProvider;
            Intrinsics.checkNotNullParameter(context, "context");
            FileResourceProvider fileResourceProvider2 = FileResourceProvider.instance;
            if (fileResourceProvider2 != null) {
                return fileResourceProvider2;
            }
            synchronized (this) {
                fileResourceProvider = FileResourceProvider.instance;
                if (fileResourceProvider == null) {
                    File dir = context.getDir(FileResourceProvider.IMAGE_DIRECTORY_NAME, 0);
                    Intrinsics.checkNotNullExpressionValue(dir, "getDir(...)");
                    File dir2 = context.getDir(FileResourceProvider.GIF_DIRECTORY_NAME, 0);
                    Intrinsics.checkNotNullExpressionValue(dir2, "getDir(...)");
                    File dir3 = context.getDir(FileResourceProvider.ALL_FILE_TYPES_DIRECTORY_NAME, 0);
                    Intrinsics.checkNotNullExpressionValue(dir3, "getDir(...)");
                    FileResourceProvider fileResourceProvider3 = new FileResourceProvider(dir, dir2, dir3, logger, null, null, null, null, null, false, 1008, null);
                    Companion companion = FileResourceProvider.INSTANCE;
                    FileResourceProvider.instance = fileResourceProvider3;
                    fileResourceProvider = fileResourceProvider3;
                }
            }
            return fileResourceProvider;
        }
    }

    private final <T> void saveData(String cacheKey, Pair<? extends T, byte[]> data, MemoryAccessObject<T> mao) {
        mao.saveInMemory(cacheKey, new Pair<>(data.getFirst(), mao.saveDiskMemory(cacheKey, data.getSecond())));
    }

    public final boolean isFileCached(String url) {
        Pair pairFetchInMemory;
        Intrinsics.checkNotNullParameter(url, "url");
        List<MemoryAccessObject<?>> list = this.mapOfMAO.get(CtCacheType.FILES);
        Serializable serializable = null;
        if (list != null) {
            List<MemoryAccessObject<?>> list2 = list;
            Iterator<T> it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    pairFetchInMemory = null;
                    break;
                }
                pairFetchInMemory = ((MemoryAccessObject) it.next()).fetchInMemory(url);
                if (pairFetchInMemory != null) {
                    break;
                }
            }
            if (pairFetchInMemory != null) {
                serializable = pairFetchInMemory;
            } else {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    File fileFetchDiskMemory = ((MemoryAccessObject) it2.next()).fetchDiskMemory(url);
                    if (fileFetchDiskMemory != null) {
                        serializable = fileFetchDiskMemory;
                        break;
                    }
                }
                serializable = serializable;
            }
        }
        return serializable != null;
    }

    public final Bitmap cachedInAppImageV1(String cacheKey) {
        return (Bitmap) fetchCachedData(new Pair<>(cacheKey, CtCacheType.IMAGE), MemoryDataTransformationType.ToBitmap.INSTANCE);
    }

    public final byte[] cachedInAppGifV1(String cacheKey) {
        return (byte[]) fetchCachedData(new Pair<>(cacheKey, CtCacheType.GIF), MemoryDataTransformationType.ToByteArray.INSTANCE);
    }

    public final byte[] cachedFileInBytes(String cacheKey) {
        return (byte[]) fetchCachedData(new Pair<>(cacheKey, CtCacheType.FILES), MemoryDataTransformationType.ToByteArray.INSTANCE);
    }

    public final String cachedFilePath(String cacheKey) {
        File fileCachedFileInstance = cachedFileInstance(cacheKey);
        if (fileCachedFileInstance != null) {
            return fileCachedFileInstance.getAbsolutePath();
        }
        return null;
    }

    public final File cachedFileInstance(String cacheKey) {
        return (File) fetchCachedData(new Pair<>(cacheKey, CtCacheType.FILES), MemoryDataTransformationType.ToFile.INSTANCE);
    }

    public final Bitmap fetchInAppImageV1(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return (Bitmap) fetchData(new Pair<>(url, CtCacheType.IMAGE), this.imageMAO, new C06561(this), new Function1() { // from class: com.clevertap.android.sdk.inapp.images.FileResourceProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FileResourceProvider.fetchInAppImageV1$lambda$3((DownloadedBitmap) obj);
            }
        });
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.images.FileResourceProvider$fetchInAppImageV1$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileResourceProvider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C06561 extends FunctionReferenceImpl implements Function1<String, Bitmap> {
        C06561(Object obj) {
            super(1, obj, FileResourceProvider.class, "cachedInAppImageV1", "cachedInAppImageV1(Ljava/lang/String;)Landroid/graphics/Bitmap;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Bitmap invoke(String str) {
            return ((FileResourceProvider) this.receiver).cachedInAppImageV1(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair fetchInAppImageV1$lambda$3(DownloadedBitmap downloadedBitmap) {
        Intrinsics.checkNotNullParameter(downloadedBitmap, "downloadedBitmap");
        if (WhenMappings.$EnumSwitchMapping$0[downloadedBitmap.getStatus().ordinal()] != 1) {
            return null;
        }
        Bitmap bitmap = downloadedBitmap.getBitmap();
        Intrinsics.checkNotNull(bitmap);
        byte[] bytes = downloadedBitmap.getBytes();
        Intrinsics.checkNotNull(bytes);
        return new Pair(bitmap, bytes);
    }

    public final byte[] fetchInAppGifV1(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return (byte[]) fetchData(new Pair<>(url, CtCacheType.GIF), this.gifMAO, new C06541(this), new C06552(this));
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.images.FileResourceProvider$fetchInAppGifV1$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileResourceProvider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C06541 extends FunctionReferenceImpl implements Function1<String, byte[]> {
        C06541(Object obj) {
            super(1, obj, FileResourceProvider.class, "cachedInAppGifV1", "cachedInAppGifV1(Ljava/lang/String;)[B", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final byte[] invoke(String str) {
            return ((FileResourceProvider) this.receiver).cachedInAppGifV1(str);
        }
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.images.FileResourceProvider$fetchInAppGifV1$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileResourceProvider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class C06552 extends FunctionReferenceImpl implements Function1<DownloadedBitmap, Pair<? extends byte[], ? extends byte[]>> {
        C06552(Object obj) {
            super(1, obj, FileResourceProvider.class, "downloadedBytesFromApi", "downloadedBytesFromApi(Lcom/clevertap/android/sdk/network/DownloadedBitmap;)Lkotlin/Pair;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Pair<byte[], byte[]> invoke(DownloadedBitmap p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((FileResourceProvider) this.receiver).downloadedBytesFromApi(p0);
        }
    }

    public final byte[] fetchFile(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return (byte[]) fetchData(new Pair<>(url, CtCacheType.FILES), this.fileMAO, new AnonymousClass1(this), new AnonymousClass2(this));
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.images.FileResourceProvider$fetchFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileResourceProvider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, byte[]> {
        AnonymousClass1(Object obj) {
            super(1, obj, FileResourceProvider.class, "cachedFileInBytes", "cachedFileInBytes(Ljava/lang/String;)[B", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final byte[] invoke(String str) {
            return ((FileResourceProvider) this.receiver).cachedFileInBytes(str);
        }
    }

    /* JADX INFO: renamed from: com.clevertap.android.sdk.inapp.images.FileResourceProvider$fetchFile$2, reason: invalid class name */
    /* JADX INFO: compiled from: FileResourceProvider.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<DownloadedBitmap, Pair<? extends byte[], ? extends byte[]>> {
        AnonymousClass2(Object obj) {
            super(1, obj, FileResourceProvider.class, "downloadedBytesFromApi", "downloadedBytesFromApi(Lcom/clevertap/android/sdk/network/DownloadedBitmap;)Lkotlin/Pair;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Pair<byte[], byte[]> invoke(DownloadedBitmap p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((FileResourceProvider) this.receiver).downloadedBytesFromApi(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<byte[], byte[]> downloadedBytesFromApi(DownloadedBitmap downloadedBitmap) {
        if (WhenMappings.$EnumSwitchMapping$0[downloadedBitmap.getStatus().ordinal()] != 1) {
            return null;
        }
        byte[] bytes = downloadedBitmap.getBytes();
        Intrinsics.checkNotNull(bytes);
        return new Pair<>(bytes, downloadedBitmap.getBytes());
    }

    public final void deleteData(String cacheKey) {
        String str;
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        List<MemoryAccessObject<?>> list = this.mapOfMAO.get(CtCacheType.IMAGE);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                MemoryAccessObject memoryAccessObject = (MemoryAccessObject) it.next();
                if (memoryAccessObject instanceof InAppImageMemoryAccessObjectV1) {
                    str = CtCacheType.IMAGE;
                } else if (memoryAccessObject instanceof InAppGifMemoryAccessObjectV1) {
                    str = CtCacheType.GIF;
                } else {
                    str = memoryAccessObject instanceof FileMemoryAccessObject ? CtCacheType.FILES : "";
                }
                if (memoryAccessObject.removeInMemory(cacheKey) != null) {
                    log(cacheKey + " was present in " + str + " in-memory cache is successfully removed");
                }
                if (memoryAccessObject.removeDiskMemory(cacheKey)) {
                    log(cacheKey + " was present in " + str + " disk-memory cache is successfully removed");
                }
            }
        }
    }

    private final <T> T fetchCachedData(Pair<String, ? extends CtCacheType> cacheKeyAndType, MemoryDataTransformationType<T> transformationType) {
        T t;
        String first = cacheKeyAndType.getFirst();
        CtCacheType second = cacheKeyAndType.getSecond();
        log(second.name() + " data for key " + first + " requested");
        if (first == null) {
            log(second.name() + " data for null key requested");
            return null;
        }
        List<MemoryAccessObject<?>> list = this.mapOfMAO.get(second);
        if (list == null) {
            return null;
        }
        List<MemoryAccessObject<?>> list2 = list;
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = (T) ((MemoryAccessObject) it.next()).fetchInMemoryAndTransform(first, transformationType);
            if (t != null) {
                break;
            }
        }
        if (t != null) {
            return t;
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            T t2 = (T) ((MemoryAccessObject) it2.next()).fetchDiskMemoryAndTransform(first, transformationType);
            if (t2 != null) {
                return t2;
            }
        }
        return null;
    }

    private final <T> T fetchData(Pair<String, ? extends CtCacheType> urlMeta, MemoryAccessObject<T> mao, Function1<? super String, ? extends T> cachedDataFetcherBlock, Function1<? super DownloadedBitmap, ? extends Pair<? extends T, byte[]>> dataToSaveBlock) {
        T tInvoke = cachedDataFetcherBlock.invoke(urlMeta.getFirst());
        if (tInvoke != null) {
            log("Returning requested " + urlMeta.getFirst() + ' ' + urlMeta.getSecond().name() + " from cache");
            return tInvoke;
        }
        DownloadedBitmap downloadedBitmapMakeApiCallForFile = this.inAppRemoteSource.makeApiCallForFile(urlMeta);
        if (WhenMappings.$EnumSwitchMapping$0[downloadedBitmapMakeApiCallForFile.getStatus().ordinal()] == 1) {
            Pair<? extends T, byte[]> pairInvoke = dataToSaveBlock.invoke(downloadedBitmapMakeApiCallForFile);
            Intrinsics.checkNotNull(pairInvoke);
            Pair<? extends T, byte[]> pair = pairInvoke;
            saveData(urlMeta.getFirst(), pair, mao);
            log("Returning requested " + urlMeta.getFirst() + ' ' + urlMeta.getSecond().name() + " with network, saved in cache");
            return pair.getFirst();
        }
        log("There was a problem fetching data for " + urlMeta.getSecond().name() + ", status: " + downloadedBitmapMakeApiCallForFile.getStatus());
        return null;
    }

    private final void log(String message) {
        ILogger iLogger;
        if (!this.deepLogging || (iLogger = this.logger) == null) {
            return;
        }
        iLogger.verbose(FileResourcesRepoImplKt.TAG_FILE_DOWNLOAD, message);
    }
}
