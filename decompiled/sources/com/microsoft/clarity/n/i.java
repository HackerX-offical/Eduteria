package com.microsoft.clarity.n;

import android.util.Log;
import com.clevertap.android.sdk.Constants;
import com.microsoft.clarity.models.LogLevel;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LogLevel f1092a = LogLevel.None;

    public static String a(String str) {
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[5];
            str2 = Constants.AES_PREFIX + stackTraceElement.getFileName().replace(".kt", "").replace(".java", "") + "::" + stackTraceElement.getMethodName() + "] ";
        } catch (Exception unused) {
        }
        return sb.append(str2).append(str).toString();
    }

    public static void b(String str) {
        if (LogLevel.Debug.ordinal() >= f1092a.ordinal()) {
            Log.d("Clarity", a(str));
        }
    }

    public static void c(String str) {
        if (LogLevel.Error.ordinal() >= f1092a.ordinal()) {
            Log.e("Clarity", a(str));
        }
    }

    public static void d(String str) {
        if (LogLevel.Info.ordinal() >= f1092a.ordinal()) {
            Log.i("Clarity", a(str));
        }
    }

    public static void e(String str) {
        if (LogLevel.Warning.ordinal() >= f1092a.ordinal()) {
            Log.w("Clarity", a(str));
        }
    }

    public static void a(String str, Exception exc) {
        if (LogLevel.Error.ordinal() >= f1092a.ordinal()) {
            Log.e("Clarity", a(str), exc);
        }
    }
}
