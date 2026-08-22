package com.clevertap.android.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: loaded from: classes7.dex */
public class PackageUtils {
    private static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    private static final String GOOGLE_PLAY_STORE_PACKAGE_OLD = "com.google.market";

    public static boolean isGooglePlayServicesAvailable(Context context) {
        try {
            Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
        } catch (ClassNotFoundException unused) {
        }
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }

    public static boolean isGooglePlayStoreAvailable(Context context) {
        return isPackageAvailable(context, "com.android.vending") || isPackageAvailable(context, GOOGLE_PLAY_STORE_PACKAGE_OLD);
    }

    private static boolean isPackageAvailable(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
