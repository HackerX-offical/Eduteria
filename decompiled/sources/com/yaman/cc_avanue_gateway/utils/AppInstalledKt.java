package com.yaman.cc_avanue_gateway.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppInstalled.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"isAppInstalled", "", "packageName", "", "activity", "Landroid/app/Activity;", "cc_avanue_gateway_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AppInstalledKt {
    public static final boolean isAppInstalled(String packageName, Activity activity) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            activity.getPackageManager().getPackageInfo(packageName, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
