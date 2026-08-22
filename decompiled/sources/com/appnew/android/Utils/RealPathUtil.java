package com.appnew.android.Utils;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.File;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class RealPathUtil {
    public static boolean isLocalStorageDocument(Uri uri) {
        return false;
    }

    public static String getPath(final Context context, final Uri uri) {
        String dataColumn;
        Uri uri2 = null;
        if (isDocumentUri(context, uri)) {
            if (isLocalStorageDocument(uri)) {
                return getDocumentId(uri);
            }
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + MqttTopic.TOPIC_LEVEL_SEPARATOR + strArrSplit[1];
                }
                File fileIfExists = getFileIfExists("/storage/extSdCard", strArrSplit[1]);
                if (fileIfExists != null) {
                    return fileIfExists.getAbsolutePath();
                }
                File fileIfExists2 = getFileIfExists("/storage/sdcard1", strArrSplit[1]);
                if (fileIfExists2 != null) {
                    return fileIfExists2.getAbsolutePath();
                }
                File fileIfExists3 = getFileIfExists("/storage/usbcard1", strArrSplit[1]);
                if (fileIfExists3 != null) {
                    return fileIfExists3.getAbsolutePath();
                }
                File fileIfExists4 = getFileIfExists("/storage/sdcard0", strArrSplit[1]);
                if (fileIfExists4 != null) {
                    return fileIfExists4.getAbsolutePath();
                }
            } else if (isDownloadsDocument(uri)) {
                String documentId = getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.substring("raw:".length());
                }
                try {
                    String[] strArr = {"content://downloads/public_downloads", "content://downloads/my_downloads", "content://downloads/all_downloads"};
                    for (int i = 0; i < 3; i++) {
                        try {
                            dataColumn = getDataColumn(context, ContentUris.withAppendedId(Uri.parse(strArr[i]), Long.valueOf(documentId).longValue()), null, null);
                        } catch (Exception unused) {
                        }
                        if (dataColumn != null) {
                            return dataColumn;
                        }
                    }
                } catch (NumberFormatException unused2) {
                }
                String displayNameColumn = getDisplayNameColumn(context, uri, null, null);
                if (displayNameColumn != null) {
                    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), displayNameColumn);
                    if (file.exists()) {
                        return file.getAbsolutePath();
                    }
                }
            } else if (isMediaDocument(uri)) {
                String[] strArrSplit2 = getDocumentId(uri).split(":");
                String str = strArrSplit2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    private static boolean isDocumentUri(Context context, Uri uri) {
        return DocumentsContract.isDocumentUri(context, uri);
    }

    private static String getDocumentId(Uri documentUri) {
        return DocumentsContract.getDocumentId(documentUri);
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static File getFileIfExists(String basePath, String path) {
        File file = new File(basePath);
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file, path);
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    public static String getDisplayNameColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        return getColumn(context, uri, "_display_name", selection, selectionArgs);
    }

    public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        return getColumn(context, uri, "_data", selection, selectionArgs);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003e A[PHI: r8
      0x003e: PHI (r8v3 android.database.Cursor) = (r8v2 android.database.Cursor), (r8v4 android.database.Cursor) binds: [B:21:0x003c, B:13:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getColumn(android.content.Context r8, android.net.Uri r9, java.lang.String r10, java.lang.String r11, java.lang.String[] r12) throws java.lang.Throwable {
        /*
            r0 = 1
            java.lang.String[] r3 = new java.lang.String[r0]
            r0 = 0
            r3[r0] = r10
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L3b
            r6 = 0
            r2 = r9
            r4 = r11
            r5 = r12
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L3b
            if (r8 == 0) goto L30
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L3c
            if (r9 == 0) goto L30
            android.database.DatabaseUtils.dumpCursor(r8)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L3c
            int r9 = r8.getColumnIndexOrThrow(r10)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L3c
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L2c java.lang.Exception -> L3c
            if (r8 == 0) goto L2b
            r8.close()
        L2b:
            return r9
        L2c:
            r0 = move-exception
            r9 = r0
            r7 = r8
            goto L35
        L30:
            if (r8 == 0) goto L41
            goto L3e
        L33:
            r0 = move-exception
            r9 = r0
        L35:
            if (r7 == 0) goto L3a
            r7.close()
        L3a:
            throw r9
        L3b:
            r8 = r7
        L3c:
            if (r8 == 0) goto L41
        L3e:
            r8.close()
        L41:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.RealPathUtil.getColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String, java.lang.String[]):java.lang.String");
    }
}
