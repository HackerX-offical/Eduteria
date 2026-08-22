package com.appnew.android.cleverTap;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.amazonaws.services.s3.internal.Constants;
import com.appnew.android.BuildConfig;
import com.appnew.android.Utils.Const;
import com.appnew.android.Utils.SharedPreference;
import com.appnew.android.pojo.Userinfo.Data;
import com.clevertap.android.sdk.network.api.CtApi;
import com.clevertap.android.sdk.product_config.CTProductConfigConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AnalyticHelper.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001d¨\u0006\u001f"}, d2 = {"Lcom/appnew/android/cleverTap/AnalyticHelper;", "", "<init>", "()V", "getUserGenderForCleverTap", "", "gender", "getUserDetails", "Lcom/appnew/android/pojo/Userinfo/Data;", "setLongToDateMills", CTProductConfigConstants.KEY_LAST_FETCHED_TIMESTAMP, "getUserId", "getUserName", "getUserMobile", "getDeviceId", "getDeviceType", "getCurrentDateTimeForEvent", "getCurrentTimeStampForEvent", "getDayPartingForEvent", "getNetworkInfo", "Lkotlin/Pair;", "context", "Landroid/content/Context;", "getVersionName", "activity", "getVersionCode", "", "getOSVersion", Const.IsFirstLaunch, "", "isCleverTapEnable", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticHelper {
    public static final int $stable = 0;
    public static final AnalyticHelper INSTANCE = new AnalyticHelper();

    private AnalyticHelper() {
    }

    public final String getUserGenderForCleverTap(String gender) {
        if (StringsKt.equals("male", gender, true)) {
            return "M";
        }
        if (StringsKt.equals("female", gender, true)) {
            return "F";
        }
        return "";
    }

    public final Data getUserDetails() {
        if (SharedPreference.getInstance().getLoggedInUser() != null) {
            Data loggedInUser = SharedPreference.getInstance().getLoggedInUser();
            Intrinsics.checkNotNull(loggedInUser);
            return loggedInUser;
        }
        return new Data();
    }

    public final String setLongToDateMills(String ts) {
        Intrinsics.checkNotNullParameter(ts, "ts");
        if (!TextUtils.isEmpty(ts) && !Intrinsics.areEqual(Constants.NULL_VERSION_ID, ts)) {
            Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
            calendar.setTimeInMillis(Long.parseLong(ts) * ((long) 1000));
            return DateFormat.format("dd MMMM, yyyy", calendar).toString();
        }
        return "";
    }

    public final String getUserId() {
        String id;
        return (TextUtils.isEmpty(getUserDetails().getId()) || (id = getUserDetails().getId()) == null) ? "NA" : id;
    }

    public final String getUserName() {
        String name;
        return (TextUtils.isEmpty(getUserDetails().getName()) || (name = getUserDetails().getName()) == null) ? "NA" : name;
    }

    public final String getUserMobile() {
        String mobile;
        return (TextUtils.isEmpty(getUserDetails().getMobile()) || (mobile = getUserDetails().getMobile()) == null) ? "NA" : mobile;
    }

    public final String getDeviceId() {
        String deviceId;
        return (SharedPreference.getInstance().getLoggedInUser() == null || TextUtils.isEmpty(SharedPreference.getInstance().getLoggedInUser().getDeviceId()) || (deviceId = SharedPreference.getInstance().getLoggedInUser().getDeviceId()) == null) ? "NA" : deviceId;
    }

    public final String getDeviceType() {
        return CtApi.DEFAULT_QUERY_PARAM_OS;
    }

    public final String getCurrentDateTimeForEvent() {
        String str = new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final String getCurrentTimeStampForEvent() {
        String str = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final String getDayPartingForEvent() {
        String str = new SimpleDateFormat("HH").format(Calendar.getInstance().getTime());
        Intrinsics.checkNotNull(str);
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<java.lang.String, java.lang.String> getNetworkInfo(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r4.getSystemService(r0)
            java.lang.String r1 = "null cannot be cast to non-null type android.net.ConnectivityManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L43
            boolean r1 = r0.isConnected()
            if (r1 == 0) goto L43
            int r1 = r0.getType()
            r2 = 1
            if (r1 != r2) goto L29
            java.lang.String r4 = "Wi-Fi"
            r0 = r4
            goto L47
        L29:
            int r0 = r0.getType()
            if (r0 != 0) goto L43
            java.lang.String r0 = "phone"
            java.lang.Object r4 = r4.getSystemService(r0)
            java.lang.String r0 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4, r0)
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4
            java.lang.String r4 = r4.getNetworkOperatorName()
            java.lang.String r0 = "Mobile"
            goto L47
        L43:
            java.lang.String r4 = "Not Connected"
            java.lang.String r0 = "Unknown"
        L47:
            kotlin.Pair r1 = new kotlin.Pair
            r1.<init>(r4, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnew.android.cleverTap.AnalyticHelper.getNetworkInfo(android.content.Context):kotlin.Pair");
    }

    public final String getVersionName(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            return String.valueOf(activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            return "NA";
        }
    }

    public final int getVersionCode(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            return activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final String getOSVersion() {
        return "OS Version: " + Build.VERSION.RELEASE + " (SDK " + Build.VERSION.SDK_INT + ")";
    }

    public final boolean isFirstLaunch() {
        boolean z = SharedPreference.getInstance().getBoolean(Const.IsFirstLaunch);
        if (!z) {
            SharedPreference.getInstance().putBoolean(Const.IsFirstLaunch, true);
        }
        return !z;
    }

    public final boolean isCleverTapEnable() {
        return (!TextUtils.isEmpty(SharedPreference.getInstance().getString(Const.EnableCleverTap)) && StringsKt.equals(SharedPreference.getInstance().getString(Const.EnableCleverTap), "1", true)) || StringsKt.equals(BuildConfig.FLAVOR, "lab", true);
    }
}
