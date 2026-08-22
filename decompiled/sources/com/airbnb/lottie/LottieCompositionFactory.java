package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();
    private static final Set<LottieTaskIdleListener> taskIdleListeners = new HashSet();
    private static final byte[] ZIP_MAGIC = {80, 75, 3, 4};
    private static final byte[] GZIP_MAGIC = {Ascii.US, -117, 8};

    private LottieCompositionFactory() {
    }

    public static void setMaxCacheSize(int i) {
        LottieCompositionCache.getInstance().resize(i);
    }

    public static void clearCache(Context context) {
        clearCache(context, true);
    }

    public static void clearCache(Context context, boolean z) {
        NetworkCache networkCache;
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        if (!z || (networkCache = L.networkCache(context)) == null) {
            return;
        }
        networkCache.clear();
    }

    public static void registerLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.add(lottieTaskIdleListener);
        lottieTaskIdleListener.onIdleChanged(taskCache.size() == 0);
    }

    public static void unregisterLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.remove(lottieTaskIdleListener);
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieTask<LottieComposition> fromUrl(final Context context, final String str, final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda14
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.lambda$fromUrl$0(context, str, str2);
            }
        }, null);
    }

    static /* synthetic */ LottieResult lambda$fromUrl$0(Context context, String str, String str2) throws Exception {
        LottieResult<LottieComposition> lottieResultFetchSync = L.networkFetcher(context).fetchSync(context, str, str2);
        if (str2 != null && lottieResultFetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, lottieResultFetchSync.getValue());
        }
        return lottieResultFetchSync;
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        LottieResult<LottieComposition> lottieResultFetchSync = L.networkFetcher(context).fetchSync(context, str, str2);
        if (str2 != null && lottieResultFetchSync.getValue() != null) {
            LottieCompositionCache.getInstance().put(str2, lottieResultFetchSync.getValue());
        }
        return lottieResultFetchSync;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromAssetSync(applicationContext, str, str2);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            return fromInputStreamSync(context, context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static LottieTask<LottieComposition> fromInputStream(Context context, final InputStream inputStream, final String str) {
        final Context applicationContext = context == null ? null : context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda15
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromInputStreamSync(applicationContext, inputStream, str);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromInputStreamSync(Context context, InputStream inputStream, String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(inputStream));
            if (isZipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (isGzipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromJsonInputStreamSync(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            return fromJsonReaderSync(JsonReader.of(bufferedSourceBuffer), str);
        } catch (IOException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i) {
        return fromRawRes(context, i, rawResCacheKey(context, i));
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.lambda$fromRawRes$3(weakReference, applicationContext, i, str);
            }
        }, null);
    }

    static /* synthetic */ LottieResult lambda$fromRawRes$3(WeakReference weakReference, Context context, int i, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i, str);
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i) {
        return fromRawResSync(context, i, rawResCacheKey(context, i));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i, String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            if (isZipCompressed(bufferedSourceBuffer).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(bufferedSourceBuffer.inputStream()), str);
            }
            if (isGzipCompressed(bufferedSourceBuffer).booleanValue()) {
                try {
                    return fromJsonInputStreamSync(new GZIPInputStream(bufferedSourceBuffer.inputStream()), str);
                } catch (IOException e2) {
                    return new LottieResult<>((Throwable) e2);
                }
            }
            return fromJsonReaderSync(JsonReader.of(bufferedSourceBuffer), str);
        } catch (Resources.NotFoundException e3) {
            return new LottieResult<>((Throwable) e3);
        }
    }

    private static String rawResCacheKey(Context context, int i) {
        return "rawRes" + (isNightMode(context) ? "_night_" : "_day_") + i;
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda16
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                Utils.closeQuietly(inputStream);
            }
        });
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream inputStream, final String str, final boolean z) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda19
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str, z);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LottieCompositionFactory.lambda$fromJsonInputStream$7(z, inputStream);
            }
        });
    }

    static /* synthetic */ void lambda$fromJsonInputStream$7(boolean z, InputStream inputStream) {
        if (z) {
            Utils.closeQuietly(inputStream);
        }
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        return fromJsonSourceSync(Okio.source(inputStream), str, z);
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject jSONObject, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda18
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonSync(jSONObject, str);
            }
        }, null);
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromJsonString(final String str, final String str2) {
        return cache(str2, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonStringSync(str, str2);
            }
        }, null);
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonSourceSync(Okio.source(new ByteArrayInputStream(str.getBytes())), str2);
    }

    public static LottieTask<LottieComposition> fromJsonSource(final Source source, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonSourceSync(source, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                Utils.closeQuietly(source);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonSourceSync(Source source, String str) {
        return fromJsonSourceSync(source, str, true);
    }

    public static LottieResult<LottieComposition> fromJsonSourceSync(Source source, String str, boolean z) {
        return fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(source)), str, z);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader jsonReader, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromJsonReaderSync(jsonReader, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                Utils.closeQuietly(jsonReader);
            }
        });
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSync(jsonReader, str, true);
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str, boolean z) {
        return fromJsonReaderSyncInternal(jsonReader, str, z);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z) {
        LottieComposition lottieComposition;
        try {
            if (str == null) {
                lottieComposition = null;
            } else {
                try {
                    lottieComposition = LottieCompositionCache.getInstance().get(str);
                } catch (Exception e2) {
                    LottieResult<LottieComposition> lottieResult = new LottieResult<>(e2);
                    if (z) {
                        Utils.closeQuietly(jsonReader);
                    }
                    return lottieResult;
                }
            }
            if (lottieComposition != null) {
                LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(lottieComposition);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult2;
            }
            LottieComposition lottieComposition2 = LottieCompositionMoshiParser.parse(jsonReader);
            if (str != null) {
                LottieCompositionCache.getInstance().put(str, lottieComposition2);
            }
            LottieResult<LottieComposition> lottieResult3 = new LottieResult<>(lottieComposition2);
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult3;
        } catch (Throwable th) {
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str) {
        return fromZipStream((Context) null, zipInputStream, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str, boolean z) {
        return fromZipStream(null, zipInputStream, str, z);
    }

    public static LottieTask<LottieComposition> fromZipStream(final Context context, final ZipInputStream zipInputStream, final String str) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromZipStreamSync(context, zipInputStream, str);
            }
        }, new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                Utils.closeQuietly(zipInputStream);
            }
        });
    }

    public static LottieTask<LottieComposition> fromZipStream(final Context context, final ZipInputStream zipInputStream, final String str, boolean z) {
        return cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda12
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.fromZipStreamSync(context, zipInputStream, str);
            }
        }, z ? new Runnable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                Utils.closeQuietly(zipInputStream);
            }
        } : null);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        return fromZipStreamSync(zipInputStream, str, true);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str, boolean z) {
        return fromZipStreamSync(null, zipInputStream, str, z);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str) {
        return fromZipStreamSync(context, zipInputStream, str, true);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str, boolean z) {
        try {
            return fromZipStreamSyncInternal(context, zipInputStream, str);
        } finally {
            if (z) {
                Utils.closeQuietly(zipInputStream);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0150 A[Catch: IOException -> 0x02b7, TryCatch #1 {IOException -> 0x02b7, blocks: (B:7:0x0019, B:9:0x001f, B:12:0x0028, B:14:0x0034, B:72:0x0183, B:15:0x0039, B:17:0x0045, B:18:0x004a, B:20:0x0056, B:21:0x006f, B:24:0x0079, B:26:0x0081, B:28:0x0089, B:31:0x0093, B:33:0x009b, B:36:0x00a4, B:37:0x00a9, B:39:0x00bb, B:41:0x00df, B:67:0x0146, B:69:0x0150, B:70:0x0170, B:66:0x0120, B:71:0x0174, B:5:0x000f, B:42:0x00e8, B:51:0x0107, B:64:0x011e, B:63:0x011b), top: B:123:0x000f, inners: #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.airbnb.lottie.LottieResult<com.airbnb.lottie.LottieComposition> fromZipStreamSyncInternal(android.content.Context r13, java.util.zip.ZipInputStream r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieCompositionFactory.fromZipStreamSyncInternal(android.content.Context, java.util.zip.ZipInputStream, java.lang.String):com.airbnb.lottie.LottieResult");
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, ZIP_MAGIC);
    }

    private static Boolean isGzipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, GZIP_MAGIC);
    }

    private static Boolean matchesMagicBytes(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b2 : bArr) {
                if (bufferedSourcePeek.readByte() != b2) {
                    return false;
                }
            }
            bufferedSourcePeek.close();
            return true;
        } catch (Exception e2) {
            Logger.error("Failed to check zip file header", e2);
            return false;
        } catch (NoSuchMethodError unused) {
            return false;
        }
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.getImages().values()) {
            if (lottieImageAsset.getFileName().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    private static LottieTask<LottieComposition> cache(final String str, Callable<LottieResult<LottieComposition>> callable, Runnable runnable) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        LottieTask<LottieComposition> lottieTask = lottieComposition != null ? new LottieTask<>(lottieComposition) : null;
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                lottieTask = map.get(str);
            }
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask<LottieComposition> lottieTask2 = new LottieTask<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask2.addListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda8
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.lambda$cache$18(str, atomicBoolean, (LottieComposition) obj);
                }
            });
            lottieTask2.addFailureListener(new LottieListener() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda9
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.lambda$cache$19(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, LottieTask<LottieComposition>> map2 = taskCache;
                map2.put(str, lottieTask2);
                if (map2.size() == 1) {
                    notifyTaskCacheIdleListeners(false);
                }
            }
        }
        return lottieTask2;
    }

    static /* synthetic */ void lambda$cache$18(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    static /* synthetic */ void lambda$cache$19(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    private static void notifyTaskCacheIdleListeners(boolean z) {
        ArrayList arrayList = new ArrayList(taskIdleListeners);
        for (int i = 0; i < arrayList.size(); i++) {
            ((LottieTaskIdleListener) arrayList.get(i)).onIdleChanged(z);
        }
    }
}
