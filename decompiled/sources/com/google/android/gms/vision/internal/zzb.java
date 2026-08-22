package com.google.android.gms.vision.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzb {
    public static Bitmap zza(ByteBuffer byteBuffer, int i, int i2, int i3) throws IOException {
        byte[] bArrArray;
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            bArrArray = byteBuffer.array();
        } else {
            byteBuffer.rewind();
            int iLimit = byteBuffer.limit();
            byte[] bArr = new byte[iLimit];
            byteBuffer.get(bArr, 0, iLimit);
            bArrArray = bArr;
        }
        byte[] bArrZza = zza(bArrArray, i, i2);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrZza, 0, bArrZza.length);
        return zza(bitmapDecodeByteArray, i3, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    private static byte[] zza(byte[] bArr, int i, int i2) throws IOException {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } finally {
        }
    }

    public static Bitmap zza(Bitmap bitmap, int i, int i2, int i3) {
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }

    public static ByteBuffer zza(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[((i3 / 4) * 2) + i3];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        int i4 = (i3 * 2) / 4;
        boolean z = buffer2.remaining() == i4 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        if (z) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer3.get(bArr, i3 + 1, i4 - 1);
        } else {
            zza(planeArr[0], i, i2, bArr, 0, 1);
            zza(planeArr[1], i, i2, bArr, i3 + 1, 2);
            zza(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    private static void zza(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int iLimit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (iLimit == 0) {
            return;
        }
        int i5 = i / (i2 / iLimit);
        int rowStride = 0;
        for (int i6 = 0; i6 < iLimit; i6++) {
            int pixelStride = rowStride;
            for (int i7 = 0; i7 < i5; i7++) {
                bArr[i3] = buffer.get(pixelStride);
                i3 += i4;
                pixelStride += plane.getPixelStride();
            }
            rowStride += plane.getRowStride();
        }
    }
}
