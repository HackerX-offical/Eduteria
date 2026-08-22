package fr.maxcom.libmedia;

import android.content.Context;
import android.os.Build;
import fr.maxcom.util.Log;

/* JADX INFO: loaded from: classes9.dex */
public final class Licensing {
    public static final String VERSION = "3.2.5";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1291a;

    private Licensing() {
    }

    public static boolean getDeveloperMode() {
        return f1291a;
    }

    public static void setDeveloperMode(boolean z) {
        f1291a = z;
        if (z) {
            Log.v("Libmedia", "BRAND " + Build.BRAND);
            Log.v("Libmedia", "DEVICE " + Build.DEVICE);
            Log.v("Libmedia", "MANUFACTURER " + Build.MANUFACTURER);
            Log.v("Libmedia", "MODEL " + Build.MODEL);
            Log.v("Libmedia", "RELEASE " + Build.VERSION.RELEASE);
            Log.v("Libmedia", "SDK " + Build.VERSION.SDK_INT);
            Log.v("Libmedia", "Libmedia version: 3.2.5");
        }
    }

    public static void allow(Context context) {
        a.f1292a = context.getApplicationContext();
    }
}
