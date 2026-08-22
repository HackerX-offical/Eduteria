package com.appnew.android.Utils;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes6.dex */
public class ToastManager {
    private static Toast currentToast;

    public static void showToast(Context context, String message, int duration) {
        Toast toast = currentToast;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(context, message, duration);
        currentToast = toastMakeText;
        toastMakeText.show();
    }

    public static boolean isToastVisible() {
        return currentToast != null;
    }

    public static void cancelToast() {
        Toast toast = currentToast;
        if (toast != null) {
            toast.cancel();
            currentToast = null;
        }
    }
}
