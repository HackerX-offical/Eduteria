package com.appnew.android.Utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes6.dex */
public class RootChecker {
    public static boolean isRooted(Context context) {
        return isTestBuild() || hasSuperuserAPK() || hasChainfiresupersu(context) || hasSU();
    }

    private static boolean isTestBuild() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean hasSuperuserAPK() {
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean hasChainfiresupersu(Context context) {
        return isPackageInstalled("eu.chainfire.supersu", context);
    }

    private static boolean hasSU() {
        return findBinary(CmcdConfiguration.KEY_STARTUP) || executeCommand(new String[]{"/system/xbin/which", CmcdConfiguration.KEY_STARTUP}) || executeCommand(new String[]{"which", CmcdConfiguration.KEY_STARTUP});
    }

    private static boolean isPackageInstalled(String packagename, Context context) {
        try {
            context.getPackageManager().getPackageInfo(packagename, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static boolean findBinary(String binaryName) {
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i = 0; i < 8; i++) {
            if (new File(strArr[i] + binaryName).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean executeCommand(String[] command) throws Throwable {
        BufferedReader bufferedReader;
        Process process = null;
        try {
            Process processExec = Runtime.getRuntime().exec(command);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                try {
                    boolean z = bufferedReader.readLine() != null;
                    if (processExec != null) {
                        processExec.destroy();
                    }
                    try {
                        bufferedReader.close();
                        return z;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return z;
                    }
                } catch (Exception unused) {
                    process = processExec;
                    if (process != null) {
                        process.destroy();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    process = processExec;
                    if (process != null) {
                        process.destroy();
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                bufferedReader = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Exception unused3) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }
}
