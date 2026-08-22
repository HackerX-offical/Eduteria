package com.clevertap.android.sdk.inapp.images;

import com.clevertap.android.sdk.bitmap.BitmapDownloadRequest;
import com.clevertap.android.sdk.bitmap.HttpBitmapLoader;
import com.clevertap.android.sdk.inapp.data.CtCacheType;
import com.clevertap.android.sdk.network.DownloadedBitmap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileFetchApi.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/clevertap/android/sdk/inapp/images/FileFetchApi;", "Lcom/clevertap/android/sdk/inapp/images/FileFetchApiContract;", "<init>", "()V", "makeApiCallForFile", "Lcom/clevertap/android/sdk/network/DownloadedBitmap;", "urlMeta", "Lkotlin/Pair;", "", "Lcom/clevertap/android/sdk/inapp/data/CtCacheType;", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileFetchApi implements FileFetchApiContract {

    /* JADX INFO: compiled from: FileFetchApi.kt */
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

    @Override // com.clevertap.android.sdk.inapp.images.FileFetchApiContract
    public DownloadedBitmap makeApiCallForFile(Pair<String, ? extends CtCacheType> urlMeta) {
        HttpBitmapLoader.HttpBitmapOperation httpBitmapOperation;
        Intrinsics.checkNotNullParameter(urlMeta, "urlMeta");
        BitmapDownloadRequest bitmapDownloadRequest = new BitmapDownloadRequest(urlMeta.getFirst(), false, null, null, 0L, 0, 62, null);
        int i = WhenMappings.$EnumSwitchMapping$0[urlMeta.getSecond().ordinal()];
        if (i == 1 || i == 2) {
            httpBitmapOperation = HttpBitmapLoader.HttpBitmapOperation.DOWNLOAD_INAPP_BITMAP;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            httpBitmapOperation = HttpBitmapLoader.HttpBitmapOperation.DOWNLOAD_BYTES;
        }
        return HttpBitmapLoader.getHttpBitmap(httpBitmapOperation, bitmapDownloadRequest);
    }
}
