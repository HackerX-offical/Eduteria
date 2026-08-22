package com.clevertap.android.sdk.inapp.images;

import android.graphics.BitmapFactory;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: compiled from: Extensions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"hasValidBitmap", "", "Ljava/io/File;", "clevertap-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExtensionsKt {
    public static final boolean hasValidBitmap(File file) {
        if (file != null && file.exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
            if (options.outWidth != -1 && options.outHeight != -1) {
                return true;
            }
        }
        return false;
    }
}
