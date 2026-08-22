package com.android.imagecompressor;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: compressImageUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000e"}, d2 = {"calculateInSampleSize", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "createImageFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "FileName", "", "getOutputMediaFile", "imageName", "ImageCompressor_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CompressImageUtilsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final File getOutputMediaFile(String str, Context context) {
        File fileCreateImageFile;
        try {
            fileCreateImageFile = createImageFile(context, str);
        } catch (IOException e2) {
            e2.printStackTrace();
            fileCreateImageFile = null;
        }
        Intrinsics.checkNotNull(fileCreateImageFile);
        if (fileCreateImageFile.exists()) {
            fileCreateImageFile.delete();
        }
        try {
            return createImageFile(context, str);
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int iRoundToInt = 1;
        if (i3 > i2 || i4 > i) {
            try {
                int iRoundToInt2 = MathKt.roundToInt(i3 / i2);
                iRoundToInt = MathKt.roundToInt(i4 / i);
                if (iRoundToInt2 < iRoundToInt) {
                    iRoundToInt = iRoundToInt2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return 1;
            }
        }
        while ((i4 * i3) / (iRoundToInt * iRoundToInt) > i * i2 * 2.0f) {
            iRoundToInt++;
        }
        return iRoundToInt;
    }

    private static final File createImageFile(Context context, String str) throws IOException {
        return new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES) + File.separator + str + ".png");
    }
}
