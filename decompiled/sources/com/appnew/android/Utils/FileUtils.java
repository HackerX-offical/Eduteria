package com.appnew.android.Utils;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class FileUtils {
    private static Uri contentUri;
    public static Activity context;

    public FileUtils(Activity context2) {
        context = context2;
    }

    public static String getPath(Activity activity, Uri uri) throws Throwable {
        Throwable th;
        Uri uri2;
        context = activity;
        Cursor cursor = null;
        Uri uri3 = null;
        if (isExternalStorageDocument(uri)) {
            String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
            String str = strArrSplit[0];
            String pathFromExtSD = getPathFromExtSD(strArrSplit);
            if (pathFromExtSD != "") {
                return pathFromExtSD;
            }
            return null;
        }
        if (isDownloadsDocument(uri)) {
            try {
                uri2 = uri;
                Cursor cursorQuery = activity.getContentResolver().query(uri2, new String[]{"_display_name"}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String str2 = Environment.getExternalStorageDirectory().toString() + "/Download/" + cursorQuery.getString(0);
                            if (!TextUtils.isEmpty(str2)) {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return str2;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                            throw th;
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                String documentId = DocumentsContract.getDocumentId(uri2);
                if (!TextUtils.isEmpty(documentId)) {
                    if (documentId.startsWith("raw:")) {
                        return documentId.replaceFirst("raw:", "");
                    }
                    String[] strArr = new String[2];
                    try {
                        return getDataColumn(activity, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                    } catch (NumberFormatException unused) {
                        return uri2.getPath().replaceFirst("^/document/raw:", "").replaceFirst("^raw:", "");
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            uri2 = uri;
        }
        if (isMediaDocument(uri2)) {
            String[] strArrSplit2 = DocumentsContract.getDocumentId(uri2).split(":");
            String str3 = strArrSplit2[0];
            if ("image".equals(str3)) {
                uri3 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str3)) {
                uri3 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str3)) {
                uri3 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(activity, uri3, "_id=?", new String[]{strArrSplit2[1]});
        }
        if (isGoogleDriveUri(uri2)) {
            return getDriveFilePath(uri2);
        }
        if (isWhatsAppFile(uri2)) {
            return getFilePathForWhatsApp(uri2);
        }
        if ("content".equalsIgnoreCase(uri2.getScheme())) {
            if (isGooglePhotosUri(uri2)) {
                return uri2.getLastPathSegment();
            }
            if (isGoogleDriveUri(uri2)) {
                return getDriveFilePath(uri2);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return copyFileToInternalStorage(uri2, "userfiles");
            }
            return getDataColumn(activity, uri2, null, null);
        }
        if ("file".equalsIgnoreCase(uri2.getScheme())) {
            return uri2.getPath();
        }
        return null;
    }

    private static boolean fileExists(String filePath) {
        return new File(filePath).exists();
    }

    private static String getPathFromExtSD(String[] pathData) {
        String str = pathData[0];
        String str2 = MqttTopic.TOPIC_LEVEL_SEPARATOR + pathData[1];
        if ("primary".equalsIgnoreCase(str)) {
            String str3 = Environment.getExternalStorageDirectory() + str2;
            if (fileExists(str3)) {
                return str3;
            }
        }
        String str4 = System.getenv("SECONDARY_STORAGE") + str2;
        if (fileExists(str4)) {
            return str4;
        }
        String str5 = System.getenv("EXTERNAL_STORAGE") + str2;
        fileExists(str5);
        return str5;
    }

    public static String getDriveFilePath(Uri uri) {
        InputStream inputStreamOpenInputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        File file = new File(context.getCacheDir(), string);
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            fileOutputStream = new FileOutputStream(file);
            bArr = new byte[Math.min(inputStreamOpenInputStream.available(), 1048576)];
        } catch (Exception unused) {
        }
        while (true) {
            int i = inputStreamOpenInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, i);
            return file.getPath();
        }
        inputStreamOpenInputStream.close();
        fileOutputStream.close();
        return file.getPath();
    }

    private static String copyFileToInternalStorage(Uri uri, String newDirName) {
        File file;
        InputStream inputStreamOpenInputStream;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name", "_size"}, null, null, null);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        int columnIndex2 = cursorQuery.getColumnIndex("_size");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        Long.toString(cursorQuery.getLong(columnIndex2));
        if (!newDirName.equals("")) {
            File file2 = new File(context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName);
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + newDirName + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        } else {
            file = new File(context.getFilesDir() + MqttTopic.TOPIC_LEVEL_SEPARATOR + string);
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            fileOutputStream = new FileOutputStream(file);
            bArr = new byte[1024];
        } catch (Exception unused) {
        }
        while (true) {
            int i = inputStreamOpenInputStream.read(bArr);
            if (i == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, i);
            return file.getPath();
        }
        inputStreamOpenInputStream.close();
        fileOutputStream.close();
        return file.getPath();
    }

    private static String getFilePathForWhatsApp(Uri uri) {
        return copyFileToInternalStorage(uri, "whatsapp");
    }

    private static String getDataColumn(Context context2, Uri uri, String selection, String[] selectionArgs) throws Throwable {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context2.getContentResolver().query(uri, new String[]{"_data"}, selection, selectionArgs, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                        throw th;
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isWhatsAppFile(Uri uri) {
        return "com.whatsapp.provider.media".equals(uri.getAuthority());
    }

    private static boolean isGoogleDriveUri(Uri uri) {
        return "com.google.android.apps.docs.storage".equals(uri.getAuthority()) || "com.google.android.apps.docs.storage.legacy".equals(uri.getAuthority());
    }
}
