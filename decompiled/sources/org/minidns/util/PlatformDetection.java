package org.minidns.util;

/* JADX INFO: loaded from: classes10.dex */
public class PlatformDetection {

    /* JADX INFO: renamed from: android, reason: collision with root package name */
    private static Boolean f1505android;

    public static boolean isAndroid() {
        if (f1505android == null) {
            try {
                Class.forName("android.Manifest");
                f1505android = true;
            } catch (Exception unused) {
                f1505android = false;
            }
        }
        return f1505android.booleanValue();
    }
}
