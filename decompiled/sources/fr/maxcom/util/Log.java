package fr.maxcom.util;

import android.util.LogPrinter;
import android.util.Printer;
import androidx.exifinterface.media.ExifInterface;
import fr.maxcom.libmedia.a;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Printer f1300a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static List<String> f92a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static Pattern f93a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static boolean f94a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f1301b = true;

    private Log() {
    }

    private static boolean a(String str) {
        List<String> list = f92a;
        if (list == null && f93a == null) {
            return true;
        }
        if (list != null && list.contains(str)) {
            return true;
        }
        Pattern pattern = f93a;
        return pattern != null && pattern.matcher(str).matches();
    }

    public static int d(String str, String str2) {
        return (f94a && f1300a != null && a(str)) ? a(3, str, str2) : android.util.Log.d(str, str2);
    }

    public static int e(String str, String str2) {
        return (f94a && f1300a != null && a(str)) ? a(6, str, str2) : android.util.Log.e(str, str2);
    }

    public static int i(String str, String str2) {
        return (f94a && f1300a != null && a(str)) ? a(4, str, str2) : android.util.Log.i(str, str2);
    }

    public static int println(int i, String str, String str2) {
        return (f94a && f1300a != null && a(str)) ? a(i, str, str2) : android.util.Log.println(i, str, str2);
    }

    public static int v(String str, String str2) {
        return (f94a && f1300a != null && a(str)) ? a(2, str, str2) : android.util.Log.v(str, str2);
    }

    public static int w(String str, String str2) {
        return (f94a && f1300a != null && a(str)) ? a(5, str, str2) : android.util.Log.w(str, str2);
    }

    private static int a(int i, String str, String str2) {
        String strValueOf;
        switch (i) {
            case 2:
                strValueOf = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                break;
            case 3:
                strValueOf = "D";
                break;
            case 4:
                strValueOf = "I";
                break;
            case 5:
                strValueOf = ExifInterface.LONGITUDE_WEST;
                break;
            case 6:
                strValueOf = ExifInterface.LONGITUDE_EAST;
                break;
            case 7:
                strValueOf = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                break;
            default:
                strValueOf = String.valueOf(i);
                break;
        }
        String str3 = String.format(Locale.ENGLISH, f1300a instanceof LogPrinter ? "%s %tm-%<td %<tT.%<tL %s %s" : "%s\t%tm-%<td %<tT.%<tL\t%s\t%s", strValueOf, new Date(), str, str2);
        if (f1301b || a.b() != 4) {
            f1300a.println(str3);
        }
        return str3.length() + 1;
    }

    public static int d(String str, String str2, Throwable th) {
        if (f94a && f1300a != null && a(str)) {
            return a(3, str, str2 + '\n' + android.util.Log.getStackTraceString(th));
        }
        return android.util.Log.d(str, str2, th);
    }

    public static int e(String str, String str2, Throwable th) {
        if (f94a && f1300a != null && a(str)) {
            return a(6, str, str2 + '\n' + android.util.Log.getStackTraceString(th));
        }
        return android.util.Log.e(str, str2, th);
    }

    public static int i(String str, String str2, Throwable th) {
        if (f94a && f1300a != null && a(str)) {
            return a(4, str, str2 + '\n' + android.util.Log.getStackTraceString(th));
        }
        return android.util.Log.i(str, str2, th);
    }

    public static int v(String str, String str2, Throwable th) {
        if (f94a && f1300a != null && a(str)) {
            return a(2, str, str2 + '\n' + android.util.Log.getStackTraceString(th));
        }
        return android.util.Log.v(str, str2, th);
    }

    public static int w(String str, String str2, Throwable th) {
        if (f94a && f1300a != null && a(str)) {
            return a(5, str, str2 + '\n' + android.util.Log.getStackTraceString(th));
        }
        return android.util.Log.w(str, str2, th);
    }

    public static int w(String str, Throwable th) {
        if (f94a && f1300a != null && a(str)) {
            return a(5, str, android.util.Log.getStackTraceString(th));
        }
        return android.util.Log.w(str, th);
    }
}
