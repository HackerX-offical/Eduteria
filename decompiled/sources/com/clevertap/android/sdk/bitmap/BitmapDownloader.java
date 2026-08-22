package com.clevertap.android.sdk.bitmap;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BitmapDownloader.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/clevertap/android/sdk/bitmap/BitmapDownloader;", "", "httpUrlConnectionParams", "Lcom/clevertap/android/sdk/bitmap/HttpUrlConnectionParams;", "bitmapInputStreamReader", "Lcom/clevertap/android/sdk/bitmap/IBitmapInputStreamReader;", "sizeConstrainedPair", "Lkotlin/Pair;", "", "", "<init>", "(Lcom/clevertap/android/sdk/bitmap/HttpUrlConnectionParams;Lcom/clevertap/android/sdk/bitmap/IBitmapInputStreamReader;Lkotlin/Pair;)V", "downloadStartTimeInMilliseconds", "", "connection", "Ljava/net/HttpURLConnection;", "srcUrl", "", "downloadBitmap", "Lcom/clevertap/android/sdk/network/DownloadedBitmap;", "createConnection", "url", "Ljava/net/URL;", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BitmapDownloader {
    public static final int NETWORK_TAG_DOWNLOAD_REQUESTS = 21;
    private final IBitmapInputStreamReader bitmapInputStreamReader;
    private HttpURLConnection connection;
    private long downloadStartTimeInMilliseconds;
    private final HttpUrlConnectionParams httpUrlConnectionParams;
    private final Pair<Boolean, Integer> sizeConstrainedPair;
    private String srcUrl;

    public BitmapDownloader(HttpUrlConnectionParams httpUrlConnectionParams, IBitmapInputStreamReader bitmapInputStreamReader, Pair<Boolean, Integer> sizeConstrainedPair) {
        Intrinsics.checkNotNullParameter(httpUrlConnectionParams, "httpUrlConnectionParams");
        Intrinsics.checkNotNullParameter(bitmapInputStreamReader, "bitmapInputStreamReader");
        Intrinsics.checkNotNullParameter(sizeConstrainedPair, "sizeConstrainedPair");
        this.httpUrlConnectionParams = httpUrlConnectionParams;
        this.bitmapInputStreamReader = bitmapInputStreamReader;
        this.sizeConstrainedPair = sizeConstrainedPair;
    }

    public /* synthetic */ BitmapDownloader(HttpUrlConnectionParams httpUrlConnectionParams, IBitmapInputStreamReader iBitmapInputStreamReader, Pair pair, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpUrlConnectionParams, iBitmapInputStreamReader, (i & 4) != 0 ? new Pair(false, 0) : pair);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005d A[PHI: r11
      0x005d: PHI (r11v10 com.clevertap.android.sdk.network.DownloadedBitmap) = 
      (r11v6 com.clevertap.android.sdk.network.DownloadedBitmap)
      (r11v7 com.clevertap.android.sdk.network.DownloadedBitmap)
      (r11v11 com.clevertap.android.sdk.network.DownloadedBitmap)
     binds: [B:24:0x00d3, B:20:0x00bd, B:10:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0061 A[PHI: r0 r11
      0x0061: PHI (r0v3 java.net.HttpURLConnection) = (r0v1 java.net.HttpURLConnection), (r0v2 java.net.HttpURLConnection), (r0v4 java.net.HttpURLConnection) binds: [B:24:0x00d3, B:20:0x00bd, B:10:0x005b] A[DONT_GENERATE, DONT_INLINE]
      0x0061: PHI (r11v8 com.clevertap.android.sdk.network.DownloadedBitmap) = 
      (r11v6 com.clevertap.android.sdk.network.DownloadedBitmap)
      (r11v7 com.clevertap.android.sdk.network.DownloadedBitmap)
      (r11v11 com.clevertap.android.sdk.network.DownloadedBitmap)
     binds: [B:24:0x00d3, B:20:0x00bd, B:10:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.clevertap.android.sdk.network.DownloadedBitmap downloadBitmap(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.bitmap.BitmapDownloader.downloadBitmap(java.lang.String):com.clevertap.android.sdk.network.DownloadedBitmap");
    }

    private final HttpURLConnection createConnection(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout(this.httpUrlConnectionParams.getConnectTimeout());
        httpURLConnection.setReadTimeout(this.httpUrlConnectionParams.getReadTimeout());
        httpURLConnection.setUseCaches(this.httpUrlConnectionParams.getUseCaches());
        httpURLConnection.setDoInput(this.httpUrlConnectionParams.getDoInput());
        for (Map.Entry<String, String> entry : this.httpUrlConnectionParams.getRequestMap().entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        return httpURLConnection;
    }
}
