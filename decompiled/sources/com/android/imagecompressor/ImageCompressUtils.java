package com.android.imagecompressor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: compressImageUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/android/imagecompressor/ImageCompressUtils;", "", "()V", "compressImage", "", "context", "Landroid/content/Context;", "imagePath", "imageName", "imageQuality", "", "ImageCompressor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageCompressUtils {
    public static final ImageCompressUtils INSTANCE = new ImageCompressUtils();

    public final String compressImage(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return compressImage$default(this, context, str, str2, 0, 8, null);
    }

    private ImageCompressUtils() {
    }

    public static /* synthetic */ String compressImage$default(ImageCompressUtils imageCompressUtils, Context context, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 50;
        }
        return imageCompressUtils.compressImage(context, str, str2, i);
    }

    public final String compressImage(Context context, String imagePath, String imageName, int imageQuality) {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = "";
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int i = options.outHeight;
            int i2 = options.outWidth;
            Intrinsics.checkNotNull(imagePath);
            byte[] allBytes = Files.readAllBytes(new File(imagePath).toPath());
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(allBytes, 0, allBytes.length, options);
            float f2 = i2;
            float f3 = i;
            float f4 = f2 / f3;
            if (f3 > 1024.0f || f2 > 912.0f) {
                if (f4 < 0.890625f) {
                    i2 = (int) ((1024.0f / f3) * f2);
                    i = (int) 1024.0f;
                } else {
                    i = f4 > 0.890625f ? (int) ((912.0f / f2) * f3) : (int) 1024.0f;
                    i2 = (int) 912.0f;
                }
            }
            options.inSampleSize = CompressImageUtilsKt.calculateInSampleSize(options, i2, i);
            options.inJustDecodeBounds = false;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inTempStorage = new byte[16384];
            try {
                bitmapDecodeByteArray = BitmapFactory.decodeFile(imagePath, options);
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
            }
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
            } catch (OutOfMemoryError e3) {
                e3.printStackTrace();
                bitmapCreateBitmap = null;
            }
            float f5 = i2;
            float f6 = f5 / options.outWidth;
            float f7 = i;
            float f8 = f7 / options.outHeight;
            float f9 = f5 / 2.0f;
            float f10 = f7 / 2.0f;
            Matrix matrix = new Matrix();
            matrix.setScale(f6, f8, f9, f10);
            Intrinsics.checkNotNull(bitmapCreateBitmap);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.setMatrix(matrix);
            canvas.drawBitmap(bitmapDecodeByteArray, f9 - (bitmapDecodeByteArray.getWidth() / 2), f10 - (bitmapDecodeByteArray.getHeight() / 2), new Paint(2));
            try {
                int attributeInt = new ExifInterface(imagePath.toString()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
                Log.d("EXIF", "Exif: " + attributeInt);
                Matrix matrix2 = new Matrix();
                if (attributeInt == 3) {
                    matrix2.postRotate(180.0f);
                    Log.d("EXIF", "Exif: " + attributeInt);
                } else if (attributeInt == 6) {
                    matrix2.postRotate(90.0f);
                    Log.d("EXIF", "Exif: " + attributeInt);
                } else if (attributeInt == 8) {
                    matrix2.postRotate(270.0f);
                    Log.d("EXIF", "Exif: " + attributeInt);
                }
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix2, true);
            } catch (IOException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            File outputMediaFile = imageName != null ? CompressImageUtilsKt.getOutputMediaFile(imageName, context) : null;
            Intrinsics.checkNotNull(outputMediaFile);
            String absolutePath = outputMediaFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "imageName?.let { getOutp…context) }!!.absolutePath");
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(absolutePath);
                    Intrinsics.checkNotNull(bitmapCreateBitmap);
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, imageQuality, fileOutputStream);
                    return absolutePath;
                } catch (FileNotFoundException e6) {
                    e6.printStackTrace();
                    return absolutePath;
                }
            } catch (Exception e7) {
                e = e7;
                str = absolutePath;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e8) {
            e = e8;
        }
    }
}
