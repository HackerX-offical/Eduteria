package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzw {
    public static Bitmap zza(Bitmap bitmap, zzs zzsVar) {
        int i;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (zzsVar.zze != 0) {
            Matrix matrix = new Matrix();
            int i2 = zzsVar.zze;
            if (i2 == 0) {
                i = 0;
            } else if (i2 == 1) {
                i = 90;
            } else if (i2 == 2) {
                i = 180;
            } else {
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unsupported rotation degree.");
                }
                i = 270;
            }
            matrix.postRotate(i);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        if (zzsVar.zze != 1 && zzsVar.zze != 3) {
            return bitmap;
        }
        zzsVar.zza = height;
        zzsVar.zzb = width;
        return bitmap;
    }

    public static ByteBuffer zza(Bitmap bitmap, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((((width + 1) / 2) * ((height + 1) / 2)) << 1) + i);
        int i2 = i;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 % width;
            int i5 = i3 / width;
            int pixel = bitmap.getPixel(i4, i5);
            float fRed = Color.red(pixel);
            float fGreen = Color.green(pixel);
            float fBlue = Color.blue(pixel);
            byteBufferAllocateDirect.put(i3, (byte) ((0.299f * fRed) + (0.587f * fGreen) + (0.114f * fBlue)));
            if (i5 % 2 == 0 && i4 % 2 == 0) {
                int i6 = i2 + 1;
                byteBufferAllocateDirect.put(i2, (byte) (((-0.169f) * fRed) + ((-0.331f) * fGreen) + (fBlue * 0.5f) + 128.0f));
                i2 += 2;
                byteBufferAllocateDirect.put(i6, (byte) ((fRed * 0.5f) + (fGreen * (-0.419f)) + (fBlue * (-0.081f)) + 128.0f));
            }
        }
        return byteBufferAllocateDirect;
    }
}
