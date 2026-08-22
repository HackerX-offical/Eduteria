package com.clevertap.android.sdk.bitmap;

import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.DownloadedBitmap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpBitmapLoader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/clevertap/android/sdk/bitmap/HttpBitmapLoader;", "", "<init>", "()V", "RESOURCE_CONNECTION_TIMEOUT", "", "RESOURCE_READ_TIMEOUT", "standardGzipHttpUrlConnectionParams", "Lcom/clevertap/android/sdk/bitmap/HttpUrlConnectionParams;", "inAppStandardHttpUrlConnectionParams", "getHttpBitmap", "Lcom/clevertap/android/sdk/network/DownloadedBitmap;", "bitmapOperation", "Lcom/clevertap/android/sdk/bitmap/HttpBitmapLoader$HttpBitmapOperation;", "bitmapDownloadRequest", "Lcom/clevertap/android/sdk/bitmap/BitmapDownloadRequest;", "HttpBitmapOperation", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpBitmapLoader {
    private static final int RESOURCE_CONNECTION_TIMEOUT = 5000;
    private static final int RESOURCE_READ_TIMEOUT = 15000;
    public static final HttpBitmapLoader INSTANCE = new HttpBitmapLoader();
    private static final HttpUrlConnectionParams standardGzipHttpUrlConnectionParams = new HttpUrlConnectionParams(1000, 5000, true, true, MapsKt.mapOf(TuplesKt.to("Accept-Encoding", "gzip, deflate")));
    private static final HttpUrlConnectionParams inAppStandardHttpUrlConnectionParams = new HttpUrlConnectionParams(5000, 15000, true, true, null, 16, null);

    /* JADX INFO: compiled from: HttpBitmapLoader.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpBitmapOperation.values().length];
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_NOTIFICATION_BITMAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_INAPP_BITMAP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_ANY_BITMAP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_BYTES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[HttpBitmapOperation.DOWNLOAD_BYTES_WITH_TIME_LIMIT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private HttpBitmapLoader() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: HttpBitmapLoader.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/clevertap/android/sdk/bitmap/HttpBitmapLoader$HttpBitmapOperation;", "", "<init>", "(Ljava/lang/String;I)V", "DOWNLOAD_NOTIFICATION_BITMAP", "DOWNLOAD_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT", "DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP", "DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT", "DOWNLOAD_INAPP_BITMAP", "DOWNLOAD_ANY_BITMAP", "DOWNLOAD_BYTES", "DOWNLOAD_BYTES_WITH_TIME_LIMIT", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HttpBitmapOperation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HttpBitmapOperation[] $VALUES;
        public static final HttpBitmapOperation DOWNLOAD_NOTIFICATION_BITMAP = new HttpBitmapOperation("DOWNLOAD_NOTIFICATION_BITMAP", 0);
        public static final HttpBitmapOperation DOWNLOAD_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT = new HttpBitmapOperation("DOWNLOAD_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT", 1);
        public static final HttpBitmapOperation DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP = new HttpBitmapOperation("DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP", 2);
        public static final HttpBitmapOperation DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT = new HttpBitmapOperation("DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT", 3);
        public static final HttpBitmapOperation DOWNLOAD_INAPP_BITMAP = new HttpBitmapOperation("DOWNLOAD_INAPP_BITMAP", 4);
        public static final HttpBitmapOperation DOWNLOAD_ANY_BITMAP = new HttpBitmapOperation("DOWNLOAD_ANY_BITMAP", 5);
        public static final HttpBitmapOperation DOWNLOAD_BYTES = new HttpBitmapOperation("DOWNLOAD_BYTES", 6);
        public static final HttpBitmapOperation DOWNLOAD_BYTES_WITH_TIME_LIMIT = new HttpBitmapOperation("DOWNLOAD_BYTES_WITH_TIME_LIMIT", 7);

        private static final /* synthetic */ HttpBitmapOperation[] $values() {
            return new HttpBitmapOperation[]{DOWNLOAD_NOTIFICATION_BITMAP, DOWNLOAD_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT, DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP, DOWNLOAD_SIZE_CONSTRAINED_GZIP_NOTIFICATION_BITMAP_WITH_TIME_LIMIT, DOWNLOAD_INAPP_BITMAP, DOWNLOAD_ANY_BITMAP, DOWNLOAD_BYTES, DOWNLOAD_BYTES_WITH_TIME_LIMIT};
        }

        public static EnumEntries<HttpBitmapOperation> getEntries() {
            return $ENTRIES;
        }

        private HttpBitmapOperation(String str, int i) {
        }

        static {
            HttpBitmapOperation[] httpBitmapOperationArr$values = $values();
            $VALUES = httpBitmapOperationArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(httpBitmapOperationArr$values);
        }

        public static HttpBitmapOperation valueOf(String str) {
            return (HttpBitmapOperation) Enum.valueOf(HttpBitmapOperation.class, str);
        }

        public static HttpBitmapOperation[] values() {
            return (HttpBitmapOperation[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final DownloadedBitmap getHttpBitmap(HttpBitmapOperation bitmapOperation, BitmapDownloadRequest bitmapDownloadRequest) {
        Intrinsics.checkNotNullParameter(bitmapOperation, "bitmapOperation");
        Intrinsics.checkNotNullParameter(bitmapDownloadRequest, "bitmapDownloadRequest");
        int i = 3;
        boolean z = false;
        Logger logger = null;
        switch (WhenMappings.$EnumSwitchMapping$0[bitmapOperation.ordinal()]) {
            case 1:
                return new NotificationBitmapDownloadRequestHandler(new BitmapDownloadRequestHandler(new BitmapDownloader(standardGzipHttpUrlConnectionParams, new BitmapInputStreamDecoder(false, false, null, 7, null), null, 4, null == true ? 1 : 0))).handleRequest(bitmapDownloadRequest);
            case 2:
                return new BitmapDownloadRequestHandlerWithTimeLimit(new NotificationBitmapDownloadRequestHandler(new BitmapDownloadRequestHandler(new BitmapDownloader(standardGzipHttpUrlConnectionParams, new GzipBitmapInputStreamReader(z, null == true ? 1 : 0, i, null == true ? 1 : 0), null, 4, null)))).handleRequest(bitmapDownloadRequest);
            case 3:
                return new NotificationBitmapDownloadRequestHandler(new BitmapDownloadRequestHandler(new BitmapDownloader(standardGzipHttpUrlConnectionParams, new GzipBitmapInputStreamReader(z, null == true ? 1 : 0, i, null == true ? 1 : 0), new Pair(true, Integer.valueOf(bitmapDownloadRequest.getDownloadSizeLimitInBytes()))))).handleRequest(bitmapDownloadRequest);
            case 4:
                return new BitmapDownloadRequestHandlerWithTimeLimit(new NotificationBitmapDownloadRequestHandler(new BitmapDownloadRequestHandler(new BitmapDownloader(standardGzipHttpUrlConnectionParams, new GzipBitmapInputStreamReader(z, null == true ? 1 : 0, i, null == true ? 1 : 0), new Pair(true, Integer.valueOf(bitmapDownloadRequest.getDownloadSizeLimitInBytes())))))).handleRequest(bitmapDownloadRequest);
            case 5:
                return new BitmapDownloadRequestHandler(new BitmapDownloader(inAppStandardHttpUrlConnectionParams, new BitmapInputStreamDecoder(true, false, null, 6, null), null, 4, null == true ? 1 : 0)).handleRequest(bitmapDownloadRequest);
            case 6:
                return new BitmapDownloadRequestHandler(new BitmapDownloader(standardGzipHttpUrlConnectionParams, new GzipBitmapInputStreamReader(z, logger, i, null == true ? 1 : 0), null, 4, null)).handleRequest(bitmapDownloadRequest);
            case 7:
                return new BitmapDownloadRequestHandler(new BitmapDownloader(inAppStandardHttpUrlConnectionParams, new BitmapInputStreamDecoder(true, false, null, 4, null), null, 4, null == true ? 1 : 0)).handleRequest(bitmapDownloadRequest);
            case 8:
                return new BitmapDownloadRequestHandlerWithTimeLimit(new BitmapDownloadRequestHandler(new BitmapDownloader(standardGzipHttpUrlConnectionParams, new BitmapInputStreamDecoder(true, false, null, 4, null), null, 4, null == true ? 1 : 0))).handleRequest(bitmapDownloadRequest);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
