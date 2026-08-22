package com.tv9news.utils.helpers;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.appnew.android.BuildConfig;
import com.appnew.android.cleverTap.AnalyticHelper;
import com.appnew.android.pojo.Userinfo.Data;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.Constants;
import com.clevertap.android.sdk.network.api.CtApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* JADX INFO: compiled from: AnalyticEvents.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ:\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\f2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0010j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001`\u0011J,\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0010j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001`\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Lcom/tv9news/utils/helpers/AnalyticEvents;", "", "<init>", "()V", "addUpdateCleverTapUser", "", "context", "Landroid/content/Context;", "isUpdate", "", "uninstallTrackingUser", "token", "", "pushEvents", "eventName", JivePropertiesExtension.ELEMENT, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCommonPropertiesForEvents", "app_EDUTERIARelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticEvents {
    public static final int $stable = 0;
    public static final AnalyticEvents INSTANCE = new AnalyticEvents();

    private AnalyticEvents() {
    }

    public final void addUpdateCleverTapUser(Context context, boolean isUpdate) {
        try {
            if (!AnalyticHelper.INSTANCE.isCleverTapEnable()) {
                Log.d("CLEVERTAP_PUSH_EVENT", "CleverTap is disable for this APP");
                return;
            }
            Data userDetails = AnalyticHelper.INSTANCE.getUserDetails();
            if (userDetails != null) {
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(userDetails.getId())) {
                    map.put("Identity", userDetails.getId());
                }
                if (!TextUtils.isEmpty(userDetails.getName())) {
                    map.put(Constants.KEY_ENCRYPTION_NAME, userDetails.getName());
                }
                if (!TextUtils.isEmpty(userDetails.getEmail())) {
                    map.put("Email", userDetails.getEmail());
                }
                if (!TextUtils.isEmpty(userDetails.getGender()) && !TextUtils.isEmpty(AnalyticHelper.INSTANCE.getUserGenderForCleverTap(userDetails.getGender()))) {
                    map.put("Gender", AnalyticHelper.INSTANCE.getUserGenderForCleverTap(userDetails.getGender()));
                }
                if (!TextUtils.isEmpty(userDetails.getDate_of_birth())) {
                    AnalyticHelper analyticHelper = AnalyticHelper.INSTANCE;
                    String date_of_birth = userDetails.getDate_of_birth();
                    Intrinsics.checkNotNullExpressionValue(date_of_birth, "getDate_of_birth(...)");
                    map.put("DOB", analyticHelper.setLongToDateMills(date_of_birth));
                }
                if (!TextUtils.isEmpty(userDetails.getMobile())) {
                    map.put("Phone", "+91" + userDetails.getMobile());
                }
                if (!TextUtils.isEmpty(userDetails.getProfilePicture())) {
                    map.put("Photo", userDetails.getProfilePicture());
                }
                CleverTapAPI defaultInstance = CleverTapAPI.getDefaultInstance(context);
                if (isUpdate) {
                    if (defaultInstance != null) {
                        defaultInstance.pushProfile(map);
                    }
                } else if (defaultInstance != null) {
                    defaultInstance.onUserLogin(map);
                }
                Log.d("CLEVERTAP_PUSH_EVENT", map + " : " + isUpdate);
            }
        } catch (Exception e2) {
            Log.d("CLEVERTAP_PUSH_EVENT", "addUpdateCleverTapUser: " + e2.getMessage());
        }
    }

    public final void uninstallTrackingUser(Context context, String token) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        try {
            if (AnalyticHelper.INSTANCE.isCleverTapEnable()) {
                if (TextUtils.isEmpty(token)) {
                    return;
                }
                CleverTapAPI defaultInstance = CleverTapAPI.getDefaultInstance(context);
                Intrinsics.checkNotNull(defaultInstance);
                defaultInstance.pushFcmRegistrationId(token, true);
                return;
            }
            Log.d("CLEVERTAP_PUSH_EVENT", "CleverTap is disable for this APP");
        } catch (Exception e2) {
            Log.d("CLEVERTAP_PUSH_EVENT", "uninstallTrackingUser: " + e2.getMessage());
        }
    }

    public final void pushEvents(Context context, String eventName, HashMap<String, Object> properties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        try {
            if (AnalyticHelper.INSTANCE.isCleverTapEnable()) {
                HashMap map = new HashMap();
                map.putAll(properties);
                Bundle bundle = new Bundle();
                ArrayList<String> arrayList = new ArrayList();
                Iterator it = map.keySet().iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next());
                }
                for (String str : arrayList) {
                    if (map.get(str) != null && !Intrinsics.areEqual(String.valueOf(map.get(str)), com.amazonaws.services.s3.internal.Constants.NULL_VERSION_ID) && !Intrinsics.areEqual(map.get(str), "")) {
                        if (String.valueOf(map.get(str)).length() > 100) {
                            String strSubstring = String.valueOf(map.get(str)).substring(0, 100);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            bundle.putString(str, strSubstring);
                        } else {
                            bundle.putString(str, String.valueOf(map.get(str)));
                        }
                    } else {
                        bundle.putString(str, "NA");
                        map.put(str, "NA");
                    }
                }
                CleverTapAPI defaultInstance = CleverTapAPI.getDefaultInstance(context);
                if (defaultInstance != null) {
                    defaultInstance.pushEvent(eventName, map);
                }
                Log.d("CLEVERTAP_PUSH_EVENT", eventName + ": " + properties);
                return;
            }
            Log.d("CLEVERTAP_PUSH_EVENT", "CleverTap is disable for this APP");
        } catch (Exception e2) {
            Log.d("CLEVERTAP_PUSH_EVENT", "pushEvents: " + e2.getMessage());
        }
    }

    private final HashMap<String, Object> getCommonPropertiesForEvents(Context context) {
        HashMap<String, Object> map = new HashMap<>();
        HashMap<String, Object> map2 = map;
        map2.put("device_id", AnalyticHelper.INSTANCE.getDeviceId());
        map2.put("app_version", BuildConfig.VERSION_NAME);
        map2.put("platform", CtApi.DEFAULT_QUERY_PARAM_OS);
        map2.put(AnalyticsConstants.APP_THEME, "Light");
        map2.put(AnalyticsConstants.PACKAGE, BuildConfig.APPLICATION_ID);
        map2.put(AnalyticsConstants.APP_MODE, "release");
        map2.put(AnalyticsConstants.TIME_STAMP, AnalyticHelper.INSTANCE.getCurrentTimeStampForEvent());
        map2.put(AnalyticsConstants.DAY_PARTING, AnalyticHelper.INSTANCE.getDayPartingForEvent());
        map2.put(AnalyticsConstants.NETWORK_BRAND_NAME, AnalyticHelper.INSTANCE.getNetworkInfo(context).getFirst());
        map2.put(AnalyticsConstants.NETWORK_TYPE, AnalyticHelper.INSTANCE.getNetworkInfo(context).getSecond());
        return map;
    }
}
