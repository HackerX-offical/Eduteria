package com.clevertap.android.sdk.network;

import android.graphics.Bitmap;
import com.clevertap.android.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DownloadedBitmap.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001 B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/clevertap/android/sdk/network/DownloadedBitmap;", "", "bitmap", "Landroid/graphics/Bitmap;", "status", "Lcom/clevertap/android/sdk/network/DownloadedBitmap$Status;", "downloadTime", "", "bytes", "", "<init>", "(Landroid/graphics/Bitmap;Lcom/clevertap/android/sdk/network/DownloadedBitmap$Status;J[B)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getStatus", "()Lcom/clevertap/android/sdk/network/DownloadedBitmap$Status;", "getDownloadTime", "()J", "getBytes", "()[B", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "component4", Constants.COPY_TYPE, InAppPurchaseConstants.METHOD_TO_STRING, "", "Status", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DownloadedBitmap {
    private final Bitmap bitmap;
    private final byte[] bytes;
    private final long downloadTime;
    private final Status status;

    public static /* synthetic */ DownloadedBitmap copy$default(DownloadedBitmap downloadedBitmap, Bitmap bitmap, Status status, long j, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = downloadedBitmap.bitmap;
        }
        if ((i & 2) != 0) {
            status = downloadedBitmap.status;
        }
        if ((i & 4) != 0) {
            j = downloadedBitmap.downloadTime;
        }
        if ((i & 8) != 0) {
            bArr = downloadedBitmap.bytes;
        }
        byte[] bArr2 = bArr;
        return downloadedBitmap.copy(bitmap, status, j, bArr2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Status getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDownloadTime() {
        return this.downloadTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final byte[] getBytes() {
        return this.bytes;
    }

    public final DownloadedBitmap copy(Bitmap bitmap, Status status, long downloadTime, byte[] bytes) {
        Intrinsics.checkNotNullParameter(status, "status");
        return new DownloadedBitmap(bitmap, status, downloadTime, bytes);
    }

    public String toString() {
        return "DownloadedBitmap(bitmap=" + this.bitmap + ", status=" + this.status + ", downloadTime=" + this.downloadTime + ", bytes=" + Arrays.toString(this.bytes) + ')';
    }

    public DownloadedBitmap(Bitmap bitmap, Status status, long j, byte[] bArr) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.bitmap = bitmap;
        this.status = status;
        this.downloadTime = j;
        this.bytes = bArr;
    }

    public /* synthetic */ DownloadedBitmap(Bitmap bitmap, Status status, long j, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap, status, j, (i & 8) != 0 ? null : bArr);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final long getDownloadTime() {
        return this.downloadTime;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: DownloadedBitmap.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/network/DownloadedBitmap$Status;", "", "statusValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatusValue", "()Ljava/lang/String;", "NO_IMAGE", "SUCCESS", "DOWNLOAD_FAILED", "NO_NETWORK", "INIT_ERROR", "SIZE_LIMIT_EXCEEDED", "GIF_SUCCESS", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        private final String statusValue;
        public static final Status NO_IMAGE = new Status("NO_IMAGE", 0, "NO_IMAGE");
        public static final Status SUCCESS = new Status("SUCCESS", 1, "SUCCESS");
        public static final Status DOWNLOAD_FAILED = new Status("DOWNLOAD_FAILED", 2, "DOWNLOAD_FAILED");
        public static final Status NO_NETWORK = new Status("NO_NETWORK", 3, "NO_NETWORK");
        public static final Status INIT_ERROR = new Status("INIT_ERROR", 4, "INIT_ERROR");
        public static final Status SIZE_LIMIT_EXCEEDED = new Status("SIZE_LIMIT_EXCEEDED", 5, "SIZE_LIMIT_EXCEEDED");
        public static final Status GIF_SUCCESS = new Status("GIF_SUCCESS", 6, "GIF_SUCCESS");

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{NO_IMAGE, SUCCESS, DOWNLOAD_FAILED, NO_NETWORK, INIT_ERROR, SIZE_LIMIT_EXCEEDED, GIF_SUCCESS};
        }

        public static EnumEntries<Status> getEntries() {
            return $ENTRIES;
        }

        private Status(String str, int i, String str2) {
            this.statusValue = str2;
        }

        public final String getStatusValue() {
            return this.statusValue;
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.clevertap.android.sdk.network.DownloadedBitmap");
        DownloadedBitmap downloadedBitmap = (DownloadedBitmap) other;
        return Intrinsics.areEqual(this.bitmap, downloadedBitmap.bitmap) && this.status == downloadedBitmap.status && this.downloadTime == downloadedBitmap.downloadTime && Arrays.equals(this.bytes, downloadedBitmap.bytes);
    }

    public int hashCode() {
        Bitmap bitmap = this.bitmap;
        return ((((((bitmap != null ? bitmap.hashCode() : 0) * 31) + this.status.hashCode()) * 31) + Long.hashCode(this.downloadTime)) * 31) + Arrays.hashCode(this.bytes);
    }
}
