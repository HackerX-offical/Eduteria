package com.appnew.android.Utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.appnew.android.Utils.StoreProvider;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes6.dex */
public class videoPlayerStorage {
    public static final int CONTROL_STORE = 1;
    public static final int DATA_STORE = 1;
    private String appName;
    public final ContentResolver contentResolver;
    String[] projection = {"key", "data"};

    public videoPlayerStorage(Context context, String appName, int stVersion) {
        this.contentResolver = context.getContentResolver();
        this.appName = appName;
        StoreProvider.videoPlayer_DATABASE_VERSION = stVersion;
        StoreProvider.videoPlayer_AUTHORITY = "com.eduteria.app.app.Utils.StoreProvider";
    }

    public int addRecordStore(String key, Object data) {
        return addRecords(this.appName, key, data);
    }

    private int addRecords(String app, String key, Object data) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(data);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return addRecordData(app, key, byteArray, 0, byteArray.length, 1);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private synchronized int addRecordData(String app, String key, byte[] bdata, int offset, int length, int type) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(StoreProvider.StoreData.APP, app);
        contentValues.put("key", key);
        contentValues.put("data", bdata);
        this.contentResolver.insert(Uri.parse("content://" + StoreProvider.videoPlayer_AUTHORITY + "/data/appkey/" + app + MqttTopic.TOPIC_LEVEL_SEPARATOR + key), contentValues);
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003f A[Catch: Exception -> 0x0043, TRY_LEAVE, TryCatch #5 {Exception -> 0x0043, blocks: (B:26:0x003a, B:28:0x003f), top: B:41:0x003a }] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.ObjectInput] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getRecordObject(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r4.appName     // Catch: java.lang.Exception -> L48
            java.lang.Object r5 = r4.getRecordData(r1, r5)     // Catch: java.lang.Exception -> L48
            byte[] r5 = (byte[]) r5     // Catch: java.lang.Exception -> L48
            if (r5 != 0) goto Lc
            return r0
        Lc:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2d
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2d
            java.lang.Object r0 = r5.readObject()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L39
            r1.close()     // Catch: java.lang.Exception -> L21
        L1d:
            r5.close()     // Catch: java.lang.Exception -> L21
            goto L38
        L21:
            r5 = move-exception
            r5.printStackTrace()
            goto L38
        L26:
            r2 = move-exception
            goto L2f
        L28:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L3a
        L2d:
            r2 = move-exception
            r5 = r0
        L2f:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L39
            r1.close()     // Catch: java.lang.Exception -> L21
            if (r5 == 0) goto L38
            goto L1d
        L38:
            return r0
        L39:
            r0 = move-exception
        L3a:
            r1.close()     // Catch: java.lang.Exception -> L43
            if (r5 == 0) goto L47
            r5.close()     // Catch: java.lang.Exception -> L43
            goto L47
        L43:
            r5 = move-exception
            r5.printStackTrace()
        L47:
            throw r0
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.Utils.videoPlayerStorage.getRecordObject(java.lang.String):java.lang.Object");
    }

    private Object getRecordData(String app, String key) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        try {
            cursorQuery = this.contentResolver.query(Uri.parse("content://" + StoreProvider.videoPlayer_AUTHORITY + "/data/appkey/" + app + MqttTopic.TOPIC_LEVEL_SEPARATOR + key), this.projection, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
                byte[] blob = cursorQuery.getBlob(1);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return blob;
            } catch (Throwable th2) {
                th = th2;
                if (cursorQuery != null) {
                    cursorQuery.close();
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
    }

    public synchronized void deleteStore() {
        this.contentResolver.delete(Uri.parse("content://" + StoreProvider.videoPlayer_AUTHORITY + "/data"), null, null);
    }

    public synchronized void deleteRecord(String key) {
        try {
            this.contentResolver.delete(Uri.parse("content://" + StoreProvider.videoPlayer_AUTHORITY + "/data/appkey/" + this.appName + MqttTopic.TOPIC_LEVEL_SEPARATOR + key), null, null);
        } catch (Exception unused) {
        }
    }
}
