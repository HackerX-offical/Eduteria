package easypay.appinvoke.utils;

import easypay.appinvoke.manager.Constants;

/* JADX INFO: loaded from: classes9.dex */
public class Log {
    public static void i(String str, String str2) {
        android.util.Log.i(str, str2);
    }

    public static void e(String str, String str2) {
        if (Constants.DEV_MODE) {
            android.util.Log.d(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (Constants.DEV_MODE) {
            android.util.Log.d(str, str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (Constants.DEV_MODE) {
            android.util.Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (Constants.DEV_MODE) {
            android.util.Log.d(str, str2, th);
        }
    }

    public static void v(String str, String str2) {
        if (Constants.DEV_MODE) {
            android.util.Log.d(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (Constants.DEV_MODE) {
            android.util.Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (Constants.DEV_MODE) {
            android.util.Log.w(str, str2, th);
        }
    }
}
