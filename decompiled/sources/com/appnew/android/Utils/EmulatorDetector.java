package com.appnew.android.Utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class EmulatorDetector {
    private static final String[] QEMU_DRIVERS = {"goldfish"};
    private static final String[] GENY_FILES = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
    private static final String[] PIPES = {"/dev/socket/qemud", "/dev/qemu_pipe"};
    private static final String[] X86_FILES = {"ueventd.android_x86.rc", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc"};
    private static final String[] ANDY_FILES = {"fstab.andy", "ueventd.andy.rc"};
    private static final String[] NOX_FILES = {"fstab.nox", "init.nox.rc", "ueventd.nox.rc"};

    public static boolean isEmulator(Context context) {
        return checkBasic() || checkAdvanced() || checkPackageName(context);
    }

    private static boolean checkBasic() {
        int i = (Build.PRODUCT.equals("sdk_x86_64") || Build.PRODUCT.equals("sdk_google_phone_x86") || Build.PRODUCT.equals("sdk_google_phone_x86_64") || Build.PRODUCT.equals("sdk_google_phone_arm64") || Build.PRODUCT.equals("vbox86p")) ? 1 : 0;
        if (Build.MANUFACTURER.equals("unknown")) {
            i++;
        }
        if (Build.BRAND.equals("generic") || Build.BRAND.equalsIgnoreCase("android") || Build.BRAND.equals("generic_arm64") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("generic_x86_64")) {
            i++;
        }
        if (Build.DEVICE.equals("generic") || Build.DEVICE.equals("generic_arm64") || Build.DEVICE.equals("generic_x86") || Build.DEVICE.equals("generic_x86_64") || Build.DEVICE.equals("vbox86p")) {
            i++;
        }
        if (Build.MODEL.equals(ServerProtocol.DIALOG_PARAM_SDK_VERSION) || Build.MODEL.equals("Android SDK built for arm64") || Build.MODEL.equals("Android SDK built for armv7") || Build.MODEL.equals("Android SDK built for x86") || Build.MODEL.equals("Android SDK built for x86_64")) {
            i++;
        }
        if (Build.HARDWARE.equals("ranchu")) {
            i++;
        }
        if (Build.FINGERPRINT.contains("sdk_google_phone_arm64") || Build.FINGERPRINT.contains("sdk_google_phone_armv7")) {
            i++;
        }
        boolean z = Build.FINGERPRINT.startsWith("generic") || Build.MODEL.contains("google_sdk") || Build.MODEL.toLowerCase().contains("droid4x") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.PRODUCT.equals(ServerProtocol.DIALOG_PARAM_SDK_VERSION) || Build.PRODUCT.startsWith("google_sdk") || Build.PRODUCT.equals("sdk_x86") || Build.PRODUCT.equals("vbox86p") || Build.BOARD.toLowerCase().contains("nox") || Build.BOOTLOADER.toLowerCase().contains("nox") || Build.HARDWARE.toLowerCase().contains("nox") || Build.PRODUCT.toLowerCase().contains("nox") || Build.SERIAL.toLowerCase().contains("nox") || Build.HOST.contains("Droid4x-BuildStation") || Build.MANUFACTURER.startsWith("iToolsAVM") || Build.DEVICE.startsWith("iToolsAVM") || Build.MODEL.startsWith("iToolsAVM") || Build.BRAND.startsWith("generic") || Build.HARDWARE.startsWith("vbox86");
        if (z) {
            return true;
        }
        boolean z2 = z | (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"));
        return z2 || z2 || "google_sdk".equals(Build.PRODUCT) || i >= 2;
    }

    private static boolean checkQEmuDrivers() {
        File[] fileArr = {new File("/proc/tty/drivers"), new File("/proc/cpuinfo")};
        for (int i = 0; i < 2; i++) {
            File file = fileArr[i];
            if (file.exists() && file.canRead()) {
                byte[] bArr = new byte[1024];
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String str = new String(bArr);
                for (String str2 : QEMU_DRIVERS) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkAdvanced() {
        return checkFiles(GENY_FILES) || checkFiles(ANDY_FILES) || checkFiles(NOX_FILES) || checkQEmuDrivers() || checkFiles(PIPES) || checkFiles(X86_FILES);
    }

    private static boolean checkFiles(String[] targets) {
        for (String str : targets) {
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            if (it.next().activityInfo.packageName.startsWith("com.bluestacks.")) {
                return true;
            }
        }
        Iterator<ApplicationInfo> it2 = packageManager.getInstalledApplications(128).iterator();
        while (it2.hasNext()) {
            String str = it2.next().packageName;
            if (str.startsWith("com.vphone.") || str.startsWith("com.bignox.") || str.startsWith("com.nox.mopen.app") || str.startsWith("me.haima.") || str.startsWith("com.bluestacks.")) {
                return true;
            }
            if ((str.startsWith("cn.itools.") && Build.PRODUCT.startsWith("iToolsAVM")) || str.startsWith("com.kop.") || str.startsWith("com.kaopu.") || str.startsWith("com.microvirt.") || str.equals("com.google.android.launcher.layouts.genymotion")) {
                return true;
            }
        }
        Iterator<ActivityManager.RunningServiceInfo> it3 = ((ActivityManager) context.getSystemService("activity")).getRunningServices(30).iterator();
        while (it3.hasNext()) {
            if (it3.next().service.getClassName().startsWith("com.bluestacks.")) {
                return true;
            }
        }
        return false;
    }
}
