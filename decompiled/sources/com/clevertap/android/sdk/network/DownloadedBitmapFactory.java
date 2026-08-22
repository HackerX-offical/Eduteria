package com.clevertap.android.sdk.network;

import android.graphics.Bitmap;
import com.clevertap.android.sdk.network.DownloadedBitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadedBitmapFactory.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/sdk/network/DownloadedBitmapFactory;", "", "<init>", "()V", "nullBitmapWithStatus", "Lcom/clevertap/android/sdk/network/DownloadedBitmap;", "status", "Lcom/clevertap/android/sdk/network/DownloadedBitmap$Status;", "successBitmap", "bitmap", "Landroid/graphics/Bitmap;", "downloadTime", "", "data", "", "successBytes", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DownloadedBitmapFactory {
    public static final DownloadedBitmapFactory INSTANCE = new DownloadedBitmapFactory();

    private DownloadedBitmapFactory() {
    }

    public final DownloadedBitmap nullBitmapWithStatus(DownloadedBitmap.Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new DownloadedBitmap(null, status, -1L, null, 8, null);
    }

    public static /* synthetic */ DownloadedBitmap successBitmap$default(DownloadedBitmapFactory downloadedBitmapFactory, Bitmap bitmap, long j, byte[] bArr, int i, Object obj) {
        if ((i & 4) != 0) {
            bArr = null;
        }
        return downloadedBitmapFactory.successBitmap(bitmap, j, bArr);
    }

    public final DownloadedBitmap successBitmap(Bitmap bitmap, long downloadTime, byte[] data) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return new DownloadedBitmap(bitmap, DownloadedBitmap.Status.SUCCESS, downloadTime, data);
    }

    public final DownloadedBitmap successBytes(long downloadTime, byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new DownloadedBitmap(null, DownloadedBitmap.Status.SUCCESS, downloadTime, data);
    }
}
