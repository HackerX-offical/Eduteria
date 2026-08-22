package com.appnew.android.Utils.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes6.dex */
public class CheckConnection {
    public static boolean isConnection(Context ctx) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ctx.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
