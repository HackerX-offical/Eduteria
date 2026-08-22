package com.clevertap.android.sdk.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.network.DownloadedBitmap;
import com.clevertap.android.sdk.network.DownloadedBitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapInputStreamDecoder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0016\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/clevertap/android/sdk/bitmap/BitmapInputStreamDecoder;", "Lcom/clevertap/android/sdk/bitmap/IBitmapInputStreamReader;", "saveBytes", "", "saveBitmap", "logger", "Lcom/clevertap/android/sdk/Logger;", "<init>", "(ZZLcom/clevertap/android/sdk/Logger;)V", "getSaveBytes", "()Z", "getSaveBitmap", "getLogger", "()Lcom/clevertap/android/sdk/Logger;", "readInputStream", "Lcom/clevertap/android/sdk/network/DownloadedBitmap;", "inputStream", "Ljava/io/InputStream;", "connection", "Ljava/net/HttpURLConnection;", "downloadStartTimeInMilliseconds", "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BitmapInputStreamDecoder implements IBitmapInputStreamReader {
    private final Logger logger;
    private final boolean saveBitmap;
    private final boolean saveBytes;

    public BitmapInputStreamDecoder() {
        this(false, false, null, 7, null);
    }

    public BitmapInputStreamDecoder(boolean z, boolean z2, Logger logger) {
        this.saveBytes = z;
        this.saveBitmap = z2;
        this.logger = logger;
    }

    public /* synthetic */ BitmapInputStreamDecoder(boolean z, boolean z2, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? null : logger);
    }

    public final boolean getSaveBytes() {
        return this.saveBytes;
    }

    public final boolean getSaveBitmap() {
        return this.saveBitmap;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    @Override // com.clevertap.android.sdk.bitmap.IBitmapInputStreamReader
    public DownloadedBitmap readInputStream(InputStream inputStream, HttpURLConnection connection, long downloadStartTimeInMilliseconds) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Logger logger = this.logger;
        if (logger != null) {
            logger.verbose("reading bitmap input stream in BitmapInputStreamDecoder....");
        }
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                break;
            }
            i += i2;
            byteArrayOutputStream.write(bArr, 0, i2);
            Logger logger2 = this.logger;
            if (logger2 != null) {
                logger2.verbose("Downloaded " + i + " bytes");
            }
        }
        Logger logger3 = this.logger;
        if (logger3 != null) {
            logger3.verbose("Total download size for bitmap = " + i);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int contentLength = connection.getContentLength();
        if (contentLength != -1 && contentLength != i) {
            Logger logger4 = this.logger;
            if (logger4 != null) {
                logger4.debug("File not loaded completely not going forward. URL was: " + connection.getURL());
            }
            return DownloadedBitmapFactory.INSTANCE.nullBitmapWithStatus(DownloadedBitmap.Status.DOWNLOAD_FAILED);
        }
        if (this.saveBitmap) {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            if (bitmapDecodeByteArray != null) {
                DownloadedBitmapFactory downloadedBitmapFactory = DownloadedBitmapFactory.INSTANCE;
                long nowInMillis = Utils.getNowInMillis() - downloadStartTimeInMilliseconds;
                if (!this.saveBytes) {
                    byteArray = null;
                }
                return downloadedBitmapFactory.successBitmap(bitmapDecodeByteArray, nowInMillis, byteArray);
            }
            return DownloadedBitmapFactory.INSTANCE.nullBitmapWithStatus(DownloadedBitmap.Status.DOWNLOAD_FAILED);
        }
        DownloadedBitmapFactory downloadedBitmapFactory2 = DownloadedBitmapFactory.INSTANCE;
        long nowInMillis2 = Utils.getNowInMillis() - downloadStartTimeInMilliseconds;
        Intrinsics.checkNotNull(byteArray);
        return downloadedBitmapFactory2.successBytes(nowInMillis2, byteArray);
    }
}
