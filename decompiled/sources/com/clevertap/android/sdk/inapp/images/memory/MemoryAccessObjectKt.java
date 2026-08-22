package com.clevertap.android.sdk.inapp.images.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.clevertap.android.sdk.inapp.images.ExtensionsKt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryAccessObject.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\"0\u0010\u0000\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"0\u0010\t\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b\".\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\"0\u0010\u000f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"fileToBitmap", "Lkotlin/Function1;", "Ljava/io/File;", "Lkotlin/ParameterName;", "name", "file", "Landroid/graphics/Bitmap;", "getFileToBitmap", "()Lkotlin/jvm/functions/Function1;", "fileToBytes", "", "getFileToBytes", "bytesToBitmap", "bytes", "getBytesToBitmap", "bitmapToBytes", "bitmap", "getBitmapToBytes", "clevertap-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MemoryAccessObjectKt {
    private static final Function1<File, Bitmap> fileToBitmap = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObjectKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MemoryAccessObjectKt.fileToBitmap$lambda$0((File) obj);
        }
    };
    private static final Function1<File, byte[]> fileToBytes = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObjectKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MemoryAccessObjectKt.fileToBytes$lambda$1((File) obj);
        }
    };
    private static final Function1<byte[], Bitmap> bytesToBitmap = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObjectKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MemoryAccessObjectKt.bytesToBitmap$lambda$2((byte[]) obj);
        }
    };
    private static final Function1<Bitmap, byte[]> bitmapToBytes = new Function1() { // from class: com.clevertap.android.sdk.inapp.images.memory.MemoryAccessObjectKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return MemoryAccessObjectKt.bitmapToBytes$lambda$4((Bitmap) obj);
        }
    };

    public static final Function1<File, Bitmap> getFileToBitmap() {
        return fileToBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap fileToBitmap$lambda$0(File file) {
        if (file == null || !ExtensionsKt.hasValidBitmap(file)) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static final Function1<File, byte[]> getFileToBytes() {
        return fileToBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] fileToBytes$lambda$1(File file) {
        if (file != null) {
            return FilesKt.readBytes(file);
        }
        return null;
    }

    public static final Function1<byte[], Bitmap> getBytesToBitmap() {
        return bytesToBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap bytesToBitmap$lambda$2(byte[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return BitmapFactory.decodeByteArray(it, 0, it.length);
    }

    public static final Function1<Bitmap, byte[]> getBitmapToBytes() {
        return bitmapToBytes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] bitmapToBytes$lambda$4(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
