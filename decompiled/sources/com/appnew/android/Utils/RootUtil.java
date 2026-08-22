package com.appnew.android.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.scottyab.rootbeer.RootBeer;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class RootUtil {
    public static String[] binaryPaths = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/su/bin/su", "/sbin/", "/su/bin/", "/system/bin/", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/sd/xbin/su", "/system/usr/we-need-root/", "/system/xbin/", "/system/app/Superuser.apk", "/system/bin/failsafe/su", "/cache", "/data", "/dev"};

    public static boolean isDeviceRooted() {
        return detectTestKeys() || checkForSuBinary() || checkSuExists() || checkForBusyBoxBinary();
    }

    public static boolean check_proxy(Context context) {
        List<Proxy> listSelect;
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            URI uriCreate = URI.create("https://appapi.videocrypt.in/");
            ProxySelector proxySelector = ProxySelector.getDefault();
            if (proxySelector != null && (listSelect = proxySelector.select(uriCreate)) != null && !listSelect.isEmpty()) {
                if (listSelect.get(0).toString().contains(":")) {
                    z = true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return !z ? checkVpn(context) : z;
    }

    public static boolean checkVpn(Context context) {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetwork = connectivityManager.getActiveNetwork()) != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
                if (networkCapabilities.hasTransport(4)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean detectFullRoot(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (!new RootBeer(context).isRooted() || Build.MODEL.equalsIgnoreCase("Lenovo K8 Plus")) {
                return false;
            }
            return !Build.MODEL.contains("Sony Xperia");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean detectTestKeys() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean checkForSuBinary() {
        return checkForBinary(CmcdConfiguration.KEY_STARTUP);
    }

    public static boolean checkForBusyBoxBinary() {
        return checkForBinary("busybox");
    }

    public static boolean checkForBinary(String filename) {
        for (String str : binaryPaths) {
            if (new File(str, filename).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSuExists() {
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec(new String[]{"/system /xbin/which", CmcdConfiguration.KEY_STARTUP});
                boolean z = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null;
                if (processExec != null) {
                    processExec.destroy();
                }
                return z;
            } catch (Exception e2) {
                e2.printStackTrace();
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }
}
