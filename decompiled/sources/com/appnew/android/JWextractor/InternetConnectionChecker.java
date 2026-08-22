package com.appnew.android.JWextractor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes6.dex */
public class InternetConnectionChecker extends BroadcastReceiver {
    public static final String INTERNET_STATE_RECEIVER = "INTERNET_STATE_RECEIVER";

    public boolean isOnline() {
        return Runtime.getRuntime().exec("/system/bin/ping -c 1 8.8.8.8").waitFor() == 0;
    }

    public boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getExtras() != null) {
            Intent intent2 = new Intent("android.net.conn.CONNECTIVITY_CHANGE");
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                intent2.putExtra("state", true);
            } else {
                intent2.putExtra("state", false);
            }
        }
    }
}
