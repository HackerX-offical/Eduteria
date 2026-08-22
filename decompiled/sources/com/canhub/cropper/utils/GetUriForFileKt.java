package com.canhub.cropper.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetUriForFile.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"authority", "", "Landroid/content/Context;", "getUriForFile", "Landroid/net/Uri;", "context", "file", "Ljava/io/File;", "cropper_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class GetUriForFileKt {
    public static final String authority(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getPackageName() + ".cropper.fileprovider";
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8 A[Catch: Exception -> 0x00e1, TryCatch #8 {Exception -> 0x00e1, blocks: (B:6:0x0022, B:12:0x0066, B:36:0x00d8, B:38:0x00dd, B:39:0x00e0, B:30:0x00cc, B:32:0x00d1), top: B:55:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd A[Catch: Exception -> 0x00e1, TryCatch #8 {Exception -> 0x00e1, blocks: (B:6:0x0022, B:12:0x0066, B:36:0x00d8, B:38:0x00dd, B:39:0x00e0, B:30:0x00cc, B:32:0x00d1), top: B:55:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.net.Uri getUriForFile(android.content.Context r10, java.io.File r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.canhub.cropper.utils.GetUriForFileKt.getUriForFile(android.content.Context, java.io.File):android.net.Uri");
    }
}
