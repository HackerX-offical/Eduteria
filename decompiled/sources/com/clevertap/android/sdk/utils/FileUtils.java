package com.clevertap.android.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class FileUtils {
    private final CleverTapInstanceConfig config;
    private final Context context;

    public FileUtils(Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.context = context;
        this.config = cleverTapInstanceConfig;
    }

    public void deleteDirectory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (FileUtils.class) {
                File file = new File(this.context.getFilesDir(), str);
                if (file.exists() && file.isDirectory()) {
                    for (String str2 : file.list()) {
                        this.config.getLogger().verbose(this.config.getAccountId(), "File" + str2 + " isDeleted:" + new File(file, str2).delete());
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.config.getLogger().verbose(this.config.getAccountId(), "writeFileOnInternalStorage: failed" + str + " Error:" + e2.getLocalizedMessage());
        }
    }

    public void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (FileUtils.class) {
                File file = new File(this.context.getFilesDir(), str);
                if (file.exists()) {
                    if (file.delete()) {
                        this.config.getLogger().verbose(this.config.getAccountId(), "File Deleted:" + str);
                    } else {
                        this.config.getLogger().verbose(this.config.getAccountId(), "Failed to delete file" + str);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.config.getLogger().verbose(this.config.getAccountId(), "writeFileOnInternalStorage: failed" + str + " Error:" + e2.getLocalizedMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String readFromFile(java.lang.String r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            r1.<init>()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            android.content.Context r2 = r7.context     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.lang.StringBuilder r8 = r1.append(r8)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5f
            r1.<init>()     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5f
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5f
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L5f
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
        L37:
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> La7
            if (r0 == 0) goto L41
            r1.append(r0)     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> La7
            goto L37
        L41:
            r8.close()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> La7
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L52 java.lang.Throwable -> La7
            r8.close()
            r2.close()
            r3.close()
            return r0
        L52:
            r0 = move-exception
            goto L6f
        L54:
            r1 = move-exception
            r3 = r0
            goto L5d
        L57:
            r1 = move-exception
            r3 = r0
            goto L62
        L5a:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L5d:
            r0 = r1
            goto La8
        L5f:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L62:
            r0 = r1
            goto L6f
        L64:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
            goto La8
        L6a:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
        L6f:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.config     // Catch: java.lang.Throwable -> La7
            com.clevertap.android.sdk.Logger r1 = r1.getLogger()     // Catch: java.lang.Throwable -> La7
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r7.config     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = r4.getAccountId()     // Catch: java.lang.Throwable -> La7
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La7
            r5.<init>()     // Catch: java.lang.Throwable -> La7
            java.lang.String r6 = "[Exception While Reading: "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> La7
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch: java.lang.Throwable -> La7
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch: java.lang.Throwable -> La7
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La7
            r1.verbose(r4, r0)     // Catch: java.lang.Throwable -> La7
            if (r8 == 0) goto L9a
            r8.close()
        L9a:
            if (r2 == 0) goto L9f
            r2.close()
        L9f:
            if (r3 == 0) goto La4
            r3.close()
        La4:
            java.lang.String r8 = ""
            return r8
        La7:
            r0 = move-exception
        La8:
            if (r8 == 0) goto Lad
            r8.close()
        Lad:
            if (r2 == 0) goto Lb2
            r2.close()
        Lb2:
            if (r3 == 0) goto Lb7
            r3.close()
        Lb7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.utils.FileUtils.readFromFile(java.lang.String):java.lang.String");
    }

    public void writeJsonToFile(String str, String str2, JSONObject jSONObject) throws IOException {
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                try {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        synchronized (FileUtils.class) {
                            try {
                                File file = new File(this.context.getFilesDir(), str);
                                if (!file.exists() && !file.mkdir()) {
                                    return;
                                }
                                FileWriter fileWriter2 = new FileWriter(new File(file, str2), false);
                                try {
                                    fileWriter2.append((CharSequence) jSONObject.toString());
                                    fileWriter2.flush();
                                    fileWriter2.close();
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    fileWriter = fileWriter2;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    this.config.getLogger().verbose(this.config.getAccountId(), "writeFileOnInternalStorage: failed" + e2.getLocalizedMessage());
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                }
            } catch (Throwable th3) {
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th3;
            }
        }
    }
}
