package com.clevertap.android.sdk.utils;

import android.graphics.Bitmap;
import com.clevertap.android.sdk.inapp.images.memory.Memory;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.message_fastening.element.FasteningElement;

/* JADX INFO: compiled from: CTCaches.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B3\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\f0\u000bJ\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f0\u000bJ\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f0\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/clevertap/android/sdk/utils/CTCaches;", "", "inAppImageMemoryV1", "Lcom/clevertap/android/sdk/inapp/images/memory/Memory;", "Landroid/graphics/Bitmap;", "inAppGifMemoryV1", "", "fileMemory", "<init>", "(Lcom/clevertap/android/sdk/inapp/images/memory/Memory;Lcom/clevertap/android/sdk/inapp/images/memory/Memory;Lcom/clevertap/android/sdk/inapp/images/memory/Memory;)V", "imageInMemory", "Lcom/clevertap/android/sdk/utils/InMemoryLruCache;", "Lkotlin/Pair;", "Ljava/io/File;", "gifInMemory", "fileInMemory", "imageDiskMemory", "Lcom/clevertap/android/sdk/utils/DiskMemory;", "gifDiskMemory", "fileDiskMemory", "Companion", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CTCaches {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static CTCaches ctCaches;
    private final Memory<byte[]> fileMemory;
    private final Memory<byte[]> inAppGifMemoryV1;
    private final Memory<Bitmap> inAppImageMemoryV1;

    public /* synthetic */ CTCaches(Memory memory, Memory memory2, Memory memory3, DefaultConstructorMarker defaultConstructorMarker) {
        this(memory, memory2, memory3);
    }

    private CTCaches(Memory<Bitmap> memory, Memory<byte[]> memory2, Memory<byte[]> memory3) {
        this.inAppImageMemoryV1 = memory;
        this.inAppGifMemoryV1 = memory2;
        this.fileMemory = memory3;
    }

    /* JADX INFO: compiled from: CTCaches.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bJ\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/clevertap/android/sdk/utils/CTCaches$Companion;", "", "<init>", "()V", "ctCaches", "Lcom/clevertap/android/sdk/utils/CTCaches;", "instance", "inAppImageMemoryV1", "Lcom/clevertap/android/sdk/inapp/images/memory/Memory;", "Landroid/graphics/Bitmap;", "inAppGifMemoryV1", "", "fileMemory", FasteningElement.ATTR_CLEAR, "", "clevertap-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CTCaches instance(Memory<Bitmap> inAppImageMemoryV1, Memory<byte[]> inAppGifMemoryV1, Memory<byte[]> fileMemory) {
            Intrinsics.checkNotNullParameter(inAppImageMemoryV1, "inAppImageMemoryV1");
            Intrinsics.checkNotNullParameter(inAppGifMemoryV1, "inAppGifMemoryV1");
            Intrinsics.checkNotNullParameter(fileMemory, "fileMemory");
            if (CTCaches.ctCaches == null) {
                synchronized (this) {
                    if (CTCaches.ctCaches == null) {
                        Companion companion = CTCaches.INSTANCE;
                        CTCaches.ctCaches = new CTCaches(inAppImageMemoryV1, inAppGifMemoryV1, fileMemory, null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            CTCaches cTCaches = CTCaches.ctCaches;
            Intrinsics.checkNotNull(cTCaches);
            return cTCaches;
        }

        public final void clear() {
            synchronized (this) {
                Companion companion = CTCaches.INSTANCE;
                CTCaches.ctCaches = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final InMemoryLruCache<Pair<Bitmap, File>> imageInMemory() {
        return this.inAppImageMemoryV1.createInMemory();
    }

    public final InMemoryLruCache<Pair<byte[], File>> gifInMemory() {
        return this.inAppGifMemoryV1.createInMemory();
    }

    public final InMemoryLruCache<Pair<byte[], File>> fileInMemory() {
        return this.fileMemory.createInMemory();
    }

    public final DiskMemory imageDiskMemory() {
        return this.inAppImageMemoryV1.createDiskMemory();
    }

    public final DiskMemory gifDiskMemory() {
        return this.inAppGifMemoryV1.createDiskMemory();
    }

    public final DiskMemory fileDiskMemory() {
        return this.fileMemory.createDiskMemory();
    }
}
