package com.razorpay;

import android.util.Log;

/* JADX INFO: loaded from: classes9.dex */
public final class Logger {
    private static final String TAG = "com.razorpay.checkout";

    static void i(String str) {
        Log.i(TAG, str);
    }

    static void i(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    static void v(String str) {
        Log.v(TAG, str);
    }

    static void v(String str, Throwable th) {
        Log.v(TAG, str, th);
    }

    static void d(String str) {
        if (ConfigDroid.DEBUG.booleanValue()) {
            Log.d(TAG, str);
        }
    }

    static void d(String str, Throwable th) {
        if (ConfigDroid.DEBUG.booleanValue()) {
            Log.d(TAG, str, th);
        }
    }

    static void w(String str) {
        Log.w(TAG, str);
    }

    static void w(String str, Throwable th) {
        Log.w(TAG, str, th);
    }

    static void e(String str) {
        Log.e(TAG, str);
    }

    static void e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }
}
